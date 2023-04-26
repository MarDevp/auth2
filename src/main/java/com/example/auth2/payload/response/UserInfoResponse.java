package com.example.auth2.payload.response;

import java.util.List;

public class UserInfoResponse {
    private int id;
    private String username;
    private String email;
    private List<String> roles;

    private String nom_user;
    private String prenom_user;

    private String role_user;


    public UserInfoResponse(int id, String username, String email, List<String> roles, String nom_user, String prenom_user, String role_user ) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.nom_user=nom_user;
        this.prenom_user=prenom_user;
        this.role_user=role_user;


    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getNom_user() {
        return nom_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public String getPrenom_user() {
        return prenom_user;
    }

    public void setPrenom_user(String prenom_user) {
        this.prenom_user = prenom_user;
    }

    public String getRole_user() {
        return role_user;
    }

    public void setRole_user(String role_user) {
        this.role_user = role_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }
}
