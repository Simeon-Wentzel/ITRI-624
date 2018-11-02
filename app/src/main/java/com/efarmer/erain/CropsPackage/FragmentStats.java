package com.efarmer.erain.CropsPackage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.efarmer.erain.Crops;
import com.efarmer.erain.DatabaseHelper;
import com.efarmer.erain.Plants;
import com.efarmer.erain.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class FragmentStats extends Fragment {

    public View myView;
    public TextView txtStats;
    private RecyclerView recyclerView;
    private List<Crops> cropsList;
    private List<Plants> plantsList;
    private List<RecyclerStats> recyclerStatsList;


    public FragmentStats() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DatabaseHelper db = new DatabaseHelper(getContext());
        cropsList = db.getAllCrops();
        plantsList = db.getAllPlants();
        recyclerStatsList = new ArrayList<>();

        // quantity
        Map<String, Integer> quantity = new HashMap<String, Integer>();
        quantity.put("Corn", 0);
        quantity.put("Onions", 0);
        quantity.put("Potatoes", 0);
        quantity.put("Tomatoes", 0);
        quantity.put("Sunflowers", 0);
        quantity.put("Wheat", 0);
        quantity.put("Carrots", 0);
        quantity.put("Pumpkins", 0);
        quantity.put("Strawberries", 0);

        // inSeason
        Map<String, Integer> inSeason = new HashMap<String, Integer>();
        inSeason.put("Corn", 0);
        inSeason.put("Onions", 0);
        inSeason.put("Potatoes", 0);
        inSeason.put("Tomatoes", 0);
        inSeason.put("Sunflowers", 0);
        inSeason.put("Wheat", 0);
        inSeason.put("Carrots", 0);
        inSeason.put("Pumpkins", 0);
        inSeason.put("Strawberries", 0);

        // nearingHarvest
        Map<String, Integer> nearingHarvest = new HashMap<String, Integer>();
        nearingHarvest.put("Corn", 0);
        nearingHarvest.put("Onions", 0);
        nearingHarvest.put("Potatoes", 0);
        nearingHarvest.put("Tomatoes", 0);
        nearingHarvest.put("Sunflowers", 0);
        nearingHarvest.put("Wheat", 0);
        nearingHarvest.put("Carrots", 0);
        nearingHarvest.put("Pumpkins", 0);
        nearingHarvest.put("Strawberries", 0);

        // nearingHarvest
        Map<String, Integer> sprouting = new HashMap<String, Integer>();
        sprouting.put("Corn", 0);
        sprouting.put("Onions", 0);
        sprouting.put("Potatoes", 0);
        sprouting.put("Tomatoes", 0);
        sprouting.put("Sunflowers", 0);
        sprouting.put("Wheat", 0);
        sprouting.put("Carrots", 0);
        sprouting.put("Pumpkins", 0);
        sprouting.put("Strawberries", 0);

        // nearingHarvest
        Map<String, Integer> vegetating = new HashMap<String, Integer>();
        vegetating.put("Corn", 0);
        vegetating.put("Onions", 0);
        vegetating.put("Potatoes", 0);
        vegetating.put("Tomatoes", 0);
        vegetating.put("Sunflowers", 0);
        vegetating.put("Wheat", 0);
        vegetating.put("Carrots", 0);
        vegetating.put("Pumpkins", 0);
        vegetating.put("Strawberries", 0);

        // sprouting
        Map<String, Integer> compareSprouting = new HashMap<String, Integer>();
        compareSprouting.put("Corn", 0);
        compareSprouting.put("Onions", 0);
        compareSprouting.put("Potatoes", 0);
        compareSprouting.put("Tomatoes", 0);
        compareSprouting.put("Sunflowers", 0);
        compareSprouting.put("Wheat", 0);
        compareSprouting.put("Carrots", 0);
        compareSprouting.put("Pumpkins", 0);
        compareSprouting.put("Strawberries", 0);

        // PLANTS
        // vegetating
        Map<String, Integer> compareVegetating = new HashMap<String, Integer>();
        compareVegetating.put("Corn", 0);
        compareVegetating.put("Onions", 0);
        compareVegetating.put("Potatoes", 0);
        compareVegetating.put("Tomatoes", 0);
        compareVegetating.put("Sunflowers", 0);
        compareVegetating.put("Wheat", 0);
        compareVegetating.put("Carrots", 0);
        compareVegetating.put("Pumpkins", 0);
        compareVegetating.put("Strawberries", 0);

        // Comparison: season
        Map<String, String> compareSeason = new HashMap<String, String>();
        compareSeason.put("Corn", "");
        compareSeason.put("Onions", "");
        compareSeason.put("Potatoes", "");
        compareSeason.put("Tomatoes", "");
        compareSeason.put("Sunflowers", "");
        compareSeason.put("Wheat", "");
        compareSeason.put("Carrots", "");
        compareSeason.put("Pumpkins", "");
        compareSeason.put("Strawberries", "");


        // Comparison data
        for (Plants p : plantsList){
            String p_name = p.getP_name();
            String p_season = p.getP_PrefMonth();
            int p_vegetate = p.getP_etaSproutMax();
            int p_sprout = p.getP_etaSproutMax();

            compareVegetating.put(p_name, p_vegetate);
            compareSprouting.put(p_name, p_sprout);
            compareSeason.put(p_name, p_season);
        }


        for (Crops c : cropsList) {
            int id = c.getC_id();
            String name = c.getC_name();
            String datePlanted = c.getC_plantDate();
            int value;

            // Determine
            // inSeason
            String prefSeason = compareSeason.get(name);
            String[] dates = prefSeason.split("-");
            int startDate, endDate = 0;

            java.util.Date date= new Date();
            Calendar nowCal = Calendar.getInstance();
            nowCal.setTime(date);
            int nowMonth = nowCal.get(Calendar.MONTH); // 0 - 11

            // Start date
            switch (dates[0]) {
                case "Jan":
                    startDate = 0;
                    break;
                case "Feb":
                    startDate = 1;
                    break;
                case "Mar":
                    startDate = 2;
                    break;
                case "Apr":
                    startDate = 3;
                    break;
                case "May":
                    startDate = 4;
                    break;
                case "Jun":
                    startDate = 5;
                    break;
                case "Jul":
                    startDate = 6;
                    break;
                case "Aug":
                    startDate = 7;
                    break;
                case "Sep":
                    startDate = 8;
                    break;
                case "Oct":
                    startDate = 9;
                    break;
                case "Nov":
                    startDate = 10;
                    break;
                case "Dec":
                    startDate = 11;
                    break;
                default: startDate = 0;
            }

            // Start date
            switch (dates[1]) {
                case "Jan":
                    endDate = 0;
                    break;
                case "Feb":
                    endDate = 1;
                    break;
                case "Mar":
                    endDate = 2;
                    break;
                case "Apr":
                    endDate = 3;
                    break;
                case "May":
                    endDate = 4;
                    break;
                case "Jun":
                    endDate = 5;
                    break;
                case "Jul":
                    endDate = 6;
                    break;
                case "Aug":
                    endDate = 7;
                    break;
                case "Sep":
                    endDate = 8;
                    break;
                case "Oct":
                    endDate = 9;
                    break;
                case "Nov":
                    endDate = 10;
                    break;
                case "Dec":
                    endDate = 11;
                    break;
                default: endDate = 0;
            }

            if (startDate > endDate){
                int temp = 0;
                temp = startDate;
                startDate = endDate;
                endDate = temp;
            }

            if ((nowMonth <= endDate) && (nowMonth >= startDate)){
                inSeason.put(name, 1);
            }

            // quantity
            value = quantity.get(name);
            quantity.put(name, value + 1);

            // crops nearing harvest
            int prefVegetating = compareVegetating.get(name);
            int prefSprouting = compareSprouting.get(name);
            int daysOld = c.getC_daysOld();
            double test = 0.75;
            double farAlong = (test * prefVegetating);
            // nearing harvest
            if (daysOld > farAlong) {
                value = quantity.get(name);
                nearingHarvest.put(name, value + 1);
            }
            // sprout
            if (daysOld < prefVegetating) {
                value = quantity.get(name);
                sprouting.put(name, value + 1);
            }
            // veg
            if (daysOld > prefSprouting) {
                value = quantity.get(name);
                vegetating.put(name, value + 1);
            }
        }


        for(Map.Entry<String, Integer> entry : quantity.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (quantity.get(key) == 0){
                continue;
            }

            int image = R.drawable.ic_add_black_24dp;
            switch (key) {
                case "Carrots":
                    image = R.mipmap.carrot;
                    break;
                case "Corn":
                    image = R.mipmap.corn;
                    break;
                case "Wheat":
                    image = R.mipmap.wheat;
                    break;
                case "Onions":
                    image = R.mipmap.onion;
                    break;
                case "Potatoes":
                    image = R.mipmap.potato;
                    break;
                case "Pumpkins":
                    image = R.mipmap.pumpkin;
                    break;
                case "Strawberries":
                    image = R.mipmap.strawberry;
                    break;
                case "Sunflowers":
                    image = R.mipmap.sunflower;
                    break;
                case "Tomatoes":
                    image = R.mipmap.tomato;
                    break;
            }

            recyclerStatsList.add(
                    new RecyclerStats(
                            0,
                            key,
                            inSeason.get(key),
                            quantity.get(key),
                            nearingHarvest.get(key),
                            sprouting.get(key),
                            vegetating.get(key),
                            image));

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflater.inflate(R.layout.fragment_crops_stats, container, false);

        // Inflate the layout for this fragment
        myView =  inflater.inflate(R.layout.fragment_crops_stats, container, false);
        recyclerView = (RecyclerView) myView.findViewById(R.id.recyclerViewStats);
        StatsAdapter statsAdapter = new StatsAdapter(getContext(), recyclerStatsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(statsAdapter);
        return myView;
    }



}
