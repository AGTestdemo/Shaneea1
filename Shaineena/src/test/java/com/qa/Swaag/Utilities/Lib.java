package com.qa.Swaag.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
public class Lib {
	
	// we will create a method for a screen shots
	
	public static String capturesScreenshot(WebDriver driver, String methodName){ //in order to pass the screen shots we have to create the webdriver reference 
		
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath= System.getProperty("user.dir")+"/Screenshots/Swaag_"+methodName+"_"+getCurrentDataTime()+".png";
		
		try {
			FileHandler.copy(src, new File(screenshotPath));
			System.out.println("Screenshot caputred.");
		} catch (IOException e) {
			System.out.println("unable to capture screenshot>>>"+e.getMessage());
		}
	return screenshotPath;
	
	}


	public static String getCurrentDataTime(){
	//DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
	
	DateFormat customFormat = new SimpleDateFormat("HH_mm_MM_dd_mm_yyyy");
	//Date currentDate= new Date();
	Date  currentDate= new Date();
	return customFormat.format(currentDate);

}

}


