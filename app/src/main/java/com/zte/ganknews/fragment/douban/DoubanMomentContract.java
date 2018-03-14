package com.zte.ganknews.fragment.douban;

import android.support.annotation.NonNull;

import com.zte.ganknews.BasePresenter;
import com.zte.ganknews.BaseView;
import com.zte.ganknews.data.DoubanMomentNewsPosts;

import java.util.List;

/**
 * Created by Stephen on 2018/2/28.
 */

public interface DoubanMomentContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        boolean isActive();

        void showResult(@NonNull List<DoubanMomentNewsPosts> list);
    }

    interface Presenter extends BasePresenter {

        void load(boolean forceUpdate, boolean clearCache, long date);

    }

}



