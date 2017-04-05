package com.lionmobi.mvptest.model;

import com.lionmobi.mvptest.mode_interface.IModel;

/**
 * Created by ChenR on 2017/4/5.
 */

public class ModelImpl implements IModel {
    @Override
    public void getData(ICallBack callBack) {
        callBack.onCall("我还是搞不懂mvp");
    }
}
