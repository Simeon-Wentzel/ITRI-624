package com.efarmer.erain;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.efarmer.erain.Home.HomeActivity;


public class LoadingScreen extends AppCompatActivity {

    //Declare Variables
   /* TextView textViewUser;
    TextView textViewSeed;
    TextView textViewPlanted;
    TextView textViewWeather;

    String u_text = "";
    String s_text = "";
    String p_text = "";
    String w_text = "";*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        System.out.println("LoadingScreenActivity  screen started");
        setContentView(R.layout.loading_screen);
        findViewById(R.id.mainSpinner1).setVisibility(View.VISIBLE);

        DatabaseHelper db = new DatabaseHelper(this);

        //inserting users
        db.addUser(new User("Faan", "Daniel", "fanie@gmail.com", "f1234"));
        db.addUser(new User("Jan", "Jansen", "jannaman3@gmail.com", "opmt"));
        db.addUser(new User("Sarel", "Burger", "sburger@gmail.com", "85246dfr"));
        db.addUser(new User("Piet", "Retief", "petrus9@gmail.com", "31 P%l"));

        //inserting seeds
        db.addSeed(new Seed("Corn", "Aug-Nov", 381, 610, 50, 50, 10, 14, 77, 98));
        db.addSeed(new Seed("Onions", "Sept-Nov", 550, 600, 25, 25, 7, 10, 100, 175));
        db.addSeed(new Seed("Potatoes", "Jan-Mar & Sept-Oct", 500, 700, 36, 36, 14, 28, 105, 140));
        db.addSeed(new Seed("Tomatoes", "Nov-Jan", 225, 450, 50, 50, 5, 10, 60, 70));
        db.addSeed(new Seed("Sunflowers", "Sept-Apr", 750, 870, 53, 53, 7, 10, 80, 120));
        db.addSeed(new Seed("Wheat", "Feb-Mar", 460, 600, 42, 42, 7, 14, 70, 99));
        db.addSeed(new Seed("Carrots", "Sept-Apr", 132, 275, 5, 25, 14, 21, 70, 80));
        db.addSeed(new Seed("Pumpkin", "Sept-Nov", 450, 670, 35, 35, 5, 10, 105, 140));
        db.addSeed(new Seed("Strawberries", "Nov-Dec", 200, 300, 38, 38, 14, 21, 42, 61));

        //inserting planted
       /* db.addPlant(new Planted("Corn", 30, 20, "2018-09-04", 7));

        //inserting weather
        db.addWeather(new Weather("15", "20", "10", "25", "18/12/2018"));*/

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                //Simulating a long running task

                /* Create an Intent that will start the ProfileData-Activity. */
                Intent intentHome = new Intent(LoadingScreen.this,HomeActivity.class);
                LoadingScreen.this.startActivity(intentHome);
                LoadingScreen.this.finish();
            }
        }, 2500);
    }

    /*
        //reading and displaying all contacts from list
        List<User> user = db.getAllUsers();
        List<SeedInformation> seed = db.getAllSeeds();
        List<Planted> planted = db.getAllPlanted();
        List<Weather> weather = db.getAllWeatherEntries();

        for(User u : user)
        {
            String u_log = "User ID: " + u.getU_id() + ", Name: " + u.getU_name() + ", Last Name: " + u.getU_surname()
                    + ", Email: " + u.getU_email() + ", Password: " + u.getU_password() + "\n";
            u_text = u_text + u_log;
        }

        textViewUser.setText(u_text);

        for(SeedInformation s : seed)
        {
            String s_log = "SeedInformation ID: " + s.getS_id() + ", SeedInformation Name: " + s.getS_name() + ", Proffered Months: " + s.getS_PrefMonth()
                    + ", Min H2o Requirements: " + s.getS_minH2oReq() + ", Max H2o Requirements: " + s.getS_maxH2oReq() + ", Weekly H20 for SeedInformation"
                    + s.getS_weeklyH2oSeed() + ", Weekly H2o for Crop" + s.getS_weeklyH2oCrop() + ", Min Estimated Sprout Days"
                    + s.getS_etaSproutMin() + ", Max Estimated Sprout Days" + s.getS_etaSproutMax() + ", Min Days to Harvest Time"
                    + s.getS_ethMin() + ", Max Days to Harvest Time" + s.getS_ethMax()
                    + "\n";
            s_text = s_text + s_log;
        }

        textViewSeed.setText(s_text);

        for(Planted p : planted)
        {
            String p_log = "Planted ID: " + p.getP_id() + ", Planted: " + p.getP_name() + ", Expected Weekly Rain: " + p.getP_ExpectedWeeklyRain()
                    + ", Weekly H2o Top Up Requirements: " + p.getP_weeklyH2oTopUpReq() + ", Date Planted: " + p.getP_plantDate() + ", " + p.getP_name() + " Age in Days"
                    + p.getP_daysOld()
                    + "\n";
            s_text = s_text + p_log;
        }

        textViewPlanted.setText(p_text);

        for(Weather w : weather)
        {
            String w_log = "Weather ID: " + w.getW_id() + ", Wind Speed: " + w.getW_windSpeed() + ", Humidity: " + w.getW_humidity()
                    + ", Rainfall: " + w.getW_rainfall() + ", Temperature: " + w.getW_temperature()
                    + "\n";
            w_text = w_text + w_log;
        }

        textViewWeather.setText(w_text);*/

}
