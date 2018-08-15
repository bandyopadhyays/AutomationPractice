package com.AutomationPractice.uiAutomation.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutomationPractice.uiAutomation.TestBase.TestBase;
import com.AutomationPractice.uiAutomation.Utility.LoggerUtil;

public class LoginPage extends TestBase {

	private final Logger Log = LoggerUtil.getLogger(LoginPage.class);

	@FindBy(xpath = "//a[@title='Log in to your customer account']")
	private WebElement signInButton;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public SignInPage clickOnSignIn() {
		Log.info("Clicking on element - " + signInButton.getText());
		signInButton.click();
		
		return new SignInPage(); 
	}

}
