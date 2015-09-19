package com.example.kancollewiki.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/9/18.
 */
public class News implements Serializable{
    private String content;
    private String date;
    public News (){}
    public News(String content, String date) {

        this.content = content;
        this.date = date;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
