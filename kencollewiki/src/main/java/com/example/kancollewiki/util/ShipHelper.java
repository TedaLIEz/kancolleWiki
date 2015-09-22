package com.example.kancollewiki.util;

import com.example.kancollewiki.bean.ship.Ship;
import com.example.kancollewiki.bean.ship.ShipClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/9/15.
 */
public class ShipHelper {

    public static ShipClass getShipClass(Ship ship) {
        return ship.getAbstractShipClass().getShipClass();
    }
    public static List<String> initDetail(Ship ship) {
        ArrayList<String> details = new ArrayList<>();
        details.add("");
        details.add("");
        details.add("");
        details.add(ship.getShipClass().getName());
        details.add(String.valueOf(ship.getRange()));
        if (ship.isCanUpdate()) {
            details.add(String.valueOf(ship.getUpdateLevel()));
            details.add(ship.getUpdateCost());
        }
        details.add(ship.getAttackCost());
        return details;
    }
}
