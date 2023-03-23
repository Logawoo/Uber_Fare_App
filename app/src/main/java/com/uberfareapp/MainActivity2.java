package com.uberfareapp;

import static java.lang.Double.parseDouble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //accessing shared preferences
        SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String userInput = sharedPref.getString("userInput", "");
        String selectedValue = sharedPref.getString("selectedValue", "");

        //set the textview to show the miles
        TextView textView = findViewById(R.id.textView);
        textView.setText(userInput);
        //set the textview to show the type of car
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText(selectedValue);

        //assigning variables with user inputs to work with
        Double miles = Double.parseDouble(userInput);
        String carType = selectedValue;

        //setting totalCost variable to what is returned from TotalCalc function
        double totalCost = TotalCalc(miles, carType);

        TextView textView3 = findViewById(R.id.textView3);
        textView3.setText("$" + totalCost);

        //order and go back buttons and their onClicks below
        Button button1 = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    //function to calculate cost based on different car and miles
    public double TotalCalc(Double miles,String carType) {
        double costPerMile = 0;
        double fee = 0;

        if (carType.equals("SUV")) {
            costPerMile = 3.25;
            fee = 8.00;
        }
        else if (carType.equals("Smart Car")) {
            costPerMile = 3.25;
            fee = 5.00;
        }
        else if (carType.equals("Sedan")) {
            costPerMile = 3.25;
            fee = 3.00;
        }

        double totalCost = miles * costPerMile + fee;
        return totalCost;
    }


}