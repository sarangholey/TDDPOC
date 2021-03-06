package com.qa.frisrcryae.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.frisrcryae.base.BasePage;
import com.qa.frisrcryae.pages.OptionsInMegaMenuPage;

public class OptionsInMegaMenuPageTest {
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	OptionsInMegaMenuPage optionsInMegaMenuPage;
	
	@BeforeMethod(alwaysRun = true)
	public void setup()
	{
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		optionsInMegaMenuPage = new OptionsInMegaMenuPage(driver);
	}
	
	@Test//(priority = 1, enabled = true)
	public void verifyBoy_FashionSubmenu_test()
	{
		Assert.assertEquals(optionsInMegaMenuPage.verifyBoy_FashionSubmenu(), false);
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown()
	{
		driver.quit();
	}

}
