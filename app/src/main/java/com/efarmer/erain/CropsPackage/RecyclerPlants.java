package com.efarmer.erain.CropsPackage;


public class RecyclerPlants {

    private int id, image;
    private String name, prefMonth, generalH2O, seedH20, cropH20, sproutETA, harvestETA;

    public RecyclerPlants(int id, String name, String prefMonth, String generalH2O, String seedH20, String cropH20, String sproutETA, String harvestETA, int image){
        this.id = id;
        this.name = name;
        this.prefMonth = prefMonth;
        this.generalH2O = generalH2O;
        this.seedH20 = seedH20;
        this.cropH20 = cropH20;
        this.sproutETA = sproutETA;
        this.harvestETA = harvestETA;
        this.image = image;
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

    public int getImage() {
        return image;
    }

    public String getInformation() {

        String information =    "Min & max H20 over lifetime: "+"\n"+getGeneralH2O()+" mm.\n"+
                "Average weekly H20 when sprouting: "+"\n"+getSeedH20()+" ml.\n"+
                "Average weekly H20 when vegatating: "+"\n"+getCropH20()+" ml.\n"+
                "Estimated time until germinatation: "+"\n"+getSproutETA()+" days\n"+
                "Estimated time until harvest: "+"\n"+getHarvestETA()+" days\n";
        return information;
    }
}
