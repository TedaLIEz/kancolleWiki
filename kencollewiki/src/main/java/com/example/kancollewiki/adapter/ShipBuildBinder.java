package com.example.kancollewiki.adapter;

import android.view.View;

import com.example.kancollewiki.bean.ship.Ship;
import com.example.kancollewiki.util.Utils;
import com.marshalchen.ultimaterecyclerview.UltimateDifferentViewTypeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/9/25.
 */
public class ShipBuildBinder extends ShipDetailFragmentBinder{
    List<String> build;
    public ShipBuildBinder(UltimateDifferentViewTypeAdapter dataBindAdapter, Ship ship) {
        super(dataBindAdapter, ship);
        initData();

    }

    private void initData() {
        build = new ArrayList<>();
        if (ship.isCanBuild()) {
            build.add("普通建造");
        } else {
            build.add("不可建造");
            return;
        }
        if (ship.isCanLargeBuild()) {
            build.add("大型建造");
        }
    }

    @Override
    public void bindViewHolder(ShipDetailFragmentViewHolder shipDetailFragmentViewHolder, final int i) {
        shipDetailFragmentViewHolder.setOnItemClickListener(new ShipDetailFragmentViewHolder.HolderClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Utils.log("click in build " + i + " >> " + build.get(i) + " <<");
            }
        });
        shipDetailFragmentViewHolder.setImageInvisible();
        shipDetailFragmentViewHolder.setTv_dataInvisible();
        shipDetailFragmentViewHolder.tv_name.setText(build.get(i));
    }

    @Override
    public int getItemCount() {
        return build.size();
    }
}
