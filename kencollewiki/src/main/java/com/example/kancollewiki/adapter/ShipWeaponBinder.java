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

    public ShipWeaponBinder(UltimateDifferentViewTypeAdapter dataBindAdapter, Ship ship, List<Weapon> weapons) {
        super(dataBindAdapter,ship);
        this.weapons = weapons;
    }

    @Override
    public void bindViewHolder(ShipDetailFragmentViewHolder viewHolder, int i) {
        viewHolder.tv_name.setText(weapons.get(i).getName());
        if (getShip().isHasPlane()) {
            viewHolder.tv_data.setText("0");
        } else {
            viewHolder.tv_data.setText(getShip().getPlanes().get(i));
        }
    }

    @Override
    public int getItemCount() {
        return weapons.size();
    }

}
