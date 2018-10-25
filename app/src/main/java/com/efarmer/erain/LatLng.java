package com.efarmer.erain;

class LatLng {
    double lat;
    double lng;

    public LatLng(double lat, double lng)
    {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}
