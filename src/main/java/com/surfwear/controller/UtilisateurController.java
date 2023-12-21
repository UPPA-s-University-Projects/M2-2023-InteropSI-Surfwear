package com.surfwear.controller;

import com.surfwear.entities.Utilisateur;
import com.surfwear.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    @GetMapping("/{id}")
    public Utilisateur getUtilisateurById(@PathVariable int id) {
        return utilisateurService.getUtilisateurById(id);
    }

    @PostMapping
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.createUtilisateur(utilisateur.getNom(), utilisateur.getEmail(), utilisateur.getPassword(), utilisateur.getRole());
    }

    @PutMapping("/{id}")
    public Utilisateur updateUtilisateur(@PathVariable int id, @RequestBody Utilisateur utilisateur) {
        return utilisateurService.updateUtilisateur(id, utilisateur.getNom(), utilisateur.getEmail(), utilisateur.getPassword(), utilisateur.getRole());
    }

    @DeleteMapping("/{id}")
    public boolean deleteUtilisateur(@PathVariable int id) {
        return utilisateurService.deleteUtilisateur(id);
    }
}
