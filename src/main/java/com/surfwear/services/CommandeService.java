package com.surfwear.services;

import com.surfwear.entities.Article;
import com.surfwear.entities.Commande;
import com.surfwear.entities.DetailCommande;
import com.surfwear.entities.Paiement;
import com.surfwear.entities.jpa.repositories.CommandeRepository;
import com.surfwear.entities.jpa.repositories.DetailCommandeRepository;
import com.surfwear.entities.jpa.repositories.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommandeService {

    private final CommandeRepository commandeRepository;
    private final DetailCommandeRepository detailCommandeRepository;

    private final PaiementRepository PaiementRepository;

    @Autowired
    public CommandeService(CommandeRepository commandeRepository, DetailCommandeRepository detailCommandeRepository, PaiementRepository PaiementRepository) {
        this.commandeRepository = commandeRepository;
        this.detailCommandeRepository = detailCommandeRepository;
        this.PaiementRepository = PaiementRepository;
    }

    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    public Commande getCommandeById(int id) {
        return commandeRepository.findById(id).orElse(null);
    }

    public Commande createCommande(DetailCommande detailCommande, Date dateCommande, String status, double total) {
        Commande commande = new Commande();
        commande.setDetailCommande(detailCommande);
        commande.setDateCommande(dateCommande);
        commande.setStatus(status);
        commande.setTotal(total);
        return commandeRepository.save(commande);
    }

    public Commande updateCommande(int id, DetailCommande detailCommande, Date dateCommande, String status, double total) {
        Commande commande = commandeRepository.findById(id).orElse(null);
        if (commande != null) {
            commande.setDetailCommande(detailCommande);
            commande.setDateCommande(dateCommande);
            commande.setStatus(status);
            commande.setTotal(total);
            return commandeRepository.save(commande);
        }
        return null;
    }

    public boolean deleteCommande(int id) {
        if (commandeRepository.existsById(id)) {
            commandeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Paiement> getAllPaiement() {
        return PaiementRepository.findAll();
    }

    public Paiement getPaiementById(int id) {
        return PaiementRepository.findById(id).orElse(null);
    }

    public Paiement createPaiement(Commande commande, double montant, String methode, Date datePaiement) {
        Paiement paiement = new Paiement();
        paiement.setCommande(commande);
        paiement.setMontant(montant);
        paiement.setMethode(methode);
        paiement.setDatePaiement(datePaiement);
        return PaiementRepository.save(paiement);
    }

    public Paiement updatePaiement(int id, Commande commande, double montant, String methode, Date datePaiement) {
        Paiement paiement = PaiementRepository.findById(id).orElse(null);
        if (paiement != null) {
            paiement.setPaiementId(id);
            paiement.setCommande(commande);
            paiement.setMontant(montant);
            paiement.setMethode(methode);
            paiement.setDatePaiement(datePaiement);
        }
        return null;
    }

    public boolean deletePaiement(int id) {
        if (PaiementRepository.existsById(id)) {
            PaiementRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<DetailCommande> getAllDetailCommande() {
        return detailCommandeRepository.findAll();
    }

    public DetailCommande getDetailCommandeById(int id) {
        return detailCommandeRepository.findById(id).orElse(null);
    }

    public DetailCommande createDetailCommande(Article article, int qte, double prixUnitaire) {
        DetailCommande detailCommande = new DetailCommande();

        detailCommande.setArticle(article);
        detailCommande.setQte(qte);
        detailCommande.setPrixUnitaire(prixUnitaire);

        return detailCommandeRepository.save(detailCommande);
    }

    public DetailCommande updateDetailCommande(int id, Article article, int qte, double prixUnitaire) {
        DetailCommande detailCommande = detailCommandeRepository.findById(id).orElse(null);
        if (detailCommande != null) {
            detailCommande.setDetailCommandeId(id);
            detailCommande.setArticle(article);
            detailCommande.setQte(qte);
            detailCommande.setPrixUnitaire(prixUnitaire);
        }
        return null;
    }

    public boolean deleteDetailCommande(int id) {
        if (detailCommandeRepository.existsById(id)) {
            detailCommandeRepository.deleteById(id);
            return true;
        }
        return false;
    }


    // Autres méthodes pour la gestion spécifique des commandes...
}
