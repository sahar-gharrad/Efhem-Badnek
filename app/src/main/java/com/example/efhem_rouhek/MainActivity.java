package com.example.efhem_rouhek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;


import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private BottomAppBar toolbar;
    private ImageView profileImg;

    private Button more1;
    private Button more2;
    private Button more3;
    Button moreDoctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        toolbar = (BottomAppBar) findViewById(R.id.app_bar);
        profileImg = (ImageView) findViewById(R.id.imgProfile);
        moreDoctor=(Button) findViewById(R.id.btnMore2);

        more1=(Button) findViewById(R.id.more3);

        Intent intent = new Intent(this ,profile2.class);
        Intent intent2 = new Intent(this ,Covid.class);
        Intent intent3 = new Intent(this ,Doctors.class);


        profileImg.setOnClickListener(view ->
        {

            startActivity(intent);

        });

        moreDoctor.setOnClickListener(view ->
        {

            startActivity(intent3);

        });

        more1.setOnClickListener(view ->
        {

            startActivity(intent2);

        });



            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.imgProfile) {


                    startActivity(intent);

                }

                return false;
            }
        });
    }
}