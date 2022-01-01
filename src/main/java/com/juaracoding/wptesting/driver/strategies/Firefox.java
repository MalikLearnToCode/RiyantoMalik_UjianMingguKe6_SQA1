package com.juaracoding.wptesting.driver.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy {

	public WebDriver setStrategy() {
		System.setProperty("webdriver.gecko.driver", "/home/luffy/geckodriver");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
}
