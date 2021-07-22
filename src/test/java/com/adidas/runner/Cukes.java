package com.adidas.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/adidas/step_definitions",
        dryRun = false,
        plugin = "html:target/adidas-report.html",
        tags = ""
)
public class Cukes {
}
