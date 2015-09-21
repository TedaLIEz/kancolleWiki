package com.example.kancollewiki.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;

/**
 * Created by Administrator on 2015/9/22.
 * more details in http://stackoverflow.com/questions/26245139/how-to-create-recyclerview-with-multiple-view-type
 */
public abstract class DataBinder<T extends RecyclerView.ViewHolder> {
    private DataBindAdapter mDataBindAdapter;

    public DataBinder(DataBindAdapter dataBindAdapter) {
        mDataBindAdapter = dataBindAdapter;
    }

    abstract public T newViewHolder(ViewGroup parent);

    abstract public void bindViewHolder(T holder, int pos);

    abstract public int getItemCount();
}
