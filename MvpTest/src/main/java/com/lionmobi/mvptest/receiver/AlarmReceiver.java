package com.lionmobi.mvptest.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.lionmobi.mvptest.utils.MessageNotifyUtil;

/**
 * Created by ChenR on 2017/2/24.
 */

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        MessageNotifyUtil.logD("action ---> " + intent.getAction());
        MessageNotifyUtil.toast("有一个闹钟");
    }
}
