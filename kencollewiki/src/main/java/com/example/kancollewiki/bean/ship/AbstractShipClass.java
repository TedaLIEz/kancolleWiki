package com.example.kancollewiki.bean.ship;


/**
 * Created by Administrator on 2015/9/15.
 * 舰种数据结构(XX型)
 */
public final class AbstractShipClass extends ShipClass implements Comparable<AbstractShipClass>{
    private ShipClass shipClass;
    private String name;
    private int id;
    private int pid;

    public int getRange() {
        return range;
    }

    public int getPid() {
        return pid;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ShipClass getShipClass() {
        return shipClass;
    }

    private int range;

    public AbstractShipClass(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.pid = builder.pid;
        this.range = builder.range;
        this.shipClass = builder.shipClass;
    }

    @Override
    public int compareTo(AbstractShipClass another) {
        return id - another.id;
    }

    public static class Builder {
        private ShipClass shipClass;
        private String name;
        private int id;
        private int pid;
        private int range;
        public Builder createClass(ShipClass shipClass, int id, String name) {
            this.shipClass = shipClass;
            this.name = name;
            this.id = id;
            this.pid = shipClass.getId();
            this.range = shipClass.getRange();
            return this;
        }
        public AbstractShipClass build() {
            return new AbstractShipClass(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            if (o instanceof AbstractShipClass) {
                AbstractShipClass abstractShipClass = (AbstractShipClass)o;
                return id == abstractShipClass.getId();
            }
            return false;
        }
        return false;

    }

    @Override
    public int hashCode() {
        int shipHash = shipClass.hashCode();
        int result = 17;
        result = result * 31 + shipHash;
        int nameHash = name.hashCode();
        result = result * 31 + nameHash;
        result = result * 31 + id;
        result = result * 31 + pid;
        return result;
    }

    @Override
    public String toString() {
        return "舰种: " + name + shipClass.toString();
    }
}
