package com.example.kancollewiki;

import android.app.Application;

import com.example.kancollewiki.util.NoSQLHelper;
import com.example.kancollewiki.util.JSONHelper;
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
        NoSQLHelper.init(this);
        JSONHelper.init(this);
    }


}
