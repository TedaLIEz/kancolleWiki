package com.example.kancollewiki;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.zzt.inbox.interfaces.OnDragStateChangeListener;
import com.zzt.inbox.widget.InboxLayoutBase;
import com.zzt.inbox.widget.InboxLayoutListView;
import com.zzt.inbox.widget.InboxBackgroundScrollView;

import com.example.kancollewiki.activities.BaseActivity;


public class MainActivity extends BaseActivity {
    InboxLayoutListView inboxLayoutListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        getActionBar().setBackgroundDrawable(new ColorDrawable(0xdd000000));

        final InboxBackgroundScrollView inboxBackgroundScrollView = (InboxBackgroundScrollView)findViewById(R.id.scroll);
        inboxLayoutListView = (InboxLayoutListView)findViewById(R.id.inboxlayout);
        inboxLayoutListView.setBackgroundScrollView(inboxBackgroundScrollView);
        inboxLayoutListView.setCloseDistance(50);
        inboxLayoutListView.setOnDragStateChangeListener(new OnDragStateChangeListener() {
            @Override
            public void dragStateChange(InboxLayoutBase.DragState state) {
                switch (state) {
                    case CANCLOSE:
                        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xff5e5e5e));
                        //getSupportActionBar().setTitle("back");
                        break;
                    case CANNOTCLOSE:
                        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xdd000000));
                        //getSupportActionBar().setTitle("InboxLayout");
                        break;
                }
            }
        });

        //展开后的数据显示
        inboxLayoutListView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() { return 20; }

            @Override
            public Object getItem(int position) { return null; }

            @Override
            public long getItemId(int position) { return position;}

            @Override
            public  View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = MainActivity.this.getLayoutInflater();
                View view = inflater.inflate(R.layout.item, null);
                return view;
            }
        });

        init();
    }

    private void init(){
        final LinearLayout dd = (LinearLayout)findViewById(R.id.dd);
        dd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inboxLayoutListView.openWithAnim(dd);
            }
        });

        final LinearLayout bb = (LinearLayout)findViewById(R.id.bb);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inboxLayoutListView.openWithAnim(bb);
            }
        });
    }

}