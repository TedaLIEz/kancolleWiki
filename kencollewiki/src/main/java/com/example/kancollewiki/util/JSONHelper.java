package com.example.kancollewiki.util;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.example.kancollewiki.R;
import com.example.kancollewiki.bean.Crusade;


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
    private static List<Crusade> datas;

    public static void init(Context ctx) {
        InputStream inputStream = ctx.getResources().openRawResource(R.raw.ship_img);
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
        datas = new ArrayList<>();
        for (int i = 0; i < crusadeJsonArray.size(); i++) {
            Crusade crusade = JSON.toJavaObject(crusadeJsonArray.getJSONObject(i),Crusade.class);
            datas.add(crusade);
        }
        Utils.log("crusade data init success");
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


    }

    public static JSONObject getPicJsonObject() {
        if (picJsonObject != null) {
            return picJsonObject;
        } else {
            throw new IllegalStateException("Json init may not process successfully");
        }
    }
    public static List<Crusade> getDatas() {
        if (datas != null) {
            return datas;
        } else {
            throw new IllegalStateException("JsonArray init may not process successfully");
        }

    }
}
