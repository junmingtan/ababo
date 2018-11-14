package com.ababo.tanjunming.ababo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class UpcomingAppointment extends AppCompatActivity {

    private TextView mUpcomingAppointmentDate;
    private TextView mUpcomingAppointmentLocation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(UpcomingAppointment.this, MainActivity.class));
                    return true;
                case R.id.navigation_dashboard:
                    startActivity(new Intent(UpcomingAppointment.this, Donate.class));
                    return true;
                case R.id.navigation_notifications:
                    startActivity(new Intent(UpcomingAppointment.this, Explore.class));
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_appointment);

        mUpcomingAppointmentDate = (TextView) findViewById(R.id.upcomingapptdate);
        mUpcomingAppointmentDate.setText(NextAppointment.getAppointmentDate());
        mUpcomingAppointmentLocation = (TextView) findViewById(R.id.upcomingapptloc);
        mUpcomingAppointmentLocation.setText(NextAppointment.getAppointmentLocation());
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
