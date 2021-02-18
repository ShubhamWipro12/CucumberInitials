package com.wipro.L2POM.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditInformationObject {

	WebDriver driver;

	@FindBy(css = "#column-right > div > a:nth-child(2)")
	WebElement edit;

	@FindBy(xpath = "//input[@name='telephone']")
	WebElement phone;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submit;
	
	
	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getEdit() {
		return edit;
	}

	public EditInformationObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
