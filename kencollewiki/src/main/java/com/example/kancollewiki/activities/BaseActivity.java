package com.example.kancollewiki.activities;

import android.app.ActionBar;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.kancollewiki.R;

public class BaseActivity extends AppCompatActivity {
    ActionBar actionBar = getActionBar();

    public void setAppIcon(int drawable) {
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setIcon(drawable);
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
