package com.wipro.L2POM.testCases;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wipro.L2POM.pageObject.EmptyCartObject;
import com.wipro.L2POM.pageObject.LoginPage;
import com.wipro.L2POM.resources.DriverDetails;
import com.wipro.L2POM.utility.Webelements;

public class EmptyCartTest {
	WebDriver driver;

	DriverDetails base = new DriverDetails();
	Webelements elements = new Webelements();

	static final Logger log = Logger.getLogger(EmptyCartTest.class);

	@BeforeTest
	public void setup() throws IOException {

		BasicConfigurator.configure(); // for Log4j configuration

		log.info("Initializing driver");
		driver = base.setUpDriver();

		log.info("Loading url");
		driver.get(elements.getProperty("homeUrl"));
	}

	
	@Test
	public void emptyCartTest() throws IOException {

		LoginPage loginPage = new LoginPage(driver);
		
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

		EmptyCartObject cart = new EmptyCartObject(driver);
		
		cart.getCheckout().click();
		elements.getScreen("EmptyCartTest", driver);
		
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
