package com.AutomationPractice.uiAutomation.TestBase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.AutomationPractice.uiAutomation.BrowserConfig.BrowserType;
import com.AutomationPractice.uiAutomation.BrowserConfig.ChromeBrowser;
import com.AutomationPractice.uiAutomation.BrowserConfig.InternetExplorerBrowser;
import com.AutomationPractice.uiAutomation.Utility.PropertyFileReaderUtil;

public class TestBase {
	
	protected static WebDriver driver;
	
	private WebDriver getDriverInstance(BrowserType bType) throws Exception {
		try {
			switch(bType) {
			case chrome:
				return ChromeBrowser.getChromeDriver();
			case ie:
				return InternetExplorerBrowser.getIeDriver();
			default:
				throw new Exception("Not able to create instance for browser - "
						+ PropertyFileReaderUtil.getPropertyvalue("Browser"));
						}
		} catch (Exception e) {
			
			e.printStackTrace();
			throw e;
	}		
}
	
	private void setUpDriver (BrowserType bType) throws Exception {
		driver=getDriverInstance(bType);
		driver.manage().window().maximize();	
	}
	@BeforeMethod
	public void setUp() throws Exception {
		setUpDriver(BrowserType.valueOf(PropertyFileReaderUtil.getPropertyvalue("Browser")));
		driver.get(PropertyFileReaderUtil.getPropertyvalue("URL"));
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
