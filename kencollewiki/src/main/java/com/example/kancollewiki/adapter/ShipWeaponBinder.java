package com.example.kancollewiki.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kancollewiki.R;
import com.example.kancollewiki.bean.Weapon;
import com.example.kancollewiki.bean.ship.Ship;
import com.example.kancollewiki.util.Utils;
import com.marshalchen.ultimaterecyclerview.UltimateDifferentViewTypeAdapter;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;
import com.marshalchen.ultimaterecyclerview.multiViewTypes.DataBinder;

import java.util.List;

/**
 * Created by Administrator on 2015/9/23.
 */
public class ShipWeaponBinder extends ShipDetailFragmentBinder{
    List<Weapon> weapons;

    public ShipWeaponBinder(UltimateDifferentViewTypeAdapter dataBindAdapter, Ship ship) {
        super(dataBindAdapter,ship);
        this.weapons = ship.getWeapons();
    }

    @Override
    public void bindViewHolder(ShipDetailFragmentViewHolder viewHolder, final int i) {
        viewHolder.setOnItemClickListener(new ShipDetailFragmentViewHolder.HolderClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Utils.log("click in weapon " + i + " >> " + weapons.get(i).getName() + " <<");
            }
        });
        viewHolder.tv_name.setText(weapons.get(i).getName());
        if (getShip().isHasPlane()) {
            viewHolder.tv_data.setText(getShip().getPlanes().get(i));
        } else {
            viewHolder.setTv_dataInvisible();
        }
    }

    @Override
    public int getItemCount() {
        return weapons.size();
    }

}
