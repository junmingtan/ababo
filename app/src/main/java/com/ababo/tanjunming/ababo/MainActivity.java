package com.ababo.tanjunming.ababo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mUpcomingAppointmentButton;
    private TextView mUpcomingAppointmentView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_dashboard:
                    startActivity(new Intent(MainActivity.this, Donate.class));
                    return true;
                case R.id.navigation_notifications:
                    startActivity(new Intent(MainActivity.this, Explore.class));
                    return true;
            }
            return false;
        }
    };

    private ProgressBar mNextDonation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_home);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        ImageButton mEditProfileButton = (ImageButton) findViewById(R.id.editProfile);
        mEditProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, EditProfile.class));
            }
        });

        mNextDonation = (ProgressBar) findViewById(R.id.progressBar);
        mNextDonation.setProgress(70);

        String nextAppointmentDate = "No Upcoming";
        String nextAppointmentLocation= "Appointments";

        if(NextAppointment.getAppointmentDate() != null)
            nextAppointmentDate = NextAppointment.getAppointmentDate();

        if(NextAppointment.getAppointmentLocation() != null)
            nextAppointmentLocation = NextAppointment.getAppointmentLocation();

        mUpcomingAppointmentView = (TextView) findViewById(R.id.displayUA);
        mUpcomingAppointmentView.setText(nextAppointmentDate + " " + nextAppointmentLocation);
        mUpcomingAppointmentButton = (Button) findViewById(R.id.upcomingapptbutton);
        mUpcomingAppointmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, UpcomingAppointment.class));
            }
        });



    }

}
