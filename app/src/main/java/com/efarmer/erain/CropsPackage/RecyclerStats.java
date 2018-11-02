package com.efarmer.erain.CropsPackage;

public class RecyclerStats
{
    private int id, image;
    private String name;
    int quantity, crops_nearing_harvest, crops_sprouting, crops_vegetating, seasonal;

    public RecyclerStats(int id, String name, int seasonal, int quantity, int crops_nearing_harvest, int crops_sprouting, int crops_vegetating, int image){
        this.id = id;
        this.name = name;
        this.seasonal = seasonal;
        this.quantity = quantity;
        this.crops_nearing_harvest = crops_nearing_harvest;
        this.crops_sprouting = crops_sprouting;
        this.crops_vegetating = crops_vegetating;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int isSeasonal() {
        return seasonal;
    }

    public void setSeasonal(int seasonal) {
        this.seasonal = seasonal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCrops_nearing_harvest() {
        return crops_nearing_harvest;
    }

    public void setCrops_nearing_harvest(int crops_nearing_harvest) {
        this.crops_nearing_harvest = crops_nearing_harvest;
    }

    public int getCrops_sprouting() {
        return crops_sprouting;
    }

    public void setCrops_sprouting(int crops_sprouting) {
        this.crops_sprouting = crops_sprouting;
    }

    public int getCrops_vegatating() {
        return crops_vegetating;
    }

    public void setCrops_vegatating(int crops_vegetating) {
        this.crops_vegetating = crops_vegetating;
    }

    public String getStatsInfo() {

        String information =    "Tomato [in season: Yes]:\n\t"
        + "No. of existing Crops:\t5\n\t"
        +"Crops in/nearing harvest:\t1\n\t"
        +"Sprouting crops (Water-intensive crops):2\n\t"
        +"Vegetating crops (Water-indifferent crops):3\n\t"

        +"Corn [in season: No]:\n\t"
        +"No. of existing Crops:\t1\n\t"
        +"Crops in/nearing harvest:\t0\n\t"
        +"Sprouting crops (Water-intensive crops):1\n\t"
        +"Vegetating crops (Water-indifferent crops):0\n\t"

        +"Pumpkin [in season: Yes]:\n\t"
        +"No. of existing Crops:\t2\n\t"
        +"Crops in/nearing harvest:\t0\n\t"
        +"Sprouting crops (Water-intensive crops):1\n\t"
        +"Vegetating crops (Water-indifferent crops):1\n\t"
        +"Strawberry [in season: No]:\n\t"
        +"No. of existing Crops:\t1\n\t"
        +"Crops in/nearing harvest:\t0\n\t"
        +"Sprouting crops (Water-intensive crops):1\n\t"
        +"Vegetating crops (Water-indifferent crops):0\n\t"
        +"Potato [in season: Yes]:\n\t"
        +"No. of existing Crops:\t3\n\t"
        +"Crops in/nearing harvest:\t0\n\t"
        +"Sprouting crops (Water-intensive crops):3\n\t"
        +"Vegetating crops (Water-indifferent crops):0\n\t"
        +"Onion [in season: No]:\n\t"
        +"No. of existing Crops:\t1\n\t"
        +"Crops in/nearing harvest:\t1\n\t"
        +"Sprouting crops (Water-intensive crops):0\n\t"
        +"Vegetating crops (Water-indifferent crops):1\n\t"
        +"Sunflower [in season: Yes]:\n\t"
        +"No. of existing Crops:\t2\n\t"
        +"Crops in/nearing harvest:\t0\n\t"
        +"Sprouting crops (Water-intensive crops):1\n\t"
        +"Vegetating crops (Water-indifferent crops):1\n\t"
        +"Wheat [in season: No]:\n\t"
        +"No. of existing Crops:\t4\n\t"
        +"Crops in/nearing harvest:\t4\n\t"
        +"Sprouting crops (Water-intensive crops):0\n\t"
        +"Vegetating crops (Water-indifferent crops):4\n\t"
        +"Carrot [in season: Yes]:\n\t"
        +"No. of existing Crops:\t8\n\t"
        +"Crops in/nearing harvest:\t1\n\t"
        +"Sprouting crops (Water-intensive crops):7\n\t"
        +"Vegetating crops (Water-indifferent crops):1\n\t";
        return information;
    }
}
