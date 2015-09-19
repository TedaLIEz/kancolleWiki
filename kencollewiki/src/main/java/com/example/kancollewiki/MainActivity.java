package com.example.kancollewiki;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.kancollewiki.fragment.CrusadeFragment;
import com.example.kancollewiki.fragment.EquipFragment;
import com.example.kancollewiki.fragment.HomeFragment;
import com.example.kancollewiki.fragment.LevelFragment;
import com.example.kancollewiki.fragment.ShipFragment;
import com.example.kancollewiki.fragment.TaskFragment;

import com.example.kancollewiki.activities.BaseActivity;
import com.example.kancollewiki.util.Utils;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @Bind(R.id.navigation)
    NavigationView navigationView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    Fragment homeFragment,shipFragment,levelFragment,taskFragment,crusadeFragment,equipFragment;
    Fragment currentFragment = null;
    FragmentManager manager = getFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFragments();
        initView();
    }

    private void initFragments() {
        if (homeFragment == null) {
            homeFragment = new HomeFragment();
        } else {
            homeFragment = manager.findFragmentByTag(homeFragment.getClass().getSimpleName());
        }
        if (levelFragment == null) {
            levelFragment = new LevelFragment();
        } else {
            levelFragment = manager.findFragmentByTag(levelFragment.getClass().getSimpleName());
        }
        if (shipFragment == null) {
            shipFragment = new ShipFragment();
        } else {
            shipFragment = manager.findFragmentByTag(shipFragment.getClass().getSimpleName());
        }
        if (crusadeFragment == null) {
            crusadeFragment = new CrusadeFragment();
        } else {
            crusadeFragment = manager.findFragmentByTag(crusadeFragment.getClass().getSimpleName());
        }
        if (equipFragment == null) {
            equipFragment = new EquipFragment();
        } else {
            equipFragment = manager.findFragmentByTag(equipFragment.getClass().getSimpleName());
        }
        if (taskFragment == null) {
            taskFragment = new TaskFragment();
        } else {
            taskFragment = manager.findFragmentByTag(taskFragment.getClass().getSimpleName());
        }
    }

    private void initView() {
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        getFragmentManager().beginTransaction().add(R.id.container, homeFragment).commit();
        currentFragment = homeFragment;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                switch (menuItem.getItemId()) {
                    case R.id.home:
                        switchFragment(homeFragment);
                        toolbar.setTitle(HomeFragment.class.getSimpleName());
                        break;
                    case R.id.level:
                        switchFragment(levelFragment);
                        break;
                    case R.id.ship:
                        switchFragment(shipFragment);

                        toolbar.setTitle(ShipFragment.class.getSimpleName());
                        break;
                    case R.id.equipment:
                        switchFragment(equipFragment);
                        toolbar.setTitle(EquipFragment.class.getSimpleName());
                        break;
                    case R.id.task:
                        switchFragment(taskFragment);
                        toolbar.setTitle(TaskFragment.class.getSimpleName());
                        break;
                    case R.id.crusade:
                        switchFragment(crusadeFragment);
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

    private void switchFragment(Fragment to) {
        if(currentFragment != to) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            if (!to.isAdded()) {
                transaction.hide(currentFragment).add(R.id.container, to, to.getClass().getSimpleName()).commit();
            } else {
                transaction.hide(currentFragment).show(to).commit();
            }
            currentFragment = to;
        }
    }
}