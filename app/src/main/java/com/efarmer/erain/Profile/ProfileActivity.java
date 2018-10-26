package com.efarmer.erain.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.efarmer.erain.DatabaseHelper;
import com.efarmer.erain.Home.HomeActivity;
import com.efarmer.erain.R;
import com.efarmer.erain.User;
import com.efarmer.erain.Utills.GlobalUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";
    public String userName;
    public String userSurname;
    public String userEmail;
    public String userCity;
    public String userSuburb;
    public String userProvince;
    public String userUsername;
    public TextView txtUsername, txtSurname, txtEmail, txtCity, txtSuburb, txtProvince;
    public Context context = ProfileActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_profile);

        userName = GlobalUser.getGName();
        userSurname = GlobalUser.getGSurname();
        userUsername = userName + " " + userSurname;
        userEmail = GlobalUser.getGEmail();
        userCity = GlobalUser.getGCity();
        userSuburb = GlobalUser.getGSuburb();
        userProvince = GlobalUser.getGProvince();

       // Log.e(userName);

        txtUsername = (TextView) findViewById(R.id.txtProfileUsername);
        txtEmail = (TextView) findViewById(R.id.txtProfileEmail);
        txtCity = (TextView) findViewById(R.id.txtProfileCity);
        txtSuburb = (TextView) findViewById(R.id.txtProfileSuburb);
        txtProvince = (TextView) findViewById(R.id.txtProfileProvince);

        txtUsername.setText(userUsername);
        txtEmail.setText(userEmail);
        txtCity.setText(userCity);
        txtSuburb.setText(userSuburb);
        txtProvince.setText(userProvince);
    }


}
