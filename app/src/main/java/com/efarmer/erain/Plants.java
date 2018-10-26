package com.efarmer.erain;

public class Plants
{
    //Declare Variables
    int p_id;
    String p_name;
    String p_preferable_months_of_season;
    int p_h2o_min_req;
    int p_h2o_max_req;
    int p_weekly_h2o_seed;
    int p_weekly_h2o_crop;
    int p_eta_sprout_min;
    int p_eta_sprout_max;
    int p_eth_min;
    int p_eth_max;


    //Constructor
    public Plants()
    {

    }

    public Plants(String p_name, String p_preferable_months_of_season, int p_h2o_min_req, int p_h2o_max_req, int p_weekly_h2o_seed, int p_weekly_h2o_crop, int p_eta_sprout_min, int p_eta_sprout_max, int p_eth_min, int p_eth_max)
    {
        this.p_name = p_name;
        this.p_preferable_months_of_season = p_preferable_months_of_season;
        this.p_h2o_min_req = p_h2o_min_req;
        this.p_h2o_max_req = p_h2o_max_req;
        this.p_weekly_h2o_seed = p_weekly_h2o_seed;
        this.p_weekly_h2o_crop = p_weekly_h2o_crop;
        this.p_eta_sprout_min = p_eta_sprout_min;
        this.p_eta_sprout_max = p_eta_sprout_max;
        this.p_eth_min = p_eth_min;
        this.p_eth_max = p_eth_max;
    }

    public Plants(int p_id, String p_name, String p_preferable_months_of_season, int p_h2o_min_req, int p_h2o_max_req, int p_weekly_h2o_seed, int p_weekly_h2o_crop, int p_eta_sprout_min, int p_eta_sprout_max, int p_eth_min, int p_eth_max)
    {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_preferable_months_of_season = p_preferable_months_of_season;
        this.p_h2o_min_req = p_h2o_min_req;
        this.p_h2o_max_req = p_h2o_max_req;
        this.p_weekly_h2o_seed = p_weekly_h2o_seed;
        this.p_weekly_h2o_crop = p_weekly_h2o_crop;
        this.p_eta_sprout_min = p_eta_sprout_min;
        this.p_eta_sprout_max = p_eta_sprout_max;
        this.p_eth_min = p_eth_min;
        this.p_eth_max = p_eth_max;
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

    // preferable months of season get-set-method
    public String getP_PrefMonth()
    {
        return p_preferable_months_of_season;
    }

    public void setP_PrefMonth(String p_preferable_months_of_season)
    {
        this.p_preferable_months_of_season = p_preferable_months_of_season;
    }

    //h2o min requirements get-set-method
    public int getP_minH2oReq()
    {
        return p_h2o_min_req;
    }

    public void setP_minH2oReq(int p_h2o_min_req)
    {
        this.p_h2o_min_req = p_h2o_min_req;
    }

    //h2o max requirements get-set-method
    public int getP_maxH2oReq()
    {
        return p_h2o_max_req;
    }

    public void setP_maxH2oReq(int p_h2o_max_req)
    {
        this.p_h2o_max_req = p_h2o_max_req;
    }

    //weekly h2o seed get-set-method
    public int getP_weeklyH2oSeed()
    {
        return p_weekly_h2o_seed;
    }

    public void setP_weeklyH2oSeed(int p_weekly_h2o_seed)
    {
        this.p_weekly_h2o_seed = p_weekly_h2o_seed;
    }

    //weekly h2o crop get-set-method
    public int getP_weeklyH2oCrop()
    {
        return p_weekly_h2o_crop;
    }

    public void setP_weeklyH2oCrop(int p_weekly_h2o_crop)
    {
        this.p_weekly_h2o_crop = p_weekly_h2o_crop;
    }

    //estimated min sprout time get-set-method
    public int getP_etaSproutMin()
    {
        return p_eta_sprout_min;
    }

    public void setP_etaSproutMin(int p_eta_sprout_min)
    {
        this.p_eta_sprout_min = p_eta_sprout_min;
    }

    //estimated max sprout time get-set-method
    public int getP_etaSproutMax()
    {
        return p_eta_sprout_max;
    }

    public void setP_etaSproutMax(int p_eta_sprout_max)
    {
        this.p_eta_sprout_max = p_eta_sprout_max;
    }

    //estimate min time to harvest get-set-method
    public int getP_ethMin()
    {
        return p_eth_min;
    }

    public void setP_ethMin(int p_eth_min)
    {
        this.p_eth_min = p_eth_min;
    }

    //estimate max time to harvest get-set-method
    public int getP_ethMax()
    {
        return p_eth_max;
    }

    public void setP_ethMax(int p_eth_max)
    {
        this.p_eth_max = p_eth_max;
    }
}
