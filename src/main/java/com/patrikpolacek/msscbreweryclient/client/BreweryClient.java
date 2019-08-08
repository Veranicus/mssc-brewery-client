package com.patrikpolacek.msscbreweryclient.client;

import com.patrikpolacek.msscbreweryclient.model.BeerDtoV2;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Configuration
@Component
@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    public static final String BEER_PATH_V2 = "/api/v2/beer/";
    @Setter
    private String apiHost;
    private final RestTemplate restTemplate;

    @Autowired
    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDtoV2 getBeerById(UUID uuid) {
        return restTemplate.getForObject("http://localhost:8080" + BEER_PATH_V2 + uuid.toString(), BeerDtoV2.class);
    }

    public URI saveNewBeer(BeerDtoV2 beerDtoV2) {
        return restTemplate.postForLocation("http://localhost:8080" + BEER_PATH_V2, beerDtoV2);
    }

    public void updateBeer(UUID uuid, BeerDtoV2 beerDtoV2){
        restTemplate.put(apiHost + BEER_PATH_V2 + uuid.toString(), beerDtoV2);
    }

    public void deleteBeer(UUID uuid){
        restTemplate.delete("http://localhost:8080" + BEER_PATH_V2 + uuid.toString());
    }

}
