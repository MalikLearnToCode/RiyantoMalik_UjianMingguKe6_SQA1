package com.juaracoding.wptesting.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.wptesting.driver.DriverSingleton;

public class AddToCart {

private WebDriver driver;
	
	public AddToCart() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#noo-site > header > div.navbar-wrapper > div > div > div > a")
	private WebElement btnSearch;
	
	@FindBy(id = "pa_color")
	private WebElement selectColor;
	
	@FindBy(id = "pa_size")
	private WebElement selectSize;
	
	@FindBy(css = "#product-1301 > div.single-product-content > div.summary.entry-summary > form > div > div.woocommerce-variation-add-to-cart.variations_button.woocommerce-variation-add-to-cart-enabled > button")
	private WebElement btnAdd;
	
	@FindBy(css = "#noo-site > header > div.navbar-wrapper > div > div > div > a")
	private WebElement txtMyAccount;
	
	@FindBy(css = "#noo-site > div.noo-container-shop.noo-shop-wrap > div.noo-row > div > div > div.noo-product-item.one.noo-product-sm-4.not_featured.post-1342.product.type-product.status-publish.has-post-thumbnail.product_cat-sun-glasses.product_tag-sun-glasses.product_tag-women.has-featured.instock.shipping-taxable.purchasable.product-type-variable > div")
	private WebElement pickGlass;
	
	
	public void addToCartShoes() {
		btnSearch.sendKeys("shoes");
		btnSearch.sendKeys(Keys.ENTER);
//		selectColor.sendKeys("NUDE");
//		selectSize.sendKeys("36");
//		btnAdd.click();
	}
	
//	public void addToCartGlass() {
//		btnSearch.sendKeys("glass");
//		btnSearch.sendKeys(Keys.ENTER);
//		pickGlass.click();
//		selectColor.sendKeys("BLUE");
//		selectSize.sendKeys("One");
//		btnAdd.click();
//	}
	
	
	
}
