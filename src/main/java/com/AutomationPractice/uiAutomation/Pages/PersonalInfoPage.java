package com.AutomationPractice.uiAutomation.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.AutomationPractice.uiAutomation.TestBase.TestBase;
import com.AutomationPractice.uiAutomation.Utility.DropDownHelper;
import com.AutomationPractice.uiAutomation.Utility.LoggerUtil;
import com.AutomationPractice.uiAutomation.Utility.WaitUtil;

public class PersonalInfoPage extends TestBase{
	
	private final Logger log = LoggerUtil.getLogger(PersonalInfoPage.class);
	
	@FindBy(xpath="//input[@id='id_gender1']")
	private WebElement radioMrBtn;
	/*@FindBy(xpath="//input[@id='id_gender2']")
	private WebElement radioMrsBtn;*/
	@FindBy(id="customer_firstname")
	private WebElement firstNameTxtbox;
	@FindBy(id="customer_lastname")
	private WebElement lastNameTxtbox;
	@FindBy(id="passwd")
	private WebElement passwardTxtbox;
	@FindBy(id="days")
	private WebElement daysDropdown;
	@FindBy(id="months")
	private WebElement monthsDropdown;
	@FindBy(id="years")
	private WebElement yearsDropdown;
	@FindBy(id="address1")
	private WebElement addressTxtbox;
	@FindBy(id="city")
	private WebElement cityTxtbox;
	@FindBy(id="id_state")
	private WebElement stateDropDn;
	@FindBy(id="postcode")
	private WebElement zipCode;
	@FindBy(id="phone_mobile")
	private WebElement mobileNotxtbox;
	@FindBy(xpath="//button[@id='submitAccount']/span")
	private WebElement registerBtn;
	@FindBy(xpath = "//a[@title='Log me out']")
	private WebElement linkSignOut;
	
	public PersonalInfoPage ()
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOnMr() {
		log.info("Clicking on Mr Button ..");
		WaitUtil.waitForElement(radioMrBtn).click();
	}
	/*public void clickOnMrs() {
		log.info("Clicking on Mrs Button ..");
		radioMrsBtn.click();
	}*/
	public void setFirstName (String firstName) {
		log.info("First Name Entered as " + firstName);
		firstNameTxtbox.sendKeys(firstName);
	}
	public void setLastName (String lastName) {
		log.info("Last Name Entered as " + lastName);
		lastNameTxtbox.sendKeys(lastName);
	}
	public void setPassword (String password) {
		log.info("Password Entered as " + password);
		passwardTxtbox.sendKeys(password);
	}
	public void setDateOfBirth (String birthDate) {
		//daysDropdown.click();
		//Select objSelect = new Select(daysDropdown);
		//log.info("You are selected day is "+visibleTest);
		//objSelect.selectByValue(visibleTest);
		//objSelect.selectByVisibleText(visibleTest);
		DropDownHelper.selectByValue(daysDropdown, birthDate);
	}
	public void setDateOfMonth (String birthMonth) {
		DropDownHelper.selectByValue(monthsDropdown, birthMonth);
	}
	public void setDateOfYear (String birthYear) {
		DropDownHelper.selectByValue(yearsDropdown, birthYear);
	}
	public void setAddress (String address) {
		log.info("Address Entered as " + address);
		addressTxtbox.sendKeys(address);
	}
	public void setCity (String city) {
		log.info("City Entered as "+city);
		cityTxtbox.sendKeys(city);
	}
	public void clickOnState () {
		log.info("Selected the city - ");
		stateDropDn.click();
		Select objSelect = new Select(stateDropDn);
		objSelect.selectByIndex(1);
	}
	public void setZipCode (String zip) {
		log.info("Zip Code Entered as " + zip);
		zipCode.sendKeys(zip);
	}
	public void setMobileNo (String mobile) {
		log.info("Mobile Entered as " + mobile);
		mobileNotxtbox.sendKeys(mobile);
	}
	public MyAccountPage clickOnRegister () {
		log.info("Clicking on Register Button.. ");
		registerBtn.click();
		return new MyAccountPage();
	}
}

