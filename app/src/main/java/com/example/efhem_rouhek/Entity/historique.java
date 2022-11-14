package com.example.efhem_rouhek.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "histoques")
public class historique {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "id_u")
    public int id_u ;
    @ColumnInfo(name = "date")
    public Date date;
    @ColumnInfo(name = "diagnostique_res")
    public String diagnostique_res ;

    public historique() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getDiagnostique_res() {
        return diagnostique_res;
    }

    public void setDiagnostique_res(String diagnostique_res) {
        this.diagnostique_res = diagnostique_res;
    }

    public int getId_u() {
        return id_u;
    }

    public void setId_u(int id_u) {
        this.id_u = id_u;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "historique{" +
                "id=" + id +
                ", id_u='" + id_u + '\'' +
                ", date='" + date + '\'' +
                ", diagnostique_res='" + diagnostique_res + '\'' +
                '}';
    }
}
