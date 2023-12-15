package com.surfwear.entities;

public class Article {

    private int articleId;
    private String nom;
    private float prix;
    private String categorie;
    private String description;
    private String img;

    public Article(int articleId, String nom, float prix, String categorie, String description, String img) {
        this.articleId = articleId;
        this.nom = nom;
        this.prix = prix;
        this.categorie = categorie;
        this.description = description;
        this.img = img;
    }

    public Article(int articleId, String nom) {
        this.articleId = articleId;
        this.nom = nom;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", categorie='" + categorie + '\'' +
                ", description='" + description + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;

        if (getArticleId() != article.getArticleId()) return false;
        if (Float.compare(getPrix(), article.getPrix()) != 0) return false;
        if (!getNom().equals(article.getNom())) return false;
        if (!getCategorie().equals(article.getCategorie())) return false;
        if (!getDescription().equals(article.getDescription())) return false;
        return getImg().equals(article.getImg());
    }

    @Override
    public int hashCode() {
        int result = getArticleId();
        result = 31 * result + getNom().hashCode();
        result = 31 * result + (getPrix() != 0.0f ? Float.floatToIntBits(getPrix()) : 0);
        result = 31 * result + getCategorie().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getImg().hashCode();
        return result;
    }
}

