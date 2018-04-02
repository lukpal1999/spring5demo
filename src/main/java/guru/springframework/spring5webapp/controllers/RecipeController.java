package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.RecipeRepository;
import guru.springframework.spring5webapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class  RecipeController {
    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String GetRecipe(@PathVariable String id, Model model) {
        model.addAttribute("recipe",recipeService.getRecipeById(new Long(id)));
        return "recipe/show";
    }
}
