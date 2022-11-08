package com.example.efhem_rouhek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Acceuil extends AppCompatActivity {
    private Button Suivant;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);

        Suivant= findViewById(R.id.commencer);
        Suivant.setOnClickListener(view ->
        {
            Intent intent = new Intent(this ,Welcome.class);
            startActivity(intent);


        });

    }
}