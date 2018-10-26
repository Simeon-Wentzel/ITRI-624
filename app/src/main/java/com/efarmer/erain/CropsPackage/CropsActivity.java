package com.efarmer.erain.CropsPackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.efarmer.erain.Profile.ProfileActivity;
import com.efarmer.erain.R;
import com.efarmer.erain.Utills.BottomNavViewHelper;
import com.efarmer.erain.Utills.ViewPagerAdapter;


public class CropsActivity extends AppCompatActivity {

    private static final String TAG = "CropsActivity";
    private static final int Activity_Num = 2;
    private Context mContext = CropsActivity.this;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_crops);
        setDrawerLayout();
        setActionBar();
        setBottomNavigationView();


        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())   {
                    case R.id.navigation_profile:
                        Intent intentProfile = new Intent(mContext, ProfileActivity.class);
                        mContext.startActivity(intentProfile);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.navigation_edit_profle:
                        Toast.makeText(CropsActivity.this, "Edit Profile",Toast.LENGTH_SHORT).show();

                }
                return false;
            }
        });

        //The setContentAndPager method must be last in the onCreate
        setContentAndPager();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        return actionBarDrawerToggle.onOptionsItemSelected(menuItem) || super.onOptionsItemSelected(menuItem);

    }

    public void setContentAndPager(){
        viewPager = (ViewPager) findViewById(R.id.crops_viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.crops_tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment(), "Plants");
        adapter.addFragment(new Fragment(), "Crops");
        adapter.addFragment(new Fragment(), "Stats");
        viewPager.setAdapter(adapter);

    }

    public void setActionBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
    }

    public void setDrawerLayout() {
        drawerLayout = (DrawerLayout) findViewById(R.id.crops_drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.Open,R.string.Close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


    }

    private void setBottomNavigationView(){
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
        BottomNavViewHelper.enableNavigation(mContext, bottomNavigationView);

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(Activity_Num);
        menuItem.setChecked(true);
    }
}
