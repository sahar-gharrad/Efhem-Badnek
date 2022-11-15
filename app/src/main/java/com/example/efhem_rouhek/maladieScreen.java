package com.example.efhem_rouhek;

import static com.example.efhem_rouhek.Welcome.PREF_NAME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.efhem_rouhek.Entity.categorie;
import com.example.efhem_rouhek.Entity.maladie;
import com.example.efhem_rouhek.Entity.symptomes;
import com.example.efhem_rouhek.database.AppDataBase;

import java.util.List;

public class maladieScreen extends AppCompatActivity {

    Button test;
    String id;
    String lab;
    String cat;
    String desc;
    String image;
    String nameCat;
    String nameMalade;
    int count ;
    private ImageView imageView;

    private TextView textview;
    private TextView name;
    private TextView textCount;
    private TextView textCat;
    private AppDataBase database;
    private List<categorie> listcategorie;
    private List<symptomes> listsymptomes;
    private SharedPreferences sharedpreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maladie);
        Bundle extras = getIntent().getExtras();
        database = AppDataBase.getAppDatabase(this);
        listcategorie = database.CategorieDAO().getAll();
        listsymptomes = database.SymptomesDAO().getAll();

        if (extras != null) {
             id = extras.getString("id");
            lab = extras.getString("lab");
            cat = extras.getString("cat");
            desc = extras.getString("desc");
            image = extras.getString("image");
            nameMalade=extras.getString("lab");
            //The key argument here must match that used in the other activity
        }

System.out.println(cat);

        for(int z =0 ;z<listcategorie.size();z++){
            System.out.println( listcategorie.get(z).getId_categorie());

            if(listcategorie.get(z).getId_categorie() == Integer.parseInt(cat)){
                nameCat = listcategorie.get(z).getLabelle();
            }
        }
        for( int i = 0;i<listsymptomes.size();i++){
            if(listsymptomes.get(i).id_maladie == Integer.parseInt(id)){
                count++;
            }
        }

        System.out.println(nameCat);
        Intent intent = new Intent(this ,quiz1.class);
        test= findViewById(R.id.faireTest);
        textCount= findViewById(R.id.textView8);
        textCount.setText(String.valueOf(count) );

        name= findViewById(R.id.textView17);
        name.setText(String.valueOf(nameMalade));

        imageView = findViewById(R.id.imageGrand);

                textCat = findViewById(R.id.textView19);
                textCat.setText(nameCat);
        textview = findViewById(R.id.textView18);
        textview.setText(desc);
        String uri = image;  // where myresource (without the extension) is the file

        int imageResource =getResources().getIdentifier(uri, null,  getPackageName());
        imageView.setImageDrawable( getResources().getDrawable(imageResource));
        sharedpreference = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        test.setOnClickListener(view ->
                {
                    SharedPreferences.Editor myEdit = sharedpreference.edit();
                    myEdit.putString("image", String.valueOf(image));
                    myEdit.putString("count", String.valueOf(count));
                    myEdit.putString("idmaladi", id);
                    myEdit.putString("nowQuestion", String.valueOf(1));
                    myEdit.putString("nameCat", String.valueOf(nameCat));
                    myEdit.putString("lab", String.valueOf(nameMalade));


                    myEdit.putInt("OuiQues",0);
                    myEdit.commit();






                    startActivity(intent);

                });



    }
}