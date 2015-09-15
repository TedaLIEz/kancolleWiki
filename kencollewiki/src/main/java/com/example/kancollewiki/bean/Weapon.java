package com.example.kancollewiki.bean;

import android.graphics.drawable.Drawable;

import com.example.kancollewiki.C;

import java.util.List;

/**
 * Created by Administrator on 2015/9/15.
 * 装备数据
 */
public class Weapon {
    private int id = C.WEAPON_ID;
    private int pid = C.SHIP_ID;
    private String name;
    private String performance;
    private List<Drawable> drawables;
    private List<String> ships;
}
