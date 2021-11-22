package com.nikitakoselev.petclient;

import com.nikitakoselev.petclient.model.Pet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.io.IOException;

@Service
public class PetService {
    Logger log = LoggerFactory.getLogger(PetService.class);

    public Flux<Pet> getPetsByStatus(String status) {
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
                .doOnError(IOException.class, it -> log.error("an error has occurred"));

        return pets;
    }
}
