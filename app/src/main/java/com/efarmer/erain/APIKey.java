package com.efarmer.erain;

import android.app.Application;

import com.johnhiott.darkskyandroidlib.ForecastApi;

public class APIKey extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ForecastApi.create("5ef650b8d20db9df7d7a8c83e3a13af8");
    }
}
