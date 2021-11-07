package cucumber_demos;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class User_registration {
	WebDriver driver;
		@Given("^Open the URL$")
		public void open_the_URL() {
			System.setProperty("webdriver.chrome.driver", "src//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://automationpractice.com/index.php");
			driver.manage().window().maximize();
		   
		    
		}

		@When("^User click on Sign In$")
		public void user_click_on_Sign_In() throws Throwable {
			driver.findElement(By.xpath("//a[@class='login']")).click();
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Create an account')]")));
	 
		}

		@Then("^User navigated to Sign In or Create Account page$")
		public void user_navigated_to_Sign_In_or_Create_Account_page(){
			Assert.assertTrue(driver.getCurrentUrl().contains("my-account"));
		   
		    
		}

		@When("^User enter \"([^\"]*)\" and click on Create Account button$")
		public void user_enter_and_click_on_Create_Account_button(String arg1){
			driver.findElement(By.xpath("//input[@id='email_create']")).clear();
			driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(arg1);
			driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();   
		}

		@Then("^User navigated to Create Account page$")
		public void user_navigated_to_Create_Account_page() {
			System.out.println("ENTERED HERE");
//			try {
//			Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(),'Your personal information')]")).isDisplayed());
//			}
//			catch(AssertionError a) {
//				System.out.println("Personal info not displayed");	
//			} 
			System.out.println("NAVIGATED TO CREATE ACCOUNT PAGE");
		}

		@When("^User enter \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
		public void user_enter_and(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) throws Throwable {
			try{
				System.out.println("ENTERED THE FORM");
//			Thread.sleep(1000);
//			WebDriverWait wait = new WebDriverWait(driver,50);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='id_gender1']")));
//			WebDriverWait wait1 = new WebDriverWait(driver,20);
//			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='id_gender1']")));
//			driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
//			System.out.println("Clicked on radio btn");
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_firstname")));
			driver.findElement(By.id("customer_firstname")).sendKeys(arg2);
			System.out.println("Entered first name");
			driver.findElement(By.id("customer_lastname")).sendKeys(arg3);
			System.out.println("Entered last name");
			driver.findElement(By.id("passwd")).sendKeys(arg5);
			System.out.println("Entered pwd");
			WebElement day = driver.findElement(By.name("days"));
			Select select_day = new Select(day);
			select_day.selectByValue("7");
			System.out.println("Selected day");
			WebElement month = driver.findElement(By.name("months"));
			Select sel_month = new Select(month);
			sel_month.selectByIndex(5);
			System.out.println("Selected month");
			WebElement year = driver.findElement(By.name("years"));
			Select sel_year = new Select(year);
			sel_year.selectByIndex(7);
			System.out.println("Selected year");
			}
			catch(Exception e) {
				System.out.println("Exception occured");
				e.printStackTrace();
				File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(srcFile, new File("src\\Screenshots\\user_reg.png"));
			}    
		}

		@When("^User enter \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
		public void user_enter(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10) throws Throwable {
//			driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(arg1);
//			driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(arg2);
			driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(arg4);  // username - tyu129@gmail.com                pwd - tyuio
			try{
			driver.findElement(By.id("city")).sendKeys(arg5);
			WebElement wb = driver.findElement(By.id("id_state"));
			Select sel = new Select(wb);
			sel.selectByVisibleText(arg6);
			System.out.println("Selected city and state");
			driver.findElement(By.name("postcode")).sendKeys(arg7);
			System.out.println("Entered zipcode");
			driver.findElement(By.id("phone_mobile")).sendKeys(arg9);
			System.out.println("Entered mob no");
			driver.findElement(By.id("alias")).clear();
			driver.findElement(By.id("alias")).sendKeys(arg10);
			System.out.println("Entered alias");
			}
			catch(Exception e) {
				System.out.println("Exception occured");
				e.printStackTrace();
				File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(srcFile, new File("src\\Screenshots\\user_reg.png"));
				
			}
		   
		    
		}

		@When("^User Click on Register button$")
		public void user_Click_on_Register_button() throws Throwable {
			try {
			driver.findElement(By.id("submitAccount")).click();
			System.out.println("Clicked on submit btn");
			}
			catch(Exception e) {
				System.out.println("Exception occured");
				e.printStackTrace();
				File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(srcFile, new File("src\\Screenshots\\user_reg.png"));
			}
		   
		    
		}

		@Then("^User Account created successfully$")
		public void user_Account_created_successfully() throws Throwable {
			try {
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("D://SeleniumDemos//SeleniumPractice//src//Screenshots//user_reg.png"));// won't work for testNG
			System.out.println("Sreenshot taken and stored");
//			driver.close();
			}
			catch(Exception e) {
				System.out.println("Exception occured");
				e.printStackTrace();
				
			}
			
			    
		}

  }

