package Book.E2EProject;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.BookStore;
import pageObjects.BooksCollection;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.ProfileLogout;
import resources.Base;

//I created a class for test
//Inherit the features of Base class to HomePage
public class HomePage extends Base {
	// Run the test Before Test
	@BeforeTest
	public void intialize() throws IOException {
		driver = intializeDriver();
		driver.get(prop.getProperty("url"));
	}

	// Run the Test
	@Test(dataProvider = "getData")
	// here I created the object for every class to acess the Methods.
	public void basepageNavigation(String userName, String password) throws IOException, InterruptedException {

		LandingPage p = new LandingPage(driver);
		p.getLogin().click();
		LoginPage lp = new LoginPage(driver);
		lp.getuserName().sendKeys(userName);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
		Thread.sleep(2000);
		BooksCollection bc = new BooksCollection(driver);
		bc.getBooks();
		Thread.sleep(3000);
		bc.addBook();
		BookStore bs = new BookStore(driver);
		bs.getGitHub();
		Thread.sleep(2000);
		ProfileLogout pl = new ProfileLogout(driver);
		pl.finalStep();

	}

	// Given Data Dynamically
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][2];
		data[0][0] = "satish";
		data[0][1] = "Satish@11";
		return data;
	}

	// Run the test after test
	@AfterTest
	public void teardown() {
		driver.close();
	}

}
