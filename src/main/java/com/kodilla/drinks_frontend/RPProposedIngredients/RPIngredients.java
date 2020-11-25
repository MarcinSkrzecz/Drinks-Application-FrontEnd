package com.kodilla.drinks_frontend.RPProposedIngredients;

public class RPIngredients {

    private String ingredient;

    public RPIngredients() {}

    public RPIngredients(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RPIngredients that = (RPIngredients) o;

        return ingredient != null ? ingredient.equals(that.ingredient) : that.ingredient == null;
    }

    @Override
    public int hashCode() {
        return ingredient != null ? ingredient.hashCode() : 0;
    }
}
