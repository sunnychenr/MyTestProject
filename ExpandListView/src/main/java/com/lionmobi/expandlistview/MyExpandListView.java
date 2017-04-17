package com.lionmobi.expandlistview;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ChenR on 2017/4/15.
 */

public class MyExpandListView extends BaseExpandableListAdapter {

    private Context mContext;
    private List<String> grounp;
    private List<String> child;

    public MyExpandListView(Context context, List<String> grounp, List<String> child) {
        this.mContext = context;
        this.grounp = grounp;
        this.child = child;
    }

    @Override
    public int getGroupCount() {
        return grounp.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return child.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return grounp.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return child.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder holder = null;

        if (convertView == null) {
            holder = new GroupViewHolder();
            convertView = View.inflate(mContext, R.layout.item, null);
            holder.tv_group = (TextView) convertView;
            convertView.setTag(holder);
        } else {
            holder = (GroupViewHolder) convertView.getTag();
        }
        Log.d("chenr", "getGroupView isExpand: " + isExpanded);
        holder.tv_group.setText(getGroup(groupPosition).toString());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder holder = null;

        if (convertView == null) {
            holder = new ChildViewHolder();
            convertView = View.inflate(mContext, R.layout.item2, null);
            holder.tv_child = (TextView) convertView;
            convertView.setTag(holder);
        } else {
            holder = (ChildViewHolder) convertView.getTag();
        }

        holder.tv_child.setText(getChild(groupPosition, childPosition).toString());
        holder.tv_child.setTextColor(0xff0086b8);
        removeChild(holder.tv_child, groupPosition, childPosition);

        return convertView;
    }

    private void removeChild(TextView tv, final int groupPosition, final int childPosition) {
        /*tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = (String) getChild(groupPosition, childPosition);
                Log.d("chenr", "child: " + str);
                child.remove(str);
            }
        });*/
        //notifyDataSetChanged();

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private class GroupViewHolder {
        TextView tv_group;
    }

    private class ChildViewHolder {
        TextView tv_child;
    }
}
