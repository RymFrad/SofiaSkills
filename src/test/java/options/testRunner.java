package options;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)

@CucumberOptions( features= {"src\\test\\java\\features"},glue= {"stepdefinitions"},plugin = {"json:target/cucumber.json"}, tags = {"@smoke"})

public class testRunner {

    }


