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
        StatsViewHolder cropViewHolder = new StatsViewHolder(view);
        return statsViewHolder;
    }

    // RECYCLERVIEW PLANTS!
    @Override
    public void onBindViewHolder(StatsAdapter.StatsViewHolder holder, int position) {
        //getting the product of the specified position
        RecyclerStats recyclerStats = recyclerStatsList.get(position);


        int mySeason = recyclerStats.isSeasonal();
        String isSeason = "Yes";
        if (mySeason == 1){
            isSeason = "Yes" ;
        }
        else{
            isSeason = "No" ;
        }

        //binding the data with the viewholder views
        holder.textViewTitle.setText(recyclerStats.getName());
        holder.textViewShortDesc.setText("Nearing harvest: " + String.valueOf(recyclerStats.getCrops_nearing_harvest())
                +"\n" + "Crops vegetating: " + String.valueOf(recyclerStats.getCrops_vegatating())
                + "\n" + "Crops sprouting: " + String.valueOf(recyclerStats.getCrops_sprouting()));
        holder.textViewRating.setText("In season: " + isSeason);


        // Image
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(recyclerStats.getImage()));

    }


    @Override
    public int getItemCount() {
        return recyclerStatsList.size();
    }

    class StatsViewHolder extends RecyclerView.ViewHolder {

        //private LinearLayout item_stats;

        //private TextView textViewStats;

        //public StatsViewHolder(View view){
        //    super(view);
        //    item_stats = (LinearLayout) itemView.findViewById(R.id.item_stats);
        //    textViewStats = itemView.findViewById(R.id.txtStats);
//
        //}

        private TextView textViewTitle, textViewShortDesc, textViewRating;
        private ImageView imageView;

        public StatsViewHolder(View view){
            super(view);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);

            imageView = itemView.findViewById(R.id.imageViewCrop);
        }

    }

}
