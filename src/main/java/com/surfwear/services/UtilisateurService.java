package com.surfwear.services;

import com.surfwear.entities.Utilisateur;
import com.surfwear.entities.jpa.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;
    private final AtomicInteger userIdCounter = new AtomicInteger(1);

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur getUtilisateurById(int id) {
        return utilisateurRepository.findById(id).orElse(null);
    }

    public Utilisateur createUtilisateur(String nom, String email, String password, String role) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUtilisateurId(userIdCounter.getAndIncrement());
        utilisateur.setNom(nom);
        utilisateur.setEmail(email);
        utilisateur.setPassword(password);
        utilisateur.setRole(role);
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur updateUtilisateur(int id, String nom, String email, String password, String role) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElse(null);
        if (utilisateur != null) {
            utilisateur.setNom(nom);

            utilisateur.setEmail(email);
            utilisateur.setPassword(password);

            utilisateur.setRole(role);
            return utilisateurRepository.save(utilisateur);
        }
        return null;
    }

    public boolean deleteUtilisateur(int id) {
        if (utilisateurRepository.existsById(id)) {
            utilisateurRepository.deleteById(id);
            return true;
        }
        return false;
    }

}