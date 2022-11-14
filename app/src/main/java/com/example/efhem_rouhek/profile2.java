package com.example.efhem_rouhek;

import static com.example.efhem_rouhek.Welcome.DiabeteShared;
import static com.example.efhem_rouhek.Welcome.PREF_NAME;
import static com.example.efhem_rouhek.Welcome.TensionShared;
import static com.example.efhem_rouhek.Welcome.longueurShared;
import static com.example.efhem_rouhek.Welcome.nomShared;
import static com.example.efhem_rouhek.Welcome.poidShared;
import static com.example.efhem_rouhek.Welcome.prenomShared;
import static com.example.efhem_rouhek.WelcomeTwo.DataShared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class profile2 extends AppCompatActivity {
    private EditText nom;
    private EditText prenom;
    private EditText dateNaissance;
    private EditText poid;
    private EditText longueur;
    private CheckBox diabcheckbox;
    private CheckBox tensioncheckbox;
    private TextView Name;

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
        Name= findViewById(R.id.textView10);

        tensioncheckbox= findViewById(R.id.checkBox3);
        diabcheckbox= findViewById(R.id.checkBox4);

        modifier=findViewById(R.id.modifierbtn);
        sharedpreference = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        String s1 = sharedpreference.getString(nomShared, "");
        String s2 = sharedpreference.getString(prenomShared, "");
        String s3 = sharedpreference.getString(poidShared, "");
        String s4 = sharedpreference.getString(TensionShared, "");
        String s5 = sharedpreference.getString(longueurShared, "");
        String s6 = sharedpreference.getString(DiabeteShared, "");
        String s7 = sharedpreference.getString(DataShared, "");
        Name.setText(s1+" "+s2);
        nom.setText("  " +s1);
        prenom.setText("  " +s2);
        poid.setText("  " +s3+" KG");
        dateNaissance.setText("  " +s7+ " CM");
        longueur.setText("  " +s5);


            diabcheckbox.setChecked(true);
            diabcheckbox.setEnabled(false);



            tensioncheckbox.setChecked(true);
            tensioncheckbox.setEnabled(false);
        modifier.setOnClickListener(view ->
        {
            Intent intent = new Intent(this ,Welcome.class);
            startActivity(intent);
            finish();


        });






    }
}