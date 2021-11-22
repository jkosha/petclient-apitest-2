package com.nikitakoselev.petclient;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    private int budget = 0;


    @Given("I have {int} in my wallet")
    public void iHaveInMyWallet(int arg0) {
    }

    @When("Service is requested for a {string} status")
    public void serviceIsRequestedForAStatus(String arg0) {
    }

    @Then("A result with {int} pets is returned by the service")
    public void aResultWithPetsIsReturnedByTheService(int arg0) {
    }
}
