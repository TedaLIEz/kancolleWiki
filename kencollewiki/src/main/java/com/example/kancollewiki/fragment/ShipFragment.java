package com.example.kancollewiki.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
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
import com.example.kancollewiki.activities.ShipActivity;
import com.example.kancollewiki.adapter.ShipTypeAdapter;
import com.example.kancollewiki.bean.ship.AbstractShipClass;
import com.example.kancollewiki.bean.ship.DDShip;
import com.example.kancollewiki.bean.ship.Ship;
import com.example.kancollewiki.bean.ship.ShipClass;
import com.example.kancollewiki.util.PicJsonArray;
import com.example.kancollewiki.util.Utils;
import com.example.kancollewiki.view.MyListLinearLayout;
import com.zzt.inbox.interfaces.OnDragStateChangeListener;
import com.zzt.inbox.widget.InboxLayoutBase;
import com.zzt.inbox.widget.InboxLayoutListView;
import com.zzt.inbox.widget.InboxBackgroundScrollView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class ShipFragment extends BaseFragment{
    InboxLayoutListView inboxLayoutListView;
    MyListLinearLayout containerLayout;
    ArrayList<ShipClass> tmp;
    ArrayList<ShipClass> tmp2;
    ArrayList<ShipClass> tmp3;
    public ShipFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = initView(inflater, container);
        return rootView;
    }

    @NonNull
    private View initView(LayoutInflater inflater, ViewGroup container) {
        final ArrayList<ArrayList<ShipClass>> lists = initData();
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
                inboxLayoutListView.setAdapter(new ShipTypeAdapter(getActivity(), lists.get(pos)));
                inboxLayoutListView.openWithAnim(v);
            }
        });
        ListView listView = inboxLayoutListView.getDragableView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (!parent.getAdapter().isEmpty()) {
                    ShipClass shipCLass = (ShipClass) parent.getAdapter().getItem(position);
//                    if (Build.VERSION.SDK_INT >= 21) {
//                        Intent intent = new Intent(getActivity(), ShipActivity.class);
//                        intent.putExtra("ship",shipCLass);
//                        ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(getActivity(), view, "change_ship_item");
//                        Utils.startSharedElementActivity(getActivity(), intent, activityOptions);
//                    }
                    startActivity(new Intent(getActivity(), ShipActivity.class));
                }






            }
        });
        return rootView;
    }

    @NonNull
    private ArrayList<ArrayList<ShipClass>> initData() {
        tmp = new ArrayList<>();
        AbstractShipClass test = new AbstractShipClass.Builder().createClass(DDShip.getInstance(), 0, "白露级").build();
        Ship poi = new Ship.Builder().createShipGirl(test, 0, "夕立", true).build();
        poi.setPic_url("0/0e/KanMusu082Illust.png");
        Ship shigure = new Ship.Builder().createShipGirl(test, 1, "时雨", true).build();
        shigure.setPic_url("b/b3/KanMusu080Illust.png");
        tmp.add(poi);
        tmp.add(shigure);

        tmp2 = new ArrayList<>();
        tmp3 = new ArrayList<>();
        ArrayList<ArrayList<ShipClass>> lists = new ArrayList<>();
        lists.add(tmp);
        lists.add(tmp2);
        lists.add(tmp3);
        return lists;
    }

    /**
     * read json of pic urls from raw
     * @throws IOException
     * @throws JSONException
     */
    private void readJson() {
        JSONObject jsonObject = PicJsonArray.getJsonObject();
        JSONArray array = jsonObject.names();
        for (int i = 0; i < array.length(); i++) {
            try {
                Utils.log("pic name" + array.get(i) + "url " + jsonObject.get((String) array.get(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

}
