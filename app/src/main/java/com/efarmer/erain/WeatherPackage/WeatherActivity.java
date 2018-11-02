package com.efarmer.erain.WeatherPackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
//import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.String;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.efarmer.erain.Profile.ProfileActivity;
import com.efarmer.erain.R;
import com.efarmer.erain.Utills.BottomNavViewHelper;
import com.efarmer.erain.Utills.MySingleton;
import com.efarmer.erain.Utills.ViewPagerAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.json.JSONObject;

import darkSkyGson.Currently;


public class WeatherActivity extends AppCompatActivity {

    private static final String TAG = "CropsActivity";
    private static final int Activity_Num = 1;
    private Context mContext = WeatherActivity.this;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private TabLayout tabLayout;
    private Gson gson;
    private String lat, lon;
    private String URL = "https://api.darksky.net/forecast/5ef650b8d20db9df7d7a8c83e3a13af8/37.8267,-122.4233?exclude=minutely,hourly,daily,alerts,flags";
    TextView precipitation, humidity, windSpeed;
    Currently currently = new Currently();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_weather);
        setBottomNavigationView();
        setDrawerLayout();
        setActionBar();
        setWeather();

        final NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())   {
                    case R.id.navigation_profile:
                        Intent intentProfile = new Intent(mContext, ProfileActivity.class);
                        mContext.startActivity(intentProfile);
                        break;
                    case R.id.navigation_edit_profle:
                        drawerLayout.closeDrawers();
                        Toast.makeText(WeatherActivity.this, "Edit Profile",Toast.LENGTH_SHORT).show();

                }
                return false;
            }
        });

        //The setContentAndPager method must be last in the onCreate
        setContentAndPager();
    }

    public void setWeather() {
        precipitation = (TextView) findViewById(R.id.txtPrecipitation);
        humidity = (TextView) findViewById(R.id.txtHumidity);
        windSpeed = (TextView) findViewById(R.id.txtWindspeed);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response)  {
                        try {
                            GsonBuilder gsonBuilder = new GsonBuilder();
                            gson = gsonBuilder.create();
                            currently = gson.fromJson(response.getJSONObject("currently").toString(), Currently.class);
                            precipitation.setText(String.format("%s mm", currently.getPrecipIntensity()));
                            humidity.setText(String.format("%s %%", currently.getHumidity()));
                            windSpeed.setText(String.format("%s km/h", currently.getWindSpeed()));
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        MySingleton.getInstance(this).addToRequestque(jsonObjectRequest);
    }



    public void setContentAndPager(){
        /*viewPager = (ViewPager) findViewById(R.id.weather_viewpager);
        setupViewPager(viewPager);*/
        tabLayout = (TabLayout) findViewById(R.id.weather_tabs);
        /*tabLayout.setupWithViewPager(viewPager);*/
        tabLayout.addTab(tabLayout.newTab().setText("Precipitation"));
        tabLayout.addTab(tabLayout.newTab().setText("Windspeed"));
        tabLayout.addTab(tabLayout.newTab().setText("Temperature"));
        tabLayout.setTabGravity(tabLayout.GRAVITY_FILL);


        final ViewPager viewPager = (ViewPager) findViewById(R.id.weather_viewpager);
        final com.efarmer.erain.WeatherPackage.PagerAdapter adapter = new com.efarmer.erain.WeatherPackage.PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0) {

                    GraphView graph = (GraphView) findViewById(R.id.graph_precipitation);
                    //getHorizontalAxisTitle();
                    LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                            new DataPoint(1, 10),
                            new DataPoint(2, 3),
                            new DataPoint(3, 0),
                            new DataPoint(4, 0),
                            new DataPoint(5, 0)
                    });
                    graph.addSeries(series);
                    StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
                    staticLabelsFormatter.setHorizontalLabels(new String[] {"Mon","Tue","Wed","Thu","Fri"});
                    graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
                    /*graph.getViewport().setMinX(0);
                    graph.getViewport().setMaxX(6);*/

                    // set manual Y bounds
                    graph.getViewport().setYAxisBoundsManual(true);
                    graph.getViewport().setXAxisBoundsManual(true);
                    graph.getViewport().setMinY(0);
                    graph.getViewport().setMaxY(60);
                    graph.getViewport().setScrollable(true);
                }

                if(tab.getPosition() == 1){
                    GraphView graph1 = (GraphView) findViewById(R.id.graph_windspeed);
                    // set manual X bounds


                    //getHorizontalAxisTitle();
                    LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(new DataPoint[] {
                            new DataPoint(1, 10),
                            new DataPoint(2, 8),
                            new DataPoint(3, 20),
                            new DataPoint(4, 15),
                            new DataPoint(5, 5)
                    });
                    graph1.addSeries(series1);
                    StaticLabelsFormatter staticLabelsFormatter1 = new StaticLabelsFormatter(graph1);
                    staticLabelsFormatter1.setHorizontalLabels(new String[] {"Mon","Tue","Wed","Thu","Fri"});
                    graph1.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter1);
                    /*graph.getViewport().setMinX(0);
                    graph.getViewport().setMaxX(6);*/

                    // set manual Y bounds
                    graph1.getViewport().setYAxisBoundsManual(true);
                    graph1.getViewport().setXAxisBoundsManual(true);
                    graph1.getViewport().setMinY(0);
                    graph1.getViewport().setMaxY(40);

                }

                if(tab.getPosition() == 2){
                    GraphView graph2 = (GraphView) findViewById(R.id.graph_temp);
                    // set manual X bounds


                    //getHorizontalAxisTitle();
                    LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[] {
                            new DataPoint(1, 32),
                            new DataPoint(2, 24),
                            new DataPoint(3, 22),
                            new DataPoint(4, 25),
                            new DataPoint(5, 29)
                    });
                    graph2.addSeries(series2);
                    StaticLabelsFormatter staticLabelsFormatter2 = new StaticLabelsFormatter(graph2);
                    staticLabelsFormatter2.setHorizontalLabels(new String[] {"Mon","Tue","Wed","Thu","Fri"});
                    graph2.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter2);
                    /*graph.getViewport().setMinX(0);
                    graph.getViewport().setMaxX(6);*/

                    // set manual Y bounds
                    graph2.getViewport().setYAxisBoundsManual(true);
                    graph2.getViewport().setXAxisBoundsManual(true);
                    graph2.getViewport().setMinY(0);
                    graph2.getViewport().setMaxY(40);

                }
            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentPrecipitation(), "Precipitation");
        adapter.addFragment(new FragmentWindspeed(), "Windspeed");
        adapter.addFragment(new FragmentTemperature(), "Temperature");
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        return actionBarDrawerToggle.onOptionsItemSelected(menuItem) || super.onOptionsItemSelected(menuItem);
    }

    public void setActionBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
    }

    public void setDrawerLayout() {
        drawerLayout = (DrawerLayout) findViewById(R.id.weather_drawer);
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
