package com.example.kancollewiki.fragment;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.kancollewiki.C;
import com.example.kancollewiki.R;
import com.example.kancollewiki.bean.News;
import com.example.kancollewiki.util.Utils;
import com.example.kancollewiki.util.RequestManager;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;
import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter;
import com.marshalchen.ultimaterecyclerview.animators.FadeInUpAnimator;
import com.marshalchen.ultimaterecyclerview.animators.ScaleInBottomAnimator;
import com.marshalchen.ultimaterecyclerview.animators.ScaleInLeftAnimator;
import com.marshalchen.ultimaterecyclerview.animators.ScaleInTopAnimator;
import com.marshalchen.ultimaterecyclerview.animators.SlideInLeftAnimator;
import com.marshalchen.ultimaterecyclerview.animators.adapters.SlideInBottomAnimationAdapter;
import com.marshalchen.ultimaterecyclerview.animators.internal.ViewHelper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class HomeFragment extends BaseFragment {
    private static final int REFRESH_COMPLETE = 0x110;
    UltimateRecyclerView recyclerView;
    NewsAdapter adapter;
    ArrayList<News> newses;
    LinearLayoutManager linearLayoutManager;
    ProgressDialog pd;
    int page = 2;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newses = new ArrayList<>();
        adapter = new NewsAdapter(getActivity(), newses);
        getData();


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




    private void initRecyclerView() {
        linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        Utils.log("adapter size" + adapter.getItemCount());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new ScaleInLeftAnimator());
        recyclerView.enableLoadmore();
        adapter.setCustomLoadMoreView(LayoutInflater.from(getActivity()).inflate(R.layout.custom_bottom_progressbar, null));
        recyclerView.setOnLoadMoreListener(new UltimateRecyclerView.OnLoadMoreListener() {
            @Override
            public void loadMore(int i, int i1) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadMoreNews();
                    }
                }, 1000);

            }
        });
        recyclerView.setDefaultOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();

            }
        });


    }

    private void refresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                StringRequest stringRequest = new StringRequest(C.NEWS_URL + "1", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        parseNews(response);
                        linearLayoutManager.scrollToPosition(0);
                        recyclerView.setRefreshing(false);
                        Utils.makeToast(getActivity(), "数据刷新成功!");
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Utils.makeToast(getActivity(), error.getLocalizedMessage());
                    }
                });
                RequestManager.addRequest(stringRequest, "test");

            }
        }, 1000);
    }


    private void getData() {

        pd = new ProgressDialog(getActivity());
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setMessage("Loading...");
        pd.show();
        if (Utils.isNetworkConnect(getActivity())) {
            StringRequest stringRequest = new StringRequest(C.NEWS_URL + "1", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    newses.clear();
                    parseNews(response);
                    pd.dismiss();
                    linearLayoutManager.scrollToPosition(0);
                    recyclerView.setRefreshing(false);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Utils.makeToast(getActivity(), error.getLocalizedMessage());
                }
            });
            RequestManager.addRequest(stringRequest, "test");
        } else {
            pd.dismiss();
            Utils.makeToast(getActivity(), "Please Check Your Network");
        }

    }

    private void parseNews(String response) {
        Document doc = Jsoup.parse(response);
        Elements contents = doc.select("#wrap #container #content div article div.entry-content");
        Elements dates = doc.select("#wrap #container #content div article header.entry-header ul.entry-meta");
        ArrayList<News> arrayList = new ArrayList<>();
        if (contents.size() == 1) {
            adapter.insert(new News(contents.get(0).toString(), dates.get(0).toString()), 0);
        } else {
            for (int i = 0; i < contents.size(); i++) {
                News news = new News(contents.get(i).toString(), dates.get(i).toString());
                arrayList.add(news);
            }
            adapter.addAll(arrayList);
        }

    }

    private void loadMoreNews() {
        StringRequest stringRequest = new StringRequest(C.NEWS_URL  + page, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getActivity(),"LoadMore",Toast.LENGTH_SHORT).show();
                parseNews(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Utils.makeToast(getActivity(), error.getLocalizedMessage());
            }
        });
        RequestManager.addRequest(stringRequest, page);
        page++;
    }

    class NewsAdapter extends UltimateViewAdapter<NewsAdapter.MyViewHolder> {
        List<News> datas;
        LayoutInflater inflater;
        private int mLastPosition = 3;
        public NewsAdapter(Context ctx, List<News> datas) {
            initWithContext(ctx);
            this.datas = datas;
        }

        private void initWithContext(Context ctx) {
            inflater = LayoutInflater.from(ctx);
        }

        @Override
        public MyViewHolder getViewHolder(View view) {
            return new MyViewHolder(view);
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
            MyViewHolder holder = new MyViewHolder(inflater.inflate(R.layout.news_item,viewGroup,false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            if (position > mLastPosition) {
                for (Animator anim : getAdapterAnimations(holder.itemView, AdapterAnimationType.SlideInBottom)) {
                    anim.setDuration(250).start();
                    anim.setInterpolator(new LinearInterpolator());
                }
                mLastPosition = position;
            } else {
                ViewHelper.clear(holder.itemView);
            }

            /**
             * You should and if when customLoadMore layout is added
             */
            if (position < datas.size()) {
                News news = datas.get(position);
                holder.tv_date.setText(Html.fromHtml(news.getDate()));
                holder.tv_content.setText(Html.fromHtml(news.getContent()));
            }




        }

        @Override
        public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup viewGroup) {return null;}

        @Override
        public void onBindHeaderViewHolder(RecyclerView.ViewHolder viewHolder, int i) {}


        @Override
        public int getAdapterItemCount() {
            return datas.size();
        }

        @Override
        public long generateHeaderId(int i) {
            return 0;
        }

        public void addAll(List<News> data) {
            datas.addAll(data);
            notifyDataSetChanged();
        }
        public void insert(News news, int position) {
            insert(datas, news, position);
        }
        public void remove(int position) {
            remove(datas, position);
        }
        public void clear() {
            clear(datas);
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

    @Override
    public void onHiddenChanged(boolean hidden) {

        super.onHiddenChanged(hidden);
        if (isVisible()) {
            getData();
        }
    }
}
