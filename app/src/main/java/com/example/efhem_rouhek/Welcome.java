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
    static final String addressShared = "address";
    static final String DiabeteShared = "diabete";
    static final String poidShared = "poid";
    static final String TensionShared = "tension";
    static final String longueurShared= "longueur";

    private TextInputEditText nomEdit;
    private TextInputLayout nomLayout;

    private TextInputEditText AddrEdit;
    private TextInputLayout AddrLayout;

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

        nomEdit= findViewById(R.id.txtNom);
        nomLayout= findViewById(R.id.txtLayoutName);
        prenomEdit= findViewById(R.id.txtPrenom);
        prenomLayout= findViewById(R.id.txtLayoutPrenom);
        Suivant= findViewById(R.id.btnSuivant);
        textView22=findViewById(R.id.textView22);
        database = AppDataBase.getAppDatabase(this);

        AddrEdit= findViewById(R.id.txtAddr);
        AddrLayout= findViewById(R.id.txtLayoutAddr);

        sharedpreference = getSharedPreferences(PREF_NAME, MODE_PRIVATE);



        Suivant.setOnClickListener(view ->
        {
            nomLayout.setError(null);
            prenomLayout.setError(null);
            AddrLayout.setError(null);
            if (nomEdit.getText().toString().isEmpty()) {
                nomLayout.setError("nom not be empty");
                return;
            }
            if (prenomEdit.getText().toString().isEmpty()) {
                prenomLayout.setError("prenom not be empty");
                return;

            }
            if (AddrEdit.getText().toString().isEmpty()) {
                AddrLayout.setError("Address not be empty");
                return;

            }
            // Creating an Editor object to edit(write to the file)
            SharedPreferences.Editor myEdit = sharedpreference.edit();

// Storing the key and its value as the data fetched from edittext
            myEdit.putString(nomShared, nomEdit.getText().toString());
            myEdit.putString(prenomShared, prenomEdit.getText().toString());
            myEdit.putString(addressShared, AddrEdit.getText().toString());
            // Once the changes have been made,
// we need to commit to apply those changes made,
// otherwise, it will throw an error
            myEdit.commit();
//get sharedpref
            String s1 = sharedpreference.getString(nomShared, "");
            System.out.println(s1);


            Intent intent = new Intent(this ,WelcomeTwo.class);
            startActivity(intent);
            finish();


        });



    }
}