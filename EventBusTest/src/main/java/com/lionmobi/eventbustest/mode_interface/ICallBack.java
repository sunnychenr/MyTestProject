package com.lionmobi.eventbustest.mode_interface;

import android.graphics.Bitmap;

/**
 * Created by ChenR on 2017/4/6.
 */

public interface ICallBack {
    public void onCall (String msg);
    public void onCall (Bitmap bmp);
    public void onCall (int num);
    public void onCall (long num);
    public void onCall (double num);
    public void onCall (float num);
    public void onCall (boolean num);
    public void onCall (Object obj);
    // ... ...; 还有各种, 写不完了;
}
