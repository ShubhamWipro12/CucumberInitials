
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumWebDriver{

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SH40064174\\Downloads\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver chrome = new ChromeDriver();
		chrome.manage().window().maximize();

		// open site
		chrome.get("https://demo.opencart.com/");

		// click login
		chrome.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/a/span[2]")).click();
		chrome.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/ul/li[2]/a")).click();

		// enter username and password
		chrome.findElement(By.xpath("//*[@id='input-email']")).clear();
		chrome.findElement(By.xpath("//*[@id='input-email']")).sendKeys("apple@banana.com");
		chrome.findElement(By.xpath("//*[@id='input-password']")).clear();
		chrome.findElement(By.xpath("//*[@id='input-password']")).sendKeys("applebanana@12");
		chrome.findElement(By.xpath("//*[@id='content']/div/div[2]/div/form/input")).submit();

		chrome.findElement(By.xpath("//*[@id='search']/input")).sendKeys("Tablets");
		chrome.findElement(By.xpath("//*[@id='search']/input")).sendKeys(Keys.ENTER);

		// Select "Monitors" under Components in the drop down. Check "Search
		// in sub categories" and click Search
		new Select(chrome.findElement(By.xpath("//*[@id='content']/div/div[2]/select"))).selectByValue("28");
		chrome.findElement(By.xpath("//*[@id='content']/div/div[3]/label/input")).click();
		chrome.findElement(By.xpath("//*[@id='button-search']")).click();

		// Click on "Phones and PDA's" tab
		chrome.findElement(By.xpath("//*[@id='menu']/div[2]/ul/li[6]/a")).click();
		// Sort from the "Price (High > Low)" for the page
		// chrome.findElement(By.xpath("//*[@id='input-sort']")).click();
		new Select(chrome.findElement(By.xpath("//*[@id='input-sort']"))).selectByVisibleText("Price (High > Low)");

		// Add to Compare
		for (int i = 0; i < 3; i++) {
			chrome.findElement(By.xpath("//*[@id='content']/div[2]/div[" + (i + 1) + "]/div/div[2]/div[2]/button[3]"))
					.click();
		}

		// WebElement
		// close=chrome.findElement(By.xpath("//*[@id='product-category']/div[1]/button"));
		// WebDriverWait wait = new WebDriverWait(chrome, 15);
		// wait.until(ExpectedConditions.elementToBeClickable(close)); //not
		// working

		chrome.findElement(By.xpath("//*[@id='compare-total']")).click();

		// select a phone
		chrome.findElement(By.xpath("//*[@id='content']/table/tbody[1]/tr[1]/td[2]/a")).click();

		// Check the fifth feature in the description section of the phone and
		// write
		// into flat file.
		File flat = new File("Flat.txt");
		if (flat.exists()) {
			flat.delete();
		}
		flat.createNewFile();

		FileOutputStream fos = new FileOutputStream(flat);
		fos.write(chrome.findElement(By.xpath("//*[@id='tab-description']/ul/li[5]")).getText().getBytes());
		fos.close();

		chrome.findElement(By.xpath("//*[@id='button-cart']")).click();

		// click on shopping cart
		chrome.findElement(By.xpath("//*[@id='top-links']/ul/li[4]/a/span")).click();
		// click on checkout
		chrome.findElement(By.xpath("//*[@id='content']/div[3]/div[2]/a")).click();

		// It is unable to proceed further.

		// log-out
		chrome.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/a/span[2]")).click();
		chrome.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/ul/li[5]/a")).click();
		chrome.findElement(By.xpath("//*[@id='content']/div/div/a")).click();

		 chrome.close();

	}

}
