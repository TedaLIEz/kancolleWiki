package com.example.kancollewiki.util;

import com.example.kancollewiki.bean.ship.Ship;
import com.example.kancollewiki.bean.ship.ShipClass;

/**
 * Created by Administrator on 2015/9/15.
 */
public class ShipHelper {
    public static ShipClass getShipClass(Ship ship) {
        return ship.getAbstractShipClass().getShipClass();
    }
}
