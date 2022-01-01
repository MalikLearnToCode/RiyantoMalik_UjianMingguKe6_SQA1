package com.juaracoding.wptesting.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.wptesting.driver.DriverSingleton;

public class LoginPage {

private WebDriver driver;
	
	public LoginPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#noo-site > header > div.noo-topbar > div > ul.pull-right.noo-topbar-right > li:nth-child(2)")
	private WebElement btnMyAccount;
	
	@FindBy(id = "username")
	private WebElement txtUsername;
	
	@FindBy(id = "password")
	private WebElement txtPassword;
	
	@FindBy(css = "#customer_login > div.u-column1.col-1 > form > p:nth-child(3) > button")
	private WebElement btnLogin;
	
	@FindBy(css = "#noo-site > section > div > div > h1")
	private WebElement txtMyAccount;
	
	public void goToMyAccount1() {
		btnMyAccount.click();
	}
	
	public void goToLoginAccount(String username, String password) {
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		btnLogin.click();
		
	}
		
	public String txtLoginMessage() {
			// TODO Auto-generated method stub
			return txtMyAccount.getText();
		
	}
	
	
}
