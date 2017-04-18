package com.lionmobi.callringfloatwindow;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by ChenR on 2017/4/17.
 */

public class PhoneStateReceiver extends BroadcastReceiver {

    private Context mContext;
    private TelephonyManager mTele;
    private CallRingFloatWindow mWindow;
    private int lastState;

    @Override
    public void onReceive(Context context, Intent intent) {
        this.mContext = context;
        mTele = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        //mTele.listen(mListener, PhoneStateListener.LISTEN_CALL_STATE);

        int curState = -1;
        if (intent.getAction().equals(TelephonyManager.ACTION_PHONE_STATE_CHANGED)) {
            curState = mTele.getCallState();
            Log.d("chenr", "Call State: " + curState);
            if (TelephonyManager.CALL_STATE_RINGING == curState) {
                if (mWindow == null) {
                    mWindow = new CallRingFloatWindow(context);
                }
                mWindow.setMsg("you a new Call");
                mWindow.showWindow();
            }
        }

        if (lastState == TelephonyManager.CALL_STATE_RINGING && curState == TelephonyManager.CALL_STATE_IDLE && mWindow != null) {
            //mWindow.dismissWindow();
        }
        lastState = curState;
    }

    private PhoneStateListener mListener = new PhoneStateListener() {
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            Log.d("chenr", "call state: " + state);
//            if (TelephonyManager.CALL_STATE_RINGING == state) {
                mWindow = new CallRingFloatWindow(mContext);
                mWindow.setMsg("you have a new Call");
                mWindow.showWindow();
//            }

            /*if (lastState == TelephonyManager.CALL_STATE_RINGING && state == TelephonyManager.CALL_STATE_IDLE && mWindow != null) {
                mWindow.dismissWindow();
            }*/
            lastState = state;
        }
    };
}
