package com.zte.ganknews.data.source.datasource;

import android.support.annotation.NonNull;

import com.zte.ganknews.data.ZhihuDailyNewsQuestion;

import java.util.List;


/**
 * Created by lizhaotailang on 2017/5/21.
 *
 * Main entry point for accessing the {@link ZhihuDailyNewsQuestion}s data.
 */

public interface ZhihuDailyNewsDataSource {

    interface LoadZhihuDailyNewsCallback {

        void onNewsLoaded(@NonNull List<ZhihuDailyNewsQuestion> list);

        void onDataNotAvailable();

    }

    interface GetNewsItemCallback {

        void onItemLoaded(@NonNull ZhihuDailyNewsQuestion item);

        void onDataNotAvailable();

    }

    void getZhihuDailyNews(boolean forceUpdate, boolean clearCache, long date, @NonNull LoadZhihuDailyNewsCallback callback);

    void getFavorites(@NonNull LoadZhihuDailyNewsCallback callback);

    void getItem(int itemId, @NonNull GetNewsItemCallback callback);

    void favoriteItem(int itemId, boolean favorite);

    void saveAll(@NonNull List<ZhihuDailyNewsQuestion> list);

}
