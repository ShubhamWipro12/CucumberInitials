package com.wipro.L2POM.testCases;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wipro.L2POM.pageObject.LoginPage;
import com.wipro.L2POM.pageObject.SortObject;
import com.wipro.L2POM.resources.DriverDetails;
import com.wipro.L2POM.utility.Webelements;

public class SortObjectTest {
	WebDriver driver;

	DriverDetails base = new DriverDetails();
	Webelements elements = new Webelements();

	static final Logger log = Logger.getLogger(SortObjectTest.class);

	@BeforeTest
	public void setup() throws IOException {

		BasicConfigurator.configure(); // for Log4j configuration

		log.info("Initializing driver");
		driver = base.setUpDriver();

		log.info("Loading url");
		driver.get(elements.getProperty("homeUrl"));
	}

	
	@Test
	public void shortTest() {

		LoginPage loginPage = new LoginPage(driver);
		SortObject sort = new SortObject(driver);
		
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

		log.info("Opening Laps and Notes");
		elements.hover(driver, sort.getLaptopAndNote());
		sort.getShowAll().click();
		
		elements.dropdownbyvisible(sort.getSort(), "Name (A - Z)");
		elements.wait(driver, 5);
		
		log.info("Checking alphabetical order - ascending");
		String result1 = sort.getResult1().getText();
		String result2 = sort.getResult2().getText();
		
		log.info((result1.compareTo(result2)<0)?"Order is maintained":"Doesn't follow Ascending order");
		
		
		elements.dropdownbyvisible(sort.getSort(), "Name (Z - A)");
		elements.wait(driver, 5);
		
		log.info("Checking alphabetical order - descending");
		String result_1 = sort.getResult1().getText();
		String result_2 = sort.getResult2().getText();
		
		log.info((result_1.compareTo(result_2)>0)?"Order is maintained":"Doesn't follow Descending order");
		
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
