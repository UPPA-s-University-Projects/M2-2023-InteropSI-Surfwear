package com.surfwear.graphql.entities;

import java.util.Objects;

public class Utilisateur {
    private int utilisateurId;
    private String nom;
    private String email;
    private String password;
    private String Role;

    public Utilisateur(int utilisateurId, String nom, String email, String password, String role) {
        this.utilisateurId = utilisateurId;
        this.nom = nom;
        this.email = email;
        this.password = password;
        Role = role;
    }

    public int getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(int utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(utilisateurId, nom, email, password, Role);
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "utilisateurId=" + utilisateurId +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", Role='" + Role + '\'' +
                '}';
    }
}
