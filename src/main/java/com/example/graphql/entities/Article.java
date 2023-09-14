package com.example.graphql.entities;

public class Article {

    private String id;
    private String nom;
    private String image;
    private float prix;
    private Map<String,String> tailles;

    public Article(String id, String nom, Strting image, float prix, Map<String,String> tailles) {
        this.id = id;
        this.nom = nom;
        this.image = image;
        this.prix = prix;
        this.tailles = tailles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Map<String,String> getTailles() {
        return tailles;
    }

    public void setTailles(Map<String,String> tailles){
        this.tailles=tailles;
    }

}
