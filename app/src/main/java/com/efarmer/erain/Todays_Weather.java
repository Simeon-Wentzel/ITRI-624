package com.efarmer.erain;

import android.location.Address;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.location.Geocoder;


import darkSkyGson.Alerts;
import darkSkyGson.Currently;


public class Todays_Weather extends AppCompatActivity {

    private Gson gson;
    Long tsLong = System.currentTimeMillis()/1000;
    String ts = tsLong.toString();

    private String URL;
    TextView precipitationOutput, humid;

    Currently currently = new Currently();
    Alerts alerts = new Alerts();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todays__weather);
        Log.e("Time", String.format("%s ", ts));
        if(Geocoder.isPresent()){
            try {
                String location = "Potchefstroom";
                Geocoder gc = new Geocoder(this);
                List<Address> addresses= gc.getFromLocationName(location, 5); // get the found Address Objects

                List<LatLng> ll = new ArrayList<LatLng>(addresses.size()); // A list to save the coordinates if they are available
                for(Address a : addresses){
                    if(a.hasLatitude() && a.hasLongitude()){
                        ll.add(new LatLng(a.getLatitude(), a.getLongitude()));

                        Log.e("Lat", String.format("%s ", a.getLatitude()));

                        Log.e("Lon", String.format("%s ", a.getLongitude()));
                        URL = "https://api.darksky.net/forecast/5ef650b8d20db9df7d7a8c83e3a13af8/"+a.getLatitude()+","+a.getLongitude()+","+ ts +"?exclude=current,flags";
                    }
                }

            } catch (IOException e) {
                // handle the exception
            }
        }

        precipitationOutput = (TextView) findViewById(R.id.lblPrecipitationOutput);
        /*final TextView textView2 = findViewById(R.id.lblTemperature);
        final TextView textView3 = findViewById(R.id.lblHumidity);
        final TextView textView4 = findViewById(R.id.lblWind_Speed);*/

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response)  {
                        try {
                            GsonBuilder gsonBuilder = new GsonBuilder();
                            gson = gsonBuilder.create();
                            currently = gson.fromJson(response.getJSONObject("currently").toString(), Currently.class);
                            precipitationOutput.setText(String.format("%s ", currently.getTemperature()));
                            Log.e("Temperature", String.format("%s ", currently.getTemperature()));
                        }catch (Exception e){

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


}



