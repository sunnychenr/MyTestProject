package com.lionmobi.callringfloatwindow;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;

/**
 * Created by ChenR on 2017/4/17.
 */

public class LocalService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();

        PhoneStateReceiver mReceiver = new PhoneStateReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(TelephonyManager.ACTION_PHONE_STATE_CHANGED);
        this.registerReceiver(mReceiver, filter);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
