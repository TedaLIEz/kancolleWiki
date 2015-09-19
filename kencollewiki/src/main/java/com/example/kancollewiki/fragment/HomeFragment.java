package com.example.kancollewiki.fragment;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kancollewiki.R;
import com.example.kancollewiki.bean.News;
import com.example.kancollewiki.util.Utils;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator;
import jp.wasabeef.recyclerview.animators.adapters.ScaleInAnimationAdapter;


public class HomeFragment extends BaseFragment{
    private static final int REFRESH_COMPLETE = 0x110;
    UltimateRecyclerView recyclerView;
    NewsAdapter adapter;
    ArrayList<News> newses;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (newses.size() > 0) {
            outState.putSerializable("data",newses);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home,container,false);
        recyclerView = (UltimateRecyclerView) rootView.findViewById(R.id.recyclerview);
        initRecyclerView();
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }



    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        newses = new ArrayList<>();
        News news1 = new News("「艦これ」オリジナルサウンドトラック OST vol.2【風】の一般販売が今月末より開始されてます。本日から同予約もスタート致します。あわせて、OST vol.1、艦娘想歌 vol.1、vol.2の再販も決定致しました！「艦これ」楽曲も、どうぞよろしくお願い致します！\n" +
                "#艦これ\n" +
                " \n" +
                "“舰队收藏”OriginalSoundTrack OST vol.2【风】的一般发售将在本月末开始。今日开始预约，另外OST vol.1、、舰娘想歌 vol.1、vol.2也决定再版了！“舰队收藏”的乐曲也请多多关照！", "8:58 09-18");
        News news2 = new News("明日より一般公開のTGS2015、DMM POWERCHORD STUDIOさんのブースに、「艦これ」も参加させて頂いています。同特設ミニシアターは「春雨＆夕立の出撃準備TGSご来場記念ささやかなクリアファイル」のお土産付です。TGSでも、どうぞよろしくお願い致します！\n" +
                "#艦これ\n" +
                " \n" +
                "明天开始向一般公众开放的TGS2015、DMM POWERCHORD STUDIO的展台，“舰队收藏”也将会参加。并且在特设迷你剧场将会有“春雨&夕立的出击准备-TGS到场纪念文件夹”的伴手礼。TGS也请多多关照。", "8:48 09-18");
        newses.add(news1);
        newses.add(news2);
//        newses.add(news2);
//        newses.add(news2);
//        newses.add(news2);
//        newses.add(news2);
//        newses.add(news2);
//        newses.add(news2);
//        newses.add(news2);
//        newses.add(news2);
//        newses.add(news2);
//        newses.add(news2);
//        newses.add(news2);
//        newses.add(news2);
//        newses.add(news2);
//        newses.add(news2);
//        newses.add(news2);
//        newses.add(news2);

        adapter = new NewsAdapter(getActivity(),newses);
        ScaleInAnimationAdapter scaleInAnimationAdapter = new ScaleInAnimationAdapter(adapter);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new SlideInDownAnimator());
        recyclerView.setDefaultOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData();
            }
        });


    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Utils.log("attached");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            ArrayList<News> datas = (ArrayList<News>) savedInstanceState.getSerializable("datas");
            if (datas != null) {
                adapter.addAll(datas);
            }
        }


        Utils.log("onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Utils.log("destroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Utils.log("destroyview");
    }

    @Override
    public void onPause() {
        super.onPause();
        Utils.log("onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Utils.log("onStop");
    }

    @Override
    public void onStart() {
        super.onStart();
        Utils.log("onStart");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Utils.log("onDetach");
    }

    private void loadData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                adapter.add(new News("マルキューヨンマル。提督の皆さん、おはようございます！\n" +
                        "今日は金曜日！関東以北では今日も強い雨の降るエリアがありそうです。天候にも注意しつつ、金曜カレーで滋養と曜日感覚を補強して、今週末も元気に乗り切ってまいりましょう！\n" +
                        "#艦これ\n" +
                        " \n" +
                        "0930。各位提督早上好！\n" +
                        "今天是周五！关东以北今天会有大范围强降雨。请一边注意天气一边享用金曜日咖喱补充营养补强时间感，本周末也精神满满地上吧！\n" +
                        "#艦これ", "8:40 09-18"));
                recyclerView.invalidate();
                recyclerView.setRefreshing(false);
            }
        }, 1000);

//        swipeRefreshLayout.setRefreshing(false);
        Utils.log("adapter size" + recyclerView.getAdapter().getItemCount());

    }


    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
        List<News> datas;
        LayoutInflater inflater;

        public NewsAdapter(Context ctx, List<News> datas) {
            initWithContext(ctx);
            this.datas = datas;
        }

        private void initWithContext(Context ctx) {
            inflater = LayoutInflater.from(ctx);
        }

        public void add(News news) {
            datas.add(0, news);
            notifyDataSetChanged();
        }

        public void remove(int pos) {
            datas.remove(pos);
            notifyItemRemoved(pos);

        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(inflater.inflate(R.layout.news_item,parent,false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            News news = datas.get(position);
            holder.tv_date.setText(news.getDate());
            holder.tv_content.setText(news.getContent());

        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        public void addAll(ArrayList<News> datas) {
            this.datas.addAll(datas);
            notifyDataSetChanged();
        }

        public List<News> getDatas() {
            return datas;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tv_content,tv_date;
            public MyViewHolder(View itemView) {
                super(itemView);
                tv_date = (TextView) itemView.findViewById(R.id.news_date);
                tv_content = (TextView) itemView.findViewById(R.id.news_content);
            }
        }
    }


}
