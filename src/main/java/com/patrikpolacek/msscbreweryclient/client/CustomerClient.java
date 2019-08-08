package com.patrikpolacek.msscbreweryclient.client;

import com.patrikpolacek.msscbreweryclient.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class CustomerClient {

    RestTemplate restTemplate;

    public static final String URI = "http://localhost:8080/api/v1/customer/";


    @Autowired
    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDto getCustomer(UUID uuid) {
        return restTemplate.getForObject(URI + uuid.toString(), CustomerDto.class);
    }

    public void postCustomer(CustomerDto customerDto) {
        restTemplate.postForLocation(URI, customerDto);
    }

    public void updateCustomer(UUID uuid, CustomerDto customerDto) {
        restTemplate.put(URI + uuid.toString(), customerDto);
    }
    public void deleteCustomer(UUID uuid){
        restTemplate.delete(URI + uuid);
    }
}
