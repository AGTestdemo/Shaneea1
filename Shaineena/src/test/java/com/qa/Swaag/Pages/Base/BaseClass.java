package com.qa.Swaag.Pages.Base;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.Swaag.Utilities.ConfigDataProvider;
import com.qa.Swaag.Utilities.ExcelDataProvider;
import com.qa.Swaag.Utilities.Lib;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	
@BeforeSuite
public void beforeSuite(){
	excel = new ExcelDataProvider();
	config= new ConfigDataProvider();
	ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Swaag_"+Lib.getCurrentDataTime()+".html"));
	report = new ExtentReports();
	report.attachReporter(extent);
	Reporter.log("Excel data, and config data reporter is ready.", true);
}

//after writing these classes at the test class you can remove them from that class then paste here to baseclass

	@BeforeClass
	public void openApplication(){
		Reporter.log("Reporter is ready. Preparing to open the browser and application.", true);
		driver= BrowserFactory.openApplication(driver, config.getBrowser("Browser"), config.getUrl("Url"));	// when you add the global driver the error from the driver will go away 	
		Reporter.log("The application is up and running.", true);
	}
	
		@AfterClass
	public void tearDown(){	
		BrowserFactory.quiteBrowser(driver);
		Reporter.log("The browser is closed.", true);
		
	}
		
	@AfterMethod
	
	public void afterMethod(ITestResult result) throws IOException{
		Reporter.log("Test is complete. preparing to capture screenshot.", true);
		if (result.getStatus()==ITestResult.FAILURE){
			Lib.capturesScreenshot(driver, result.getMethod().getMethodName());
			//logger.fail("Login failed", MediaEntityBuilder.createScreenCaptureFromPath(Lib.capturesScreenshot(driver, result.getMethod().getMethodName())).build());
			logger.fail("login Failed", MediaEntityBuilder.createScreenCaptureFromPath(Lib.capturesScreenshot(driver, result.getMethod().getMethodName())).build());
		}
		
		else if (result.getStatus()==ITestResult.SUCCESS){
			Lib.capturesScreenshot(driver, result.getMethod().getMethodName());
			//logger.fail("Login failed", MediaEntityBuilder.createScreenCaptureFromPath(Lib.capturesScreenshot(driver, result.getMethod().getMethodName())).build());
			logger.pass("login successful.", MediaEntityBuilder.createScreenCaptureFromPath(Lib.capturesScreenshot(driver, result.getMethod().getMethodName())).build());
		}
		report.flush();
		Reporter.log("Test is complete, check the html report >>>", true);
	}
	
}
