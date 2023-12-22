package com.surfwear.entities.jpa.repositories;

import com.surfwear.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    // Les méthodes CRUD de base sont déjà fournies par JpaRepository
}
