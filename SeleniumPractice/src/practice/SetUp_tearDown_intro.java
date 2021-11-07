package practice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class SetUp_tearDown_intro {
	
	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
	}

	
	@Test
	void test() {
		System.out.println("TITLE:"+driver.getTitle());
		System.out.println("URL: "+driver.getCurrentUrl());
		
	}
	
	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}


}
