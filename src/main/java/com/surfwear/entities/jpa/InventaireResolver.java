package com.surfwear.entities.jpa;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.surfwear.entities.Inventaire;
import com.surfwear.services.InventaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InventaireResolver implements GraphQLResolver<Inventaire> {

    private final InventaireService inventaireService;

    @Autowired
    public InventaireResolver(InventaireService inventaireService) {
        this.inventaireService = inventaireService;
    }

    public List<Inventaire> getAllInventaires() {
        // Implémentez la méthode dans le service pour récupérer tous les inventaires
        return inventaireService.getAllInventaires();
    }

    public Inventaire getInventaireById(int id) {
        // Implémentez la méthode dans le service pour récupérer un inventaire par son ID
        return inventaireService.getInventaireById(id);
    }

    // Ajoutez d'autres méthodes si nécessaire, en fonction des opérations disponibles dans votre service pour Inventaire
}
