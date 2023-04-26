package com.example.auth2.models;

import jakarta.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "resultat")

public class Resultat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_resultat;

    @Column(name = "libele_resultat")
    private String libele_resultat;

    @Column(name = "description_resultat")
    private String description_resultat;

    @Column(name = "id_objectif")
    private int id_objectif;

    public Resultat()
    {

    }

    public Resultat( String libele_resultat, String description_resultat, int id_objectif) {
        //this.id_resultat = id_resultat;
        this.libele_resultat = libele_resultat;
        this.description_resultat = description_resultat;
        this.id_objectif = id_objectif;
    }

    public int getId_resultat() {
        return id_resultat;
    }

    public void setId_resultat(int id_resultat) {
        this.id_resultat = id_resultat;
    }

    public String getLibele_resultat() {
        return libele_resultat;
    }

    public void setLibele_resultat(String libele_resultat) {
        this.libele_resultat = libele_resultat;
    }

    public String getDescription_resultat() {
        return description_resultat;
    }

    public void setDescription_resultat(String description_resultat) {
        this.description_resultat = description_resultat;
    }

    public int getId_objectif() {
        return id_objectif;
    }

    public void setId_objectif(int id_objectif) {
        this.id_objectif = id_objectif;
    }


    @Override
    public String toString() {
        return "Resultat{" +
                "id_resultat=" + id_resultat +
                ", libele_resultat='" + libele_resultat + '\'' +
                ", description_resultat='" + description_resultat + '\'' +
                ", id_objectif=" + id_objectif +
                '}';
    }
}
