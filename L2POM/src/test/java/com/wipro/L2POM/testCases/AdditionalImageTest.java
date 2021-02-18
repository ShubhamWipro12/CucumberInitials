package com.wipro.L2POM.testCases;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wipro.L2POM.pageObject.AdditionalImageObject;
import com.wipro.L2POM.pageObject.LoginPage;
import com.wipro.L2POM.pageObject.ShoppingObject;
import com.wipro.L2POM.resources.DriverDetails;
import com.wipro.L2POM.utility.Webelements;

public class AdditionalImageTest {
	WebDriver driver;

	DriverDetails base = new DriverDetails();
	Webelements elements = new Webelements();

	static final Logger log = Logger.getLogger(AdditionalImageTest.class);

	@BeforeTest
	public void setup() throws IOException {

		BasicConfigurator.configure(); // for Log4j configuration

		log.info("Initializing driver");
		driver = base.setUpDriver();

		log.info("Loading url");
		driver.get(elements.getProperty("homeUrl"));
	}

	@Test
	public void additionalImageTesting() throws IOException {

		LoginPage loginPage = new LoginPage(driver);
		ShoppingObject shop = new ShoppingObject(driver);
		AdditionalImageObject img = new AdditionalImageObject(driver);

		log.info("Opening Login Page");
		loginPage.getMyAccount().click();
		loginPage.getLogin().click();

		log.info("Inserting Login Credentials");
		loginPage.getEmail().clear();
		loginPage.getPassword().clear();

		loginPage.getEmail().sendKeys("apple@banana.com");
		loginPage.getPassword().sendKeys("applebanana@12");

		log.info("Submitting");
		loginPage.getSubmit().click();

		log.info("Searching Sony");
		shop.getSearchBar().sendKeys("Sony");
		shop.getSearchBar().sendKeys(Keys.ENTER);
		// clicking on Sony link
		shop.getSeachedItem().click();

		log.info("Getting image name..");
		String[] imageName = img.getImage().getAttribute("href").split("/");
		log.info("File name : " + imageName[imageName.length - 1]);

		log.info("Logging out");
		loginPage.getMyAccount().click();
		loginPage.getLogOut().click();
		loginPage.getNext().click();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}

}
