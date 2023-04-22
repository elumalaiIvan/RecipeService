package com.college.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecipeController {

  @Autowired
  RestTemplate restTemplate;

  @GetMapping("/recipe")
  ResponseEntity<MealDBRecipePreviewModel> getRecipeByIngredient(@RequestParam String ingredient) {
    String mealDBURL = "https://www.themealdb.com/api/json/v1/1/filter.php?i="+ingredient;
    return restTemplate.getForEntity(mealDBURL, MealDBRecipePreviewModel.class);
  }
  @GetMapping("/ingredients")
  ResponseEntity<List<String>> getIngredients() {
    List<String> ingredients = List.of("egg, milk, chicken, mutton");
    return ResponseEntity.ok(ingredients);
  }
}
