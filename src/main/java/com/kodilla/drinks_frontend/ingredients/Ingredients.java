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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredients that = (Ingredients) o;

        if (howManyTimesUsed != that.howManyTimesUsed) return false;
        if (ingredientId != null ? !ingredientId.equals(that.ingredientId) : that.ingredientId != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = ingredientId != null ? ingredientId.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + howManyTimesUsed;
        return result;
    }
}
