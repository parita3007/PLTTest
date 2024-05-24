package com.plt.testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.plt.pom.HomePage;
import com.plt.pom.BillingPage;
import com.plt.pom.CartPage;
import com.plt.pom.PDPPage;
import com.plt.pom.PLPPage;
import com.plt.pom.Login;

import utils.DriverFactory;

public class PLTTestCase {
	

    WebDriver driver;
    public String url="https://www.prettylittlething.com/";

	
	@BeforeTest
	@Parameters({"browser"})
	public void beforeTest(String browserName) {
	    driver=DriverFactory.getBrowser(browserName);	
	}
	
	@Test
	public void PlaceOrderOnPLT() throws IOException, InterruptedException {
		HomePage homePage= new HomePage(driver);
		PLPPage plpPage= new PLPPage(driver);
		PDPPage pdpPage=new PDPPage(driver);
		CartPage cartPage= new CartPage(driver);
		Login signInPage= new Login(driver);
		BillingPage billingPage= new BillingPage(driver);
		
		homePage.openAndValidateStore(url);
		homePage.selectCategory();
		plpPage.SelectProduct();
		pdpPage.getProductName();
		pdpPage.SelectAndValidateSize();
		pdpPage.addToBag();
		cartPage.ValidateProductName();
		cartPage.getProductPrice();
		cartPage.gotoCheckoutPage();
		signInPage.SignIn();
		billingPage.assertProductName();
		billingPage.assertSelectedProductSize();
		billingPage.assertProductPrice();
		billingPage.verifyDeliveryTotal();
		billingPage.verifyGrandTotal();
		billingPage.clickOnPaymentMethod();
	}
	
	@AfterTest
	public void AfterTest() {
		driver.quit();
	}

}
