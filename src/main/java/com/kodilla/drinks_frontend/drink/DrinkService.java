package com.kodilla.drinks_frontend.drink;

import com.kodilla.drinks_frontend.connectionsToBackend.DrinkConnections;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DrinkService {

    @Autowired
    DrinkConnections drinkConnections;

    private Set<Drink> drinks;
    private static DrinkService drinkService;

    private DrinkService() {
        this.drinks = exampleData();
    }

    public static DrinkService getInstance() {
        if (drinkService == null) {
            drinkService = new DrinkService();
        }
        return drinkService;
    }

    public Set getDrinks() {
        return new HashSet<>(drinks);
    }

    public Set exampleData() {
        Set drinks = new HashSet();
        drinks.add(new Drink(1L,"Name1", "Username1", "Recipe1", "Wodka, Piwo, Energetyk", LocalDate.now()));
        return drinks;
    }

    //Backend - not working
    public Set backendData() {
        Set drinks = new HashSet(drinkConnections.getAllDrinksList());
        return drinks;
    }

    public Set findByName(String drinkName) {
        return drinks.stream().filter(drink -> drink.getDrinkName().contains(drinkName)).collect(Collectors.toSet());
    }
    public Set filterByFirstIngredient(String ingredient1) {
        if (ingredient1 != null) {
            return drinks.stream().filter(drink -> drink.getIngredients().contains(ingredient1)).collect(Collectors.toSet());
        } else {
            return drinks;
        }
    }
    public Set filterBySecondIngredient(String ingredient1, String ingredient2) {
        Set<Drink> firstFilterDrinks = filterByFirstIngredient(ingredient1);
        if (ingredient1 != null) {
            return firstFilterDrinks.stream().filter(drink -> drink.getIngredients().contains(ingredient2)).collect(Collectors.toSet());
        } else {
            return firstFilterDrinks;
        }
    }

    public void save(Drink drink) {
        this.drinks.add(drink);
        //Backend - not working
        //drinkConnections.createDrink(drink);
    }
    public void delete(Drink drink) {
        this.drinks.remove(drink);
        //Backend - not working
        drinkConnections.deleteDrink(drink.getId());
    }
    public void update(Drink drink) {
        //Backend - not working
        //drinkConnections.updateDrink(drink);
    }
}