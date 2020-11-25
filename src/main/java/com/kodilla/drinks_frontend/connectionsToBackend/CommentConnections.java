package com.kodilla.drinks_frontend.connectionsToBackend;

import com.kodilla.drinks_frontend.comment.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Optional.ofNullable;

@Component
public class CommentConnections {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommentConnections.class);

    @Autowired
    private RestTemplate restTemplate;

    public List<Comment> getAllCommentsList() {
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/comments").build().encode().toUri();
        try {
            Comment[] response = restTemplate.getForObject(uri, Comment[].class);
            return Arrays.asList(ofNullable(response).orElse(new Comment[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new ArrayList<>();
        }
    }

    public void createComment(Comment comment) {
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/comments")
                .queryParam("drinkId", comment.getDrinkId())
                .queryParam("username", comment.getUsername())
                .queryParam("comment", comment.getComment())
                .queryParam("rate", comment.getRate())
                .build().encode().toUri();
        restTemplate.postForObject(uri, null, Comment.class);
    }


    public void updateComment(Comment comment) {
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/comments")
                .queryParam("id", comment.getId())
                .queryParam("drinkId", comment.getDrinkId())
                .queryParam("comment", comment.getComment())
                .queryParam("rate", comment.getRate())
                .build().encode().toUri();
        restTemplate.exchange(uri, HttpMethod.PUT, null, Comment.class);
    }

    public void deleteComment(Long commentId) {
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/comments/" + commentId)
                .build().encode().toUri();
        restTemplate.delete(uri);
    }

    public void likeComment(Long commentId) {
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/comments/{commentId}")
                .queryParam("id", commentId)
                .build().encode().toUri();
        restTemplate.exchange(uri, HttpMethod.PUT, null, Comment.class);
    }
}

