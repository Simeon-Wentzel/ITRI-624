package com.efarmer.erain;

public class Crops
{
    //Declare Variables
    int c_id;
    String c_name;
    int c_expected_weekly_rain;
    int c_weekly_h2o_top_up_req;
    String c_planted_date;
    int c_days_old;

    //Constructor
    public Crops()
    {

    }

    public Crops(String c_name, int c_expected_weekly_rain, int c_weekly_h2o_top_up_req, String c_planted_date, int c_days_old)
    {
        this.c_name = c_name;
        this.c_expected_weekly_rain = c_expected_weekly_rain;
        this.c_weekly_h2o_top_up_req = c_weekly_h2o_top_up_req;
        this.c_planted_date = c_planted_date;
        this.c_days_old = c_days_old;
    }

    public Crops(int c_id, String c_name, int c_expected_weekly_rain, int c_weekly_h2o_top_up_req, String c_planted_date, int c_days_old)
    {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_expected_weekly_rain = c_expected_weekly_rain;
        this.c_weekly_h2o_top_up_req = c_weekly_h2o_top_up_req;
        this.c_planted_date = c_planted_date;
        this.c_days_old = c_days_old;
    }

    //ID get-set-method
    public int getC_id()
    {
        return c_id;
    }

    public void setC_id(int c_id)
    {
        this.c_id = c_id;
    }

    //name get-set-method
    public String getC_name()
    {
        return c_name;
    }

    public void setC_name(String c_name)
    {
        this.c_name = c_name;
    }

    // expected weekly rain
    public int getC_ExpectedWeeklyRain()
    {
        return c_expected_weekly_rain;
    }

    public void setC_ExpectedWeeklyRain(int c_expected_weekly_rain)
    {
        this.c_expected_weekly_rain = c_expected_weekly_rain;
    }

    //h2o min requirements get-set-method
    public int getC_weeklyH2oTopUpReq()
    {
        return c_weekly_h2o_top_up_req;
    }

    public void setC_weeklyH2oTopUpReq(int c_weekly_h2o_top_up_req)
    {
        this.c_weekly_h2o_top_up_req = c_weekly_h2o_top_up_req;
    }

    //date planted get-set-method
    public String getC_plantDate()
    {
        return c_planted_date;
    }

    public void setC_plantDate(String c_planted_date)
    {
        this.c_planted_date = c_planted_date;
    }

    //plant days age in days get-set-method
    public int getC_daysOld()
    {
        return c_days_old;
    }

    public void setC_daysOld(int c_days_old)
    {
        this.c_days_old = c_days_old;
    }
}
