package com.nikitakoselev.petclient;

import com.nikitakoselev.petclient.model.Category;
import com.nikitakoselev.petclient.model.Pet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.io.IOException;

import static org.mockito.Mockito.when;

@WebFluxTest(PetController.class)
public class PetControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private PetService petService;

    @Test
    void somePetsShouldBeReturned() {
        Flux<Pet> pets = Flux.just(new Pet[]{
                        new Pet(1l, new Category(1l, "cat"), "Tom", "available", null, null)
                        , new Pet(2l, new Category(1l, "cat"), "Tom", "available", null, null)
                        , new Pet(3l, new Category(1l, "cat"), "Tom", "available", null, null)
                        , new Pet(4l, new Category(1l, "cat"), "Tom", "available", null, null)
                        , new Pet(5l, new Category(1l, "cat"), "Tom", "available", null, null)
                }
        );

        Mockito.when(petService.getPetsByStatus("available")).thenReturn(pets);

        webTestClient.get()
                .uri("/getPetsByStatus?status=available")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$[0].id").isEqualTo(1)
                .jsonPath("$[0].status" ).isEqualTo("available");



    }
}
