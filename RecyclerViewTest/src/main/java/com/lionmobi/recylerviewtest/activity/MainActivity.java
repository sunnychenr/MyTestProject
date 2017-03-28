package com.lionmobi.recylerviewtest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.lionmobi.recylerviewtest.utils.DividerItemDecoration;
import com.lionmobi.recylerviewtest.R;
import com.lionmobi.recylerviewtest.adapter.TestViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // 主界面测试
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
        findViewById(R.id.btn_jump_to_sec).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                // 将数据添加到model的头部;
                adapter.addData(0);
                break;
            case R.id.btn_delete:
                // 删除model中的位置在 1 数据;
                adapter.deleteData(1);
                break;
            case R.id.btn_sta_vertical:
                // 设置 RecyclerView 瀑布垂直显示;
                rv.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
                break;
            case R.id.btn_sta_horizontal:
                // 设置 RecyclerView 瀑布水平显示;
                rv.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL));
                break;
            case R.id.btn_grid:
                // 设置 RecyclerView item 网状显示;
                rv.setLayoutManager(new GridLayoutManager(this, 3));
                break;
            case R.id.btn_list:
                // 设置 RecyclerView 线性显示(item 在界面上呈垂直状态显示);
                rv.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.btn_jump_to_sec:
                // 跳转到第二个页面;
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                break;
        }
    }
}
