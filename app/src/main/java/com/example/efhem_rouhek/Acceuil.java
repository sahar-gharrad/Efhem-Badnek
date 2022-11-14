package com.example.efhem_rouhek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import com.example.efhem_rouhek.Entity.maladie;
import com.example.efhem_rouhek.database.AppDataBase;

import java.util.List;

public class Acceuil extends AppCompatActivity {
    private Button Suivant;

    private AppDataBase database ;

    private List<maladie> listmaladie;
    static final String longueurShared= "longueur";
    static final String PREF_NAME = "DATA";
    private SharedPreferences sharedpreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        sharedpreference = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        //init données
        database = AppDataBase.getAppDatabase(this);
        String s1 = sharedpreference.getString(longueurShared, "");
        if (s1 != ""){
            Intent intent = new Intent(this ,MainActivity.class);
            startActivity(intent);
            finish();
        }
        listmaladie = database.MaladieDAO().getAll();
        if(listmaladie.isEmpty()){
            database.MaladieDAO().Insterall();
            database.DoctorDAO().Insterall();
            database.SymptomesDAO().Insterall();
            database.CategorieDAO().Insterall();
        }


        Suivant= findViewById(R.id.commencer);
        Suivant.setOnClickListener(view ->
        {
            Intent intent = new Intent(this ,Welcome.class);
            startActivity(intent);
            finish();


        });

    }
}