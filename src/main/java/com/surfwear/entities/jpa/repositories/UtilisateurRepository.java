package com.surfwear.entities.jpa.repositories;

import com.surfwear.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    // Les méthodes CRUD de base sont déjà fournies par JpaRepository

}
