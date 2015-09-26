package com.example.kancollewiki.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by Administrator on 2015/9/15.
 */
public abstract class BaseListAdapter<T> extends BaseAdapter implements StickyListHeadersAdapter{
    Context ctx;
    LayoutInflater inflater;
    List<T> datas = new ArrayList<T>();

    public BaseListAdapter(Context ctx) {
        initWithContext(ctx);
    }

    public BaseListAdapter(Context ctx, List<T> datas) {
        initWithContext(ctx);
        this.datas = datas;
    }

    public void initWithContext(Context ctx) {
        this.ctx = ctx;
        inflater = LayoutInflater.from(ctx);
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public void addAll(List<T> subDatas) {
        datas.addAll(subDatas);
        notifyDataSetChanged();
    }

    public void add(T object) {
        datas.add(object);
        notifyDataSetChanged();
    }

    public void remove(int position) {
        datas.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public abstract View getView(int position, View convertView, ViewGroup parent);

    public void clear() {
        datas.clear();
        notifyDataSetChanged();
    }
}
