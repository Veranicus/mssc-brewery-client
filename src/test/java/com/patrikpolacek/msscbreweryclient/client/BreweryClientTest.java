package com.patrikpolacek.msscbreweryclient.client;

import com.patrikpolacek.msscbreweryclient.model.BeerDtoV2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getBeerById() {
        BeerDtoV2 beerDtoV2 = breweryClient.getBeerById(UUID.randomUUID());

        assertNotNull(beerDtoV2);
    }

    @Test
    void saveNewBeer()
    {
        BeerDtoV2 beerDtoV2 = BeerDtoV2.builder().bearName("Test eer name").build();

        URI uri = breweryClient.saveNewBeer(beerDtoV2);

        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void testSaveNewBeer() {
        BeerDtoV2 beerDtoV2 = BeerDtoV2.builder().bearName("testName").build();
        breweryClient.updateBeer(UUID.randomUUID(), beerDtoV2);
    }
    @Test
    public void deleteBeer(){
        breweryClient.deleteBeer(UUID.randomUUID());
    }
    @Test
    void setApiHost() {
    }
}
