package com.efarmer.erain.CropsPackage;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.efarmer.erain.R;

import java.util.List;

public class StatsAdapter extends RecyclerView.Adapter<StatsAdapter.StatsViewHolder> {


    //This context will inflate the layout
    private Context mCtx;
    //Store all the crops in a list
    private List<RecyclerStats> recyclerStatsList;
    Dialog myDialog;

    public StatsAdapter(Context mCtx, List<RecyclerStats> statsList){
        this.mCtx = mCtx;
        this.recyclerStatsList = statsList;
    }

    @Override
    public StatsAdapter.StatsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.item_stats, parent,false);
        final StatsAdapter.StatsViewHolder statsViewHolder = new StatsAdapter.StatsViewHolder(view);



        return statsViewHolder;
    }

    // RECYCLERVIEW PLANTS!
    @Override
    public void onBindViewHolder(StatsAdapter.StatsViewHolder holder, int position) {
        //getting the product of the specified position
        RecyclerStats recyclerStats = recyclerStatsList.get(position);

        RecyclerStats statInfo = new RecyclerStats();
        String stats = statInfo.getStatsInfo();

    }

    @Override
    public int getItemCount() {
        return recyclerStatsList.size();
    }

    class StatsViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout item_stats;

        private TextView textViewStats;

        public StatsViewHolder(View view){
            super(view);
            item_stats = (LinearLayout) itemView.findViewById(R.id.item_stats);
            textViewStats = itemView.findViewById(R.id.txtStats);

        }

    }

}
