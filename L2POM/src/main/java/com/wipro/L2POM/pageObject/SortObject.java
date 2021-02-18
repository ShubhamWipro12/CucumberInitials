package com.wipro.L2POM.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SortObject {

	WebDriver driver;

	@FindBy(xpath = "//*[@id='menu']/div[2]/ul/li[2]/a")
	WebElement laptopAndNote;

	@FindBy(xpath = "//*[@id='menu']/div[2]/ul/li[2]/div/a")
	WebElement showAll;

	@FindBy(xpath = "//*[@id='input-sort']")
	WebElement sort;

	@FindBy(css = "#content > div:nth-child(7) > div:nth-child(1) > div > div:nth-child(2) > div.caption > h4 > a")
	WebElement result1;

	@FindBy(css = "#content > div:nth-child(7) > div:nth-child(2) > div > div:nth-child(2) > div.caption > h4 > a")
	WebElement result2;

	public WebElement getLaptopAndNote() {
		return laptopAndNote;
	}

	public WebElement getShowAll() {
		return showAll;
	}

	public WebElement getSort() {
		return sort;
	}

	public WebElement getResult1() {
		return result1;
	}

	public WebElement getResult2() {
		return result2;
	}

	public SortObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
