package com.surfwear.entities.jpa.repositories;

import com.surfwear.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Integer> {
    // Les méthodes CRUD de base sont déjà fournies par JpaRepository
}
