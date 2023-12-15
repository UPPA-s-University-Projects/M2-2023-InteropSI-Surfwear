package com.surfwear;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.surfwear.entities.*;

import java.util.List;

//This class's purpose is to provide a GraphQL API for the Surfwear application.
//It is annotated with @Controller to indicate that it is a Spring MVC controller.
@Controller
public class SurfwearController {
    //This annotation tells Spring to inject an instance of GraphQLService into this class.
    @Autowired
    private SurfwearService surfwearService;

    //This method returns all users.
    @QueryMapping
    public List<Utilisateur> getAllUsers() {
        return surfwearService.getAllUsers();
    }

    //This method returns a user by ID.
    @QueryMapping
    public Utilisateur getUserById(@Argument("id") int id) {
        return surfwearService.getUserById(id).orElse(null);
    }

    //This method creates a new user.
    @QueryMapping
    public Utilisateur createUser(
        @Argument("name") String name,
        @Argument("email") String email,
        @Argument("password") String password,
        @Argument("role") String role
    ) {
        return surfwearService.createUser(name, email, password, role);
    }

    //This method updates an existing user.
    @QueryMapping
    public Utilisateur updateUser(
        @Argument("id") int id,
        @Argument("name") String name,
        @Argument("email") String email,
        @Argument("password") String password,
        @Argument("role") String role
    ) {
        return surfwearService.updateUser(id, name, email, password, role);
    }

    //This method deletes a user.
    @QueryMapping
    public Boolean deleteUser(@Argument("id") int id) {
        return surfwearService.deleteUser(id);
    }

    //This method returns all articles.
    @QueryMapping
    public List<Article> getAllArticles() {
        return surfwearService.getAllArticles();
    }

    //This method returns an article by ID.
    @QueryMapping
    public Article getArticleById(@Argument("id") int id) {
        return surfwearService.getArticleById(id).orElse(null);//TODO:fix this
    }

    //This method creates a new article.
    @QueryMapping
    public Article createArticle(
        @Argument("title") String title,
        @Argument("articleId") String articleId
    ) {
        return surfwearService.createArticle(title, articleId);
    }

    //This method updates an existing article.
    @QueryMapping
    public Article updateArticle(
        @Argument("id") int id,
        @Argument("title") String title
    ) {
        return surfwearService.updateArticle(id, title);
    }

    //This method deletes an article.
    @QueryMapping
    public Boolean deleteArticle(@Argument("id") int id) {
        return surfwearService.deleteArticle(id);
    }

    //This method returns all commandes.
    @QueryMapping
    public List<Commande> getAllCommandes() {
        return surfwearService.getAllCommandes();
    }

    //This method returns a commande by ID.
    @QueryMapping
    public Commande getCommandeById(@Argument("id") int id) {
        return surfwearService.getCommandeById(id).orElse(null);
    }

    //This method creates a new commande.
    @QueryMapping
    public Commande createCommande(
        @Argument("id") int id,
        @Argument("userId") String userId,
        @Argument("articles") List<String> articles,
        @Argument("prix") float prix,
        @Argument("date") String date
    ) {
        return surfwearService.createCommande(id, userId, articles, prix, date);
    }

    //This method updates an existing commande.
    @QueryMapping
    public Commande updateCommande(
        @Argument("id") int id,
        @Argument("userId") String userId,
        @Argument("articles") List<String> articles,
        @Argument("prix") float prix,
        @Argument("date") String date
    ) {
        return surfwearService.updateCommande(id, userId, articles, prix, date);
    }

    //This method deletes a commande.
    @QueryMapping
    public Boolean deleteCommande(@Argument("id") int id) {
        return surfwearService.deleteCommande(id);
    }

    //This method returns all inventaires.
    @QueryMapping
    public List<Inventaire> getAllInventaires() {
        return surfwearService.getAllInventaires();
    }

    //This method returns an inventaire by ID.
    @QueryMapping
    public Inventaire getInventaireById(@Argument("id") int id) {
        return surfwearService.getInventaireById(id).orElse(null);
    }

    //This method creates a new inventaire.
    @QueryMapping
    public Inventaire createInventaire(
        @Argument("id") int id,
        @Argument("articleId") String articleId,
        @Argument("quantite") int quantite
    ) {
        return surfwearService.createInventaire(id, articleId, quantite);
    }

    //This method updates an existing inventaire.
    @QueryMapping
    public Inventaire updateInventaire(
        @Argument("id") int id,
        @Argument("articleId") String articleId,
        @Argument("quantite") int quantite
    ) {
        return surfwearService.updateInventaire(id, articleId, quantite);
    }

    //This method deletes an inventaire.
    @QueryMapping
    public Boolean deleteInventaire(@Argument("id") int id) {
        return surfwearService.deleteInventaire(id);
    }

    //This method returns all paiements.
    @QueryMapping
    public List<Paiement> getAllPaiements() {
        return surfwearService.getAllPaiements();
    }

    //This method returns a paiement by ID.
    @QueryMapping
    public Paiement getPaiementById(@Argument("id") int id) {
        return surfwearService.getPaiementById(id).orElse(null);
    }

    //This method creates a new paiement.
    @QueryMapping
    public Paiement createPaiement(
        @Argument("id") int id,
        @Argument("commandeId") String commandeId,
        @Argument("montant") float montant,
        @Argument("date") String date
    ) {
        return surfwearService.createPaiement(id, commandeId, montant, date);
    }

    //This method updates an existing paiement.
    @QueryMapping
    public Paiement updatePaiement(
        @Argument("id") int id,
        @Argument("commandeId") String commandeId,
        @Argument("montant") float montant,
        @Argument("date") String date
    ) {
        return surfwearService.updatePaiement(id, commandeId, montant, date);
    }

    //This method deletes a paiement.
    @QueryMapping
    public Boolean deletePaiement(@Argument("id") int id) {
        return surfwearService.deletePaiement(id);
    }
}
