package com.surfwear.entities.jpa.repositories;

import com.surfwear.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
