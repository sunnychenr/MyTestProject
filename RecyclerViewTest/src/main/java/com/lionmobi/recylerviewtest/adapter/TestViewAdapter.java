package com.lionmobi.recylerviewtest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lionmobi.recylerviewtest.R;

import java.util.List;

/**
 * Created by ChenR on 2016/12/28.
 */

public class TestViewAdapter extends RecyclerView.Adapter<TestViewAdapter.ViewHolder> {

    private List<String> model;
    private LayoutInflater mInflater;
    private Context context;
    private OnItemClickListener mOnItemClickListener;

    public TestViewAdapter(List<String> model, Context context) {
        this.model = model;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public TestViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TestViewAdapter.ViewHolder holder, final int position) {
        String s = model.get(position);
        holder.tv.setText(s.substring(0, s.indexOf("&")));
        ViewGroup.LayoutParams layoutParams = holder.tv.getLayoutParams();
        layoutParams.height = Integer.parseInt(s.substring(s.indexOf("&") + 1));
        holder.tv.setLayoutParams(layoutParams);

        //holder.tv.setText(model.get(position));
        // 设置瀑布流实现;
        // 当这样设置时，每次滑动，重新加载屏幕外的视图时会重新设置子视图的高度，导致高度发生变化的情况发生；
        // 当视图的LayoutManager属于StaggeredGridLayoutManager时，当方向设置为horizontal时子视图设置width
        // 方向设置为vertical时子视图设置height
        //ViewGroup.LayoutParams layoutParams = holder.tv.getLayoutParams();
        //layoutParams.height = (int) (100 + Math.random() * 300);
        //holder.tv.setLayoutParams(layoutParams);

        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 使用position和holder.getLayoutPosition具有同样的效果，但是后者保险一点；
                    mOnItemClickListener.onItemClickListener(holder.itemView, holder.getLayoutPosition());
                    //mOnItemClickListener.onItemClickListener(holder.itemView, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return (model == null) ? -1 : model.size();
    }

    public void addData(int position) {
        model.add(position, "new " + position + "&" + 250);
        notifyItemInserted(position);
    }

    public void deleteData(int position) {
        model.remove(position);
        notifyItemRemoved(position);
    }

    public void setOnItemClickListener (OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv_recycler_view_item);
        }
    }

    public interface OnItemClickListener {
        void onItemClickListener(View view, int position);
    }
}
