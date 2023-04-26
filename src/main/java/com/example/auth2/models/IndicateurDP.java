package com.example.auth2.models;
import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "indicateur_dates_prevues_suivi")
public class IndicateurDP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_date_prevue;

    @Column(name = "id_indicateur")
    private int id_indicateur;

    @Column(name = "libele_DP")
    private String libele_DP;

    @Column(name = "date_planification")
    private Date date_planification;

    @Column(name = "valeur_cible_date")
    private double valeur_cible_date;


    public IndicateurDP()
    {

    }

    public IndicateurDP(int id_date_prevue, int id_indicateur, String libele_DP, Date date_planification, double valeur_cible_date) {
        this.id_date_prevue = id_date_prevue;
        this.id_indicateur = id_indicateur;
        this.libele_DP = libele_DP;
        this.date_planification = date_planification;
        this.valeur_cible_date = valeur_cible_date;
    }

    public int getId_date_prevue() {
        return id_date_prevue;
    }

    public void setId_date_prevue(int id_date_prevue) {
        this.id_date_prevue = id_date_prevue;
    }

    public int getId_indicateur() {
        return id_indicateur;
    }

    public void setId_indicateur(int id_indicateur) {
        this.id_indicateur = id_indicateur;
    }

    public String getLibele_DP() {
        return libele_DP;
    }

    public void setLibele_DP(String libele_DP) {
        this.libele_DP = libele_DP;
    }

    public Date getDate_planification() {
        return date_planification;
    }

    public void setDate_planification(Date date_planification) {
        this.date_planification = date_planification;
    }

    public double getValeur_cible_date() {
        return valeur_cible_date;
    }

    public void setValeur_cible_date(double valeur_cible_date) {
        this.valeur_cible_date = valeur_cible_date;
    }


}
