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

    @Query("INSERT INTO `maladie` (`id_maladie`, `labelle`, `description`, `image`, `color`, `imagegrand`, `id_categorie`) VALUES\n" +
            "(1, 'COVID-19','erhzhz hzerhzeh z hz ','@drawable/heart','rouge','@drawable/heart', 1),\n" +
            "(2, 'Influenza (grippe)','zetztztze t ze ','@drawable/heart','bleu', '@drawable/heart', 1),\n" +
            "(3, 'tuberculose','zte z ze', '@drawable/heart','rouge','@drawable/heart', 1),\n" +
            "(4, 'L’eczéma\\r\\n','zett z','@drawable/heart','rouge','@drawable/heart',  2),\n" +
            "(5, 'La rosacée','zet z', '@drawable/heart','rouge','@drawable/heart', 2),\n" +
            "(6, 'Le psoriasis','ztzt ', '@drawable/heart','rouge','@drawable/heart', 2),\n" +
            "(7, 'Allergie au pollen\\r\\n','zetztetz ','@drawable/heart' ,'rouge','@drawable/heart', 3),\n" +
            "(8, 'Allergie alimentaire','zetzet ','@drawable/heart','rouge', '@drawable/heart', 3),\n" +
            "(9, 'Allergie aux poils d’animaux ','zetzet te tz','@drawable/heart','rouge', '@drawable/heart', 3);")
    void Insterall();
}