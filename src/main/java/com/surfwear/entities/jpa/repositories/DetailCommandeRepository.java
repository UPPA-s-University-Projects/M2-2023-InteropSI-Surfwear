package com.surfwear.entities.jpa.repositories;

import com.surfwear.entities.DetailCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailCommandeRepository extends JpaRepository<DetailCommande, Integer> {
    // Les méthodes CRUD de base sont déjà fournies par JpaRepository
}
