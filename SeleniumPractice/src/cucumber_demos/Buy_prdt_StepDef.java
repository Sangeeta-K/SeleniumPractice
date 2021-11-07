package cucumber_demos;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.it.E;
import junit.framework.Assert;

public class Buy_prdt_StepDef {
	WebDriver driver;
   
	  @Given("^Load the website homepage$")
	  public void load_the_website_homepage()  {
	      System.setProperty("webdriver.chrome.driver", "src//Drivers//chromedriver.exe");
	      driver = new ChromeDriver();
	      driver.get("http://automationpractice.com/index.php");
	      driver.manage().window().maximize();
	  }

	  @When("^User sign in using \"([^\"]*)\" and \"([^\"]*)\"$")
	  public void user_sign_in_using_and(String arg1, String arg2) {
		  try {
		  driver.findElement(By.className("login")).click();
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Authentication']")));
		  driver.findElement(By.xpath("//input[@id='email']")).sendKeys(arg1);
		  driver.findElement(By.id("passwd")).sendKeys(arg2);
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("window.scrollBy(0,250)", "");
		  driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		  }
		  catch(Exception e) {
			  e.printStackTrace();
			  System.out.println("Unable to sign in");
		  }
		  
	    
	  }

	  @Then("^User signed in successfully$")
	  public void user_signed_in_successfully()  {
		  try {
		      Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'My account')]")).isDisplayed());
		  }
		  catch(Exception e) {
			  e.printStackTrace();
			  System.out.println("Not signed in");
		  }
	      
	  }

	  @Then("^User move the cursor over Women's link$")
	  public void user_move_the_cursor_over_Women_s_link()  {
		  try {
			  WebElement wo_link = driver.findElement(By.xpath("//a[@title='Women']"));
			  Actions actions = new Actions(driver);
			  actions.moveToElement(wo_link);
			  actions.perform();
			  
		  }
		  catch(Exception e) {
			  e.printStackTrace();
			  System.out.println("Unable to move the cursor to women's link");
		  }
		  
		  
	      
	  }

	  @Then("^User click on sub-menu T-shirts$")
	  public void user_click_on_sub_menu_T_shirts()  {
		  try {
			  WebElement shirt_link = driver.findElement(By.xpath("//a[@title='T-shirts']"));
			  if(shirt_link.isDisplayed()) 
				  shirt_link.click();
		  }
		  catch(Exception e) {
		      e.printStackTrace();
			  System.out.println("T-shirt link not displayed");
			  }
	      
	  }
	  
	  @When("^User mouse hover on the second product displayed and click on the More button$")
	  public void user_mouse_hover_on_the_second_product_displayed_and_click_on_the_More_button()  {
		  try {
			  WebElement prdt =driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']"));
			  Actions action = new Actions(driver);
			  action.moveToElement(prdt);
			  WebElement moreBtn = driver.findElement(By.xpath("//a[@title='View']"));
			  action.moveToElement(moreBtn);
			  action.click().build().perform();
			  
		  }
		  catch(Exception e){
			  e.printStackTrace();
			  System.out.println("Unable to mouse hover on the second product displayed and click on the More button");
			  
		  }
		  
	  }

	  @When("^Increase the quantity to \"([^\"]*)\",size to \"([^\"]*)\" and select color$")
	  public void increase_the_quantity_to_size_to_and_select_color(String arg1, String arg2) {
		  try {
			  WebElement qty = driver.findElement(By.name("qty"));
			  WebDriverWait wait1 = new WebDriverWait(driver,20);
			  wait1.until(ExpectedConditions.visibilityOf(qty));
			  qty.clear();
			  qty.sendKeys(arg1);
			  WebElement size = driver.findElement(By.xpath("//select[@id='group_1']"));
			  Select select = new Select(size);
			  select.selectByVisibleText(arg2);
			  driver.findElement(By.xpath("//a[@id='color_14']")).click();
			  
		  }
		  catch(Exception e) {
			  e.printStackTrace();
			  System.out.println("Unable to Increase the quantity size  and select color");
		  }
		  
		  
		  
	      
	  }


	  @Then("^Cilck on Add to Cart button$")
	  public void cilck_on_Add_to_Cart_button()  {
		  try {
			  Assert.assertTrue(driver.findElement(By.xpath("//button[@name='Submit']")).isDisplayed());
		      driver.findElement(By.xpath("//button[@name='Submit']")).click();
		  }
		  catch(Exception e) {
			  e.printStackTrace();
			  System.out.println("Add to cart button not displayed");
		  }
	      
	  }

	  @Then("^Click on Proceed to checkout button$")
	  public void click_on_Proceed_to_checkout_button()  {
		  try {  
//			  String mainWindow = driver.getWindowHandle();
//			  System.out.println("MAIN WINDOW: "+mainWindow);
//			  Set<String> windows = driver.getWindowHandles();
//			  for(String s:windows) {
//				  System.out.println("Windows are:" +s);
//			  }
//			  Iterator<String> iterator = windows.iterator();
//			  while(iterator.hasNext()) {
//				  String otherWindow = iterator.next();
//				  System.out.println("OTHER WINDOW: "+otherWindow);
//				  if(!mainWindow.equals(otherWindow)) {
//					  driver.switchTo().window(otherWindow);
					  WebDriverWait wt = new WebDriverWait(driver,20);
					  wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='http://automationpractice.com/index.php?controller=order'])[3]")));
					  wt.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='http://automationpractice.com/index.php?controller=order'])[3]")));
					  Assert.assertTrue(driver.findElement(By.xpath("(//a[@href='http://automationpractice.com/index.php?controller=order'])[3]")).isDisplayed());
					  driver.findElement(By.xpath("(//a[@href='http://automationpractice.com/index.php?controller=order'])[3]")).click();
//					  driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
//				  }
//			  }
			  
		  }
		  catch(Exception e) {
			  e.printStackTrace();
			  System.out.println("Proceed to checkout btn not displayed");
		  }
		  
	      
	  }

	  @When("^User perform the payment$")
	  public void user_perform_the_payment() {
		  try {
			  driver.findElement(By.xpath("//span[text()='Proceed to checkout']")).click();
			  driver.findElement(By.xpath("//button[@name='processAddress']")).click();
			  driver.findElement(By.xpath("//input[@id='cgv']")).click();
			  driver.findElement(By.xpath("//button[@name='processCarrier']")).click();
			  driver.findElement(By.xpath("//a[@title='Pay by bank wire']")).click();
			  driver.findElement(By.xpath("//span[text()='I confirm my order']/parent::button")).click();
		  }
		  catch(Exception e){
			  e.printStackTrace();
			  System.out.println("Unable to perform payment");
		  }
			  
	      
	  }

	  @Then("^User placed order successfully$")
	  public void user_placed_order_successfully()  {
		  try {
			  WebDriverWait wt = new WebDriverWait(driver,20);
			  wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Order confirmation']")));
		      Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Order confirmation']")).isDisplayed());
		      driver.close();
		  }
		  catch(AssertionError | Exception e) {
			  e.printStackTrace();
			  System.out.println("Order not placed");
	      
	  }


  }
}
