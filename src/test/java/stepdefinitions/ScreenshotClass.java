package stepdefinitions;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotClass implements ITestListener {

    private static WebDriver driver;

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed : " + result.getName());
        takeScreenshot(result.getName());
    }

    public void takeScreenshot(String testName) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String filename = testName + ".png";
            Path destination = Paths.get(System.getProperty("user.home") + "/Desktop/" + screenshot);
            Files.copy(screenshot.toPath(), destination);
            System.out.println("Screenshot saved as " + filename + " on your desktop");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStart(ITestContext context) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Override
    public void onFinish(ITestContext context) {
        driver.quit();
    }

	public static File toFile() {
		// TODO Auto-generated method stub
		return null;
	}

    // other methods such as onTestSuccess, onTestSkipped, etc.
}

