package com.example.kancollewiki.adapter;

import android.content.Context;
import android.os.PatternMatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kancollewiki.R;
import com.example.kancollewiki.bean.Task;

import org.w3c.dom.Text;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/10/1.
 */
public class TaskListAdapter extends BaseListAdapter<Task>{

    public TaskListAdapter(Context ctx) {
        super(ctx);
    }

    public TaskListAdapter(Context ctx, List<Task> datas) {
        super(ctx, datas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        Task task = datas.get(position);
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.task_item, parent, false);
            convertView.setTag(viewHolder);
            viewHolder.task_id = (TextView) convertView.findViewById(R.id.task_id);
            viewHolder.task_has_pid = (LinearLayout) convertView.findViewById(R.id.task_has_pid);
            viewHolder.task_name = (TextView) convertView.findViewById(R.id.task_name);
            viewHolder.task_pid = (TextView) convertView.findViewById(R.id.task_pid);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (task.getPid().equals("")) {
            viewHolder.task_has_pid.setVisibility(View.GONE);
        } else {
            viewHolder.task_pid.setText(task.getPid());
        }
        viewHolder.task_name.setText(task.getTask_name_jp());
        viewHolder.task_id.setText(task.getId());
        return convertView;
    }

    @Override
    public View getHeaderView(int i, View view, ViewGroup viewGroup) {
        HeaderViewHolder headerViewHolder;
        if (view == null) {
            headerViewHolder = new HeaderViewHolder();
            view = inflater.inflate(R.layout.stick_header_item, viewGroup, false);
            headerViewHolder.tv_subtitle = (TextView) view.findViewById(R.id.stick_text);
            view.setTag(headerViewHolder);
        } else {
            headerViewHolder = (HeaderViewHolder) view.getTag();
        }

        headerViewHolder.tv_subtitle.setText(getTitle(getHeaderId(i)));
        return view;
    }

    private String getTitle(long headerId) {
        switch ((int) headerId) {
            case 0 :
                return "一次性任务";
            case 1 :
                return "日常任务";
            case 2 :
                return "周常任务";
            case 3 :
                return "月常任务";
            default:
                return null;

        }
    }

    @Override
    public long getHeaderId(int i) {
        String id = datas.get(i).getId();
        if (id.contains("d")) {
            return 1;
        } else if (id.contains("w")){
            return 2;
        } else if (id.contains("m")) {
            return 3;
        } else {
            return 0;
        }
//        Pattern pattern = Pattern.compile("d");
//        Pattern pattern1 = Pattern.compile("w");
//        Pattern pattern2 = Pattern.compile("m");
//        Matcher matcher = pattern.matcher(id);
//        Matcher matcher1 = pattern1.matcher(id);
//        Matcher matcher2 = pattern2.matcher(id);
//        if (matcher.find()) {
//            return 1;
//        } else if (matcher1.find()) {
//            return 2;
//        } else if (matcher2.find()) {
//            return 3;
//        } else {
//            return 0;
//        }
    }

    static class ViewHolder {
        TextView task_id,task_name,task_pid;
        LinearLayout task_has_pid;
    }

    static class HeaderViewHolder {
        TextView tv_subtitle;
    }
}
