package com.lionmobi.expandlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ExpandableListView elv;
    private MyExpandListView mAdapter;

    private List<String> group = new ArrayList<>();
    private List<String> child = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
        setListener();
    }

    private void setListener() {
        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                if (groupPosition == 0) {
                    Log.d("chenr", "onChildClick: " + childPosition);
                    Toast.makeText(MainActivity.this, "Chick Child position: " + childPosition, Toast.LENGTH_SHORT).show();
                    child.remove(childPosition);
                    mAdapter.notifyDataSetChanged();
                    return true;
                }
                return false;
            }
        });
        //mAdapter.notifyDataSetChanged();
    }

    private void initData() {
        for (int i = 1; i <= 5; i++) {
            group.add("Group-" + i);
        }
        for (int i = 1; i <= 30; i++) {
            child.add("Child-" + i);
        }
    }

    private void initView() {
        elv = (ExpandableListView) findViewById(R.id.elv);

        mAdapter = new MyExpandListView(this, group, child);
        elv.setAdapter(mAdapter);
    }
}
