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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Votes votes = (Votes) o;

        if (id != null ? !id.equals(votes.id) : votes.id != null) return false;
        if (ingredient != null ? !ingredient.equals(votes.ingredient) : votes.ingredient != null) return false;
        return votesCount != null ? votesCount.equals(votes.votesCount) : votes.votesCount == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (ingredient != null ? ingredient.hashCode() : 0);
        result = 31 * result + (votesCount != null ? votesCount.hashCode() : 0);
        return result;
    }
}