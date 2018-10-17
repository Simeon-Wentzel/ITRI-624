package com.efarmer.erain;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class Sign_Up extends AppCompatActivity {

    public Button btnSignUp;
    public EditText txtName, txtSurname, txtEmail_su, txtCell;
    public EditText txtCity, txtProvince,  txtPassword_su, txtConfirmPassword;
    public String URL = "http://erain.ddns.net:8080/signup.php";
    JSONObject jsonObject;

    //Create an on click listener
    private View.OnClickListener OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            btnSignUpClicked();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);

        btnSignUp = (Button) findViewById(R.id.btnSignup);
        txtName = (EditText) findViewById(R.id.txtName);
        txtSurname = (EditText) findViewById(R.id.txtSurname);
        txtEmail_su = (EditText) findViewById(R.id.txtEmail_su);
        txtCell = (EditText) findViewById(R.id.txtCell);
        txtCity = (EditText) findViewById(R.id.txtCity);
        txtProvince = (EditText) findViewById(R.id.txtProvince);
        txtPassword_su = (EditText) findViewById(R.id.txtPassword_su);
        txtConfirmPassword = (EditText) findViewById(R.id.txtConfirmPassword);

        btnSignUp.setOnClickListener(OnClickListener);
    }

    //On click event for btnSignIn
    private void btnSignUpClicked() {
        jsonObject = new JSONObject();
        String name = txtName.getText().toString();
        String surname = txtSurname.getText().toString();
        String email = txtEmail_su.getText().toString();
        String cell = txtCell.getText().toString();
        String city = txtCity.getText().toString();
        String password = txtPassword_su.getText().toString();
        try {
            jsonObject.put("name", name);
            jsonObject.put("surname", surname);
            jsonObject.put("email", email);
            jsonObject.put("cell", cell);
            jsonObject.put("city", city);
            jsonObject.put("password", password);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String result = response.toString();
                        Log.d("responce", "result :" + result);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        MySingleton.getInstance(this).addToRequestque(jsonObjectRequest);

    }
}
