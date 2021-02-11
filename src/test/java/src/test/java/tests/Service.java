package src.test.java.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Service {

	public String getProperty(String key) {
		FileInputStream fis = null;

		Properties property = new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir")
					+"\\src\\main\\resources\\data.properties");
			property.load(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return property.getProperty(key);
	}

}
