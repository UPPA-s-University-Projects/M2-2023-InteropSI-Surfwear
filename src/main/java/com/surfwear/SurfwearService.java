package com.surfwear;


import org.springframework.stereotype.Service;

import com.surfwear.entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

//This is the service class for the surfwear application
//It is annotated with @Service to indicate that it is a Spring service.
@Service
public class SurfwearService {
    //This is a list of users. It is initialized with two users.
    private List<Utilisateur> users = new ArrayList<>();
    //This is a list of articles. It is initialized with two articles.
    private List<Article> articles = new ArrayList<>();
    //This is a list of inventaires. It is initialized with two inventaires.
    private List<Inventaire> inventaires = new ArrayList<>();
    //This is a list of commandes. It is initialized with two commandes.
    private List<Commande> commandes = new ArrayList<>();
    //This is a list of paiements. It is initialized with two paiements.
    private List<Paiement> paiements = new ArrayList<>();
    //This is a list of detailCommandes. It is initialized with two detailCommandes.
    private List<DetailCommande> detailCommandes = new ArrayList<>();

    //This is an atomic integer that is used to generate unique IDs for users.
    private AtomicInteger userIdCounter = new AtomicInteger(1);
    //This is an atomic integer that is used to generate unique IDs for articles.
    private AtomicInteger articleIdCounter = new AtomicInteger(1);
    //This is an atomic integer that is used to generate unique IDs for inventaires.
    private AtomicInteger inventaireIdCounter = new AtomicInteger(1);
    //This is an atomic integer that is used to generate unique IDs for commandes.
    private AtomicInteger commandeIdCounter = new AtomicInteger(1);
    //This is an atomic integer that is used to generate unique IDs for paiements.
    private AtomicInteger paiementIdCounter = new AtomicInteger(1);
    //This is an atomic integer that is used to generate unique IDs for detailCommandes.
    private AtomicInteger detailCommandeIdCounter = new AtomicInteger(1);


    //This is the constructor
    //TOCO: Implement to add each of two entities inside the lists

    //This method returns all users.
    public List<Utilisateur> getAllUsers() {
        return users;
    }

    //This method returns a user by ID.
    public Optional<Utilisateur> getUserById(int id) {
        return users.stream().filter(user -> user.getUtilisateurId()==id).findFirst();
    }

    //This method creates a new user.
    public Utilisateur createUser(String name, String email, String password, String role) {
        //This is the new user.
        Utilisateur user = new Utilisateur(userIdCounter.getAndIncrement(), name, email, password, role);
        //The new user is added to the list of users.
        users.add(user);
        //The new user is returned.
        return user;
    }

    //This method updates an existing user.
    public Utilisateur updateUser(int id, String name, String email, String password, String role) {
        //This is the user that will be updated.
        Utilisateur user = getUserById(id).orElse(null);
        //If the user exists, it is updated.
        if (user != null) {
            user.setNom(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setRole(role);
        }
        //The updated user is returned.
        return user;
    }

    //This method deletes a user.
    public Boolean deleteUser(int id) {
        //This is the user that will be deleted.
        Utilisateur user = getUserById(id).orElse(null);
        //If the user exists, it is deleted.
        if (user != null) {
            users.remove(user);
            return true;
        }
        //The user is returned.
        return false;
    }

    //This method returns all articles.
    public List<Article> getAllArticles() {
        return articles;
    }

    //This method returns an article by ID.
    public Article getArticleById(int id) {
        return articles.stream().filter(article -> article.getArticleId()==id).findFirst().orElse(null);
    }

    //This method creates a new article.
    public Article createArticle(String title, String articleId) {
        //This is the new article.
        Article article = new Article(articleIdCounter.getAndIncrement(), title, articleId);
        //The new article is added to the list of articles.
        articles.add(article);
        //The new article is returned.
        return article;
    }

    //This method updates an existing article.
    public Article updateArticle(int id, String title, String articleId) {
        //This is the article that will be updated.
        Article article = getArticleById(id);
        //If the article exists, it is updated.
        if (article != null) {
            article.setTitle(title);
            article.setArticleId(articleId);
        }
        //The updated article is returned.
        return article;
    }

    //This method deletes an article.
    public Boolean deleteArticle(int id) {
        //This is the article that will be deleted.
        Article article = getArticleById(id);
        //If the article exists, it is deleted.
        if (article != null) {
            articles.remove(article);
            return true;
        }
        //The article is returned.
        return false;
    }

    //This method returns all inventaires.
    public List<Inventaire> getAllInventaires() {
        return inventaires;
    }

    //This method returns an inventaire by ID.
    public Inventaire getInventaireById(int id) {
        return inventaires.stream().filter(inventaire -> inventaire.getInventaireId()==id).findFirst().orElse(null);
    }

    //This method creates a new inventaire.
    public Inventaire createInventaire(String title, String inventaireId) {
        //This is the new inventaire.
        Inventaire inventaire = new Inventaire(inventaireIdCounter.getAndIncrement(), title, inventaireId);
        //The new inventaire is added to the list of inventaires.
        inventaires.add(inventaire);
        //The new inventaire is returned.
        return inventaire;
    }

    //This method updates an existing inventaire.
    public Inventaire updateInventaire(int id, String title, String inventaireId) {
        //This is the inventaire that will be updated.
        Inventaire inventaire = getInventaireById(id);
        //If the inventaire exists, it is updated.
        if (inventaire != null) {
            inventaire.setTitle(title);
            inventaire.setInventaireId(inventaireId);
        }
        //The updated inventaire is returned.
        return inventaire;
    }

    //This method deletes an inventaire.
    public Boolean deleteInventaire(int id) {
        //This is the inventaire that will be deleted.
        Inventaire inventaire = getInventaireById(id);
        //If the inventaire exists, it is deleted.
        if (inventaire != null) {
            inventaires.remove(inventaire);
            return true;
        }
        //The inventaire is returned.
        return false;
    }

    //This method returns all commandes.
    public List<Commande> getAllCommandes() {
        return commandes;
    }

    //This method returns a commande by ID.
    public Commande getCommandeById(int id) {
        return commandes.stream().filter(commande -> commande.getCommandeId()==id).findFirst().orElse(null);
    }

    //This method creates a new commande.
    public Commande createCommande(String title, String commandeId) {
        //This is the new commande.
        Commande commande = new Commande(commandeIdCounter.getAndIncrement(), title, commandeId);
        //The new commande is added to the list of commandes.
        commandes.add(commande);
        //The new commande is returned.
        return commande;
    }

    //This method updates an existing commande.
    public Commande updateCommande(int id, String title, String commandeId) {
        //This is the commande that will be updated.
        Commande commande = getCommandeById(id);
        //If the commande exists, it is updated.
        if (commande != null) {
            commande.setTitle(title);
            commande.setCommandeId(commandeId);
        }
        //The updated commande is returned.
        return commande;
    }

    //This method deletes a commande.
    public Boolean deleteCommande(int id) {
        //This is the commande that will be deleted.
        com.surfwear.graphql.entities.Commande commande = getCommandeById(id);
        //If the commande exists, it is deleted.
        if (commande != null) {
            commandes.remove(commande);
            return true;
        }
        //The commande is returned.
        return false;
    }

    //This method returns all Paiements.
    public List<Paiement> getAllPaiements() {
        return paiements;
    }

    //This method returns a Paiement by ID.
    public Paiement getPaiementById(int id) {
        return paiements.stream().filter(Paiement -> Paiement.getPaiementId()==id).findFirst().orElse(null);
    }

    //This method creates a new Paiement.
    public Paiement createPaiement(String title, String PaiementId) {
        //This is the new Paiement.
        Paiement Paiement = new Paiement(paiementIdCounter.getAndIncrement(), title, PaiementId);
        //The new Paiement is added to the list of Paiements.
        paiements.add(Paiement);
        //The new Paiement is returned.
        return Paiement;
    }

    //This method updates an existing Paiement.
    public Paiement updatePaiement(int id, String title, String PaiementId) {
        //This is the Paiement that will be updated.
        Paiement Paiement = getPaiementById(id);
        //If the Paiement exists, it is updated.
        if (Paiement != null) {
            Paiement.setTitle(title);
            Paiement.setPaiementId(PaiementId);
        }
        //The updated Paiement is returned.
        return Paiement;
    }

    //This method deletes a Paiement.
    public Boolean deletePaiement(int id) {
        //This is the Paiement that will be deleted.
        Paiement paiement = getPaiementById(id);
        //If the Paiement exists, it is deleted.
        if (paiement != null) {
            paiements.remove(paiement);
            return true;
        }
        //The Paiement is returned.
        return false;
    }

    //This method returns all detailCommandes.
    public List<DetailCommande> getAllDetailCommandes() {
        return detailCommandes;
    }

    //This method returns a detailCommande by ID.
    public DetailCommande getDetailCommandeById(int id) {
        return detailCommandes.stream().filter(detailCommande -> detailCommande.getDetailCommandeId()==id).findFirst().orElse(null);
    }

    //This method creates a new detailCommande.
    public DetailCommande createDetailCommande(String title, String detailCommandeId) {
        //This is the new detailCommande.
        DetailCommande detailCommande = new DetailCommande(detailCommandeIdCounter.getAndIncrement(), title, detailCommandeId);
        //The new detailCommande is added to the list of detailCommandes.
        detailCommandes.add(detailCommande);
        //The new detailCommande is returned.
        return detailCommande;
    }

    //This method updates an existing detailCommande.
    public DetailCommande updateDetailCommande(int id, String title, String detailCommandeId) {
        //This is the detailCommande that will be updated.
        DetailCommande detailCommande = getDetailCommandeById(id);
        //If the detailCommande exists, it is updated.
        if (detailCommande != null) {
            detailCommande.setTitle(title);
            detailCommande.setDetailCommandeId(detailCommandeId);
        }
        //The updated detailCommande is returned.
        return detailCommande;
    }

    //This method deletes a detailCommande.
    public Boolean deleteDetailCommande(int id) {
        //This is the detailCommande that will be deleted.
        DetailCommande detailCommande = getDetailCommandeById(id);
        //If the detailCommande exists, it is deleted.
        if (detailCommande != null) {
            detailCommandes.remove(detailCommande);
            return true;
        }
        //The detailCommande is returned.
        return false;
    }

}
