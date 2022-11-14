package com.example.efhem_rouhek.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "symptomes")
public class symptomes {
    @PrimaryKey(autoGenerate = true)
    public int id_symptome;
    @ColumnInfo(name = "labelle")
    public String labelle;
    @ColumnInfo(name = "id_maladie")
    public int id_maladie;
    @ColumnInfo(name = "degre_symp")
    public int degre_symp;


    public int getId_symptome() {
        return id_symptome;
    }

    public String getLabelle() {
        return labelle;
    }

    public int getId_maladie() {
        return id_maladie;
    }

    public int getDegre_symp() {
        return degre_symp;
    }

    public void setId_symptome(int id_symptome) {
        this.id_symptome = id_symptome;
    }

    public void setLabelle(String labelle) {
        this.labelle = labelle;
    }

    public void setId_maladie(int id_maladie) {
        this.id_maladie = id_maladie;
    }

    public void setDegre_symp(int degre_symp) {
        this.degre_symp = degre_symp;
    }

    public symptomes(int id_symptome, String labelle, int id_maladie, int degre_symp) {
        this.id_symptome = id_symptome;
        this.labelle = labelle;
        this.id_maladie = id_maladie;
        this.degre_symp = degre_symp;
    }

    @Override
    public String toString() {
        return "symptomes{" +
                "id_symptome=" + id_symptome +
                ", labelle='" + labelle + '\'' +
                ", id_maladie=" + id_maladie +
                ", degre_symp=" + degre_symp +
                '}';
    }
}
