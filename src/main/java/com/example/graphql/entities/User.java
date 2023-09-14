package com.example.graphql.entities;

public class User {

    private String id;
    private String nom;
    private String pwd;
    private ArrayList<Article> articles;

    public User(String id, String nom, String pwd, ArrayList<Article> articles) {
        this.id = id;
        this.nom = nom;
        this.pwd = pwd;
        this.articles = articles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles){
        this.articles=articles;
    }

}
