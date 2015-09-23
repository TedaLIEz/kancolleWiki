package com.example.kancollewiki.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kancollewiki.R;
import com.example.kancollewiki.bean.ship.Ship;
import com.example.kancollewiki.bean.ship.ShipDataBean;
import com.example.kancollewiki.fragment.ShipDetailFragment;
import com.example.kancollewiki.util.Utils;
import com.marshalchen.ultimaterecyclerview.UltimateDifferentViewTypeAdapter;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;
import com.marshalchen.ultimaterecyclerview.multiViewTypes.DataBinder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2015/9/23.
 */
public class ShipDetailBinder extends ShipDetailFragmentBinder{
    HashMap<String, Object> lists;

    public ShipDetailBinder(UltimateDifferentViewTypeAdapter dataBindAdapter, Ship ship) {
        super(dataBindAdapter, ship);
        init(ship);
    }

    private void init(Ship ship) {
        lists = new HashMap<>();
        lists.put(ShipDataType.SHIP_DATA.getText(), ship.getBean());
        lists.put(ShipDataType.PIC.getText(), ship.getPic_url());
        lists.put(ShipDataType.PAINTER.getText(), ship.getPainter());
        lists.put(ShipDataType.RANGE.getText(), ship.getRange());
        if (ship.isCanUpdate()) {
            lists.put(ShipDataType.SHIP_UPDATE_LEVEL.getText(), ship.getUpdateCost());
            lists.put(ShipDataType.SHIP_UPDATE_COST.getText(), ship.getUpdateCost());
        }
        lists.put(ShipDataType.SHIP_ATTACK_COST.getText(), ship.getAttackCost());
    }

    @Override
    public void bindViewHolder(ShipDetailFragmentViewHolder viewHolder, int i) {
        if (i < getItemCount()) {

            viewHolder.tv_name.setText(ShipDataType.values()[i].getText());


            if (i > 4) {
                viewHolder.setInvisible();
            }
        }

    }

    @Override
    public int getItemCount() {
        if (ship.isCanUpdate()) {
            return 9;
        } else {
            return 6;
        }
    }

    enum ShipDataType{
        SHIP_DATA("数据比较"),
        PIC("图鉴"),
        AUDIO("声优"),
        PAINTER("画师"),
        SHIP_TYPE("舰种"),
        RANGE("射程"),
        SHIP_UPDATE_LEVEL("改造Level"),
        SHIP_UPDATE_COST("改造消耗"),
        SHIP_ATTACK_COST("出击消耗");

        private String text;

        ShipDataType(String text) {
            this.text = text;
        }

        private String getText() {
            return this.text;
        }
    }

}
