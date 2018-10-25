package com.efarmer.erain;

public class Seed
{
    //Declare Variables
    int s_id;
    String s_name;
    String s_preferable_months_of_season;
    int s_h2o_min_req;
    int s_h2o_max_req;
    int s_weekly_h2o_seed;
    int s_weekly_h2o_crop;
    int s_eta_sprout_min;
    int s_eta_sprout_max;
    int s_eth_min;
    int s_eth_max;


    //Constructor
    public Seed()
    {

    }

    public Seed(String s_name, String s_preferable_months_of_season, int s_h2o_min_req, int s_h2o_max_req, int s_weekly_h2o_seed, int s_weekly_h2o_crop, int s_eta_sprout_min, int s_eta_sprout_max, int s_eth_min, int s_eth_max)
    {
        this.s_name = s_name;
        this.s_preferable_months_of_season = s_preferable_months_of_season;
        this.s_h2o_min_req = s_h2o_min_req;
        this.s_h2o_max_req = s_h2o_max_req;
        this.s_weekly_h2o_seed = s_weekly_h2o_seed;
        this.s_weekly_h2o_crop = s_weekly_h2o_crop;
        this.s_eta_sprout_min = s_eta_sprout_min;
        this.s_eta_sprout_max = s_eta_sprout_max;
        this.s_eth_min = s_eth_min;
        this.s_eth_max = s_eth_max;
    }

    public Seed(int s_id, String s_name, String s_preferable_months_of_season, int s_h2o_min_req, int s_h2o_max_req, int s_weekly_h2o_seed, int s_weekly_h2o_crop, int s_eta_sprout_min, int s_eta_sprout_max, int s_eth_min, int s_eth_max)
    {
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_preferable_months_of_season = s_preferable_months_of_season;
        this.s_h2o_min_req = s_h2o_min_req;
        this.s_h2o_max_req = s_h2o_max_req;
        this.s_weekly_h2o_seed = s_weekly_h2o_seed;
        this.s_weekly_h2o_crop = s_weekly_h2o_crop;
        this.s_eta_sprout_min = s_eta_sprout_min;
        this.s_eta_sprout_max = s_eta_sprout_max;
        this.s_eth_min = s_eth_min;
        this.s_eth_max = s_eth_max;
    }

    //ID get-set-method
    public int getS_id()
    {
        return s_id;
    }

    public void setS_id(int s_id)
    {
        this.s_id = s_id;
    }

    //name get-set-method
    public String getS_name()
    {
        return s_name;
    }

    public void setS_name(String s_name)
    {
        this.s_name = s_name;
    }

    // preferable months of season get-set-method
    public String getS_PrefMonth()
    {
        return s_preferable_months_of_season;
    }

    public void setS_PrefMonth(String s_preferable_months_of_season)
    {
        this.s_preferable_months_of_season = s_preferable_months_of_season;
    }

    //h2o min requirements get-set-method
    public int getS_minH2oReq()
    {
        return s_h2o_min_req;
    }

    public void setS_minH2oReq(int s_h2o_min_req)
    {
        this.s_h2o_min_req = s_h2o_min_req;
    }

    //h2o max requirements get-set-method
    public int getS_maxH2oReq()
    {
        return s_h2o_max_req;
    }

    public void setS_maxH2oReq(int s_h2o_max_req)
    {
        this.s_h2o_max_req = s_h2o_max_req;
    }

    //weekly h2o seed get-set-method
    public int getS_weeklyH2oSeed()
    {
        return s_weekly_h2o_seed;
    }

    public void setS_weeklyH2oSeed(int s_weekly_h2o_seed)
    {
        this.s_weekly_h2o_seed = s_weekly_h2o_seed;
    }

    //weekly h2o crop get-set-method
    public int getS_weeklyH2oCrop()
    {
        return s_weekly_h2o_crop;
    }

    public void setS_weeklyH2oCrop(int s_weekly_h2o_crop)
    {
        this.s_weekly_h2o_crop = s_weekly_h2o_crop;
    }

    //estimated min sprout time get-set-method
    public int getS_etaSproutMin()
    {
        return s_eta_sprout_min;
    }

    public void setS_etaSproutMin(int s_eta_sprout_min)
    {
        this.s_eta_sprout_min = s_eta_sprout_min;
    }

    //estimated max sprout time get-set-method
    public int getS_etaSproutMax()
    {
        return s_eta_sprout_max;
    }

    public void setS_etaSproutMax(int s_eta_sprout_max)
    {
        this.s_eta_sprout_max = s_eta_sprout_max;
    }

    //estimate min time to harvest get-set-method
    public int getS_ethMin()
    {
        return s_eth_min;
    }

    public void setS_ethMin(int s_eth_min)
    {
        this.s_eth_min = s_eth_min;
    }

    //estimate max time to harvest get-set-method
    public int getS_ethMax()
    {
        return s_eth_max;
    }

    public void setS_ethMax(int s_eth_max)
    {
        this.s_eth_max = s_eth_max;
    }
}
