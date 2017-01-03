package com.lionmobi.utils;

import android.util.Log;

/**
 * Created by ChenR on 2017/1/3.
 */

public class LogUtil {

    private static final String TAG = "chenr";

    private static boolean isOutput = true;

    public static void d (String log) {
        if (isOutput) {
            Log.d(TAG, log);
        }
    }

}
