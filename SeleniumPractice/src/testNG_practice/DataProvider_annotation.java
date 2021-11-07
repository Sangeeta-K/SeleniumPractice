package testNG_practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class DataProvider_annotation {
	WebDriver driver;
 
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "src\\Drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.saucedemo.com/");
  }
  
  @DataProvider
  public Object[][] getData(){
	  Object[][] data = new Object[2][2];
	  data[0][0] ="standard_user";
	  
	return null;
	  
  }
  
  @Test
  public void f() {
	  
	  
	  
  }
  
 

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
