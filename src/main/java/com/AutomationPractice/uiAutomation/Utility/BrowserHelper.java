package com.AutomationPractice.uiAutomation.Utility;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BrowserHelper {

	private static final Logger Log = LoggerUtil.getLogger(BrowserHelper.class);

	/**
	 * Non Java Doc -> Utility method to click bowser forward button.
	 * 
	 * @param driver
	 */
	public static void goForward(WebDriver driver) {
		driver.navigate().forward();
		Log.info("Clicked to Browser forward -");
	}

	/**
	 * Non Java doc -> Utility to click browser back button.
	 * 
	 * @param driver
	 */
	public static void goBack(WebDriver driver) {
		driver.navigate().back();
		Log.info("Clicked to Browser back -");
	}

	/**
	 * Non Java doc -> utility to refresh web page.
	 * 
	 * @param driver
	 */
	public static void refresh(WebDriver driver) {
		driver.navigate().refresh();
		Log.info("Web Page refreshed.. ");
	}

	/**
	 * Non Java doc -> utility to get all window handle.
	 * 
	 * @param driver
	 * @return
	 */
	public static Set<String> getWindowhandels(WebDriver driver) {
		return driver.getWindowHandles();
	}

	/**
	 * Non Java doc -> utility to get parent windoe id.
	 * 
	 * @param driver
	 * @return
	 */
	public static String getParentWinId(WebDriver driver) {
		return driver.getWindowHandle();
	}
	/**
	 * public static void switchToWindow(WebDriver driver, String index) {
	 * driver.switchTo().window(index); }
	 **/
}
