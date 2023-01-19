package com.ally.support;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ally.actions.TestEngine;
import com.ally.base.DriverScript;

public class WebDriverFactory extends DriverScript{
	
	public static WebDriver initialize () throws NumberFormatException, IOException {
		if (BROWSER.toUpperCase().equals("CHROME")) {
			System.setProperty ("webdriver.chrome.silentOutput", "true");
			System.setProperty ("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "Drivers" + File.separator + "chromedriver");
			driver = new ChromeDriver();
			TestEngine.deleteCookies();
			driver.get (baseUrl);
			TestEngine.maximize();
		} else if (BROWSER.toUpperCase().equals("IE")) {
			//code
		} else if (BROWSER.toUpperCase().equals("FIREFOX")) {
			//code
		}
		return driver;
	}
	
}
