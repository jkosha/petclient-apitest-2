package com.nikitakoselev.petclient;

import com.nikitakoselev.petclient.model.Pet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class PetClientApplication {

    private static final Logger log = LoggerFactory.getLogger(PetClientApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PetClientApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            List<Pet> pets = restTemplate.getForObject(
                    "https://petstore.swagger.io/v2/pet/findByStatus?status=available", List.class);
            log.info(pets.toString());
        };
    }
}
