package com.example.kancollewiki.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.example.kancollewiki.adapter.BaseListAdapter;
import com.example.kancollewiki.bean.Crusade;
import com.example.kancollewiki.fragment.BaseFragment;

import java.util.List;

/**
 * Created by Administrator on 2015/9/29.
 */
public class JsonManager {
    private static final int LOAD_SUCCESS = 0;
    private static final int LOAD_FAILED = 1;
    private static JsonManager sInstance = null;
    private Handler mHandler;
    private JsonDataLoad jsonDataLoad;
    static {
        sInstance = new JsonManager();
    }
    public interface JsonDataLoad<T> {
        void onDataLoadSuccess(List<T> datas);

        void onDataLoadFailed();
    }
    private JsonManager() {
        mHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                JsonTask jsonTask = (JsonTask) msg.obj;
                List datas = jsonTask.getData();
                switch (msg.what) {
                    case LOAD_SUCCESS :
//                        baseFragment.onDataLoadSuccess(datas);
                        jsonDataLoad.onDataLoadSuccess(datas);
                        break;
                    case LOAD_FAILED :
//                        baseFragment.onDataLoadFailed();
                        jsonDataLoad.onDataLoadFailed();
                        break;
                    default:
                        super.handleMessage(msg);
                        break;
                }

            }
        };
    }

    public static JsonManager getInstance() {
        return sInstance;
    }

    public void setJsonDataLoad(JsonDataLoad jsonDataLoad) {
        this.jsonDataLoad = jsonDataLoad;
    }

    public void handleState(JsonTask jsonTask, int state) {
        switch (state) {
            case LOAD_SUCCESS :
                Message completeMessage = mHandler.obtainMessage(state, jsonTask);
                completeMessage.sendToTarget();
                break;
        }
    }

    public void startLoadCrusade(JsonDataLoad jsonDataLoad) {
        setJsonDataLoad(jsonDataLoad);
        JsonTask jsonTask = new JsonTask(this);

    }
}
