package com.lionmobi.calllogcursortest;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.database.Cursor;
import android.provider.CallLog;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

/**
 * Created by ChenR on 2017/4/25.
 */

public class MyCursorAdapter extends ResourceCursorAdapter {

    public MyCursorAdapter(Context context, int layout, Cursor c, boolean autoRequery) {
        super(context, layout, c, autoRequery);
    }

    private int newCount;
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = super.newView(context, cursor, parent);
//        TranslateAnimation anim = new TranslateAnimation(720.0f, 0.0f, 0.0f, 0.0f);
//        anim.setDuration(500);
//        view.setAnimation(anim);

        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String name = cursor.getString(cursor.getColumnIndex(CallLog.Calls.CACHED_NAME));
        String num = cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER));

        TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
        TextView tv_num = (TextView) view.findViewById(R.id.tv_num);
        tv_name.setText(name);
        tv_num.setText(num);

        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "translationX", 720, 0);
        anim.setDuration(200);
        anim.start();
    }
}
