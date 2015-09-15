package com.example.kancollewiki.bean;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by guojian on 15-2-11.
 */
public class Node {
    private int id;
    private int pid=0;
    private String name;
    private int level;
    private boolean isExpand=false;
    private int icon;
    private Node parent;
    private List<Node> children =new ArrayList<Node>();
    public Node(){

    }

    public Node(int id, int pid, String name) {
        this.id = id;
        this.pid = pid;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public Node getParent() {
        return parent;
    }
    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
    public boolean isRoot(){
        return parent==null;
    }

    public boolean isParentExpand(){
        if(parent==null){
            return false;
        }
        return parent.isExpand;
    }
    public boolean isLeaf(){
        return children.size()==0;
    }

    public int getLevel() {
        return parent==null?0:parent.getLevel()+1;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean isExpand) {
        this.isExpand = isExpand;
        if(!isExpand){
            for(Node node:children){
                node.setExpand(false);
            }
        }
    }

}
