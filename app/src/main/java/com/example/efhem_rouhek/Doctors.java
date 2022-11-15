package com.example.efhem_rouhek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.efhem_rouhek.database.AppDataBase;
import com.google.android.material.bottomappbar.BottomAppBar;

public class Doctors extends AppCompatActivity {
    private BottomAppBar toolbar;
    private ImageView profileImg;
    private ImageView doctors;
    private ImageView historique;
    private ImageView home;


    String nom;
    String loc;
    String spec;
    String image;
    private ImageView imageView;
    private TextView nomtv;
    private TextView loctv;
    private TextView spectv;
    private AppDataBase database;

    private SharedPreferences sharedpreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors);

        toolbar = (BottomAppBar) findViewById(R.id.app_bar);
        profileImg = (ImageView) findViewById(R.id.imgProfile);
        doctors = (ImageView) findViewById(R.id.docotors);
        historique = (ImageView) findViewById(R.id.historiqueImg);
        home = (ImageView) findViewById(R.id.homeImg);
        Intent intent1 = new Intent(this ,profile2.class);
        Intent intent2 = new Intent(this ,MainActivity.class);

        Intent intent4 = new Intent(this ,profile2.class);
        Intent intent5 = new Intent(this ,Doctors.class);



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



        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            image = extras.getString("image");
            nom = extras.getString("nom");
            spec = extras.getString("spec");
            loc = extras.getString("loc");


            //The key argument here must match that used in the other activity
        }

        nomtv= findViewById(R.id.textView4);
        spectv= findViewById(R.id.textView5);
        loctv= findViewById(R.id.textview6);

        imageView=findViewById(R.id.imgview);

        nomtv.setText(nom);
        spectv.setText(spec);
        loctv.setText(loc);
        String uri = image;
        int imageResource =getResources().getIdentifier(uri, null,  getPackageName());
        imageView.setImageDrawable( getResources().getDrawable(imageResource));





    }
}