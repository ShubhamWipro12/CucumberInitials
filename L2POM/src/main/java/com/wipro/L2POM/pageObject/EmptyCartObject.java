package com.wipro.L2POM.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmptyCartObject {

	WebDriver driver;

	@FindBy(xpath = "//a[@title='Checkout']")
	WebElement checkout;

	public WebElement getCheckout() {
		return checkout;
	}

	public EmptyCartObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
