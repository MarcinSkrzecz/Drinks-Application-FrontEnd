package com.kodilla.drinks_frontend.connectionsToBackend;

import com.kodilla.drinks_frontend.votedIngredients.Votes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Optional.ofNullable;

public class VotesConnections {
    private static final Logger LOGGER = LoggerFactory.getLogger(VotesConnections.class);

    @Autowired
    private RestTemplate restTemplate;

    public List<Votes> getAllVotesList() {
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/rp/ingredients").build().encode().toUri();
        try {
            Votes[] response = restTemplate.getForObject(uri, Votes[].class);
            return Arrays.asList(ofNullable(response).orElse(new Votes[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new ArrayList<>();
        }
    }

    public void proposeIngredient(Votes votes) {
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/rp/ingredients")
                .queryParam("id", votes.getId())
                .queryParam("description", votes.getIngredient())
                .queryParam("votes", votes.getVotesCount())
                .build().encode().toUri();
        restTemplate.postForObject(uri, null, Votes.class);
    }

    public void voteIngredient(Votes votes) {
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/rp/ingredients/vote")
                .queryParam("ingredientName", votes.getIngredient())
                .build().encode().toUri();
        restTemplate.postForObject(uri, null, Votes.class);
    }
}