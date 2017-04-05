package com.lionmobi.mvptest.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.lionmobi.mvptest.R;
import com.lionmobi.mvptest.mode_interface.IModel;
import com.lionmobi.mvptest.mode_interface.IPresenter;
import com.lionmobi.mvptest.mode_interface.IView;
import com.lionmobi.mvptest.model.ModelImpl;
import com.lionmobi.mvptest.utils.MessageNotifyUtil;

/**
 * Created by ChenR on 2017/4/5.
 *
 * mvp 中间层实现;(IPresenter)
 */

public class PresenterImpl implements IPresenter{
    private Handler mHandler;
    private Context mContext;

    private IView mIView;
    private IModel mIModel;

    private Thread loadData;

    public PresenterImpl (Context context, IView iView, Handler handler) {
        this.mHandler = handler;
        this.mContext = context;
        this.mIView = iView;
    }

    @Override
    public void onCreate() {
        mIModel = new ModelImpl();
    }

    @Override
    public void onDestory() {
        mHandler = null;
        mContext = null;
        mIModel = null;
        mIView = null;
    }

    @Override
    public void onElementsClick(int viewId) {
        if (viewId == R.id.btn) {
            if (loadData == null || !loadData.isAlive()) {
                loadData = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            Thread.currentThread().sleep(2000);
                        } catch (Exception e) {
                            MessageNotifyUtil.logE("PresenterImpl IModel getData exception: " + e.getMessage());
                        }

                        mIModel.getData(new IModel.ICallBack() {
                            @Override
                            public void onCall(String data) {
                                mIView.setElemetsData(data);

                                Message msg = mHandler.obtainMessage(1);
                                msg.obj = data + ", handler send msg";
                                mHandler.sendMessageDelayed(msg, 1000);
                            }
                        });
                    }
                });
                loadData.start();
            }
        }
    }
}
