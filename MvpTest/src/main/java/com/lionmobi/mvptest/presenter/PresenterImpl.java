package com.lionmobi.mvptest.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.lionmobi.mvptest.R;
import com.lionmobi.mvptest.activity.MainActivity;
import com.lionmobi.mvptest.mode_interface.IModel;
import com.lionmobi.mvptest.mode_interface.IPresenter;
import com.lionmobi.mvptest.mode_interface.IView;
import com.lionmobi.mvptest.model.ModelImpl;

/**
 * Created by ChenR on 2017/4/5.
 */

public class PresenterImpl implements IPresenter{
    private Handler mHandler;
    private Context mContext;

    private IView mIView;
    private IModel mIModel;

    public PresenterImpl (MainActivity act, Handler handler) {
        this.mHandler = handler;
        this.mContext = act;
        this.mIView = act;
    }

    @Override
    public void onCreate() {
        mIModel = new ModelImpl();
    }

    @Override
    public void onDestory() {

    }

    @Override
    public void onElementsClick(int viewId) {
        if (viewId == R.id.btn) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    mIModel.getData(new IModel.ICallBack() {
                        @Override
                        public void onCall(String data) {
                            mIView.setElemetsData(data);

                            Message msg = mHandler.obtainMessage(1);
                            msg.obj = data + ", handler send msg";
                            mHandler.sendMessage(msg);
                        }
                    });
                }
            }).start();
        }
    }
}
