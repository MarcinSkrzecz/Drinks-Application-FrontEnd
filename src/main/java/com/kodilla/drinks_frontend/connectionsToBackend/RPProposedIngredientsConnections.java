package com.kodilla.drinks_frontend.connectionsToBackend;

import com.kodilla.drinks_frontend.RPProposedIngredients.RPIngredients;
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

public class RPProposedIngredientsConnections {
    private static final Logger LOGGER = LoggerFactory.getLogger(RPProposedIngredientsConnections.class);

    @Autowired
    private RestTemplate restTemplate;

    public List<RPIngredients> getAllCRPIngredientsList() {
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/comments/rp/ingredientsDescriptions").build().encode().toUri();
        try {
            RPIngredients[] response = restTemplate.getForObject(uri, RPIngredients[].class);
            return Arrays.asList(ofNullable(response).orElse(new RPIngredients[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new ArrayList<>();
        }
    }
}