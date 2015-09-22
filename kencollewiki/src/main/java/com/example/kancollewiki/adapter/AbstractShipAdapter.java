package com.example.kancollewiki.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kancollewiki.R;
import com.example.kancollewiki.bean.ship.AbstractShipClass;

import java.util.List;

/**
 * Created by Administrator on 2015/9/22.
 */
public class AbstractShipAdapter extends DataBinder<AbstractShipAdapter.ViewHolder>{
    List<AbstractShipClass> datas;

    public AbstractShipAdapter(DataBindAdapter dataBindAdapter) {
        super(dataBindAdapter);
    }

    @Override
    public ViewHolder newViewHolder(ViewGroup parent) {
//        LayoutInflater.from(parent.getContext()).inflate(R.layout.)
        return null;
    }

    @Override
    public void bindViewHolder(ViewHolder holder, int pos) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
