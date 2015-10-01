package com.example.kancollewiki.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Adapter;

import com.example.kancollewiki.adapter.BaseListAdapter;
import com.example.kancollewiki.adapter.TaskListAdapter;
import com.zzt.inbox.widget.InboxLayoutBase;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by Administrator on 2015/10/1.
 */
public class InboxLayoutStickyHeaderListView extends InboxLayoutBase<StickyListHeadersListView>{
    
    private StickyListHeadersListView listHeadersListView;
    public InboxLayoutStickyHeaderListView(Context context) {
        this(context, null);
    }

    public InboxLayoutStickyHeaderListView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public InboxLayoutStickyHeaderListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected StickyListHeadersListView createDragableView(Context context, AttributeSet attrs) {
        listHeadersListView = new StickyListHeadersListView(context);
        listHeadersListView.setId(android.R.id.list);
        return listHeadersListView;
    }

    @Override
    protected boolean isReadyForDragStart() {
        final Adapter adapter = listHeadersListView.getAdapter();
        if(null == adapter || adapter.isEmpty()){
            return true;
        }else{
            if( listHeadersListView.getFirstVisiblePosition()<=1 ){
                final View firstVisibleChild = listHeadersListView.getChildAt(0);
                if(firstVisibleChild != null){
                    return firstVisibleChild.getTop() >= listHeadersListView.getTop();
                }
            }
        }
        return false;
    }

    @Override
    protected boolean isReadyForDragEnd() {
        final Adapter adapter = listHeadersListView.getAdapter();

        if (null == adapter || adapter.isEmpty()) {
            return true;
        }
        else {
            final int lastItemPosition = listHeadersListView.getCount() - 1;
            final int lastVisiblePosition = listHeadersListView.getLastVisiblePosition();
            if (lastVisiblePosition >= lastItemPosition - 1) {
                final int childIndex = lastVisiblePosition - listHeadersListView.getFirstVisiblePosition();
                final View lastVisibleChild = listHeadersListView.getChildAt(childIndex);
                if (lastVisibleChild != null) {
                    return lastVisibleChild.getBottom() <= listHeadersListView.getBottom();
                }
            }
        }
        return false;
    }

    public void setAdapter(BaseListAdapter baseListAdapter) {
        listHeadersListView.setAdapter(baseListAdapter);
    }
}
