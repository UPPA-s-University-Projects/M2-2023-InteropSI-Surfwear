package com.surfwear;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.Date;
import java.util.List;
import com.surfwear.entities.*;

/**
 * This class is the controller for the Surfwear application.
 * It is annotated with @Controller to indicate that it is a Spring MVC controller.
 * It is annotated with @Autowired to indicate that it is a Spring managed bean.
 * It is annotated with @QueryMapping to indicate that it is a GraphQL query.
 * It is annotated with @Argument to indicate that it is a GraphQL argument.
 * It is annotated with @ServiceConnection to indicate that it is a Spring managed service connection.
 * It is annotated with @TestConfiguration to indicate that it is a Spring managed test configuration.
 * It is annotated with @Bean to indicate that it is a Spring managed bean.
 * It is annotated with @SpringBootTest to indicate that it is a Spring Boot test.
 * It is annotated with @SpringBootApplication to indicate that it is a Spring Boot application.
 * It is annotated with @Test to indicate that it is a JUnit test.
 */

@Controller
public class SurfwearController {
    //This annotation tells Spring to inject an instance of GraphQLService into this class.
    @Autowired
    private SurfwearService surfwearService;

    /*================================================================================*/
    /* USER */
    /**
     * This method returns all users.
     * @return String
     */
    @QueryMapping
    public List<Utilisateur> getAllUsers() {
        return surfwearService.getAllUsers();
    }

    /**
     * This method returns a user by ID.
     * @param id int
     * @return Utilisateur
     */
    @QueryMapping
    public Utilisateur getUserById(@Argument("id") int id) {
        return surfwearService.getUserById(id);
    }

    /**
     * This method creates a new user.
     * @param name String
     * @param email String
     * @param password String
     * @param role String
     * @return Utilisateur
     */
    @QueryMapping
    public Utilisateur createUser(
        @Argument("name") String name,
        @Argument("email") String email,
        @Argument("password") String password,
        @Argument("role") String role
    ) {
        return surfwearService.createUser(name, email, password, role);
    }

    /**
     * This method updates an existing user.
     * @param id int
     * @param name String
     * @param email String
     * @param password String
     * @param role String
     * @return Utilisateur
     */
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

    /**
     * This method deletes a user.
     * @param id int
     * @return Boolean
     */
    @QueryMapping
    public Boolean deleteUser(@Argument("id") int id) {
        return surfwearService.deleteUser(id);
    }

    /*================================================================================*/
    /* ARTICLE */
    /**
     * This method returns all articles.
     * @return List<Article>
     */
    @QueryMapping
    public List<Article> getAllArticles() {
        return surfwearService.getAllArticles();
    }

    /**
     * This method returns an article by ID.
     * @param id int
     * @return Article
     */
    @QueryMapping
    public Article getArticleById(@Argument("id") int id) {
        return surfwearService.getArticleById(id);
    }

    /**
     * This method creates a new article.
     * @param nom String
     * @param prix float
     * @param categorie Categorie
     * @param description String
     * @param img String
     * @return Article
     */
    @QueryMapping
    public Article createArticle(
            @Argument("nom") String nom,
            @Argument("prix") float prix,
            @Argument("categorie") Categorie categorie,
            @Argument("description") String description,
            @Argument("img") String img
    ) {
        return surfwearService.createArticle(nom, prix, categorie, description, img);
    }

    /**
     * This method updates an existing article.
     * @param id int
     * @param nom String
     * @param prix float
     * @param categorie Categorie
     * @param description String
     * @param img String
     * @return Article
     */
    @QueryMapping
    public Article updateArticle(
        @Argument("id") int id,
        @Argument("nom") String nom,
        @Argument("prix") float prix,
        @Argument("categorie") Categorie categorie,
        @Argument("description") String description,
        @Argument("img") String img
    ) {
        return surfwearService.updateArticle(id, nom, prix, categorie, description, img);
    }

    /**
     * This method deletes an article.
     * @param id int
     * @return Boolean
     */
    @QueryMapping
    public Boolean deleteArticle(@Argument("id") int id) {
        return surfwearService.deleteArticle(id);
    }

    /*================================================================================*/
    /* CATEGORIE */
    /**
     * This method returns all categories.
     * @return List<Categorie>
     */
    @QueryMapping
    public List<Categorie> getAllCategories() {
        return surfwearService.getAllCategories();
    }


    /**
     * This method returns a categorie by ID.
     * @param id int
     * @return Categorie | null if not found
     */
    @QueryMapping
    public Categorie getCategorieById(@Argument("id") int id) {
        return surfwearService.getCategorieById(id);
    }


    /**
     * This method creates a new categorie.
     * @param nomCategorie String
     * @param description String
     * @return Categorie
     */
    @QueryMapping
    public Categorie createCategorie(
        @Argument("nomCategorie") String nomCategorie,
        @Argument("description") String description
    ) {
        return surfwearService.createCategorie(nomCategorie, description);
    }


    /**
     * This method updates an existing categorie.
     * @param id int
     * @param nomCategorie String
     * @param description String
     * @return Categorie
     */
    @QueryMapping
    public Categorie updateCategorie(
        @Argument("id") int id,
        @Argument("nomCategorie") String nomCategorie,
        @Argument("description") String description
    ) {
        return surfwearService.updateCategorie(id, nomCategorie, description);
    }


    /**
     * This method deletes a categorie.
     * @param id int
     * @return Boolean
     */
    @QueryMapping
    public Boolean deleteCategorie(@Argument("id") int id) {
        return surfwearService.deleteCategorie(id);
    }

    /*================================================================================*/
    /* COMMANDE */
    /**
     * This method returns all commandes.
     * @return List<Commande>
     */
    @QueryMapping
    public List<Commande> getAllCommandes() {
        return surfwearService.getAllCommandes();
    }

    /**
     * This method returns a commande by ID.
     * @param id int
     * @return Commande
     */
    @QueryMapping
    public Commande getCommandeById(@Argument("id") int id) {
        return surfwearService.getCommandeById(id);
    }

    /**
     * This method creates a new commande.
     * @param detailCommande DetailCommande
     * @param dateCommande Date
     * @param status String
     * @param total double
     * @return Commande
     */
    @QueryMapping
    public Commande createCommande(
            @Argument("detailCommande") DetailCommande detailCommande,
            @Argument("dateCommande") Date dateCommande,
            @Argument("status") String status,
            @Argument("total") double total
    ) {
        return surfwearService.createCommande(detailCommande, dateCommande, status, total);
    }

    /**
     * This method updates an existing commande.
     * @param id int
     * @param commande DetailCommande
     * @param dateCommande Date
     * @param status String
     * @param total double
     * @return Commande
     */
    @QueryMapping
    public Commande updateCommande(
        @Argument("id") int id,
        @Argument("commande") DetailCommande commande,
        @Argument("dateCommande") Date dateCommande,
        @Argument("status") String status,
        @Argument("total") double total
    ) {
        return surfwearService.updateCommande(id, commande, dateCommande, status, total);
    }

    /**
     * This method deletes a commande.
     * @param id int
     * @return Boolean
     */
    @QueryMapping
    public Boolean deleteCommande(@Argument("id") int id) {
        return surfwearService.deleteCommande(id);
    }

    /*================================================================================*/
    /* INVENTAIRE */
    /**
     * This method returns all inventaires.
     * @return List<DetailCommande>
     */
    @QueryMapping
    public List<Inventaire> getAllInventaires() {
        return surfwearService.getAllInventaires();
    }


    /**
     * This method returns an inventaire by ID.
     * @param id int
     * @return Inventaire
     */
    @QueryMapping
    public Inventaire getInventaireById(@Argument("id") int id) {
        return surfwearService.getInventaireById(id);
    }


    /**
     * This method creates a new inventaire.
     * @param article Article
     * @param qteStock int
     * @param qteReserve int
     * @return Inventaire
     */
    @QueryMapping
    public Inventaire createInventaire(
        @Argument("article") Article article,
        @Argument("qteStock") int qteStock,
        @Argument("qteReserve") int qteReserve
    ) {
        return surfwearService.createInventaire(article, qteStock, qteReserve);
    }


    /**
     * This method updates an existing inventaire.
     * @param id int
     * @param article Article
     * @param qteStock int
     * @param qteReserve int
     * @return Inventaire
     */
    @QueryMapping
    public Inventaire updateInventaire(
        @Argument("id") int id,
        @Argument("article") Article article,
        @Argument("qteStock") int qteStock,
        @Argument("qteReserve") int qteReserve
    ) {
        return surfwearService.updateInventaire(id, article, qteStock, qteReserve);
    }


    /**
     * This method deletes an inventaire.
     * @param id int
     * @return Boolean
     */
    @QueryMapping
    public Boolean deleteInventaire(@Argument("id") int id) {
        return surfwearService.deleteInventaire(id);
    }

    /*================================================================================*/
    /* PAIEMENT */
    /**
     * This method returns all paiements.
     * @return List<Paiement>
     */
    @QueryMapping
    public List<Paiement> getAllPaiements() {
        return surfwearService.getAllPaiements();
    }


    /**
     * This method returns a paiement by ID.
     * @param id int
     * @return Paiement
     */
    @QueryMapping
    public Paiement getPaiementById(@Argument("id") int id) {
        return surfwearService.getPaiementById(id);
    }


    /**
     * This method creates a new paiement.
     * @param commande Commande
     * @param montant double
     * @param methode String
     * @param datePaiement Date
     * @return Paiement
     */
    @QueryMapping
    public Paiement createPaiement(
        @Argument("commande") Commande commande,
        @Argument("montant") double montant,
        @Argument("methode") String methode,
        @Argument("datePaiement") Date datePaiement
    ) {
        return surfwearService.createPaiement(commande, montant, methode, datePaiement);
    }


    /**
     * This method updates an existing paiement.
     * @param id int
     * @param montant double
     * @param methode String
     * @param date Date
     * @return Paiement
     */
    @QueryMapping
    public Paiement updatePaiement(
        @Argument("id") int id,
        @Argument("montant") float montant,
        @Argument("methode") String methode,
        @Argument("date") Date date
    ) {
        return surfwearService.updatePaiement(id, montant,methode, date);
    }


    /**
     * This method deletes a paiement.
     * @param id int
     * @return Boolean
     */
    @QueryMapping
    public Boolean deletePaiement(@Argument("id") int id) {
        return surfwearService.deletePaiement(id);
    }
}
