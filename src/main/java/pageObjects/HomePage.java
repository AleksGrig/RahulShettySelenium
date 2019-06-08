package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	private By logIn = By.cssSelector("a[href*='sign_in']");
	private By title = By.xpath("//h2[text()='Featured Courses']");
	private By navigationBar = By.cssSelector("nav.navbar-collapse.collapse");

	public WebElement getLogin() {
		return driver.findElement(logIn);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}

	public WebElement getNavigationBar() {
		return driver.findElement(navigationBar);
	}
}
