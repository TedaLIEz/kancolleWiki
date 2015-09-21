package com.example.kancollewiki.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.kancollewiki.bean.ship.ShipClass;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;
import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter;

import java.util.List;

/**
 * Created by Administrator on 2015/9/21.
 */
public class ShipDetailAdapter extends UltimateViewAdapter<ShipDetailAdapter.ShipDetailAdapterViewHolder>{
    private List<ShipClass> datas;
    public ShipDetailAdapter(List<ShipClass> datas) {
        this.datas = datas;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public ShipDetailAdapterViewHolder getViewHolder(View view) {
        return null;
    }

    @Override
    public ShipDetailAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return null;
    }


    @Override
    public int getAdapterItemCount() {
        return datas.size();
    }

    @Override
    public long generateHeaderId(int pos) {
        return 0;
    }

    @Override
    public void onBindViewHolder(ShipDetailAdapterViewHolder shipDetailAdapterViewHolder, int pos) {

    }

    @Override
    public ShipDetailAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return super.onCreateViewHolder(parent, viewType);
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup viewGroup) {
        return null;
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder viewHolder, int pos) {

    }

    public class ShipDetailAdapterViewHolder extends UltimateRecyclerviewViewHolder{

        public ShipDetailAdapterViewHolder(View itemView, boolean isAbstract) {
            super(itemView);
        }
    }

}
