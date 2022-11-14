package com.example.efhem_rouhek;

import static com.example.efhem_rouhek.Welcome.PREF_NAME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class resultat extends AppCompatActivity {

    private TextView resultfinish;
        private ProgressBar progressBar;
        private int curentProgress=70;
        Button more;
    private SharedPreferences sharedpreference;
    String count;
    int OuiQuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        sharedpreference = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        OuiQuest =  sharedpreference.getInt("OuiQues", 0);
        count =  sharedpreference.getString("count", "");
        curentProgress = (OuiQuest/Integer.parseInt(count)) *100;
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

        resultfinish =  findViewById(R.id.result);
        resultfinish.setText(String.valueOf(OuiQuest)+"/"+count);
        Intent intent = new Intent(this ,Doctors.class);
        more.setOnClickListener(view ->
        {
            startActivity(intent);


        });
        countDownTimer.start();



    }
}