package com.example.kancollewiki.fragment;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.kancollewiki.R;
import com.example.kancollewiki.adapter.CrusadeListAdapter;
import com.example.kancollewiki.bean.Crusade;
import com.example.kancollewiki.util.JSONHelper;
import com.example.kancollewiki.util.JsonManager;
import com.example.kancollewiki.util.JsonTask;
import com.example.kancollewiki.util.LoadCrusadeRunnable;
import com.example.kancollewiki.util.Utils;


import java.util.ArrayList;
import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class CrusadeFragment extends BaseFragment implements JsonManager.JsonDataLoad<Crusade>{
    StickyListHeadersListView stickyListHeadersListView;
    CrusadeListAdapter crusadeListAdapter;
    private static final int MSG_SUCCESS = 0;
    List<Crusade> datas;
    private JsonManager jsonManager;
    ProgressDialog pd;
    public CrusadeFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        datas = new ArrayList<>();
        crusadeListAdapter = new CrusadeListAdapter(getActivity(),datas);
        jsonManager = JsonManager.getInstance();
        jsonManager.setJsonDataLoad(this);
        JsonTask jsonTask = new JsonTask(jsonManager);
        new Thread(new LoadCrusadeRunnable(jsonTask)).run();
        pd = new ProgressDialog(getActivity());
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setMessage("Loading...");
        pd.show();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_crusade, container, false);
        stickyListHeadersListView = (StickyListHeadersListView) rootView.findViewById(R.id.lv_task);
//        crusadeListAdapter.notifyDataSetChanged();
        stickyListHeadersListView.setAdapter(crusadeListAdapter);
        stickyListHeadersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Utils.log("click in crusade----- " + position + "---------");
                Crusade item = (Crusade) parent.getAdapter().getItem(position);
                showDialog(item);
                Utils.log(item.toString());
            }
        });
//        Utils.log("update time" + SystemClock.uptimeMillis());
        return rootView;
    }

    private void showDialog(Crusade item) {

    }

    @Override
    public void onDataLoadSuccess(List<Crusade> datas) {
        crusadeListAdapter.addAll(datas);
        Utils.log("load json data success" + datas.size());
        pd.dismiss();
    }

    @Override
    public void onDataLoadFailed() {
        Utils.log("load json failed");
        pd.dismiss();
    }


}
