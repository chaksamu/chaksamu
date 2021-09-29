package com.syniverse;

import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTitleTest {
	//static String URL = "https://mysyniverse.syniverse.com/";
		@Test
		public void loginPageTitleTest() {
			// TODO Auto-generated method stub
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\g706427\\Box Sync\\eclipse\\chromedriver.exe");
			System.setProperty("java.awt.headless", "true");
			ResourceBundle rb = ResourceBundle.getBundle("config");
			String url = rb.getString("url");
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			//driver.get("https://mysyniverse.syniverse.com");
			driver.get(url);
			String title_l = driver.getTitle();
			Assert.assertEquals(title_l,"Portal Login");
			System.out.println(title_l);
			driver.close();
		}
}
