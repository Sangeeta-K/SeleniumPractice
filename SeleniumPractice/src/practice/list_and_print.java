package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class list_and_print {
	WebDriver driver;
  @Test
  public void test() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "src//Drivers//chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://www.google.com");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@aria-label='Search']")).sendKeys("books");
	  WebElement total_list = driver.findElement(By.xpath("//ul[@role='listbox']"));
	  List<WebElement> search_list = total_list.findElements(By.tagName("li"));
	  System.out.println("Size of the list: "+search_list.size());
	  System.out.println("Items in the search list: ");
	  for(int i=0;i<search_list.size();i++) {
		  System.out.println(search_list.get(i).getText());
	  }
	  driver.close();  
  }
}
