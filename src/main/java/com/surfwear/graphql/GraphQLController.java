package com.surfwear.graphql;

import com.surfwear.graphql.entities.Commande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLController {

    @Autowired
    private GraphQLService graphQLService;

    @QueryMapping
    public List<Articles> getAllArticles() {
        return graphQLService.getAllArticles();
    }

    @QueryMapping
    public Articles getArticlesById(@Argument("id") String id) {
        return graphQLService.getArticlesById(id).orElse(null);
    }

    @MutationMapping
    public Articles createArticles(@Argument("title") String title, @Argument("articleId") String articleId) {
        return graphQLService.createArticles(title, articleId);
    }

    @MutationMapping
    public Articles updateArticles(@Argument("id") String id, @Argument("title") String title) {
        return graphQLService.updateArticles(id, title);
    }

    @MutationMapping
    public Boolean deleteArticles(@Argument("id") String id) {
        return graphQLService.deleteArticles(id);
    }

    @QueryMapping
    public List<Commande> getAllCommandes() {
        return graphQLService.getAllCommandes();
    }

    @QueryMapping
    public Commande getCommandeById(@Argument("id") String id) {
        return graphQLService.getCommandeById(id).orElse(null);
    }

    @MutationMapping
    public Commande createCommande(
        @Argument("id") String id,
        @Argument("userId") String userId,
        @Argument("articles") List<String> articles,
        @Argument("prix") float prix,
        @Argument("date") String date
    ) {
        // Convertissez les paramètres en types appropriés et appelez la méthode de service
        return graphQLService.createCommande(id, userId, articles, prix, date);
    }

    @MutationMapping
    public Commande updateCommande(
        @Argument("id") String id,
        @Argument("articles") List<String> articles,
        @Argument("prix") float prix,
        @Argument("date") String date
    ) {
        // Convertissez les paramètres en types appropriés et appelez la méthode de service
        return graphQLService.updateCommande(id, articles, prix, date);
    }

    @MutationMapping
    public Boolean deleteCommande(@Argument("id") String id) {
        return graphQLService.deleteCommande(id);
    }

}