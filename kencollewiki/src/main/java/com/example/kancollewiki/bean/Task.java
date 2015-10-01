package com.example.kancollewiki.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/10/1.
 */
public class Task implements Serializable{
    private String al;
    private List<String> bonus = new ArrayList<>();
    private String bullet;
    private String comment;
    private String fuel;
    private String id;
    private String pid;
    private String steel;
    private String task_detail_jp;
    private String task_detail_zh;
    private String task_name_jp;
    private String task_name_zh;


    @Override
    public String toString() {
        return "Task{" +
                "al='" + al + '\'' +
                ", bonus=" + bonus +
                ", bullet='" + bullet + '\'' +
                ", comment='" + comment + '\'' +
                ", fuel='" + fuel + '\'' +
                ", id='" + id + '\'' +
                ", pid='" + pid + '\'' +
                ", steel='" + steel + '\'' +
                ", task_detail_jp='" + task_detail_jp + '\'' +
                ", task_detail_zh='" + task_detail_zh + '\'' +
                ", task_name_jp='" + task_name_jp + '\'' +
                ", task_name_zh='" + task_name_zh + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (al != null ? !al.equals(task.al) : task.al != null) return false;
        if (bonus != null ? !bonus.equals(task.bonus) : task.bonus != null) return false;
        if (bullet != null ? !bullet.equals(task.bullet) : task.bullet != null) return false;
        if (comment != null ? !comment.equals(task.comment) : task.comment != null) return false;
        if (fuel != null ? !fuel.equals(task.fuel) : task.fuel != null) return false;
        if (id != null ? !id.equals(task.id) : task.id != null) return false;
        if (pid != null ? !pid.equals(task.pid) : task.pid != null) return false;
        if (steel != null ? !steel.equals(task.steel) : task.steel != null) return false;
        if (task_detail_jp != null ? !task_detail_jp.equals(task.task_detail_jp) : task.task_detail_jp != null)
            return false;
        if (task_detail_zh != null ? !task_detail_zh.equals(task.task_detail_zh) : task.task_detail_zh != null)
            return false;
        if (task_name_jp != null ? !task_name_jp.equals(task.task_name_jp) : task.task_name_jp != null)
            return false;
        return !(task_name_zh != null ? !task_name_zh.equals(task.task_name_zh) : task.task_name_zh != null);

    }

    @Override
    public int hashCode() {
        int result = al != null ? al.hashCode() : 0;
        result = 31 * result + (bonus != null ? bonus.hashCode() : 0);
        result = 31 * result + (bullet != null ? bullet.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (fuel != null ? fuel.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (pid != null ? pid.hashCode() : 0);
        result = 31 * result + (steel != null ? steel.hashCode() : 0);
        result = 31 * result + (task_detail_jp != null ? task_detail_jp.hashCode() : 0);
        result = 31 * result + (task_detail_zh != null ? task_detail_zh.hashCode() : 0);
        result = 31 * result + (task_name_jp != null ? task_name_jp.hashCode() : 0);
        result = 31 * result + (task_name_zh != null ? task_name_zh.hashCode() : 0);
        return result;
    }

    public String getAl() {

        return al;
    }

    public void setAl(String al) {
        this.al = al;
    }

    public List<String> getBonus() {
        return bonus;
    }

    public void setBonus(List<String> bonus) {
        this.bonus = bonus;
    }
    public void addBouns(String bonus) {
        this.bonus.add(bonus);
    }
    public String getBullet() {
        return bullet;
    }

    public void setBullet(String bullet) {
        this.bullet = bullet;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getSteel() {
        return steel;
    }

    public void setSteel(String steel) {
        this.steel = steel;
    }

    public String getTask_detail_jp() {
        return task_detail_jp;
    }

    public void setTask_detail_jp(String task_detail_jp) {
        this.task_detail_jp = task_detail_jp;
    }

    public String getTask_detail_zh() {
        return task_detail_zh;
    }

    public void setTask_detail_zh(String task_detail_zh) {
        this.task_detail_zh = task_detail_zh;
    }

    public String getTask_name_jp() {
        return task_name_jp;
    }

    public void setTask_name_jp(String task_name_jp) {
        this.task_name_jp = task_name_jp;
    }

    public String getTask_name_zh() {
        return task_name_zh;
    }

    public void setTask_name_zh(String task_name_zh) {
        this.task_name_zh = task_name_zh;
    }


}
