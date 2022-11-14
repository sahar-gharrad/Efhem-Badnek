package com.example.efhem_rouhek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class WelcomeTwo extends AppCompatActivity {

    private DatePicker datePicker;
    int year = 0;
    private SharedPreferences sharedpreference;
    int month =0;
    int day =0;
    static final String PREF_NAME = "DATA";
    static final String DataShared = "date";
    private Button Suivant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_two);

        this.datePicker = (DatePicker) this.findViewById(R.id.datePicker);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
         year = calendar.get(Calendar.YEAR);
        month  = calendar.get(Calendar.MONTH);
         day = calendar.get(Calendar.DAY_OF_MONTH);
        sharedpreference = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        this.datePicker.init( year, month , day , new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
                datePickerChange(  datePicker,   year,   month,   dayOfMonth);
            }
        });
        Suivant= findViewById(R.id.btnSuivant);
        Suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDate();
            }
        });
    }
    private void datePickerChange(DatePicker datePicker, int year, int month, int dayOfMonth) {
        Log.d("Date", "Year=" + year + " Month=" + (month + 1) + " day=" + dayOfMonth);

    }
    //anlflaef

    private void showDate()  {
         year = this.datePicker.getYear();
         month = this.datePicker.getMonth(); // 0 - 11
         day = this.datePicker.getDayOfMonth();
        SharedPreferences.Editor myEdit = sharedpreference.edit();

// Storing the key and its value as the data fetched from edittext
        myEdit.putString(DataShared, day+"/"+ (month + 1) +"/"+ year);

        // Once the changes have been made,
// we need to commit to apply those changes made,
// otherwise, it will throw an error
        myEdit.commit();
    //    Toast.makeText(this, "Date: " + day+"-"+ (month + 1) +"-"+ year, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this ,DiabetScreen.class);
        startActivity(intent);
    }
}