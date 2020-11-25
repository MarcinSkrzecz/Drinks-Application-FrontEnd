package com.kodilla.drinks_frontend.comment;

import com.kodilla.drinks_frontend.connectionsToBackend.CommentConnections;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CommentService {

    @Autowired
    private CommentConnections commentConnections;

    private Set<Comment> comments;
    private static CommentService commentService;

    private CommentService() {
        this.comments = exampleData();
    }

    public static CommentService getInstance() {
        if (commentService == null) {
            commentService = new CommentService();
        }
        return commentService;
    }

    public Set getComments() {
        return new HashSet<>(comments);
    }

    public Set exampleData() {
        Set comments = new HashSet();
        comments.add(new Comment(1L, 1, "username", "comment", 1, 1, LocalDate.now()));
        return comments;
    }

    //Backend - not working
    public Set backendData() {
        Set comments = new HashSet(commentConnections.getAllCommentsList());
        return comments;
    }

    public Set findByDrinkId(String drinkIdString) {
        Long drinkId = Long.parseLong(drinkIdString);
        return comments.stream().filter(comment -> comment.getDrinkId().equals(drinkId)).collect(Collectors.toSet());
    }

    public void save(Comment comment) {
        this.comments.add(comment);
        //Backend - not working
        //commentConnections.createComment(comment);
    }
    public void delete(Comment comment) {
        this.comments.remove(comment);
        //Backend - not working
        //commentConnections.deleteComment(comment.getId());
    }
    public void update(Comment comment) {
        //Backend - not working
        //commentConnections.updateComment(comment);
    }
    public void like(Comment comment) {
        //Backend - not working
        //commentConnections.likeComment(comment.getId());
    }
}
