package com.lionmobi.mvptest.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lionmobi.mvptest.R;
import com.lionmobi.mvptest.mode_interface.IPresenter;
import com.lionmobi.mvptest.mode_interface.IView;
import com.lionmobi.mvptest.presenter.PresenterImpl;

/**
 *
 * mvp 视图实现;(IView)
 *
 * */

public class MainActivity extends AppCompatActivity implements IView {
    private IPresenter mIPresenter;
    private TextView tv_1;
    private TextView tv_2;
    private Button btn;

    /*long time;
    boolean b;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();

        /*Intent intent = new Intent("com.android.intent.action.AlarmReceiver");
        final PendingIntent pi = PendingIntent.getBroadcast(this, 22, intent, PendingIntent.FLAG_ONE_SHOT);
        final AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b) {
                    am.cancel(pi);
                    Toast.makeText(MainActivity.this, "取消闹钟", Toast.LENGTH_SHORT).show();
                    b = !b;
                } else {
                    time = System.currentTimeMillis() + 10 * 1000;
                    am.set(AlarmManager.RTC, time, pi);
                    Toast.makeText(MainActivity.this, "注册闹钟", Toast.LENGTH_SHORT).show();
                    b = !b;
                }
            }
        });*/

        mIPresenter = new PresenterImpl(MainActivity.this, MainActivity.this, mHandler);
        mIPresenter.onCreate();
    }

    private void initListener() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIPresenter != null) {
                    mIPresenter.onElementsClick(v.getId());
                }
            }
        });
    }

    private void initView() {
        tv_1 = (TextView) findViewById(R.id.tv_1);
        tv_2 = (TextView) findViewById(R.id.tv_2);
        btn = (Button) findViewById(R.id.btn);
    }

    @Override
    public void setElemetsData(final String content) {
        tv_1.post(new Runnable() {
            @Override
            public void run() {
                tv_1.setText(content);
            }
        });
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                String str = msg.obj.toString();
                tv_2.setText(str);
            }
        }
    };
}
