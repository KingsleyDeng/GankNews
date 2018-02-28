package com.zte.ganknews.fragment.douban;

import android.support.annotation.NonNull;

import com.zte.ganknews.BasePresenter;
import com.zte.ganknews.BaseView;

/**
 * Created by Stephen on 2018/2/28.
 */

public interface DoubanMomentContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        boolean isActive();

        void showResult();
    }

    interface Presenter extends BasePresenter {

        void load(boolean forceUpdate, boolean clearCache, long date);

    }

}



