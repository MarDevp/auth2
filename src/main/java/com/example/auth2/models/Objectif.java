package com.example.auth2.models;
import jakarta.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "objectif")
public class Objectif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_objectif;

    @Column(name = "libele_objectif")
    private String libele_objectif;

    @Column(name = "description_objectif")
    private String description_objectif;

    @Column(name = "id_projet")
    private int id_projet;

    @Column(name = "is_global")
    private int is_global;

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

    public int getIs_global() {
        return is_global;
    }

    public void setIs_global(int is_global) {
        this.is_global = is_global;
    }
    public Objectif() {
    }

    public Objectif(int id_objectif, String libele_objectif, String description_objectif, int id_projet, int is_global) {
        this.id_objectif = id_objectif;
        this.libele_objectif = libele_objectif;
        this.description_objectif = description_objectif;
        this.id_projet = id_projet;
        this.is_global = is_global;
    }

    @Override
    public String toString() {
        return "Objectif{" +
                "id_objectif=" + id_objectif +
                ", libele_objectif='" + libele_objectif + '\'' +
                ", description_objectif='" + description_objectif + '\'' +
                ", id_projet=" + id_projet +
                ", isGlobal='" + is_global + '\'' +
                '}';
    }
}
