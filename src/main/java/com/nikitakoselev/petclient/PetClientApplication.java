package com.nikitakoselev.petclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetClientApplication {
    private static final Logger log = LoggerFactory.getLogger(PetClientApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PetClientApplication.class, args);
    }
}
