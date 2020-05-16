package com.qa.frisrcryae.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.frisrcryae.base.BasePage;
import com.qa.frisrcryae.utills.ElementActions;
import com.qa.frisrcryae.utills.JavaScriptUtil;

public class MegaMenuProductsPage extends BasePage {
	
	WebDriver driver;
	Properties prop;
	ElementActions elementActions;
	JavaScriptUtil javaScriptUtil;
	
	// Locators
	private By Boy_FashionFromMegaMenu = By.xpath("//a[text()=' Boy Fashion']"); 
	private By AfterClickBoy_FashionFromMegaMenu = By.xpath("//h1[text()='Boys Dresses, Newborn Baby Boy Dresses & Infant Wear']");
	private By Girl_FashionFromMegaMenu = By.xpath("//a[text()=' Girl Fashion']"); 
	private By AfterClickGirl_FashionFromMegaMenu = By.xpath("//h1[text()='Girls Dresses, Newborn Baby Girl Dresses & Infant Wear']");
	private By FootwearFromMegaMenu = By.xpath("//a[text()=' Footwear']");
	private By AfterClickFootwearFromMegaMenu = By.xpath("//h1[text()='Kids Shoes, Sandals & Booties']");
	private By ToysFromMegaMenu = By.xpath("//a[text()=' Toys']");
	private By AfterClickToysFromMegaMenu = By.xpath("//h1[text()='Toys for Kids & Babies']");
	private By BooksAndSchoolFromMegaMenu = By.xpath("//a[text()=' Books & School']");
	private By AfterClickBooksAndSchoolFromMegaMenu = By.xpath("//h1[text()='Kids School Supplies Online']"); 
	private By DiaperingFromMegaMenu = By.xpath("//a[text()=' Diapering']");
	private By AfterClickDiaperingFromMegaMenuMenu = By.xpath("//h1[text()='Baby Diapers & Diapering Produts Online']"); 
	private By GearFromMegaMenu = By.xpath("//a[text()=' Gear']");
	private By AfterClickringGearFromMegaMenu = By.xpath("//h1[text()='Baby Gear & Accessories']"); 
	private By OutdoorFromMegaMenu = By.xpath("//a[text()=' Outdoor']");
	private By AfterClickringOutdoorFromMegaMenu = By.xpath("//h1[text()='Kids Outdoor Play Toys & Gears']"); 
	private By FeedingFromMegaMenu = By.xpath("//a[text()=' Feeding']");
	private By AfterClickringFeedingFromMegaMenu = By.xpath("//h1[text()='Baby Feeding Products & Accessories']"); 
	private By BathFromMegaMenu = By.xpath("//a[text()=' Bath']");
	private By AfterClickringBathFromMegaMenu = By.xpath("//h1[text()='Baby Bath & Skin Care Products']"); 
	
	
	// Constructor of page class:
	public MegaMenuProductsPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}
	
	// Page action/methods
	public boolean verifyBoy_FashionFromMegaMenu()
	{
		elementActions.waitForElementClickable(Boy_FashionFromMegaMenu);
		elementActions.doActionsClick(Boy_FashionFromMegaMenu);
		elementActions.waitForElementVisible(AfterClickBoy_FashionFromMegaMenu);
		if (elementActions.doGetText(AfterClickBoy_FashionFromMegaMenu).contains("BOY")) 
		{
			return true;
		
		}
		else {
			System.out.println("Text containing after clicked on Boy_FashionFromMegaMenu link is -> " + 
		elementActions.doGetText(AfterClickBoy_FashionFromMegaMenu));
			return false;
		}
	}
	
	public boolean verifyGirl_FashionFromMegaMenu()
	{
		elementActions.waitForElementClickable(Girl_FashionFromMegaMenu);
		elementActions.doActionsClick(Girl_FashionFromMegaMenu);
		elementActions.waitForElementVisible(AfterClickGirl_FashionFromMegaMenu);
		if (elementActions.doGetText(AfterClickGirl_FashionFromMegaMenu).contains("GIRL")) 
		{
			return true;
		
		}
		else {
			System.out.println("Text containing after clicked on Girl_FashionFromMegaMenu link is -> " + 
		elementActions.doGetText(AfterClickGirl_FashionFromMegaMenu));
			return false;
		}
	}
	
	public boolean verifyFootwearFromMegaMenu()
	{
		elementActions.waitForElementClickable(FootwearFromMegaMenu);
		elementActions.doActionsClick(FootwearFromMegaMenu);
		elementActions.waitForElementVisible(AfterClickFootwearFromMegaMenu);
		if (elementActions.doGetText(AfterClickFootwearFromMegaMenu).contains("SHOES")) 
		{
			return true;
		
		}
		else {
			System.out.println("Text containing after clicked on Boy_FashionFromMegaMenu link is -> " + 
		elementActions.doGetText(AfterClickFootwearFromMegaMenu));
			return false;
		}
	}
	
	public boolean verifyToysFromMegaMenu()
	{
		elementActions.waitForElementClickable(ToysFromMegaMenu);
		elementActions.doActionsClick(ToysFromMegaMenu);
		elementActions.waitForElementVisible(AfterClickToysFromMegaMenu);
		if (elementActions.doGetText(AfterClickToysFromMegaMenu).contains("TOYS")) 
		{
			return true;
		
		}
		else {
			System.out.println("Text containing after clicked on Boy_FashionFromMegaMenu link is -> " + 
		elementActions.doGetText(AfterClickToysFromMegaMenu));
			return false;
		}
	}

	
	public boolean verifyBooksAndSchoolFromMegaMenu()
	{
		elementActions.waitForElementClickable(BooksAndSchoolFromMegaMenu);
		elementActions.doActionsClick(BooksAndSchoolFromMegaMenu);
		elementActions.waitForElementVisible(AfterClickBooksAndSchoolFromMegaMenu);
		if (elementActions.doGetText(AfterClickBooksAndSchoolFromMegaMenu).contains("SCHOOL")) 
		{
			return true;
		
		}
		else {
			System.out.println("Text containing after clicked on Boy_FashionFromMegaMenu link is -> " + 
		elementActions.doGetText(AfterClickBooksAndSchoolFromMegaMenu));
			return false;
		}
	} 
	
	public boolean verifyDiaperingFromMegaMenu()
	{
		elementActions.waitForElementClickable(DiaperingFromMegaMenu);
		elementActions.doActionsClick(DiaperingFromMegaMenu);
		elementActions.waitForElementVisible(AfterClickDiaperingFromMegaMenuMenu);
		if (elementActions.doGetText(AfterClickDiaperingFromMegaMenuMenu).contains("DIAPERING")) 
		{
			return true;
		
		}
		else {
			System.out.println("Text containing after clicked on Boy_FashionFromMegaMenu link is -> " + 
		elementActions.doGetText(AfterClickDiaperingFromMegaMenuMenu));
			return false;
		}
	}
	
	public boolean verifyGearFromMegaMenu()
	{
		elementActions.waitForElementClickable(GearFromMegaMenu);
		elementActions.doActionsClick(GearFromMegaMenu);
		elementActions.waitForElementVisible(AfterClickringGearFromMegaMenu);
		if (elementActions.doGetText(AfterClickringGearFromMegaMenu).contains("GEAR")) 
		{
			return true;
		
		}
		else {
			System.out.println("Text containing after clicked on Boy_FashionFromMegaMenu link is -> " + 
		elementActions.doGetText(AfterClickringGearFromMegaMenu));
			return false;
		}
	}
	
	public boolean verifyOutdoorFromMegaMenu()
	{
		elementActions.waitForElementClickable(OutdoorFromMegaMenu);
		elementActions.doActionsClick(OutdoorFromMegaMenu);
		elementActions.waitForElementVisible(AfterClickringOutdoorFromMegaMenu);
		if (elementActions.doGetText(AfterClickringOutdoorFromMegaMenu).contains("OUTDOOR")) 
		{
			return true;
		
		}
		else {
			System.out.println("Text containing after clicked on Boy_FashionFromMegaMenu link is -> " + 
		elementActions.doGetText(AfterClickringOutdoorFromMegaMenu));
			return false;
		}
	} 

	public boolean verifyFeedingFromMegaMenu()
	{
		elementActions.waitForElementClickable(FeedingFromMegaMenu);
		elementActions.doActionsClick(FeedingFromMegaMenu);
		elementActions.waitForElementVisible(AfterClickringFeedingFromMegaMenu);
		if (elementActions.doGetText(AfterClickringFeedingFromMegaMenu).contains("FEEDING")) 
		{
			return true;
		
		}
		else {
			System.out.println("Text containing after clicked on Boy_FashionFromMegaMenu link is -> " + 
		elementActions.doGetText(AfterClickringFeedingFromMegaMenu));
			return false;
		}
	} 
	
	public boolean verifyBathFromMegaMenu()
	{
		elementActions.waitForElementClickable(BathFromMegaMenu);
		elementActions.doActionsClick(BathFromMegaMenu);
		elementActions.waitForElementVisible(AfterClickringBathFromMegaMenu);
		if (elementActions.doGetText(AfterClickringBathFromMegaMenu).contains("BATH")) 
		{
			return true;
		
		}
		else {
			System.out.println("Text containing after clicked on Boy_FashionFromMegaMenu link is -> " + 
		elementActions.doGetText(AfterClickringBathFromMegaMenu));
			return false;
		}
	}

}
