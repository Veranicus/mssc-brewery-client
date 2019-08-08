package com.patrikpolacek.msscbreweryclient.client;

import com.patrikpolacek.msscbreweryclient.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CustomerClientTest {

    CustomerDto customerDto = CustomerDto.builder().name("john").build();
    @Autowired
    CustomerClient customerClient;

    @Test
    void getCustomer() {
        CustomerDto customerDto = customerClient.getCustomer(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void postCustomer() {
        customerClient.postCustomer(customerDto);
    }

    @Test
    void testUpdateCustomer() {
        customerClient.updateCustomer(UUID.randomUUID(), customerDto);

    }

    @Test
    void deleteCustomer() {
        customerClient.deleteCustomer(UUID.randomUUID());
    }
}
