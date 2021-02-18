package com.wipro.L2POM.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Webelements {

	public static Properties property;
	FileInputStream fis;

	public String getProperty(String key) throws IOException {

		property = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\wipro\\L2POM\\resources\\application.properties");
		property.load(fis);

		return property.getProperty(key);
	}

	public String getScreen(String testcasename, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationfile = System.getProperty("user.dir") + "\\reports\\" + testcasename + ".png";
		FileUtils.copyFile(source, new File(destinationfile));
		return destinationfile;
	}

	public void dropdownbyvisible(WebElement option, String value) {
		Select sel = new Select(option);
		sel.selectByVisibleText(value);
	}

	public void wait(WebDriver driver, long time){
		
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public void hover(WebDriver driver, WebElement element){
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	// public Object [][]readdatafromexcel(int sheetno) throws
	// FileNotFoundException, IOException
	// {
	// XSSFWorkbook workbook=new
	// XSSFWorkbook(getfis("./src\\main\\java\\resources\\cs1.xlsx"));
	// XSSFSheet sheet=workbook.getSheetAt(sheetno);
	// int rowcount=sheet.getPhysicalNumberOfRows();
	// XSSFRow row=sheet.getRow(0);
	// int colcount=row.getLastCellNum();
	// Object data[][]=new Object[rowcount-1][colcount];
	// for(int i=0;i<rowcount-1;i++)
	// {
	// row=sheet.getRow(i+1);
	// for(int j=0;j<colcount;j++)
	// {
	// XSSFCell cell=row.getCell(j);
	// data[i][j]=formatter.formatCellValue(cell);
	// }
	// }
	// workbook.close();
	// return data;
	// }

	// private XSSFWorkbookType getfis(String string) {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
