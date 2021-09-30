package com.syniverse;

import java.util.ResourceBundle;
import java.awt.*;
import java.io.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomepageTitleTest {
	//static String URL = "https://mysyniverse.syniverse.com/";
			@Test
			public void HpageTitleTest() throws InterruptedException {
				// TODO Auto-generated method stub
				//System.setProperty("webdriver.chrome.driver", "C:\\Users\\g706427\\Box Sync\\eclipse\\chromedriver.exe");
				System.setProperty("java.awt.headless", "false");
				ResourceBundle rb = ResourceBundle.getBundle("config");
				String url = rb.getString("url");
				String uname = rb.getString("username");
				String passwd = rb.getString("password");
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				//driver.get("https://mysyniverse.syniverse.com");
				driver.get(url);
				driver.findElement(By.id("login-email-field")).sendKeys(uname);
				driver.findElement(By.id("login-password-field")).sendKeys(passwd);
				driver.findElement(By.id("log-in-button")).click();
				Thread.sleep(3000);
				//driver.findElement(By.cssSelector("input[type='submit']")).click();
				String title_h = driver.getTitle();
				Assert.assertEquals(title_h,"Trending - CodePen");
				System.out.println(title_h);
				driver.close();	
				driver.quit();
			}
}
