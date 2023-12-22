package com.surfwear.entities.jpa;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.surfwear.entities.DetailCommande;
import com.surfwear.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DetailCommandeResolver implements GraphQLResolver<DetailCommande> {

    private final CommandeService commandeService;

    @Autowired
    public DetailCommandeResolver(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    public List<DetailCommande> getAllDetailCommandes() {
        // Implémentez la méthode dans le service pour récupérer tous les détails de commande
        return commandeService.getAllDetailCommande();
    }

    public DetailCommande getDetailCommandeById(int id) {
        // Implémentez la méthode dans le service pour récupérer un détail de commande par son ID
        return commandeService.getDetailCommandeById(id);
    }

    // Ajoutez d'autres méthodes si nécessaire, en fonction des opérations disponibles dans votre service pour DetailCommande
}
