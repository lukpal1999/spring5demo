package guru.springframework.spring5webapp.services;

import guru.springframework.spring5webapp.model.Recipe;
import guru.springframework.spring5webapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getAllRecipesTest() throws Exception {
        Recipe recipe = new Recipe();
        Set<Recipe> recipeData = new HashSet<>();
        recipeData.add(recipe);

        when(recipeService.getAllRecipes()).thenReturn(recipeData);

        Set<Recipe> recipes = recipeService.getAllRecipes();

        assertEquals(recipeData.size(),1);

        verify(recipeRepository,times(1)).findAll();
    }

    @Test
    public void getRecipeByIdTest() throws Exception {
        Long recipeId = 100L;
        Recipe recipe = new Recipe();
        recipe.setId(recipeId);

        Optional<Recipe> optionalRecipe = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(optionalRecipe);

        Recipe recipeRerurned = recipeService.getRecipeById(recipeId);

        assertNotNull("Null recipe returned",recipeRerurned);
        assertEquals(recipeId,recipeRerurned.getId());
        verify(recipeRepository,times(1)).findById(anyLong());
        verify(recipeRepository,never()).findAll();
    }
}