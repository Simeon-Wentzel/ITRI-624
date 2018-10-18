package com.efarmer.erain;

import android.graphics.Bitmap;

import com.android.volley.RequestQueue;

public interface IWeatherImageProvider {

    Bitmap getImage(int code, RequestQueue requestQueue, WeatherImageListener listener);


    interface WeatherImageListener {
        void onImageReady(Bitmap image);
    }


}
