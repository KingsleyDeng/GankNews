package com.zte.ganknews.data.source.remote;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.zte.ganknews.data.ZhihuDailyNews;
import com.zte.ganknews.data.ZhihuDailyNewsQuestion;
import com.zte.ganknews.data.source.datasource.ZhihuDailyNewsDataSource;
import com.zte.ganknews.retrofit.RetrofitService;
import com.zte.ganknews.util.DateFormatUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lizhaotailang on 2017/5/21.
 * <p>
 * Implementation of the {@link ZhihuDailyNews} data source that accesses network.
 */

public class ZhihuDailyNewsRemoteDataSource implements ZhihuDailyNewsDataSource {

    @Nullable
    private static ZhihuDailyNewsRemoteDataSource INSTANCE = null;

    // Prevent direct instantiation.
    private ZhihuDailyNewsRemoteDataSource() {
    }

    public static ZhihuDailyNewsRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ZhihuDailyNewsRemoteDataSource();
        }
        return INSTANCE;
    }

    // The parameter forceUpdate and addToCache are ignored.
    @Override
    public void getZhihuDailyNews(boolean forceUpdate, boolean clearCache, long date, @NonNull ZhihuDailyNewsDataSource.LoadZhihuDailyNewsCallback callback) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitService.ZHIHU_DAILY_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitService.ZhihuDailyService service = retrofit.create(RetrofitService.ZhihuDailyService.class);

        service.getZhihuList(DateFormatUtil.formatZhihuDailyDateLongToString(date))
                .enqueue(new Callback<ZhihuDailyNews>() {
                    @Override
                    public void onResponse(Call<ZhihuDailyNews> call, Response<ZhihuDailyNews> response) {

                        // Note: Only the timestamp of zhihu daily was set in remote source.
                        // The other two was set in repository due to structure of returning json.
                        long timestamp = DateFormatUtil.formatZhihuDailyDateStringToLong(response.body().getDate());

                        Log.d("TAG", "onResponse: timestamp " + timestamp);

                        for (ZhihuDailyNewsQuestion item : response.body().getStories()) {
                            item.setTimestamp(timestamp);
                        }
                        callback.onNewsLoaded(response.body().getStories());
                    }

                    @Override
                    public void onFailure(Call<ZhihuDailyNews> call, Throwable t) {
                        callback.onDataNotAvailable();
                    }
                });

    }

    @Override
    public void getFavorites(@NonNull LoadZhihuDailyNewsCallback callback) {
        // Not required for the remote data source because the {@link TasksRepository} handles
        // converting from a {@code taskId} to a {@link task} using its cached data.
    }

    @Override
    public void getItem(int itemId, @NonNull GetNewsItemCallback callback) {
        // Not required for the remote data source because the {@link TasksRepository} handles
        // converting from a {@code taskId} to a {@link task} using its cached data.
    }

    @Override
    public void favoriteItem(int itemId, boolean favorite) {
        // Not required for the remote data source because the {@link TasksRepository} handles
        // converting from a {@code taskId} to a {@link task} using its cached data.
    }

    @Override
    public void saveAll(@NonNull List<ZhihuDailyNewsQuestion> list) {
        // Not required for the remote data source because the {@link TasksRepository} handles
        // converting from a {@code taskId} to a {@link task} using its cached data.
    }

}