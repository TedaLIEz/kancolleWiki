package com.example.kancollewiki.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kancollewiki.R;
import com.example.kancollewiki.bean.ship.Ship;
import com.example.kancollewiki.util.ShipHelper;
import com.marshalchen.ultimaterecyclerview.UltimateDifferentViewTypeAdapter;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;
import com.marshalchen.ultimaterecyclerview.multiViewTypes.DataBinder;

import java.util.List;

/**
 * Created by Administrator on 2015/9/22.
 */
public class ShipDataBinder extends DataBinder<ShipDataBinder.ViewHolder> {
    Ship ship;
    List<String> lists;
    String[] items = new String[]{"数据比较", "图鉴", "声优", "画师", "舰种", "射程",  "出击消耗", "改造Level", "改造消耗"};
    String[] items_not_update = new String[]{"数据比较", "图鉴", "声优", "画师", "舰种", "射程",  "出击消耗"};

    public ShipDataBinder(UltimateDifferentViewTypeAdapter dataBindAdapter) {
        super(dataBindAdapter);
        initDatas();
    }


    private void initDatas() {
        lists = ShipHelper.initDetail(ship);

    }

    @Override
    public ViewHolder newViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ship_detail_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void bindViewHolder(ViewHolder holder, int pos) {
//        Ship ship = datas.get(pos);
        if (ship.isCanUpdate()) {
            holder.tv_name.setText(items[pos]);
            holder.tv_data.setText(lists.get(pos));
        } else {
            holder.tv_name.setText(items_not_update[pos]);
            holder.tv_data.setText(lists.get(pos));
        }


    }



    @Override
    public int getItemCount() {
        if (ship.isCanUpdate()) {
            return items.length;
        } else {
            return items_not_update.length;
        }
    }

    public class ViewHolder extends UltimateRecyclerviewViewHolder {
        TextView tv_name,tv_data;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.ship_detail_name);
            tv_data = (TextView) itemView.findViewById(R.id.ship_detail_data);
        }
    }
}
