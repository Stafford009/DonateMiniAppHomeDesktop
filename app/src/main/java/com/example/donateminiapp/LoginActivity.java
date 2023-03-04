package com.example.donateminiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private ImageView mGannonLogo;
    private TextView mLoginText;
    private TextView mAttemptsText;
    private TextView mAttemptsCounter;
    private int mCounter = 3;
    private EditText mUsername;
    private EditText mPassword;
    private Button mLoginButton;
    private Button mCancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mGannonLogo = findViewById(R.id.GannonLogo);
        mLoginText = findViewById(R.id.LoginText);
        mAttemptsText = findViewById(R.id.AttemptsText);
        mAttemptsCounter = findViewById(R.id.AttemptsCounter);
        mUsername = findViewById(R.id.Username);
        mPassword = findViewById(R.id.Password);
        mLoginButton = findViewById(R.id.LoginButton);
        mCancelButton = findViewById(R.id.CancelButton);


        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((mUsername.getText().toString().equals("User")) && (mPassword.getText().toString().equals("Gannon123"))){
                    Intent intent = new Intent(LoginActivity.this, DonateActivity.class);
                    startActivity(intent);
                }
                else{
                    mCounter--;

                    mAttemptsCounter.setText(Integer.toString(mCounter));

                    if (mCounter == 0){
                        mLoginButton.setEnabled(false);

                        Toast tmsg = Toast.makeText(getApplicationContext(), "No More Attempts Allowed, Please Cancel Donation.",
                                Toast.LENGTH_SHORT);
                        tmsg.show();
                    }
                }
            }
        });

        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginActivity.this.finish();
                System.exit(0);
            }
        });
    }
}