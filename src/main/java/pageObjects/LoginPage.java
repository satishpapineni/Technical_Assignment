package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//Created a Class for Login Page
public class LoginPage {
	public WebDriver driver;
	By userName = By.id("userName");
	By password = By.id("password");
	By log = By.id("login");

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getuserName() {
		return driver.findElement(userName);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLogin() {
		return driver.findElement(log);
	}

}
