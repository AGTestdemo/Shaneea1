package com.qa.Swaag.Tests;


import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import com.qa.Swaag.Page.LoginPage;
import com.qa.Swaag.Pages.Base.BaseClass;


public class LoginTest extends BaseClass{
	
@Test
public void loginApp() {
	logger = report.createTest("Login to Swaag Test");
	logger.info("Starting the browser");
	
	//ExcelDataProvider excel = new ExcelDataProvider();
	//ExcelDataProvider excel = new ExcelDataProvider();
	
	
LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

loginPage.loginToSwaag(excel.getDataFromExcel(0, 0, 0), excel.getDataFromExcel(0, 0, 1));
//Lib.capturesScreenshot(driver);

logger.pass("Test passed; login successful");

//logger.fail("Test failed, Logout was unsuccessfull");

}
}



     

          


