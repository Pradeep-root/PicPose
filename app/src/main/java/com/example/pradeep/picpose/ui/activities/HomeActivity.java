package com.example.pradeep.picpose.ui.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.pradeep.picpose.R;
import com.example.pradeep.picpose.ui.fragments.FragmentDrawer;
import com.example.pradeep.picpose.ui.fragments.MenFragment;
import com.example.pradeep.picpose.ui.fragments.TrendingFragment;
import com.example.pradeep.picpose.ui.fragments.WomenFragment;

public class HomeActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    Toolbar mToolbar;
    ActionBar actionBar;
    private FragmentDrawer drawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setToolbar();
        drawerFragment = (FragmentDrawer) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);
        displayFragment(0);
    }

    public void setToolbar(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
            displayFragment(position);
    }


    private void displayFragment(int position){
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position){
            case 0:
                fragment = new TrendingFragment();
                title = getString(R.string.fragment_trending);
                break;
            case 1:
                fragment = new MenFragment();
                title = getString(R.string.fragment_men);
                break;
            case 2:
                fragment = new WomenFragment();
                title = getString(R.string.fragment_women);
                break;
            default:
                break;

        }

        if(fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            getSupportActionBar().setTitle(title);
        }
    }
}
