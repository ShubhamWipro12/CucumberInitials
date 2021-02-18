package com.wipro.L2POM.testCases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wipro.L2POM.pageObject.LoginPage;
import com.wipro.L2POM.resources.DriverDetails;
import com.wipro.L2POM.utility.Webelements;

public class LoginTest extends DriverDetails {

	WebDriver driver;

	DriverDetails base = new DriverDetails();
	Webelements elements = new Webelements();

	static final Logger log = Logger.getLogger(LoginTest.class);

	@BeforeTest
	public void setup() throws IOException {

		BasicConfigurator.configure(); // for Log4j configuration

		log.info("Initializing driver");
		driver = base.setUpDriver();

		log.info("Loading url");
		driver.get(elements.getProperty("homeUrl"));

	}

	@DataProvider
	public Object[][] loginCredentials(Method methodName) {

		if (methodName.getName().equals("validateLogin")) {

			return new Object[][] { { "xyz@gmail.com", "123456789" }, { "sri@gmail.com", "989889" } };

		} else if (methodName.getName().equals("validateLogout")) {

			return new Object[][] { { "apple@banana.com", "applebanana@12" } };

		}

		return null;
	}

	@Test(dataProvider = "loginCredentials")
	public void validateLogin(String email, String password) {

		LoginPage loginPage = new LoginPage(driver);

		log.info("Opening Login Page");
		loginPage.getMyAccount().click();
		loginPage.getLogin().click();

		log.info("Inserting Login Credentials - wrong");
		loginPage.getEmail().clear();
		loginPage.getPassword().clear();

		loginPage.getEmail().sendKeys(email);
		loginPage.getPassword().sendKeys(password);

		log.info("Submitting");
		loginPage.getSubmit().click();

		String actual = loginPage.getTitle();
		String expected = "Account Login";

		Assert.assertEquals(actual, expected);
		
		if (actual.equals(expected)) {

			log.info("Wrong credentials didn't get access.");
		} else {

			log.error("Wrong credentials got access.");
		}

	}

	@Test(dataProvider = "loginCredentials")
	public void validateLogout(String email, String password) {

		LoginPage loginPage = new LoginPage(driver);

		log.info("Opening Login Page");
		loginPage.getMyAccount().click();
		loginPage.getLogin().click();

		log.info("Inserting Login Credentials");
		loginPage.getEmail().clear();
		loginPage.getPassword().clear();

		loginPage.getEmail().sendKeys(email);
		loginPage.getPassword().sendKeys(password);

		loginPage.getSubmit().click();

		String actual = loginPage.getTitle();
		String expected = "My Account";

		Assert.assertEquals(actual, expected);

		if (actual.equals(expected)) {

			log.info("Correct credentials access granted");
		} else {

			log.error("Correct credentials access denied");
		}

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
