package com.qa.frisrcryae.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.frisrcryae.base.BasePage;
import com.qa.frisrcryae.pages.MegaMenuProductsPage;


public class MegaMenuProductsPageTest {
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	MegaMenuProductsPage megaMenuProductsPage;
	
	@BeforeMethod(alwaysRun = true)
	public void setup()
	{
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		megaMenuProductsPage = new MegaMenuProductsPage(driver);
	}
	
	@Test(groups = "smoke")
	public void verifyBoys_ClothesLink_test()
	{
		
		Assert.assertEquals(megaMenuProductsPage.verifyBoy_FashionFromMegaMenu(), true);
	}
	
	@Test(groups = "smoke")
	public void verifyGirl_FashionFromMegaMenu_test()
	{
		
		Assert.assertEquals(megaMenuProductsPage.verifyGirl_FashionFromMegaMenu(), true);
	}
	
	@Test//(priority = 3, enabled = true)
	public void verifyFootwearFromMegaMenu_test()
	{
		
		Assert.assertEquals(megaMenuProductsPage.verifyFootwearFromMegaMenu(), true);
	} 
	
	@Test//(priority = 4, enabled = true)
	public void verifyToysFromMegaMenu_test()
	{
		
		Assert.assertEquals(megaMenuProductsPage.verifyToysFromMegaMenu(), true);
	} 
	
	@Test//(priority = 5, enabled = true)
	public void verifyBooksAndSchoolFromMegaMenu_test()
	{
		
		Assert.assertEquals(megaMenuProductsPage.verifyBooksAndSchoolFromMegaMenu(), true);
	} 
	
	@Test//(priority = 6, enabled = true)
	public void verifyDiaperingFromMegaMenu_test()
	{
		
		Assert.assertEquals(megaMenuProductsPage.verifyDiaperingFromMegaMenu(), true);
	}
	
	@Test//(priority = 7, enabled = true)
	public void verifyGearFromMegaMenu_test()
	{
		
		Assert.assertEquals(megaMenuProductsPage.verifyGearFromMegaMenu(), true);
	}
	
	@Test//(priority = 8, enabled = true)
	public void verifyOutdoorFromMegaMenu_test()
	{
		
		Assert.assertEquals(megaMenuProductsPage.verifyOutdoorFromMegaMenu(), true);
	} 
	
	@Test//(priority = 9, enabled = true)
	public void verifyFeedingFromMegaMenu_test()
	{
		
		Assert.assertEquals(megaMenuProductsPage.verifyFeedingFromMegaMenu(), true);
	} 
	
	@Test//(priority = 10, enabled = true)
	public void verifyBathFromMegaMenu_test()
	{
		
		Assert.assertEquals(megaMenuProductsPage.verifyBathFromMegaMenu(), true);
	}
	
	
	
	@AfterMethod(alwaysRun = true)
	public void tearDown()
	{
		driver.quit();
	}

}
