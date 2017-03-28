package com.lionmobi.recylerviewtest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lionmobi.recylerviewtest.R;
import com.lionmobi.recylerviewtest.adapter.AnotherViewAdapter;
import com.lionmobi.recylerviewtest.beans.Person;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends Activity {

    private List<Person> model = new ArrayList() {
        {
            add(new Person(0, 12, Person.PersonTag.PRIVATE_PERSON, "小A", null, false));
            add(new Person(1, 28, Person.PersonTag.PRIVATE_PERSON, "木木", null, false));
            add(new Person(2, 33, Person.PersonTag.PRIVATE_PERSON, "C君", null, false));
            add(new Person(3, 24, Person.PersonTag.PRIVATE_PERSON, "张毅", null, false));
            add(new Person(4, 18, Person.PersonTag.PRIVATE_PERSON, "Tom", null, false));
            add(new Person(5, 15, Person.PersonTag.PRIVATE_PERSON, "Cheney", null, false));
            add(new Person(6, 14, Person.PersonTag.PRIVATE_PERSON, "Lucy", null, true));
            add(new Person(7, 17, Person.PersonTag.PRIVATE_PERSON, "Lily", null, true));
            add(new Person(8, 18, Person.PersonTag.PRIVATE_PERSON, "Sabar", "中国·黑龙江", null));
            add(new Person(9, 19, Person.PersonTag.PRIVATE_PERSON, "莫小凡", null, false));
            add(new Person(10, 21, Person.PersonTag.PUBLIC_PERSON, "陈一一", null, true));
            add(new Person(11, 52, Person.PersonTag.PUBLIC_PERSON, "程华", null, false));
            add(new Person(12, 44, Person.PersonTag.PUBLIC_PERSON, "罗晓", null, false));
            add(new Person(13, 42, Person.PersonTag.PUBLIC_PERSON, "黄子文", "广东·广州", false));
            add(new Person(14, 43, Person.PersonTag.PUBLIC_PERSON, "白晓辉", null, false));
            add(new Person(15, 51, Person.PersonTag.PRIVATE_PERSON, "霍名", null, false));
            add(new Person(16, 68, Person.PersonTag.PUBLIC_PERSON, "肖子怡", "四川·遂宁", true));
            add(new Person(17, 15, Person.PersonTag.PUBLIC_PERSON, "黄子珊", null, true));
            add(new Person(18, 10, Person.PersonTag.PRIVATE_PERSON, "肖珊", null, true));
            add(new Person(19, 35, Person.PersonTag.PUBLIC_PERSON, "鸣子璋", "上海·浦东", false));
            add(new Person(20, 37, Person.PersonTag.PUBLIC_PERSON, "肖华", null, false));
            add(new Person(21, 33, Person.PersonTag.PUBLIC_PERSON, "Iris", null, true));
            add(new Person(22, 36, Person.PersonTag.PRIVATE_PERSON, "谢珊", "四川·自贡", true));
            add(new Person(23, 20, Person.PersonTag.PUBLIC_PERSON, "老王", null, false));
            add(new Person(24, 41, Person.PersonTag.PUBLIC_PERSON, "姜思怡", "四川·成都", true));
            add(new Person(25, 37, Person.PersonTag.PRIVATE_PERSON, "蒋珲", "意大利·罗马", false));
            add(new Person(26, 29, Person.PersonTag.PUBLIC_PERSON, "张默晓", "自贡·荣县", true));
            add(new Person(27, 17, Person.PersonTag.PUBLIC_PERSON, "张华易", null, true));
            add(new Person(28, 48, Person.PersonTag.PRIVATE_PERSON, "卢晓芬", null, true));
            add(new Person(29, 16, Person.PersonTag.PUBLIC_PERSON, "GuluNeko", null, true));
            add(new Person(30, 42, Person.PersonTag.PUBLIC_PERSON, "咕噜猫", "成都市新津县", false));
            add(new Person(31, 45, Person.PersonTag.PRIVATE_PERSON, "陶小明", null, false));
            add(new Person(32, 25, Person.PersonTag.PUBLIC_PERSON, "自发电", null, null));
        }
    };
    private RecyclerView rv;
    private AnotherViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initView();
        setRv();
        initAdapter();
    }

    private void initAdapter() {
        mAdapter = new AnotherViewAdapter(model, Main2Activity.this);
        rv.setAdapter(mAdapter);
    }

    private void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);
    }

    public void setRv() {
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}
