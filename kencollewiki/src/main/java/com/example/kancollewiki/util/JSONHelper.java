package com.example.kancollewiki.util;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.example.kancollewiki.R;
import com.example.kancollewiki.bean.Crusade;
import com.example.kancollewiki.bean.Task;
import com.snappydb.DB;
import com.snappydb.SnappydbException;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/9/20.
 */
public class JSONHelper {
    private static JSONObject picJsonObject;
    private static JSONArray crusadeJsonArray;
    private static List<Crusade> crusade_datas;
    private static JSONObject taskJsonObject;
    private static List<Task> task_datas;
    private static Context context;
    public static void init(Context ctx) {
        context = ctx;
        InputStream inputStream = ctx.getResources().openRawResource(R.raw.ship_img);
        try {
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            String json = new String(buffer);
            picJsonObject = JSON.parseObject(json);
            Utils.log("Picjson loaded success");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        inputStream = ctx.getResources().openRawResource(R.raw.crusade);
        try {
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            String json = new String(buffer);
            crusadeJsonArray = JSON.parseArray(json);
            Utils.log("Crusadejson loaded success");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        crusade_datas = new ArrayList<>();
        for (int i = 0; i < crusadeJsonArray.size(); i++) {
            Crusade crusade = JSON.toJavaObject(crusadeJsonArray.getJSONObject(i),Crusade.class);
            crusade_datas.add(crusade);
        }
        Utils.log("crusade data init success");
        inputStream = ctx.getResources().openRawResource(R.raw.task);
        try {
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            String json = new String(buffer);
            taskJsonObject = JSON.parseObject(json);
            Utils.log("taskjson loaded success");
            PutTaskDataToDB(taskJsonObject);
            Utils.log("task db loaded success");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SnappydbException e) {
            e.printStackTrace();
        }


    }

    private static void PutTaskDataToDB(JSONObject taskJsonObject) throws SnappydbException {
        DB db = SnappyDBHelper.getDb();
        for (String s : taskJsonObject.keySet()) {
            JSONObject obj = taskJsonObject.getJSONObject(s);
            Task task = JSON.toJavaObject(obj, Task.class);
            db.put("task_" + task.getId(), task);
        }
    }

    public static JSONObject getPicJsonObject() {
        if (picJsonObject != null) {
            return picJsonObject;
        } else {
            throw new IllegalStateException("Json init may not process successfully");
        }
    }


    public static List<Crusade> getCrusadeDatas() {
        if (crusade_datas != null) {
            return crusade_datas;
        } else {
            throw new IllegalStateException("JsonArray init may not process successfully");
        }

    }

    public static JSONObject getTaskJsonObject() {
        if (taskJsonObject != null) {
            return taskJsonObject;
        } else {
            throw new IllegalStateException("Json init may not process successfully");
        }
    }
}
