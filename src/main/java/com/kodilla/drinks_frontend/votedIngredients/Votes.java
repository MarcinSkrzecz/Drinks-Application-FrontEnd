package com.kodilla.drinks_frontend.votedIngredients;

public class Votes {
    private Long id;
    private String ingredient;
    private Integer votesCount;

    public Votes() {}

    public Votes(String ingredient, Integer votesCount) {
        this.ingredient = ingredient;
        this.votesCount = votesCount;
    }

    public Votes(Long id, String ingredient, Integer votesCount) {
        this.id = id;
        this.ingredient = ingredient;
        this.votesCount = votesCount;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
    public Integer getVotesCount() {
        return votesCount;
    }
    public void setVotesCount(Integer votesCount) {
        this.votesCount = votesCount;
    }
}