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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Date;

public class BookAppointment extends AppCompatActivity {

    private Spinner bloodbankSelectionSpinner;
    private Spinner bloodtypeSelectionSpinner;
    private Button submitBookAppointmentButton;
    private EditText mNameView;
    private EditText mIdentificationNumberView;
    private EditText mContactNumberView;
    private EditText mEmailAddressView;
    private CalendarView mAppointmentDateView;
    private String appointmentDate;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(BookAppointment.this, MainActivity.class));
                    return true;
                case R.id.navigation_dashboard:
                    startActivity(new Intent(BookAppointment.this, Donate.class));
                    return true;
                case R.id.navigation_notifications:
                    startActivity(new Intent(BookAppointment.this, Explore.class));
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_dashboard);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        bloodbankSelectionSpinner = (Spinner) findViewById(R.id.bloodbank);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.bloodbanks, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloodbankSelectionSpinner.setAdapter(adapter);

        bloodtypeSelectionSpinner = (Spinner) findViewById(R.id.bloodtype);
        ArrayAdapter<CharSequence> bloodtypeAdapter = ArrayAdapter.createFromResource(this,
                R.array.bloodtypes, android.R.layout.simple_spinner_item);
        bloodtypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloodtypeSelectionSpinner.setAdapter(bloodtypeAdapter);

        mAppointmentDateView = (CalendarView) findViewById(R.id.calendarView);
        mAppointmentDateView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                appointmentDate = dayOfMonth + "/" + month + "/" + year;
            }
        });

        mNameView = (EditText) findViewById(R.id.name);
        mNameView.setText(R.string.user_name);

        mIdentificationNumberView =  (EditText) findViewById(R.id.nric);
        mIdentificationNumberView.setText(R.string.identification_number);

        mContactNumberView = (EditText) findViewById(R.id.phone);
        mContactNumberView.setText(R.string.contact_number);

        mEmailAddressView = (EditText) findViewById(R.id.apptemail);
        mEmailAddressView.setText(R.string.email_address);

        submitBookAppointmentButton = (Button) findViewById(R.id.bookapptsubmit);
        submitBookAppointmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add implementation code here
                Log.d(getClass().getName(), CreateAppointment());
                AlertDialog.Builder builder = new AlertDialog.Builder(BookAppointment.this);

                builder.setCancelable(true);
                builder.setTitle("Appointment Confirmed");
                builder.setMessage(CreateAppointment());

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        startActivity(new Intent(BookAppointment.this, Donate.class));
                    }
                });

                builder.show();
            }
        });

    }

    private String CreateAppointment(){
        String bookingBloodbank = bloodbankSelectionSpinner.getSelectedItem().toString();
        String bookingDate = appointmentDate;
        String name = mNameView.getText().toString();
        String nric = mIdentificationNumberView.getText().toString();
        String contact = mContactNumberView.getText().toString();
        String email = mEmailAddressView.getText().toString();
        String bloodType = bloodtypeSelectionSpinner.getSelectedItem().toString();

        String result = "\nAppointment Details: \n" +
                "Bloodbank: " + bookingBloodbank +
                "\nDate of Appointment: " + bookingDate +
                "\nName: " + name +
                "\nNRIC: " + nric +
                "\nContact Number: " + contact +
                "\nEmail: " + email +
                "\nBlood Type: " + bloodType;
        return result;
    }

}
