package com.TacoCloud.TacoCloud.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.TacoCloud.TacoCloud.Domain.Entities.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
