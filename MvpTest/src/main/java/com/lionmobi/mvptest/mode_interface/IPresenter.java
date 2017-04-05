package com.lionmobi.mvptest.mode_interface;

import android.view.View;

/**
 * Created by ChenR on 2017/1/25.
 *
 * MVP 中间层接口;
 */

public interface IPresenter{
    public void onCreate();
    public void onDestory();
    public void onElementsClick(int viewId);
}
