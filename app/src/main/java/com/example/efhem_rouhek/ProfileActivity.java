package com.example.efhem_rouhek;

import static com.example.efhem_rouhek.Welcome.PREF_NAME;
import static com.example.efhem_rouhek.Welcome.nomShared;
import static com.example.efhem_rouhek.Welcome.prenomShared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {

    private EditText nom;
    private EditText prenom;
    private EditText email;
    private EditText password;
    private Button modifier;
    private SharedPreferences sharedpreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

    //init
        nom= findViewById(R.id.nom);
        prenom= findViewById(R.id.prenom);
        email= findViewById(R.id.email);
        password= findViewById(R.id.password);
        nom= findViewById(R.id.nom);
        modifier=findViewById(R.id.modifierbtn);

        sharedpreference = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        String s1 = sharedpreference.getString(nomShared, "");
        String s2 = sharedpreference.getString(prenomShared, "");
        nom.setText(s1);
        prenom.setText(s1);





    }
}