package com.example.kancollewiki.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.kancollewiki.R;
import com.example.kancollewiki.adapter.CrusadeListAdapter;
import com.example.kancollewiki.bean.Crusade;
import com.example.kancollewiki.util.JSONHelper;
import com.example.kancollewiki.util.Utils;


import java.util.ArrayList;
import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class CrusadeFragment extends BaseFragment{
    StickyListHeadersListView stickyListHeadersListView;
    CrusadeListAdapter crusadeListAdapter;
    volatile List<Crusade> datas;
    public CrusadeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_crusade, container, false);
        stickyListHeadersListView = (StickyListHeadersListView) rootView.findViewById(R.id.lv_task);
        datas = JSONHelper.getDatas();
        crusadeListAdapter = new CrusadeListAdapter(getActivity());
        crusadeListAdapter.setDatas(datas);
        stickyListHeadersListView.setAdapter(crusadeListAdapter);
        stickyListHeadersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Utils.log("click in crusade----- " + position + "---------");
                Crusade item = (Crusade) parent.getAdapter().getItem(position);
                Utils.log(item.toString());
            }
        });
        Utils.log("update time" + SystemClock.uptimeMillis());
        return rootView;
    }
}
