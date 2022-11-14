package com.example.efhem_rouhek.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "utilisateur")
public class utilisateur {


    public int id;
    @ColumnInfo(name = "nom")
    public String nom;
    @ColumnInfo(name = "prenom")
    public String prenom;
    @ColumnInfo(name = "adresse")
    public String adresse;
    @ColumnInfo(name = "email")
    public String email;
    @ColumnInfo(name = "telephone")
    public String telephone;


    @ColumnInfo(name = "photo")
    public String photo;
    @ColumnInfo(name = "diabetique")
    public int diabetique;
    @ColumnInfo(name = "tension")
    public int tension;

    public int getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getDiabetique() {
        return diabetique;
    }

    public void setDiabetique(int diabetique) {
        this.diabetique = diabetique;
    }

    public int getTension() {
        return tension;
    }

    public void setTension(int tension) {
        this.tension = tension;
    }

    public utilisateur(int id, String nom, String prenom, String adresse, String email, String telephone, String photo, int diabetique, int tension) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
        this.photo = photo;
        this.diabetique = diabetique;
        this.tension = tension;
    }

    public utilisateur() {
    }

    @Override
    public String toString() {
        return "utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", photo='" + photo + '\'' +
                ", diabetique=" + diabetique +
                ", tension=" + tension +
                '}';
    }

}
