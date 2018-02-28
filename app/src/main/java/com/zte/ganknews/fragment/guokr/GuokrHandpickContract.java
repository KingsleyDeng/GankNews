package com.zte.ganknews.fragment.guokr;

import com.zte.ganknews.BasePresenter;
import com.zte.ganknews.BaseView;

public interface GuokrHandpickContract {

    interface View extends BaseView<Presenter> {

        boolean isActive();

        void setLoadingIndicator(boolean active);

        void showResult();

    }

    interface Presenter extends BasePresenter {

        void load(boolean forceUpdate, boolean clearCache, int offset, int limit);

    }

}
