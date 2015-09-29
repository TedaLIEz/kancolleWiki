package com.example.kancollewiki.util;

import com.example.kancollewiki.fragment.BaseFragment;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by Administrator on 2015/9/29.
 */
public class JsonTask implements LoadCrusadeRunnable.LoadCrusadeRunnableMethods{
    static final int LOAD_SUCCESS = 0;
    private static final int LOAD_FAILED = 1;
    private List<T> data;
    private WeakReference<BaseFragment> mBaseFragmentRef;


    interface JsonDataLoad<T> {
        void onDataLoadSuccess(List<T> datas);

        void onDataLoadFailed();
    }
    private static JsonManager jsonManager;

    public JsonTask() {
    }

    void initialzeTask(JsonManager jsonManager, BaseFragment baseFragment) {
        this.jsonManager = jsonManager;
        mBaseFragmentRef = new WeakReference<BaseFragment>(baseFragment);
    }

    @Override
    public void setData(List datas) {
        data = datas;
    }

    public List<T> getData() {
        return data;
    }

    public BaseFragment getBaseFragment() {
        if (mBaseFragmentRef != null) {
            return mBaseFragmentRef.get();
        }
        return null;
    }


    @Override
    public void handleState(int state) {
        switch (state) {
            case LOAD_SUCCESS :
                jsonManager.handleState(this, state);
                break;
            case LOAD_FAILED :
                break;
        }
    }


}
