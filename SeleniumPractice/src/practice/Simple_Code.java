package practice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class Simple_Code {
	WebDriver driver;


	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver","src\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("Title: "+title);
		driver.navigate().to("https://www.gmail.com/");
		System.out.println("Navigated to mail");
		driver.navigate().back();
		System.out.println("Navigated back");
		driver.navigate().forward();
		System.out.println("Navigated forward");
		driver.navigate().refresh();
		System.out.println("Refreshed the page");
		System.out.println("URL:"+driver.getCurrentUrl());
		driver.close();
		
	}

}
