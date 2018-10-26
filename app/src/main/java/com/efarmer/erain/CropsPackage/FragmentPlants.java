package com.efarmer.erain.Crops;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.efarmer.erain.DatabaseHelper;
import com.efarmer.erain.R;
import com.efarmer.erain.Seed;

import java.util.ArrayList;
import java.util.List;

public class FragmentPlants extends Fragment {

    View view;
    private RecyclerView recyclerView;
    private List<Plants> plantList;

    public FragmentPlants() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        plantList = new ArrayList<>();

        DatabaseHelper db = new DatabaseHelper(getContext());
        List<Seed> seed = db.getAllSeeds();

        for (Seed s : seed) {
            int id = s.getS_id();
            String name = s.getS_name();
            String prefMonth = s.getS_PrefMonth();
            String generalH2O = s.getS_minH2oReq() + "~" + s.getS_maxH2oReq();
            String seedH20 = String.valueOf(s.getS_weeklyH2oSeed());
            String cropH20 = String.valueOf(s.getS_weeklyH2oCrop());
            String sproutETA = s.getS_etaSproutMin() + "~" + s.getS_etaSproutMax();
            String harvestETA = s.getS_ethMin() + "~" + s.getS_ethMax();

            plantList.add(
                    new Plants(
                            id,
                            name,
                            prefMonth,
                            generalH2O,
                            seedH20,
                            cropH20,
                            sproutETA,
                            harvestETA));


        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_crops_plants, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewPlants);
        PlantsAdapter plantsAdapter = new PlantsAdapter(getContext(), plantList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(plantsAdapter);
        return view;
    }


}
