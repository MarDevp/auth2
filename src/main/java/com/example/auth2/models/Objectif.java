package com.example.auth2.models;
import jakarta.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "objectif")
public class Objectif {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_objectif;

    @Column(name = "libele_objectif")
    private String libele_objectif;

    @Column(name = "description_objectif")
    private String description_objectif;

    @Column(name = "id_projet")
    private int id_projet;

    @Column(name = "nature_objectif")
    private String nature_objectif;

    public int getId_objectif() {
        return id_objectif;
    }

    public void setId_objectif(int id_objectif) {
        this.id_objectif = id_objectif;
    }

    public String getLibele_objectif() {
        return libele_objectif;
    }

    public void setLibele_objectif(String libele_objectif) {
        this.libele_objectif = libele_objectif;
    }

    public String getDescription_objectif() {
        return description_objectif;
    }

    public void setDescription_objectif(String description_objectif) {
        this.description_objectif = description_objectif;
    }

    public int getId_projet() {
        return id_projet;
    }

    public void setId_projet(int id_projet) {
        this.id_projet = id_projet;
    }

    public String getNature_objectif() {
        return nature_objectif;
    }

    public void setNature_objectif(String nature_objectif) {
        this.nature_objectif = nature_objectif;
    }
    public Objectif() {
    }

    public Objectif(int id_objectif, String libele_objectif, String description_objectif, int id_projet, String nature_objectif) {
        this.id_objectif = id_objectif;
        this.libele_objectif = libele_objectif;
        this.description_objectif = description_objectif;
        this.id_projet = id_projet;
        this.nature_objectif = nature_objectif;
    }

    @Override
    public String toString() {
        return "Objectif{" +
                "id_objectif=" + id_objectif +
                ", libele_objectif='" + libele_objectif + '\'' +
                ", description_objectif='" + description_objectif + '\'' +
                ", id_projet=" + id_projet +
                ", nature_objectif='" + nature_objectif + '\'' +
                '}';
    }
}
