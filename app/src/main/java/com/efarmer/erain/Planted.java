package com.efarmer.erain;

public class Planted
{
    //Declare Variables
    int p_id;
    String p_name;
    int p_expected_weekly_rain;
    int p_weekly_h2o_top_up_req;
    String p_planted_date;
    int p_days_old;

    //Constructor
    public Planted()
    {

    }

    public Planted(String p_name, int p_expected_weekly_rain, int p_weekly_h2o_top_up_req, String p_planted_date, int p_days_old)
    {
        this.p_name = p_name;
        this.p_expected_weekly_rain = p_expected_weekly_rain;
        this.p_weekly_h2o_top_up_req = p_weekly_h2o_top_up_req;
        this.p_planted_date = p_planted_date;
        this.p_days_old = p_days_old;
    }

    public Planted(int p_id, String p_name, int p_expected_weekly_rain, int p_weekly_h2o_top_up_req, String p_planted_date, int p_days_old)
    {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_expected_weekly_rain = p_expected_weekly_rain;
        this.p_weekly_h2o_top_up_req = p_weekly_h2o_top_up_req;
        this.p_planted_date = p_planted_date;
        this.p_days_old = p_days_old;
    }

    //ID get-set-method
    public int getP_id()
    {
        return p_id;
    }

    public void setP_id(int p_id)
    {
        this.p_id = p_id;
    }

    //name get-set-method
    public String getP_name()
    {
        return p_name;
    }

    public void setP_name(String p_name)
    {
        this.p_name = p_name;
    }

    // expected weekly rain
    public int getP_ExpectedWeeklyRain()
    {
        return p_expected_weekly_rain;
    }

    public void setP_ExpectedWeeklyRain(int p_expected_weekly_rain)
    {
        this.p_expected_weekly_rain = p_expected_weekly_rain;
    }

    //h2o min requirements get-set-method
    public int getP_weeklyH2oTopUpReq()
    {
        return p_weekly_h2o_top_up_req;
    }

    public void setP_weeklyH2oTopUpReq(int p_weekly_h2o_top_up_req)
    {
        this.p_weekly_h2o_top_up_req = p_weekly_h2o_top_up_req;
    }

    //date planted get-set-method
    public String getP_plantDate()
    {
        return p_planted_date;
    }

    public void setP_plantDate(String p_planted_date)
    {
        this.p_planted_date = p_planted_date;
    }

    //plant days age in days get-set-method
    public int getP_daysOld()
    {
        return p_days_old;
    }

    public void setP_daysOld(int p_days_old)
    {
        this.p_days_old = p_days_old;
    }
}
