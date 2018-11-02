package com.efarmer.erain.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
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


public class LoginActivity extends AppCompatActivity {

    public String navName;
    public TextView navUser;
    public Button btnSignIn, btnNoAccount, btnForgotPassword;
    public EditText txtEmail, txtPassword;
    public Context context = LoginActivity.this;
    public DatabaseHelper db;
    //email validation regex
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    //Create an on click listener for btnForgotPassword
    private View.OnClickListener OnForgotPasswordClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            btnForgotPassowrdClicked();
        }
    };

    //Create an on click listener for NoAccount
    private View.OnClickListener OnNoAccountClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            btnNoAccountClicked();
        }
    };

    //Create an on click listener for Signin
    private View.OnClickListener OnSignInClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            btnSignInClicked();
        }
    };

    //The on create event
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnNoAccount = (Button) findViewById(R.id.btnNoAccount);
        btnForgotPassword = (Button) findViewById(R.id.btnForgotPassword);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);

        btnSignIn.setOnClickListener(OnSignInClickListener);
        btnNoAccount.setOnClickListener(OnNoAccountClickListener);
        btnForgotPassword.setOnClickListener(OnForgotPasswordClickListener);
    }

    //On click event for btnForgotPasswor
    private void btnForgotPassowrdClicked() {
        Intent intent = new Intent(context, ForgotPassword.class);
        context.startActivity(intent);
    }

    //On click event for btmNoAccount
    private void btnNoAccountClicked() {
        Intent intent = new Intent(context, SignupActivity.class);
        context.startActivity(intent);
    }

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }

    //On click event for btnSignIn
    private void btnSignInClicked() {
        db = new DatabaseHelper(this);
        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();
        boolean isInputValid = true; // will be invalidated by any incorrect input

        if (!TextUtils.isEmpty(password) && !TextUtils.isEmpty(email)) {
            // Toast.makeText(context, "Email or password field is incorrect.", Toast.LENGTH_SHORT).show();
            isInputValid = false;
        }

        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        boolean isValidEmail = matcher.find();
        if (!TextUtils.isEmpty(email) && (!isValidEmail)) {
            txtEmail.setError("Email address is invalid");
            isInputValid = false;
        }

        // Log user in and store global variables of his/her information
        if (db.queryUser(email, password)){
            // Get User object populated with information belonging to logged in user
            User loggedInUser = db.getUserByEmail(email);
            // Capture logged in user's information
            GlobalUser.setGName(loggedInUser.getU_name());
            GlobalUser.setGSurname(loggedInUser.getU_surname());
            GlobalUser.setGEmail(loggedInUser.getU_email());
            GlobalUser.setGSuburb(loggedInUser.getU_suburb());
            GlobalUser.setGCity(loggedInUser.getU_city());
            GlobalUser.setGProvince(loggedInUser.getU_province());

          /*  navName = GlobalUser.getGName();
            navUser = (TextView) findViewById(R.id.navUser);
            navUser.setText(navName);*/


            //globalUser.setGEmail(email);
            Intent intent = new Intent(context, HomeActivity.class);
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "Email does not exists or password in incorrect", Toast.LENGTH_SHORT).show();
        }

    }
}

