package com.surfwear.entities.jpa.repositories;

import com.surfwear.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {
}
