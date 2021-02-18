package com.wipro.L2POM.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(xpath = "//span[@class='caret']")
	WebElement myAccount;

	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement login;

	@FindBy(xpath = "//input[@name='email']")
	WebElement email;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement submit;

	@FindBy(xpath = "//*[@id='account-login']/div[1]/text()")
	WebElement errorMsg;

	@FindBy(xpath = "//*[@id='top-links']/ul/li[2]/ul/li[5]/a")
	WebElement logOut;

	@FindBy(xpath = "//*[@id='content']/div/div/a")
	WebElement next;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getErrorMsg() {
		return errorMsg;
	}


	public WebElement getMyAccount() {
		return myAccount;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getEmail() {
		return email;
	}

	public void setEmail(WebElement email) {
		this.email = email;
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getLogOut() {
		return logOut;
	}

	public WebElement getNext() {
		return next;
	}

	public String getTitle() {
		return driver.getTitle();
	}

}
