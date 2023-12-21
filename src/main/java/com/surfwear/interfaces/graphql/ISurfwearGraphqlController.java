package com.surfwear.interfaces.graphql;

import com.surfwear.entities.*;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.Date;
import java.util.List;

public interface ISurfwearGraphqlController {
    @QueryMapping
    public List<Utilisateur> getAllUsers();

    @QueryMapping
    public Utilisateur getUserById(@Argument("id") int id);

    @QueryMapping
    public Utilisateur createUser(
            @Argument("name") String name,
            @Argument("email") String email,
            @Argument("password") String password,
            @Argument("role") String role
    );

    @QueryMapping
    public Utilisateur updateUser(
            @Argument("id") int id,
            @Argument("name") String name,
            @Argument("email") String email,
            @Argument("password") String password,
            @Argument("role") String role
    );

    @QueryMapping
    public Boolean deleteUser(@Argument("id") int id);

    @QueryMapping
    public List<Article> getAllArticles();

    @QueryMapping
    public Article getArticleById(@Argument("id") int id);

    @QueryMapping
    public Article createArticle(
            @Argument("nom") String nom,
            @Argument("prix") float prix,
            @Argument("categorie") Categorie categorie,
            @Argument("description") String description,
            @Argument("img") String img
    );

    @QueryMapping
    public Article updateArticle(
            @Argument("id") int id,
            @Argument("nom") String nom,
            @Argument("prix") float prix,
            @Argument("categorie") Categorie categorie,
            @Argument("description") String description,
            @Argument("img") String img
    );

    @QueryMapping
    public Boolean deleteArticle(@Argument("id") int id);

    @QueryMapping
    public List<Categorie> getAllCategories();

    @QueryMapping
    public Categorie getCategorieById(@Argument("id") int id);

    @QueryMapping
    public Categorie createCategorie(
            @Argument("nomCategorie") String nomCategorie,
            @Argument("description") String description
    );

    @QueryMapping
    public Categorie updateCategorie(
            @Argument("id") int id,
            @Argument("nomCategorie") String nomCategorie,
            @Argument("description") String description
    );

    @QueryMapping
    public Boolean deleteCategorie(@Argument("id") int id);

    @QueryMapping
    public List<Commande> getAllCommandes();

    @QueryMapping
    public Commande getCommandeById(@Argument("id") int id);

    @QueryMapping
    public Commande createCommande(
            @Argument("detailCommande") DetailCommande detailCommande,
            @Argument("dateCommande") Date dateCommande,
            @Argument("status") String status,
            @Argument("total") double total
    );

    @QueryMapping
    public Commande updateCommande(
            @Argument("id") int id,
            @Argument("commande") DetailCommande commande,
            @Argument("dateCommande") Date dateCommande,
            @Argument("status") String status,
            @Argument("total") double total
    );

    @QueryMapping
    public Boolean deleteCommande(@Argument("id") int id);

    @QueryMapping
    public List<Inventaire> getAllInventaires();

    @QueryMapping
    public Inventaire getInventaireById(@Argument("id") int id);

    @QueryMapping
    public Inventaire createInventaire(
            @Argument("article") Article article,
            @Argument("qteStock") int qteStock,
            @Argument("qteReserve") int qteReserve
    );

    @QueryMapping
    public Inventaire updateInventaire(
            @Argument("id") int id,
            @Argument("article") Article article,
            @Argument("qteStock") int qteStock,
            @Argument("qteReserve") int qteReserve
    );

    @QueryMapping
    public Boolean deleteInventaire(@Argument("id") int id);

    @QueryMapping
    public List<Paiement> getAllPaiements();

    @QueryMapping
    public Paiement getPaiementById(@Argument("id") int id);

    @QueryMapping
    public Paiement createPaiement(
            @Argument("commande") Commande commande,
            @Argument("montant") double montant,
            @Argument("methode") String methode,
            @Argument("datePaiement") Date datePaiement
    );

    @QueryMapping
    public Paiement updatePaiement(
            @Argument("id") int id,
            @Argument("montant") float montant,
            @Argument("methode") String methode,
            @Argument("date") Date date
    );

    @QueryMapping
    public Boolean deletePaiement(@Argument("id") int id);


}

