package com.example.efhem_rouhek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class resultat extends AppCompatActivity {

        private ProgressBar progressBar;
        private int curentProgress=70;
        Button more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        progressBar=(ProgressBar)findViewById(R.id.progressBar2);
        more=(Button) findViewById(R.id.btnmMore);

        final CountDownTimer countDownTimer=new CountDownTimer(11*1000,1000) {
            @Override
            public void onTick(long l) {

                progressBar.setProgress(curentProgress);
                progressBar.setMax(100);
            }

            @Override
            public void onFinish() {
                if(curentProgress<40) {
                    Toast.makeText(getApplicationContext(), "Il y a pas de danger",Toast.LENGTH_SHORT);

                } else
                    if(curentProgress>40){
                        Toast.makeText(getApplicationContext(), "Veuillez consulter un medecin",Toast.LENGTH_SHORT);
                    }
            }
        };

        Intent intent = new Intent(this ,Doctors.class);
        more.setOnClickListener(view ->
        {
            startActivity(intent);


        });
        countDownTimer.start();



    }
}