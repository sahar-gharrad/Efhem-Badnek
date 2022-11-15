package com.example.efhem_rouhek;

import static com.example.efhem_rouhek.Welcome.PREF_NAME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.example.efhem_rouhek.Entity.categorie;
import com.example.efhem_rouhek.Entity.symptomes;
import com.example.efhem_rouhek.database.AppDataBase;

import java.util.ArrayList;
import java.util.List;

public class quiz1 extends AppCompatActivity {
 Button Ouibtn;
    Button NnBTN;
    private ImageView imageView;
 ProgressBar progressBar;
 int curentProgress=10;
    private SharedPreferences sharedpreference;
 String count;
 String idmaladie ;
 String nowQuestion ;
 String nameCat;
    String namemalad;
 int OuiQuest;
 private TextView countquestion ;
    private TextView avezvous ;
    private AppDataBase database;
    private List<categorie> listcategorie;
    private List<symptomes> listsymptomes;
    private List<symptomes> listsymptomesmaladie=  new ArrayList<>();
    private ImageView image;
    private String imagev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);




        database = AppDataBase.getAppDatabase(this);
        listcategorie = database.CategorieDAO().getAll();
        listsymptomes = database.SymptomesDAO().getAll();
        Bundle extras = getIntent().getExtras();
        sharedpreference = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
                count =  sharedpreference.getString("count", "");
        idmaladie =  sharedpreference.getString("idmaladi", "");
        nowQuestion =  sharedpreference.getString("nowQuestion", "");
        namemalad =  sharedpreference.getString("lab", "");
        imagev=  sharedpreference.getString("image", "");


        OuiQuest =  sharedpreference.getInt("OuiQues", 0);

            //The key argument here must match that used in the other activity


        for( int i = 0;i<listsymptomes.size();i++){
            if(listsymptomes.get(i).id_maladie == Integer.parseInt(idmaladie)){
                listsymptomesmaladie.add(listsymptomes.get(i));
            }
        }



        imageView = findViewById(R.id.imageGrand);

        String uri = imagev;  // where myresource (without the extension) is the file

        int imageResource =getResources().getIdentifier(uri, null,  getPackageName());
        imageView.setImageDrawable( getResources().getDrawable(imageResource));

        progressBar= (ProgressBar) findViewById(R.id.progressBar);

        Ouibtn = (Button) findViewById(R.id.appCompatButton7);
        NnBTN = (Button) findViewById(R.id.appCompatButton4);
        countquestion =  findViewById(R.id.textView13);
        countquestion.setText("Question "+nowQuestion+" de "+count);
        avezvous =  findViewById(R.id.textView14);
        avezvous.setText("Avez-vous "+listsymptomesmaladie.get(Integer.parseInt(nowQuestion)-1).getLabelle());

        Ouibtn.setOnClickListener(view ->
        {
            if(Integer.parseInt(nowQuestion) == listsymptomesmaladie.size()){
                SharedPreferences.Editor myEdit = sharedpreference.edit();
                myEdit.putInt("OuiQues",OuiQuest +1);
                myEdit.commit();
                Intent intent = new Intent(this ,resultat.class);

                startActivity(intent);
                finish();
            }else{
                // Creating an Editor object to edit(write to the file)
                SharedPreferences.Editor myEdit = sharedpreference.edit();

// Storing the key and its value as the data fetched from edittext
                Intent intent = new Intent(this ,quiz1.class);
                myEdit.putString("count", String.valueOf(count));
                myEdit.putString("lab", String.valueOf(namemalad));
                myEdit.putString("image", String.valueOf(imagev));
                myEdit.putString("idmaladi", idmaladie);
                myEdit.putString("nowQuestion", String.valueOf(Integer.parseInt(nowQuestion)+1));
                myEdit.putInt("OuiQues",OuiQuest +1);
                myEdit.commit();

                startActivity(intent);
                finish();
            }



        });
        NnBTN.setOnClickListener(view ->
        {
            if(Integer.parseInt(nowQuestion) == listsymptomesmaladie.size()){

            Intent intent = new Intent(this ,resultat.class);

            startActivity(intent);
            finish();
        }else{
            SharedPreferences.Editor myEdit = sharedpreference.edit();
            Intent intent = new Intent(this ,quiz1.class);
            myEdit.putString("count", String.valueOf(count));
            myEdit.putString("idmaladi", idmaladie);
            myEdit.putString("nowQuestion", String.valueOf(Integer.parseInt(nowQuestion)+1));

            myEdit.commit();

            startActivity(intent);
            finish();
        }


        });

        final CountDownTimer countDownTimer=new CountDownTimer(11*1000,1000) {
            @Override
            public void onTick(long l) {

                progressBar.setProgress(Integer.parseInt(nowQuestion));
                progressBar.setMax(Integer.parseInt(count)-1);
            }

            @Override
            public void onFinish() {
                if(curentProgress<40) {
                    //Toast.makeText(getApplicationContext(), "Il y a pas de danger",Toast.LENGTH_SHORT).show();


                } else
                if(curentProgress>40){
                    //Toast.makeText(getApplicationContext(), "Veuillez consulter un medecin",Toast.LENGTH_SHORT).show();
                }
            }
        };
        countDownTimer.start();


    }
}