package com.prestoncoldwell.JavaProject;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Recipe> allRecipes() {
        return recipeRepository.findAll();
    }

    public Optional<Recipe> singleRecipe(UUID id) {
        return recipeRepository.findById(id);
    }

    public Recipe createRecipe(Recipe recipe) {
        recipe.setId(UUID.randomUUID());
        recipe.setCreatedAt(Instant.now());
        recipe.setUpdatedAt(Instant.now());
        return recipeRepository.save(recipe);
    }

    public Recipe updateRecipe(UUID id, Recipe updatedRecipe) {
        Optional<Recipe> existingRecipe = recipeRepository.findById(id);
        if (existingRecipe.isPresent()) {
            Recipe recipe = existingRecipe.get();
            BeanUtils.copyProperties(updatedRecipe, recipe, "id", "createdAt", "updatedAt");
            recipe.setUpdatedAt(Instant.now());
            return recipeRepository.save(recipe);
        } else {
            return null;
        }
    }

    public Recipe deleteRecipe(UUID id) {
        Optional<Recipe> existingRecipe = recipeRepository.findById(id);
        if (existingRecipe.isPresent()) {
            Query query = new Query();
            query.addCriteria(Criteria.where("recipeId").is(id));
            mongoTemplate.remove(query, Review.class);

            recipeRepository.deleteById(id);
            return existingRecipe.get();
        } else {
            return null;
        }
    }
}