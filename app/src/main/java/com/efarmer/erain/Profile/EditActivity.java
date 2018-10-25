package com.efarmer.erain.Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.efarmer.erain.R;

public class EditActivity extends AppCompatActivity {

    private static final String TAG = "EditActivity";
    private Context mContext = EditActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_edit);
    }
}