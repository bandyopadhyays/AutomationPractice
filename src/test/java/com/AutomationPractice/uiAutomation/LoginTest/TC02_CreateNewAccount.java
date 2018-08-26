package com.AutomationPractice.uiAutomation.LoginTest;

import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import com.AutomationPractice.uiAutomation.Pages.CreateAccountPage;
import com.AutomationPractice.uiAutomation.Pages.LoginPage;
import com.AutomationPractice.uiAutomation.TestBase.TestBase;
import com.AutomationPractice.uiAutomation.Utility.ExcelReader;
import com.AutomationPractice.uiAutomation.Utility.LoggerUtil;

public class TC02_CreateNewAccount extends TestBase{
	private final Logger log = LoggerUtil.getLogger(TC02_CreateNewAccount.class);
	
	@Test
	public void TC02_CreateNewAccounts () {
		
		log.info("Started Test Case - " + TC02_CreateNewAccount.class.getName() );
		LoginPage objLoginPage = new LoginPage();
		CreateAccountPage createAcctPage = new CreateAccountPage();
		objLoginPage.clickOnSignIn();
		createAcctPage.createEmailId(ExcelReader.getDataFromExcel("Registration_Data", "Email_ID", 1));
		createAcctPage.clickOnCreate();
	}
}
	
