package com.lionmobi.mvptest.mvp_interface;

/**
 * Created by ChenR on 2017/4/5.
 *
 * mvp 数据接口;
 */

public interface IModel {
    public void getData(ICallBack callBack);

    public interface ICallBack {
        public void onCall (String data);
    }
}
