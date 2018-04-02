package guru.springframework.spring5webapp.services;

import guru.springframework.spring5webapp.model.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getAllRecipes();
    Recipe getRecipeById(Long id);
}
