package com.AutomationPractice.uiAutomation.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutomationPractice.uiAutomation.TestBase.TestBase;
import com.AutomationPractice.uiAutomation.Utility.LoggerUtil;
import com.AutomationPractice.uiAutomation.Utility.WaitUtil;

public class MyAccountPage extends TestBase {

	private final Logger Log = LoggerUtil.getLogger(MyAccountPage.class);
	
	@FindBy(xpath = "//a[@title='Log me out']")
	private WebElement linkSignOut;
	
	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isLogin() {
		return WaitUtil.waitForElement(linkSignOut).isDisplayed();
		//return linkSignOut.isDisplayed();
	}
	
	public void clickOnLogOut() {
		Log.info("clicking on log out ..");
		linkSignOut.click();
	}

	
}
