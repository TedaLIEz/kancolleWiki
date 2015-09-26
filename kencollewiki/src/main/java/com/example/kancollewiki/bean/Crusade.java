package com.example.kancollewiki.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/9/26.
 */
public class Crusade implements Serializable{
    private int id;
    private int pid;
    private String ad_exp;
    private String al;
    private String bonus;
    private String bucket;
    private String bullet;
    private String bullet_cost;
    private String flagship_lv;
    private String fuel;
    private String fuel_cost;
    private String name_jp;
    private String name_zh;
    private String neccShip;
    private String ship_exp;
    private String steel;
    private String time;
    private String total_lv;
    public Crusade() {

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Crusade crusade = (Crusade) o;

        if (id != crusade.id) return false;
        if (pid != crusade.pid) return false;
        if (ad_exp != null ? !ad_exp.equals(crusade.ad_exp) : crusade.ad_exp != null) return false;
        if (al != null ? !al.equals(crusade.al) : crusade.al != null) return false;
        if (bonus != null ? !bonus.equals(crusade.bonus) : crusade.bonus != null) return false;
        if (bucket != null ? !bucket.equals(crusade.bucket) : crusade.bucket != null) return false;
        if (bullet != null ? !bullet.equals(crusade.bullet) : crusade.bullet != null) return false;
        if (bullet_cost != null ? !bullet_cost.equals(crusade.bullet_cost) : crusade.bullet_cost != null)
            return false;
        if (flagship_lv != null ? !flagship_lv.equals(crusade.flagship_lv) : crusade.flagship_lv != null)
            return false;
        if (fuel != null ? !fuel.equals(crusade.fuel) : crusade.fuel != null) return false;
        if (fuel_cost != null ? !fuel_cost.equals(crusade.fuel_cost) : crusade.fuel_cost != null)
            return false;
        if (name_jp != null ? !name_jp.equals(crusade.name_jp) : crusade.name_jp != null) return false;
        if (name_zh != null ? !name_zh.equals(crusade.name_zh) : crusade.name_zh != null) return false;
        if (neccShip != null ? !neccShip.equals(crusade.neccShip) : crusade.neccShip != null)
            return false;
        if (ship_exp != null ? !ship_exp.equals(crusade.ship_exp) : crusade.ship_exp != null)
            return false;
        if (steel != null ? !steel.equals(crusade.steel) : crusade.steel != null) return false;
        if (time != null ? !time.equals(crusade.time) : crusade.time != null) return false;
        return !(total_lv != null ? !total_lv.equals(crusade.total_lv) : crusade.total_lv != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + pid;
        result = 31 * result + (ad_exp != null ? ad_exp.hashCode() : 0);
        result = 31 * result + (al != null ? al.hashCode() : 0);
        result = 31 * result + (bonus != null ? bonus.hashCode() : 0);
        result = 31 * result + (bucket != null ? bucket.hashCode() : 0);
        result = 31 * result + (bullet != null ? bullet.hashCode() : 0);
        result = 31 * result + (bullet_cost != null ? bullet_cost.hashCode() : 0);
        result = 31 * result + (flagship_lv != null ? flagship_lv.hashCode() : 0);
        result = 31 * result + (fuel != null ? fuel.hashCode() : 0);
        result = 31 * result + (fuel_cost != null ? fuel_cost.hashCode() : 0);
        result = 31 * result + (name_jp != null ? name_jp.hashCode() : 0);
        result = 31 * result + (name_zh != null ? name_zh.hashCode() : 0);
        result = 31 * result + (neccShip != null ? neccShip.hashCode() : 0);
        result = 31 * result + (ship_exp != null ? ship_exp.hashCode() : 0);
        result = 31 * result + (steel != null ? steel.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (total_lv != null ? total_lv.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getAd_exp() {
        return ad_exp;
    }

    public void setAd_exp(String ad_exp) {
        this.ad_exp = ad_exp;
    }

    public String getAl() {
        return al;
    }

    public void setAl(String al) {
        this.al = al;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getBullet() {
        return bullet;
    }

    public void setBullet(String bullet) {
        this.bullet = bullet;
    }

    public String getBullet_cost() {
        return bullet_cost;
    }

    public void setBullet_cost(String bullet_cost) {
        this.bullet_cost = bullet_cost;
    }

    public String getFlagship_lv() {
        return flagship_lv;
    }

    public void setFlagship_lv(String flagship_lv) {
        this.flagship_lv = flagship_lv;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getFuel_cost() {
        return fuel_cost;
    }

    public void setFuel_cost(String fuel_cost) {
        this.fuel_cost = fuel_cost;
    }

    public String getName_jp() {
        return name_jp;
    }

    public void setName_jp(String name_jp) {
        this.name_jp = name_jp;
    }

    public String getName_zh() {
        return name_zh;
    }

    public void setName_zh(String name_zh) {
        this.name_zh = name_zh;
    }

    public String getNeccShip() {
        return neccShip;
    }

    public void setNeccShip(String neccShip) {
        this.neccShip = neccShip;
    }

    public String getShip_exp() {
        return ship_exp;
    }

    public void setShip_exp(String ship_exp) {
        this.ship_exp = ship_exp;
    }

    public String getSteel() {
        return steel;
    }

    public void setSteel(String steel) {
        this.steel = steel;
    }

    public String getTime() {
        return time + ":00";
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTotal_lv() {
        return total_lv;
    }

    @Override
    public String toString() {
        return "Crusade{" +
                "id=" + id +
                ", pid=" + pid +
                ", ad_exp='" + ad_exp + '\'' +
                ", al='" + al + '\'' +
                ", bonus='" + bonus + '\'' +
                ", bucket='" + bucket + '\'' +
                ", bullet='" + bullet + '\'' +
                ", bullet_cost='" + bullet_cost + '\'' +
                ", flagship_lv='" + flagship_lv + '\'' +
                ", fuel='" + fuel + '\'' +
                ", fuel_cost='" + fuel_cost + '\'' +
                ", name_jp='" + name_jp + '\'' +
                ", name_zh='" + name_zh + '\'' +
                ", neccShip='" + neccShip + '\'' +
                ", ship_exp='" + ship_exp + '\'' +
                ", steel='" + steel + '\'' +
                ", time='" + time + '\'' +
                ", total_lv='" + total_lv + '\'' +
                '}';
    }

    public void setTotal_lv(String total_lv) {
        this.total_lv = total_lv;
    }
}
