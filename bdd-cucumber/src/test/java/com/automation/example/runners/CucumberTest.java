package com.automation.example.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com/automation/example/features",
        glue = {"com.automation.example.stepdefs"},
        plugin = {"ru.yandex.qatools.allure.cucumberjvm.AllureReporter",
                "json",
                "json:target/cucumber.json"}
                )
public class CucumberTest {
}
