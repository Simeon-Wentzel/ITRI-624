package com.efarmer.erain.CropsPackage;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.efarmer.erain.DatabaseHelper;
import com.efarmer.erain.R;
import com.efarmer.erain.Crops;

import java.util.ArrayList;
import java.util.List;

public class FragmentCrops extends Fragment {

    View view;
    private RecyclerView recyclerView;
    private List<Crops> cropsList;
    private List<RecyclerCrops> recyclerCropsList;


    public  FragmentCrops(){
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DatabaseHelper db = new DatabaseHelper(getContext());
        cropsList = db.getAllCrops();
        recyclerCropsList = new ArrayList<>();

        for (Crops c : cropsList) {
            int id = c.getC_id();
            String name = c.getC_name();
            String exptWeeklyRain = String.valueOf(c.getC_ExpectedWeeklyRain());
            String weeklyH20TopUp = String.valueOf(c.getC_weeklyH2oTopUpReq());
            String plantDate = String.valueOf(c.getC_plantDate());
            String daysOld = String.valueOf(c.getC_daysOld());
            int image = R.drawable.ic_add_black_24dp;
            switch (name){
                case "Carrots":
                    image = R.mipmap.carrot;
                    break;
                case "corn":
                    image = R.mipmap.corn;
                    break;
                case "wheat":
                    image = R.mipmap.wheat;
                    break;
                case "Onions":
                    image = R.mipmap.onion;
                    break;
                case "Potatoes":
                    image = R.mipmap.potato;
                    break;
                case "pumpkin":
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

            recyclerCropsList.add(
                    new RecyclerCrops(
                            id,
                            name,
                            exptWeeklyRain,
                            weeklyH20TopUp,
                            plantDate,
                            daysOld,
                            image));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_crops_crops, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewCrops);
        CropsAdapter cropsAdapter = new CropsAdapter(getContext(), recyclerCropsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(cropsAdapter);
        return view;
    }

}
