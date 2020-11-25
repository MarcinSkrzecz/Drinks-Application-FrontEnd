package com.kodilla.drinks_frontend.drink;

import java.time.LocalDate;

public class Drink {

    private Long id;
    private String username;
    private String drinkName;
    private String recipe;
    private String ingredients;
    private LocalDate creationDate;

    public Drink() {}

    public Drink(Long id, String username, String drinkName, String recipe, String ingredients, LocalDate creationDate) {
        this.id = id;
        this.username = username;
        this.drinkName = drinkName;
        this.recipe = recipe;
        this.ingredients = ingredients;
        this.creationDate = creationDate;
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getDrinkName() {
        return drinkName;
    }
    public String getRecipe() {
        return recipe;
    }
    public String getIngredients() {
        return ingredients;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }
    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Drink drink = (Drink) o;

        if (id != null ? !id.equals(drink.id) : drink.id != null) return false;
        if (username != null ? !username.equals(drink.username) : drink.username != null) return false;
        if (drinkName != null ? !drinkName.equals(drink.drinkName) : drink.drinkName != null) return false;
        if (recipe != null ? !recipe.equals(drink.recipe) : drink.recipe != null) return false;
        if (ingredients != null ? !ingredients.equals(drink.ingredients) : drink.ingredients != null) return false;
        return creationDate != null ? creationDate.equals(drink.creationDate) : drink.creationDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (drinkName != null ? drinkName.hashCode() : 0);
        result = 31 * result + (recipe != null ? recipe.hashCode() : 0);
        result = 31 * result + (ingredients != null ? ingredients.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        return result;
    }
}