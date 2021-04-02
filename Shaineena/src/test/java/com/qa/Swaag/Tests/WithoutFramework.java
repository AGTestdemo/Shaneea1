package com.qa.Swaag.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WithoutFramework {

	@ Test
	public static void loginTest(){
		
		//setting the property
		System.setProperty("webdriver.chrome.driver", "C:\\PS_QA\\Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();//Creating the Obj of webdriver interface
		
		
		driver.manage().window().maximize();//maximize the window
		driver.manage().deleteAllCookies();//deleting all the cookies
		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);//page load timeout
		driver.get("https://www.saucedemo.com/");//opening the url
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//implicitwait
		
		driver.findElement(By.name("user-name")).sendKeys("standard_user");//setting up the Username
		driver.findElement(By.id("password")).sendKeys("secret_sauce");//putting the password
		
		driver.findElement(By.xpath("//input[@id='login-button']")).click();//clicking the log in button
		
		driver.quit();
		
	}

}
