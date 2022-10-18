package com.example.efhem_rouhek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    int month =0;
    int day =0;
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

    private void showDate()  {
         year = this.datePicker.getYear();
         month = this.datePicker.getMonth(); // 0 - 11
         day = this.datePicker.getDayOfMonth();

    //    Toast.makeText(this, "Date: " + day+"-"+ (month + 1) +"-"+ year, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this ,MainActivity.class);
        startActivity(intent);
    }
}