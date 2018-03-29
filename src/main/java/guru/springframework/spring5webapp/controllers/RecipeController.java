package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.RecipeRepository;
import org.springframework.stereotype.Controller;

@Controller
public class  RecipeController {
    private RecipeRepository recipeRepository;

    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }
}
