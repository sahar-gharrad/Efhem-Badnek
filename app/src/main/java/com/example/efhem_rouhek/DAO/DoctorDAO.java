package com.example.efhem_rouhek.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.efhem_rouhek.Entity.doctor;
import com.example.efhem_rouhek.Entity.maladie;

import java.util.List;

@Dao
public interface DoctorDAO {

    @Query("SELECT * FROM doctors")
    List<doctor> getAll();

    @Query("INSERT INTO `doctors` (`id`, `nom`, `prenom`, `photo`, `specialite`, `tel`, `adresse`) VALUES\n" +
            "(2, 'abdelmoumen', 'khaled', '@drawable/khaled', 'Generaliste', '22232313', '21,rue neplous , tunisie'),\n" +
            "(3, 'sahar ', 'gharrad', '@drawable/sahar', 'Cardiologue', '56666521', '06,rue spain , boumhal'),\n" +
            "(5, 'Rami', 'chaaleli', '@drawable/khaled', 'Dermatologue', '98563247', 'Beb Souika 1919');")
    void Insterall();

}
