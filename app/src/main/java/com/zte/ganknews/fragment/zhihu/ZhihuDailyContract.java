package com.zte.ganknews.fragment.zhihu;

import android.support.annotation.NonNull;

import com.zte.ganknews.BasePresenter;
import com.zte.ganknews.BaseView;

public interface ZhihuDailyContract {

    interface View extends BaseView<Presenter> {

        boolean isActive();

        void setLoadingIndicator(boolean active);

        void showResult();

    }

    interface Presenter extends BasePresenter {

        void loadNews(boolean forceUpdate, boolean clearCache, long date);

    }

}
