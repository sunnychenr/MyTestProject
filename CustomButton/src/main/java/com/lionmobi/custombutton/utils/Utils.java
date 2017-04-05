package com.lionmobi.custombutton.utils;

import android.content.Context;
import android.os.Debug;
import android.util.Log;
import android.widget.Toast;

import com.lionmobi.custombutton.BuildConfig;

/**
 * Created by ChenR on 2017/3/30.
 */

public class Utils {

    private static final String TAG = "chenr";

    public static void showToast (Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

    public static void logD(String log) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, log);
        }
    }
}
