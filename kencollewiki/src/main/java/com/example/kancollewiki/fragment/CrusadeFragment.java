package com.example.kancollewiki.fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kancollewiki.R;
import com.example.kancollewiki.adapter.CrusadeListAdapter;
import com.example.kancollewiki.bean.Crusade;
import com.example.kancollewiki.util.SnappyDBHelper;
import com.example.kancollewiki.util.Utils;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class CrusadeFragment extends BaseFragment {
    StickyListHeadersListView stickyListHeadersListView;
    CrusadeListAdapter crusadeListAdapter;
    private static final int MSG_SUCCESS = 0;
    List<Crusade> datas;
    ProgressDialog pd;
    Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_SUCCESS :
                    datas.addAll((Collection<? extends Crusade>) msg.obj);
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            List<Crusade> crusades = SnappyDBHelper.findDatasById("crusade_", Crusade.class);
            Collections.sort(crusades,new Comparator<Crusade>() {
                @Override
                public int compare(Crusade lhs, Crusade rhs) {
                    if (lhs.getPid() > rhs.getPid()) {
                        return 1;
                    } else if (lhs.getPid() < rhs.getPid()) {
                        return -1;
                    } else {
                        return lhs.getId() - rhs.getId();
                    }

                }
            });
            Message message = mHandler.obtainMessage(MSG_SUCCESS, crusades);
            message.sendToTarget();
        }
    };
    public CrusadeFragment() {
        // Required empty public constructor
        datas = new ArrayList<>();
        mHandler.post(runnable);
//        runnable.run();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        crusadeListAdapter = new CrusadeListAdapter(getActivity(),datas);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_crusade, container, false);
        stickyListHeadersListView = (StickyListHeadersListView) rootView.findViewById(R.id.lv_task);
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
        return rootView;
    }

    private void showDialog(Crusade item) {
        final Dialog dialog = new Dialog(getActivity(),android.R.style.Theme_DeviceDefault_Dialog_NoActionBar);
        View dialogView = View.inflate(getActivity(), R.layout.crusade_dialog_layout, null);
        TextView title = (TextView) dialogView.findViewById(R.id.crusade_title);
        LinearLayout total_lv_layout = (LinearLayout) dialogView.findViewById(R.id.crusade_total);
        LinearLayout bucket_layout = (LinearLayout) dialogView.findViewById(R.id.crusade_bucket);
        LinearLayout bonus_layout = (LinearLayout) dialogView.findViewById(R.id.crusade_bonus);
        TextView total_lv = (TextView) dialogView.findViewById(R.id.crusade_total_lv);
        TextView necc_ship = (TextView) dialogView.findViewById(R.id.crusade_necc_ship);
        TextView bucket = (TextView) dialogView.findViewById(R.id.crusade_tv_bucket);
        TextView bonus = (TextView) dialogView.findViewById(R.id.crusade_tv_bonus);
        Button button = (Button) dialogView.findViewById(R.id.positive_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        title.setText(item.getId() + " "  + item.getName_jp());
        if (item.getTotal_lv().equals("")) {
            total_lv_layout.setVisibility(View.GONE);
        } else {
            total_lv.setText(item.getTotal_lv());
        }
        if (item.getBucket().equals("")) {
            bucket_layout.setVisibility(View.GONE);
        } else {
            bucket.setText(item.getBucket());
        }
        if (item.getBonus().equals(" ")) {
            bonus_layout.setVisibility(View.GONE);
        } else {
            bonus.setText(item.getBonus());
        }
        necc_ship.setText(item.getNeccShip());
        dialog.setContentView(dialogView);
        dialog.show();

    }


}
