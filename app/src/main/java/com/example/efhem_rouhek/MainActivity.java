package com.example.efhem_rouhek;

import static com.example.efhem_rouhek.Welcome.PREF_NAME;
import static com.example.efhem_rouhek.Welcome.nomShared;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
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


import com.example.efhem_rouhek.Entity.doctor;
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
private SearchView search1;
    private ImageView doctors;
    private ImageView historique;
    private ImageView home;
    private Button more1;
    private Button more2;
    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private CustomAdapter customAdapter;
    private CustomerAdapter customerAdapter2;
    Button moreDoctor;

    private ImageView imageview;
    private SharedPreferences sharedpreference;
    private AppDataBase database ;
    private List<maladie> listmaladie;
    private List<doctor> listdoctor;
    private List<symptomes> listsymp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedpreference = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        database = AppDataBase.getAppDatabase(this);
        listmaladie = database.MaladieDAO().getAll();
        listsymp = database.SymptomesDAO().getAll();
        listdoctor = database.DoctorDAO().getAll();

        toolbar = (BottomAppBar) findViewById(R.id.app_bar);
        profileImg = (ImageView) findViewById(R.id.imgProfile);
        doctors = (ImageView) findViewById(R.id.docotors);
        historique = (ImageView) findViewById(R.id.historiqueImg);
        home = (ImageView) findViewById(R.id.homeImg);
        profileImg = (ImageView) findViewById(R.id.imgProfile);

        name=(TextView) findViewById(R.id.txtName);


       





// recy categorie
        recyclerView=(RecyclerView) findViewById(R.id.recy);
        customAdapter = new CustomAdapter(this,listmaladie);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(customAdapter);

//recy doctor
        recyclerView2=(RecyclerView) findViewById(R.id.recyc);
        customerAdapter2 = new CustomerAdapter(this,listdoctor);
        LinearLayoutManager layoutManager2
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setAdapter(customerAdapter2);



        String s1 = sharedpreference.getString(nomShared, "");
        /*
        String uri = "@drawable/heart";  // where myresource (without the extension) is the file

        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        imageview= (ImageView)findViewById(R.id.imageMaladie);
        imageview.setImageDrawable(getResources().getDrawable(imageResource));
*/
        name.setText("Bonjour ,"+ s1);
        Intent intent = new Intent(this ,profile2.class);
        Intent intent2 = new Intent(this ,MainActivity.class);
        Intent intent3 = new Intent(this ,Doctors.class);
        Intent intent4 = new Intent(this ,profile2.class);
        Intent intent5 = new Intent(this ,Doctors.class);



        profileImg.setOnClickListener(view ->
        {

            startActivity(intent);

        });

       /* moreDoctor.setOnClickListener(view ->
        {

            startActivity(intent3);

        });*/





        profileImg.setOnClickListener(view ->
        {

            startActivity(intent);

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
                if (item.getItemId() == R.id.imgProfile) {


                    startActivity(intent);

                } else
                if (item.getItemId() == R.id.historiqueImg) {


                    startActivity(intent4);

                }else

                if (item.getItemId() == R.id.docotors) {


                    startActivity(intent5);

                }


                return false;
            }
        });





    }

}