package com.example.efhem_rouhek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.efhem_rouhek.database.AppDataBase;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;




public class Welcome extends AppCompatActivity {
    static final String PREF_NAME = "DATA";
    static final String nomShared = "nom";
    static final String prenomShared = "prenom";
    static final String Diabete = "diabete";
    static final String poidShared = "poid";
    static final String Tension = "tension";
    private TextInputEditText nomEdit;
    private TextInputLayout nomLayout;

    private TextInputEditText prenomEdit;
    private TextInputLayout prenomLayout;
    private TextView textView22;
    private Button Suivant;
private AppDataBase database;
    //stockage inetern
    private SharedPreferences sharedpreference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        nomEdit= findViewById(R.id.txtEmail);
        nomLayout= findViewById(R.id.txtLayoutName);
        prenomEdit= findViewById(R.id.txtPrenom);
        prenomLayout= findViewById(R.id.txtLayoutPrenom);
        Suivant= findViewById(R.id.btnSuivant);
        textView22=findViewById(R.id.textView22);
        database = AppDataBase.getAppDatabase(this);
        textView22.setText(database.SymptomesDAO().getAll().toString());
        sharedpreference = getSharedPreferences(PREF_NAME, MODE_PRIVATE);



        Suivant.setOnClickListener(view ->
        {
            nomLayout.setError(null);
            prenomLayout.setError(null);
            if (nomEdit.getText().toString().isEmpty()) {
                nomLayout.setError("nom not be empty");
                return;
            }
            if (prenomEdit.getText().toString().isEmpty()) {
                prenomLayout.setError("prenom not be empty");
                return;

            }
            // Creating an Editor object to edit(write to the file)
            SharedPreferences.Editor myEdit = sharedpreference.edit();

// Storing the key and its value as the data fetched from edittext
            myEdit.putString(nomShared, nomEdit.getText().toString());
            myEdit.putString(prenomShared, prenomEdit.getText().toString());

            // Once the changes have been made,
// we need to commit to apply those changes made,
// otherwise, it will throw an error
            myEdit.commit();
//get sharedpref
            String s1 = sharedpreference.getString(nomShared, "");
            System.out.println(s1);


            Intent intent = new Intent(this ,WelcomeTwo.class);
            startActivity(intent);


        });



    }
}