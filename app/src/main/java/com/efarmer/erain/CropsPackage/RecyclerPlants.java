package com.efarmer.erain.CropsPackage;

public class RecyclerPlants {

    private int id;
    private String name, prefMonth, generalH2O, seedH20, cropH20, sproutETA, harvestETA;

    public RecyclerPlants(int id, String name, String prefMonth, String generalH2O, String seedH20, String cropH20, String sproutETA, String harvestETA){
        this.id = id;
        this.name = name;
        this.prefMonth = prefMonth;
        this.generalH2O = generalH2O;
        this.seedH20 = seedH20;
        this.cropH20 = cropH20;
        this.sproutETA = sproutETA;
        this.harvestETA = harvestETA;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrefMonth() {
        return prefMonth;
    }

    public String getGeneralH2O() {
        return generalH2O;
    }

    public String getSeedH20() {
        return seedH20;
    }

    public String getCropH20() {
        return cropH20;
    }

    public String getSproutETA() {
        return sproutETA;
    }

    public String getHarvestETA() {
        return harvestETA;
    }

    public String getTitle(){
        return getName();
    }

    public String getSubtitle() {
        return getPrefMonth();
    }

    public String getInformation() {

        String information =    "Min & max H20: "+getGeneralH2O()+"\n"+
                "Weekly H20 when sprouting: "+getSeedH20()+"\n"+
                "Weekly H20 when vegatating: "+getCropH20()+"\n"+
                "Estimated weeks until germinatation: "+getSproutETA()+"\n"+
                "Estimated weeks until harvest: "+getHarvestETA()+"\n";
        return information;
    }
}
