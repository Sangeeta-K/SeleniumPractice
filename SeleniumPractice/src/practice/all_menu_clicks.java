package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class all_menu_clicks {
	
	WebDriver driver;
  @Test
  public void test() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "src\\Drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.amazon.in");
	  driver.manage().window().maximize();
	  System.out.println("TITLE: " +driver.getTitle());
	  driver.findElement(By.className("hm-icon-label")).click();
	  System.out.println("CLICKED ON ALL");
	  driver.findElement(By.xpath("//div[@class='nav-sprite hmenu-close-icon']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[contains(text(),'Mobiles')]")).click();
	  if(driver.getCurrentUrl().contains("/mobile-phones/")) {
		  System.out.println("Clickked on mobile link");
	  }
	  driver.navigate().back();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[contains(text(),'Best Sellers')]")).click();
	  System.out.println("Clicked on Best Sellers link");
	  driver.navigate().back();
	  Thread.sleep(1000);
	  driver.close();
	  
	  
	  
	  
	  
	  
	  
	  
	  
  }
}
