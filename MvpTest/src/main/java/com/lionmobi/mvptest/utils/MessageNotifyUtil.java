package com.lionmobi.mvptest.utils;

import android.util.Log;
import android.widget.Toast;

import com.lionmobi.mvptest.application.ApplicationEx;
import com.lionmobi.mvptest.BuildConfig;

/**
 * Created by ChenR on 2017/1/24.
 */

public class MessageNotifyUtil {

    private static final String TAG = "chenr";

    public static void log (String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, msg);
        }
    }

    public static void toast (String msg) {
        Toast.makeText(ApplicationEx.mAppContext, msg, Toast.LENGTH_SHORT).show();
    }

}
