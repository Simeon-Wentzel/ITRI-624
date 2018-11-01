package com.efarmer.erain.Utills;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import com.efarmer.erain.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import darkSkyGson.Alerts;
import darkSkyGson.Currently;

public class Pull_Weather extends AppCompatActivity {

    private Gson gson;
    private String lat, lon;
    private String URL = "https://api.darksky.net/forecast/5ef650b8d20db9df7d7a8c83e3a13af8/37.8267,-122.4233?exclude=minutely,hourly,daily,alerts,flags";
    TextView precipitation, temperature, humidity, windSpeed;

    Currently currently = new Currently();
    Alerts alerts = new Alerts();

    public ImageButton imgbtnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*precipitation = (TextView) findViewById(R.id.lblPrecipitationOutput);
        temperature = (TextView) findViewById(R.id.lblTemperature_TW);
        humidity = (TextView) findViewById(R.id.lblHumidityOutput);
        windSpeed = (TextView) findViewById(R.id.lblWindSpeedOutput);
        imgbtnProfile = (ImageButton) findViewById(R.id.imgbtnProfile);*/


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response)  {
                        try {
                            GsonBuilder gsonBuilder = new GsonBuilder();
                            gson = gsonBuilder.create();
                            currently = gson.fromJson(response.getJSONObject("currently").toString(), Currently.class);
                            precipitation.setText(String.format("%s mm", currently.getPrecipIntensity()));
                            temperature.setText(String.format("%s °C", currently.getTemperature()));
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
}



