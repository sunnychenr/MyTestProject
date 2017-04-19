package com.lionmobi.callringfloatwindow;

import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by ChenR on 2017/4/17.
 */

public class CallRingFloatWindow extends LinearLayout {
    private Context mContext;
    private String msg;
    private AppEx mAppEx;

    private WindowManager mWindowManager;
    private WindowManager.LayoutParams mParams;
    private View root;
    private TextView tv;

    private int screenWidth;
    private int screenHeight;
    private int viewWidth;
    private int viewHeight;

    private boolean isAddView = false;

    public CallRingFloatWindow(Context context) {
        this(context, null);
    }

    public CallRingFloatWindow(Context context, String msg) {
        super(context);
        this.mContext = context;
        this.msg = msg;
        mAppEx = AppEx.getInstance();

        DisplayMetrics metrics = mAppEx.getResources().getDisplayMetrics();
        screenHeight = metrics.heightPixels;
        screenWidth = metrics.widthPixels;
        viewWidth = (int) (metrics.widthPixels - metrics.density * 28);
        viewHeight = (int) (metrics.density * 80);

        init();
    }

    private void init() {
        initWindManager();
        initLayoutParams();
        initView();
        initData();
    }

    private void initData() {
        if (!TextUtils.isEmpty(msg)) {
            tv.setText(msg);
        }
    }

    private void initView() {
        LayoutInflater mInflater = (LayoutInflater) mAppEx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        root = mInflater.inflate(R.layout.call_ring_float_window, this);
        tv = (TextView) root.findViewById(R.id.tv);
    }

    private void initLayoutParams() {
        WindowManager.LayoutParams layoutParams= new WindowManager.LayoutParams();
        layoutParams.format = PixelFormat.RGBA_8888;
        layoutParams.flags = WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;

        if (Build.VERSION.SDK_INT >= 19) {
            layoutParams.type =  WindowManager.LayoutParams.TYPE_TOAST; // 2005
        } else {
            layoutParams.type = WindowManager.LayoutParams.TYPE_PHONE; // 2002
        }

        if (Build.VERSION.SDK_INT < 23) {
            layoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        } else if (Settings.canDrawOverlays(mAppEx)) {
            layoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        }

        layoutParams.gravity = Gravity.LEFT | Gravity.TOP;
        layoutParams.y = screenHeight / 2 - viewHeight / 2;
        layoutParams.x = screenWidth / 2 - viewWidth / 2;
        layoutParams.height = viewHeight;
        layoutParams.width = viewWidth;
        layoutParams.format = PixelFormat.RGBA_8888; // 设置窗口背景透明;

        mParams = layoutParams;
    }

    private void initWindManager() {
        mWindowManager = (WindowManager) mAppEx.getSystemService(Context.WINDOW_SERVICE);
    }

    public void setMsg(String msg) {
        tv.setText(msg);
    }

    public void showWindow () {
        if (!isAddView) {
//            postDelayed(new Runnable() {
//                @Override
//                public void run() {
                    isAddView = true;
                    mWindowManager.addView(root, mParams);
//                }
//            }, 1000);
        }
    }

    public void dismissWindow () {
        if (isAddView) {
            isAddView = false;
            mWindowManager.removeView(root);
        }
    }

    private void updateWindow () {
        if (isAddView) {
            mParams.x = (int) (xInScreen - xInView);
            mParams.y = (int) (yInScreen - yInView);
            mWindowManager.updateViewLayout(root, mParams);
        }
    }

    private float xInScreen;
    private float yInScreen;
    private float xInView;
    private float yInView;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xInView = event.getX();
                yInView = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                xInScreen = event.getRawX();
                yInScreen = event.getRawY() - getStatusBarHeight();
                updateWindow();
                break;
        }
        return true;
    }

    public int getStatusBarHeight() {
        /**
         * 获取状态栏高度——方法1
         * */
        int statusBarHeight = -1;
        //获取status_bar_height资源的ID
        int resourceId = mAppEx.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            statusBarHeight = mAppEx.getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }
}
