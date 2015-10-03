package com.example.kancollewiki.util;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.kancollewiki.MyApp;
import com.example.kancollewiki.bean.Task;
import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappydbException;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2015/9/26.
 */
public class SnappyDBHelper {
    private static DB db;
    public static void init(Context myApp){
        try {
            db = DBFactory.open(myApp);
        } catch (SnappydbException e) {
            e.printStackTrace();
        }
    }

    public static DB getDb() {
        if (db != null) {
            return db;
        } else {
            throw new IllegalStateException("db init failed");
        }
    }

    public static void closeDb() {
        try {
            db.close();
        } catch (SnappydbException e) {
            e.printStackTrace();
        }

    }


    public static List findDatasById(String key, Class clazz) {
        List datas = new ArrayList();
        try {
            String keys[] = db.findKeys(key);
            for (String s : keys) {
                datas.add(db.getObject(s,clazz));
            }
            return datas;
        } catch (SnappydbException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    public static Object findItemById(String key, Class clazz) {
        try {
            return db.get(key, clazz);
        } catch (SnappydbException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
