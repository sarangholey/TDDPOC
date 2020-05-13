package com.qa.frisrcryae.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;

	public WebDriver init_driver(Properties prop) {
		String browserName = null;
		if (System.getProperty("browser") == null) {
			browserName = prop.getProperty("browser");
		} else {
			browserName = System.getProperty("browser");
		}

		System.out.println("Running on ----> " + browserName + " browser");

		optionsManager = new OptionsManager(prop);

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(optionsManager.getChromeOptions());
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
		} else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver = new SafariDriver();
		} else {
			System.out.println(browserName + " is not found, please pass the right browser Name");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;

	}
	
	
	/**
	 * 
	 * @return this method returns properties - prop available in
	 *         config.proerties file
	 */
	public Properties init_prop() {
		prop = new Properties();
		String path = null;
		String env = null;

		try {
			env = System.getProperty("env");
			if (env == null) {
				path = "./src/test/resources/resources/config.properties";
			} else {
				switch (env) {
				case "qa":
					path = "./src/test/resources/resources/config.qa.properties";
					break;
				case "stg":
					path = "./src/test/resources/resources/config.stg.properties";
					break;
				case "prod":
					path = "./src/test/resources/resources/config.prod.properties";
					break;
				default:
					System.out.println("no env is passed");
					break;
				}
			}

			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("config file is not found.....");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}
	
	/**
	 * take screenshot util
	 */
//	public String getScreenshot() {
//		File src = ((TakesScreenshot) driver()).getScreenshotAs(OutputType.FILE);
//		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
//		File destination = new File(path);
//
//		try {
//			FileUtils.copyFile(src, destination);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		return path;
//	}

}
