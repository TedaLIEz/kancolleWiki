package com.example.kancollewiki.bean.ship;


import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by Administrator on 2015/9/14.
 * 船只抽象类
 */
public abstract class ShipClass implements Comparator<ShipClass>,Serializable{
    @Override
    public boolean equals(Object o) {
        ShipClass shipClass;
        if (o instanceof ShipClass) {
            shipClass = (ShipClass)o;
            return id == shipClass.getId();
        }
        return false;
    }

    @Override
    public int compare(ShipClass lhs, ShipClass rhs) {
        return lhs.getId() - rhs.getId();
    }
    private int id;
    private String name;
    private int pid;
    protected boolean isAbstract = true;

    public ShipClass() {

    }

    public abstract int getRange();
    public abstract int getId();

    public void setId(int id) {
        this.id = id;
    }

    public abstract String getName();

    public void setLabel(String name) {
        this.name = name;
    }

    public abstract int getPid();

    public  void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public int hashCode() {
        int result = 17;
        int bool = isAbstract ? 1 : 0;
        result = 31 * result + bool;
        int hash = name.hashCode();
        result = 31 * result + hash;
        result = 31 * result + pid;
        return result;
    }

    public abstract String toString();
}
