package com.example.kancollewiki.bean.level;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/10/3.
 */
public class LevelDetail {
    String pic_url;
    ArrayList<Enemy> formations;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LevelDetail that = (LevelDetail) o;

        if (pic_url != null ? !pic_url.equals(that.pic_url) : that.pic_url != null) return false;
        if (formations != null ? !formations.equals(that.formations) : that.formations != null)
            return false;
        return !(droplist != null ? !droplist.equals(that.droplist) : that.droplist != null);

    }

    @Override
    public int hashCode() {
        int result = pic_url != null ? pic_url.hashCode() : 0;
        result = 31 * result + (formations != null ? formations.hashCode() : 0);
        result = 31 * result + (droplist != null ? droplist.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LevelDetail{" +
                "pic_url='" + pic_url + '\'' +
                ", formations=" + formations +
                ", droplist=" + droplist +
                '}';
    }

    ArrayList<String> droplist;
    public LevelDetail() {
    }
    public void addFormations(Enemy formations) {
        this.formations.add(formations);
    }

    public void addDropList(String droplist) {
        this.droplist.add(droplist);
    }
    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public ArrayList<Enemy> getFormations() {
        return formations;
    }

    public void setFormations(ArrayList<Enemy> formations) {
        this.formations = formations;
    }

    public ArrayList<String> getDroplist() {
        return droplist;
    }

    public void setDroplist(ArrayList<String> droplist) {
        this.droplist = droplist;
    }
}
