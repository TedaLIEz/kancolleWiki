package com.example.kancollewiki.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.kancollewiki.R;
import com.example.kancollewiki.util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogRecord;

/**
 * Created by Administrator on 2015/9/17.
 */
public class MyListLinearLayout extends LinearLayout implements View.OnClickListener {
    private int itemHeight;
    private OnListItemClickListener onListItemClickListener;

    public MyListLinearLayout(Context context) {
        super(context);
    }


    public MyListLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
    }

    public MyListLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        for (int i = 0; i < getChildCount(); i++) {
            final View child = getChildAt(i);
            child.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
            itemHeight = child.getMeasuredHeight();
            child.setOnClickListener(this);

        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setItems(ArrayList<? extends LinearLayout> items) {
        for (LinearLayout layout : items) {
            addView(layout);
        }
        invalidate();
    }
    public void createItem(String title) {
        View view = inflate(getContext(), R.layout.ship_class_layout,null);
        TextView tv = (TextView) view.findViewById(R.id.ship_class_name);
        tv.setText(title);
        view.setTag(title);
        addView(view);
    }
    public void setOnListItemClickListener(OnListItemClickListener onListItemClickListener) {
        this.onListItemClickListener = onListItemClickListener;
    }

    @Override
    public void onClick(View v) {
        int pos = (int) (v.getY() / itemHeight);
        onListItemClickListener.onClick(v, pos);
    }

    public interface OnListItemClickListener {
        void onClick(View v, int pos);
    }

}
