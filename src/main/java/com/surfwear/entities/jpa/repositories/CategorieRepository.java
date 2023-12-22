package com.surfwear.entities.jpa.repositories;

import com.surfwear.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
    // Les méthodes CRUD de base sont déjà fournies par JpaRepository
}
