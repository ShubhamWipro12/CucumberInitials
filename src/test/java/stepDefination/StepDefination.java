package stepDefination;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import src.test.java.tests.Configure;

public class StepDefination {

	public static WebDriver driver;
	static final Logger log = Logger.getLogger(StepDefination.class);
	Configure configuration;

	@Given("Open Google")
	public void open_google() {
		
		BasicConfigurator.configure();

		log.info("Setting up driver");
		configuration = new Configure();
		driver = configuration.setUp();
		
		
	}

	@When("You pass {string}")
	public void you_pass(String string) {
		log.info("Searching "+string+" on google");
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys(string);
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
	}

	@Then("Pages related to search should get displayed {string}")
	public void pages_related_to_search_should_get_displayed(String string) {
		log.info("Matching search page with the query");
		Assert.assertTrue(driver.getTitle().contains(string));
		driver.close();
	}
	
}
