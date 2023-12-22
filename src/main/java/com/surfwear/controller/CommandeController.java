package com.surfwear.controller;

import com.surfwear.entities.Article;
import com.surfwear.entities.Commande;
import com.surfwear.entities.DetailCommande;
import com.surfwear.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    private final CommandeService commandeService;


    @Autowired
    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping
    public ResponseEntity<List<Commande>> getAllCommandes() {
        return ResponseEntity.ok(commandeService.getAllCommandes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable int id) {
        Commande commande = commandeService.getCommandeById(id);
        if (commande != null) {
            return ResponseEntity.ok(commande);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Commande> createCommande(@RequestBody DetailCommande detailCommande,
                                                   @RequestParam Date dateCommande,
                                                   @RequestParam String status,
                                                   @RequestParam double total) {
        Commande newCommande = commandeService.createCommande(detailCommande, dateCommande, status, total);
        return ResponseEntity.ok(newCommande);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commande> updateCommande(@PathVariable int id,
                                                   @RequestBody DetailCommande detailCommande,
                                                   @RequestParam Date dateCommande,
                                                   @RequestParam String status,
                                                   @RequestParam double total) {
        Commande updatedCommande = commandeService.updateCommande(id, detailCommande, dateCommande, status, total);
        if (updatedCommande != null) {
            return ResponseEntity.ok(updatedCommande);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable int id) {
        boolean isDeleted = commandeService.deleteCommande(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/detailsCommande/{id}")
    public ResponseEntity<DetailCommande> getDetailsCommandeById(@PathVariable int id) {
        DetailCommande detailCommande = commandeService.getDetailCommandeById(id);
        if (detailCommande != null) {
            return ResponseEntity.ok(detailCommande);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/detailsCommande")
    public ResponseEntity<DetailCommande> createDetailCommande(@RequestBody Article article,
                                                               @RequestParam int qte,
                                                               @RequestParam double prix) {
        DetailCommande newDetailCommande = commandeService.createDetailCommande(article, qte, prix);
        return ResponseEntity.ok(newDetailCommande);
    }

    @PutMapping("/detailsCommande/{id}")
    public ResponseEntity<DetailCommande> updateDetailCommande(@PathVariable int id, @RequestBody Article article,
                                                               @RequestParam int qte,
                                                               @RequestParam double prix) {
        DetailCommande updatedDetailCommande = commandeService.updateDetailCommande(id, article, qte, prix);
        if (updatedDetailCommande != null) {
            return ResponseEntity.ok(updatedDetailCommande);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/detailsCommande/{id}")
    public ResponseEntity<Void> deleteDetailCommande(@PathVariable int id) {
        boolean isDeleted = commandeService.deleteDetailCommande(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Ajoutez d'autres méthodes si nécessaire...
}
