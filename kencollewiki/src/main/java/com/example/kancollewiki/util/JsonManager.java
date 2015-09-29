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
    private BaseListAdapter baseListAdapter;
    private Handler mHandler;
    static {
        sInstance = new JsonManager();
    }

    private JsonManager() {
        mHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                JsonTask jsonTask = (JsonTask) msg.obj;
                BaseFragment baseFragment = jsonTask.getBaseFragment();
                List<Crusade> datas = jsonTask.getData();
                switch (msg.what) {
                    case LOAD_SUCCESS :
//                        baseFragment.onDataLoadSuccess(datas);
                        break;
                    case LOAD_FAILED :
//                        baseFragment.onDataLoadFailed();
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

    public void handleState(JsonTask jsonTask, int state) {
        switch (state) {
            case LOAD_SUCCESS :
                Message completeMessage = mHandler.obtainMessage(state, jsonTask);
                completeMessage.sendToTarget();
                break;
        }
    }
}
