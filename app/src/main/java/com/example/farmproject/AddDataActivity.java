package com.example.farmproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

public class AddDataActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor myEdit;

    TextView farmerName, numCows, numPigs, numSheep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        farmerName = findViewById(R.id.farmerNameView);
        numCows = findViewById(R.id.numCowsView);
        numPigs = findViewById(R.id.numPigsView);
        numSheep = findViewById(R.id.numSheepView);

        Context context = getApplicationContext();
        sharedPreferences = getSharedPreferences("Data", MODE_PRIVATE);
        myEdit = sharedPreferences.edit();
    }

    public void submit(View view) {

        String farmNameText = farmerName.getText().toString();
        String numCowsText = numCows.getText().toString();
        String numPigsText =  numPigs.getText().toString();
        String numSheepText = numSheep.getText().toString();

        if (farmNameText.equals("") || numCowsText.equals("") || numPigsText.equals("") || numSheepText.equals("")) {
            Toast.makeText(getApplicationContext(), "Please enter all the data!", Toast.LENGTH_LONG).show();
            return;
        }

        Farm farm = new Farm(farmNameText, numCowsText, numPigsText, numSheepText);
        Gson gson = new Gson();
        String jsonString = gson.toJson(farm);
        myEdit.putString("data", jsonString);
        myEdit.apply();

        farmerName.setText("");
        numCows.setText("");
        numPigs.setText("");
        numSheep.setText("");

        Toast.makeText(getApplicationContext(), "Farm set!", Toast.LENGTH_LONG).show();
    }
}