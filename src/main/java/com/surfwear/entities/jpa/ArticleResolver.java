package com.surfwear.entities.jpa;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.surfwear.entities.Article;
import com.surfwear.entities.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleResolver implements GraphQLResolver<Article> {
    private final SurfwearService surfwearService;

    @Autowired
    public ArticleResolver(SurfwearService surfwearService) {
        this.surfwearService = surfwearService;
    }

    // Résolution des requêtes liées à l'article
    public List<Article> getAllArticles() {
        return surfwearService.getAllArticles();
    }

    public Article getArticleById(int id) {
        return surfwearService.getArticleById(id);
    }

    public Article createArticle(String nom, float prix, Categorie categorie, String description, String img) {
        return surfwearService.createArticle(nom, prix, categorie, description, img);
    }

    public Article updateArticle(int id, String nom, float prix, Categorie categorie, String description, String img) {
        return surfwearService.updateArticle(id, nom, prix, categorie, description, img);
    }

    public Boolean deleteArticle(int id) {
        return surfwearService.deleteArticle(id);
    }

    // Autres méthodes de résolution pour les champs ou relations spécifiques à l'entité Article
    // ...
}
