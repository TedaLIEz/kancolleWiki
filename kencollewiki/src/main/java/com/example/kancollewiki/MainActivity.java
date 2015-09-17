package com.example.kancollewiki;

import android.animation.StateListAnimator;
import android.app.FragmentManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.example.kancollewiki.fragment.CrusadeFragment;
import com.example.kancollewiki.fragment.EquipFragment;
import com.example.kancollewiki.fragment.HomeFragment;
import com.example.kancollewiki.fragment.LevelFragment;
import com.example.kancollewiki.fragment.ShipFragment;
import com.example.kancollewiki.fragment.TaskFragment;
import com.example.kancollewiki.util.Utils;
import com.zzt.inbox.interfaces.OnDragStateChangeListener;
import com.zzt.inbox.widget.InboxLayoutBase;
import com.zzt.inbox.widget.InboxLayoutListView;
import com.zzt.inbox.widget.InboxBackgroundScrollView;

import com.example.kancollewiki.activities.BaseActivity;

import java.util.logging.Level;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @Bind(R.id.navigation)
    NavigationView navigationView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    FragmentManager manager = getFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }
    private void init() {
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        manager.beginTransaction().replace(R.id.container, new HomeFragment()).commit();
                        toolbar.setTitle(HomeFragment.class.getSimpleName());
                        break;
                    case R.id.ship:
                        manager.beginTransaction().replace(R.id.container, new ShipFragment()).commit();
                        toolbar.setTitle(ShipFragment.class.getSimpleName());
                        break;
                    case R.id.level:
                        manager.beginTransaction().replace(R.id.container, new LevelFragment()).commit();
                        toolbar.setTitle(LevelFragment.class.getSimpleName());
                        break;
                    case R.id.equipment:
                        manager.beginTransaction().replace(R.id.container, new EquipFragment()).commit();
                        toolbar.setTitle(EquipFragment.class.getSimpleName());
                        break;
                    case R.id.task:
                        manager.beginTransaction().replace(R.id.container, new TaskFragment()).commit();
                        toolbar.setTitle(TaskFragment.class.getSimpleName());
                        break;
                    case R.id.crusade:
                        manager.beginTransaction().replace(R.id.container, new CrusadeFragment()).commit();
                        toolbar.setTitle(CrusadeFragment.class.getSimpleName());
                        break;
                    default:
                        break;
                }
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }

        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}