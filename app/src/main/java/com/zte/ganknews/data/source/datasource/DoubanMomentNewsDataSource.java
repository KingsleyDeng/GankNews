package com.zte.ganknews.data.source.datasource;

import android.support.annotation.NonNull;

import com.zte.ganknews.data.DoubanMomentNewsPosts;

import java.util.List;


/**
 * Created by lizhaotailang on 2017/5/21.
 * <p>
 * Main entry point for accessing {@link DoubanMomentNewsPosts}s data.
 */

public interface DoubanMomentNewsDataSource {

    interface LoadDoubanMomentDailyCallback {

        void onNewsLoaded(@NonNull List<DoubanMomentNewsPosts> list);

        void onDataNotAvailable();

    }

    interface GetNewsItemCallback {

        void onItemLoaded(@NonNull DoubanMomentNewsPosts item);

        void onDataNotAvailable();

    }

    void getDoubanMomentNews(boolean forceUpdate, boolean clearCache, long date, @NonNull LoadDoubanMomentDailyCallback callback);

    void getFavorites(@NonNull LoadDoubanMomentDailyCallback callback);

    void getItem(int id, @NonNull GetNewsItemCallback callback);

    void favoriteItem(int itemId, boolean favorite);

    void saveAll(@NonNull List<DoubanMomentNewsPosts> list);

}
