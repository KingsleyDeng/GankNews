package com.zte.ganknews.data.source.repository;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.zte.ganknews.data.ZhihuDailyContent;
import com.zte.ganknews.data.source.datasource.ZhihuDailyContentDataSource;


/**
 * Created by lizhaotailang on 2017/5/26.
 *
 * Concrete implementation to load {@link ZhihuDailyContent} from the data sources into a cache.
 * <p>
 *     Use the remote data source firstly, which is obtained from the server.
 *     If the remote data was not available, then use the local data source,
 *     which was from the locally persisted in database.
 */

public class ZhihuDailyContentRepository implements ZhihuDailyContentDataSource {

    @Nullable
    public static ZhihuDailyContentRepository INSTANCE = null;

    @NonNull
    private final ZhihuDailyContentDataSource mLocalDataSource;

    @NonNull
    private final ZhihuDailyContentDataSource mRemoteDataSource;

    @Nullable
    private ZhihuDailyContent mContent;

    private ZhihuDailyContentRepository(@NonNull ZhihuDailyContentDataSource remoteDataSource,
                                        @NonNull ZhihuDailyContentDataSource localDataSource) {
        mLocalDataSource = localDataSource;
        mRemoteDataSource = remoteDataSource;
    }

    public static ZhihuDailyContentRepository getInstance(@NonNull ZhihuDailyContentDataSource remoteDataSource,
                                                          @NonNull ZhihuDailyContentDataSource localDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new ZhihuDailyContentRepository(remoteDataSource, localDataSource);
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    public void getZhihuDailyContent(int id, @NonNull LoadZhihuDailyContentCallback callback) {
        if (mContent != null) {
            callback.onContentLoaded(mContent);
            return;
        }

        mRemoteDataSource.getZhihuDailyContent(id, new LoadZhihuDailyContentCallback() {
            @Override
            public void onContentLoaded(@NonNull ZhihuDailyContent content) {
                if (mContent == null) {
                    mContent = content;
                    saveContent(content);
                }
                callback.onContentLoaded(content);
            }

            @Override
            public void onDataNotAvailable() {
                mLocalDataSource.getZhihuDailyContent(id, new LoadZhihuDailyContentCallback() {
                    @Override
                    public void onContentLoaded(@NonNull ZhihuDailyContent content) {
                        if (mContent == null) {
                            mContent = content;
                        }
                        callback.onContentLoaded(content);
                    }

                    @Override
                    public void onDataNotAvailable() {
                        callback.onDataNotAvailable();
                    }
                });
            }
        });
    }

    @Override
    public void saveContent(@NonNull ZhihuDailyContent content) {
        // Note: Setting of timestamp was done in the {@link ZhihuDailyContentLocalDataSource} class.
        mLocalDataSource.saveContent(content);
        mRemoteDataSource.saveContent(content);
    }
}
