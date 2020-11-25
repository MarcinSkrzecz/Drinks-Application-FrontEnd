package com.kodilla.drinks_frontend.ingredients;

import com.kodilla.drinks_frontend.connectionsToBackend.IngredientsConnections;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IngredientsService {

    @Autowired
    private IngredientsConnections ingredientsConnections;

    private Set<Ingredients> ingredients;
    private static IngredientsService ingredientsService;

    private IngredientsService() {
        this.ingredients = exampleData();
    }

    public static IngredientsService getInstance() {
        if (ingredientsService == null) {
            ingredientsService = new IngredientsService();
        }
        return ingredientsService;
    }

    public Set getIngredients() {
        return new HashSet<>(ingredients);
    }

    public Set exampleData() {
        Set ingredients = new HashSet();
        ingredients.add(new Ingredients(1L,"Piwo", 6));
        return ingredients;
    }

    //Backend - not working
    public Set backend() {
        List<Ingredients> backend = ingredientsConnections.getAllIngredientsList();
        Set ingredients = new HashSet(backend);
        return ingredients;
    }

    public Set findByDescription(String description) {
        return ingredients.stream().filter(drink -> drink.getDescription().contains(description)).collect(Collectors.toSet());
    }
}