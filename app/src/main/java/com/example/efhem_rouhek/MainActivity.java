package com.example.efhem_rouhek;

import static com.example.efhem_rouhek.Welcome.PREF_NAME;
import static com.example.efhem_rouhek.Welcome.nomShared;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.efhem_rouhek.Entity.maladie;
import com.example.efhem_rouhek.Entity.symptomes;
import com.example.efhem_rouhek.database.AppDataBase;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BottomAppBar toolbar;
    private ImageView profileImg;
    private TextView name;
    private Button more1;
    private Button more2;
    private RecyclerView recyclerView;
    private CustomAdapter customAdapter;
    Button moreDoctor;

    private ImageView imageview;
    private SharedPreferences sharedpreference;
    private AppDataBase database ;
    private List<maladie> listmaladie;
    private List<symptomes> listsymp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedpreference = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        database = AppDataBase.getAppDatabase(this);
        listmaladie = database.MaladieDAO().getAll();
        listsymp = database.SymptomesDAO().getAll();
        toolbar = (BottomAppBar) findViewById(R.id.app_bar);
        profileImg = (ImageView) findViewById(R.id.imgProfile);
        moreDoctor=(Button) findViewById(R.id.btnMore2);
        name=(TextView) findViewById(R.id.txtName);


        recyclerView=(RecyclerView) findViewById(R.id.recy);
        customAdapter = new CustomAdapter(this,listmaladie);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(customAdapter);


        String s1 = sharedpreference.getString(nomShared, "");
        /*
        String uri = "@drawable/heart";  // where myresource (without the extension) is the file

        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        imageview= (ImageView)findViewById(R.id.imageMaladie);
        imageview.setImageDrawable(getResources().getDrawable(imageResource));
*/
        name.setText("Bonjour ,"+ s1);
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