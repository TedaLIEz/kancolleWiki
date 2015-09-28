package com.example.kancollewiki.util;

import android.os.AsyncTask;

import java.util.List;

/**
 * Created by Administrator on 2015/9/28.
 */
public abstract class LoadJsonAsyncTask extends AsyncTask<Void, Void, List>{

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(List list) {
        super.onPostExecute(list);
    }

    @Override
    protected List doInBackground(Void... params) {
        try {
            doInBack();
        } catch (Exception e) {
            Utils.log("load json error" + e.getMessage());
        }
        return null;
    }

    protected abstract void doInBack();
}
