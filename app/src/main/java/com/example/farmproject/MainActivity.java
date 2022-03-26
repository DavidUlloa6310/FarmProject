package com.example.farmproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToAddData(View view) {
        Intent intent = new Intent(getApplicationContext(), AddDataActivity.class);
        startActivity(intent);
    }

    public void goToSeeData(View view) {
        Intent intent = new Intent(getApplicationContext(), SeeDataActivity.class);
        startActivity(intent);
    }
}