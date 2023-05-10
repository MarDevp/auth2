package com.example.auth2.models;
import jakarta.persistence.*;


@Entity
@Table(name = "objectif")
public class Objectif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idObjectif;

    @Column(name = "libele_objectif")
    private String libeleObjectif;

    @Column(name = "description_objectif")
    private String descriptionObjectif;

    @Column(name = "id_projet")
    private int idProjet;

    @Column(name = "is_global")
    private boolean isGlobal;

    @Column(name = "is_objectif")
    private boolean isObjectif;

    @ManyToOne
    @JoinColumn(name="projet")
    Project projet;

    @Column(name = "res_id_objectif")
    private int resIdObjectif;


    public int getResIdObjectif() {
        return resIdObjectif;
    }

    public void setResIdObjectif(int resIdObjectif) {
        this.resIdObjectif = resIdObjectif;
    }

    public boolean isObjectif() {
        return isObjectif;
    }

    public void setObjectif(boolean objectif) {
        isObjectif = objectif;
    }

    public int getIdObjectif() {
        return idObjectif;
    }

    public void setIdObjectif(int idObjectif) {
        this.idObjectif = idObjectif;
    }

    public String getLibeleObjectif() {
        return libeleObjectif;
    }

    public void setLibeleObjectif(String libeleObjectif) {
        this.libeleObjectif = libeleObjectif;
    }

    public String getDescriptionObjectif() {
        return descriptionObjectif;
    }

    public void setDescriptionObjectif(String descriptionObjectif) {
        this.descriptionObjectif = descriptionObjectif;
    }

    public int getId_projet() {
        return idProjet;
    }

    public void setId_projet(int id_projet) {
        this.idProjet = id_projet;
    }

    public boolean getIsGlobal() {
        return isGlobal;
    }

    public void setIsGlobal(boolean isGlobal) {
        this.isGlobal = isGlobal;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public Project getProjet() {
        return projet;
    }

    public void setProjet(Project projet) {
        this.projet = projet;
    }

    public Objectif() {
    }

    public Objectif(int id_objectif, String libeleObjectif, String descriptionObjectif, int id_projet, boolean is_global , boolean isObjectif, Project projet, int resIdObjectif) {
        this.idObjectif = id_objectif;
        this.libeleObjectif = libeleObjectif;
        this.descriptionObjectif = descriptionObjectif;
        this.idProjet = id_projet;
        this.isGlobal = is_global;
        this.isObjectif=isObjectif;
        this.projet=projet;
        this.resIdObjectif=resIdObjectif;
    }

    @Override
    public String toString() {
        return "Objectif{" +
                "id_objectif=" + idObjectif +
                ", libele_objectif='" + libeleObjectif + '\'' +
                ", description_objectif='" + descriptionObjectif + '\'' +
                ", id_projet=" + idProjet +
                ", isGlobal='" + isGlobal + '\'' +
                '}';
    }
}
