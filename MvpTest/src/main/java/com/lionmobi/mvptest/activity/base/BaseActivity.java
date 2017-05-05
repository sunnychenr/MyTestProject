package com.lionmobi.mvptest.activity.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;

import com.lionmobi.mvptest.mode_interface.IView;

import butterknife.ButterKnife;

/**
 * Created by ChenR on 2017/5/5.
 */

public abstract class BaseActivity extends Activity implements IView, View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

}
