package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class login_stepdefinition {
public  static WebDriver driver; 
	
	
	@Given("I visit login page")
	public void i_visit_login_page() {
	  System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir")+"\\chromedriver.exe");
	  driver = new ChromeDriver(); 	
	  driver.manage().window();
	  driver.get("http://localhost:4200/login"); 
	}

	@When("I enter {string} in the user name field and {string} in the passwrd field")
	public void i_enter_in_the_user_name_field_and_in_the_passwrd_field(String email, String pwd) throws InterruptedException{
	  WebElement getinputemail =  driver.findElement(By.id("email"));
	  getinputemail.sendKeys(email);
	  Thread.sleep(2000);
	  WebElement getinputpwd =  driver.findElement(By.id("password"));
	  getinputpwd.sendKeys(pwd);
	}

	@When("I click in login button")
	public void i_click_in_login_button() throws InterruptedException {
	    WebElement getbutton = driver.findElement(By.xpath("//button[@type='submit']"));
	    Thread.sleep(1000);
	    getbutton.click();
	    Thread.sleep(2000);
	}

	@Then("I should be in profile page")
	public void i_should_be_in_profile_page() {
	   Assert.assertEquals(driver.getTitle(),"Profile" );
       

	}
	@Then("Error message is shown {string}")
	public void error_message_is_shown(String string) {
		Assert.assertEquals(driver.getTitle(),"Sofia tech" );
		System.out.println("Erreur");
		
	}
	
	}
	
	
	