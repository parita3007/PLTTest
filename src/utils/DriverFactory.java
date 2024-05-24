package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {
	public static WebDriver getBrowser(String browserType) {

		WebDriver driver = null;

		if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/parita.patel/Desktop/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);

		} else if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver", "/Users/parita.patel/Desktop/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);

		}
		driver.manage().window().maximize();
		return driver;
	}
}
