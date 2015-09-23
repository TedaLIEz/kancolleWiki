package com.example.kancollewiki.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kancollewiki.R;
import com.marshalchen.ultimaterecyclerview.UltimateDifferentViewTypeAdapter;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2015/9/23.
 */
public class ShipDetailAdapter<T extends ShipDetailFragmentBinder> extends UltimateDifferentViewTypeAdapter{
    List<T> binders;
    @Override
    public Enum getEnumFromPosition(int i) {
        int pos = 0;
        for (ShipDetailFragmentBinder binder : binders) {
            pos = binder.getItemCount();
            if (i < pos)
                break;
            i -= pos;
        }
        return ShipDetailType.values()[i];
    }


    public ShipDetailAdapter(List<T> binders){
        this.binders = binders;
        for (ShipDetailFragmentBinder binder : binders) {
            if (binder instanceof ShipDetailBinder) {
                putBinder(ShipDetailType.SHIP, binder);
            }
            if (binder instanceof ShipWeaponBinder) {
                putBinder(ShipDetailType.WEAPON, binder);
            }
        }
    }


    @Override
    public Enum getEnumFromOrdinal(int i) {
        return ShipDetailType.values()[i];
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(View view) {
        return new ShipDetailFragmentViewHolder(view);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ship_detail_item, viewGroup, false);
        ShipDetailFragmentViewHolder viewHolder = new ShipDetailFragmentViewHolder(view);
        return viewHolder;
    }


    @Override
    public UltimateRecyclerviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return super.onCreateViewHolder(parent, viewType);
    }

    @Override
    public int getAdapterItemCount() {
        return binders.size();
    }

    @Override
    public long generateHeaderId(int i) {
        return 0;
    }



    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup viewGroup) {
        return null;
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder viewHolder, int i) {}

    enum ShipDetailType {
        SHIP,WEAPON
    }
}
