package com.nikitakoselev.petclient;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/acceptance-tests.feature")
public class CucumberIntegrationTest {
}
