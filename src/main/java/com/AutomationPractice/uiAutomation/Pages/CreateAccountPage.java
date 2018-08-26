package com.AutomationPractice.uiAutomation.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.AutomationPractice.uiAutomation.TestBase.TestBase;
import com.AutomationPractice.uiAutomation.Utility.LoggerUtil;

public class CreateAccountPage extends TestBase  {
	private final Logger log = LoggerUtil.getLogger(CreateAccountPage.class);
	@FindBy(id="email_create")
	private WebElement emailCreateTxtBox;
	@FindBy(xpath="//button[@id='SubmitCreate']/span")
	private WebElement createAccountBtn;
	public CreateAccountPage ()
	{
		PageFactory.initElements(driver, this);		
	}
	public void createEmailId (String createAccountId) {
		log.info("Created account name is " + createAccountId);
		emailCreateTxtBox.sendKeys(createAccountId);
	}
	public void clickOnCreate()
	{
	log.info("Clicking on create account button...");
	createAccountBtn.click();
	}
}