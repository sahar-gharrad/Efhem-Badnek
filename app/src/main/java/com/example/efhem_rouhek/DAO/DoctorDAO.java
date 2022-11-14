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
            "(2, 'abdelmoumen', 'khaled', 'cv pic.jpg', 'Generaliste', '22232313', '21,rue neplous , tunisie'),\n" +
            "(3, 'sahar ', 'gharrad', 'profil.png', 'Cardiologue', '56666521', '06,rue spain , boumhal');")
    void Insterall();

}
