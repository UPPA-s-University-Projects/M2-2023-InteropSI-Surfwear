package com.surfwear.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor // Lombok annotation for no-argument constructor
@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categorieId;

    private String nomCategorie;

    private String description;

    /**
     * @param categorieId  int id de la categorie
     * @param nomCategorie String nom de la categorie
     * @param description  String description de la categorie
     */
    public Categorie(int categorieId, String nomCategorie, String description) {
        this.categorieId = categorieId;
        this.nomCategorie = nomCategorie;
        this.description = description;
    }

    /**
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categorie categorie)) return false;

        if (getCategorieId() != categorie.getCategorieId()) return false;
        if (!getNomCategorie().equals(categorie.getNomCategorie())) return false;
        return getDescription().equals(categorie.getDescription());
    }

    /**
     * @return int
     */
    @Override
    public int hashCode() {
        int result = getCategorieId();
        result = 31 * result + getNomCategorie().hashCode();
        result = 31 * result + getDescription().hashCode();
        return result;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "Categorie{" +
                "categorieId=" + categorieId +
                ", nomCategorie='" + nomCategorie + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
