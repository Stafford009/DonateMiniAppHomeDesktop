package com.example.donateminiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DonateActivity extends AppCompatActivity {

    private RadioButton mCheckButton;
    private RadioButton mDirectButton;
    private Button mUploadButton;
    private Button mDonateButton;
    private TextView mDonateTitle;
    private TextView mGenerousText;
    private TextView mAmountText;
    private TextView mOverallTotal;
    private TextView mShownTotal;
    private EditText mPaymentAmount;
    private ImageView mCheckImage;
    private ProgressBar mDonationProgress;
    private NumberPicker mNumberPicker;
    private int TotalDonated = 0;
    private boolean TargetReached = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        mCheckButton = findViewById(R.id.CheckButton);
        mDirectButton = findViewById(R.id.DirectButton);
        mUploadButton = findViewById(R.id.UploadButton);
        mDonateButton = findViewById(R.id.DonateButton);
        mDonateTitle = findViewById(R.id.DonateTitle);
        mGenerousText = findViewById(R.id.GenerousText);
        mAmountText = findViewById(R.id.AmountText);
        mOverallTotal = findViewById(R.id.OverallTotal);
        mShownTotal = findViewById(R.id.ShownTotal);
        mPaymentAmount = findViewById(R.id.PaymentAmount);
        mDonationProgress = findViewById(R.id.DonationProgress);
        mNumberPicker = findViewById(R.id.NumberPicker);

        mNumberPicker.setMinValue(0);
        mNumberPicker.setMaxValue(1000);
        mDonationProgress.setMax(10000);
        mShownTotal.setText("Php.0");


        mDonateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}