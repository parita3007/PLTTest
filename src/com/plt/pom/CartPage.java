package com.plt.pom;

import static utils.Config.getSelector;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import helpers.CommonActions;

public class CartPage {
	WebDriver driver;
	CommonActions helpers;
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		this.helpers= new CommonActions(driver);
	} 
	public void ValidateProductName() throws InterruptedException, IOException {
		Thread.sleep(3000);
//	String ProductNameCart =helpers.waitAndGetText(getSelector("cartproductName"));
	String ProductNameCart =helpers.waitAndGetText(By.cssSelector("[class='font-brand-thin text-sm text-new-brand-black hover:underline lg:text-base lg:tracking-wide']"));
	System.out.println("Actual Product name: "+ProductNameCart);
	System.out.println("Actual Product name: "+helpers.ProductName);
	Assert.assertEquals(ProductNameCart, helpers.ProductName);
	}
	
	public void getProductPrice() throws IOException {
		helpers.productSubTotal=helpers.waitAndGetText(By.cssSelector("[class='flex lg:justify-end'] p:nth-child(2)"));		
	}
	
	public void gotoCheckoutPage() throws IOException {
		helpers.waitAndClick(getSelector("checkoutButton"));
	}
}
