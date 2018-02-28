package com.zte.ganknews.fragment.zhihu;

import android.support.annotation.NonNull;

public class ZhihuDailyPresenter implements ZhihuDailyContract.Presenter {

    @NonNull
    private final ZhihuDailyContract.View mView;

    public ZhihuDailyPresenter(@NonNull ZhihuDailyContract.View view
                               ) {
        this.mView = view;

    }

    @Override
    public void start() {

    }

    @Override
    public void loadNews(boolean forceUpdate, boolean clearCache, long date) {

    }

}