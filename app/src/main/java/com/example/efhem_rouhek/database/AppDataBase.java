package com.example.efhem_rouhek.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.efhem_rouhek.DAO.DoctorDAO;
import com.example.efhem_rouhek.DAO.MaladieDAO;
import com.example.efhem_rouhek.DAO.SymptomeDAO;
import com.example.efhem_rouhek.Entity.doctor;
import com.example.efhem_rouhek.Entity.maladie;
import com.example.efhem_rouhek.Entity.symptomes;

@Database(entities = {symptomes.class, maladie.class, doctor.class}, version = 2, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase instance;
    public abstract MaladieDAO MaladieDAO();
    public abstract SymptomeDAO SymptomesDAO();
    public abstract DoctorDAO DoctorDAO();

    public static AppDataBase getAppDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "room_test_db")

                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return instance;
    }

}
