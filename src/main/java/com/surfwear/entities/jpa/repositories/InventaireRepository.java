package com.surfwear.entities.jpa.repositories;

import com.surfwear.entities.Article;
import com.surfwear.entities.Inventaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventaireRepository extends JpaRepository<Inventaire, Integer> {
    // Les méthodes CRUD de base sont déjà fournies par JpaRepository

    Optional<List<Inventaire>> findAllByArticle(Article article);

    Optional<Inventaire> findAllByArticleAndArticle_Categorie(Article article, int idCategorie);

}
