package com.lionmobi.eventbustest.mode_interface;

/**
 * Created by ChenR on 2017/4/6.
 */

public interface IPresenter {
    public void onCreate();
    public void onStart();
    public void onRestart();
    public void onResume();
    public void onStop();
    public void onPause();
    public void onDestory();
    public void onItemClick(int viewId);
}
