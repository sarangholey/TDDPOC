package com.qa.frisrcryae.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.frisrcryae.base.BasePage;
import com.qa.frisrcryae.pages.LandingPage;
import com.qa.frisrcryae.utills.AppConstants;


public class LandingPageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LandingPage landingPage;
	//Logger log;
	
	@BeforeMethod(alwaysRun = true)
	public void setup()
	{
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		landingPage = new LandingPage(driver);
		//log = basePage.getLogger(LandingPageTest.class);
	}
	
	@Test(groups = "smoke")
	public void verifyLandingPageTitle_test() {
		//log.info("Test logger");
		Assert.assertEquals(landingPage.getLandingPageTitle(), AppConstants.LANDING_PAGE_TITLE);
	}
	
	@Test(groups = "smoke")
	public void verifySearchBoxIsAvailable_test() {
		Assert.assertEquals(landingPage.verifySearchBoxIsAvailable(), true);
	}
	
	@Test//(priority = 3, enabled=false)
	public void verifySearchBoxWorking_test() {
		Assert.assertEquals(landingPage.verifySearchBoxWorking("play"), true);
	}
	
	@Test//(priority = 4, enabled=false)
	public void verifyPlaceHolder_test() {
		landingPage.verifyPlaceHolder();
	}
	
	@Test//(priority = 5, enabled=false)
	public void loginToApp_test()
	{
		Assert.assertEquals(landingPage.loginToApp(prop.getProperty("username"), prop.getProperty("password")), true, 
		"loginToApp_test failed unable to locate My Account Webelement");
	}
	
	@Test//(priority = 6, enabled=false)
	public void verifyContactUsLinkOnHeader_test()
	{
		Assert.assertEquals(landingPage.verifyContactUsLinkOnHeader(), AppConstants.CONTACT_US_PAGE_TITILE);
	}
	
	
	@Test//(priority = 7, enabled = false)
	public void verifyTrackOrderLinkOnHeader_test()
	{
		Assert.assertEquals(landingPage.verifyTrackOrderLinkOnHeader("trackmyorder"), true);
	}
	
	@Test//(priority = 8, enabled = false)
	public void verifyFirstCryParentingLinkOnHeader_test()
	{
		Assert.assertEquals(landingPage.verifyFirstCryParentingLinkOnHeader("parenting"), true);
	}
	@Test//(priority = 9, enabled = false)
	public void verifyRegisterLinkOnHeader_test()
	{
		Assert.assertEquals(landingPage.verifyRegisterLinkOnHeader(), true);
	}
	
	@Test//(priority = 10, enabled = false)
	public void verifyShortListLinkOnHeader_test()
	{
		Assert.assertEquals(landingPage.verifyShortListLinkOnHeader("myshortlist"), true);
	}
	
	@Test//(priority = 11, enabled = false)
	public void verifyFirstCryLogoOnHeader_test()
	{
		Assert.assertEquals(landingPage.verifyFirstCryLogoOnHeader(), true);
	}
	
	@Test//(priority = 12, enabled = false)
	public void verifyBoys_ClothesLink_test()
	{
		
		Assert.assertEquals(landingPage.verifyBoys_ClothesLink(), true);
	} 

	@Test//(priority = 13, enabled = false)
	public void verifyGirls_ClothesLink_test()
	{
		
		Assert.assertEquals(landingPage.verifyGirls_ClothesLink(), true);
	}
	
	@Test//(priority = 14, enabled = false)
	public void verifyBaby_And_Kids_FootwearLink_test()
	{
		
		Assert.assertEquals(landingPage.verifyBaby_And_Kids_FootwearLink(), true);
	}
	
	@Test//(priority = 15, enabled = false)
	public void verifyBaby_And_Kids_ToysLink_test()
	{
		
		Assert.assertEquals(landingPage.verifyBaby_And_Kids_ToysLink(), true);
	} 
	
	@Test//(priority = 16, enabled = false)
	public void verifyKids_Books_And_CDsLink_test()
	{
		
		Assert.assertEquals(landingPage.verifyKids_Books_And_CDsLink(), true);
	} 
	
	@Test//(priority = 17, enabled = false)
	public void verifyBaby_DiaperingLink_test()
	{
		
		Assert.assertEquals(landingPage.verifyBaby_DiaperingLink(), true);
	}
	
	@Test//(priority = 18, enabled = false)
	public void verifyBrokenLinksCountOnLandingPage_test()
	{
		landingPage.verifyBrokenLinksCountOnLandingPage();
		//Assert.assertEquals(landingPage.verifyLinksCountOnLandingPage(), true);
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void tearDown()
	{
		driver.quit();
	}

}
