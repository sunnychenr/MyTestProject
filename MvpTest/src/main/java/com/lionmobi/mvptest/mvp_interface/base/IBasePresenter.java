package com.lionmobi.mvptest.mvp_interface.base;

import android.view.MotionEvent;
import android.view.View;

/**
 * Created by ChenR on 2017/5/5.
 */

public interface IBasePresenter {
    void onElementsClick(View v);
    void attachView(IBaseView view);
    void detachView(IBaseView view);
    boolean onElementsTouch(View v, MotionEvent event);
}
