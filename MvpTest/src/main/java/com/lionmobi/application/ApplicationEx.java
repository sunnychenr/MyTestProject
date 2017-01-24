package com.lionmobi.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by ChenR on 2017/1/24.
 */

public class ApplicationEx extends Application {

    public static Context mAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = getApplicationContext();
    }
}
