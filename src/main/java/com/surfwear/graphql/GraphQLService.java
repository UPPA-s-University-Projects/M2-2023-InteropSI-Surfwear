package com.surfwear.graphql;

import com.surfwear.graphql.entities.Article;
import com.surfwear.graphql.entities.Commande;


import com.surfwear.graphql.entities.Utilisateur;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GraphQLService {

    private List<Article> articles = new ArrayList<>();
    private List<Utilisateur> users = new ArrayList<>();
    private final List<Commande> commandes = new ArrayList<>();
    private AtomicInteger articleIdCounter = new AtomicInteger(1);
    private AtomicInteger userIdCounter = new AtomicInteger(1);

    public GraphQLService() {
        Article article = new Article(articleIdCounter.getAndIncrement(), "Surf");
        articles.add(article);

        Utilisateur user1 = new Utilisateur(userIdCounter.getAndIncrement(), "User One", "mail", "pwd", "role1");
        Utilisateur user2 = new Utilisateur(userIdCounter.getAndIncrement(), "User Two", "mail", "pwd", "role2");
        users.add(user1);
        users.add(user2);
    }

    public List<Article> getAllArticles() {
        return articles;
    }

    public Optional<Article> getArticleById(String id) {
        return articles.stream().filter(article -> article.getArticleId().equals(id)).findFirst();
    }

     // Méthode pour récupérer toutes les commandes
     public List<Commande> getAllCommandes() {
        return commandes;
    }

    // Méthode pour récupérer une commande par son ID
    public Optional<Commande> getCommandeById(String id) {
        return commandes.stream()
                .filter(commande -> commande.getCommandeId().equals(id))
                .findFirst();
    }

    // Méthode pour créer une nouvelle commande
    public Commande createCommande(String id, String userId, List<String> articles, float prix, String date) {
        return null; // Mettez votre logique de création ici.
    }

    // Méthode pour mettre à jour une commande existante
    public Commande updateCommande(String id, List<String> articles, float prix, String date) {
        Optional<Commande> commandeExistante = getCommandeById(id);
        if (commandeExistante.isPresent()) {
            Commande commande = commandeExistante.get();
            // Mettez à jour les attributs de la commande avec les nouvelles valeurs
            // Retournez la commande mise à jour
        }
        return null; // Retournez null si la commande n'a pas été trouvée.
    }

    // Méthode pour supprimer une commande par son ID
    public boolean deleteCommande(String id) {
        Optional<Commande> commandeASupprimer = getCommandeById(id);
        if (commandeASupprimer.isPresent()) {
            // Supprimez la commande de la liste et retournez true
        }
        return false; // Retournez false si la commande n'a pas été trouvée.
    }

    //fonction mdp et nom    
    public static boolean verifierAuthentification(String id, String pwd) {
        // Vérifier si l'utilisateur et le mot de passe sont corrects
        return user.stream().filter(user -> id.equals(id)).collect(Collectors.toList) &&  Utilisateur.stream().filter(user -> id.equals(id)).collect(Collectors.toList).equals(pwd);
    }
}
