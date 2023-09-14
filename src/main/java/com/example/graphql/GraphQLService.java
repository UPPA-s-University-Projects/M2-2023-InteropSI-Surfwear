package com.example.graphql;

import com.example.graphql.entities.Commande;
import com.example.graphql.entities.User;
import com.example.graphql.entities.Articles;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GraphQLService {

    private List<Article> articles = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private final List<Commande> commandes = new ArrayList<>();
    private AtomicLong articleIdCounter = new AtomicLong(1);
    private AtomicLong userIdCounter = new AtomicLong(1);

    public GraphQLService() {
        Article article = new Article(articleIdCounter.getAndIncrement(), "Surf");
        article.add(article);

        User user1 = new User(userIdCounter.getAndIncrement(), "User One", user);
        User user2 = new User(userIdCounter.getAndIncrement(), "User Two", user);
        Users.add(user1);
        Users.add(user2);
    }

    public List<Article> getAllArticles() {
        return articles;
    }

    public Optional<Article> getArticleById(String id) {
        return articles.stream().filter(articles -> article.getId().equals(id)).findFirst();
    }

     // Méthode pour récupérer toutes les commandes
     public List<Commande> getAllCommandes() {
        return commandes;
    }

    // Méthode pour récupérer une commande par son ID
    public Optional<Commande> getCommandeById(String id) {
        return commandes.stream()
                .filter(commande -> commande.getId().equals(id))
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
        return Users.stream().filter(user -> id.equals(id)).collect(Collectors.toList) &&  Users.stream().filter(user -> id.equals(id)).collect(Collectors.toList).equals(pwd);
    }
}
