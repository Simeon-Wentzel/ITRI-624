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
import com.efarmer.erain.Planted;
import com.efarmer.erain.R;
import com.efarmer.erain.Seed;

import java.util.ArrayList;
import java.util.List;

public class FragmentCrops extends Fragment {

    View view;
    private RecyclerView recyclerView;
    private List<Crops> cropsList;


    public  FragmentCrops(){
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DatabaseHelper db = new DatabaseHelper(getContext());
        List<Planted> plantedList = db.getAllPlanted();

        for (Planted p : plantedList) {
            int id = p.getP_id();
            String name = p.getP_name();
            String exptWeeklyRain = String.valueOf(p.getP_ExpectedWeeklyRain());
            String weeklyH20TopUp = String.valueOf(p.getP_weeklyH2oTopUpReq());
            String plantDate = String.valueOf(p.getP_plantDate());
            String daysOld = String.valueOf(p.getP_daysOld());

            plantedList.add(
                    new Planted(
                            id,
                            name,
                            exptWeeklyRain,
                            weeklyH20TopUp,
                            plantDate,
                            daysOld));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_crops_crops, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewCrops);
        CropsAdapter cropsAdapter = new CropsAdapter(getContext(), cropsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(cropsAdapter);
        return view;
    }

}
