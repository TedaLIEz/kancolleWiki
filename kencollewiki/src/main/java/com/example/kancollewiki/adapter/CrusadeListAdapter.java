package com.example.kancollewiki.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kancollewiki.R;
import com.example.kancollewiki.bean.Crusade;

import java.util.List;

/**
 * Created by Administrator on 2015/9/26.
 */
public class CrusadeListAdapter extends BaseListAdapter<Crusade>{

    String[] parent = new String[]{"镇守府海域", "南西诸岛海域", "北方海域", "西方海域", "南方海域"};
    public CrusadeListAdapter(Context ctx) {
        super(ctx);
    }

    public CrusadeListAdapter(Context ctx, List<Crusade> datas) {
        super(ctx, datas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        Crusade crusade = datas.get(position);
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.crusade_item, parent, false);
            convertView.setTag(viewHolder);
            viewHolder.tv_name = (TextView) convertView.findViewById(R.id.crusade_name);
            viewHolder.tv_time = (TextView) convertView.findViewById(R.id.crusade_time);
            viewHolder.tv_bullet = (TextView) convertView.findViewById(R.id.crusade_bullet);
            viewHolder.tv_fuel = (TextView) convertView.findViewById(R.id.crusade_fuel);
            viewHolder.tv_steel = (TextView) convertView.findViewById(R.id.crusade_steel);
            viewHolder.tv_al = (TextView) convertView.findViewById(R.id.crusade_al);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tv_name.setText(crusade.getId() + "." + crusade.getName_jp());
        viewHolder.tv_time.setText(crusade.getTime().split("/")[0]);
        viewHolder.tv_fuel.setText(crusade.getFuel().split("/")[0]);
        viewHolder.tv_steel.setText(crusade.getSteel().split("/")[0]);
        viewHolder.tv_al.setText(crusade.getAl().split("/")[0]);
        viewHolder.tv_bullet.setText(crusade.getBullet().split("/")[0]);
        return convertView;
    }

    @Override
    public View getHeaderView(int i, View view, ViewGroup viewGroup) {
        HeaderViewHolder headerViewHolder;
        if (view == null) {
            headerViewHolder = new HeaderViewHolder();
            view = inflater.inflate(R.layout.crusade_subtitle_item, viewGroup, false);
            headerViewHolder.tv_subtitle = (TextView) view.findViewById(R.id.crusade_sub_name);
            view.setTag(headerViewHolder);
        } else {
            headerViewHolder = (HeaderViewHolder) view.getTag();
        }

        headerViewHolder.tv_subtitle.setText(parent[((int) getHeaderId(i))]);
        return view;
    }

    @Override
    public long getHeaderId(int i) {
        return datas.get(i).getPid();
    }
    static class ViewHolder {
        TextView tv_name,tv_time,tv_fuel,tv_bullet,tv_steel,tv_al;
    }

    static class  HeaderViewHolder {
        TextView tv_subtitle;
    }
}
