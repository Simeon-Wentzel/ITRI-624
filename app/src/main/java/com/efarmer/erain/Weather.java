package com.efarmer.erain;

public class Weather {
    //Declare Variables
    int w_id;
    String w_wind_speed;
    String w_humidity;
    String w_rainfall;
    String w_temperature;
    String w_date;

    //Constructor
    public Weather() {

    }

    public Weather(String w_wind_speed, String w_humidity, String w_rainfall, String w_temperature, String w_date) {
        this.w_wind_speed = w_wind_speed;
        this.w_humidity = w_humidity;
        this.w_rainfall = w_rainfall;
        this.w_temperature = w_temperature;
        this.w_date = w_date;

    }

    public Weather(int w_id, String w_wind_speed, String w_humidity, String w_rainfall, String w_temperature, String w_date) {
        this.w_id = w_id;
        this.w_wind_speed = w_wind_speed;
        this.w_humidity = w_humidity;
        this.w_rainfall = w_rainfall;
        this.w_temperature = w_temperature;
        this.w_date = w_date;
    }

    //ID get-set-method
    public int getW_id() {
        return w_id;
    }

    public void setW_id(int w_id) {
        this.w_id = w_id;
    }

    //wind speed get-set-method
    public String getW_windSpeed() {
        return w_wind_speed;
    }

    public void setW_windSpeed(String w_wind_speed) {
        this.w_wind_speed = w_wind_speed;
    }

    // humidity get-set-methods
    public String getW_humidity() {
        return w_humidity;
    }

    public void setW_humidity(String w_humidity) {
        this.w_humidity = w_humidity;
    }

    //rainfall get-set-method
    public String getW_rainfall() {
        return w_rainfall;
    }

    public void setW_rainfall(String w_rainfall) {
        this.w_rainfall = w_rainfall;
    }

    //temperature get-set-method
    public String getW_temperature() {
        return w_temperature;
    }

    public void setW_temperature(String w_temperature) {
        this.w_temperature = w_temperature;
    }

    //date get-set-method
    public String getW_date(){
        return w_date;
    }

    public void setW_date(String w_date){
        this.w_date = w_date;
    }
}
