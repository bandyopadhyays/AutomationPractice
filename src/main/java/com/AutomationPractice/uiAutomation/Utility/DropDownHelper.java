package com.AutomationPractice.uiAutomation.Utility;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownHelper {

	private static final Logger Log = LoggerUtil.getLogger(DropDownHelper.class);
	private static Select oSelect;
		
	public static void selectByIndex(WebElement element, String option) {
		oSelect = new Select(element);
		oSelect.selectByVisibleText(option);
		Log.info("Locator : " + element + " Value : " + option);
	}
	public static void selectByValue(WebElement element, String option) {
		oSelect = new Select(element);
		oSelect.selectByValue(option);
		Log.info("Locator : " + element + " Value : " + option);
	}	
	public static void selectByVisibleText(WebElement element, String option) {
		oSelect = new Select(element);
		oSelect.selectByVisibleText(option);
		Log.info("Locator : " + element + " Value : " + option);
	}
}
