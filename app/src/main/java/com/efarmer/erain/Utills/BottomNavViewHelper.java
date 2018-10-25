package com.efarmer.erain.Utills;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.efarmer.erain.Crops.CropsActivity;
import com.efarmer.erain.Home.HomeActivity;
import com.efarmer.erain.R;
import com.efarmer.erain.WeatherPackage.WeatherActivity;

public class BottomNavViewHelper {

    private static final String TAG = "BottomNamViewHelper";


    public static void enableNavigation(final Context context, BottomNavigationView view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_home:
                        Intent intentHome = new Intent(context, HomeActivity.class);
                        context.startActivity(intentHome);
                        break;
                    case R.id.navigation_crops:
                        Intent intentCrops = new Intent(context, CropsActivity.class);
                        context.startActivity(intentCrops);
                        break;
                    case R.id.navigation_weather:
                        Intent intentWeather = new Intent(context, WeatherActivity.class);
                        context.startActivity(intentWeather);
                        break;
                }
                return false;
            }
        });
    }
}
