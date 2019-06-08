package aleksgrig;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;

public class ValidateTitleTest extends Base {

	private static Logger log = LogManager.getLogger(ValidateTitleTest.class.getName());

	@BeforeClass
	public void before() throws IOException {
		driver = initDriver();
		log.info("Driver initialized for ValidateTitleTest");
	}

	@Test
	public void validateTitle() throws IOException {
		driver.get(properties.getProperty("url"));
		HomePage homePage = new HomePage(driver);
		Assert.assertEquals(homePage.getTitle().getText(), "FEATURED COURSES");
		Assert.assertTrue(homePage.getNavigationBar().getText().contains("INTERVIEW GUIDE"));
		Assert.assertTrue(homePage.getNavigationBar().isDisplayed());
	}

	@AfterClass
	public void after() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
		driver = null;
	}
}
