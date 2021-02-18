package com.wipro.L2POM.testCases;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wipro.L2POM.pageObject.LoginPage;
import com.wipro.L2POM.pageObject.ShoppingObject;
import com.wipro.L2POM.resources.DriverDetails;
import com.wipro.L2POM.utility.Webelements;

public class E2ETest {

	WebDriver driver;

	DriverDetails base = new DriverDetails();
	Webelements elements = new Webelements();

	static final Logger log = Logger.getLogger(E2ETest.class);

	@BeforeTest
	public void setup() throws IOException {

		BasicConfigurator.configure(); // for Log4j configuration

		log.info("Initializing driver");
		driver = base.setUpDriver();

		log.info("Loading url");
		driver.get(elements.getProperty("homeUrl"));
	}

	@DataProvider
	public Object[][] searchedKeywords(){
		return new Object[][] {{"Apple"},{"Sony"},{"Nikon"},{"Canon"}};
	}
	
	@Test(dataProvider="searchedKeywords")
	public void shopingTest(String items) throws IOException {


		LoginPage loginPage = new LoginPage(driver);
		ShoppingObject shop = new ShoppingObject(driver);
		
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

		log.info("Searching "+items);
		shop.getSearchBar().sendKeys(items);
		shop.getSearchBar().sendKeys(Keys.ENTER);
		
		log.info("Opening the searched result");
		shop.getSeachedItem().click();
		
		log.info("Setting the Quantity");
		shop.getQuantity().clear();
		shop.getQuantity().sendKeys("2");
		
		log.info("Adding to Cart");
		shop.getAddToCart().click();
		
		log.info("Checking Basket");
		shop.getBasket().click();
		
		log.error("Payment processes are not available");
		//taking screenshot
		elements.getScreen("E2ETest", driver);
		
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
