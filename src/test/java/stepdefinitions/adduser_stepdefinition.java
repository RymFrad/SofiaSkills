package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;



public class adduser_stepdefinition  {
public  static WebDriver driver; 


	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		 System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir")+"\\chromedriver.exe");
		  driver = new ChromeDriver(); 	
		  driver.manage().window();
		  driver.manage().window().maximize();
		  driver.get("http://localhost:4200/login"); 
	}

	@When("I log in as an administrator with valid email {string} and a valid password {string}")
	public void i_log_in_as_an_administrator_with_valid_email_and_a_valid_password(String email, String pwd) throws InterruptedException, IOException {
		WebElement getinputemail =  driver.findElement(By.id("email"));
		  getinputemail.sendKeys(email);
		  Thread.sleep(1000);
		  WebElement getinputpwd =  driver.findElement(By.id("password"));
		  getinputpwd.sendKeys(pwd);
		  
		 
	}

	@When("I click the login button")
	public void i_click_the_login_button() throws InterruptedException {
		WebElement getbutton = driver.findElement(By.xpath("//button[@type='submit']"));
	    Thread.sleep(1000);
	    getbutton.click();
	    Thread.sleep(1000);
	  
	}

	@Then("I should be redirected to the profile page")
	public void i_should_be_redirected_to_the_profile_page() throws IOException, InterruptedException  {
		try {
			Assert.assertEquals(driver.getTitle(),"Profile" );
		    Thread.sleep(2000);

	    } catch (AssertionError e) {
	        // Capture d'écran en cas d'échec de l'assertion
	        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        File destDir = new File("C:\\Users\\user\\Desktop\\testautopfe\\screenshots");
	        File destFile = new File(destDir, "screenshot3.png");
	        FileUtils.copyFile(screenshotFile, destFile);
	        // Rethrow l'exception pour signaler le test comme échoué
	        throw e;
	    }
		System.out.println("Page de profile");
	}

	@And("I click on the User Configuration option")
	public void i_click_on_the_User_Configuration_option() throws InterruptedException {		 
		 WebElement userConfigElement = driver.findElement(By.linkText("User Configuration"));
		 Thread.sleep(1000);
		 userConfigElement.click();
		    Thread.sleep(1000);
			System.out.println("OK1");

	}

	@And("I select the Add User option")
	public void i_select_the_Add_User_option() throws InterruptedException {
		 WebElement getaddbutton = driver.findElement(By.className("p-button-label"));
		    Thread.sleep(1000);
		    getaddbutton.click();
		    Thread.sleep(1000);
			System.out.println("OK2");
			System.out.println("Page de profile");

	}

	@Then("I enter {string} in the First Name field {string} in the Last Name field and {string} in the Email Address field")
	public void i_enter_in_the_First_Name_field_in_the_Last_Name_field_and_in_the_Email_Address_field(String First, String Last, String email) throws InterruptedException {
		 WebElement getinputFirst =  driver.findElement(By.id("mat-input-0"));
		  getinputFirst.sendKeys(First);
		  Thread.sleep(1000);
		  WebElement getinputLast=  driver.findElement(By.id("mat-input-1"));
		  getinputLast.sendKeys(Last);
		  Thread.sleep(1000);
		  WebElement getinputemail=  driver.findElement(By.id("mat-input-2"));
		  getinputemail.sendKeys(email);
		  Thread.sleep(1000);
			System.out.println("OK3");

	}

	@And("I select a Role from the Role list")
	public void i_select_a_Role_from_the_Role_list1() throws InterruptedException {    
		WebElement getrole = driver.findElement(By.xpath("//*[@id=\"role\"]/div/div[1]/div[3]"));
		getrole.click();
		Thread.sleep(1000);
		WebElement getonerole = driver.findElement(By.xpath("//span[@class='mat-option-text'][normalize-space()='USER']"));
		getonerole.click();
		Thread.sleep(1000);
		System.out.println("OK4");

	}
	
	@And("I select a Company from the Company list")
	public void i_select_a_Company_from_the_Company_list() throws InterruptedException {
	    WebElement getcompany = driver.findElement(By.xpath("//*[@id=\"company\"]/div/div[1]/div[3]"));
	    getcompany.click();
	    Thread.sleep(1000);
		WebElement getonecompany = driver.findElement(By.xpath("//span[normalize-space()='SofiaTech']"));
		getonecompany.click();
	    Thread.sleep(1000);
		System.out.println("OK5");


	}

	@And("I select a Department from the Department list")
	public void i_select_a_Department_from_the_Department_list() throws InterruptedException {
		WebElement getdepartment = driver.findElement(By.xpath("//*[@id=\"department\"]/div/div[1]/div[3]"));
		getdepartment.click();
		Thread.sleep(1000);
		WebElement getElement = driver.findElement(By.xpath("//span[normalize-space()='Software Department']"));
		getElement.click();
	    Thread.sleep(1000);
		System.out.println("OK6");

	}

	@And("I select a Function from the Function list")
	public void i_select_a_Function_from_the_Function_list() throws InterruptedException {
		WebElement getfunction = driver.findElement(By.xpath("//*[@id=\"function\"]/div/div[1]/div[3]"));
		getfunction.click();
		Thread.sleep(1000);
		WebElement getElement = driver.findElement(By.xpath("//span[normalize-space()='Embedded Developer']"));
		getElement.click();
	    Thread.sleep(1000);
		System.out.println("OK7");

	}


	@And("I click on the Submit button")
    public void i_click_on_the_Submit_button() throws InterruptedException {
		WebElement getsubmitbutton = driver.findElement(By.className("p-button-label"));
	    Thread.sleep(1000);
	    getsubmitbutton.click();
	    Thread.sleep(2000);
		System.out.println("OK7");

}


	@Then("a message should be displayed saying User added successfully.")
	public void a_message_should_be_displayed_saying_User_added_successfully() {
		Assert.assertEquals(driver.getTitle(),"Add User" );
		System.out.println("User added successfully");
		driver.quit();;

	}
	@Then("I select the Import file option")
	public void i_select_the_Import_file_option() throws InterruptedException {
		 WebElement getimportbutton = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-user-list/mat-card/div[1]/p-toolbar/div/div[2]/button"));
		    Thread.sleep(1000);
		    getimportbutton.click();
		    Thread.sleep(1000);
			System.out.println("OK2");
	}
	@Then("I choose an excel file and i click on open button")
	public void i_choose_an_excel_file_and_i_click_on_open_button() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("C:\\Users\\user\\Desktop\\FileUploadScript.exe");
	    Thread.sleep(3000);
	    System.out.println("Ok3");

		}
	@Then("A confirmation window should be open with a message Do you want to upload this file")
	public void a_confirmation_window_should_be_open_with_a_message_Do_you_want_to_upload_this_file() {
		System.out.println("Do you want to upload this file");

	}

	@Then("I click Yes button")
	public void i_click_Yes_button() throws InterruptedException {
		WebElement getyesbutton = driver.findElement(By.xpath("//span[normalize-space()='Yes']"));
	    getyesbutton.click();
	    Thread.sleep(2000);
		System.out.println("OK4");
	}

	@Then("a message should be displayed saying file is uploaded successfully.")
	public void a_message_should_be_displayed_saying_file_is_uploaded_successfully() {
		System.out.println("file is uploaded successfully");
		driver.quit();

	}
	
	
	
}
