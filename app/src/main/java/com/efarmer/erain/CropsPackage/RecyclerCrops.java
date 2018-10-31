package com.efarmer.erain.CropsPackage;

public class RecyclerCrops {
    private int id, image;
    private String name, exptWeeklyRain, topupH2O, plantedDate, daysOld;

    public RecyclerCrops(int id, String name, String exptWeeklyRain, String topupH2O, String plantedDate, String daysOld, int image){
        this.id = id;
        this.name = name;
        this.exptWeeklyRain = exptWeeklyRain;
        this.topupH2O = topupH2O;
        this.plantedDate = plantedDate;
        this.daysOld = daysOld;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getExptWeeklyRain() {
        return exptWeeklyRain;
    }

    public String getTopupH2O() {
        return topupH2O;
    }

    public String getPlantedDate() {
        return plantedDate;
    }

    public String getDaysOld() {
        return daysOld;
    }

    public int getImage() { return  image; }
}
