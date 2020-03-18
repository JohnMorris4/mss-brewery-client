package com.morrisje.mssbreweryclient.web.client;

import com.morrisje.mssbreweryclient.web.models.BeerDto;
import com.morrisje.mssbreweryclient.web.models.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;


    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void testSavedNewBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("New Beer to test").build();

        URI uri = client.saveNewBeer(beerDto);

        assertNotNull(uri);

        System.out.println(uri.toString());
    }

    @Test
    void  testUpdateBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("New Beer to test").build();

        client.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void testDeleteBeer(){
        client.deleteBeer(UUID.randomUUID());
    }

    // Customer information test

    @Test
    void getCustomerById() {
        CustomerDto customerDto = client.gerCustomerById(UUID.randomUUID());

        assertNotNull(customerDto);
    }

    @Test
    void testSavedNewCustomer(){
        CustomerDto customerDto = CustomerDto.builder().Name("John").build();

        URI uri = client.savedNewCustomer(customerDto);

        assertNotNull(uri);

        System.out.println(uri.toString());
    }

    @Test
    void testUpdateCustomer(){
        CustomerDto customerDto = CustomerDto.builder().Name("John").build();

        client.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void testDeleteCustomer(){
        client.deleteCustomer(UUID.randomUUID());
    }

}