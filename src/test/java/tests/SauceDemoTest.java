package tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SauceDemoPage;
import utils.Driver;
import utils.TestDataReader;

public class SauceDemoTest {
	    
	SauceDemoPage login = new SauceDemoPage();
	
  @Test 
  public void testCase1() {
	  
		/*
		 * go to https://saucedemo.com log in with valid username = standard_user
		 * password = secret_sauce Verify that you are logged in successfully.
		 */
//	   go to https://saucedemo.com
	   Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   Driver.getDriver().get(TestDataReader.getProperty("sauceUrl"));
	   

//	   log in with valid username = standard_user, password = secret_sauce
	   login.username.sendKeys(TestDataReader.getProperty("sauceUsername"));
	   login.password.sendKeys(TestDataReader.getProperty("saucePassword"));
	   login.loginButton.click();
	   
//	   Verify that you are logged in successfully.
	   Assert.assertTrue(login.productText.isDisplayed());
	   
       
}
  @Test
  public void testCase2() {
		/*		 * go to https://saucedemo.com log in with invalid username = invalid_user
		 * password = secret_sauce Verify that you are not logged in, and you get the
		 * error message of: “Epic sadface: Username and password do not match any user
		 * in this service”
		 * 
		 */
	   
//	   go to https://saucedemo.com 
	   Driver.getDriver().get(TestDataReader.getProperty("sauceUrl"));
	   
	   
//	   log in with invalid username = invalid_user, password = secret_sauce
	   login.username.sendKeys(TestDataReader.getProperty("sauceInvalidUsername"));
	   login.password.sendKeys(TestDataReader.getProperty("saucePassword"));
	   login.loginButton.click();
	   
//	   Verify that you are not logged in, and you get the error message of: 
	   Assert.assertTrue(login.username.isDisplayed());	  
	   
	   
//	   “Epic sadface: Username and password do not match any user in this service”
	   
	   WebDriverWait letsWait = new WebDriverWait(Driver.getDriver(), 5);
	   letsWait.until(ExpectedConditions.visibilityOf(login.errorMessage));
	   
	   Assert.assertEquals(login.errorMessage.getText(), 
			   TestDataReader.getProperty("sauceInvalidUsernameErrorMessage"));
	   
	   
	   
}
  @Test
  public void testCase3() {
	  
		/* 
		 * go to https://saucedemo.com
		 * log in with locked username = locked_out_user,password = secret_sauce 
		 * Verify that you are not logged in, and you get the error message of :
		 * “Epic sadface: Sorry, this user has been locked out.”
		 * 
		 */
	  
//	   go to https://saucedemo.com 
	   Driver.getDriver().get(TestDataReader.getProperty("sauceUrl"));
	   
	   
//	   log in with locked username = locked_out_user,password = secret_sauce 
	   login.username.sendKeys(TestDataReader.getProperty("sauceLockedOutUsername"));
	   login.password.sendKeys(TestDataReader.getProperty("saucePassword"));
	   login.loginButton.click();
	   
	   
//	   Verify that you are not logged in, and you get the error message of :
//	   “Epic sadface: Sorry, this user has been locked out.”
	   Assert.assertTrue(login.username.isDisplayed());
	   
	   WebDriverWait letsWait = new WebDriverWait(Driver.getDriver(), 5);
	   letsWait.until(ExpectedConditions.visibilityOf(login.errorMessage));
	   
	   Assert.assertEquals(login.errorMessage.getText(), 
			   TestDataReader.getProperty("sauceLockedOutUsernameErrorMessage"));
	   
	   Driver.quitDriver();
		
  }
  
  
}
