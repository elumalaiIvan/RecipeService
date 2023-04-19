package com.college.recipe;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RecipeController {
  @GetMapping
  ResponseEntity<String> getRecipeByIngredients(@RequestParam String ingredients) {
    return ResponseEntity.ok("working" + ingredients);
  }
}
