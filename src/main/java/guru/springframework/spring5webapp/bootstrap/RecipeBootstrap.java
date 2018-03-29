package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.*;
import guru.springframework.spring5webapp.repositories.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private RecipeRepository recipeRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private CategoryRepository categoryRepository;

    public RecipeBootstrap(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<Recipe>(2);

        //Unit of Measure
        Optional<UnitOfMeasure> cloveOptional = unitOfMeasureRepository.findByDescription("clove");

        if (!cloveOptional.isPresent()) {
            throw new RuntimeException("Excpected UOM clove");
        }

        Optional<UnitOfMeasure> teaspoonOptional = unitOfMeasureRepository.findByDescription("teaspoon");
        if (!teaspoonOptional.isPresent()) {
            throw new RuntimeException("Expected UOM teaspoon");
        }

        UnitOfMeasure clove = cloveOptional.get();
        UnitOfMeasure teaspoon = teaspoonOptional.get();

        //Categories
        Optional<Category> mexicanOptional = categoryRepository.findByDescription("Mexican");

        if (!mexicanOptional.isPresent()) {
            throw new RuntimeException("Expected Category Mexican");
        }

        Optional<Category> polishOptional = categoryRepository.findByDescription("Polish");
        if (!polishOptional.isPresent()) {
            throw new RuntimeException("Expected Category Polish");
        }

        Category polishCategory = polishOptional.get();
        Category mexicanCategory = mexicanOptional.get();

        //Chicken
        Recipe chickenRecipe = new Recipe();

        //Chicken Ingredients
        Ingredient chickenIngredientOne = new Ingredient("Garlic",new BigDecimal(100),chickenRecipe,clove);
        Ingredient chickenIngredientTwo = new Ingredient("Dried Cumin", new BigDecimal(2),chickenRecipe,teaspoon);

        chickenRecipe.setDescription("Spicy Grilled Chicken ");
        chickenRecipe.setCookTime(10);
        chickenRecipe.setPrepTime(15);
        chickenRecipe.setServings(2);
        chickenRecipe.setSource("Simply Recipes");
        chickenRecipe.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        chickenRecipe.setDifficulty(Difficulty.MODERATE);
        chickenRecipe.getCategories().add(polishCategory);
        chickenRecipe.setDirections("Look for ancho chile powder with the Mexican ingredients at your grocery store, on buy it online.");
        chickenRecipe.getIngredients().add(chickenIngredientOne);
        chickenRecipe.getIngredients().add(chickenIngredientTwo);

        Note chickenNote = new Note(chickenRecipe,"The ancho chiles I use in the marinade are named for their wide shape. They are large, have a deep reddish brown color when dried, and are mild in flavor with just a hint of heat. You can find ancho chile powder at any markets that sell Mexican ingredients, or online.\n" +
                "\n" +
                "I like to put all the toppings in little bowls on a big platter at the center of the table: avocados, radishes, tomatoes, red onions, wedges of lime, and a sour cream sauce. I add arugula, as well – this green isn’t traditional for tacos, but we always seem to have some in the fridge and I think it adds a nice green crunch to the tacos.\n" +
                "\n" +
                "Everyone can grab a warm tortilla from the pile and make their own tacos just they way they like them.\n" +
                "\n" +
                "You could also easily double or even triple this recipe for a larger party. A taco and a cold beer on a warm day? Now that’s living!");

        chickenRecipe.setNote(chickenNote);

        //Guacamole
        Recipe guacamoleRecipe = new Recipe();

        //Guacamole Ingredients
        Ingredient guacamoleIngredientOne = new Ingredient("Garlic",new BigDecimal(100),guacamoleRecipe,clove);
        Ingredient guacamoleIngredientTwo = new Ingredient("Dried Cumin", new BigDecimal(2),guacamoleRecipe,teaspoon);

        guacamoleRecipe.setDescription("Guacamole");
        guacamoleRecipe.setCookTime(7);
        guacamoleRecipe.setPrepTime(55);
        guacamoleRecipe.setServings(7);
        guacamoleRecipe.setSource("Simply Recipes");
        guacamoleRecipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamoleRecipe.setDifficulty(Difficulty.HARD);
        guacamoleRecipe.getCategories().add(mexicanCategory);
        guacamoleRecipe.getCategories().add(polishCategory);
        guacamoleRecipe.setDirections("All you really need to make guacamole is ripe avocados and salt. After that, a little lime or lemon juice");
        guacamoleRecipe.getIngredients().add(chickenIngredientOne);
        guacamoleRecipe.getIngredients().add(chickenIngredientTwo);

        Note guacamoleNote = new Note(guacamoleRecipe,"Guacamole, a dip made from avocados, is originally from Mexico. The name is derived from two Aztec Nahuatl words—ahuacatl (avocado) and molli (sauce).\n" +
                "\n" +
                "All you really need to make guacamole is ripe avocados and salt. After that, a little lime or lemon juice—a splash of acidity— will help to balance the richness of the avocado. Then if you want, add chopped cilantro, chiles, onion, and/or tomato.\n" +
                "\n" +
                "The trick to making perfect guacamole is using good, ripe avocados.\n" +
                "\n" +
                "Check for ripeness by gently pressing the outside of the avocado. If there is no give, the avocado is not ripe yet and will not taste good. If there is a little give, the avocado is ripe. If there is a lot of give, the avocado may be past ripe and not good. In this case, taste test first before using.The ancho chiles I use in the marinade are named for their wide shape. They are large, have a deep reddish brown color when dried, and are mild in flavor with just a hint of heat. You can find ancho chile powder at any markets that sell Mexican ingredients, or online.\n" +
                "\n" +
                "I like to put all the toppings in little bowls on a big platter at the center of the table: avocados, radishes, tomatoes, red onions, wedges of lime, and a sour cream sauce. I add arugula, as well – this green isn’t traditional for tacos, but we always seem to have some in the fridge and I think it adds a nice green crunch to the tacos.\n" +
                "\n" +
                "Everyone can grab a warm tortilla from the pile and make their own tacos just they way they like them.\n" +
                "\n" +
                "You could also easily double or even triple this recipe for a larger party. A taco and a cold beer on a warm day? Now that’s living!");

        guacamoleRecipe.setNote(guacamoleNote);

        recipes.add(chickenRecipe);
        recipes.add(guacamoleRecipe);

        return recipes;
    }
}
