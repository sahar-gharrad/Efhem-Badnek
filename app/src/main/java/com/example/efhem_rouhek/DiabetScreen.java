package com.example.efhem_rouhek;

import androidx.appcompat.app.AppCompatActivity;


import static com.example.efhem_rouhek.Welcome.DiabeteShared;
import static com.example.efhem_rouhek.Welcome.PREF_NAME;

import static com.example.efhem_rouhek.Welcome.poidShared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import android.os.Bundle;

public class DiabetScreen extends AppCompatActivity {

    private Button Oui;

    private Button Non;
    private Button Jsp;

    private SharedPreferences sharedpreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diabet_screen);


        sharedpreference = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        Oui= findViewById(R.id.btnOui);
        Non= findViewById(R.id.btnNon);
        Jsp= findViewById(R.id.btnJsp);

        Oui.setOnClickListener(view ->
        {


            // Creating an Editor object to edit(write to the file)
            SharedPreferences.Editor myEdit = sharedpreference.edit();

// Storing the key and its value as the data fetched from edittext
            myEdit.putString(DiabeteShared, "OUI");
            // Once the changes have been made,
// we need to commit to apply those changes made,
// otherwise, it will throw an error
            myEdit.commit();
            String s1 = sharedpreference.getString(DiabeteShared, "");
            System.out.println(s1);


            Intent intent = new Intent(this ,Tension.class);
            startActivity(intent);

            finish();
        });
        Non.setOnClickListener(view ->
        {


            // Creating an Editor object to edit(write to the file)
            SharedPreferences.Editor myEdit = sharedpreference.edit();

// Storing the key and its value as the data fetched from edittext
            myEdit.putString(DiabeteShared, "NON");
            // Once the changes have been made,
// we need to commit to apply those changes made,
// otherwise, it will throw an error
            myEdit.commit();
            String s1 = sharedpreference.getString(DiabeteShared, "");
            System.out.println(s1);


            Intent intent = new Intent(this ,Tension.class);
            startActivity(intent);
            finish();

        });
        Jsp.setOnClickListener(view ->
        {


            // Creating an Editor object to edit(write to the file)
            SharedPreferences.Editor myEdit = sharedpreference.edit();

// Storing the key and its value as the data fetched from edittext
            myEdit.putString(DiabeteShared, "JSP");
            // Once the changes have been made,
// we need to commit to apply those changes made,
// otherwise, it will throw an error
            myEdit.commit();
            String s1 = sharedpreference.getString(DiabeteShared, "");
            System.out.println(s1);


            Intent intent = new Intent(this ,Tension.class);
            startActivity(intent);
            finish();

        });


    }
}