package com.example.kancollewiki.bean.ship;

import com.example.kancollewiki.C;

/**
 * Created by Administrator on 2015/9/15.‘
 * Ship for DD
 */
public final class DDShip extends ShipClass{
    private int range = C.SHORT_RANGE;
    private static final DDShip ddShip = new DDShip();

    private DDShip(){}
    public static DDShip getInstance()
    {
        return ddShip;
    }
    @Override
    public int getRange() {
        return range;
    }

    @Override
    public int getId() {
        return C.DD_ID;
    }

    @Override
    public String getName() {
        return C.DD;
    }


    @Override
    public int getPid() {
        return C.SHIP_ROOT_PID;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        return 31 * result + range;
    }

    @Override
    public String toString() {
        return getName();
    }
}
