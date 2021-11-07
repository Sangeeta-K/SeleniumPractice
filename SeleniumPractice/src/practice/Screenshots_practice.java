package practice;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

class Screenshots_practice {
	WebDriver driver;
	@Test
	void test() {
		try {
			System.setProperty("webdriver.chrome.driver", "src//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.google.com");
			driver.manage().window().maximize();
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("D:\\SeleniumDemos\\SeleniumPractice\\src\\Screenshots\\user_reg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
