package com.example.kancollewiki.bean;

import android.graphics.drawable.Drawable;

import com.example.kancollewiki.C;
import com.example.kancollewiki.annotation.ShipNodeId;
import com.example.kancollewiki.annotation.ShipNodeLabel;
import com.example.kancollewiki.annotation.ShipNodePid;

import java.util.List;

/**
 * Created by Administrator on 2015/9/15.
 * 装备数据
 */
public class Weapon {
    @ShipNodeId
    private int id = C.WEAPON_ID;
    @ShipNodePid
    private int pid = C.SHIP_ID;
    @ShipNodeLabel
    private String name;
    private String performance;
    private List<Drawable> drawables;
    private List<String> ships;
}
