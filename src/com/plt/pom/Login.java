package com.plt.pom;

import static utils.Config.getSelector;
import static utils.Config.getUserCredentials;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helpers.CommonActions;

public class Login {
WebDriver driver;
	
	CommonActions helpers;
	public Login(WebDriver driver) {
		this.driver=driver;	
		this.helpers = new CommonActions(driver);
	}
	
	public void SignIn() throws InterruptedException, IOException {
		helpers.waitForElementDisplayed(getSelector("emailField"));
		driver.findElement(getSelector("emailField")).sendKeys(getUserCredentials("PLTusername")); 
		driver.findElement(getSelector("submitButton")).click();
		helpers.waitForElementDisplayed(getSelector("passwordField"));
		driver.findElement(getSelector("passwordField")).sendKeys(getUserCredentials("PLTPassword")); 
		driver.findElement(getSelector("submitButton")).click();
	}
}
