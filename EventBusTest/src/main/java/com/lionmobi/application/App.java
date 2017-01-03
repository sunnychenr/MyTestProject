package com.lionmobi.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by ChenR on 2017/1/3.
 */

public class App extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
    }
}
