package pageObjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class ProfileLogout {
	public WebDriver driver;
	int sum = 0;
	int r;
	public String[] finalBooks = { "You Don't Know JS", "Understanding ECMAScript 6",
			"Learning JavaScript Design Patterns", "Git Pocket Guide" };

	public ProfileLogout(WebDriver driver) {
		this.driver = driver;
	}

	By books = By.xpath("//div[@class='action-buttons']/span/a");
	By submit = By.id("submit");

	public void finalStep() {
		List<WebElement> Elements = driver.findElements(books);

		for (int i = 0; i < Elements.size(); i++) {
			String finalCollection = Elements.get(i).getText();
			JavascriptExecutor jse2 = (JavascriptExecutor) driver;
			jse2.executeScript("window.scrollBy(0,200)");
			List items = Arrays.asList(finalBooks);
			r = 0;
			if (items.contains(finalCollection)) {
				r++;

				System.out.println(finalCollection);
				sum = sum + r;

			} else {
				System.out.println("Items are not added into user Collection");
			}

		}
		System.out.println("Items are added into user Collection:" + sum);
		driver.findElement(submit).click();

	}

}
