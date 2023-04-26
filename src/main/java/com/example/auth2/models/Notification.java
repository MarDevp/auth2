package com.example.auth2.models;
import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "notification_suivi_indicateur")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_notification;

    @Column(name = "id_date_prevue")
    private int id_date_prevue;

    @Column(name = "statut_notification")
    private String statut_notification;


    public Notification()
    {

    }

    public Notification(int id_date_prevue, String statut_notification) {
        this.id_date_prevue = id_date_prevue;
        this.statut_notification = statut_notification;
    }

    public int getId_date_prevue() {
        return id_date_prevue;
    }

    public void setId_date_prevue(int id_date_prevue) {
        this.id_date_prevue = id_date_prevue;
    }

    public int getId_notification() {
        return id_notification;
    }

    public void setId_notification(int id_notification) {
        this.id_notification = id_notification;
    }


    public String getStatut_notification() {
        return statut_notification;
    }

    public void setStatut_notification(String statut_notification) {
        this.statut_notification = statut_notification;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id_notification=" + id_notification +
                ", id_date_prevue=" + id_date_prevue +
                ", statut_notification='" + statut_notification + '\'' +
                '}';
    }
}
