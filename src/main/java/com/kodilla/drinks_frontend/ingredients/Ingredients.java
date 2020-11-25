package com.kodilla.drinks_frontend.ingredients;

public class Ingredients {
    private Long ingredientId;
    private String description;
    private int howManyTimesUsed;

    public Ingredients() {}

    public Ingredients(Long ingredientId, String description, int howManyTimesUsed) {
        this.ingredientId = ingredientId;
        this.description = description;
        this.howManyTimesUsed = howManyTimesUsed;
    }

    public Long getIngredientId() {
        return ingredientId;
    }
    public String getDescription() {
        return description;
    }
    public int getHowManyTimesUsed() {
        return howManyTimesUsed;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHowManyTimesUsed(int howManyTimesUsed) {
        this.howManyTimesUsed = howManyTimesUsed;
    }
}
