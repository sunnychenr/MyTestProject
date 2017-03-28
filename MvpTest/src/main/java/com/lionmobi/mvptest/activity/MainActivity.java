package com.lionmobi.mvptest.activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.lionmobi.mvptest.R;

public class MainActivity extends AppCompatActivity {

    long time;
    boolean b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent("com.android.intent.action.AlarmReceiver");
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
        });

    }
}
