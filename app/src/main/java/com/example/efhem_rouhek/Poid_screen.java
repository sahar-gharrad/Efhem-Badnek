package com.example.efhem_rouhek;

import androidx.appcompat.app.AppCompatActivity;
import static com.example.efhem_rouhek.Welcome.Diabete;
import static com.example.efhem_rouhek.Welcome.PREF_NAME;
import static com.example.efhem_rouhek.Welcome.poidShared;



import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


public class Poid_screen extends AppCompatActivity {

    private Button Terminer;
    private EditText poidinput;
    private SharedPreferences sharedpreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poid_screen);


        sharedpreference = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        Terminer= findViewById(R.id.btnTerminer);
        poidinput = findViewById(R.id.poidinput);

        Terminer.setOnClickListener(view ->
        {


            // Creating an Editor object to edit(write to the file)
            SharedPreferences.Editor myEdit = sharedpreference.edit();

// Storing the key and its value as the data fetched from edittext
            myEdit.putString(poidShared, poidinput.getText().toString());
            // Once the changes have been made,
// we need to commit to apply those changes made,
// otherwise, it will throw an error
            myEdit.commit();
            String s1 = sharedpreference.getString(poidShared, "");
            System.out.println(s1);


            Intent intent = new Intent(this ,MainActivity.class);
            startActivity(intent);
            finish();


        });
    }
}