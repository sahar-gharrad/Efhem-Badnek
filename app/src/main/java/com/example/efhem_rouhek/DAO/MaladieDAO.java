package com.example.efhem_rouhek.DAO;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.efhem_rouhek.Entity.maladie;

import java.util.List;

@Dao
public interface MaladieDAO {



    @Query("SELECT * FROM maladie")
    List<maladie> getAll();

    @Query("INSERT INTO `maladie` (`id_maladie`, `labelle`, `id_categorie`) VALUES\n" +
            "(1, 'COVID-19', 1),\n" +
            "(2, 'Influenza (grippe)', 1),\n" +
            "(3, 'tuberculose', 1),\n" +
            "(4, 'L’eczéma\\r\\n', 2),\n" +
            "(5, 'La rosacée', 2),\n" +
            "(6, 'Le psoriasis', 2),\n" +
            "(7, 'Allergie au pollen\\r\\n', 3),\n" +
            "(8, 'Allergie alimentaire', 3),\n" +
            "(9, 'Allergie aux poils d’animaux ', 3);")
    void Insterall();
}