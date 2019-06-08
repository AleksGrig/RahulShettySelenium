package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	By emailField = By.cssSelector("#user_email");
	By passwordField = By.cssSelector("#user_password");
	By logInButton = By.xpath("//input[@value='Log In']");

	public WebElement getEmail() {
		return driver.findElement(emailField);
	}

	public WebElement getPassword() {
		return driver.findElement(passwordField);
	}

	public WebElement getLogInButton() {
		return driver.findElement(logInButton);
	}
}
