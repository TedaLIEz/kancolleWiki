package com.example.kancollewiki.util;

import android.content.Context;

import com.example.kancollewiki.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2015/9/20.
 */
public class PicJsonArray {
    private static JSONObject picJsonObject;


    public static void init(Context ctx) {
        InputStream inputStream = ctx.getResources().openRawResource(R.raw.ship_img);
        try {
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            String json = new String(buffer);
            picJsonObject = new JSONObject(json);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public static JSONObject getJsonObject() {
        if (picJsonObject != null) {
            return picJsonObject;
        } else {
            throw new IllegalStateException("Json init may not process successfully");
        }
    }

}
