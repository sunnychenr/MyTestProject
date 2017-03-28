package com.lionmobi.recylerviewtest.utils;

import android.util.Log;

import com.lionmobi.recylerviewtest.BuildConfig;

/**
 * Created by ChenR on 2017/2/6.
 */

public class LogUtil {

    private static final String TAG = "chenr";

    public static void d (String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, msg);
        }
    }
}
