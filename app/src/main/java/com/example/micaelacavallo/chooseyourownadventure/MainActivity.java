package com.example.micaelacavallo.chooseyourownadventure;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    StartFragment mStartFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insertStartFragment();

    }

    private void insertStartFragment() {
        mStartFragment  = new StartFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().
                add(R.id.container, mStartFragment).
                addToBackStack(null).
                commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        Boolean handled = false;
        switch (id){
            case R.id.action_settings:
                Intent intent = new Intent(this, AppSettingsActivity.class);
                startActivity(intent);
                handled=true;
                break;
        }
        if (!handled)
        {
            handled = super.onOptionsItemSelected(item);
        }
        return handled;
    }
}
