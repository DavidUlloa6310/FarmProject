package com.example.farmproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class SeeDataActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    TextView farmerName, numCows, numPigs, numSheep, funFact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_data);
        sharedPreferences = getApplicationContext().getSharedPreferences("Data", MODE_PRIVATE);

        farmerName = findViewById(R.id.textView2);
        numCows = findViewById(R.id.textView3);
        numPigs = findViewById(R.id.textView4);
        numSheep = findViewById(R.id.textView5);
        funFact = findViewById(R.id.textView7);

        getData();

    }

    @Override
    public void onResume() {
        super.onResume();
        getData();
    }

    public void getData() {
        String jsonString = sharedPreferences.getString("data", "");
        System.out.println(jsonString);
        Gson gson = new Gson();
        Farm farm = gson.fromJson(jsonString, Farm.class);

//        System.out.println(farm.getFarmerName() + " " + farm.getFunFact());

        farmerName.setText("Farmer Name: " + farm.getFarmerName());
        numCows.setText("# Cows: " + farm.getNumCows());
        numPigs.setText("# Pigs: " + farm.getNumPigs());
        numSheep.setText("# Sheep: " + farm.getNumSheeps());
        funFact.setText("Fun Fact: " + farm.getFunFact());
    }
}