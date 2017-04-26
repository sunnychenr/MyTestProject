package com.lionmobi.calllogcursortest;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.lv)
    ListView lv;
    @BindView(R.id.rv)
    RecyclerView rv;

    private MyCursorAdapter mAdapter;
    private MyRecyclerAdapter adapter;

    private Cursor mCallLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btn)
    public void onViewClicked() {
        Toast.makeText(this, "start query call log", Toast.LENGTH_SHORT).show();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        long start = System.currentTimeMillis();
        mCallLog = getContentResolver().query(CallLog.Calls.CONTENT_URI,
                new String[]{
                        CallLog.Calls._ID,
                        CallLog.Calls.CACHED_NAME,
                        CallLog.Calls.NUMBER,
                },
                null,
                null,
                CallLog.Calls.DEFAULT_SORT_ORDER/* + " limit 50"*/);
        long end = System.currentTimeMillis();
        long during = end - start;
        int count = mCallLog.getCount();
        tv.setText("  start: " + start + ",  end: " + end + ",  during: " + during + ",  count: " + count);

        //mAdapter = new MyCursorAdapter(this, R.layout.layout_lv_item, mCallLog, false);
        //lv.setAdapter(mAdapter);

        adapter = new MyRecyclerAdapter(mCallLog, this);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(adapter);
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rv.setItemAnimator(new DefaultItemAnimator());
        adapter.setItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("chenr", "view.position: " + v.getTag());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!mCallLog.isClosed()) {
            mCallLog.close();
        }
    }
}
