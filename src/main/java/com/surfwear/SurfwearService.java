package com.surfwear;

import com.surfwear.entities.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This is the service class for the surfwear application.
 * It is annotated with @Service to indicate that it is a Spring service.
 * It contains methods to create, read, update, and delete entities.
 * It contains lists of entities.
 * It contains atomic integers to generate unique IDs for entities.
 * It contains methods to get entities by ID.
 * It contains methods to get all entities.
 * It contains methods to create entities.
 * It contains methods to update entities.
 * It contains methods to delete entities.
 */
@Service
public class SurfwearService {
    /* ENTITIES LISTS */
    //This is a list of users. It is initialized with two users.
    private final List<Utilisateur> users = new ArrayList<>();
    //This is a list of articles. It is initialized with two articles.
    private final List<Article> articles = new ArrayList<>();
    //This is a list of categories. It is initialized with two categories.
    private final List<Categorie> categories = new ArrayList<>();
    //This is a list of inventaires. It is initialized with two inventaires.
    private final List<Inventaire> inventaires = new ArrayList<>();
    //This is a list of commandes. It is initialized with two commandes.
    private final List<Commande> commandes = new ArrayList<>();
    //This is a list of paiements. It is initialized with two paiements.
    private final List<Paiement> paiements = new ArrayList<>();
    //This is a list of detailCommandes. It is initialized with two detailCommandes.
    private final List<DetailCommande> detailCommandes = new ArrayList<>();

    /* ATOMIC INTEGERS */
    //This is an atomic integer that is used to generate unique IDs for users.
    private final AtomicInteger userIdCounter = new AtomicInteger(1);
    //This is an atomic integer that is used to generate unique IDs for articles.
    private final AtomicInteger articleIdCounter = new AtomicInteger(1);
    //This is an atomic integer that is used to generate unique IDs for categories.
    private final AtomicInteger categorieIdCounter = new AtomicInteger(1);
    //This is an atomic integer that is used to generate unique IDs for inventaires.
    private final AtomicInteger inventaireIdCounter = new AtomicInteger(1);
    //This is an atomic integer that is used to generate unique IDs for commandes.
    private final AtomicInteger commandeIdCounter = new AtomicInteger(1);
    //This is an atomic integer that is used to generate unique IDs for paiements.
    private final AtomicInteger paiementIdCounter = new AtomicInteger(1);
    //This is an atomic integer that is used to generate unique IDs for detailCommandes.
    private final AtomicInteger detailCommandeIdCounter = new AtomicInteger(1);

    //This is the constructor
    //TODO: Implement to add each of two entities inside the lists

    /*================================================================================*/
    /* USER */
    /**
     * This method returns all users.
     * @return Utilisateur all users
     */
    public List<Utilisateur> getAllUsers() {
        return users;
    }


    /**
     * This method returns a user by ID.
     * @param id int
     * @return Utilisateur user by id or null if not found
     */
    public Utilisateur getUserById(int id) {
        return users.stream().filter(user -> user.getUtilisateurId()==id).findFirst().orElse(null);
    }

    /**
     * This method creates a new user.
     * @param name String
     * @param email String
     * @param password String
     * @param role String
     * @return Utilisateur user
     */
    public Utilisateur createUser(String name, String email, String password, String role) {
        //This is the new user.
        Utilisateur user = new Utilisateur(userIdCounter.getAndIncrement(), name, email, password, role);
        //The new user is added to the list of users.
        users.add(user);
        //The new user is returned.
        return user;
    }


    /**
     * This method updates an existing user.
     * @param id int
     * @param name String
     * @param email String
     * @param password String
     * @param role String
     * @return Utilisateur user
     */
    public Utilisateur updateUser(int id, String name, String email, String password, String role) {
        //This is the user that will be updated.
        Utilisateur user = getUserById(id);
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

    /**
     * This method deletes a user.
     * @param id int
     * @return Boolean true if user deleted, false if not
     */
    public Boolean deleteUser(int id) {
        //This is the user that will be deleted.
        Utilisateur user = getUserById(id);
        //If the user exists, it is deleted.
        if (user != null) {
            users.remove(user);
            return true;
        }
        //The user is returned.
        return false;
    }

    /*================================================================================*/
    /* ARTICLE */
    /**
     * This method returns all articles.
     * @return Article all articles
     */
    public List<Article> getAllArticles() {
        return articles;
    }

    /**
     * This method returns an article by ID.
     * @param id int
     * @return Article article by id or null if not found
     */
    public Article getArticleById(int id) {
        return articles.stream().filter(article -> article.getArticleId()==id).findFirst().orElse(null);
    }

    /**
     * This method creates a new article.
     * @param nom String
     * @param prix float
     * @param categorie Categorie
     * @param description String
     * @param img String
     * @return Article article
     */
    public Article createArticle(String nom,float prix,Categorie categorie,String description,String img) {

        //This is the new article.
        Article article = new Article(articleIdCounter.getAndIncrement(),nom,prix,categorie,description,img);
        //The new article is added to the list of articles.
        articles.add(article);
        //The new article is returned.
        return article;
    }


    /**
     * This method updates an existing article.
     * @param id int
     * @param nom String
     * @param prix float
     * @param categorie Categorie
     * @param description String
     * @param img String
     * @return Article article
     */
    public Article updateArticle(int id,String nom,float prix,Categorie categorie,String description,String img) {
        //This is the article that will be updated.
        Article article = getArticleById(id);
        //If the article exists, it is updated.
        if (article != null) {
            article.setArticleId(id);
            article.setNom(nom);
            article.setPrix(prix);
            article.setCategorie(categorie);
            article.setDescription(description);
            article.setImg(img);
        }
        //The updated article is returned.
        return article;
    }


    /**
     * This method deletes an article.
     * @param id int
     * @return Boolean true if article deleted, false if not
     */
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

    /*================================================================================*/
    /* CATEGORIE */
    /**
     * This method returns all categories.
     * @return Categorie all categories
     */
    public List<Categorie> getAllCategories() {
        return categories;
    }

    /**
     * This method returns a categorie by ID.
     * @param id int
     * @return Categorie categorie by id or null if not found
     */
    public Categorie getCategorieById(int id) {
        return categories.stream().filter(categorie -> categorie.getCategorieId()==id).findFirst().orElse(null);
    }

    /**
     * This method creates a new categorie.
     * @param nomCategorie String
     * @param description String
     * @return Categorie categorie
     */
    public Categorie createCategorie(String nomCategorie,String description) {
        //This is the new categorie.
        Categorie categorie = new Categorie(categorieIdCounter.getAndIncrement(), nomCategorie, description);
        //The new categorie is added to the list of categories.
        categories.add(categorie);
        //The new categorie is returned.
        return categorie;
    }

    /**
     * This method updates an existing categorie.
     * @param id int
     * @param nomCategorie String
     * @param description String
     * @return Categorie categorie
     */
    public Categorie updateCategorie(int id, String nomCategorie,String description) {
        //This is the categorie that will be updated.
        Categorie categorie = getCategorieById(id);
        //If the categorie exists, it is updated.
        if (categorie != null) {
            categorie.setCategorieId(id);
            categorie.setNomCategorie(nomCategorie);
            categorie.setDescription(description);
        }
        //The updated categorie is returned.
        return categorie;
    }

    /**
     * This method deletes a categorie.
     * @param id int
     * @return Boolean true if categorie deleted, false if not
     */
    public Boolean deleteCategorie(int id) {
        //This is the categorie that will be deleted.
        Categorie categorie = getCategorieById(id);
        //If the categorie exists, it is deleted.
        if (categorie != null) {
            categories.remove(categorie);
            return true;
        }
        //The categorie is returned.
        return false;
    }

    /*================================================================================*/
    /* INVENTAIRE */
    /**
     * This method returns all inventaires.
     * @return Inventaire all inventaires
     */
    public List<Inventaire> getAllInventaires() {
        return inventaires;
    }

    /**
     * This method returns an inventaire by ID.
     * @param id int
     * @return Inventaire inventaire by id or null if not found
     */
    public Inventaire getInventaireById(int id) {
        return inventaires.stream().filter(inventaire -> inventaire.getInventaireId()==id).findFirst().orElse(null);
    }

    /**
     * This method creates a new inventaire.
     * @param article Article
     * @param qteStock int
     * @param qteReserve int
     * @return Inventaire inventaire
     */
    public Inventaire createInventaire(Article article,int qteStock,int qteReserve) {

        //This is the new inventaire.
        Inventaire inventaire = new Inventaire(inventaireIdCounter.getAndIncrement(), article, qteStock, qteReserve);
        //The new inventaire is added to the list of inventaires.
        inventaires.add(inventaire);
        //The new inventaire is returned.
        return inventaire;
    }

    /**
     * This method updates an existing inventaire.
     * @param id int
     * @param article Article
     * @param qteStock int
     * @param qteReserve int
     * @return Inventaire inventaire
     */
    public Inventaire updateInventaire(int id, Article article,int qteStock,int qteReserve) {
        //This is the inventaire that will be updated.
        Inventaire inventaire = getInventaireById(id);
        //If the inventaire exists, it is updated.
        if (inventaire != null) {
            inventaire.setInventaireId(id);
            inventaire.setArticle(article);
            inventaire.setQteStock(qteStock);
            inventaire.setQteReserve(qteReserve);
        }
        //The updated inventaire is returned.
        return inventaire;
    }

    /**
     * This method deletes an inventaire.
     * @param id int
     * @return Boolean true if inventaire deleted, false if not
     */
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

    /*================================================================================*/
    /* COMMANDE */
    /**
     * This method returns all commandes.
     * @return Commande all commandes
     */
    public List<Commande> getAllCommandes() {
        return commandes;
    }

    /**
     * This method returns a commande by ID.
     * @param id int
     * @return Commande commande by id or null if not found
     */
    public Commande getCommandeById(int id) {
        return commandes.stream().filter(commande -> commande.getCommandeId()==id).findFirst().orElse(null);
    }

    /**
     * This method creates a new commande.
     * @param detailCommande DetailCommande
     * @param dateCommande Date
     * @param status String
     * @param total double
     * @return Commande commande
     */
    public Commande createCommande(DetailCommande detailCommande ,Date dateCommande ,String status, double total) {
        //This is the new commande.
        Commande commande = new Commande(commandeIdCounter.getAndIncrement(), detailCommande, dateCommande, status, total);
        //The new commande is added to the list of commandes.
        commandes.add(commande);
        //The new commande is returned.
        return commande;
    }

  
    /**
     * This method updates an existing commande.
     * @param id int
     * @param detailCommande DetailCommande
     * @param dateCommande Date
     * @param status String
     * @param total double
     * @return Commande commande
     */
    public Commande updateCommande(int id, DetailCommande detailCommande ,Date dateCommande ,String status, double total) {
        //This is the commande that will be updated.
        Commande commande = getCommandeById(id);
        //If the commande exists, it is updated.
        if (commande != null) {
            commande.setCommandeId(id);
            commande.setCommande(detailCommande);
            commande.setDateCommande(dateCommande);
            commande.setStatus(status);
            commande.setTotal(total);
        }
        //The updated commande is returned.
        return commande;
    }

    /**
     * This method deletes a commande.
     * @param id int
     * @return Boolean true if commande deleted, false if not
     */
    public Boolean deleteCommande(int id) {
        //This is the commande that will be deleted.
        Commande commande = getCommandeById(id);
        //If the commande exists, it is deleted.
        if (commande != null) {
            commandes.remove(commande);
            return true;
        }
        //The commande is returned.
        return false;
    }

    /*================================================================================*/
    /* PAIEMENT */
    /**
     * This method returns all paiements.
     * @return Paiement all paiements
     */
    public List<Paiement> getAllPaiements() {
        return paiements;
    }

    /**
     * This method returns a paiement by ID.
     * @param id int
     * @return Paiement paiement by id or null if not found
     */
    public Paiement getPaiementById(int id) {
        return paiements.stream().filter(Paiement -> Paiement.getPaiementId()==id).findFirst().orElse(null);
    }

    /**
     * This method creates a new paiement.
     * @param commande Commande
     * @param montant double
     * @param methode String
     * @param datePaiement Date
     * @return Paiement paiement
     */
    public Paiement createPaiement(Commande commande ,double montant ,String methode ,Date datePaiement) {
        //This is the new Paiement.
        Paiement Paiement = new Paiement(paiementIdCounter.getAndIncrement(), commande, montant, methode, datePaiement);
        //The new Paiement is added to the list of Paiements.
        paiements.add(Paiement);
        //The new Paiement is returned.
        return Paiement;
    }

    /**
     * This method updates an existing paiement.
     * @param id int
     * @param montant double
     * @param methode String
     * @param datePaiement Date
     * @return Paiement paiement
     */
    public Paiement updatePaiement(int id ,double montant ,String methode ,Date datePaiement) {
        //This is the Paiement that will be updated.
        Paiement Paiement = getPaiementById(id);
        //If the Paiement exists, it is updated.
        if (Paiement != null) {
            Paiement.setPaiementId(id);
            Paiement.setMontant(montant);
            Paiement.setMethode(methode);
            Paiement.setDatePaiement(datePaiement);
        }
        //The updated Paiement is returned.
        return Paiement;
    }

    /**
     * This method deletes a paiement.
     * @param id int
     * @return Boolean true if paiement deleted, false if not
     */
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

    /*================================================================================*/
    /* DETAIL COMMANDE */
    /**
     * This method returns all detailCommandes.
     * @return DetailCommande all detailCommandes
     */
    public List<DetailCommande> getAllDetailCommandes() {
        return detailCommandes;
    }

    /**
     * This method returns a detailCommande by ID.
     * @param id int
     * @return DetailCommande detailCommande by id or null if not found
     */
    public DetailCommande getDetailCommandeById(int id) {
        return detailCommandes.stream().filter(detailCommande -> detailCommande.getDetailCommandeId()==id).findFirst().orElse(null);
    }

    /**
     * This method creates a new detailCommande.
     * @param article Article
     * @param qte int
     * @param prixUnitaire double
     * @return DetailCommande detailCommande
     */
    public DetailCommande createDetailCommande(Article article,int qte,double prixUnitaire) {
        //This is the new detailCommande.
        DetailCommande detailCommande = new DetailCommande(detailCommandeIdCounter.getAndIncrement(), article, qte, prixUnitaire);
        //The new detailCommande is added to the list of detailCommandes.
        detailCommandes.add(detailCommande);
        //The new detailCommande is returned.
        return detailCommande;
    }

    /**
     * This method updates an existing detailCommande.
     * @param id int
     * @param article Article
     * @param qte int
     * @param prixUnitaire double
     * @return DetailCommande detailCommande
     */
    public DetailCommande updateDetailCommande(int id, Article article,int qte,double prixUnitaire) {
        //This is the detailCommande that will be updated.
        DetailCommande detailCommande = getDetailCommandeById(id);
        //If the detailCommande exists, it is updated.
        if (detailCommande != null) {
            detailCommande.setDetailCommandeId(id);
            detailCommande.setArticle(article);
            detailCommande.setQte(qte);
            detailCommande.setPrixUnitaire(prixUnitaire);
        }
        //The updated detailCommande is returned.
        return detailCommande;
    }

    /**
     * This method deletes a detailCommande.
     * @param id int
     * @return Boolean true if detailCommande deleted, false if not
     */
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
