package com.efarmer.erain.Home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;


import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.efarmer.erain.Profile.EditActivity;
import com.efarmer.erain.Profile.ProfileActivity;
import com.efarmer.erain.R;
import com.efarmer.erain.Utills.BottomNavViewHelper;
import com.efarmer.erain.Utills.MySingleton;
import com.efarmer.erain.Utills.Pull_Weather;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import darkSkyGson.Currently;

import static java.lang.Math.round;


public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity";
    private static final int Activity_Num = 0;
    private Context mContext = HomeActivity.this;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private Gson gson;
    private String lat, lon;
    private String URL = "https://api.darksky.net/forecast/5ef650b8d20db9df7d7a8c83e3a13af8/-26.7145,27.0970?exclude=minutely,hourly,daily,alerts,flags";
    TextView precipitation, temperature;

    Currently currently = new Currently();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_home);
        setBottomNavigationView();
        setDrawerLayout();
        setActionBar();
        setWeather();

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
                        Intent intentEdit = new Intent(mContext, EditActivity.class);
                        mContext.startActivity(intentEdit);
                        drawerLayout.closeDrawers();
                        break;

                }
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        return actionBarDrawerToggle.onOptionsItemSelected(menuItem) || super.onOptionsItemSelected(menuItem);

    }

    public void setWeather() {
        precipitation = (TextView) findViewById(R.id.txtrainfall);
        temperature = (TextView) findViewById(R.id.txttemp);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response)  {
                        try {
                            GsonBuilder gsonBuilder = new GsonBuilder();
                            gson = gsonBuilder.create();
                            currently = gson.fromJson(response.getJSONObject("currently").toString(), Currently.class);
                            precipitation.setText(String.format("%s mm", currently.getPrecipIntensity()));
                            temperature.setText(String.format("%s °C", round((currently.getTemperature() - 32) * 0.5555556 ), 2));
                            //temperature.setText(String.format("%s °C", (((currently.getTemperature() - 32) * 0.5555556 ))));
                           /* humidity.setText(String.format("%s %%", currently.getHumidity()));
                            windSpeed.setText(String.format("%s km/h", currently.getWindSpeed()));*/
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


    public void setActionBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
    }

    public void setDrawerLayout() {
        drawerLayout = (DrawerLayout) findViewById(R.id.home_drawer);
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
