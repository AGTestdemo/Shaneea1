package com.qa.Swaag.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;

	
	public LoginPage(WebDriver ldriver){
		this.driver=ldriver;
	}
@FindBy(name="user-name") WebElement uName;
@FindBy(id="password") WebElement pWord;
@FindBy(xpath="//input[@id='login-button']") WebElement loginButton;

public void loginToSwaag(String username, String password){
	uName.sendKeys(username);
	pWord.sendKeys(password);
	loginButton.click();
}
	


}
