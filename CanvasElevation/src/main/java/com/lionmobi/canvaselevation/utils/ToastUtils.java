package com.lionmobi.canvaselevation.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by ChenR on 2017/4/10.
 */

public class ToastUtils {
    public static void showToast (Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
