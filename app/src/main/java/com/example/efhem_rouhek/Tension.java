package com.example.efhem_rouhek;


import static com.example.efhem_rouhek.Welcome.PREF_NAME;
import static com.example.efhem_rouhek.Welcome.TensionShared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

public class Tension extends AppCompatActivity {


    private Button Oui;

    private Button Non;
    private Button Jsp;

    private SharedPreferences sharedpreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tension);



        sharedpreference = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        Oui= findViewById(R.id.btnOui);
        Non= findViewById(R.id.btnNon);
        Jsp= findViewById(R.id.btnJsp);

        Oui.setOnClickListener(view ->
        {


            // Creating an Editor object to edit(write to the file)
            SharedPreferences.Editor myEdit = sharedpreference.edit();

// Storing the key and its value as the data fetched from edittext
            myEdit.putString(TensionShared, "OUI");
            // Once the changes have been made,
// we need to commit to apply those changes made,
// otherwise, it will throw an error
            myEdit.commit();
            String s1 = sharedpreference.getString(TensionShared, "");
            System.out.println(s1);


            Intent intent = new Intent(this ,Poid_screen.class);
            startActivity(intent);
            finish();


        });
        Non.setOnClickListener(view ->
        {


            // Creating an Editor object to edit(write to the file)
            SharedPreferences.Editor myEdit = sharedpreference.edit();

// Storing the key and its value as the data fetched from edittext
            myEdit.putString(TensionShared, "NON");
            // Once the changes have been made,
// we need to commit to apply those changes made,
// otherwise, it will throw an error
            myEdit.commit();
            String s1 = sharedpreference.getString(TensionShared, "");
            System.out.println(s1);


            Intent intent = new Intent(this ,Poid_screen.class);
            startActivity(intent);

            finish();
        });
        Jsp.setOnClickListener(view ->
        {


            // Creating an Editor object to edit(write to the file)
            SharedPreferences.Editor myEdit = sharedpreference.edit();

// Storing the key and its value as the data fetched from edittext
            myEdit.putString(TensionShared, "JSP");
            // Once the changes have been made,
// we need to commit to apply those changes made,
// otherwise, it will throw an error
            myEdit.commit();
            String s1 = sharedpreference.getString(TensionShared, "");
            System.out.println(s1);


            Intent intent = new Intent(this ,Poid_screen.class);
            startActivity(intent);

            finish();
        });


    }



    }
