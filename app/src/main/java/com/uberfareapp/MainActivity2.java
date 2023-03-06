package com.uberfareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String myString = preferences.getString("myString", "");
        //Toast.makeText(this, myString, Toast.LENGTH_LONG).show();

        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(myString);

    }



}