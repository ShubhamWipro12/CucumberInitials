package com.wipro.L2POM.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemoveObject {
	WebDriver driver;

	@FindBy(xpath = "//tbody/tr[1]/td[4]/div[1]/span[1]/button[2]")
	WebElement remove;

	@FindBy(xpath = "//a[contains(text(),'Continue')]")
	WebElement next;

	public WebElement getNext() {
		return next;
	}

	public void setNext(WebElement next) {
		this.next = next;
	}

	public WebElement getRemove() {
		return remove;
	}

	public void setRemove(WebElement remove) {
		this.remove = remove;
	}

	public RemoveObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
