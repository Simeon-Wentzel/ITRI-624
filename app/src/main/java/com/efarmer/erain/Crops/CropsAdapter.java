package com.efarmer.erain.Crops;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.efarmer.erain.R;

import java.util.List;

public class CropsAdapter extends RecyclerView.Adapter<CropsAdapter.CropViewHolder> {

    //This context will inflate the layout
    private Context mCtx;
    private List<Crops> cropsList;

    public CropsAdapter(Context mCtx, List<Crops> cropsList){
        this.mCtx = mCtx;
        this.cropsList = cropsList;
    }

    @Override
    public CropViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.item_crops, parent,false);
        CropViewHolder cropViewHolder = new CropViewHolder(view);
        return cropViewHolder;
    }

    @Override
    public void onBindViewHolder(CropViewHolder holder, int position) {
        //getting the product of the specified position
        Crops crops = cropsList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(crops.getName());
        holder.textViewShortDesc.setText(crops.getPlantedDate());
        holder.textViewRating.setText(String.valueOf(crops.getDaysOld()));
        //holder.textViewPrice.setText(String.valueOf(crops.getPrice()));

    }

    @Override
    public int getItemCount() {
        return cropsList.size();
    }

    class CropViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;

        public CropViewHolder(View view){
            super(view);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            //textViewPrice = itemView.findViewById(R.id.textViewPrice);
            //imageView = itemView.findViewById(R.id.imageView);
        }

    }

}
