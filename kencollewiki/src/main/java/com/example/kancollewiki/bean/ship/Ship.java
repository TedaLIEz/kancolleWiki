package com.example.kancollewiki.bean.ship;


import com.example.kancollewiki.bean.Locations;
import com.example.kancollewiki.bean.Weapon;

import java.util.List;

/**
 * Created by Administrator on 2015/9/15.
 * 舰娘
 *
 */
public final class Ship extends ShipClass implements Comparable<Ship>{
    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    private String pic_url;
    private int id;
    //对应XX型id
    private int pid;
    private String name;
    //能否改造
    private boolean canUpdate;
    //舰种
    private ShipClass shipClass;
    private boolean isUpdate;
    private int updateLevel;
    private String updateCost;
    private String attackCost;
    private int updateTime = 0;
    private int maxUpdate = Integer.MAX_VALUE;
    //舰型
    private AbstractShipClass abstractShipClass;
    //装备
    private List<Weapon> weapons;
    //掉落
    private List<Locations> locations;
    //数据
    private ShipDataBean bean;
    //射程
    private int range;



    public AbstractShipClass getAbstractShipClass() {
        return abstractShipClass;
    }

    public int getId() {
        return id;
    }

    public int getPid() {
        return pid;
    }
    @Override
    public String getName() {
        return name;
    }

    public boolean isCanUpdate() {
        return canUpdate;
    }

    public ShipClass getShipClass() {
        return shipClass;
    }


    public boolean isUpdate() {
        return isUpdate;
    }

    public int getUpdateLevel() {
        return updateLevel;
    }

    public String getUpdateCost() {
        return updateCost;
    }

    public String getAttackCost() {
        return attackCost;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public List<Locations> getLocations() {
        return locations;
    }

    public int getRange() {
        return range;
    }




    public Ship(Builder builder) {
        id = builder.id;
        pid = builder.pid;
        name = builder.name;
        abstractShipClass = builder.abstractShipClass;
        canUpdate = builder.canUpdate;
        isUpdate = builder.isUpdate;
        updateLevel = builder.updateLevel;
        updateCost = builder.updateCost;
        attackCost = builder.attackCost;
        weapons = builder.weapons;
        locations = builder.locations;
        shipClass = builder.shipClass;
        range = shipClass.getRange();
        bean = builder.bean;
        isAbstract = false;
    }

    @Override
    public int compareTo(Ship another) {
        if (abstractShipClass.getId() - another.abstractShipClass.getId() < 0) {
            return -1;
        } else if(abstractShipClass.getId() == another.abstractShipClass.getId()){
            return id - another.getId();
        } else {
            return 1;
        }
    }


    public static class Builder {
        private int id;
        private int pid;
        private boolean canUpdate = true;
        private boolean isUpdate = false;
        private int updateLevel;
        private String updateCost;
        private String attackCost;
        private List<Weapon> weapons = null;
        private List<Locations> locations = null;
        private String name;
        private int range;
        private ShipClass shipClass;
        private AbstractShipClass abstractShipClass;
        private ShipDataBean bean;
        /**
         * 构造舰娘
         * @param id
         * @param name 名称
         * @param canUpdate 能否改造
         * @return
         */
        public Builder createShipGirl(AbstractShipClass abstractShipClass, int id, String name, boolean canUpdate) {
            this.shipClass = abstractShipClass.getShipClass();
            this.abstractShipClass = abstractShipClass;
            this.range = shipClass.getRange();
            this.id = id;
            this.pid = abstractShipClass.getId();
            this.name = name;
            this.canUpdate = canUpdate;
            return this;
        }
        public Builder attackCost(String attackCost) {
            this.attackCost = attackCost;
            return this;
        }
        public Builder updateCost(String val) {
            if (canUpdate) {
                this.updateCost = val;
            }
            return this;
        }
        public Builder dataBean(ShipDataBean bean) {
            this.bean = bean;
            return this;
        }
        public Builder updateLevel(int val) {
            if (canUpdate) {
                this.updateLevel = val;
            }
            return this;
        }
        public Builder isUpdate(boolean isUpdate) {
            this.isUpdate = isUpdate;
            return this;
        }
        public Ship build() {
            return new Ship(this);
        }
    }

    @Override
    public String toString() {
        String shipName = abstractShipClass.getName() +id + "番舰" + shipClass.getName() + name;
        if (isUpdate) {
            shipName = shipName + "我已经改造过了";
        } else {
            shipName = shipName + "我还没改造";
        }
        if (canUpdate) {
            shipName = shipName + "我可以改造";
        } else {
            shipName = shipName + "我不能改造了";
        }
        return shipName;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Ship) {
            Ship ship = (Ship)o;
            return shipClass.getId() == ship.shipClass.getId() && abstractShipClass.getId() == ship.abstractShipClass.getId() && id == ship.getId();
        }
        return false;

    }

    @Override
    public int hashCode() {
        int result = 17;
        int absHash = abstractShipClass.hashCode();
        result = result * 31 + absHash;
        int classHash = shipClass.hashCode();
        result = result * 31 + classHash;
        int canUpdateHash = canUpdate ? 1 : 0;
        result = result * 31 + canUpdateHash;
        int updateHash = isUpdate ? 1 : 0;
        result = result * 31 + updateHash;
        int nameHash = name.hashCode();
        int updateCostHash = updateCost.hashCode();
        int attackHash = attackCost.hashCode();
        int weaponHash = weapons.hashCode();
        int locationHash = locations.hashCode();
        int beanHash = 0;
        if (bean != null) {
            beanHash = bean.hashCode();
        }
        result = result * 31 + nameHash;
        result = result * 31 + updateCostHash;
        result = result * 31 + attackHash;
        result = result * 31 + weaponHash;
        result = result * 31 + locationHash;
        result = result * 31 + range;
        result = result * 31 + beanHash;
        return result;
    }
}
