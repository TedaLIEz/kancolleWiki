package com.example.kancollewiki.adapter;

import android.view.View;

import com.example.kancollewiki.bean.ship.Ship;
import com.example.kancollewiki.util.Utils;
import com.marshalchen.ultimaterecyclerview.UltimateDifferentViewTypeAdapter;

import java.util.List;

/**
 * Created by Administrator on 2015/9/25.
 */
public class ShipLocationBinder extends ShipDetailFragmentBinder{
    List<String> locations;
    public ShipLocationBinder(UltimateDifferentViewTypeAdapter dataBindAdapter, Ship ship) {
        super(dataBindAdapter, ship);
        locations = ship.getLocations();
    }

    @Override
    public void bindViewHolder(ShipDetailFragmentViewHolder shipDetailFragmentViewHolder, final int i) {
        shipDetailFragmentViewHolder.setOnItemClickListener(new ShipDetailFragmentViewHolder.HolderClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Utils.log("click in location " + i  + " >> " + locations.get(i) + " <<");
            }
        });
        shipDetailFragmentViewHolder.setTv_dataInvisible();
        shipDetailFragmentViewHolder.setImageInvisible();
        shipDetailFragmentViewHolder.tv_name.setText(locations.get(i));
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }
}
