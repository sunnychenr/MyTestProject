package com.lionmobi.eventbustest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lionmobi.eventbustest.R;
import com.lionmobi.eventbustest.eventbus.message.EventBusData;
import com.lionmobi.eventbustest.mode_interface.IView;
import com.lionmobi.eventbustest.presenter.PresenterImpl;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity implements IView{

    TextView tv1;
    TextView tv2;

    private PresenterImpl mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new PresenterImpl(this, this);
        mPresenter.onCreate();

        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onItemClick(R.id.btn);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestory();

        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onDataChange (EventBusData data) {
        tv2.setText("onDataChange: " + data.getData());
    }

    // 运行在其他线程中;
    @Override
    public void setElementData(final String msg) {
        tv1.post(new Runnable() {
            @Override
            public void run() {
                tv1.setText("setElementData: " + msg);
            }
        });
    }
}
