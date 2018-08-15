package com.AutomationPractice.uiAutomation.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutomationPractice.uiAutomation.TestBase.TestBase;
import com.AutomationPractice.uiAutomation.Utility.LoggerUtil;


public class SignInPage extends TestBase {
	
	private final Logger log = LoggerUtil.getLogger(SignInPage.class);
	
	@FindBy(id = "email")
	private WebElement eMailIdTxtBox;
	@FindBy(id = "passwd")
	private WebElement passwordTxtBox;
	@FindBy(xpath = "//button[@id='SubmitLogin']/span")
	private WebElement signInBtn;

	public SignInPage () {
		PageFactory.initElements(driver, this);
	}
	
	public void setEmailId (String emailId) {
		log.info("Emeil Id entered as " + emailId);
		eMailIdTxtBox.sendKeys(emailId);
	}
	
	public void setPassword (String password) {
		log.info("Password entered as " + password);
		passwordTxtBox.sendKeys(password);
	}
	
	public MyAccountPage clickOnSignIn() {
		log.info("Clicking on Sign In Button ..");
		signInBtn.click();
		return new MyAccountPage();
	}
}
