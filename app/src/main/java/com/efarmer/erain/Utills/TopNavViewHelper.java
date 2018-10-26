package com.efarmer.erain.Utills;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.efarmer.erain.Profile.EditActivity;
import com.efarmer.erain.Profile.ProfileActivity;
import com.efarmer.erain.R;


public class TopNavViewHelper {
    private static final String TAG = "TopNavViewHelper";

    public static void enableNavigation(final Context context, Toolbar view){
        view.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_profile:
                        Intent intentProfile = new Intent(context, EditActivity.class);
                        context.startActivity(intentProfile);
                        break;
                }
                return false;
            }
        });
    }
}
