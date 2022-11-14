package com.example.efhem_rouhek.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "doctors")
public class doctor {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "nom")
    public String nom ;
    @ColumnInfo(name = "prenom")
    public String prenom;
    @ColumnInfo(name = "adresse")
    public String adresse ;
    @ColumnInfo(name = "tel")
    public String tel;
    @ColumnInfo(name = "photo")
    public String photo;
    @ColumnInfo(name = "specialite")
    public String specialite;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "doctor{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", tel='" + tel + '\'' +
                ", photo='" + photo + '\'' +
                ", specialite='" + specialite + '\'' +
                '}';
    }

    public doctor() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
