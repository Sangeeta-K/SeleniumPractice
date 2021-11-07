package practice;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class window_handling {
	WebDriver driver;
  @Test
  public void f() throws IOException {
	  System.setProperty("webdriver.chrome.driver", "src//Drivers//chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.way2automation.com/demo.html");
	  driver.manage().window().maximize();
	  
	  
	  //switching to another window and performing operations
//	  driver.findElement(By.xpath("//a[text()='Frames and Windows']")).click();
//	  try {
//	  String firstWindow = driver.getWindowHandle();
//	  Set<String> allWindows = driver.getWindowHandles();
//	  int flag=0;
//	  for(String s:allWindows) {
//		  if(!firstWindow.equals(s)) {
//			  driver.switchTo().window(s);
//			  System.out.println("Switched to required window");
//			  WebDriverWait wait = new WebDriverWait(driver,20);
//			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class='text_popup']/a[contains(text(),'ENTER TO THE TESTING WEBSITE')])[2]")));
//			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[@class='text_popup']/a[contains(text(),'ENTER TO THE TESTING WEBSITE')])[2]")));
//			  driver.findElement(By.xpath("(//p[@class='text_popup']/a[contains(text(),'ENTER TO THE TESTING WEBSITE')])[2]")).click();
//			  flag=1;
//			  
//		  }
//	  }
//	  if(flag==1) {
//		  System.out.println("PERFORMED REQD OPERATIONS");
//	  }
//	  }
//	  catch(AssertionError | Exception e) {
//		  e.printStackTrace();
//	  }
	  
	  
	  
//	  driver.findElement(By.xpath("(//p[@class='text_popup']/a[contains(text(),'ENTER TO THE TESTING WEBSITE')])[2]")).click();
//	  driver.findElement(By.xpath("//img[@alt='frames-and-windows']")).click();
//	  WebDriverWait wait = new WebDriverWait(driver,20);
//	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Dummy Registration Form']")));

	  
	  
	  //finding the desired window
//	  String msg = " ";
//	  Set<String> windows = driver.getWindowHandles();
//	  System.out.println("No of windows: "+windows.size());
//	  for(String s:windows) {
//		  System.out.println("Window handles: "+s);  
//		  driver.switchTo().window(s);
//		  System.out.println(driver.getTitle());
//		  if(driver.getTitle().equals("Welcome to the Test Site")) {
//			  msg ="window found";
//		  }
//	  }
//	  if(msg.equals("window found")) {
//		  System.out.println("Found");
//	  }
//	  else {
//		  System.out.println("Not found");
//	  }
//	  

	  //switching to sub window and performing various operations and switching to child window and printing the text(both using while)
	  try {
	  driver.findElement(By.xpath("//a[text()='Frames and Windows']")).click();
	  String initialWindow = driver.getWindowHandle();
	  Set<String> activeWindows = driver.getWindowHandles();
	  Iterator<String> it = activeWindows.iterator();
	  while(it.hasNext()) {
		  String nextWindow = it.next();
		  if(!initialWindow.equals(nextWindow)) {
			  driver.switchTo().window(nextWindow);
			  WebDriverWait wt = new WebDriverWait(driver,20);
			  wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@class='text_popup']/a[contains(text(),'ENTER TO THE TESTING WEBSITE')])[2]")));
			  wt.until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[@class='text_popup']/a[contains(text(),'ENTER TO THE TESTING WEBSITE')])[2]")));
			  driver.findElement(By.xpath("(//p[@class='text_popup']/a[contains(text(),'ENTER TO THE TESTING WEBSITE')])[2]")).click();
			  WebElement txt = driver.findElement(By.xpath("//h1[contains(text(),'Practice your Automation scripts here... ')]"));
			  WebDriverWait wait1 = new WebDriverWait(driver,20);
			  wait1.until(ExpectedConditions.visibilityOf(txt));
			  driver.findElement(By.xpath("//h2[contains(text(),'Frames and Windows')]/following-sibling::figure/img")).click();
			  
			  
		  }
	  }
	  
	  //opening the child window
	  Set<String> openWindows = driver.getWindowHandles();
	  System.out.println("NO OF WINDOWS OPEN: "+openWindows.size());
	  Iterator<String> iterator2 = openWindows.iterator();
	  while(iterator2.hasNext()) {
		  String otherWindow = iterator2.next();
		  if(!initialWindow.equals(otherWindow)) {
			  driver.switchTo().window(otherWindow);
			  if(driver.getCurrentUrl().equals("https://www.way2automation.com/way2auto_jquery/frames-and-windows.php#load_box")) {
				  System.out.println("IN IF");
				  System.out.println("Switched to reqd window");
				  driver.findElement(By.xpath("//a[contains(text(),'Open Seprate New Window')]")).click();
				  System.out.println("Total no: of frames : "+driver.findElements(By.tagName("iframe")));
				  driver.switchTo().frame(1);
				  driver.findElement(By.xpath("//title[contains(text(),'Open New Seprate Window')]/parent::head/following-sibling::body//a")).click();
				  System.out.println("Clicked on the link");
			  }
			  else {
				  System.out.println("IN ELSE");
				  System.out.println(otherWindow);
			  }
		  }
	  }
	  
	  
	  //closing all other window except the needed windows
	  Set<String> allWins = driver.getWindowHandles();
	  Iterator<String> itr = allWins.iterator();
	  while(itr.hasNext()) {
		  if(!driver.getCurrentUrl().contains("frames")) {
			  driver.close();
		  }
		  String nxtWin = itr.next();
		  driver.switchTo().window(nxtWin);
		  
	  }
	  
	  //switching to the child window and priniting the text
	  String parentWindow = driver.getWindowHandle();
	  Set<String> bothWindows = driver.getWindowHandles();
	  for(String s:bothWindows) {
		  System.out.println(" WINDOWS: "+s);  
	  }
//	  Iterator<String> itr2 = bothWindows.iterator();
//	  driver.switchTo().frame(1);
//	  System.out.println("Switched to needed frame");
//	  while(itr2.hasNext()) {
//		  String childWindow = itr2.next();
//		  System.out.println("CHILD: "+childWindow);
//		  System.out.println("PARENT: "+parentWindow);
//		  if(!parentWindow.equals(childWindow)) {
			  System.out.println("IN HERE");
//			  driver.switchTo().window(parentWindow);
//			  System.out.println("Switched to child window");
//			  driver.close();
			  System.out.println(driver.findElement(By.xpath("//div[@class='farme_window']//a")).getText());
			  System.out.println("DONE");
			  driver.quit();
			  
//		  }
//	  }
	  
	  
	  }
	  catch(AssertionError | Exception e) {
		  e.printStackTrace();
		  File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(srcFile, new File("src\\Screenshots\\img_window.png"));
		  
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
//	  String currentWindow = driver.getWindowHandle();
//	  Set<String> window = driver.getWindowHandles();
//	  Iterator<String> iterator = window.iterator();
//	  while(iterator.hasNext()) {
//		  String childWindow = iterator.next();
//		  if(!currentWindow.equals(childWindow)) {
//			  
//			  
//		  }
//	  }
	  
	  
	  
	  
  }
}
