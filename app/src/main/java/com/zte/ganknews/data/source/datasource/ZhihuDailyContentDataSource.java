package com.zte.ganknews.data.source.datasource;

import android.support.annotation.NonNull;

import com.zte.ganknews.data.ZhihuDailyContent;


/**
 * Created by lizhaotailang on 2017/5/25.
 *
 * Main entry point for accessing the {@link ZhihuDailyContent} data.
 */

public interface ZhihuDailyContentDataSource {

    interface LoadZhihuDailyContentCallback {

        void onContentLoaded(@NonNull ZhihuDailyContent content);

        void onDataNotAvailable();

    }

    void getZhihuDailyContent(int id, @NonNull LoadZhihuDailyContentCallback callback);

    void saveContent(@NonNull ZhihuDailyContent content);

}
