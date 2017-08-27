package com.example.pradeep.picpose.ui.home;

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
import com.example.pradeep.picpose.ui.fragments.men.MenFragment;
import com.example.pradeep.picpose.ui.fragments.trending.TrendingFragment;
import com.example.pradeep.picpose.ui.fragments.women.WomenFragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class HomeActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private Toolbar mToolbar;
    private ActionBar actionBar;
    private FragmentDrawer drawerFragment;
    private AdView adViewBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setToolbar();
        displayDefaultScreen();
        displayFragment(0);
        initAdViewBanner();
    }

    public void initAdViewBanner(){
        adViewBanner = (AdView) findViewById(R.id.adViewBanner);
        MobileAds.initialize(getApplicationContext(), getResources().getString(R.string.banner_home_footer));
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("581351123D5FF66504BA8CECE6AE1743")
                .build();
        adViewBanner.loadAd(adRequest);
    }


    @Override
    protected void onPause() {
        if(adViewBanner != null){
            adViewBanner.pause();
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(adViewBanner != null){
            adViewBanner.resume();
        }
    }

    @Override
    protected void onDestroy() {
        if(adViewBanner != null){
            adViewBanner.destroy();
        }
        super.onDestroy();
    }


    public void displayDefaultScreen(){
        drawerFragment = (FragmentDrawer) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);
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
