package com.example.kancollewiki.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kancollewiki.R;
import com.example.kancollewiki.util.Utils;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;

/**
 * Created by Administrator on 2015/9/23.
 */
public class ShipDetailFragmentViewHolder extends UltimateRecyclerviewViewHolder{
    TextView tv_name,tv_data;
    ImageView iv_next;
    public ShipDetailFragmentViewHolder(View itemView) {
        super(itemView);
        tv_name = Utils.findViewById(itemView, R.id.ship_detail_name);
        tv_data = Utils.findViewById(itemView, R.id.ship_detail_data);
        iv_next = Utils.findViewById(itemView, R.id.ship_detail_next);
    }

    public void setImageInvisible () {
        iv_next.setVisibility(View.INVISIBLE);
    }
    public void setTv_dataInvisible () {tv_data.setVisibility(View.INVISIBLE);}
}
