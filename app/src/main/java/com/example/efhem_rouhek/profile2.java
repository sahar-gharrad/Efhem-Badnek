package com.example.efhem_rouhek;

import static com.example.efhem_rouhek.Welcome.PREF_NAME;
import static com.example.efhem_rouhek.Welcome.nomShared;
import static com.example.efhem_rouhek.Welcome.poidShared;
import static com.example.efhem_rouhek.Welcome.prenomShared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.Date;

public class profile2 extends AppCompatActivity {
    private EditText nom;
    private EditText prenom;
    private EditText dateNaissance;
    private EditText poid;
    private EditText longueur;

    private Button modifier;
    private SharedPreferences sharedpreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);

        nom= findViewById(R.id.nom);
        prenom= findViewById(R.id.prenom);
        dateNaissance= findViewById(R.id.date);
        poid= findViewById(R.id.poids);
        longueur= findViewById(R.id.longueur);

        modifier=findViewById(R.id.modifierbtn);
        sharedpreference = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        String s1 = sharedpreference.getString(nomShared, "");
        String s2 = sharedpreference.getString(prenomShared, "");
        String s3 = sharedpreference.getString(poidShared, "");
        nom.setText(s1);
        prenom.setText(s2);
        poid.setText(s3);





    }
}