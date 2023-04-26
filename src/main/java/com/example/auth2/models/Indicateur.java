package com.example.auth2.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "indicateur")
public class Indicateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_indicateur ;

    @Column(name = "libele_indicateur")
    private String libele_indicateur;

    @Column(name = "description_indicateur")
    private String description_indicateur;

    @Column(name = "format_indicateur")
    private String format_indicateur;

    @Column(name = "unite_mes_indicateur")
    private String unite_mes_indicateur;

    @Column(name = "valeur_initiale_indicateur")
    private double valeur_initiale_indicateur;

    @Column(name = "valeur_cible_indicateur")
    private double valeur_cible_indicateur;

    @Column(name = "date_prevu_realisation_indicateur")
    private Date date_prevu_realisation_indicateur;

    @Column(name = "tendance_souhaite_hausse")
    private int tendance_souhaite_hausse;

    @Column(name = "moyen_verification_indicateur")
    private String moyen_verification_indicateur;

    @Column(name = "objres")
    private int objres;

    @Column(name = "id_objres")
    private int id_objres;


    public Indicateur( int id_indicateur, String libele_indicateur, String description_indicateur, String format_indicateur, String unite_mes_indicateur, double valeur_initiale_indicateur, double valeur_cible_indicateur, Date date_prevu_realisation_indicateur, int tendance_souhaite_hausse, String moyen_verification_indicateur, int objres , int id_objres) {

        this.id_indicateur=id_indicateur;
        this.libele_indicateur = libele_indicateur;
        this.description_indicateur = description_indicateur;
        this.format_indicateur = format_indicateur;
        this.unite_mes_indicateur = unite_mes_indicateur;
        this.valeur_initiale_indicateur = valeur_initiale_indicateur;
        this.valeur_cible_indicateur = valeur_cible_indicateur;
        this.date_prevu_realisation_indicateur = date_prevu_realisation_indicateur;
        this.tendance_souhaite_hausse = tendance_souhaite_hausse;
        this.moyen_verification_indicateur = moyen_verification_indicateur;
        this.objres=objres;

    }

    public Indicateur()
    {

    }

    public int getObjres() {
        return objres;
    }

    public void setObjres(int objres) {
        this.objres = objres;
    }

    public int getId_indicateur() {
        return id_indicateur;
    }

    public void setId_indicateur(int id_indicateur) {
        this.id_indicateur = id_indicateur;
    }

    public String getLibele_indicateur() {
        return libele_indicateur;
    }

    public void setLibele_indicateur(String libele_indicateur) {
        this.libele_indicateur = libele_indicateur;
    }

    public String getDescription_indicateur() {
        return description_indicateur;
    }

    public void setDescription_indicateur(String description_indicateur) {
        this.description_indicateur = description_indicateur;
    }

    public String getFormat_indicateur() {
        return format_indicateur;
    }

    public void setFormat_indicateur(String format_indicateur) {
        this.format_indicateur = format_indicateur;
    }

    public String getUnite_mes_indicateur() {
        return unite_mes_indicateur;
    }

    public void setUnite_mes_indicateur(String unite_mes_indicateur) {
        this.unite_mes_indicateur = unite_mes_indicateur;
    }

    public double getValeur_initiale_indicateur() {
        return valeur_initiale_indicateur;
    }

    public void setValeur_initiale_indicateur(double valeurInitiale_indicateur) {
        this.valeur_initiale_indicateur = valeurInitiale_indicateur;
    }

    public double getValeur_cible_indicateur() {
        return valeur_cible_indicateur;
    }

    public void setValeur_cible_indicateur(double valeurCible_indicateur) {
        this.valeur_cible_indicateur = valeurCible_indicateur;
    }

    public Date getDate_prevu_realisation_indicateur() {
        return date_prevu_realisation_indicateur;
    }

    public void setDate_prevu_realisation_indicateur(Date datePrevuRealisation_indicateur) {
        this.date_prevu_realisation_indicateur = datePrevuRealisation_indicateur;
    }

    public int getTendance_souhaite_hausse() {
        return tendance_souhaite_hausse;
    }

    public void setTendance_souhaite_hausse(int tendance_souhaite_hausse) {
        this.tendance_souhaite_hausse = tendance_souhaite_hausse;
    }

    public String getMoyen_verification_indicateur() {
        return moyen_verification_indicateur;
    }

    public void setMoyen_verification_indicateur(String moyenVerification_indicateur) {
        this.moyen_verification_indicateur = moyenVerification_indicateur;
    }


    public int getId_objres() {
        return id_objres;
    }

    public void setId_objres(int id_objres) {
        this.id_objres = id_objres;
    }

    @Override
    public String toString() {
        return "Indicateur{" +
                "id_indicateur=" + id_indicateur +
                ", libele_indicateur='" + libele_indicateur + '\'' +
                ", description_indicateur='" + description_indicateur + '\'' +
                ", format_indicateur='" + format_indicateur + '\'' +
                ", uniteMes_indicateur='" + unite_mes_indicateur + '\'' +
                ", valeurInitiale_indicateur=" + valeur_initiale_indicateur +
                ", valeurCible_indicateur=" + valeur_cible_indicateur +
                ", datePrevuRealisation_indicateur=" + date_prevu_realisation_indicateur +
                ", tendance_souhaite_hausse=" + tendance_souhaite_hausse +
                ", moyenVerification_indicateur='" + moyen_verification_indicateur + '\'' +
                '}';
    }
}
