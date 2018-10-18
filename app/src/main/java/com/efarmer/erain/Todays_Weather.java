package com.efarmer.erain;

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


import darkSkyGson.Alerts;
import darkSkyGson.Currently;

public class Todays_Weather extends AppCompatActivity {

    private Gson gson;
    private String lat, lon;
    private String URL = "https://api.darksky.net/forecast/5ef650b8d20db9df7d7a8c83e3a13af8/"+lat+","+lon+"?exclude=minutely,hourly,daily,alerts,flags";
    TextView precipitationOutput, humid;

    Currently currently = new Currently();
    Alerts alerts = new Alerts();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todays__weather);

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



