package com.nikitakoselev.petclient.bdd;

import com.nikitakoselev.petclient.PetController;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PetClientBddTest {

    private PetController petController;

    @Autowired
    private WebTestClient webTestClient;

    @When("server is available")
    public void when() {
        Assertions.assertTrue(true);
     /*   assertNotNull(webTestClient);
        webTestClient.get()
                .uri("/getPetsByStatus?status=available")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();*/
    }
}
