package com.surfwear.entities.jpa;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.surfwear.entities.Commande;
import com.surfwear.entities.DetailCommande;
import com.surfwear.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class CommandeResolver implements GraphQLResolver<Commande> {

    private final CommandeService commandeService;

    @Autowired
    public CommandeResolver(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }

    public Commande getCommandeById(int id) {
        return commandeService.getCommandeById(id);
    }

    public Commande createCommande(DetailCommande detailCommande, Date dateCommande, String status, double total) {
        return commandeService.createCommande(detailCommande, dateCommande, status, total);
    }

    public Commande updateCommande(int id, DetailCommande commande, Date dateCommande, String status, double total) {
        return commandeService.updateCommande(id, commande, dateCommande, status, total);
    }

    public Boolean deleteCommande(int id) {
        return commandeService.deleteCommande(id);
    }
}
