package com.uberfareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //grabbing textView to put time estimate in
        TextView textView = findViewById(R.id.textView13);

        //using random class and nextInt method
        Random rand = new Random();
        //generating random number within an hour
        int randomNumber = rand.nextInt(60);

        //changing to string to display
        textView.setText(Integer.toString(randomNumber) + " Minutes");

        //Cancel Order button
        Button button = (Button) findViewById(R.id.button3);
        //Onclick to send back to first activity
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
            }

        });

    }

}