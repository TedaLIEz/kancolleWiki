package com.example.kancollewiki.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kancollewiki.C;
import com.example.kancollewiki.R;
import com.example.kancollewiki.adapter.ShipTypeAdapter;
import com.example.kancollewiki.util.Utils;
import com.example.kancollewiki.view.MyListLinearLayout;
import com.zzt.inbox.interfaces.OnDragStateChangeListener;
import com.zzt.inbox.widget.InboxLayoutBase;
import com.zzt.inbox.widget.InboxLayoutListView;
import com.zzt.inbox.widget.InboxBackgroundScrollView;

import java.util.ArrayList;


public class ShipFragment extends BaseFragment{
    InboxLayoutListView inboxLayoutListView;
    MyListLinearLayout containerLayout;
    ArrayList<String> tmp;
    ArrayList<String> tmp2;
    ArrayList<String> tmp3;
    public ShipFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final ArrayList<ArrayList<String>> lists = initData();
        View rootView = inflater.inflate(R.layout.fragment_ship, container, false);
        containerLayout = (MyListLinearLayout) rootView.findViewById(R.id.shipclass_container);
        final InboxBackgroundScrollView inboxBackgroundScrollView =
                (InboxBackgroundScrollView)rootView.findViewById(R.id.scroll);
        inboxLayoutListView = (InboxLayoutListView)rootView.findViewById(R.id.inboxlayout);
        inboxLayoutListView.setBackgroundScrollView(inboxBackgroundScrollView);
        inboxLayoutListView.setCloseDistance(30);
        inboxLayoutListView.setOnDragStateChangeListener(new OnDragStateChangeListener() {
            @Override
            public void dragStateChange(InboxLayoutBase.DragState state) {
                switch (state) {
                    case CANCLOSE:
                        //TODO: Actionbar

                        break;
                    case CANNOTCLOSE:
                        break;
                }
            }
        });
        containerLayout.createItem(C.DD);
        containerLayout.createItem(C.BB);
        containerLayout.createItem(C.CL);
        containerLayout.setOnListItemClickListener(new MyListLinearLayout.OnListItemClickListener() {
            @Override
            public void onClick(View v, int pos) {
                Utils.log("pos in item" + v.getTag());
                inboxLayoutListView.setAdapter(new ShipTypeAdapter<>(getActivity(), lists.get(pos)));
                inboxLayoutListView.openWithAnim(v);
            }
        });
        ListView listView = inboxLayoutListView.getDragableView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Utils.log((String) parent.getAdapter().getItem(position));
            }
        });
        return rootView;
    }

    @NonNull
    private ArrayList<ArrayList<String>> initData() {
        tmp = new ArrayList<>();
        tmp.add("poi0");
        tmp.add("poi2");
        tmp.add("poi3");
        tmp.add("poi43");
        tmp.add("poi432");
        tmp.add("poi4235");
        tmp.add("poi44");
        tmp.add("po5i");
        tmp.add("poi55");
        tmp.add("poi4");

        tmp2 = new ArrayList<>();
        tmp2.add("长门234");
        tmp2.add("长门22");
        tmp2.add("长门1");
        tmp2.add("长门2");
        tmp2.add("长门3");
        tmp2.add("长门4");
        tmp2.add("长门5");
        tmp2.add("长门6");
        tmp3 = new ArrayList<>();
        tmp3.add("阿武偎");
        tmp3.add("阿武偎");
        tmp3.add("阿武偎");
        tmp3.add("阿武偎");
        tmp3.add("阿武偎");
        tmp3.add("阿武偎");
        tmp3.add("阿武偎");
        tmp3.add("阿武偎");
        tmp3.add("阿武偎");
        final ArrayList<ArrayList<String>> lists = new ArrayList<>();
        lists.add(tmp);
        lists.add(tmp2);
        lists.add(tmp3);
        return lists;
    }

}
