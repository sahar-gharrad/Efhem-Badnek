package com.example.efhem_rouhek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.efhem_rouhek.database.AppDataBase;

public class Acceuil extends AppCompatActivity {
    private Button Suivant;

    private AppDataBase database ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);

        //init données
        database = AppDataBase.getAppDatabase(this);
     //   database.MaladieDAO().Insterall();
       // database.DoctorDAO().Insterall();
       // database.SymptomesDAO().Insterall();

        Suivant= findViewById(R.id.commencer);
        Suivant.setOnClickListener(view ->
        {
            Intent intent = new Intent(this ,Welcome.class);
            startActivity(intent);


        });

    }
}