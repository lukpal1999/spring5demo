package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
}
