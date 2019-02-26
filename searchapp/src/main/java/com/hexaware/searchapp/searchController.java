package com.hexaware.searchapp;

import com.example.Example;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class searchController
{

    @GetMapping(value = "/search/{term}/{location}")
    public Example getProductList(@PathVariable(name = "term") String term, @PathVariable(name="location") String location) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("https://api.yelp.com/v3/businesses/search?term="+term+"&location="+location
                , HttpMethod.GET, entity, Example.class).getBody();
    }
}
