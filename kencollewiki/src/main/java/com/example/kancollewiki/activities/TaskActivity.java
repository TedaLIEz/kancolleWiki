package com.example.kancollewiki.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kancollewiki.R;
import com.example.kancollewiki.adapter.TaskAdapter;
import com.example.kancollewiki.bean.Task;
import com.example.kancollewiki.util.SnappyDBHelper;
import com.example.kancollewiki.util.Utils;
import com.snappydb.SnappydbException;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class TaskActivity extends BaseActivity {
    @Bind(R.id.task_detail)
    TextView tv_detail;
    @Bind(R.id.task_open_lv)
    ListView listView;
    @Bind(R.id.task_res)
    TextView tv_res;
    @Bind(R.id.task_bonus)
    TextView tv_bonus;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.task_comment)
    TextView tv_comment;
    @Bind(R.id.task_open_pid)
    LinearLayout linearLayout;
    @Bind(R.id.task_name_jp)
    TextView tv_name_jp;
    Task task;
    TaskAdapter taskAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        ButterKnife.bind(this);
        task = (Task) getIntent().getSerializableExtra("task");
        initData();
//        Utils.log("task activity task" + task.toString());
        TextView toolbar_title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar_title.setText(task.getId());
        setSupportActionBar(toolbar);
        tv_name_jp.setText(task.getTask_name_jp());
        toolbar.setNavigationIcon(R.drawable.ic_navigate_before_white_36dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supportFinishAfterTransition();
            }
        });
        tv_detail.setText(task.getTask_detail_zh());
        tv_comment.setText(task.getComment());
        String fuel = task.getFuel().equals("") ? "0" : task.getFuel();
        String bullet = task.getBullet().equals("") ? "0" : task.getBullet();
        String steel = task.getSteel().equals("") ? "0" : task.getSteel();
        String al = task.getAl().equals("") ? "0" : task.getAl();
        tv_res.setText("燃料: " + fuel + " 弹药: " + bullet + " 钢: " + steel + " 铝: " + al);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < task.getBonus().size() - 1; i++) {
            sb.append(task.getBonus().get(i) + '\n');
        }
        sb.append(task.getBonus().get(task.getBonus().size() - 1));
        tv_bonus.setText(sb.toString());
    }

    private void initListView() {
        listView.setAdapter(taskAdapter);
//        Utils.log("adapter size" + taskAdapter.getCount());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Task task = (Task) parent.getAdapter().getItem(position);
                Intent intent = new Intent(TaskActivity.this, TaskActivity.class);
                intent.putExtra("task", task);
                startActivity(intent);
                Utils.log(task.toString());
            }
        });
    }

    private void initData() {
        List<Task> datas = new ArrayList<>();
        if (!task.getPid().equals("")) {
            String[] pid = task.getPid().split(" ");
            if (pid.length != 0) {
                for (String str : pid) {
                    Task task = (Task) SnappyDBHelper.findItemById("task_" + str, Task.class);
//                List<Task> data = SnappyDBHelper.findDatasById(str, Task.class);
                    datas.add(task);
                }
            }
            taskAdapter = new TaskAdapter(this,datas);
            initListView();
        } else {
            hideView();
        }
    }

    private void hideView() {
        linearLayout.setVisibility(View.INVISIBLE);
        listView.setVisibility(View.GONE);
    }


}
