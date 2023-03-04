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

public class LoginActivity extends AppCompatActivity {

    private ImageView mGannonLogo;
    private TextView mLoginText;
    private TextView mAttemptsText;
    private int mAttemptsCounter = 3;
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
        mUsername = findViewById(R.id.Username);
        mPassword = findViewById(R.id.Password);
        mLoginButton = findViewById(R.id.LoginButton);
        mCancelButton = findViewById(R.id.CancelButton);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(mUsername.getText().toString(), mPassword.getText().toString());
            }
        });

        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void validate(String userName, String userPassword){
        if((userName == "User") && (userPassword == "Gannon123")){
            Intent intent = new Intent(LoginActivity.this, DonateActivity.class);
            startActivity(intent);
        }
        else{
                mAttemptsCounter--;

                if (mAttemptsCounter == 0){
                    mLoginButton.setEnabled(false);
                }
        }
    }
}