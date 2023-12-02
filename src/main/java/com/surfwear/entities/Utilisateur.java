package com.surfwear.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Utilisateur {
    private int utilisateurId;
    private String nom;
    private String email;
    private String password;
    private String Role;

    /**
     * @param utilisateurId int id de l'utilisateur
     * @param nom String nom de l'utilisateur
     * @param email String email de l'utilisateur
     * @param password String password de l'utilisateur
     * @param role String role de l'utilisateur
     */
    public Utilisateur(int utilisateurId, String nom, String email, String password, String role) {
        this.utilisateurId = utilisateurId;
        this.nom = nom;
        this.email = email;
        this.password = password;
        Role = role;
    }

    /**
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Utilisateur utilisateur)) return false;

        if (getUtilisateurId() != utilisateur.getUtilisateurId()) return false;
        if (!getNom().equals(utilisateur.getNom())) return false;
        if (!getEmail().equals(utilisateur.getEmail())) return false;
        if (!getPassword().equals(utilisateur.getPassword())) return false;
        return getRole().equals(utilisateur.getRole());
    }

    /**
     * @return int
     */
    @Override
    public int hashCode() {
        int result = getUtilisateurId();
        result = 31 * result + getNom().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getRole().hashCode();
        return result;
    }

    /**
     * @return String
     */
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
