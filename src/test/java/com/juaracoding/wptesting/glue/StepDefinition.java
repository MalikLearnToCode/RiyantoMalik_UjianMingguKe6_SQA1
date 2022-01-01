package com.juaracoding.wptesting.glue;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.juaracoding.wptesting.driver.DriverSingleton;
import com.juaracoding.wptesting.utils.ConfigurationProperties;
import com.juaracoding.wptesting.utils.Constants;
import com.juaracoding.wptesting.utils.Log;
import com.juaracoding.wptesting.utils.TestCases;
import com.juaracoding.wptesting.utils.Utils;
import com.juaracoding.wptesting.config.AutomationFrameworkConfiguration;
import com.juaracoding.wptesting.page.LoginPage;
import com.juaracoding.wptesting.page.RegisPage;
import com.juaracoding.wptesting.page.AddToCart;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
public class StepDefinition {

	private WebDriver driver;
	private RegisPage regisPage;
	private LoginPage loginPage;
	private AddToCart addToCart;
	ExtentTest extentTest;
	static ExtentReports report = new ExtentReports("src/main/resources/TestReport.html");
//	String username = "-";
	@Autowired
	ConfigurationProperties configurationProperties;
	
	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		regisPage = new RegisPage();
		loginPage = new LoginPage();
		addToCart = new AddToCart();
		TestCases[] tests = TestCases.values();
		extentTest = report.startTest(tests[Utils.testCount].getTestName());
		Log.getLogData(Log.class.getName()); //log4j
		Log.startTest(tests[Utils.testCount].getTestName()); //log4j
		Utils.testCount++;
	}
	
	// Scenario Register
	@Given("^User go to the Website")
	public void user_go_to_the_Website() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		Log.info("INFO: Navigating to " + Constants.URL); //log4j
		extentTest.log(LogStatus.PASS, "Navigating to " + Constants.URL);
	}
	
	@When("^User click MyAccount")
	public void user_click_myaccount() {
		regisPage.goToMyAccount();
		extentTest.log(LogStatus.PASS, "User click MyAccount");
	}
	
	@When("^User input username email address password and click submit")
	public void user_input_username_email_password_and_click_submit() {
//		String strRandom = UUID.randomUUID().toString();
//        username = strRandom.replace("-", "");
//        String email = username + "@gmail.com";
		regisPage.goToRegister(configurationProperties.getUserName() , configurationProperties.getEmail(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "User input username email address and password");
	}
	
	@Then("^User finish register account")
	public void user_finish_register_account() {
		 assertEquals(configurationProperties.getTxtLoginMessage(), regisPage.txtLoginMessage());
		 extentTest.log(LogStatus.PASS, "User finish register");
		 regisPage.back();
	}
	
	// Scenario Login
	@When("^User click MyAccount for login")
	public void user_click_myaccount_for_login() {
		loginPage.goToMyAccount1();
		extentTest.log(LogStatus.PASS, "User click MyAccount for login");
	}
		
	@When("^User input registered username password and click submit")
	public void user_input_username_password_and_click_submit() {
		loginPage.goToLoginAccount(configurationProperties.getUserName(), configurationProperties.getPassword());
		extentTest.log(LogStatus.PASS, "User input username email address and password");
	}
		
	@Then("^User logged in to their account")
	public void user_logged_in_to_their_account() {
		equals(configurationProperties.getTxtMyAccount());
		extentTest.log(LogStatus.PASS, "User logged in");
			 
	}
	
	// Scenario Add to cart
	@When("^User search shoes add to cart using compare")
	public void user_search_shoes_add_to_cart_using_compare() {
		addToCart.addToCartShoes();
		extentTest.log(LogStatus.PASS, "User add to cart shoes");
		}
			
//	@Then("^User add to cart glass using search")
//	public void user_add_to_cart_glass_using_search() {
//		addToCart.addToCartGlass();
//		extentTest.log(LogStatus.PASS, "User add to cart glass");
//		}
//			
		
	// Posts
		
	@After
		public void closeObject() {
		report.endTest(extentTest);
		report.flush();
		}
}