package com.AutomationPractice.uiAutomation.Utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerUtil {

	private static boolean root = false;

	/**
	 * Non Java doc -> utility method to create logger instance
	 * @param clz
	 * @return -> logger instance
	 */
	@SuppressWarnings("rawtypes")
	public static Logger getLogger(Class clz) {
		if (root) {
			return Logger.getLogger(clz);
		} else {
			PropertyConfigurator
					.configure(System.getProperty("user.dir") + "/src/main/resources/configFile/log4j.properties");
			return Logger.getLogger(clz);
		}
	}

}
