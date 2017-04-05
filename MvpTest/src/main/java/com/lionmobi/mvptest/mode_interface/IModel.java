package com.lionmobi.mvptest.mode_interface;

/**
 * Created by ChenR on 2017/4/5.
 */

public interface IModel {
    public void getData(ICallBack callBack);

    public interface ICallBack {
        public void onCall (String data);
    }
}
