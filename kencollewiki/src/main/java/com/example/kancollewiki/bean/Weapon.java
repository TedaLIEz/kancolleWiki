package com.example.kancollewiki.bean;

import android.graphics.drawable.Drawable;

import com.example.kancollewiki.C;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2015/9/15.
 * 装备数据
 */
public class Weapon implements Serializable{
    private int id = C.WEAPON_ID;
    private int pid = C.SHIP_ID;
    private String name;
    private String performance;
    private List<Drawable> drawables;
    private List<String> ships;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public List<Drawable> getDrawables() {
        return drawables;
    }

    public void setDrawables(List<Drawable> drawables) {
        this.drawables = drawables;
    }

    public List<String> getShips() {
        return ships;
    }

    public void setShips(List<String> ships) {
        this.ships = ships;
    }
}
