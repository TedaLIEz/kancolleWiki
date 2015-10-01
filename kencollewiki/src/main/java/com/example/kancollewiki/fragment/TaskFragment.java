package com.example.kancollewiki.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.kancollewiki.R;
import com.example.kancollewiki.adapter.TaskListAdapter;
import com.example.kancollewiki.bean.Task;
import com.example.kancollewiki.util.JSONHelper;
import com.example.kancollewiki.util.SnappyDBHelper;
import com.example.kancollewiki.util.TaskItemComparator;
import com.example.kancollewiki.util.Utils;
import com.example.kancollewiki.view.InboxLayoutStickyHeaderListView;
import com.example.kancollewiki.view.MyListLinearLayout;
import com.snappydb.SnappydbException;
import com.zzt.inbox.interfaces.OnDragStateChangeListener;
import com.zzt.inbox.widget.InboxBackgroundScrollView;
import com.zzt.inbox.widget.InboxLayoutBase;
import com.zzt.inbox.widget.InboxLayoutListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * 任务
 */
public class TaskFragment extends BaseFragment {
    InboxLayoutStickyHeaderListView inboxLayoutListView;
    MyListLinearLayout containerLayout;
    List<Task> formations,attacks,exercises,crusades,supplies,factories,modifys;
    String[] task_names = new String[]{"编成","出击","演习","远征","补给/入渠","工厂","改装"};
    public TaskFragment() {
        // Required empty public constructor
        initData();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_task, container, false);
        inboxLayoutListView = (InboxLayoutStickyHeaderListView) rootView.findViewById(R.id.task_listview);
        containerLayout = (MyListLinearLayout) rootView.findViewById(R.id.task_container);
        InboxBackgroundScrollView inboxBackgroundScrollView = (InboxBackgroundScrollView) rootView.findViewById(R.id.task_scroll);
        inboxLayoutListView.setBackgroundScrollView(inboxBackgroundScrollView);
        initItems();

        return rootView;
    }

    private void initItems() {
        inboxLayoutListView.setCloseDistance(30);
        inboxLayoutListView.setOnDragStateChangeListener(new OnDragStateChangeListener() {
            @Override
            public void dragStateChange(InboxLayoutBase.DragState state) {

            }
        });
        for (String s : task_names) {
            containerLayout.createItem(s);
        }
        final ArrayList<List<Task>> lists = new ArrayList<>();
        lists.add(formations);
        lists.add(attacks);
        lists.add(exercises);
        lists.add(crusades);
        lists.add(supplies);
        lists.add(factories);
        lists.add(modifys);
        containerLayout.setOnListItemClickListener(new MyListLinearLayout.OnListItemClickListener() {
            @Override
            public void onClick(View v, int pos) {
                Utils.log("click in task" + v.getTag());
                inboxLayoutListView.setAdapter(new TaskListAdapter(getActivity(), lists.get(pos)));
                inboxLayoutListView.openWithAnim(v);
            }
        });
        StickyListHeadersListView listView = inboxLayoutListView.getDragableView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Task task = (Task) parent.getAdapter().getItem(position);
                Utils.log("click on task" + task.toString());
            }
        });
    }


    private void initData() {
        formations = new ArrayList<>();
        ArrayList<Task> formations0 = (ArrayList<Task>) SnappyDBHelper.findDatasById("task_A", Task.class);
        ArrayList<Task> formations1 = (ArrayList<Task>) SnappyDBHelper.findDatasById("task_WA", Task.class);
        formations.addAll(formations0);
        formations.addAll(formations1);
        Collections.sort(formations, new TaskItemComparator());
        attacks = new ArrayList<>();
        ArrayList<Task> attacks0 = (ArrayList<Task>) SnappyDBHelper.findDatasById("task_B", Task.class);
        ArrayList<Task> attacks1 = (ArrayList<Task>) SnappyDBHelper.findDatasById("task_WB", Task.class);
        attacks.addAll(attacks0);
        attacks.addAll(attacks1);
        Collections.sort(attacks, new TaskItemComparator());
        crusades = SnappyDBHelper.findDatasById("task_D",Task.class);
        Collections.sort(crusades, new TaskItemComparator());
        exercises = new ArrayList<>();
        ArrayList<Task> exercises0 = (ArrayList<Task>) SnappyDBHelper.findDatasById("task_C", Task.class);
        ArrayList<Task> exercises1 = (ArrayList<Task>) SnappyDBHelper.findDatasById("task_WC", Task.class);
        exercises.addAll(exercises0);
        exercises.addAll(exercises1);
        Collections.sort(exercises, new TaskItemComparator());
        supplies = SnappyDBHelper.findDatasById("task_E", Task.class);
        Collections.sort(supplies, new TaskItemComparator());
        factories = new ArrayList<>();
        ArrayList<Task> factories0 = (ArrayList<Task>) SnappyDBHelper.findDatasById("task_F", Task.class);
        ArrayList<Task> factories1 = (ArrayList<Task>) SnappyDBHelper.findDatasById("task_WF",Task.class);
        factories.addAll(factories0);
        factories.addAll(factories1);
        Collections.sort(factories, new TaskItemComparator());
        modifys = SnappyDBHelper.findDatasById("task_G", Task.class);
        Collections.sort(modifys, new TaskItemComparator());
    }

}
