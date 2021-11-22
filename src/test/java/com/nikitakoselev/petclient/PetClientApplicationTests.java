package com.nikitakoselev.petclient;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest
class PetClientApplicationTests {

    @Autowired
    PetClientApplication petClientApplication;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(petClientApplication);
    }


}
