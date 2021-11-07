package practice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

class Page_Title_validation {
	
	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(" https://www.godaddy.com/");
		driver.manage().window().maximize();
		
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}

	@Test
	void test() {
		String actualTitle = driver.getTitle();
		System.out.println("actualTitle: "+actualTitle);
		String expectedTitle = "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN";
		if(actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("Title is same");
		}
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current url: "+currentUrl);
		String expectedUrl = "https://in.godaddy.com/";
	
	}

}
