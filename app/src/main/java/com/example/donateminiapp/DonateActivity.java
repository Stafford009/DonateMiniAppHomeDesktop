package com.example.donateminiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DonateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
    }

    boolean check  = false;   // initial state of your radio button
        myRadioButton.setOnClickListener(view -> {
        if (check) {
            myRadioButton.setChecked(false);
            check = false;
            //write code for when button is unchecked
        } else {
            check = true;
            myRadioButton.setChecked(true);
            //write code for when button is checked
        }
    });
}