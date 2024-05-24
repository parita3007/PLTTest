package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class Config {
	private static String locatorProperty;
	private static String locatorType;
	private static String locatorValue;

	public static Properties getPropertyObject() throws IOException {

		FileInputStream fp = new FileInputStream("src/PropertiesFiles/SelectorsProperties");
		Properties prop = new Properties();
		prop.load(fp);
		return prop;
	}

	public static Properties getSelectorsObject() throws IOException {

		FileInputStream fp = new FileInputStream("src/PropertiesFiles/SelectorsProperties");
		Properties prop = new Properties();
		prop.load(fp);
		return prop;
	}

	public static String getUserCredentials(String userData) throws IOException {
		return getPropertyObject().getProperty(userData);
	}

	public static By getSelector(String locatorName) throws IOException {
		locatorProperty = getSelectorsObject().getProperty(locatorName);
		locatorType = locatorProperty.split(":")[0];
		System.out.println(locatorProperty.toString());
		locatorValue = locatorProperty.split(":")[1];

		By locator = null;
		switch (locatorType) {
		case "Id":
			locator = By.id(locatorValue);
			break;

		case "Name":
			locator = By.name(locatorValue);
			break;

		case "Class":
			locator = By.className(locatorValue);
			break;

		case "CssSelector":
			locator = By.cssSelector(locatorValue);
			break;

		case "LinkText":
			locator = By.linkText(locatorValue);
			break;

		case "PartialLinkText":
			locator = By.partialLinkText(locatorValue);
			break;

		case "TagName":
			locator = By.tagName(locatorValue);
			break;

		case "Xpath":
			locator = By.xpath(locatorValue);
			break;
		}

		return locator;

	}

}
