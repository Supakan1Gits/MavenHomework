package tests;

import org.testng.annotations.Test;

import pages.CommonPage;
import pages.ECommerceSignUpPage;
import utils.Driver;
import utils.TestDataReader;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class RequireFieldValidation {
	  
	 ECommerceSignUpPage validation =  new ECommerceSignUpPage();
	 CommonPage page = new CommonPage();
	
	
  @Test (description = "verify require field")
  public void Validation() {
//	  When I navigate to the ‘Sign Up’ screen, 
	  Driver.getDriver().get(TestDataReader.getProperty("primeTechUrl"));
	  page.welcomeLink.click();
	  page.signUpButton.click();

//	  click on ‘Sign Up’ Button,
	  validation.signUpBtn.click();
	  

//	  Email Address’ Textbox if no value should see the following error message:”Email is required.”
	  Assert.assertTrue(validation.enterEmailField.getText().isEmpty());
	  Assert.assertEquals(validation.emailRequiredText.getText(), "Email is required.");
	  
//	  First Name’ Textbox, If no value the user should see the following error message: ”First Name is required.”
	  Assert.assertTrue(validation.enterFirstNameField.getText().isEmpty());
	  Assert.assertEquals(validation.firstNameRequiredText.getText(), "First Name is required.");
	  

//	  Last Name’ Textbox, If no valueshould see the following error message:”Last Name is required.”
	  Assert.assertTrue(validation.enterLastNameField.getText().isEmpty());
	  Assert.assertEquals(validation.lastNameRequiredText.getText(), "Last Name is required.");


//	  Password’ Textbox, If no value should see the following error message:”Password is required.”
	  Assert.assertTrue(validation.enterPasswordField.getText().isEmpty());
	  Assert.assertEquals(validation.passwordRequiredText.getText(), "Password is required.");
	  

//	  The System should ensure that the user is unable to Register an account.
	  Assert.assertTrue(validation.signUpBtn.isDisplayed());


  }
  @BeforeMethod
  public void beforeMethod() {
	  Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	  Driver.quitDriver();
  }

}
