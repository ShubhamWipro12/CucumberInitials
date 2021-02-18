package com.wipro.L2POM.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryObject {

	WebDriver driver;

	@FindBy(xpath = "//*[@id='content']/div/div[2]/select")
	WebElement category;

	@FindBy(xpath = "//input[@id='button-search']")
	WebElement search;

	public WebElement getSearch() {
		return search;
	}

	public WebElement getCategory() {
		return category;
	}

	public void setCategory(WebElement category) {
		this.category = category;
	}

	public CategoryObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
