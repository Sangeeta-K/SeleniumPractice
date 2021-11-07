package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class form {
	WebDriver driver;
  @Test
  public void test() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "src//Drivers//chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.name("firstname")).sendKeys("ABC");
	  driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("def");
	  driver.findElement(By.xpath("//input[@value='Male']")).click();
	  driver.findElement(By.cssSelector("input#exp-3")).click();
	  driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("23-4-2031");
	  Thread.sleep(1000);
	  WebDriverWait wait = new WebDriverWait(driver,10);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Automation Tester']")));
	  driver.findElement(By.xpath("//input[@value='Automation Tester']")).click();
	  driver.findElement(By.id("tool-2")).click();
	  driver.findElement(By.xpath("//input[@id='tool-1']")).click();
	  WebElement cont_dpdn = driver.findElement(By.id("continents"));
	  Select sel = new Select(cont_dpdn);
	  sel.selectByVisibleText("Europe");
	  WebElement sel_dpdn = driver.findElement(By.id("selenium_commands"));
	  Select select = new Select(sel_dpdn);
	  select.selectByIndex(4);
	  select.selectByIndex(1);
//	  driver.findElement(By.xpath("//input[@id='photo']")).click();
	  driver.findElement(By.xpath("//a[contains(text(),'Click here to Download File')]")).click();
	  driver.navigate().back();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[@id='submit']")).click();
	  driver.close();
	  
	  
  }
}
