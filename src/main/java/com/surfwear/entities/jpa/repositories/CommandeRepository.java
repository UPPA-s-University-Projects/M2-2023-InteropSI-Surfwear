package com.surfwear.entities.jpa.repositories;

import com.surfwear.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {
    // Les méthodes CRUD de base sont déjà fournies par JpaRepository
}
