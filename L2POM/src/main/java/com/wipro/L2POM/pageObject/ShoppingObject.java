package com.wipro.L2POM.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingObject {

	WebDriver driver;

	@FindBy(css = "input[name='search']")
	WebElement searchBar;

	@FindBy(xpath = "//*[@id='content']/div[3]/div/div/div[2]/div[1]/h4/a")
	WebElement seachedItem;

	@FindBy(css = "input[name='quantity']")
	WebElement quantity;

	@FindBy(css = "[id='button-cart']")
	WebElement addToCart;

	@FindBy(xpath = "//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[4]/a[1]")
	WebElement basket;

	@FindBy(xpath = "//*[@id='content']/div[3]/div[1]/a")
	WebElement continueShopping;
	
	
	
	public WebElement getBasket() {
		return basket;
	}

	public void setBasket(WebElement basket) {
		this.basket = basket;
	}

	public WebElement getContinueShopping() {
		return continueShopping;
	}

	public void setContinueShopping(WebElement continueShopping) {
		this.continueShopping = continueShopping;
	}

	public WebElement getAddToCart() {
		return addToCart;
	}

	public void setAddToCart(WebElement addToCart) {
		this.addToCart = addToCart;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public void setQuantity(WebElement quantity) {
		this.quantity = quantity;
	}

	public WebElement getSeachedItem() {
		return seachedItem;
	}

	public void setSeachedItem(WebElement seachedItem) {
		this.seachedItem = seachedItem;
	}

	public WebElement getSearchBar() {
		return searchBar;
	}

	public void setSearchBar(WebElement searchBar) {
		this.searchBar = searchBar;
	}

	public ShoppingObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
