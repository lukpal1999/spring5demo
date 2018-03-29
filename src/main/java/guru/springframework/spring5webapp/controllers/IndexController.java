package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.bootstrap.RecipeBootstrap;
import guru.springframework.spring5webapp.model.Category;
import guru.springframework.spring5webapp.model.UnitOfMeasure;
import guru.springframework.spring5webapp.repositories.CategoryRepository;
import guru.springframework.spring5webapp.repositories.RecipeRepository;
import guru.springframework.spring5webapp.repositories.UnitOfMeasureRepository;
import guru.springframework.spring5webapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model) {
        model.addAttribute("recipes", recipeService.getAllRecipes());
        return "index";
    }
}
