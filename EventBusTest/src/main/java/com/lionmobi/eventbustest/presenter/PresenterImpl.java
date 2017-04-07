package com.lionmobi.eventbustest.presenter;

import android.content.Context;
import android.util.Log;

import com.lionmobi.eventbustest.R;
import com.lionmobi.eventbustest.eventbus.message.EventBusData;
import com.lionmobi.eventbustest.mode_interface.IModel;
import com.lionmobi.eventbustest.mode_interface.IPresenter;
import com.lionmobi.eventbustest.mode_interface.IView;
import com.lionmobi.eventbustest.model.CallBackAdapter;
import com.lionmobi.eventbustest.model.ModelImpl;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by ChenR on 2017/4/7.
 */

public class PresenterImpl implements IPresenter {
    private Context mContext;
    private IView mIView;
    private IModel mIModel;

    public PresenterImpl(Context context, IView iView) {
        this.mContext = context;

        this.mIView = iView;
        mIModel = new ModelImpl();
    }

    @Override
    public void onCreate() {
        Log.d("chenr", "没有操作嚯... ...");
    }

    @Override
    public void onDestory() {
        Log.d("chenr", "还是没有操作嚯... ...");
    }

    @Override
    public void onItemClick(int viewId) {
        switch (viewId) {
            case R.id.btn:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mIModel.getData(new CallBackAdapter() {
                            @Override
                            public void onCall(String msg) {
                                mIView.setElementData(msg);

                                EventBusData data = new EventBusData();
                                data.setData(msg);
                                EventBus.getDefault().post(data);
                            }
                        });
                    }
                }).start();
                break;
            default:
                Log.d("chenr", "也是没有操作的嚯... ...");
                break;
        }
    }
}
