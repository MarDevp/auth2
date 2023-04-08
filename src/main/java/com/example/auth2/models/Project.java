package com.example.auth2.models;

import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_projet;

    @Column(name = "code_projet")
    private String code_projet;

    @Column(name = "intitule_projet")
    private String intitule_projet;

    @Column(name = "description_projet")
    private String description_projet;

    @Column(name = "dateDeb_projet")
    private Date dateDeb_projet;


    @Column(name = "dateFin_projet")
    private Date dateFin_projet;


    @Column(name = "statut_projet")
    private String statut_projet;

    @Column( name = "id_theme_projet")
    private int id_theme_projet;



    @Column(name = "maitre_oeuvre")
    private String maitre_oeuvre;

    @Column(name = "maitre_ouvrage")
    private String maitre_ouvrage;


    @Column( name = "monnaie_projet")
    private double monnaie_projet;


    @Column(name = "taux_rent_eco")
    private double taux_rent_eco;

    @Column(name = "cout_total")
    private double cout_total;


    @Column( name = "taux_rent_interneInit")
    private double taux_rent_interneInit;

    @Column(name = "observations")
    private String observations;

    @Column(name = "secteur")
    private String secteur;

    @Column(name = "stade")
    private String stade;


    public String getMaitre_oeuvre() {
        return maitre_oeuvre;
    }

    public void setMaitre_oeuvre(String maitre_oeuvre) {
        this.maitre_oeuvre = maitre_oeuvre;
    }

    public String getMaitre_ouvrage() {
        return maitre_ouvrage;
    }

    public void setMaitre_ouvrage(String maitre_ouvrage) {
        this.maitre_ouvrage = maitre_ouvrage;
    }

    public double getMonnaie_projet() {
        return monnaie_projet;
    }

    public void setMonnaie_projet(double monnaie_projet) {
        this.monnaie_projet = monnaie_projet;
    }

    public double getTaux_rent_eco() {
        return taux_rent_eco;
    }

    public void setTaux_rent_eco(double taux_rent_eco) {
        this.taux_rent_eco = taux_rent_eco;
    }

    public double getCout_total() {
        return cout_total;
    }

    public void setCout_total(double cout_total) {
        this.cout_total = cout_total;
    }

    public double getTaux_rent_interneInit() {
        return taux_rent_interneInit;
    }

    public void setTaux_rent_interneInit(double taux_rent_interneInit) {
        this.taux_rent_interneInit = taux_rent_interneInit;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public String getStade() {
        return stade;
    }

    public void setStade(String stade) {
        this.stade = stade;
    }


    public String getIntitule_projet() {
        return intitule_projet;
    }

    public void setIntitule_projet(String intitule_projet) {
        this.intitule_projet = intitule_projet;
    }

    public Project() {
    }

    public Project(int id_projet, String code_projet, String intitule_projet, String description_projet, Date dateDeb_projet, Date dateFin_projet, String statut_projet, int id_theme_projet, String maitre_oeuvre, String maitre_ouvrage, double monnaie_projet, double taux_rent_eco, double cout_total, double taux_rent_interneInit, String observations, String secteur, String stade) {
        this.id_projet = id_projet;
        this.code_projet = code_projet;
        this.intitule_projet = intitule_projet;
        this.description_projet = description_projet;
        this.dateDeb_projet = dateDeb_projet;
        this.dateFin_projet = dateFin_projet;
        this.statut_projet = statut_projet;
        this.id_theme_projet = id_theme_projet;
        this.maitre_oeuvre = maitre_oeuvre;
        this.maitre_ouvrage = maitre_ouvrage;
        this.monnaie_projet = monnaie_projet;
        this.taux_rent_eco = taux_rent_eco;
        this.cout_total = cout_total;
        this.taux_rent_interneInit = taux_rent_interneInit;
        this.observations = observations;
        this.secteur = secteur;
        this.stade = stade;
    }

    public int getId_projet() {
        return id_projet;
    }

    public void setId_projet(int id_projet) {
        this.id_projet = id_projet;
    }

    public String getCode_projet() {
        return code_projet;
    }

    public void setCode_projet(String code_projet) {
        this.code_projet = code_projet;
    }



    public String getDescription_projet() {
        return description_projet;
    }

    public void setDescription_projet(String description_projet) {
        this.description_projet = description_projet;
    }

    public Date getDateDeb_projet() {
        return dateDeb_projet;
    }

    public void setDateDeb_projet(Date dateDeb_projet) {
        this.dateDeb_projet = dateDeb_projet;
    }

    public Date getDateFin_projet() {
        return dateFin_projet;
    }

    public void setDateFin_projet(Date dateFin_projet) {
        this.dateFin_projet = dateFin_projet;
    }

    public String getStatut_projet() {
        return statut_projet;
    }

    public void setStatut_projet(String statut_projet) {
        this.statut_projet = statut_projet;
    }

    public int getId_theme_projet() {
        return id_theme_projet;
    }

    public void setId_theme_projet(int id_theme_projet) {
        this.id_theme_projet = id_theme_projet;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id_projet=" + id_projet +
                ", code_projet='" + code_projet + '\'' +
                ", intitule_projet='" + intitule_projet + '\'' +
                ", description_projet='" + description_projet + '\'' +
                ", dateDeb_projet=" + dateDeb_projet +
                ", dateFin_projet=" + dateFin_projet +
                ", statut_projet='" + statut_projet + '\'' +
                ", id_theme_projet=" + id_theme_projet +
                ", maitre_oeuvre='" + maitre_oeuvre + '\'' +
                ", maitre_ouvrage='" + maitre_ouvrage + '\'' +
                ", monnaie_projet=" + monnaie_projet +
                ", taux_rent_eco=" + taux_rent_eco +
                ", cout_total=" + cout_total +
                ", taux_rent_interneInit=" + taux_rent_interneInit +
                ", observations='" + observations + '\'' +
                ", secteur='" + secteur + '\'' +
                ", stade='" + stade + '\'' +
                '}';
    }
}