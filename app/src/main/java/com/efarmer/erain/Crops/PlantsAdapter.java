package com.efarmer.erain.Crops;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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

public class PlantsAdapter extends RecyclerView.Adapter<PlantsAdapter.PlantViewHolder> {


    //This context will inflate the layout
    private Context mCtx;
    //Store all the crops in a list
    private List<Plants> plantsList;
    Dialog myDialog;

    public PlantsAdapter(Context mCtx, List<Plants> plantList){
        this.mCtx = mCtx;
        this.plantsList = plantList;
    }

    @Override
    public PlantsAdapter.PlantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.item_plants, parent,false);
        final PlantsAdapter.PlantViewHolder plantViewHolder = new PlantsAdapter.PlantViewHolder(view);

        // Dialog ini
        myDialog = new Dialog(mCtx);
        myDialog.setContentView((R.layout.dialog_plant));
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        // POPUP DIALOG!
        plantViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dialog_title = (TextView) myDialog.findViewById(R.id.txtTitle);
                TextView dialog_subtitle = (TextView) myDialog.findViewById(R.id.txtSubtitle);
                TextView dialog_information = (TextView) myDialog.findViewById(R.id.txtInformation);
                ImageView dialog_plant_img = (ImageView) myDialog.findViewById(R.id.imgPlant);

                // Create text for dialog population
                String title = plantsList.get(plantViewHolder.getAdapterPosition()).getTitle();
                String subtitle = plantsList.get(plantViewHolder.getAdapterPosition()).getSubtitle();
                String information = plantsList.get(plantViewHolder.getAdapterPosition()).getInformation();
                dialog_title.setText(title);
                dialog_subtitle.setText(subtitle);
                dialog_information.setText(information);
                //dialog_plant_img.setImageResource(plantsList.get(plantViewHolder.getAdapterPosition()).getPhoto());

                Toast.makeText(mCtx, "Test Click"+String.valueOf(plantViewHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
                myDialog.show();
            }
        });

        return plantViewHolder;
    }

    // RECYCLERVIEW PLANTS
    @Override
    public void onBindViewHolder(PlantsAdapter.PlantViewHolder holder, int position) {
        //getting the product of the specified position
        Plants plants = plantsList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(plants.getTitle());
        holder.textViewShortDesc.setText(plants.getSubtitle());
        holder.textViewRating.setText(plants.getHarvestETA()+" weeks");
        //holder.textViewPrice.setText(plants.getInformation());

    }

    @Override
    public int getItemCount() {
        return plantsList.size();
    }

    class PlantViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout item_plant;

        private TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;

        public PlantViewHolder(View view){
            super(view);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            //textViewPrice = itemView.findViewById(R.id.textViewPrice);
            //imageView = itemView.findViewById(R.id.imageView);

            item_plant = (LinearLayout) itemView.findViewById(R.id.plant_item_id);
        }

    }

}
