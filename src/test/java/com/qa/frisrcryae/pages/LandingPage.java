package com.qa.frisrcryae.pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.frisrcryae.base.BasePage;
import com.qa.frisrcryae.utills.AppConstants;
import com.qa.frisrcryae.utills.ElementActions;

public class LandingPage extends BasePage {

	WebDriver driver;
	Properties prop;
	ElementActions elementActions;

	// Locators
	By loginBtn = By.xpath("//a[text()='Login ']");
	By loginFrame = By.xpath("//iframe[@onload]");
	By emailIdField = By.xpath("//input[@id='loginPhoneFlag']");
	By loginWithPasswordBtn = By.xpath("//div[@id='loginWithPassBtn']");
	By passwordField = By.xpath("//input[@id='txtLPass']");
	By loginBtnAfterPass = By.xpath("//div[text()='Login']");
	By myAccount = By.xpath("//span[text()='My Account']");
	By searchBox = By.xpath("//input[@id='search_box']");
	By searchList = By.xpath("//div[@id='searchlist']//li");
	By placeHolderList = By.xpath("//div[@class='menu-container']//li");
	
	By contactUsLink = By.xpath("//span[text()='Contact Us']");
	By TrackOrderLink = By.xpath("//span[text()='Track Order']");
	By FirstCryParentingLink = By.xpath("//span[text()='FirstCry Parenting']");
	By RegisterLink = By.xpath("//a[text()=' Register']");
	By RegisterFrame = By.xpath("//div[@id='main-con']/iframe");
	By registerWithText = By.xpath("//p[text()='Or Register with']");
	By ShortListLink = By.xpath("//span[text()='Shortlist']");
	By FirstCryLogo = By.xpath("//img[@alt='logo']");
	
	
	
	
	// Constructor of page class:
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);

	}

	// Page action/methods
	public String getLandingPageTitle() {
		return elementActions.doGetPageTitle("Baby Products Online UAE, Kids Online Shopping, Baby Care Products at FirstCry.ae");
	}

	public boolean verifyLoginBtnIsAvailable() {
		elementActions.waitForElementClickable(loginBtn);
		return elementActions.doIsDisplayed(loginBtn);
	}

	public boolean verifySearchBoxIsAvailable() {
		return elementActions.doIsDisplayed(searchBox);
	}

	public boolean verifySearchBoxWorking(String text) {
		elementActions.getElement(searchBox).clear();
		elementActions.getElement(searchBox).sendKeys(text);
		elementActions.waitForElementVisible(searchList);

		System.out.println("List of Searched items contains -");
		for (int i = 0; i < elementActions.getElementsList(searchList).size(); i++) {
			String listText = elementActions.getElementsList(searchList).get(i).getText();
			String listTextLowercse = listText.toLowerCase();
			String textToLowserCase = text.toLowerCase();
			if (listTextLowercse.contains(textToLowserCase)) 
			{
				System.out.print(i + " - ");
				System.out.println(listText);
			
			}
			else {
				return false;
			}

		}
		return true;
	}
	
	public void verifyPlaceHolder()
	{
		elementActions.waitForElementVisible(placeHolderList);
		for(int i=0;i<elementActions.getElementsList(placeHolderList).size();i++)
		{
			System.out.println(elementActions.getElementsList(placeHolderList).get(i).getText());
		}
	}

	public boolean loginToApp(String username, String password) {
		elementActions.doClick(loginBtn);
		driver.switchTo().frame(elementActions.getElement(loginFrame));
		elementActions.waitForElementVisible(emailIdField);
		elementActions.doSendKeys(emailIdField, username);
		elementActions.waitForElementClickable(loginWithPasswordBtn);
		elementActions.doClick(loginWithPasswordBtn);
		elementActions.waitForElementClickable(passwordField);
		elementActions.doSendKeys(passwordField, password);
		elementActions.waitForElementClickable(loginBtnAfterPass);
		elementActions.doClick(loginBtnAfterPass);
		driver.switchTo().parentFrame();
		elementActions.getElement(myAccount);
		//elementActions.waitForElementVisible(myAccount);
		return elementActions.doIsDisplayed(myAccount);

	}

	public String verifyContactUsLinkOnHeader()
	{
		elementActions.waitForElementClickable(contactUsLink);
		elementActions.doClick(contactUsLink);
		elementActions.switchToWindowId(driver, 1);
		return elementActions.doGetPageTitle(AppConstants.CONTACT_US_PAGE_TITILE);
	}
	
	public boolean verifyTrackOrderLinkOnHeader(String textToBeInURL)
	{
		elementActions.waitForElementClickable(TrackOrderLink);
		elementActions.doClick(TrackOrderLink);
		elementActions.switchToWindowId(driver, 1);
		String currentURL = elementActions.doGetcurrentURL();
		if(currentURL.contains(textToBeInURL))
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifyFirstCryParentingLinkOnHeader(String textToBeInURL)
	{
		elementActions.waitForElementClickable(FirstCryParentingLink);
		elementActions.doClick(FirstCryParentingLink);
		elementActions.switchToWindowId(driver, 1);
		String currentURL = elementActions.doGetcurrentURL();
		if(currentURL.contains(textToBeInURL))
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifyRegisterLinkOnHeader()
	{
		elementActions.waitForElementClickable(RegisterLink);
		elementActions.doClick(RegisterLink);
		driver.switchTo().frame(elementActions.getElement(RegisterFrame));
		elementActions.waitForElementVisible(registerWithText);
		return elementActions.doIsDisplayed(registerWithText);
	}
	
	public boolean verifyShortListLinkOnHeader(String textToBeInURL)
	{
		elementActions.waitForElementClickable(ShortListLink);
		elementActions.doClick(ShortListLink);
		String currentURL = elementActions.doGetcurrentURL();
		if(currentURL.contains(textToBeInURL))
		{
			return true;
		}
		else {
			return false;
		}
	}
	public boolean verifyFirstCryLogoOnHeader()
	{
		elementActions.waitForElementVisible(FirstCryLogo);
		return elementActions.doIsDisplayed(FirstCryLogo);
	}
	


}
