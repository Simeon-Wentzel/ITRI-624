package com.efarmer.erain.Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.efarmer.erain.DatabaseHelper;
import com.efarmer.erain.R;
import com.efarmer.erain.User;
import com.efarmer.erain.Utills.GlobalUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditActivity extends AppCompatActivity {

    private static final String TAG = "EditActivity";
    public EditText txtName, txtSurname, txtEmail, txtCity, txtSuburb, txtProvince, txtCurrentPassword, txtNewPassword;
    public Button btnUpdate;
    public DatabaseHelper db;
    //email validation regex
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public Context context = EditActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_edit);

        txtName = (EditText) findViewById(R.id.txtName);
        txtSurname = (EditText) findViewById(R.id.txtSurname);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtCity = (EditText) findViewById(R.id.txtCity);
        txtSuburb = (EditText) findViewById(R.id.txtSuburb);
        txtProvince = (EditText) findViewById(R.id.txtProvince);
        txtCurrentPassword = (EditText) findViewById(R.id.txtCurrentPassword);
        txtNewPassword = (EditText) findViewById(R.id.txtNewPassword);

        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(OnUpdateClickListener);
    }

    //Create an on click listener for Signin
    private View.OnClickListener OnUpdateClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            btnUpdateClicked();
        }
    };

    //On click event for btnUpdate
    private void btnUpdateClicked() {
        db = new DatabaseHelper(this);
        boolean isInputValid = true; // will be invalidated by any incorrect input

        // Capture entered information
        String name             = txtName.getText().toString();
        String surname          = txtSuburb.getText().toString();
        String email            = txtEmail.getText().toString();
        String city             = txtCity.getText().toString();
        String suburb           = txtSuburb.getText().toString();
        String province         = txtProvince.getText().toString();
        String currentPassword  = txtCurrentPassword.getText().toString();
        String newPassword      = txtNewPassword.getText().toString();

        // User must enter password to commit changes
        if (TextUtils.isEmpty(currentPassword)) {
            txtCurrentPassword.setError("Please enter password to commit changes.");
            isInputValid = false;
        }

        // Check e-Mail
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        boolean isValidEmail = matcher.find();
        if (!TextUtils.isEmpty(email) && (!isValidEmail)) {
            txtEmail.setError("e-Mail address is invalid");
            isInputValid = false;
        }

        // exit function
        if (!isInputValid){
            return;
        }


        if (db.queryUser(GlobalUser.getGEmail(), currentPassword)) {
            User loggedInUser = db.getUserByEmail(email);
            int userId = loggedInUser.getU_id();

            // Populate missing info (info not to be chnaged) from global user
            if (TextUtils.isEmpty(name)) name           = GlobalUser.getGName();
            if (TextUtils.isEmpty(surname)) surname     = GlobalUser.getGSurname();
            if (TextUtils.isEmpty(name)) city           = GlobalUser.getGCity();
            if (TextUtils.isEmpty(suburb)) suburb       = GlobalUser.getGSuburb();
            if (TextUtils.isEmpty(name)) province       = GlobalUser.getGProvince();

            if (TextUtils.isEmpty(newPassword)) newPassword = currentPassword;

            // User entered change to e-Mail: check if e-Mail exists in db
            if (!TextUtils.isEmpty(email)){
                // if exists
                if (db.checkEmail(email)){
                    txtEmail.setError("!");
                    Toast.makeText(context, "e-Mail is already in use", Toast.LENGTH_SHORT).show();
                }else{
                    if (TextUtils.isEmpty(email)) email = GlobalUser.getGEmail(); // existing value
                }
            }

            //updateUser
            User updatedUserInformation = new User(userId, name, surname, email, newPassword, city, suburb, province);
            db.updateUser(updatedUserInformation);


            Toast.makeText(context, "User profile has been updated", Toast.LENGTH_SHORT).show();

            // User cannot commit changes since password does not match based on global user
        }else{
            txtCurrentPassword.setError("Password is incorrect.");
            return;
        }
    }
}