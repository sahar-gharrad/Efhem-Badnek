package com.example.efhem_rouhek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

public class quiz1 extends AppCompatActivity {
 Button suivant;
 ProgressBar progressBar;
 int curentProgress=10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);



        progressBar= (ProgressBar) findViewById(R.id.progressBar);

        suivant = (Button) findViewById(R.id.suivantB);
        Intent intent = new Intent(this ,resultat.class);
        suivant.setOnClickListener(view ->
        {
            startActivity(intent);


        });

        final CountDownTimer countDownTimer=new CountDownTimer(11*1000,1000) {
            @Override
            public void onTick(long l) {

                progressBar.setProgress(curentProgress);
                progressBar.setMax(50);
            }

            @Override
            public void onFinish() {
                if(curentProgress<40) {
                    Toast.makeText(getApplicationContext(), "Il y a pas de danger",Toast.LENGTH_SHORT).show();


                } else
                if(curentProgress>40){
                    Toast.makeText(getApplicationContext(), "Veuillez consulter un medecin",Toast.LENGTH_SHORT).show();
                }
            }
        };
        countDownTimer.start();


    }
}