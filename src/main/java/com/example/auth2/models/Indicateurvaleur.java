package com.example.auth2.models;

import jakarta.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "indicateurvaleur")
public class Indicateurvaleur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_valeur;

    @Column(name = "id_indicateur")
    private int id_indicateur;

    @Column(name = "valeur_indicateur")
    private double valeur_indicateur;

    @Column(name = "date_saisie")
    private Date date_saisie;


    public Indicateurvaleur()
    {

    }

    public Indicateurvaleur(int id_indicateur, double valeur_indicateur, Date date_saisie) {
        this.id_indicateur = id_indicateur;
        this.valeur_indicateur = valeur_indicateur;
        this.date_saisie = date_saisie;
    }

    public int getId_valeur() {
        return id_valeur;
    }

    public void setId_valeur(int id_valeur) {
        this.id_valeur = id_valeur;
    }

    public int getId_indicateur() {
        return id_indicateur;
    }

    public void setId_indicateur(int id_indicateur) {
        this.id_indicateur = id_indicateur;
    }

    public double getValeur_indicateur() {
        return valeur_indicateur;
    }

    public void setValeur_indicateur(double valeur_indicateur) {
        this.valeur_indicateur = valeur_indicateur;
    }

    public Date getDate_saisie() {
        return date_saisie;
    }

    public void setDate_saisie(Date date_saisie) {
        this.date_saisie = date_saisie;
    }

    @Override
    public String toString() {
        return "Indicateurvaleur{" +
                "id_valeur=" + id_valeur +
                ", id_indicateur=" + id_indicateur +
                ", valeur_indicateur=" + valeur_indicateur +
                ", date_saisie=" + date_saisie +
                '}';
    }
}
