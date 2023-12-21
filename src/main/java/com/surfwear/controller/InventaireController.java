package com.surfwear.controller;

import com.surfwear.entities.Article;
import com.surfwear.entities.Inventaire;
import com.surfwear.services.InventaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventaires")
public class InventaireController {

    private final InventaireService inventaireService;

    @Autowired
    public InventaireController(InventaireService inventaireService) {
        this.inventaireService = inventaireService;
    }

    @GetMapping
    public ResponseEntity<List<Inventaire>> getAllInventaires() {
        return ResponseEntity.ok(inventaireService.getAllInventaires());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventaire> getInventaireById(@PathVariable int id) {
        Inventaire inventaire = inventaireService.getInventaireById(id);
        if (inventaire != null) {
            return ResponseEntity.ok(inventaire);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Inventaire> createInventaire(@RequestBody Article article,
                                                       @RequestParam int qteStock,
                                                       @RequestParam int qteReserve) {
        Inventaire newInventaire = inventaireService.createInventaire(article, qteStock, qteReserve);
        return ResponseEntity.ok(newInventaire);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventaire> updateInventaire(@PathVariable int id, @RequestBody Article article,
                                                       @RequestParam int qteStock,
                                                       @RequestParam int qteReserve) {
        Inventaire updatedInventaire = inventaireService.updateInventaire(id, article, qteStock, qteReserve);
        if (updatedInventaire != null) {
            return ResponseEntity.ok(updatedInventaire);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventaire(@PathVariable int id) {
        boolean isDeleted = inventaireService.deleteInventaire(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Ajoutez d'autres méthodes au besoin...
}
