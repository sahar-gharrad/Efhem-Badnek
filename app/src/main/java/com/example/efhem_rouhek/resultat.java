package com.example.efhem_rouhek;

import static com.example.efhem_rouhek.Welcome.PREF_NAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.efhem_rouhek.Entity.doctor;
import com.example.efhem_rouhek.database.AppDataBase;
import com.google.android.material.bottomappbar.BottomAppBar;

import org.w3c.dom.Text;

import java.util.List;

public class resultat extends AppCompatActivity {
    private AppDataBase database ;

    private RecyclerView recyclerView2;

    private CustomerAdapter customerAdapter2;
    private TextView resultfinish;
    private TextView resultfinish1;
    private TextView title;
    private List<doctor> listdoctor;
    private ImageView profileImg;
    private ImageView doctors;
    private ImageView historique;
    private ImageView home;

    private BottomAppBar toolbar;

        private ProgressBar progressBar;
        private int curentProgress;

        Button more;
    private SharedPreferences sharedpreference;
    String count;
    String nameMalade;
    int OuiQuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        sharedpreference = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        OuiQuest =  sharedpreference.getInt("OuiQues", 0);
        nameMalade =  sharedpreference.getString("lab", "");
        count =  sharedpreference.getString("count", "");
        curentProgress = (OuiQuest/Integer.parseInt(count)) *100;


        toolbar = (BottomAppBar) findViewById(R.id.app_bar);





        database = AppDataBase.getAppDatabase(this);
        listdoctor = database.DoctorDAO().getAll();
        recyclerView2=(RecyclerView) findViewById(R.id.recyc);
        customerAdapter2 = new CustomerAdapter(this,listdoctor);
        LinearLayoutManager layoutManager2
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setAdapter(customerAdapter2);






        progressBar=(ProgressBar)findViewById(R.id.progressBar2);


        final CountDownTimer countDownTimer=new CountDownTimer(11*1000,1000) {
            @Override
            public void onTick(long l) {

                progressBar.setProgress(OuiQuest);
                progressBar.setMax(Integer.parseInt(count));
            }

            @Override
            public void onFinish() {

            }
        };

        resultfinish =  findViewById(R.id.result);
        resultfinish.setText(String.valueOf(OuiQuest)+"/"+count);

        title =  findViewById(R.id.title1);
        title.setText(String.valueOf(nameMalade)+" test");

        resultfinish1 =  findViewById(R.id.textView16);
        resultfinish1.setText("Vous avez "+String.valueOf(OuiQuest)+" symptomes sur "+count);

        title =  findViewById(R.id.title1);


        countDownTimer.start();


        Intent intent1 = new Intent(this ,profile2.class);
        Intent intent2 = new Intent(this ,MainActivity.class);

        Intent intent4 = new Intent(this ,profile2.class);
        Intent intent5 = new Intent(this ,Doctors.class);

        profileImg = (ImageView) findViewById(R.id.imgProfile);
        doctors = (ImageView) findViewById(R.id.docotors);
        historique = (ImageView) findViewById(R.id.historiqueImg);
        home = (ImageView) findViewById(R.id.homeImg);

        profileImg.setOnClickListener(view ->
        {

            startActivity(intent1);

        });

        doctors.setOnClickListener(view ->
        {

            startActivity(intent5);

        });

        historique.setOnClickListener(view ->
        {

            startActivity(intent4);

        });

        home.setOnClickListener(view ->
        {

            startActivity(intent2);

        });


        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.homeImg) {


                    startActivity(intent2);

                } else
                if (item.getItemId() == R.id.imgProfile) {


                    startActivity(intent1);

                }
                else
                if (item.getItemId() == R.id.historiqueImg) {


                    startActivity(intent4);

                }
                else
                if (item.getItemId() == R.id.docotors) {


                    startActivity(intent5);

                }

                return false;
            }
        });

    }
}