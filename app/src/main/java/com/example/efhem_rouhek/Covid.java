package com.example.efhem_rouhek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.efhem_rouhek.Entity.maladie;
import com.example.efhem_rouhek.Entity.symptomes;
import com.example.efhem_rouhek.database.AppDataBase;
import com.google.android.material.bottomappbar.BottomAppBar;

import java.util.List;

public class Covid extends AppCompatActivity {

    Button test;
    private AppDataBase database ;
    private List<maladie> listmaladie;
    private List<maladie> listmaladiNow;
    private List<symptomes> listsymp;
    private List<symptomes> listsympNow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid);
        database = AppDataBase.getAppDatabase(this);
        listmaladie = database.MaladieDAO().getAll();
        listsymp = database.SymptomesDAO().getAll();


        Intent intent = new Intent(this ,quiz1.class);
        test = (Button) findViewById(R.id.faireTest);
        test.setOnClickListener(view ->
        {


            startActivity(intent);

        });
    }
}