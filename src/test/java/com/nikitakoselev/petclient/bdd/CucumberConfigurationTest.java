package com.nikitakoselev.petclient.bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        plugin = {"pretty", "html:target/cucumber/petclient"},
        extraGlue = "com.nikitakoselev.petclient.bdd")
public class CucumberConfigurationTest {
}
