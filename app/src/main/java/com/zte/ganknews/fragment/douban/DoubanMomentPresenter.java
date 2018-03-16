package com.zte.ganknews.fragment.douban;

import android.support.annotation.NonNull;

/**
 * Created by Stephen on 2018/2/28.
 */

public class DoubanMomentPresenter implements DoubanMomentContract.Presenter {

    @NonNull
    private final DoubanMomentContract.View mView;


    public DoubanMomentPresenter(@NonNull DoubanMomentContract.View mView) {

        this.mView = mView;
    }

    @Override
    public void start() {

    }

    @Override
    public void load(boolean forceUpdate, boolean clearCache, long date) {

    }
}
