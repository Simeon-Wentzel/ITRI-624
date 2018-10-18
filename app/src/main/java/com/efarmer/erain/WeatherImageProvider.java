package com.efarmer.erain;

import android.graphics.Bitmap;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageRequest;

public class WeatherImageProvider {

    private static final String YAHOO_IMG_URL = "http://l.yimg.com/a/i/us/we/52/";

    @Override
    public Bitmap getImage(int code, RequestQueue requestQueue, final WeatherImageListener listener) {
        String imageURL = YAHOO_IMG_URL + code + ".gif";
        ImageRequest ir = new ImageRequest(imageURL, new Response.Listener<Bitmap>() {

            @Override
            public void onResponse(Bitmap response) {
                if (listener != null)
                    listener.onImageReady(response);
            }
        }, 0, 0, null, null);

        requestQueue.add(ir);
        return null;
    }

}
