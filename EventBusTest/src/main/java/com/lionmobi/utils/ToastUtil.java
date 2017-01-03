package com.lionmobi.utils;

import android.widget.Toast;

import com.lionmobi.application.App;

/**
 * Created by ChenR on 2017/1/3.
 */

public class ToastUtil {

    public static void t (String toast) {
        Toast.makeText(App.context, toast, Toast.LENGTH_SHORT).show();
    }

}
