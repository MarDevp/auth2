package com.example.auth2.models;

import java.sql.Date;

public class IndicateurObjectifDTO {

        private int id_indicateur;
        private String libele_indicateur;
        private String description_indicateur;
        private String format_indicateur;
        private String tendance_souhaite_hausse;
        private Date date_prevu_realisation_indicateur;
        private String moyen_verification_indicateur;
        private String unite_mes_indicateur;
        private String valeur_cible_indicateur;
        private String valeur_initiale_indicateur;
        private int objres;
        private int id_objres;
        private String libele_objectif;

        // constructors, getters, and setters

    public IndicateurObjectifDTO()
    {

    }

    public IndicateurObjectifDTO(int id_indicateur, String libele_indicateur, String description_indicateur, String format_indicateur, String tendance_souhaite_hausse, Date date_prevu_realisation_indicateur, String moyen_verification_indicateur, String unite_mes_indicateur, String valeur_cible_indicateur, String valeur_initiale_indicateur, int objres, int id_objres, String libele_objectif) {
        this.id_indicateur = id_indicateur;
        this.libele_indicateur = libele_indicateur;
        this.description_indicateur = description_indicateur;
        this.format_indicateur = format_indicateur;
        this.tendance_souhaite_hausse = tendance_souhaite_hausse;
        this.date_prevu_realisation_indicateur = date_prevu_realisation_indicateur;
        this.moyen_verification_indicateur = moyen_verification_indicateur;
        this.unite_mes_indicateur = unite_mes_indicateur;
        this.valeur_cible_indicateur = valeur_cible_indicateur;
        this.valeur_initiale_indicateur = valeur_initiale_indicateur;
        this.objres = objres;
        this.id_objres = id_objres;
        this.libele_objectif = libele_objectif;
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

    public String getTendance_souhaite_hausse() {
        return tendance_souhaite_hausse;
    }

    public void setTendance_souhaite_hausse(String tendance_souhaite_hausse) {
        this.tendance_souhaite_hausse = tendance_souhaite_hausse;
    }

    public Date getDate_prevu_realisation_indicateur() {
        return date_prevu_realisation_indicateur;
    }

    public void setDate_prevu_realisation_indicateur(Date date_prevu_realisation_indicateur) {
        this.date_prevu_realisation_indicateur = date_prevu_realisation_indicateur;
    }

    public String getMoyen_verification_indicateur() {
        return moyen_verification_indicateur;
    }

    public void setMoyen_verification_indicateur(String moyen_verification_indicateur) {
        this.moyen_verification_indicateur = moyen_verification_indicateur;
    }

    public String getUnite_mes_indicateur() {
        return unite_mes_indicateur;
    }

    public void setUnite_mes_indicateur(String unite_mes_indicateur) {
        this.unite_mes_indicateur = unite_mes_indicateur;
    }

    public String getValeur_cible_indicateur() {
        return valeur_cible_indicateur;
    }

    public void setValeur_cible_indicateur(String valeur_cible_indicateur) {
        this.valeur_cible_indicateur = valeur_cible_indicateur;
    }

    public String getValeur_initiale_indicateur() {
        return valeur_initiale_indicateur;
    }

    public void setValeur_initiale_indicateur(String valeur_initiale_indicateur) {
        this.valeur_initiale_indicateur = valeur_initiale_indicateur;
    }

    public int getObjres() {
        return objres;
    }

    public void setObjres(int objres) {
        this.objres = objres;
    }

    public int getId_objres() {
        return id_objres;
    }

    public void setId_objres(int id_objres) {
        this.id_objres = id_objres;
    }

    public String getLibele_objectif() {
        return libele_objectif;
    }

    public void setLibele_objectif(String libele_objectif) {
        this.libele_objectif = libele_objectif;
    }
}


