package com.lionmobi.calllogcursortest;

import android.content.Context;
import android.database.Cursor;
import android.provider.CallLog;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
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
        Log.d("chenr", "newCount: " + (++newCount));
        return super.newView(context, cursor, parent);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String name = cursor.getString(cursor.getColumnIndex(CallLog.Calls.CACHED_NAME));
        String num = cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER));

        TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
        TextView tv_num = (TextView) view.findViewById(R.id.tv_num);
        tv_name.setText(name);
        tv_num.setText(num);
    }
}
