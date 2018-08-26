package com.AutomationPractice.uiAutomation.LoginTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import com.AutomationPractice.uiAutomation.Pages.LoginPage;
import com.AutomationPractice.uiAutomation.Pages.CreateAccountPage;
import com.AutomationPractice.uiAutomation.Pages.PersonalInfoPage;
import com.AutomationPractice.uiAutomation.Pages.MyAccountPage;
import com.AutomationPractice.uiAutomation.TestBase.TestBase;
import com.AutomationPractice.uiAutomation.Utility.ExcelReader;
import com.AutomationPractice.uiAutomation.Utility.LoggerUtil;

public class TC03_PutYourPersonalInfo extends TestBase {
	private final Logger log = LoggerUtil.getLogger(TC03_PutYourPersonalInfo.class);
	@Test
	public void PutYourPersonalInfo () throws InterruptedException {
		log.info("Personal Info filling up - "+TC03_PutYourPersonalInfo.class.getName());
		LoginPage objLoginPage = new LoginPage();
		CreateAccountPage createAcctPage = new CreateAccountPage();
		PersonalInfoPage objPersoInfoPage = new PersonalInfoPage();
		MyAccountPage objMyAccountPage = new MyAccountPage();
		objLoginPage.clickOnSignIn();
		createAcctPage.createEmailId(ExcelReader.getDataFromExcel("Registration_Data", "Email_ID", 1));
		createAcctPage.clickOnCreate();
		//Thread.sleep(10000);
		objPersoInfoPage.clickOnMr();
		//objPersoInfoPage.clickOnMrs();
		objPersoInfoPage.setFirstName(ExcelReader.getDataFromExcel("Registration_Data", "First_Name", 1));
		objPersoInfoPage.setLastName(ExcelReader.getDataFromExcel("Registration_Data", "Last_Name", 1));
		objPersoInfoPage.setPassword(ExcelReader.getDataFromExcel("Registration_Data", "Passward", 1));
		objPersoInfoPage.setDateOfBirth(ExcelReader.getDataFromExcel("Registration_Data", "Birth_Date", 1));
		objPersoInfoPage.setDateOfMonth(ExcelReader.getDataFromExcel("Registration_Data", "Birth_Month", 1));
		objPersoInfoPage.setDateOfYear(ExcelReader.getDataFromExcel("Registration_Data", "Birth_Year", 1));
		objPersoInfoPage.setAddress(ExcelReader.getDataFromExcel("Registration_Data", "Address", 1));
		objPersoInfoPage.setCity(ExcelReader.getDataFromExcel("Registration_Data", "City", 1));
		objPersoInfoPage.clickOnState();
		objPersoInfoPage.setZipCode(ExcelReader.getDataFromExcel("Registration_Data", "Zip_Code", 1));
		objPersoInfoPage.setMobileNo(ExcelReader.getDataFromExcel("Registration_Data", "Mobile_No", 1));
		objMyAccountPage = objPersoInfoPage.clickOnRegister();
		Assert.assertTrue(objMyAccountPage.isLogin());
		objMyAccountPage.clickOnLogOut();
	}
}
	