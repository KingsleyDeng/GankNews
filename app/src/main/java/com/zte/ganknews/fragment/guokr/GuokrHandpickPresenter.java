package com.zte.ganknews.fragment.guokr;

import android.support.annotation.NonNull;

public class GuokrHandpickPresenter implements GuokrHandpickContract.Presenter {

    @NonNull
    private final GuokrHandpickContract.View mView;


    public GuokrHandpickPresenter( @NonNull GuokrHandpickContract.View mView) {

        this.mView = mView;
    }

    @Override
    public void load(boolean forceUpdate, boolean clearCache, int offset, int limit) {

    }

    @Override
    public void start() {

    }
}
