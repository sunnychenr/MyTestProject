package com.lionmobi.observermode.mode_observer.mode_impl;

import java.util.Observable;

/**
 * Created by ChenR on 2017/4/7.
 */

public class ObservableImpl extends Observable {
    private String strData = "";

    public void setData (String data) {
        if (!strData.equals(data)) {
            strData = data;
            setChanged();
            notifyObservers();
        }
    }

    public String getStrData() {
        return strData;
    }
}
