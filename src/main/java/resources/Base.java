package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//Created a Class 
public class Base {
	// Define Global Elements
	public WebDriver driver;
	public Properties prop;

	// Created a Method for driver access
	public WebDriver intializeDriver() throws IOException {
		prop = new Properties();
		// Given a file from Local Path
		FileInputStream fis = new FileInputStream(
				"C:\\Selenium\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		// By using property method, I am calling a browser
		String browserName = prop.getProperty("browser");
		// I used If and ElseIf Condition for different browsers.
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {
			WebDriverManager.iedriver().setup();

			driver = new InternetExplorerDriver();
		}

		return driver;
	}

}
