package com.qa.frisrcryae.tests;

import java.util.Properties;
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
	
	@BeforeMethod
	public void setup()
	{
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		landingPage = new LandingPage(driver);
	}
	
	@Test//(priority = 1, enabled=true)
	public void verifySignUpLink_test() {
		Assert.assertEquals(landingPage.getLandingPageTitle(), AppConstants.LANDING_PAGE_TITLE);
	}
	
	@Test//(priority = 2, enabled=true)
	public void verifySearchBoxIsAvailable_test() {
		Assert.assertEquals(landingPage.verifySearchBoxIsAvailable(), true);
	}
	
	@Test//(priority = 3, enabled=true)
	public void verifySearchBoxWorking_test() {
		Assert.assertEquals(landingPage.verifySearchBoxWorking("play"), true);
	}
	
	@Test//(priority = 4, enabled=true)
	public void verifyPlaceHolder_test() {
		landingPage.verifyPlaceHolder();
	}
	
	@Test//(priority = 5, enabled=false)
	public void loginToApp_test()
	{
		Assert.assertEquals(landingPage.loginToApp(prop.getProperty("username"), prop.getProperty("password")), true, 
		"loginToApp_test failed unable to locate My Account Webelement");
	}
	
	@Test//(priority = 6, enabled=true)
	public void verifyContactUsLinkOnHeader_test()
	{
		Assert.assertEquals(landingPage.verifyContactUsLinkOnHeader(), AppConstants.CONTACT_US_PAGE_TITILE);
	}
	
	
	@Test//(priority = 7, enabled = true)
	public void verifyTrackOrderLinkOnHeader_test()
	{
		Assert.assertEquals(landingPage.verifyTrackOrderLinkOnHeader("trackmyorder"), true);
	}
	
	@Test//(priority = 8, enabled = true)
	public void verifyFirstCryParentingLinkOnHeader_test()
	{
		Assert.assertEquals(landingPage.verifyFirstCryParentingLinkOnHeader("parenting"), true);
	}
	@Test//(priority = 9, enabled = true)
	public void verifyRegisterLinkOnHeader_test()
	{
		Assert.assertEquals(landingPage.verifyRegisterLinkOnHeader(), true);
	}
	
	@Test//(priority = 10, enabled = true)
	public void verifyShortListLinkOnHeader_test()
	{
		Assert.assertEquals(landingPage.verifyShortListLinkOnHeader("myshortlist"), true);
	}
	
	@Test//(priority = 11, enabled = true)
	public void verifyFirstCryLogoOnHeader_test()
	{
		Assert.assertEquals(landingPage.verifyFirstCryLogoOnHeader(), true);
	}
	

	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
