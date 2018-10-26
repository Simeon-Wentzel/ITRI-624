package com.efarmer.erain.Utills;

import com.efarmer.erain.User;

public class GlobalUser {

    public static String gName;
    public static String gSurname;
    public static String gEmail;
    public static String gCity;
    public static String gSuburb;
    public static String gProvince;


    /*public GlobalUser() {

    }

    // CONSTRUCTOR
    public GlobalUser(String gName, String gSurname, String gEmail, String gCity, String gSuburb, String gProvince) {
        this.setGName(gName);
        this.setGSurname(gSurname);
        this.setGEmail(gEmail);
        this.setGCity(gCity);
        this.setGSuburb(gSuburb);
        this.setGProvince(gProvince);
    }

    // Accpets DB User object and extracts information pertaining to that user and populates the global user
    public GlobalUser(User loggedInUser) {
        this.setGName(loggedInUser.getU_name());
        this.setGSurname(loggedInUser.getU_surname());
        this.setGEmail(loggedInUser.getU_email());
        this.setGCity(loggedInUser.getU_city());
        this.setGSuburb(loggedInUser.getU_suburb());
        this.setGProvince(loggedInUser.getU_province());
    }*/

    // SETTERS
    public static void setGName(String name) {
        gName = name;
    }

    public static void setGSurname(String surname) {
        gSurname = surname;
    }

    public static void setGEmail(String email){
        gEmail = email;
    }

    public static void setGCity(String city) {
        gCity = city;
    }

    public static void setGSuburb(String suburb) { gSuburb = suburb; }

    public static void setGProvince(String province) {
        gProvince = province;
    }

    // GETTERS
    public static String getGName() {
        return gName;
    }

    public static String getGSurname() {
        return gSurname;
    }

    public static String getGEmail(){
        return gEmail;
    }

    public static String getGCity() {
        return gCity;
    }

    public static String getGSuburb() { return gSuburb; }

    public static String getGProvince() {
        return gProvince;
    }

}
