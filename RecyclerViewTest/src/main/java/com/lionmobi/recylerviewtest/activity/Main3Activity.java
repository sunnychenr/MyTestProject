package com.lionmobi.recylerviewtest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.lionmobi.recylerviewtest.R;


public class Main3Activity extends Activity {

    private TextView tv1, tv2, tv3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
    }
}
