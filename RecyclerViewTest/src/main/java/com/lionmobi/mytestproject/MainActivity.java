package com.lionmobi.mytestproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView cv;

    private RecyclerView rv;
    private RecyclerView.LayoutManager manager;
    private TestViewAdapter adapter;
    private List<String> model = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initAdapter();
        setRv();
    }

    private void setRv() {
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL_LIST));
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        rv.setItemAnimator(new DefaultItemAnimator());

        adapter.setOnItemClickListener(new TestViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                Toast.makeText(MainActivity.this, model.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initAdapter() {
        adapter = new TestViewAdapter(model, this);
        rv.setAdapter(adapter);
    }

    private void initData() {
        for (int i = 'A'; i < 'z'; i ++) {
            String str = (char) i + "&" + (int) (100 + Math.random() * 300);
            model.add(str);
        }
    }

    private void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);

        findViewById(R.id.btn_add).setOnClickListener(this);
        findViewById(R.id.btn_delete).setOnClickListener(this);
        findViewById(R.id.btn_list).setOnClickListener(this);
        findViewById(R.id.btn_grid).setOnClickListener(this);
        findViewById(R.id.btn_sta_vertical).setOnClickListener(this);
        findViewById(R.id.btn_sta_horizontal).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                adapter.addData(1);
                break;
            case R.id.btn_delete:
                adapter.deleteData(1);
                break;
            case R.id.btn_sta_vertical:
                rv.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
                break;
            case R.id.btn_sta_horizontal:
                rv.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL));
                break;
            case R.id.btn_grid:
                rv.setLayoutManager(new GridLayoutManager(this, 3));
                break;
            case R.id.btn_list:
                rv.setLayoutManager(new LinearLayoutManager(this));
                break;
        }
    }
}
