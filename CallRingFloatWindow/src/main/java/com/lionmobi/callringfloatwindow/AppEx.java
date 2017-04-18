package com.lionmobi.callringfloatwindow;

import android.app.Application;

/**
 * Created by ChenR on 2017/4/17.
 */

public class AppEx extends Application {
    public static AppEx instance;

    public static AppEx getInstance () {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
