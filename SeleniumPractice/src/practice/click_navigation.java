package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class click_navigation {
	
	WebDriver driver;
  @Test
  public void Test() {
	  System.setProperty("webdriver.chrome.driver", "src\\Drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.amazon.in");
	  driver.manage().window().maximize();
	  String initialTitle = driver.getTitle();
	  System.out.println("Page tiltle: "+initialTitle);
	  driver.findElement(By.xpath("//a[contains(text(),'Amazon Pay')]")).click();
	  System.out.println("Title of page 2 : "+driver.getTitle());
	  driver.navigate().back();
	  String homeTitle = driver.getTitle();
	  System.out.println("Title of homepage: "+homeTitle);
	  Assert.assertEquals(initialTitle, homeTitle);
	  driver.close();
	  
	  
  
  
  }
}
