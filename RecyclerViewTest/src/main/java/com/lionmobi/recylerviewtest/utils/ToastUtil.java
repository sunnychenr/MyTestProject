package com.lionmobi.recylerviewtest.utils;

import android.widget.Toast;

import com.lionmobi.recylerviewtest.BaseApplication;

/**
 * Created by ChenR on 2017/2/6.
 */

public class ToastUtil {

    public static void showString (String toast) {
        Toast.makeText(BaseApplication.mContext, toast, Toast.LENGTH_SHORT).show();
    }

}
