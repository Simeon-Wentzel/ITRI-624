
package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("time")
    @Expose
    private Integer time;
    @SerializedName("precipIntensity")
    @Expose
    private Double precipIntensity;
    @SerializedName("precipIntensityError")
    @Expose
    private Double precipIntensityError;
    @SerializedName("precipProbability")
    @Expose
    private Double precipProbability;
    @SerializedName("precipType")
    @Expose
    private String precipType;

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Data withTime(Integer time) {
        this.time = time;
        return this;
    }

    public Double getPrecipIntensity() {
        return precipIntensity;
    }

    public void setPrecipIntensity(Double precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public Data withPrecipIntensity(Double precipIntensity) {
        this.precipIntensity = precipIntensity;
        return this;
    }

    public Double getPrecipIntensityError() {
        return precipIntensityError;
    }

    public void setPrecipIntensityError(Double precipIntensityError) {
        this.precipIntensityError = precipIntensityError;
    }

    public Data withPrecipIntensityError(Double precipIntensityError) {
        this.precipIntensityError = precipIntensityError;
        return this;
    }

    public Double getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(Double precipProbability) {
        this.precipProbability = precipProbability;
    }

    public Data withPrecipProbability(Double precipProbability) {
        this.precipProbability = precipProbability;
        return this;
    }

    public String getPrecipType() {
        return precipType;
    }

    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    public Data withPrecipType(String precipType) {
        this.precipType = precipType;
        return this;
    }

}
