package com.surfwear.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Article {

    private int articleId;
    private String nom;
    private float prix;
    private Categorie categorie;
    private String description;
    private String img;

    /**
     * @param articleId int id de l'article
     * @param nom String nom de l'article
     * @param prix float prix de l'article
     * @param categorie Categorie categorie de l'article
     * @param description String description de l'article
     * @param img String img de l'article
     */
    public Article(int articleId, String nom, float prix, Categorie categorie, String description, String img) {
        this.articleId = articleId;
        this.nom = nom;
        this.prix = prix;
        this.categorie = categorie;
        this.description = description;
        this.img = img;
    }

    /**
     * @param o Object
     * @return boolean
     */
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

    /**
     * @return int
     */
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
  
    /**
     * @return String
     */
    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", categorie=" + categorie +
                ", description='" + description + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}

