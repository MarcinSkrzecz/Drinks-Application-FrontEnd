package com.kodilla.drinks_frontend.connectionsToBackend;

import com.kodilla.drinks_frontend.contactUs.ContactUs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class ContactUsConnections {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactUsConnections.class);

    @Autowired
    private RestTemplate restTemplate;

    public void contactUs(ContactUs contactUs) {
        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/trello/sendMessage")
                .queryParam("title", contactUs.getTitle())
                .queryParam("content", contactUs.getContent())
                .build().encode().toUri();
        try {
            restTemplate.postForObject(uri, null, ContactUs.class);
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}