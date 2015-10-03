package com.example.kancollewiki.bean.level;

/**
 * Created by Administrator on 2015/10/3.
 */
public class Enemy {
    String place;
    String name;
    String formation;
    String air;
    String air_advantage;
    String air_confirm;

    @Override
    public String toString() {
        return "Enemy{" +
                "place='" + place + '\'' +
                ", name='" + name + '\'' +
                ", formation='" + formation + '\'' +
                ", air='" + air + '\'' +
                ", air_advantage='" + air_advantage + '\'' +
                ", air_confirm='" + air_confirm + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Enemy enemy = (Enemy) o;

        if (place != null ? !place.equals(enemy.place) : enemy.place != null) return false;
        if (name != null ? !name.equals(enemy.name) : enemy.name != null) return false;
        if (formation != null ? !formation.equals(enemy.formation) : enemy.formation != null)
            return false;
        if (air != null ? !air.equals(enemy.air) : enemy.air != null) return false;
        if (air_advantage != null ? !air_advantage.equals(enemy.air_advantage) : enemy.air_advantage != null)
            return false;
        return !(air_confirm != null ? !air_confirm.equals(enemy.air_confirm) : enemy.air_confirm != null);

    }

    @Override
    public int hashCode() {
        int result = place != null ? place.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (formation != null ? formation.hashCode() : 0);
        result = 31 * result + (air != null ? air.hashCode() : 0);
        result = 31 * result + (air_advantage != null ? air_advantage.hashCode() : 0);
        result = 31 * result + (air_confirm != null ? air_confirm.hashCode() : 0);
        return result;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public String getAir() {
        return air;
    }

    public void setAir(String air) {
        this.air = air;
    }

    public String getAir_advantage() {
        return air_advantage;
    }

    public void setAir_advantage(String air_advantage) {
        this.air_advantage = air_advantage;
    }

    public String getAir_confirm() {
        return air_confirm;
    }

    public void setAir_confirm(String air_confirm) {
        this.air_confirm = air_confirm;
    }
}
