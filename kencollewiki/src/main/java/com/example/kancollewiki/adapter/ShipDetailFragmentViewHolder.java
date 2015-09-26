package com.example.kancollewiki.adapter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kancollewiki.R;
import com.example.kancollewiki.util.Utils;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;

/**
 * Created by Administrator on 2015/9/23.
 */
public class ShipDetailFragmentViewHolder extends UltimateRecyclerviewViewHolder implements View.OnClickListener {
    TextView tv_name,tv_data;
    ImageView iv_next;
    protected HolderClickListener holderClickListener;
    public ShipDetailFragmentViewHolder(View itemView) {
        super(itemView);
        tv_name = (TextView) itemView.findViewById(R.id.ship_detail_name);
        tv_data = (TextView) itemView.findViewById(R.id.ship_detail_data);
        iv_next = (ImageView) itemView.findViewById(R.id.ship_detail_next);

    }

    public void setImageInvisible () {
        iv_next.setVisibility(View.INVISIBLE);
    }
    public void setTv_dataInvisible () {tv_data.setVisibility(View.INVISIBLE);}

    public void setOnItemClickListener(HolderClickListener holderClickListener) {
        this.holderClickListener = holderClickListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        holderClickListener.onItemClick(v, getAdapterPosition());
    }

    public interface HolderClickListener {
        void onItemClick(View v, int pos);
    }
}
