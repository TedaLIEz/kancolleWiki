package com.example.kancollewiki;

import android.app.Application;

import com.example.kancollewiki.util.PicJsonArray;
import com.example.kancollewiki.util.RequestManager;

/**
 * Created by Administrator on 2015/9/14.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        RequestManager.init(this);
        PicJsonArray.init(this);
    }


}
