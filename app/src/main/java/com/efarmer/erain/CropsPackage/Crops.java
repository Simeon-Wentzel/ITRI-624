package com.efarmer.erain.Crops;

public class Crops {
    private int id;
    private String name, exptWeeklyRain, topupH2O, plantedDate, daysOld;

    public Crops(int id, String name, String exptWeeklyRain, String topupH2O, String plantedDate, String daysOld){
        this.id = id;
        this.name = name;
        this.exptWeeklyRain = exptWeeklyRain;
        this.topupH2O = topupH2O;
        this.plantedDate = plantedDate;
        this.daysOld = daysOld;
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
}
