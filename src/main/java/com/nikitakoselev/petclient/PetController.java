package com.nikitakoselev.petclient;

import com.nikitakoselev.petclient.model.Pet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.io.IOException;

@RestController
public class PetController {
    private static final Logger log = LoggerFactory.getLogger(PetController.class);


    @GetMapping("getPetsByStatus")
    public Flux<Pet> getPetsByStatus(@RequestParam(defaultValue = "available") String status) {
        log.debug("status = " + status);

        Flux<Pet> pets = WebClient.builder()
                .baseUrl("https://petstore.swagger.io")
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v2/pet/findByStatus")
                        .queryParam("status", status)
                        .build())
                .retrieve()
                .bodyToFlux(Pet.class)
                .doOnError(IOException.class, it -> log.error("an error has occured"));

        return pets;
    }
}
