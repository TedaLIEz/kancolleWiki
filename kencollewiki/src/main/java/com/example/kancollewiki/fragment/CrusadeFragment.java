package com.example.kancollewiki.fragment;

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
import com.example.kancollewiki.util.Utils;


import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class CrusadeFragment extends BaseFragment{
    StickyListHeadersListView stickyListHeadersListView;
    CrusadeListAdapter crusadeListAdapter;
    private static final int MSG_SUCCESS = 0;
    List<Crusade> datas;
    public CrusadeFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        crusadeListAdapter = new CrusadeListAdapter(getActivity());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_crusade, container, false);
        new LoadDataAsyncTask().execute();
        stickyListHeadersListView = (StickyListHeadersListView) rootView.findViewById(R.id.lv_task);
        stickyListHeadersListView.setAdapter(crusadeListAdapter);
        stickyListHeadersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Utils.log("click in crusade----- " + position + "---------");
                Crusade item = (Crusade) parent.getAdapter().getItem(position);
                Utils.log(item.toString());
            }
        });
//        Utils.log("update time" + SystemClock.uptimeMillis());
        return rootView;
    }
    class LoadDataAsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            crusadeListAdapter.setDatas(JSONHelper.getDatas());
            return null;
        }
    }

}
