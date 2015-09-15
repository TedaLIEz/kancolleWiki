package com.example.kancollewiki.util;


import com.example.kancollewiki.annotation.ShipNodeId;
import com.example.kancollewiki.annotation.ShipNodeLabel;
import com.example.kancollewiki.annotation.ShipNodePid;
import com.example.kancollewiki.bean.Node;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guojian on 15-2-11.
 */
public class TreeHelper {
    /*
    获取最后的树状节点
     */
    public static <T> List<Node> getSortedNodes(List<T> datas,int defaultExpandLevel) throws IllegalArgumentException,IllegalAccessException{
        List<Node> result=new ArrayList<Node>();
        List<Node> nodes=convertDatas2Nodes(datas);
        List<Node> rootNodes=getRootNodes(nodes);
        for(Node node:rootNodes){
            addNode(result,node,defaultExpandLevel,1);
        }
        return result;
    }

    /*
    过滤出可见的节点
     */
    public static List<Node> filterVisibleNodes(List<Node> nodes){
        List<Node> result=new ArrayList<Node>();
        for(Node node:nodes){
            if(node.isRoot()||node.isParentExpand()){
                setNodeIcon(node);
                result.add(node);
            }
        }
        return result;
    }

    public static <T> List<Node> convertDatas2Nodes(List<T> datas) throws IllegalAccessException {
        List<Node> nodes=new ArrayList<Node>();
        Node node=null;
        for (T t:datas){
            int id=-1;
            int pid=-1;
            String label=null;
            node = new Node();
            //反射加注解获得Id,PId,label
            Class clazz=t.getClass();
            Field[] fields=clazz.getDeclaredFields();
            for(Field field:fields){
                if(field.getAnnotation(ShipNodeId.class)!=null){
                    field.setAccessible(true);
                    id=field.getInt(t);
                }
                if(field.getAnnotation(ShipNodePid.class)!=null){
                    field.setAccessible(true);
                    pid=field.getInt(t);
                }
                if(field.getAnnotation(ShipNodeLabel.class)!=null){
                    field.setAccessible(true);
                    label=(String)field.get(t);
                }

            }
            node=new Node(id,pid,label);
            nodes.add(node);

        }
        /*
        设置NODE间节点关系
         */
        for(int i=0;i<nodes.size();i++){
            Node n=nodes.get(i);
            for(int j=i+1;j<nodes.size();j++){
                Node m=nodes.get(j);
                if(m.getPid()==n.getId()){
                    n.getChildren().add(m);
                    m.setParent(n);
                }else if(m.getId()==n.getPid()){
                    m.getChildren().add(n);
                    n.setParent(m);
                }
            }
        }
        for(Node n:nodes){
            setNodeIcon(n);
        }


        return nodes;
    }

    private static void setNodeIcon(Node n) {
        if(n.getChildren().size()>0&&n.isExpand()){
            n.setIcon(android.R.drawable.star_off);
        }else if(n.getChildren().size()>0&&!n.isExpand()){
            n.setIcon(android.R.drawable.star_on);
        }else{
            n.setIcon(-1);
        }
    }





    /*
    添加节点及其子节点
     */
    private static void addNode(List<Node> result, Node node, int defaultExpandLevel, int currentLevel) {
        result.add(node);
        if(defaultExpandLevel>=currentLevel){
            node.setExpand(true);
        }
        if(node.isLeaf()){
            return;
        }
        for(int i=0;i<node.getChildren().size();i++){
            addNode(result,node.getChildren().get(i),defaultExpandLevel,currentLevel+1);
        }
    }

    private static List<Node> getRootNodes(List<Node> nodes) {
        List<Node> root=new ArrayList<Node>();
        for(Node node:nodes){
            if(node.isRoot()){
                root.add(node);
            }
        }
        return root;

    }

}
