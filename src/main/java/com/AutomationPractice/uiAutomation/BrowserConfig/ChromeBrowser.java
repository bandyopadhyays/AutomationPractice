package com.AutomationPractice.uiAutomation.BrowserConfig;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.AutomationPractice.uiAutomation.Utility.LoggerUtil;

public class ChromeBrowser {

	
	private static Logger log= LoggerUtil.getLogger(ChromeBrowser.class);
	
	public static WebDriver getChromeDriver() {
		log.info("Initializing chrome driver..." );
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/driverServer/chromedriver.exe");
		return new ChromeDriver();
	}
}
