package aleksgrig;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	protected static WebDriver driver;
	protected static Properties properties;

	public WebDriver initDriver() throws IOException {
		properties = new Properties();
		FileInputStream inputFile = new FileInputStream("src/main/resources/data.properties");
		properties.load(inputFile);

		switch (properties.getProperty("browser")) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "drivers/MozillaGeckoDriver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		case "chrome":
			System.setProperty("webdriver.chrome.driver", "drivers/ChromeDriver/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "iexplorer":
			System.setProperty("webdriver.ie.driver", "drivers/MicrosoftWebDriver/MicrosoftWebdriver.exe");
			driver = new InternetExplorerDriver();
			break;

		default:
			System.setProperty("webdriver.gecko.driver", "drivers/MozillaGeckoDriver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public static void getScreenShot(String testName) throws IOException {
		File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		LocalDateTime dateTime = LocalDateTime.now();
		String formattedDate = dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy$$HH-mm-ss"));
		FileUtils.copyFile(screenShot, new File("screenshots/" + testName + formattedDate + ".png"));
	}
}
