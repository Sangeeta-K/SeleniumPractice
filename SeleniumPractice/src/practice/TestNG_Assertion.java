package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestNG_Assertion {
	
  WebDriver driver;
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver", "src\\Drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.godaddy.com/");
	  driver.manage().window().maximize();
	  String pageTitle = driver.getTitle();
	  Assert.assertEquals("https://in.godaddy.com/",driver.getCurrentUrl() );
	  System.out.println("Url is same");
	  if(driver.getPageSource().contains(pageTitle)) {
		  System.out.println("Page source has tiltle");  
	  }
	  driver.close();
	  
  }
}
