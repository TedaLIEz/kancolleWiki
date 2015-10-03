package com.example.kancollewiki.bean.level;

/**
 * Created by Administrator on 2015/10/3.
 */
public class Level {
    String pid;
    String id;
    String title;
    String hard;
    String exp;
    String bonus;
    String name;
    String content;
    LevelDetail detail;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHard() {
        return hard;
    }

    public void setHard(String hard) {
        this.hard = hard;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LevelDetail getDetail() {
        return detail;
    }

    public void setDetail(LevelDetail detail) {
        this.detail = detail;
    }

    public Level() {

    }
}
