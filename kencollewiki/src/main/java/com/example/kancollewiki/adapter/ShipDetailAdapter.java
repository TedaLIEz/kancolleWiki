package com.example.kancollewiki.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kancollewiki.R;
import com.example.kancollewiki.util.Utils;
import com.marshalchen.ultimaterecyclerview.UltimateDifferentViewTypeAdapter;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;
import com.marshalchen.ultimaterecyclerview.multiViewTypes.DataBinder;

import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2015/9/23.
 */
public class ShipDetailAdapter extends UltimateDifferentViewTypeAdapter{
    List<ShipDetailFragmentBinder> binders;
    @Override
    public Enum getEnumFromPosition(int i) {
        int itemCount = 0;
        for (int viewType = 0; viewType < binders.size(); viewType++) {
            itemCount += binders.get(viewType).getItemCount();
            if (i < itemCount) {
                return ShipDetailType.values()[viewType];
            }
        }
        throw new IllegalArgumentException("arg pos is invalid");
    }

    private String getEnumName(int i) {
        int itemCount = 0;
        for (int viewType = 0; viewType < binders.size(); viewType++) {
            itemCount += binders.get(viewType).getItemCount();
            if (i < itemCount) {
                return ShipDetailType.values()[viewType].getText();
            }
        }
        throw new IllegalArgumentException("arg pos is invalid");
    }
    public ShipDetailAdapter(){}

    public void setBinders(List<ShipDetailFragmentBinder> binders) {
        this.binders = binders;
        for (DataBinder binder : binders) {
            if (binder instanceof ShipDetailBinder) {
                putBinder(ShipDetailType.SHIP, binder);
            }
            if (binder instanceof ShipWeaponBinder) {
                putBinder(ShipDetailType.WEAPON, binder);
            }
            if (binder instanceof ShipLocationBinder) {
                putBinder(ShipDetailType.LOCATIONS, binder);
            }
            if (binder instanceof ShipBuildBinder){
                putBinder(ShipDetailType.BUILD, binder);
            }
        }
    }


    @Override
    public Enum getEnumFromOrdinal(int i) {
        return ShipDetailType.values()[i];
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(View view) {
        return new ShipDetailFragmentViewHolder(view);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ship_detail_item, viewGroup, false);
        ShipDetailFragmentViewHolder viewHolder = new ShipDetailFragmentViewHolder(view);
        return viewHolder;
    }


    @Override
    public UltimateRecyclerviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return super.onCreateViewHolder(parent, viewType);
    }

    @Override
    public int getAdapterItemCount() {
        return binders.size();
    }



    /**
     * must return different id if headerview needed.
     * @param i
     * @return
     */
    @Override
    public long generateHeaderId(int i) {
        if (binders.get(0).getShip().isCanUpdate()) {
            if (i < 9) {
                return 0;
            } else if (i < getDataBinder(ShipDetailType.SHIP).getItemCount() + getDataBinder(ShipDetailType.WEAPON).getItemCount()){
                return 1;
            } else if (i < getDataBinder(ShipDetailType.SHIP).getItemCount() + getDataBinder(ShipDetailType.WEAPON).getItemCount() + getDataBinder(ShipDetailType.BUILD).getItemCount()) {
                return 2;
            } else {
                return 3;
            }
        } else {
            if (i < 6) {
                return 0;
            } else if (i < getDataBinder(ShipDetailType.SHIP).getItemCount() + getDataBinder(ShipDetailType.WEAPON).getItemCount()){
                return 1;
            } else if (i < getDataBinder(ShipDetailType.SHIP).getItemCount() + getDataBinder(ShipDetailType.WEAPON).getItemCount() + getDataBinder(ShipDetailType.BUILD).getItemCount()) {
                return 2;
            } else {
                return 3;
            }
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup viewGroup) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.stick_header_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ViewHolder) {
            ViewHolder mViewHolder = (ViewHolder) viewHolder;
            mViewHolder.tv_sticky.setText(getEnumName(i));
        }

    }



    enum ShipDetailType {
        SHIP("舰船数据"),WEAPON("装备/搭载"),BUILD("入手方法"),LOCATIONS("掉落");
        String text;
        ShipDetailType(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_sticky;
        View itemView;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tv_sticky = (TextView) itemView.findViewById(R.id.stick_text);
        }

        public void setInvisible() {
            itemView.setVisibility(View.GONE);
        }
    }
}
