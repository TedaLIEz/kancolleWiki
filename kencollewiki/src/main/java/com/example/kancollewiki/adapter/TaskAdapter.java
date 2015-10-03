package com.example.kancollewiki.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kancollewiki.R;
import com.example.kancollewiki.bean.Task;

import java.util.List;

/**
 * Created by Administrator on 2015/10/3.
 */
public class TaskAdapter extends BaseListAdapter<Task>{
    public TaskAdapter(Context ctx) {
        super(ctx);
    }

    public TaskAdapter(Context ctx, List<Task> datas) {
        super(ctx, datas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        Task task = datas.get(position);
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.task_detail_item, parent, false);
            viewHolder.tv_pid = (TextView) convertView.findViewById(R.id.task_pid);
            viewHolder.tv_pname = (TextView) convertView.findViewById(R.id.task_pname);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_pid.setText(task.getId());
        viewHolder.tv_pname.setText(task.getTask_name_jp());
        return convertView;
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public long getHeaderId(int position) {
        return 0;
    }

    static class ViewHolder {
        TextView tv_pid,tv_pname;
    }
}
