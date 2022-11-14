package com.example.efhem_rouhek.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.efhem_rouhek.Entity.categorie;

import java.util.List;

@Dao

public interface CategorieDAO {

    @Query("SELECT * FROM categorie")
    List<categorie> getAll();


    @Query("INSERT INTO `categorie` (`id_categorie`, `labelle`) VALUES\n" +
            "(1, 'Maladie infectieuse'),\n" +
            "(2, 'Maladies de peau'),\n" +
            "(3, 'Allergies');")
    void Insterall();
}
