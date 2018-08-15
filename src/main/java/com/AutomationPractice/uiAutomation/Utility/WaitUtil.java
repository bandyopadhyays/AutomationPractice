package com.AutomationPractice.uiAutomation.Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.AutomationPractice.uiAutomation.TestBase.TestBase;

public class WaitUtil extends TestBase {
	
	private static WebDriverWait wait;
	
	static {
		wait = new WebDriverWait(driver, Integer.valueOf(PropertyFileReaderUtil.getPropertyvalue("ExplicitWait")));
	}
	
	public static WebElement waitForElement (WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
