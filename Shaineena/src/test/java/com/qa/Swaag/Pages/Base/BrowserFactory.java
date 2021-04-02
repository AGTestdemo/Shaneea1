package com.qa.Swaag.Pages.Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	public static WebDriver openApplication(WebDriver driver, String browserName, String appUrl){

	if (browserName.equals("Chrome")){
       System.setProperty("webdriver.chrome.driver", "C:\\PS_QA\\Driver\\chromedriver.exe");
         driver = new ChromeDriver();//Creating the Obj of webdriver interface
	}
	else if (browserName.equals("Firefox")){
		System.setProperty("webdriver.gecko.driver", "C:\\PS_QA\\Driver\\geckodriver.exe");
		 driver = new FirefoxDriver();//Creating the Obj of webdriver interface
	}
	else if (browserName.equals("Edge")){
	}
	else {
		System.out.println("This browser is not supported");
	}
		
	
	driver.manage().window().maximize();//maximize the window
	driver.manage().deleteAllCookies();//deleting all the cookies
	driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);//page load timeout
	driver.get(appUrl);//opening the url
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//implicitwait
	
	return driver;
	}
	
	public static void quiteBrowser(WebDriver driver){
    driver.quit();
	
	}


}
