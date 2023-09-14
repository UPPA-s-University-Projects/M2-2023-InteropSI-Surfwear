package com.example.graphql;

import com.example.graphql.entities.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLController {

    @Autowired
    private GraphQLService graphQLService;

    @QueryMapping
    public List<Articles> getAllArticles() {
        return graphQLService.getAllArticles();
    }

    @QueryMapping
    public Articles getArticlesById(@Argument("id") String id) {
        return graphQLService.getArticlesById(id).orElse(null);
    }

    @MutationMapping
    public Articles createArticles(@Argument("title") String title, @Argument("articleId") String articleId) {
        return graphQLService.createArticles(title, articleId);
    }

    @MutationMapping
    public Articles updateArticles(@Argument("id") String id, @Argument("title") String title) {
        return graphQLService.updateArticles(id, title);
    }

    @MutationMapping
    public Boolean deleteArticles(@Argument("id") String id) {
        return graphQLService.deleteArticles(id);
    }

}
