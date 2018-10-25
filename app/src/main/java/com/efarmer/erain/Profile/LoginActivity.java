package com.efarmer.erain.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.efarmer.erain.R;
import com.efarmer.erain.Utills.MySingleton;

import org.json.JSONException;
import org.json.JSONObject;


public class LoginActivity extends AppCompatActivity{

    public Button btnSignIn, btnNoAccount, btnForgotPassword;
    public EditText txtEmail, txtPassword;
    public String URL = "http://erain.ddns.net:8080/signin.php";
    JSONObject jsonObject;

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
        public void onClick(View v) {
            btnNoAccountClicked();
        }
    };

    //Create an on click listener for Signin
    private View.OnClickListener OnSignInClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
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
    private void btnForgotPassowrdClicked(){
        Intent intent = new Intent(LoginActivity.this, ForgotPassword.class);
        LoginActivity.this.startActivity(intent);
    }

    //On click event for btmNoAccount
    private void btnNoAccountClicked(){
        Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
        LoginActivity.this.startActivity(intent);
    }

    //On click event for btnSignIn
    private void btnSignInClicked() {
        jsonObject = new JSONObject();
        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();
        try {
            jsonObject.put("email", email);
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

