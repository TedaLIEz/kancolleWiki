package com.example.kancollewiki.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kancollewiki.C;
import com.example.kancollewiki.R;
import com.example.kancollewiki.bean.ship.AbstractShipClass;
import com.example.kancollewiki.bean.ship.Ship;
import com.example.kancollewiki.bean.ship.ShipClass;
import com.example.kancollewiki.util.Utils;

import java.util.List;

/**
 * Created by Administrator on 2015/9/15.
 */
public class ShipTypeAdapter extends BaseListAdapter<ShipClass> {
    private String[] strs = new String[]{"二","三"};
    public ShipTypeAdapter(Context ctx) {
        super(ctx);
    }

    public ShipTypeAdapter(Context ctx, List datas) {
        super(ctx, datas);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ShipClass shipClass = datas.get(position);
        if (convertView == null) {
            if (shipClass instanceof AbstractShipClass) {
                AbstractShipClass abstractShipClass = (AbstractShipClass) shipClass;
                convertView = inflater.inflate(R.layout.ship_subtitle_item, parent, false);

                TextView subtitle = findViewById(convertView, R.id.ship_subtitle);
                subtitle.setText(abstractShipClass.getName());
            } else if (shipClass instanceof Ship){
                Ship ship = (Ship) shipClass;
                convertView = inflater.inflate(R.layout.ship_item, parent, false);
                TextView shipSpeed = findViewById(convertView, R.id.ship_speed);
                shipSpeed.setText(ship.getSpeed() == C.HIGH_SPEED ? "高速" : "低速");
                TextView needPaper = findViewById(convertView, R.id.ship_paper);
                if (ship.isNeedPaper()) {
                    needPaper.setVisibility(View.VISIBLE);
                }
                TextView tv_update = findViewById(convertView, R.id.ship_update);
                int updateTime = ship.getUpdateTime();
                if (updateTime >= 2) {
                    tv_update.setText("改" + strs[updateTime - 2]);
                } else {
                    tv_update.setVisibility(View.INVISIBLE);
                }
                TextView shipName = findViewById(convertView, R.id.ship_type);
                shipName.setText(ship.getName());
                TextView tv_id = findViewById(convertView, R.id.ship_id);
                tv_id.setText(ship.getId() + "番舰");

            }
        }

        return convertView;



    }

    @Override
    public View getHeaderView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public long getHeaderId(int i) {
        return 0;
    }


    public static <T extends View> T findViewById(View view, int id) {
        SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();
        if (viewHolder == null) {
            viewHolder = new SparseArray<View>();
            view.setTag(viewHolder);
        }
        View childView = viewHolder.get(id);
        if (childView == null) {
            childView = view.findViewById(id);
            viewHolder.put(id, childView);
        }
        return (T) childView;
    }
}
