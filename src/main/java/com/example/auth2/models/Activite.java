package com.example.auth2.models;
import jakarta.persistence.*;


@Entity
@Table(name = "activite")
public class Activite {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_activite;

    @Column(name = "libele_activite")
    private String libele_activite;

    @Column(name = "description_activite")
    private String description_activite;

    @Column(name = "id_resultat")
    private int id_resultat;

    public Activite( String libele_activite, String description_activite, int id_resultat) {

        this.libele_activite = libele_activite;
        this.description_activite = description_activite;
        this.id_resultat = id_resultat;
    }

    public Activite()
    {

    }

    public int getId_activite() {
        return id_activite;
    }

    public void setId_activite(int id_activite) {
        this.id_activite = id_activite;
    }

    public String getLibele_activite() {
        return libele_activite;
    }

    public void setLibele_activite(String libele_activite) {
        this.libele_activite = libele_activite;
    }

    public String getDescription_activite() {
        return description_activite;
    }

    public void setDescription_activite(String description_activite) {
        this.description_activite = description_activite;
    }

    public int getId_resultat() {
        return id_resultat;
    }

    public void setId_resultat(int id_resultat) {
        this.id_resultat = id_resultat;
    }
}
