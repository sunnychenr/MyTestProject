package com.lionmobi.fonticonview;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by ChenR on 2017/2/5.
 */

public class BaseApplication extends Application {

    public static Context mContext;
    private static BaseApplication instance;

    private Typeface iconFace;

    public static synchronized BaseApplication getInstance () {
        return instance;
    }

    public synchronized Typeface getIconFace () {
        return iconFace;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mContext = getApplicationContext();
        iconFace = Typeface.createFromAsset(getAssets(), "icomoon.ttf");
    }
}
