package com.zte.ganknews.data.source.datasource;

import android.support.annotation.NonNull;

import com.zte.ganknews.data.GuokrHandpickNewsResult;

import java.util.List;


/**
 * Created by lizhaotailang on 2017/5/24.
 *
 * Main entry point for accessing the {@link GuokrHandpickNewsResult}s data.
 */

public interface GuokrHandpickDataSource {

    interface LoadGuokrHandpickNewsCallback {

        void onNewsLoad(@NonNull List<GuokrHandpickNewsResult> list);

        void onDataNotAvailable();

    }

    interface GetNewsItemCallback {

        void onItemLoaded(@NonNull GuokrHandpickNewsResult item);

        void onDataNotAvailable();

    }

    void getGuokrHandpickNews(boolean forceUpdate, boolean clearCache, int offset, int limit, @NonNull LoadGuokrHandpickNewsCallback callback);

    void getFavorites(@NonNull LoadGuokrHandpickNewsCallback callback);

    void getItem(int itemId, @NonNull GetNewsItemCallback callback);

    void favoriteItem(int itemId, boolean favorite);

    void saveAll(@NonNull List<GuokrHandpickNewsResult> list);

}
