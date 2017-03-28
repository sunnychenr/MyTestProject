package com.lionmobi.recylerviewtest;

import android.app.Application;
import android.content.Context;

/**
 * Created by ChenR on 2017/2/6.
 */

public class BaseApplication extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
}
