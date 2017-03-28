package com.lionmobi.recylerviewtest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lionmobi.recylerviewtest.beans.Person;

import java.util.List;

/**
 * Created by ChenR on 2017/2/6.
 */

public class AnotherViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Person> model;
    private Context mContext;
    private LayoutInflater mInflater;

    public AnotherViewAdapter(List<Person> model, Context mContext) {
        this.model = model;
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemViewType(int position) {
        return model.get(position).getTag();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        if (viewType == Person.PersonTag.PRIVATE_PERSON.ordinal()) {
            return new PrivateViewHolder(view);
        } else if (viewType == Person.PersonTag.PUBLIC_PERSON.ordinal()) {
            return new PublicViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Person person = model.get(position);

    }

    @Override
    public int getItemCount() {
        return (model == null) ? -1 : model.size();
    }

    private class PublicViewHolder extends RecyclerView.ViewHolder {

        public PublicViewHolder(View itemView) {
            super(itemView);
        }

    }

    private class PrivateViewHolder extends RecyclerView.ViewHolder {
        public PrivateViewHolder(View itemView) {
            super(itemView);
        }
    }
}
