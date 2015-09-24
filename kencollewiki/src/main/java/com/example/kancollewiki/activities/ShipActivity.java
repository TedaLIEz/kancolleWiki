package com.example.kancollewiki.activities;

import android.graphics.Bitmap;
import android.media.Image;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.example.kancollewiki.C;
import com.example.kancollewiki.R;
import com.example.kancollewiki.bean.ship.Ship;
import com.example.kancollewiki.fragment.ShipDetailFragment;
import com.example.kancollewiki.util.RequestManager;
import com.example.kancollewiki.util.Utils;

import org.jsoup.Connection;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ShipActivity extends BaseActivity {
    ImageLoader imageLoader;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.ship_viewpager)
    ViewPager viewPager;
    @Bind(R.id.tabs)
    TabLayout tabLayout;

    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ship);
        ButterKnife.bind(this);
        bundle = getIntent().getExtras();
        initView();
        Ship ship = (Ship) bundle.getSerializable("ship");
        Utils.log(ship.toString());
    }

    private void initView() {
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_navigate_before_white_36dp);
        actionBar.setDisplayHomeAsUpEnabled(true);
        if (viewPager != null) {
            setupViewPager(viewPager);
        }

        tabLayout.setupWithViewPager(viewPager);
    }
    private void setupViewPager(ViewPager viewPager) {
        ShipFragmentAdapter adapter = new ShipFragmentAdapter(getSupportFragmentManager());
        ShipDetailFragment shipDetailFragment = new ShipDetailFragment();
        ShipDetailFragment shipDetailFragment1 = new ShipDetailFragment();
        ShipDetailFragment shipDetailFragment2 = new ShipDetailFragment();
        shipDetailFragment1.setArguments(bundle);
        shipDetailFragment2.setArguments(bundle);
        shipDetailFragment.setArguments(bundle);
        adapter.addFragment(shipDetailFragment, "1");
        adapter.addFragment(shipDetailFragment1, "2");
        adapter.addFragment(shipDetailFragment2, "3");
        viewPager.setAdapter(adapter);
    }
    static class ShipFragmentAdapter extends FragmentPagerAdapter {
        private List<Fragment> mFragments = new ArrayList<>();
        private List<String> mFragmentsTitles = new ArrayList<>();
        public ShipFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentsTitles.add(title);
        }
        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentsTitles.get(position);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
