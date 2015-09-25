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
        lists.put(ShipDataType.AUDIO.getText(), ship.getAudio());
        lists.put(ShipDataType.PAINTER.getText(), ship.getPainter());
        lists.put(ShipDataType.RANGE.getText(), ship.getRange() == 0 ? "短" : "长");
        lists.put(ShipDataType.SHIP_TYPE.getText(), ship.getShipClass().getName());
        if (ship.isCanUpdate()) {
            lists.put(ShipDataType.SHIP_UPDATE_LEVEL.getText(), ship.getUpdateLevel());
            lists.put(ShipDataType.SHIP_UPDATE_COST.getText(), ship.getUpdateCost());
        }
        lists.put(ShipDataType.SHIP_ATTACK_COST.getText(), ship.getAttackCost());
    }

    @Override
    public void bindViewHolder(ShipDetailFragmentViewHolder viewHolder, final int i) {
        if (i > 5) {
            viewHolder.itemView.setBackgroundResource(R.drawable.detail_ship_selector);
        }
        viewHolder.setOnItemClickListener(new ShipDetailFragmentViewHolder.HolderClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                if (i > 4) {
                    return ;
                }
                Utils.log("click in detail " + i + " >> " + ShipDataType.values()[i].getText() + " <<");
            }
        });
        if (i < getItemCount()) {
            viewHolder.tv_name.setText(ShipDataType.values()[i].getText());
            if (i < 2) {
                viewHolder.setTv_dataInvisible();
            } else {
                if (lists.get(ShipDataType.values()[i].getText()) != null) {
                    viewHolder.tv_data.setText(lists.get(ShipDataType.values()[i].getText()).toString());
                }

            }
            if (i > 4) {
                viewHolder.setImageInvisible();
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
