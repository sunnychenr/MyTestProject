package com.lionmobi.mvptest.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.lionmobi.mvptest.R;
import com.lionmobi.mvptest.activity.base.BaseActivity;
import com.lionmobi.mvptest.mode_interface.IPresenter;
import com.lionmobi.mvptest.presenter.PresenterImpl;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ChenR on 2017/5/5.
 */

public class SecendActivity extends BaseActivity {

    private IPresenter mIPresenter;
    private TextView tv;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        mIPresenter = new PresenterImpl(this, this, mHandler);
        mIPresenter.onCreate();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_secend;
    }

    @Override
    protected void initView() {
        tv = (TextView) findViewById(R.id.tv);
    }

    @Override
    public void onClick(View v) {
        mIPresenter.onElementsClick(v.getId());
    }

    @Override
    public void setElemetsData(String content) {

    }
}
