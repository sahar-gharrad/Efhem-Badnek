package com.example.efhem_rouhek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class maladie extends AppCompatActivity {

    Button test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maladie);

        Intent intent = new Intent(this ,quiz1.class);
        test.findViewById(R.id.faireTest);
        test.setOnClickListener(view ->
                {

                    startActivity(intent);

                });



    }
}