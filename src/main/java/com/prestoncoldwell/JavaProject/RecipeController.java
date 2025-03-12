package com.prestoncoldwell.JavaProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/recipes")
public class RecipeController {
    private static final Logger logger = Logger.getLogger(RecipeController.class.getName());

    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        return new ResponseEntity<List<Recipe>>(recipeService.allRecipes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Recipe>> getRecipeById(@PathVariable UUID id) {
        Optional<Recipe> recipe = recipeService.singleRecipe(id);
        if (recipe.isPresent()) {
            return new ResponseEntity<Optional<Recipe>>(recipe, HttpStatus.OK);
        } else {
            return new ResponseEntity<Optional<Recipe>>(HttpStatus.NOT_FOUND);
        }
    }
}