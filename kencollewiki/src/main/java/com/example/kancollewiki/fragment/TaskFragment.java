package com.example.kancollewiki.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.kancollewiki.R;
import com.example.kancollewiki.activities.TaskActivity;
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
    OnTaskListSelectedListener onTaskListSelectedListener;
    public interface OnTaskListSelectedListener {
        public void onTaskSelected(String title);
    }
    public TaskFragment() {
        // Required empty public constructor
        initData();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onTaskListSelectedListener = (OnTaskListSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnTaskListSelectedListener");
        }
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
                switch (state) {
                    case CANCLOSE:
                        onTaskListSelectedListener.onTaskSelected("任务");
                        break;
                }
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
                onTaskListSelectedListener.onTaskSelected(task_names[pos] + "任务");
            }
        });
        StickyListHeadersListView listView = inboxLayoutListView.getDragableView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Task task = (Task) parent.getAdapter().getItem(position);
                Intent intent = new Intent(getActivity(), TaskActivity.class);
                intent.putExtra("task", task);
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), view, "task_transition");
                startActivity(intent);
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

        attacks = new ArrayList<>();
        ArrayList<Task> attacks0 = (ArrayList<Task>) SnappyDBHelper.findDatasById("task_B", Task.class);
        ArrayList<Task> attacks1 = (ArrayList<Task>) SnappyDBHelper.findDatasById("task_WB", Task.class);
        attacks.addAll(attacks0);
        attacks.addAll(attacks1);

        crusades = SnappyDBHelper.findDatasById("task_D",Task.class);

        exercises = new ArrayList<>();
        ArrayList<Task> exercises0 = (ArrayList<Task>) SnappyDBHelper.findDatasById("task_C", Task.class);
        ArrayList<Task> exercises1 = (ArrayList<Task>) SnappyDBHelper.findDatasById("task_WC", Task.class);
        exercises.addAll(exercises0);
        exercises.addAll(exercises1);

        supplies = SnappyDBHelper.findDatasById("task_E", Task.class);

        factories = new ArrayList<>();
        ArrayList<Task> factories0 = (ArrayList<Task>) SnappyDBHelper.findDatasById("task_F", Task.class);
        ArrayList<Task> factories1 = (ArrayList<Task>) SnappyDBHelper.findDatasById("task_WF",Task.class);
        factories.addAll(factories0);
        factories.addAll(factories1);

        modifys = SnappyDBHelper.findDatasById("task_G", Task.class);
        TaskItemComparator taskItemComparator = new TaskItemComparator();
        Collections.sort(exercises, taskItemComparator);
        Collections.sort(attacks, taskItemComparator);
        Collections.sort(crusades, taskItemComparator);
        Collections.sort(supplies, taskItemComparator);
        Collections.sort(factories, taskItemComparator);
        Collections.sort(formations, taskItemComparator);
        Collections.sort(modifys, taskItemComparator);
    }

}
