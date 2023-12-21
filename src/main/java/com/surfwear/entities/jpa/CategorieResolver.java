package com.surfwear.entities.jpa;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.surfwear.entities.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategorieResolver implements GraphQLResolver<Categorie> {

    private final SurfwearService surfwearService;

    @Autowired
    public CategorieResolver(SurfwearService surfwearService) {
        this.surfwearService = surfwearService;
    }

    public List<Categorie> getAllCategories() {
        return surfwearService.getAllCategories();
    }

    public Categorie getCategorieById(int id) {
        return surfwearService.getCategorieById(id);
    }

    public Categorie createCategorie(String nomCategorie, String description) {
        return surfwearService.createCategorie(nomCategorie, description);
    }

    public Categorie updateCategorie(int id, String nomCategorie, String description) {
        return surfwearService.updateCategorie(id, nomCategorie, description);
    }

    public Boolean deleteCategorie(int id) {
        return surfwearService.deleteCategorie(id);
    }
}
