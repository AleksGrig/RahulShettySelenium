package aleksgrig;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;

public class HomePageTest extends Base {

	private static Logger log = LogManager.getLogger(HomePageTest.class.getName());

	@BeforeClass
	public void before() throws IOException {
		driver = initDriver();
		log.info("Driver initialized.");
	}

	@Test(dataProvider = "getData")
	public void navigate(String userEmail, String userPassword) throws IOException, InterruptedException {
		driver.get(properties.getProperty("url"));
		HomePage homePage = new HomePage(driver);
		homePage.getLogin().click();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.getEmail().sendKeys(userEmail);
		loginPage.getPassword().sendKeys(userPassword);
		loginPage.getLogInButton().click();
	}

	@AfterClass
	public void after() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
		driver = null;
	}

	@DataProvider
	public Object[][] getData() {

		// Rows stands for number of different tests, columns stands for number of
		// values in one particular test
		Object[][] data = new Object[2][2];
		data[0][0] = "notRestrictedUser@gmail.com";
		data[0][1] = "55555";
		data[1][0] = "restrictedUser@gmail.com";
		data[1][1] = "4444";

		return data;
	}
}
