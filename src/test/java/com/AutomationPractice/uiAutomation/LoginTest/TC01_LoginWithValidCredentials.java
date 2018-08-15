package com.AutomationPractice.uiAutomation.LoginTest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.AutomationPractice.uiAutomation.Pages.LoginPage;
import com.AutomationPractice.uiAutomation.Pages.MyAccountPage;
import com.AutomationPractice.uiAutomation.Pages.SignInPage;
import com.AutomationPractice.uiAutomation.TestBase.TestBase;
import com.AutomationPractice.uiAutomation.Utility.LoggerUtil;

public class TC01_LoginWithValidCredentials extends TestBase {

	private final Logger log = LoggerUtil.getLogger(TC01_LoginWithValidCredentials.class);

	@Test
	public void loginWithValidCredentials() {
		log.info("Started Test Case - " + TC01_LoginWithValidCredentials.class.getName());
		LoginPage objLoginPage = new LoginPage();
		SignInPage objSignInPage;
		MyAccountPage objMyAccountPage;
		objSignInPage = objLoginPage.clickOnSignIn();
		objSignInPage.setEmailId("test_suman@test.com");
		objSignInPage.setPassword("Passward1");
		objMyAccountPage = objSignInPage.clickOnSignIn();
		Assert.assertTrue(objMyAccountPage.isLogin());
		objMyAccountPage.clickOnLogOut();

	}
}