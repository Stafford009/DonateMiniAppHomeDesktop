package com.example.donateminiapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
    }

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
}