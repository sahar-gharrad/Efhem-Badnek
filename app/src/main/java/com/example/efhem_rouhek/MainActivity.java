package com.example.efhem_rouhek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;


import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private BottomAppBar toolbar;
    private ImageView profileImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        toolbar = (BottomAppBar) findViewById(R.id.app_bar);
        profileImg = (ImageView) findViewById(R.id.imgProfile);


        Intent intent = new Intent(this ,profile2.class);

        profileImg.setOnClickListener(view ->
        {

            startActivity(intent);

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