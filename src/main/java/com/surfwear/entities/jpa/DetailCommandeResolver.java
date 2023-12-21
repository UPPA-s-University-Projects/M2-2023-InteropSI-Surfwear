package com.surfwear.entities.jpa;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.surfwear.entities.DetailCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DetailCommandeResolver implements GraphQLResolver<DetailCommande> {

    private final SurfwearService surfwearService;

    @Autowired
    public DetailCommandeResolver(SurfwearService surfwearService) {
        this.surfwearService = surfwearService;
    }

    public List<DetailCommande> getAllDetailCommandes() {
        // Implémentez la méthode dans le service pour récupérer tous les détails de commande
        return surfwearService.getAllDetailCommandes();
    }

    public DetailCommande getDetailCommandeById(int id) {
        // Implémentez la méthode dans le service pour récupérer un détail de commande par son ID
        return surfwearService.getDetailCommandeById(id);
    }

    // Ajoutez d'autres méthodes si nécessaire, en fonction des opérations disponibles dans votre service pour DetailCommande
}
