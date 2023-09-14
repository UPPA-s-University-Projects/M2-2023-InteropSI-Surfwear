package com.example.graphql.entities;

import java.util.ArrayList;
import java.util.Date;

import org.h2.engine.User;

public class Commande {

    private String id;
    private User user;
    private ArrayList<String> articles;
    private float prix;
    private Date date;

    public Commande(String id, User user, float prix, Date date) {
        this.id = id;
        this.user = user;
        this.prix = prix;
        this.date = date;
        this.articles = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<String> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<String> articles) {
        this.articles = articles;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
