package com.surfwear.entities.jpa;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.surfwear.entities.Utilisateur;
import com.surfwear.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UtilisateurResolver implements GraphQLResolver<Utilisateur> {

    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurResolver(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    public List<Utilisateur> getAllUsers() {
        // Implémentez la méthode dans le service pour récupérer tous les utilisateurs
        return utilisateurService.getAllUtilisateurs();
    }

    public Utilisateur getUserById(int id) {
        // Implémentez la méthode dans le service pour récupérer un utilisateur par son ID
        return utilisateurService.getUtilisateurById(id);
    }

    public Utilisateur createUser(String name, String email, String password, String role) {
        // Implémentez la méthode dans le service pour créer un nouvel utilisateur
        return utilisateurService.createUtilisateur(name, email, password, role);
    }

    public Utilisateur updateUser(int id, String name, String email, String password, String role) {
        // Implémentez la méthode dans le service pour mettre à jour un utilisateur existant
        return utilisateurService.updateUtilisateur(id, name, email, password, role);
    }

    public Boolean deleteUser(int id) {
        // Implémentez la méthode dans le service pour supprimer un utilisateur
        return utilisateurService.deleteUtilisateur(id);
    }

    // Ajoutez d'autres méthodes si nécessaire, en fonction des opérations disponibles dans votre service pour Utilisateur
}
