package com.example.graphql;

import com.example.graphql.entities.Author;
import com.example.graphql.entities.Book;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GraphQLService {

    private List<Article> articles = new ArrayList<>();
    private List<User> users = new ArrayList<>();
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

    

    //fonction mdp et nom    
    public static boolean verifierAuthentification(String id, String pwd) {
        // Vérifier si l'utilisateur et le mot de passe sont corrects
        return Users.stream().filter(user -> id.equals(id)).collect(Collectors.toList) &&  Users.stream().filter(user -> id.equals(id)).collect(Collectors.toList).equals(pwd);
    }
}
