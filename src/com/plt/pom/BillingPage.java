package com.plt.pom;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import static utils.Config.getSelector;

import java.io.IOException;

import helpers.CommonActions;

public class BillingPage {

	WebDriver driver;
	CommonActions helpers;

	public BillingPage(WebDriver driver) {
		this.driver = driver;
		this.helpers=new CommonActions(driver);
	}

	public void assertProductName() throws IOException{
		String ProductName=helpers.waitAndGetText(getSelector("productName"));
		System.out.println("i am name actual: "+ProductName);
		System.out.println("I am name Expected: "+helpers.ProductName);
		Assert.assertEquals(ProductName, helpers.ProductName);		
	}

	public void assertSelectedProductSize() throws IOException {
		String PRoductSelectedSize=helpers.waitAndGetText(getSelector("productSize"));
		System.out.println("i am size actual: "+PRoductSelectedSize);
		System.out.println("I am size Expected: "+helpers.ProductSize);
		assertTrue(PRoductSelectedSize.contains(helpers.ProductSize));

	}

	public void assertProductPrice() throws IOException {
		String SubTotal=helpers.waitAndGetText(getSelector("productSubtotal"));
		System.out.println("i am subtotal actual: "+SubTotal);
		System.out.println("I am subtotal Expected: "+helpers.productSubTotal);
		Assert.assertEquals(SubTotal, helpers.productSubTotal);	
	}

	public void verifyDeliveryTotal() throws IOException {
		helpers.waitForElementDisplayed(getSelector("deliveryTotal"));
	}

	public void verifyGrandTotal() throws IOException {
		helpers.waitForElementDisplayed(getSelector("grandTotal"));
	}
	public void clickOnPaymentMethod() throws InterruptedException, IOException {
        helpers.ScrollToView(getSelector("goToPayment"));
		helpers.waitAndClick(getSelector("goToPayment"));
	}
}
