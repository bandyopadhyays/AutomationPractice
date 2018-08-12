package com.AutomationPractice.uiAutomation.Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReaderUtil {

	private static Properties prop;

	static {

		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/resources/configFile/OR.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Non java doc -> method to read data from property file 
	 */
	public static String getPropertyvalue(String key) {
		return prop.getProperty(key);
}
}
