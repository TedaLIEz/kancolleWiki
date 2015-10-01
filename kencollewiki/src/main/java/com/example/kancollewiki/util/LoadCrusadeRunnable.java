package com.example.kancollewiki.util;

import android.os.*;
import android.widget.ListView;

import com.example.kancollewiki.bean.Crusade;

import java.util.List;

/**
 * Created by Administrator on 2015/9/29.
 */
public class LoadCrusadeRunnable implements Runnable {
    private static final int LOAD_SUCCESS = 0;
    private static final int LOAD_FAILED = 1;
    JsonTask jsonTask;

    public LoadCrusadeRunnable(JsonTask jsonTask) {
        this.jsonTask = jsonTask;
    }

    @Override
    public void run() {
        android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
        List<Crusade> datas = JSONHelper.getCrusadeDatas();
        if (datas != null && datas.size() != 0) {
            jsonTask.setData(datas);
            jsonTask.handleState(LOAD_SUCCESS);
        } else {
            jsonTask.handleState(LOAD_FAILED);
        }

    }
}
