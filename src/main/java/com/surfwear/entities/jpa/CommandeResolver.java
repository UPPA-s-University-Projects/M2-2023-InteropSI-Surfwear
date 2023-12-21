package com.surfwear.entities.jpa;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.surfwear.entities.Commande;
import com.surfwear.entities.DetailCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class CommandeResolver implements GraphQLResolver<Commande> {

    private final SurfwearService surfwearService;

    @Autowired
    public CommandeResolver(SurfwearService surfwearService) {
        this.surfwearService = surfwearService;
    }

    public List<Commande> getAllCommandes() {
        return surfwearService.getAllCommandes();
    }

    public Commande getCommandeById(int id) {
        return surfwearService.getCommandeById(id);
    }

    public Commande createCommande(DetailCommande detailCommande, Date dateCommande, String status, double total) {
        return surfwearService.createCommande(detailCommande, dateCommande, status, total);
    }

    public Commande updateCommande(int id, DetailCommande commande, Date dateCommande, String status, double total) {
        return surfwearService.updateCommande(id, commande, dateCommande, status, total);
    }

    public Boolean deleteCommande(int id) {
        return surfwearService.deleteCommande(id);
    }
}
