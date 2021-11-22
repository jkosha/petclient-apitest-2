package com.nikitakoselev.petclient;


import com.nikitakoselev.petclient.model.Pet;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import reactor.core.publisher.Flux;

import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PetClientApplicationHttpTest {
    Logger log = LoggerFactory.getLogger(PetClientApplicationHttpTest.class);

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void somePetsShouldBeReturned() {
        List<Pet> pets = restTemplate
                .getForEntity("http://localhost:" + port + "/getPetsByStatus?status=available", List.class)
                .getBody();

        Assertions.assertTrue(pets.size() > 0);
    }
}
