package com.surfwear.graphql.entities;

public class Categorie {
    private int categorieId;
    private String nomCategorie;
    private String description;

    public Categorie(int categorieId, String nomCategorie, String description) {
        this.categorieId = categorieId;
        this.nomCategorie = nomCategorie;
        this.description = description;
    }

    public int getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(int categorieId) {
        this.categorieId = categorieId;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "categorieId=" + categorieId +
                ", nomCategorie='" + nomCategorie + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
