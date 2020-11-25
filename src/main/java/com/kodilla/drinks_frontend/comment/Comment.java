package com.kodilla.drinks_frontend.comment;

import java.time.LocalDate;

public class Comment {

    private Long id;
    private Integer drinkId;
    private String username;
    private String comment;
    private int rate;
    private int likes;
    private LocalDate creationDate;

    public Comment(){}

    public Comment(Long id, Integer drinkId, String username, String comment, int rate, int likes, LocalDate creationDate) {
        this.id = id;
        this.drinkId = drinkId;
        this.username = username;
        this.comment = comment;
        this.rate = rate;
        this.likes = likes;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }
    public Integer getDrinkId() {
        return drinkId;
    }
    public String getUsername() {
        return username;
    }
    public String getComment() {
        return comment;
    }
    public int getRate() {
        return rate;
    }
    public int getLikes() {
        return likes;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setDrinkId(Integer drinkId) {
        this.drinkId = drinkId;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public void setRate(int rate) {
        this.rate = rate;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment1 = (Comment) o;

        if (rate != comment1.rate) return false;
        if (likes != comment1.likes) return false;
        if (id != null ? !id.equals(comment1.id) : comment1.id != null) return false;
        if (drinkId != null ? !drinkId.equals(comment1.drinkId) : comment1.drinkId != null) return false;
        if (username != null ? !username.equals(comment1.username) : comment1.username != null) return false;
        if (comment != null ? !comment.equals(comment1.comment) : comment1.comment != null) return false;
        return creationDate != null ? creationDate.equals(comment1.creationDate) : comment1.creationDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (drinkId != null ? drinkId.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + rate;
        result = 31 * result + likes;
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        return result;
    }
}
