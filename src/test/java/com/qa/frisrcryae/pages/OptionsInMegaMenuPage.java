package com.qa.frisrcryae.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.frisrcryae.base.BasePage;
import com.qa.frisrcryae.utills.ElementActions;
import com.qa.frisrcryae.utills.JavaScriptUtil;

public class OptionsInMegaMenuPage extends BasePage {

	WebDriver driver;
	Properties prop;
	ElementActions elementActions;
	JavaScriptUtil javaScriptUtil;

	String text = "T-shirts";
	
	// Locators
	private By Boy_FashionFromMegaMenu = By.xpath("//a[text()=' Boy Fashion']");
	private By Boy_FashionSubmenu = By.xpath("//a[text()='Shop By Category']/ancestor::ul//li/a[text()='"+text+"']");
	private By checkBox = By.xpath("//a[contains(text(),'"+text+"')]/ancestor::div//div[text()='SUBCATEGORIES :']");
	
	

	// Constructor of page class:
	public OptionsInMegaMenuPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}

	// Page action/methods
	public boolean verifyBoy_FashionSubmenu()
		{
			elementActions.waitForElementVisible(Boy_FashionFromMegaMenu);
			elementActions.doMoveToElement(Boy_FashionFromMegaMenu);
			elementActions.waitForElementClickable(Boy_FashionSubmenu);
			elementActions.doActionsClick(Boy_FashionSubmenu);
			elementActions.waitForElementVisible(checkBox);
			return elementActions.doIsDisplayed(checkBox);
		}

}
