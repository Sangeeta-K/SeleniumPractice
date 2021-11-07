package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class User_reg {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "src//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@class='login']")).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Create an account')]")));
		Assert.assertTrue(driver.getCurrentUrl().contains("my-account"));
		driver.findElement(By.xpath("//input[@id='email_create']")).clear();
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("ghjkiuy@yopmail.com");
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();   
		System.out.println("ENTERED HERE");
//		try {
//		Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(),'Your personal information')]")).isDisplayed());
//		}
//		catch(AssertionError a) {
//			System.out.println("Personal info not displayed");	
//		} 
		System.out.println("NAVIGATED TO CREATE ACCOUNT PAGE");
		System.out.println("ENTERED THE FORM");
		Thread.sleep(1000);
		WebDriverWait wait1 = new WebDriverWait(driver,50);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='id_gender1']")));
		WebDriverWait wait2 = new WebDriverWait(driver,20);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='id_gender1']")));
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		System.out.println("Clicked on radio btn");
		driver.findElement(By.id("customer_firstname")).sendKeys("yz");
		System.out.println("Entered first name");
		driver.findElement(By.id("customer_lastname")).sendKeys("jkl");
		System.out.println("Entered last name");
		driver.findElement(By.id("passwd")).sendKeys("iopuy");
		System.out.println("Entered pwd");
		WebElement day = driver.findElement(By.name("days"));
		Select select_day = new Select(day);
		select_day.deselectByValue("7");
		System.out.println("Selected day");
		WebElement month = driver.findElement(By.name("months"));
		Select sel_month = new Select(month);
		sel_month.selectByIndex(5);
		System.out.println("Selected month");
		WebElement year = driver.findElement(By.name("years"));
		Select sel_year = new Select(year);
		sel_year.selectByVisibleText("2004");
		System.out.println("Selected year");
  }
}
