package com.example.kancollewiki.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;
import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter;

/**
 * Created by Administrator on 2015/9/22.
 *
 * more details in http://stackoverflow.com/questions/26245139/how-to-create-recyclerview-with-multiple-view-type
 */
public abstract class DataBindAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return getDataBinder(viewType).newViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder ultimateRecyclerviewViewHolder, int i) {
        int binderPosition = getBinderPosition(i);
        getDataBinder(ultimateRecyclerviewViewHolder.getItemViewType()).bindViewHolder(ultimateRecyclerviewViewHolder, binderPosition);
    }

    @Override
    public abstract int getItemCount();
    @Override
    public abstract int getItemViewType(int position);

    public abstract <T extends DataBinder> T getDataBinder(int viewType);

    public abstract int getPosition(DataBinder binder, int binderPos);

    public abstract int getBinderPosition(int pos);
}
