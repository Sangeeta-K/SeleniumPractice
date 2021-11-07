package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class table {
	WebDriver driver;
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver", "src//Drivers//chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
	  driver.manage().window().maximize();
	  
	  //Print all the elements in the table ---> headings included
	  WebElement table = driver.findElement(By.className("tsc_table_s13"));
//	  List<WebElement> rows = table.findElements(By.tagName("tr"));
//	  for(WebElement el:rows) {
//		  System.out.println();
//		  List<WebElement> col = el.findElements(By.tagName("td")); // for headings
//		  List<WebElement> headings = el.findElements(By.tagName("th"));
//		  for(WebElement h:headings) {
//			  System.out.print("          "+h.getText());
//		  }
//		  for(WebElement c:col) {
//			  System.out.print("            "+c.getText());
//		  }
//	  }
//	  driver.close();
	  
	  
	  //Read structure column and print no of elements(using rows and cols)
//	  List<WebElement> rows = table.findElements(By.tagName("tr"));
//	  int count =0;
//	  for(int i=2;i<rows.size();i++) {
//		  List<WebElement> structures = rows.get(i).findElements(By.tagName("th"));
//		  for(WebElement s :structures)
//			  System.out.println("ELEMENTS: "+s.getText()); 
//		      count++;
//		      
//	  }
//	  System.out.println("TOTAL NO OF STRUCTURES: "+count);
//	  driver.close();
	  
	
	  
	  //Verify that Burj Khalifa has a height of 829m (similar for other structures)
	  List<WebElement> rows = table.findElements(By.tagName("tr"));
	  for(WebElement row:rows) {
//		  System.out.println(row.getText());
		  if(row.getText().contains("Burj Khalifa")) {
			  List<WebElement> sp = row.findElements(By.tagName("td"));
			  System.out.println("3rd value:"+sp.get(2).getText());
			  if(sp.get(2).getText().equals("829m")) {
				  System.out.println("Height is same");
			  }
					  
		  }
		  else if(row.getText().contains("Clock Tower Hotel")) {
			  List<WebElement> sp = row.findElements(By.tagName("td"));
			  if(sp.get(2).getText().equals("601m")) {
				  System.out.println("Height is same for clk tower");
				  
			  }
		  }
		  else if(row.getText().contains("Taipei 101")) {
			  List<WebElement> sp = row.findElements(By.tagName("td"));
			  if(sp.get(2).getText().equals("509m")) {
				  System.out.println("Height is same for T 101");
			  }
		  }
		  else if(row.getText().contains("Financial Center")) {
			  List<WebElement> sp = row.findElements(By.tagName("td"));
			  if(sp.get(2).getText().equalsIgnoreCase("492m")) {
				  System.out.println("Height is same for FC");
			  }
		  }
			  
	  }
	  driver.close();
	  
  }
  
}
