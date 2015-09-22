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
public abstract class DataBindAdapter extends UltimateViewAdapter<RecyclerView.ViewHolder> {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return getDataBinder(viewType).newViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int binderPosition = getBinderPosition(position);
        getDataBinder(holder.getItemViewType()).bindViewHolder(holder, binderPosition);
    }

    @Override
    public abstract RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup viewGroup);

    @Override
    public abstract void onBindHeaderViewHolder(RecyclerView.ViewHolder viewHolder, int i);

    @Override
    public abstract int getItemCount();
    @Override
    public abstract int getItemViewType(int position);

    public abstract <T extends DataBinder> DataBinder getDataBinder(int viewType);

    public abstract int getPosition(DataBinder binder, int binderPos);

    public abstract int getBinderPosition(int pos);

    public void notifyBinderItemChanged(DataBinder binder, int binderPosition) {
        notifyItemChanged(getPosition(binder, binderPosition));
    }

    public abstract void notifyBinderItemRangeChanged(DataBinder binder, int positionStart,
                                                      int itemCount);

    public void notifyBinderItemInserted(DataBinder binder, int binderPosition) {
        notifyItemInserted(getPosition(binder, binderPosition));
    }

    public void notifyBinderItemMoved(DataBinder binder, int fromPosition, int toPosition) {
        notifyItemMoved(getPosition(binder, fromPosition), getPosition(binder, toPosition));
    }

    public abstract void notifyBinderItemRangeInserted(DataBinder binder, int positionStart,
                                                       int itemCount);

    public void notifyBinderItemRemoved(DataBinder binder, int binderPosition) {
        notifyItemRemoved(getPosition(binder, binderPosition));
    }

    public abstract void notifyBinderItemRangeRemoved(DataBinder binder, int positionStart,
                                                      int itemCount);
}
