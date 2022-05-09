package pageObjects;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BooksCollection {
	public WebDriver driver;

	public BooksCollection(WebDriver driver) {
		this.driver = driver;
	}

	public String[] selectedBooks = { "You Don't Know JS", "Understanding ECMAScript 6",
			"Learning JavaScript Design Patterns" };
	By cartButton = By.xpath("//div[@class='profile-wrapper']/div[9]/div[2]");
	By sortBook = By.xpath("//div[@class='action-buttons']/span/a");

	public void getBooks() throws InterruptedException {

		List<WebElement> myElements = driver.findElements(sortBook);

		for (int i = 0; i < myElements.size(); i++) {
			String finalText = myElements.get(i).getText();
			List items = Arrays.asList(selectedBooks);
			if (items.contains(finalText)) {
				String tab = Keys.chord(Keys.CONTROL, Keys.ENTER);
				myElements.get(i).sendKeys(tab);
			}
		}
	}

	public void addBook() throws InterruptedException {

		String parent = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		int count = allWindows.size();
		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				Thread.sleep(2000);
				driver.switchTo().window(child);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,500)");
				driver.findElement(cartButton).click();
				Thread.sleep(3000);
				driver.switchTo().alert().accept();
				Thread.sleep(2000);
				driver.close();

			}

		}
		driver.switchTo().window(parent);

	}
}
