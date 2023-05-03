package options;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)

@CucumberOptions( features= "src\\test\\java\\features\\adduser.feature",glue= "stepdefinitions")


public class adduser_testRunner {

}
