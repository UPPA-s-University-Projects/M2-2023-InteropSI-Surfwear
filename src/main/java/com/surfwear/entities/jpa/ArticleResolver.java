package com.surfwear.entities.jpa;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.surfwear.entities.Article;
import com.surfwear.entities.Categorie;
import com.surfwear.services.InventaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleResolver implements GraphQLResolver<Article> {
    private final InventaireService inventaireService;

    @Autowired
    public ArticleResolver(InventaireService inventaireService) {
        this.inventaireService = inventaireService;
    }

    // Résolution des requêtes liées à l'article
    public List<Article> getAllArticles() {
        return inventaireService.getAllArticles();
    }

    public Article getArticleById(int id) {
        return inventaireService.getArticleById(id);
    }

    public Article createArticle(String nom, float prix, Categorie categorie, String description) {
        return inventaireService.createArticle(nom, description, prix, categorie.getCategorieId());
    }

    public Article updateArticle(int id, String nom, float prix, Categorie categorie, String description) {
        return inventaireService.updateArticle(id, nom, description, prix, categorie.getCategorieId());
    }

    public Article deleteArticle(int id) {
        return inventaireService.deleteArticle(id);
    }

    // Autres méthodes de résolution pour les champs ou relations spécifiques à l'entité Article
    // ...
}
