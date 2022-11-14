package com.example.efhem_rouhek.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "categorie")
public class categorie {
    @PrimaryKey(autoGenerate = true)
    public int id_categorie;
    @ColumnInfo(name = "labelle")
    public String labelle;

    @Override
    public String toString() {
        return "categorie{" +
                "id_categorie=" + id_categorie +
                ", labelle='" + labelle + '\'' +
                '}';
    }

    public categorie() {
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getLabelle() {
        return labelle;
    }

    public void setLabelle(String labelle) {
        this.labelle = labelle;
    }
}
