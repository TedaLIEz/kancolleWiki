package com.example.kancollewiki.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kancollewiki.R;
import com.example.kancollewiki.bean.ship.Ship;
import com.marshalchen.ultimaterecyclerview.UltimateDifferentViewTypeAdapter;
import com.marshalchen.ultimaterecyclerview.multiViewTypes.DataBinder;

/**
 * Created by Administrator on 2015/9/23.
 */
public abstract class ShipDetailFragmentBinder extends DataBinder<ShipDetailFragmentViewHolder>{
    protected Ship ship;
    public ShipDetailFragmentBinder(UltimateDifferentViewTypeAdapter dataBindAdapter,Ship ship) {
        super(dataBindAdapter);
        this.ship = ship;
    }

    public Ship getShip() {
        return ship;
    }

    @Override
    public ShipDetailFragmentViewHolder newViewHolder(ViewGroup viewGroup) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ship_detail_item, viewGroup, false);
        return new ShipDetailFragmentViewHolder(view);
    }

    @Override
    public abstract void bindViewHolder(ShipDetailFragmentViewHolder shipDetailFragmentViewHolder, int i);

    @Override
    public abstract int getItemCount();


}
