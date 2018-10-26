package com.efarmer.erain.CropsPackage;

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
import com.efarmer.erain.Plants;

import java.util.ArrayList;
import java.util.List;

public class FragmentPlants extends Fragment {

    View view;
    private RecyclerView recyclerView;
    private List<Plants> plantList;
    private List<RecyclerPlants> recyclerPlantsList;

    public FragmentPlants() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        DatabaseHelper db = new DatabaseHelper(getContext());
        plantList = db.getAllPlants();
        recyclerPlantsList = new ArrayList<>();

        for (Plants p : plantList) {
            int id = p.getP_id();
            String name = p.getP_name();
            String prefMonth = p.getP_PrefMonth();
            String generalH2O = p.getP_minH2oReq() + "~" + p.getP_maxH2oReq();
            String seedH20 = String.valueOf(p.getP_weeklyH2oSeed());
            String cropH20 = String.valueOf(p.getP_weeklyH2oCrop());
            String sproutETA = p.getP_etaSproutMin() + "~" + p.getP_etaSproutMax();
            String harvestETA = p.getP_ethMin() + "~" + p.getP_ethMax();

            recyclerPlantsList.add(
                    new RecyclerPlants(
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
        PlantsAdapter plantsAdapter = new PlantsAdapter(getContext(), recyclerPlantsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(plantsAdapter);
        return view;
    }


}
