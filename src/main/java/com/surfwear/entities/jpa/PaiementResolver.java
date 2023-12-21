package com.surfwear.entities.jpa;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.surfwear.entities.Paiement;
import com.surfwear.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaiementResolver implements GraphQLResolver<Paiement> {

    private final CommandeService commandeService;

    @Autowired
    public PaiementResolver(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    public List<Paiement> getAllPaiements() {
        // Implémentez la méthode dans le service pour récupérer tous les paiements
        return commandeService.getAllPaiements();
    }

    public Paiement getPaiementById(int id) {
        // Implémentez la méthode dans le service pour récupérer un paiement par son ID
        return commandeService.getPaiementById(id);
    }

    // Ajoutez d'autres méthodes si nécessaire, en fonction des opérations disponibles dans votre service pour Paiement
}
