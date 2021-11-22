package com.nikitakoselev.petclient;

import com.nikitakoselev.petclient.model.Pet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class PetController {
    private static final Logger log = LoggerFactory.getLogger(PetController.class);

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }


    @GetMapping("getPetsByStatus")
    public Flux<Pet> getPetsByStatus(@RequestParam(defaultValue = "available") String status) {
        log.debug("status = " + status);

        return petService.getPetsByStatus(status);
    }


}
