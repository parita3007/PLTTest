package helpers;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions {
	WebDriver driver;
	public static String ProductSize;
	public static String ProductName;
	public static String ProductPrice;
	public static String productSubTotal;
	
	public CommonActions(WebDriver driver){
		this.driver=driver;
	}
	
	public void waitAndClick(By element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		driver.findElement(element).click();
	}
	
	public String waitAndGetText(By element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		System.out.println(driver.findElement(element).getText());
		return driver.findElement(element).getText();
	}
	
	public void waitForElementDisplayed(By element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		driver.findElement(element).isDisplayed();
		
	}
	
	public WebElement selectRandomItem(List<WebElement> element) {
		List<WebElement> listItems= element;
		  int maxProducts = listItems.size();
		  System.out.println("Size is :"+maxProducts);
		  Random random = new Random();
		  int randomProduct = random.nextInt(maxProducts);
		  return listItems.get(randomProduct);		
	}
	
	public void ScrollToView(By element) throws InterruptedException {
//		Thread.sleep(10000);
		waitForElementDisplayed(element);
		WebElement l=driver.findElement(element);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);	
	}
	
	public void acceptCookiesPopUp(By element) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Thread.sleep(3000);
		driver.findElement(element).click();
	}
	

}
