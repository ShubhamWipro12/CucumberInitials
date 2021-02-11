package src.test.java.tests;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class DriverInfo {
	Service property;
	static final Logger log = Logger.getLogger(DriverInfo.class);
	
	public WebDriver setUpDriver()  {
		BasicConfigurator.configure();
		
		property = new Service(); 

		String browser = null;
		browser = property.getProperty("browser");
		log.info(browser+ " driver is selected to conduct the tests");

		if (browser.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SH40064174\\Downloads\\Softwares\\chromedriver_win32\\chromedriver.exe");
			return new ChromeDriver();

		} else if (browser.equals("edge")) {

			System.setProperty("webdriver.edge.driver", "C:\\Users\\SH40064174\\Downloads\\Softwares\\working\\edgeDriver\\msedgedriver.exe");
			return new EdgeDriver();

		}
		return null;
	}
}
