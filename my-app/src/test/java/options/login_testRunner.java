package options;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)

@CucumberOptions( features= "src\\test\\java\\features\\Authentification.feature",glue= "stepdefinitions")


public class login_testRunner {

}
