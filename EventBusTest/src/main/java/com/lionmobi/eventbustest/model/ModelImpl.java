package com.lionmobi.eventbustest.model;

import com.lionmobi.eventbustest.mode_interface.ICallBack;
import com.lionmobi.eventbustest.mode_interface.IModel;

/**
 * Created by ChenR on 2017/4/7.
 */

public class ModelImpl implements IModel {
    @Override
    public void getData(ICallBack callback) {
        // 在这里做各种数据的操作; 网络、读取本地数据、耗时操作；
        callback.onCall("wait! wait! wait!");
    }
}
