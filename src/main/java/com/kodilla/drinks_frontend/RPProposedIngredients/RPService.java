package com.kodilla.drinks_frontend.RPProposedIngredients;

import com.kodilla.drinks_frontend.connectionsToBackend.RPProposedIngredientsConnections;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RPService {

    @Autowired
    private RPProposedIngredientsConnections rpProposedIngredientsConnections;

    private Set<RPIngredients> ingredients;
    private static RPService rpService;

    private RPService() {
        this.ingredients = exampleData();
    }

    public static RPService getInstance() {
        if (rpService == null) {
            rpService = new RPService();
        }
        return rpService;
    }

    public Set getIngredients() {
        return new HashSet<>(ingredients);
    }

    public Set exampleData() {
        Set ingredients = new HashSet();
        ingredients.add(new RPIngredients("Beer"));
        return ingredients;
    }

    public Set backend() {
        List<RPIngredients> backendIngredients = rpProposedIngredientsConnections.getAllCRPIngredientsList();
        Set ingredients = new HashSet(backendIngredients);
        return ingredients;
    }

    public Set findByIngredient(String ingredientName) {
        return ingredients.stream().filter(i -> i.getIngredient().contains(ingredientName)).collect(Collectors.toSet());
    }

    public void proposeIngredient(String rpIngredient) {
        this.ingredients.add(new RPIngredients(rpIngredient));
    }
}
