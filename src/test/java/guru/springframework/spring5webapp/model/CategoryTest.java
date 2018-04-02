package guru.springframework.spring5webapp.model;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class CategoryTest {

    Category category;

    @Before
    public void setUp() {
        category = new Category();
    }

    @Test
    public void getId() throws Exception {
        Long idValue = 41L;
        category.setId(idValue);
        assertEquals(idValue,category.getId());
    }

    @Test
    public void getDescription() {
        String descriptionValue = "asdfrtfvtr/'%";
        category.setDescription(descriptionValue);
        assertEquals(descriptionValue,category.getDescription());
    }

    @Test
    public void getRecipes() {
        Set<Recipe> recipeValue = new HashSet<>();
        recipeValue.add(new Recipe());
        recipeValue.add(new Recipe());

        category.setRecipes(recipeValue);
        assertEquals(recipeValue,category.getRecipes());
    }

}