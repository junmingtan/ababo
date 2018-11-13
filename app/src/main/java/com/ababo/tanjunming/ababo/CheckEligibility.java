package com.ababo.tanjunming.ababo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class CheckEligibility extends AppCompatActivity {

    private Button mSubmitEligibilityFormButton;
    private RadioGroup mRadioGroupQ1;
    private RadioGroup mRadioGroupQ2;
    private RadioGroup mRadioGroupQ3;
    private RadioGroup mRadioGroupQ4;
    private RadioGroup mRadioGroupQ5;
    private  RadioGroup mRadioGroupQ6;
    private  RadioGroup mRadioGroupQ7;
    private  RadioGroup mRadioGroupQ8;
    private  RadioGroup mRadioGroupQ9;
    private  RadioGroup mRadioGroupQ10;
    View focusView = null;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(CheckEligibility.this, MainActivity.class));
                    return true;
                case R.id.navigation_dashboard:
                    startActivity(new Intent(CheckEligibility.this, Donate.class));
                    return true;
                case R.id.navigation_notifications:
                    startActivity(new Intent(CheckEligibility.this, Explore.class));
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_eligibility);

        mRadioGroupQ1 = (RadioGroup) findViewById(R.id.q1);
        mRadioGroupQ2 = (RadioGroup) findViewById(R.id.q2);
        mRadioGroupQ3 = (RadioGroup) findViewById(R.id.q3);
        mRadioGroupQ4 = (RadioGroup) findViewById(R.id.q4);
        mRadioGroupQ5 = (RadioGroup) findViewById(R.id.q5);
        mRadioGroupQ6 = (RadioGroup) findViewById(R.id.q6);
        mRadioGroupQ7 = (RadioGroup) findViewById(R.id.q7);
        mRadioGroupQ8 = (RadioGroup) findViewById(R.id.q8);
        mRadioGroupQ9 = (RadioGroup) findViewById(R.id.q9);
        mRadioGroupQ10 = (RadioGroup) findViewById(R.id.q10);

        mSubmitEligibilityFormButton = (Button) findViewById(R.id.checkeligsubmit);
        mSubmitEligibilityFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkCompleted()){
                    if(verifyEligibility()){
                        AlertDialog.Builder builder = new AlertDialog.Builder(CheckEligibility.this);

                        builder.setCancelable(true);
                        builder.setTitle("Congratulations!");
                        builder.setMessage("You are eligible to donate blood.");

                        builder.setPositiveButton("Indicate Interest", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                startActivity(new Intent(CheckEligibility.this, IndicateInterestActivity.class));
                            }
                        });

                        builder.setNegativeButton("Book Appointment", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(CheckEligibility.this, BookAppointment.class));
                            }
                        });

                        builder.show();
                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(CheckEligibility.this);

                        builder.setCancelable(true);
                        builder.setTitle("");
                        builder.setMessage("Sorry you are not eligible to donate.");

                        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                dialogInterface.cancel();
                            }
                        });
                        builder.show();

                    }
                }
            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_dashboard);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private boolean verifyEligibility(){

        boolean result = true;
        if(mRadioGroupQ1.getCheckedRadioButtonId() == R.id.qn1no)
            result = false;
        else if(mRadioGroupQ2.getCheckedRadioButtonId() == R.id.qn2no)
            result = false;
        else if(mRadioGroupQ3.getCheckedRadioButtonId() == R.id.qn3no)
            result = false;
        else if(mRadioGroupQ4.getCheckedRadioButtonId() == R.id.qn4yes)
            result = false;
        else if(mRadioGroupQ5.getCheckedRadioButtonId() == R.id.qn5yes)
            result = false;
        else if(mRadioGroupQ6.getCheckedRadioButtonId() == R.id.qn6yes)
            result = false;
        else if(mRadioGroupQ7.getCheckedRadioButtonId() == R.id.qn7yes)
            result = false;
        else if(mRadioGroupQ8.getCheckedRadioButtonId() == R.id.qn8yes)
            result = false;
        else if(mRadioGroupQ9.getCheckedRadioButtonId() == R.id.qn9yes)
            result = false;
        else if(mRadioGroupQ10.getCheckedRadioButtonId() == R.id.qn10yes)
            result = false;
    
        return result;
    }

    private boolean checkCompleted(){
        boolean result = true;
        RadioButton lastRadioBtn1 = (RadioButton) findViewById(R.id.qn1no);
        RadioButton lastRadioBtn2 = (RadioButton) findViewById(R.id.qn2no);
        RadioButton lastRadioBtn3 = (RadioButton) findViewById(R.id.qn3no);
        RadioButton lastRadioBtn4 = (RadioButton) findViewById(R.id.qn4no);
        RadioButton lastRadioBtn5 = (RadioButton) findViewById(R.id.qn5no);
        RadioButton lastRadioBtn6 = (RadioButton) findViewById(R.id.qn6no);
        RadioButton lastRadioBtn7 = (RadioButton) findViewById(R.id.qn7no);
        RadioButton lastRadioBtn8 = (RadioButton) findViewById(R.id.qn8no);
        RadioButton lastRadioBtn9 = (RadioButton) findViewById(R.id.qn9no);
        RadioButton lastRadioBtn10 = (RadioButton) findViewById(R.id.qn10no);
        View focusView = null;

        if(mRadioGroupQ1.getCheckedRadioButtonId() <= 0){
            lastRadioBtn1.setError("Select Item");
            focusView = mRadioGroupQ1;
            result = false;
        }
        if(mRadioGroupQ2.getCheckedRadioButtonId() <= 0){
            lastRadioBtn2.setError("Select Item");
            focusView = mRadioGroupQ2;
            result = false;
        }
        if(mRadioGroupQ3.getCheckedRadioButtonId() <= 0){
            lastRadioBtn3.setError("Select Item");
            focusView = mRadioGroupQ3;
            result = false;
        }
        if(mRadioGroupQ4.getCheckedRadioButtonId() <= 0){
            lastRadioBtn4.setError("Select Item");
            focusView = mRadioGroupQ4;
            result = false;
        }
        if(mRadioGroupQ5.getCheckedRadioButtonId() <= 0){
            lastRadioBtn5.setError("Select Item");
            focusView = mRadioGroupQ5;
            result = false;
        }
        if(mRadioGroupQ6.getCheckedRadioButtonId() <= 0){
            lastRadioBtn6.setError("Select Item");
            focusView = mRadioGroupQ6;
            result = false;
        }
        if(mRadioGroupQ7.getCheckedRadioButtonId() <= 0){
            lastRadioBtn7.setError("Select Item");
            focusView = mRadioGroupQ7;
            result = false;
        }
        if(mRadioGroupQ8.getCheckedRadioButtonId() <= 0){
            lastRadioBtn8.setError("Select Item");
            focusView = mRadioGroupQ8;
            result = false;
        }
        if(mRadioGroupQ9.getCheckedRadioButtonId() <= 0){
            lastRadioBtn9.setError("Select Item");
            focusView = mRadioGroupQ9;
            result = false;
        }
        if(mRadioGroupQ10.getCheckedRadioButtonId() <= 0){
            lastRadioBtn10.setError("Select Item");
            focusView = mRadioGroupQ10;
            result = false;
        }
        if (result == false)
            focusView.requestFocus();
        return result;
    }

}
