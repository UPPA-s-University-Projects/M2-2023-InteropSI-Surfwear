package com.surfwear.entities.jpa;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.surfwear.entities.Inventaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InventaireResolver implements GraphQLResolver<Inventaire> {

    private final SurfwearService surfwearService;

    @Autowired
    public InventaireResolver(SurfwearService surfwearService) {
        this.surfwearService = surfwearService;
    }

    public List<Inventaire> getAllInventaires() {
        // Implémentez la méthode dans le service pour récupérer tous les inventaires
        return surfwearService.getAllInventaires();
    }

    public Inventaire getInventaireById(int id) {
        // Implémentez la méthode dans le service pour récupérer un inventaire par son ID
        return surfwearService.getInventaireById(id);
    }

    // Ajoutez d'autres méthodes si nécessaire, en fonction des opérations disponibles dans votre service pour Inventaire
}
