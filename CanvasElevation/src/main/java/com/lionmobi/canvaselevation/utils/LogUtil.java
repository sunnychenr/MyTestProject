package com.lionmobi.canvaselevation.utils;

import android.util.Log;

import com.lionmobi.canvaselevation.BuildConfig;

/**
 * Created by ChenR on 2017/4/10.
 */

public class LogUtil {
    private static final String TAG = "chenr";

    public static void logD (String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, msg);
        }
    }
}
