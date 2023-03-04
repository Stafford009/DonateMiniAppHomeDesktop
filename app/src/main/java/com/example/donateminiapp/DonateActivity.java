package com.example.donateminiapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

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
    private boolean GoalAchieved = false;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.donate:
                Intent intent1 = new Intent(getApplicationContext(), DonateActivity.class);
                startActivity(intent1);
                Toast.makeText(this, "Donation Screen Selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.report:
                Intent intent2 = new Intent(getApplicationContext(), ReportActivity.class);
                startActivity(intent2);
                Toast.makeText(this, "Report Screen Selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

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
        mShownTotal.setText("0");


        mDonateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int DonatedAmount = mNumberPicker.getValue();

                if (DonatedAmount == 0){
                    String text = mPaymentAmount.getText().toString();
                    if (!text.equals(""))
                        DonatedAmount = Integer.parseInt(text);

                }
                if (!GoalAchieved){
                    TotalDonated = TotalDonated + DonatedAmount;
                    mDonationProgress.setProgress(TotalDonated);
                    GoalAchieved = TotalDonated >= 10000;
                    String totalDonated = "$" + TotalDonated;
                    mShownTotal.setText(totalDonated);
                    Toast tmsg1 = Toast.makeText(getApplicationContext(), "Thank You For The Donation",
                            Toast.LENGTH_SHORT);
                    tmsg1.show();
                }
                if (GoalAchieved) {
                    TotalDonated = TotalDonated + DonatedAmount;
                    mDonationProgress.setProgress(TotalDonated);
                    String totalDonated = "$" + TotalDonated;
                    mShownTotal.setText(totalDonated);
                    Toast tmsg2 = Toast.makeText(getApplicationContext(), "Goal Achieved/Exceeded!",
                            Toast.LENGTH_SHORT);
                    tmsg2.show();

                }
            }
        });




    }
}