package com.zte.ganknews;

import android.view.View;

/**
 * Created by Stephen on 2018/2/28.
 */

public interface BaseView<T> {

    void setPresenter(T presenter);

    void initViews(View view);

}
