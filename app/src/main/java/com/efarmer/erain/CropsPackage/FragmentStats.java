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

import com.efarmer.erain.R;

public class FragmentStats extends Fragment {

    public View myView;
    public TextView txtStats;

    public FragmentStats() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflater.inflate(R.layout.fragment_crops_stats, container, false);


        // Inflate the layout for this fragment
        myView =  inflater.inflate(R.layout.fragment_crops_plants, container, false);


        return myView;


    }

}
