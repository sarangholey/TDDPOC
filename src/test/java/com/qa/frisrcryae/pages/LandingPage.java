package com.qa.frisrcryae.pages;

import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.qa.frisrcryae.base.BasePage;
import com.qa.frisrcryae.utills.AppConstants;
import com.qa.frisrcryae.utills.ElementActions;

public class LandingPage extends BasePage {

	WebDriver driver;
	Properties prop;
	ElementActions elementActions;
	
	Logger log = Logger.getLogger(LandingPage.class);

	// Locators
	private By loginBtn = By.xpath("//a[text()='Login ']");
	private By loginFrame = By.xpath("//iframe[@onload]");
	private By emailIdField = By.xpath("//input[@id='loginPhoneFlag']");
	private By loginWithPasswordBtn = By.xpath("//div[@id='loginWithPassBtn']");
	private By passwordField = By.xpath("//input[@id='txtLPass']");
	private By loginBtnAfterPass = By.xpath("//div[text()='Login']");
	private By myAccount = By.xpath("//span[text()='My Account']");
	private By searchBox = By.xpath("//input[@id='search_box']");
	private By searchList = By.xpath("//div[@id='searchlist']//li");
	private By placeHolderList = By.xpath("//div[@class='menu-container']//li");
	
	private By contactUsLink = By.xpath("//span[text()='Contact Us']");
	private By TrackOrderLink = By.xpath("//span[text()='Track Order']");
	private By FirstCryParentingLink = By.xpath("//span[text()='FirstCry Parenting']");
	private By RegisterLink = By.xpath("//a[text()=' Register']");
	private By RegisterFrame = By.xpath("//div[@id='main-con']/iframe");
	private By registerWithText = By.xpath("//p[text()='Or Register with']");
	private By ShortListLink = By.xpath("//span[text()='Shortlist']");
	private By FirstCryLogo = By.xpath("//img[@alt='logo']");
	//footer links
	private By Boys_ClothesLink = By.xpath("//a[text()='Boys Clothes']");  
	private By Girls_ClothesLink = By.xpath("//a[text()='Girls Clothes']");
	private By Baby_And_Kids_FootwearLink = By.xpath("//a[text()='Baby & Kids Footwear']");
	private By Baby_And_Kids_ToysLink = By.xpath("//a[text()='Baby & Kids Toys']");
	private By Kids_Books_And_CDsLink = By.xpath("//a[text()='Kids Books &  CDs']");
	private By Baby_DiaperingLink = By.xpath("//a[text()='Baby Diapering']");
	
	// Constructor of page class:
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);

	}

	// Page action/methods
	public String getLandingPageTitle() {
		log.info("Launching URL");
		log.info("Application Title is - " +
				elementActions.doGetPageTitle("Baby Products Online UAE, Kids Online Shopping, Baby Care Products at FirstCry.ae"));
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
	
	public boolean verifyBoys_ClothesLink()
	{
		elementActions.waitForElementClickable(Boys_ClothesLink);
		elementActions.doClick(Boys_ClothesLink);
		elementActions.switchToWindowId(driver, 1);
		String cuurentUrl = elementActions.doGetcurrentURL();
		if(cuurentUrl.contains("boys-clothes"))
		{
			System.out.println("After clicking Boys_clothesLink current URL is -> " + cuurentUrl);
			return true;
		}
		else {
			System.out.println("After clicking Boys_clothesLink current URL is -> " + cuurentUrl);
			return false;
		}
	}
	
	public boolean verifyGirls_ClothesLink()
	{
		elementActions.waitForElementClickable(Girls_ClothesLink);
		elementActions.doClick(Girls_ClothesLink);
		elementActions.switchToWindowId(driver, 1);
		String cuurentUrl = elementActions.doGetcurrentURL();
		if(cuurentUrl.contains("girls-clothes"))
		{
			System.out.println("After clicking Girls_ClothesLink current URL is -> " + cuurentUrl);
			return true;
		}
		else {
			System.out.println("After clicking Girls_ClothesLink current URL is -> " + cuurentUrl);
			return false;
		}
	} 
	
	public boolean verifyBaby_And_Kids_FootwearLink()
	{
		elementActions.waitForElementClickable(Baby_And_Kids_FootwearLink);
		elementActions.doClick(Baby_And_Kids_FootwearLink);
		elementActions.switchToWindowId(driver, 1);
		String cuurentUrl = elementActions.doGetcurrentURL();
		if(cuurentUrl.contains("baby-kids-footwear"))
		{
			System.out.println("After clicking Baby_And_Kids_FootwearLink current URL is -> " + cuurentUrl);
			return true;
		}
		else {
			System.out.println("After clicking Baby_And_Kids_FootwearLink current URL is -> " + cuurentUrl);
			return false;
		}
	}
	
	public boolean verifyBaby_And_Kids_ToysLink()
	{
		elementActions.waitForElementClickable(Baby_And_Kids_ToysLink);
		elementActions.doClick(Baby_And_Kids_ToysLink);
		elementActions.switchToWindowId(driver, 1);
		String cuurentUrl = elementActions.doGetcurrentURL();
		if(cuurentUrl.contains("baby-kids-toys-store"))
		{
			System.out.println("After clicking Baby_And_Kids_FootwearLink current URL is -> " + cuurentUrl);
			return true;
		}
		else {
			System.out.println("After clicking Baby_And_Kids_FootwearLink current URL is -> " + cuurentUrl);
			return false;
		}
	} 
	
	public boolean verifyKids_Books_And_CDsLink()
	{
		elementActions.waitForElementClickable(Kids_Books_And_CDsLink);
		elementActions.doClick(Kids_Books_And_CDsLink);
		elementActions.switchToWindowId(driver, 1);
		String cuurentUrl = elementActions.doGetcurrentURL();
		if(cuurentUrl.contains("kids-books-cds"))
		{
			System.out.println("After clicking Baby_And_Kids_FootwearLink current URL is -> " + cuurentUrl);
			return true;
		}
		else {
			System.out.println("After clicking Baby_And_Kids_FootwearLink current URL is -> " + cuurentUrl);
			return false;
		}
	} 
	
	public boolean verifyBaby_DiaperingLink()
	{
		elementActions.waitForElementClickable(Baby_DiaperingLink);
		elementActions.doClick(Baby_DiaperingLink);
		elementActions.switchToWindowId(driver, 1);
		String cuurentUrl = elementActions.doGetcurrentURL();
		if(cuurentUrl.contains("diapering"))
		{
			System.out.println("After clicking Baby_And_Kids_FootwearLink current URL is -> " + cuurentUrl);
			return true;
		}
		else {
			System.out.println("After clicking Baby_And_Kids_FootwearLink current URL is -> " + cuurentUrl);
			return false;
		}
	}
	
	public void verifyBrokenLinksCountOnLandingPage()
	{
		int countOfBrokenLinks=0;
		List<WebElement> listOfLinks =  elementActions.getTagCount("a", driver);
		for(int i=0;i<listOfLinks.size();i++)
		{
			System.out.println(listOfLinks.get(i).getAttribute("href"));
//			if((listOfLinks.get(i).getAttribute("href").equals("")))
//			{
//				countOfBrokenLinks = countOfBrokenLinks + 1;
//			}
		}
		System.out.println("The Count of brokenLinks is - " + countOfBrokenLinks);
		
	}


}
