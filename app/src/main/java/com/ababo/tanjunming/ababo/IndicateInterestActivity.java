package com.ababo.tanjunming.ababo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


/**
 *  yet to add constraints to the xml files esp to the buttons and the test view file
 */
public class IndicateInterestActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner mInterestLocationSelectionSpinner;
    private Button mSubmitIndicateInterestButton;
    private EditText mNameView;
    private EditText mIdentificationNumberView;
    private EditText mContactNumberView;
    private EditText mEmailAddressView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(IndicateInterestActivity.this, MainActivity.class));
                    return true;
                case R.id.navigation_dashboard:
                    startActivity(new Intent(IndicateInterestActivity.this, Donate.class));
                    return true;
                case R.id.navigation_notifications:
                    startActivity(new Intent(IndicateInterestActivity.this, Explore.class));
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicate_interest);

        mInterestLocationSelectionSpinner = (Spinner) findViewById(R.id.iibloodbank);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.locations, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mInterestLocationSelectionSpinner.setAdapter(adapter);

        mNameView = (EditText) findViewById(R.id.iiname);
        mNameView.setText(R.string.user_name);

        mIdentificationNumberView =  (EditText) findViewById(R.id.iinric);
        mIdentificationNumberView.setText(R.string.identification_number);

        mContactNumberView = (EditText) findViewById(R.id.iiphone);
        mContactNumberView.setText(R.string.contact_number);

        mEmailAddressView = (EditText) findViewById(R.id.iiemail);
        mEmailAddressView.setText(R.string.email_address);

        mSubmitIndicateInterestButton = (Button) findViewById(R.id.submitIndicateInterest);
        mSubmitIndicateInterestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add implementation code here
                String selectedLocation = mInterestLocationSelectionSpinner.getSelectedItem().toString();
                Log.d(getClass().getName(), selectedLocation);
                startActivity(new Intent(IndicateInterestActivity.this, MainActivity.class));
            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_dashboard);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position , long l) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
