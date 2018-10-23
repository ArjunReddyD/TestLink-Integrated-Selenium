package com.qa.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class BaseTest {

	public WebDriver driver;
	String environment;
	
	@BeforeMethod
	@Parameters({ "Environment", "browser" })
	public void setup(String Environment, String browser) throws Exception {

		environment = Environment;

		if (browser.equalsIgnoreCase("U_firefox")) {
			
			System.out.println("Launching Ubuntu firefox browser.");

			System.setProperty("webdriver.gecko.driver",
					"..//TestLink-Integrated-Selenium//Drivers//Ubuntu_geckodriver"); // Replace your Driver path 
			
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("U_Chrome")) {

			System.out.println("Launching Ubuntu chrome browser.");

			System.setProperty("webdriver.chrome.driver",
					"..//TestLink-Integrated-Selenium//Drivers//Ubuntu_chromedriver"); // Replace your Driver path  
			driver = new ChromeDriver();

		} 
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Environment);
		driver.manage().deleteAllCookies();
		
	}
	@AfterMethod
	public void tearDown(ITestResult result) {

		driver.quit();

	}
	
	public String getOSBrowserDetails() {
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String BrowserName = cap.getBrowserName().toLowerCase();
		String os = System.getProperty("os.name").toLowerCase();
		String BrowserVersion = cap.getVersion().toString();
		System.out.println("OS = " + os + ", Browser = " + BrowserName + ", BrowserVersion=" + BrowserVersion + "");
		String OSBrowserDetails = "Test Execution Successfully Passed in OS = " + os + ", Browser = " + BrowserName
				+ ", BrowserVersion=" + BrowserVersion + "";
		return OSBrowserDetails;

	}

}
