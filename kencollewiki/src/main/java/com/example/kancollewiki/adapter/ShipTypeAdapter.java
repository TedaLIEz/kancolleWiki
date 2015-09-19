package com.example.kancollewiki.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kancollewiki.R;
import com.example.kancollewiki.util.Utils;

import java.util.List;

/**
 * Created by Administrator on 2015/9/15.
 */
public class ShipTypeAdapter<T> extends BaseListAdapter {
    public ShipTypeAdapter(Context ctx) {
        super(ctx);
    }

    public ShipTypeAdapter(Context ctx, List datas) {
        super(ctx, datas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_ship,parent,false);
        }
        TextView ship = Utils.findViewById(convertView, R.id.ship_type);
        ship.setText((String) datas.get(position));
        return convertView;
    }

}
