package com.efarmer.erain;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.util.List;

import com.efarmer.erain.CropsPackage.RecyclerCrops;
import com.efarmer.erain.Home.HomeActivity;
import com.efarmer.erain.Profile.LoginActivity;


public class LoadingScreen extends AppCompatActivity {

    //Declare Variables
    //TextView textViewUser;
    /*
    TextView textViewPlants;
    TextView textViewCrops;
    TextView textViewWeather;
*/
    //String u_text = "";
    /*
    String p_text = "";
    String c_text = "";
    String w_text = "";*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        System.out.println("LoadingScreenActivity  screen started");
        setContentView(R.layout.loading_screen);
        findViewById(R.id.mainSpinner1).setVisibility(View.VISIBLE);

        DatabaseHelper db = new DatabaseHelper(this);

        //insert Users
        db.addUser(new User("sj", "wdt", "sj@gmail.com", "1234", "Potchefstroom", "Bult", "NW"));


        //insert RecyclerPlants
        db.addPlant(new Plants("Corn", "Aug-Nov", 381, 610, 50, 50, 10, 14, 77, 98));
        db.addPlant(new Plants("Onions", "Sept-Nov", 550, 600, 25, 25, 7, 10, 100, 175));
        db.addPlant(new Plants("Potatoes", "Jan-Mar & Sept-Oct", 500, 700, 36, 36, 14, 28, 105, 140));
        db.addPlant(new Plants("Tomatoes", "Nov-Jan", 225, 450, 50, 50, 5, 10, 60, 70));
        db.addPlant(new Plants("Sunflowers", "Sept-Apr", 750, 870, 53, 53, 7, 10, 80, 120));
        db.addPlant(new Plants("Wheat", "Feb-Mar", 460, 600, 42, 42, 7, 14, 70, 99));
        db.addPlant(new Plants("Carrots", "Sept-Apr", 132, 275, 5, 25, 14, 21, 70, 80));
        db.addPlant(new Plants("Pumpkin", "Sept-Nov", 450, 670, 35, 35, 5, 10, 105, 140));
        db.addPlant(new Plants("Strawberries", "Nov-Dec", 200, 300, 38, 38, 14, 21, 42, 61));

        //insert RecyclerCrops
        // Tomoato
        db.addCrop(new Crops("Tomato", 30, 20, "2018-10-04", 23));
        db.addCrop(new Crops("Tomato", 30, 20, "2018-10-14", 14));
        db.addCrop(new Crops("Tomato", 30, 20, "2018-10-14", 14));
        db.addCrop(new Crops("Tomato", 30, 20, "2018-10-04", 7));
        db.addCrop(new Crops("Tomato", 30, 20, "2018-10-04", 7));
        // Corn
        db.addCrop(new Crops("Corn", 30, 20, "2018-10-04", 7));
        // Pumpkin
        db.addCrop(new Crops("Pumpkin", 30, 20, "2018-10-01", 12));
        db.addCrop(new Crops("Pumpkin", 30, 20, "2018-10-12", 3));
        // Strawberry
        db.addCrop(new Crops("Strawberry", 30, 20, "2018-10-08", 8));
        // Potato
        db.addCrop(new Crops("Potato", 30, 20, "2018-09-29", 2));
        db.addCrop(new Crops("Potato", 30, 20, "2018-09-29", 2));
        db.addCrop(new Crops("Potato", 30, 20, "2018-09-29", 2));
        // Onion
        db.addCrop(new Crops("Onion", 30, 20, "2018-08-14", 67));
        // Sunflower
        db.addCrop(new Crops("Sunflower", 30, 20, "2018-08-39", 26));
        db.addCrop(new Crops("Sunflower", 30, 20, "2018-09-29", 8));
        // Wheat
        db.addCrop(new Crops("Wheat", 30, 20, "2018-07-29", 63));
        db.addCrop(new Crops("Wheat", 30, 20, "2018-07-29", 63));
        db.addCrop(new Crops("Wheat", 30, 20, "2018-07-29", 63));
        db.addCrop(new Crops("Wheat", 30, 20, "2018-07-29", 63));
        // Carrot
        db.addCrop(new Crops("Carrot", 30, 20, "2018-06-29", 81));
        db.addCrop(new Crops("Carrot", 30, 20, "2018-06-29", 81));
        db.addCrop(new Crops("Carrot", 30, 20, "2018-06-29", 81));
        db.addCrop(new Crops("Carrot", 30, 20, "2018-06-29", 81));
        db.addCrop(new Crops("Carrot", 30, 20, "2018-06-29", 81));
        db.addCrop(new Crops("Carrot", 30, 20, "2018-06-29", 81));
        db.addCrop(new Crops("Carrot", 30, 20, "2018-06-29", 81));
        db.addCrop(new Crops("Carrot", 30, 20, "2018-06-29", 81));




        //insert weather
       // db.addWeather(new Weather("15", "20", "10", "25", "18/12/2018"));*/

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Simulating a long running task

                /* Create an Intent that will start the ProfileData-Activity. */
                Intent intentHome = new Intent(LoadingScreen.this, LoginActivity.class);
                LoadingScreen.this.startActivity(intentHome);
                LoadingScreen.this.finish();
            }
        }, 2500);
    }


        //reading and displaying all contacts from list
        //List<User> user = db.getAllUsers();
        //List<RecyclerPlants> plants = db.getAllPlants();
        //List<RecyclerCrops> crops = db.getAllCrops();
        //List<Weather> weather = db.getAllWeatherEntries();


       /* for (User u : user) {
            String u_log = "User ID: " + u.getU_id() + ", Name: " + u.getU_name() + ", Last Name: "
                    + u.getU_surname() + ", Email: " + u.getU_email() + ", Password: " + u.getU_password()
                    + ", City: " + u.getU_city() + ", Suburb: " + u.getU_suburb() + ", Province: " + u.getU_province()
                    + "\n";

            u_text = u_text + u_log;
        }

        textViewUser.setText(u_text);*/

        /*

        for(RecyclerPlants p : plants)
        {
            String p_log = "SeedInformation ID: " + p.getP_id() + ", SeedInformation Name: " + p.getP_name() + ", Proffered Months: " + p.getP_PrefMonth()
                    + ", Min H2o Requirements: " + p.getP_minH2oReq() + ", Max H2o Requirements: " + p.getP_maxH2oReq() + ", Weekly H20 for SeedInformation"
                    + p.getP_weeklyH2oSeed() + ", Weekly H2o for Crop" + p.getP_weeklyH2oCrop() + ", Min Estimated Sprout Days"
                    + p.getP_etaSproutMin() + ", Max Estimated Sprout Days" + p.getP_etaSproutMax() + ", Min Days to Harvest Time"
                    + p.getP_ethMin() + ", Max Days to Harvest Time" + p.getP_ethMax()
                    + "\n";
            p_text = p_text + p_log;
        }

        textViewPlants.setText(p_text);

        for(RecyclerCrops c : crops)
        {
            String c_log = "RecyclerCrops ID: " + c.getC_id() + ", RecyclerCrops: " + c.getC_name() + ", Expected Weekly Rain: " + c.getC_ExpectedWeeklyRain()
                    + ", Weekly H2o Top Up Requirements: " + c.getC_weeklyH2oTopUpReq() + ", Date Planted: " + c.getC_plantDate() + ", " + c.getC_name() + " Age in Days"
                    + c.getC_daysOld()
                    + "\n";
            c_text = c_text + c_log;
        }

        textViewCrops.setText(c_text);

        for(Weather w : weather)
        {
            String w_log = "Weather ID: " + w.getW_id() + ", Wind Speed: " + w.getW_windSpeed() + ", Humidity: " + w.getW_humidity()
                    + ", Rainfall: " + w.getW_rainfall() + ", Temperature: " + w.getW_temperature()
                    + "\n";
            w_text = w_text + w_log;
        }

        textViewWeather.setText(w_text);
        }*/

}


