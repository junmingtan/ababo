package com.ababo.tanjunming.ababo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

public class CheckBloodReserve extends AppCompatActivity {

    private VerticalProgressBar aPlusLevel;
    private VerticalProgressBar bPlusLevel;
    private VerticalProgressBar oPlusLevel;
    private VerticalProgressBar abPlusLevel;
    private VerticalProgressBar aNegLevel;
    private VerticalProgressBar bNegLevel;
    private VerticalProgressBar oNegLevel;
    private VerticalProgressBar abNegLevel;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(CheckBloodReserve.this, MainActivity.class));
                    return true;
                case R.id.navigation_dashboard:
                    startActivity(new Intent(CheckBloodReserve.this, Donate.class));
                    return true;
                case R.id.navigation_notifications:
                    startActivity(new Intent(CheckBloodReserve.this, Explore.class));
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_blood_reserve);


        aPlusLevel = (VerticalProgressBar) findViewById(R.id.aplus);
        aPlusLevel.setProgress(100);
        bPlusLevel = (VerticalProgressBar) findViewById(R.id.bplus);
        bPlusLevel.setProgress(100);
        oPlusLevel = (VerticalProgressBar) findViewById(R.id.oplus);
        oPlusLevel.setProgress(100);
        abPlusLevel = (VerticalProgressBar) findViewById(R.id.abplus);
        abPlusLevel.setProgress(100);
        aNegLevel = (VerticalProgressBar) findViewById(R.id.aneg);
        aNegLevel.setProgress(51);
        bNegLevel = (VerticalProgressBar) findViewById(R.id.bneg);
        bNegLevel.setProgress(73);
        oNegLevel = (VerticalProgressBar) findViewById(R.id.oneg);
        oNegLevel.setProgress(16);
        abNegLevel = (VerticalProgressBar) findViewById(R.id.abneg);
        abNegLevel.setProgress(60);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_notifications);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
