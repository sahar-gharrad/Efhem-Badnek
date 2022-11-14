package com.example.efhem_rouhek.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "maladie")
public class maladie {

    @PrimaryKey(autoGenerate = true)
    public int id_maladie;
    @ColumnInfo(name = "labelle")
    public String labelle;
    @ColumnInfo(name = "id_categorie")
    public int id_categorie;

    public maladie(int id_maladie, String labelle, int id_categorie) {
        this.id_maladie = id_maladie;
        this.labelle = labelle;
        this.id_categorie = id_categorie;
    }

    public maladie() {
    }

    public int getId_maladie() {
        return id_maladie;
    }

    public void setId_maladie(int id_maladie) {
        this.id_maladie = id_maladie;
    }

    public String getLabelle() {
        return labelle;
    }

    public void setLabelle(String labelle) {
        this.labelle = labelle;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    @Override
    public String toString() {
        return "maladie{" +
                "id_maladie=" + id_maladie +
                ", labelle='" + labelle + '\'' +
                ", id_categorie=" + id_categorie +
                '}';
    }
}
