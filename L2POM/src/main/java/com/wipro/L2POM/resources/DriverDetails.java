package com.wipro.L2POM.resources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.wipro.L2POM.utility.Webelements;

public class DriverDetails {

	static WebDriver driver;
	Webelements property;
	
	String chromeDriverPath = "C:\\Users\\SH40064174\\Downloads\\Softwares\\chromedriver_win32\\chromedriver.exe";
	String edgeDriverPath = "C:\\Users\\SH40064174\\Downloads\\Softwares\\working\\edgeDriver\\msedgedriver.exe";

	public WebDriver setUpDriver() throws IOException {

		property = new Webelements();
		
		String browser = property.getProperty("browser");

		if (browser.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			return new ChromeDriver();
			
		} else if (browser.equals("edge")) {
			
			System.setProperty("webdriver.edge.driver", edgeDriverPath);
			return new EdgeDriver();
			
		}
		return null;

	}


}
