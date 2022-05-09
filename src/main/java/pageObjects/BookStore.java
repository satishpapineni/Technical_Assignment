package pageObjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class BookStore {
	public WebDriver driver;
	public String k = "Git Pocket Guide";

	public BookStore(WebDriver driver) {
		this.driver = driver;
	}

	By searchBox = By.id("searchBox");
	By gitHub = By.xpath("//div[@class='action-buttons']/span/a");
	By cartButton1 = By.xpath("//div[@class='profile-wrapper']/div[9]/div[2]");
	By pratice = By.xpath("//div[@class='accordion']/div[6]/div/ul/li[3]");

	public void getGitHub() throws InterruptedException {
		driver.findElement(searchBox).sendKeys("Git");
		List<WebElement> gitItem = driver.findElements(gitHub);
		for (int j = 0; j < gitItem.size(); j++) {
			String text = gitItem.get(j).getText();

			if (k.equals(text)) {

				gitItem.get(j).click();
				JavascriptExecutor jse1 = (JavascriptExecutor) driver;
				jse1.executeScript("window.scrollBy(0,500)");
				driver.findElement(cartButton1).click();
				Thread.sleep(2500);
				driver.switchTo().alert().accept();

				driver.findElement(pratice).click();

			} else {
				Assert.assertFalse(false);
			}
		}

	}

}
