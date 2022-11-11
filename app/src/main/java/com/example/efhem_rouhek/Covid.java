package com.example.efhem_rouhek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.bottomappbar.BottomAppBar;

public class Covid extends AppCompatActivity {

    Button test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid);

        Intent intent = new Intent(this ,quiz1.class);
        test = (Button) findViewById(R.id.faireTest);
        test.setOnClickListener(view ->
        {

            startActivity(intent);

        });
    }
}