package com.surfwear.entities.jpa;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.surfwear.entities.Categorie;
import com.surfwear.services.InventaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategorieResolver implements GraphQLResolver<Categorie> {

    private final InventaireService inventaireService;

    @Autowired
    public CategorieResolver(InventaireService inventaireService) {
        this.inventaireService = inventaireService;
    }

    public List<Categorie> getAllCategories() {
        return inventaireService.getAllCategorie();
    }

    public Categorie getCategorieById(int id) {
        return inventaireService.getCategorieById(id);
    }

    public Categorie createCategorie(String nomCategorie, String description) {
        return inventaireService.createCategorie(nomCategorie, description);
    }

    public Categorie updateCategorie(int id, String nomCategorie, String description) {
        return inventaireService.updateCategorie(id, nomCategorie, description);
    }

    public Boolean deleteCategorie(int id) {
        return inventaireService.deleteCategorie(id);
    }
}
