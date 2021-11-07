package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class click_navigation_2 {
	WebDriver driver;
  @Test
  public void Test() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "src\\Drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.techlistic.com/");
	  driver.manage().window().maximize();
	  driver.findElement(By.xpath("//a[contains(@href,'/p/java.html')]")).click();
	  System.out.println("Page Title: "+driver.getTitle());
	  driver.navigate().back();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(" //a[contains(@href,'p/selenium-tutorials.html')]")).click();
	  driver.navigate().back();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(" //a[contains(text(),'Blogs')]")).click();
	  driver.navigate().back();
	  driver.close();
	  
  }
}
