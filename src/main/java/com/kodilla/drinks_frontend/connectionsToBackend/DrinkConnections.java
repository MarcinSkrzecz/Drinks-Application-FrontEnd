package com.kodilla.drinks_frontend.connectionsToBackend;

import com.kodilla.drinks_frontend.drink.Drink;
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
public class DrinkConnections {

    private static final Logger LOGGER = LoggerFactory.getLogger(DrinkConnections.class);

    @Autowired
    private RestTemplate restTemplate;

    public List<Drink> getAllDrinksList() {
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/drinks").build().encode().toUri();
        try {
            Drink[] response = restTemplate.getForObject(uri, Drink[].class);
            return Arrays.asList(ofNullable(response).orElse(new Drink[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new ArrayList<>();
        }
    }

    public void createDrink(Drink drink) {
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/drinks")
                .queryParam("username", drink.getUsername())
                .queryParam("drinkName", drink.getDrinkName())
                .queryParam("recipe", drink.getRecipe())
                .queryParam("ingredients", drink.getIngredients())
                .build().encode().toUri();
        restTemplate.postForObject(uri, null, Drink.class);
    }

    public void updateDrink(Drink drink) {
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/drinks")
                .queryParam("id", drink.getId())
                .queryParam("username", drink.getUsername())
                .queryParam("drinkName", drink.getDrinkName())
                .queryParam("recipe", drink.getRecipe())
                .queryParam("ingredients", drink.getIngredients())
                .build().encode().toUri();
        restTemplate.exchange(uri, HttpMethod.PUT, null, Drink.class);
    }

    public void deleteDrink(Long drinkId) {
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/drinks/" + drinkId)
                .build().encode().toUri();
        restTemplate.delete(uri);
    }
}