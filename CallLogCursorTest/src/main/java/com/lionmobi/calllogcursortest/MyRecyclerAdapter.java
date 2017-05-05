package com.lionmobi.calllogcursortest;

import android.content.Context;
import android.database.Cursor;
import android.nfc.cardemulation.HostApduService;
import android.provider.CallLog;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by ChenR on 2017/4/26.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.CursorView> {

    private Cursor cursor;
    private Context context;
    private boolean isDataValid;

    private View.OnClickListener mListener;

    public MyRecyclerAdapter(Cursor cursor, Context context) {
        this.cursor = cursor;
        this.context = context;
        this.isDataValid = (cursor != null);
    }

    @Override
    public CursorView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.layout_lv_item, null);
        ViewGroup.LayoutParams params =
                new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);
        if (mListener != null) view.setOnClickListener(mListener);
        return new CursorView(view);
    }

    @Override
    public void onBindViewHolder(CursorView holder, int position) {
        holder.itemView.setTag(holder.getLayoutPosition());

        Cursor cur = getItem(position);

        String num = cur.getString(cur.getColumnIndex(CallLog.Calls.NUMBER));
        String name = cur.getString(cur.getColumnIndex(CallLog.Calls.CACHED_NAME));

        name = TextUtils.isEmpty(name) ? num : name;
        holder.tv_name.setText(name);
        holder.tv_num.setText(num);
        holder.tv_position.setText(holder.getLayoutPosition() + "");
    }

    public void setItemClickListener (View.OnClickListener listener) {
        this.mListener = listener;
    }

    private Cursor getItem(int position) {
        if (isDataValid && cursor != null) {
            cursor.moveToPosition(position);
            return cursor;
        }
        return null;
    }

    @Override
    public int getItemCount() {
        if (cursor != null) {
            return cursor.getCount();
        }
        return 0;
    }

    class CursorView extends RecyclerView.ViewHolder {

        private TextView tv_num;
        private TextView tv_name;
        private TextView tv_position;

        public CursorView(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_num = (TextView) itemView.findViewById(R.id.tv_num);
            tv_position = (TextView) itemView.findViewById(R.id.tv_position);
        }
    }
}
