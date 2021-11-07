package cucumber_demos;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class User_sign_in {
	WebDriver driver;
	@Given("^User load the saucedemo website$")
	public void user_load_the_saucedemo_website() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
		System.setProperty("webdriver.chrome.driver", "src//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
	}

	@When("^User enter details and click on sign in$")
	public void user_enter_details_and_click_on_sign_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
	}

	@Then("^User signed in successfully and log out$")
	public void user_signed_in_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
		if(driver.getCurrentUrl().equalsIgnoreCase("https://www.saucedemo.com/inventory.html")){
			System.out.println("User signed in successfully");
		}
		try {
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
		driver.findElement(By.id("logout_sidebar_link")).click();
		if(driver.getCurrentUrl().equalsIgnoreCase("https://www.saucedemo.com/")) {
			System.out.println("User logged out successfully");
		}
		}
		catch(Exception e){
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("//src//Screenshots//sign_in.img"));
			
			
		}
		driver.close();
	}


	

}
