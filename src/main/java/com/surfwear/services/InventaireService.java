package com.surfwear.services;

import com.surfwear.entities.Article;
import com.surfwear.entities.Categorie;
import com.surfwear.entities.Inventaire;
import com.surfwear.entities.jpa.repositories.ArticleRepository;
import com.surfwear.entities.jpa.repositories.CategorieRepository;
import com.surfwear.entities.jpa.repositories.InventaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventaireService {

    private final InventaireRepository inventaireRepository;
    private final ArticleRepository articleRepository;

    private final CategorieRepository categorieRepository;

    @Autowired
    public InventaireService(InventaireRepository inventaireRepository, ArticleRepository articleRepository, CategorieRepository categorieRepository) {
        this.inventaireRepository = inventaireRepository;
        this.articleRepository = articleRepository;
        this.categorieRepository = categorieRepository;
    }

    public List<Inventaire> getAllInventaires() {
        return inventaireRepository.findAll();
    }

    public Inventaire getInventaireById(int id) {
        return inventaireRepository.findById(id).orElse(null);
    }

    public Inventaire createInventaire(Article article, int qteStock, int qteReserve) {
        Inventaire inventaire = new Inventaire();
        inventaire.setArticle(article);
        inventaire.setQteStock(qteStock);
        inventaire.setQteReserve(qteReserve);
        return inventaireRepository.save(inventaire);
    }

    public Inventaire updateInventaire(int id, Article article, int qteStock, int qteReserve) {
        Inventaire inventaire = inventaireRepository.findById(id).orElse(null);
        if (inventaire != null) {
            inventaire.setArticle(article);
            inventaire.setQteStock(qteStock);
            inventaire.setQteReserve(qteReserve);
            return inventaireRepository.save(inventaire);
        }
        return null;
    }

    public boolean deleteInventaire(int id) {
        if (inventaireRepository.existsById(id)) {
            inventaireRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Inventaire> getAllInventairesByCategorie(int id) {
        Categorie categorie = categorieRepository.findById(id).orElse(null);
        if (categorie != null) {
            return inventaireRepository.findAllByArticle_Categorie(categorie);
        }
        return null;
    }

    public List<Inventaire> getAllInventairesByArticle(int id) {
        Article article = articleRepository.findById(id).orElse(null);
        if (article != null) {
            return inventaireRepository.findAllByArticle(article);
        }
        return null;
    }

    public List<Inventaire> getAllInventairesByArticleAndCategorie(int idArticle, int idCategorie) {
        Article article = articleRepository.findById(idArticle).orElse(null);
        Categorie categorie = categorieRepository.findById(idCategorie).orElse(null);
        if (article != null && categorie != null) {
            return inventaireRepository.findAllByArticleAndArticle_Categorie(article, categorie);
        }
        return null;
    }

    public Inventaire getInventaireByArticleAndCategorie(int idArticle, int idCategorie) {
        Article article = articleRepository.findById(idArticle).orElse(null);
        Categorie categorie = categorieRepository.findById(idCategorie).orElse(null);
        if (article != null && categorie != null) {
            return inventaireRepository.findByArticleAndArticle_Categorie(article, categorie);
        }
        return null;
    }

    public Article getArticleByInventaire(int id) {
        Inventaire inventaire = inventaireRepository.findById(id).orElse(null);
        if (inventaire != null) {
            return inventaire.getArticle();
        }
        return null;
    }

    public Categorie getCategorieByInventaire(int id) {
        Inventaire inventaire = inventaireRepository.findById(id).orElse(null);
        if (inventaire != null) {
            return inventaire.getArticle().getCategorie();
        }
        return null;
    }

    public int getQteStockByInventaire(int id) {
        Inventaire inventaire = inventaireRepository.findById(id).orElse(null);
        if (inventaire != null) {
            return inventaire.getQteStock();
        }
        return -1;
    }

    public int getQteReserveByInventaire(int id) {
        Inventaire inventaire = inventaireRepository.findById(id).orElse(null);
        if (inventaire != null) {
            return inventaire.getQteReserve();
        }
        return -1;
    }

    public int getQteDisponibleByInventaire(int id) {
        Inventaire inventaire = inventaireRepository.findById(id).orElse(null);
        if (inventaire != null) {
            return inventaire.getQteStock() - inventaire.getQteReserve();
        }
        return -1;
    }

    public int getQteStockByArticle(int idArticle) {
        Article article = articleRepository.findById(idArticle).orElse(null);
        if (article != null) {
            return inventaireRepository.findAllByArticle(article).stream().mapToInt(Inventaire::getQteStock).sum();
        }
        return -1;
    }

    public int getQteReserveByArticle(int idArticle) {
        Article article = articleRepository.findById(idArticle).orElse(null);
        if (article != null) {
            return inventaireRepository.findAllByArticle(article).stream().mapToInt(Inventaire::getQteReserve).sum();
        }
        return -1;
    }

    public int getQteDisponibleByArticle(int idArticle) {
        Article article = articleRepository.findById(idArticle).orElse(null);
        if (article != null) {
            return getQteStockByArticle(idArticle) - getQteReserveByArticle(idArticle);
        }
        return -1;
    }

    public Article createArticle(String nom, String description, float prix, int idCategorie) {
        Categorie categorie = categorieRepository.findById(idCategorie).orElse(null);
        if (categorie != null) {
            Article article = new Article();
            article.setNom(nom);
            article.setDescription(description);
            article.setPrix(prix);
            article.setCategorie(categorie);
            return articleRepository.save(article);
        }
        return null;
    }

    public Article updateArticle(int idArticle, String nom, String description, float prix, int idCategorie) {
        Article article = articleRepository.findById(idArticle).orElse(null);
        Categorie categorie = categorieRepository.findById(idCategorie).orElse(null);
        if (article != null && categorie != null) {
            article.setNom(nom);
            article.setDescription(description);
            article.setPrix(prix);
            article.setCategorie(categorie);
            return articleRepository.save(article);
        }
        return null;
    }

    public Article deleteArticle(int idArticle) {
        Article article = articleRepository.findById(idArticle).orElse(null);
        if (article != null) {
            articleRepository.deleteById(idArticle);
            return article;
        }
        return null;
    }

    public Categorie createCategorie(String nomCategorie, String description) {
        Categorie categorie = new Categorie();
        categorie.setNomCategorie(nomCategorie);
        categorie.setDescription(description);
        return categorieRepository.save(categorie);
    }

    public Categorie updateCategorie(int id, String nomCategorie, String description) {
        Categorie categorie = categorieRepository.findById(id).orElse(null);
        if (categorie != null) {
            categorie.setNomCategorie(nomCategorie);
            categorie.setDescription(description);
            return categorieRepository.save(categorie);
        }
        return null;
    }

    public boolean deleteCategorie(int id) {
        if (categorieRepository.existsById(id)) {
            categorieRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Categorie> getAllCategorie() {
        return categorieRepository.findAll();
    }

    public Categorie getCategorieById(int id) {
        return categorieRepository.findById(id).orElse(null);
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article getArticleById(int id) {
        return articleRepository.findById(id).orElse(null);
    }



    // Autres méthodes spécifiques à la gestion des inventaires et des articles...
}