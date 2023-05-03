package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;


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
		driver.quit();;


	}
	@Then("Error message is shown {string}")
	public void error_message_is_shown(String string) {
		Assert.assertEquals(driver.getTitle(),"Sofia tech" );
		System.out.println("Erreur");
		driver.quit();;
	}
	
	
	@When("I click on the Forgot password button")
	public void i_click_on_the_Forgot_password_button1() throws InterruptedException {
		 WebElement getfogotbutton = driver.findElement(By.xpath("//a[@id='forgetpwd']"));
		    Thread.sleep(1000);
		    getfogotbutton.click();
		    Thread.sleep(2000);
	}

	@Then("I redirected to the password recovery page")
	public void i_redirected_to_the_password_recovery_page() {
		   Assert.assertEquals(driver.getTitle(),"Sofia tech" );

	}

	@And("I enter email address {string}")
	public void i_enter_email_address(String email) throws InterruptedException {
		 WebElement getinputemail =  driver.findElement(By.id("email"));
		  getinputemail.sendKeys(email);
		  Thread.sleep(2000);
		 
	}

	@And("I click on the submit button")
	public void i_click_on_the_submit_button() throws InterruptedException {
		WebElement getsubmitbutton = driver.findElement(By.xpath("//button[@type='submit']"));
	    Thread.sleep(1000);
	    getsubmitbutton.click();
	    Thread.sleep(2000);
	}

	@Then("An email is sent with an {int} character password")
	public void an_email_is_sent_with_an_character_password(Integer int1) {
		Assert.assertEquals(driver.getTitle(),"Sofia tech" );
		System.out.println("OK");
		driver.quit();;

	}

	
	}
	
	
	