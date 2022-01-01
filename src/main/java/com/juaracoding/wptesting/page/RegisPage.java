package com.juaracoding.wptesting.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.wptesting.driver.DriverSingleton;

public class RegisPage {
private WebDriver driver;
	
	public RegisPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "body > p > a")
	private WebElement btnDismiss;
	
	@FindBy(css = "#noo-site > header > div.noo-topbar > div > ul.pull-right.noo-topbar-right > li:nth-child(2) > a")
	private WebElement btnMyAccount;
	
	@FindBy(id = "reg_username")
	private WebElement txtRegUsername;
	
	@FindBy(id = "reg_email")
	private WebElement txtRegEmail;
	
	@FindBy(id = "reg_password")
	private WebElement txtRegPassword;
	
	@FindBy(css = "#customer_login > div.u-column2.col-2 > form > p:nth-child(5) > button")
	private WebElement btnSubmit;
	
	@FindBy(css = "#login > p.login.message")
	private WebElement loginMessage;
	
	@FindBy(css = "#backtoblog > a")
	private WebElement btnBack;
	
	public void goToMyAccount() {
		btnDismiss.click();
		btnMyAccount.click();
	}
	
	public void goToRegister(String username, String email, String password) {		
		txtRegUsername.sendKeys(username);
		txtRegEmail.sendKeys(email);
		txtRegPassword.sendKeys(password);
		btnSubmit.click();
		
	}

	public String txtLoginMessage() {
		// TODO Auto-generated method stub
		return loginMessage.getText();
	}
	
	public void back() {
		btnBack.click();
	}
	
}

