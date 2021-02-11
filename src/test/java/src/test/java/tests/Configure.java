package src.test.java.tests;

import org.openqa.selenium.WebDriver;

public class Configure {

	public WebDriver setUp() {
		DriverInfo info = new DriverInfo();
		WebDriver driver = info.setUpDriver();
		driver.manage().window().maximize();

		Service property = new Service();
		driver.get(property.getProperty("url"));
		return driver;
	}

}
