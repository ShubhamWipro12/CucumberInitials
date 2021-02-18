package com.wipro.L2POM.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdditionalImageObject {

	WebDriver driver;
	@FindBy(xpath = "//*[@id='content']/div/div[1]/ul[1]/li[2]/a")
	WebElement image;

	public WebElement getImage() {
		return image;
	}

	public AdditionalImageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
