package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ECommerceSignUpPage;
import utils.Driver;
import utils.TestDataReader;

public class EcommerceLoginTest {
	
     ECommerceSignUpPage primeTech = new ECommerceSignUpPage();
 
  @Test (description="verify sign up page")
  public void signUpTest(){
	  
	  
//	  When I navigate to the “Prime Tech Ecommerce Store”,
	  Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  Driver.getDriver().get(TestDataReader.getProperty("primeTechUrl"));
	  
	  
//	  And I click on the Welcome Dropdown,And I click on the ‘Sign Up’ Link
//	  Assert.assertTrue(primeTech.welcomeDropDown.isDisplayed());
	  primeTech.welcomeDropDown.click();
//	  Assert.assertTrue(primeTech.singUpLink.isDisplayed());
	  primeTech.singUpLink.click();
	  
	  
//	  Then the system should display the following page with the UI components as follows
//	  Page Title: “Sign Up” Text Box -1: 

	  Assert.assertTrue(primeTech.signUpText.isDisplayed());
	  Assert.assertEquals(primeTech.signUpText.getText(), TestDataReader.getProperty("signUpText"));

	  
//	  A Text box with the Label ‘Email Address’ with  
//
      Assert.assertTrue(primeTech.emailAddrressText.isDisplayed());
	  Assert.assertEquals(primeTech.emailAddrressText.getText(), TestDataReader.getProperty("emailText"));
	  
//	  “Please Enter Your Email”
	  Assert.assertTrue(primeTech.enterEmailField.isDisplayed());
	  Assert.assertEquals(primeTech.enterEmailField.getAttribute("placeholder"), 
			   TestDataReader.getProperty("emailFieldText"));
	  
//	  A Text box with the Label ‘First Name’ with “Please Enter Your First Name”
	  Assert.assertTrue(primeTech.firstNameText.isDisplayed());
	  Assert.assertEquals(primeTech.firstNameText.getText(), TestDataReader.getProperty("firstNameText"));
	  Assert.assertTrue(primeTech.enterFirstNameField.isDisplayed());
	  
//	  A Text box with the Label ‘Last Name’ with “Please Enter Your Last Name”
	  Assert.assertTrue(primeTech.lastNameText.isDisplayed());
	  Assert.assertEquals(primeTech.lastNameText.getText(), TestDataReader.getProperty("lastNameText"));
	  Assert.assertTrue(primeTech.enterLastNameField.isDisplayed());
	  
		  
//	  A Text box with the Label ‘Password’ with “Please Enter Your Password
	  Assert.assertTrue(primeTech.passwordText.isDisplayed());
	  Assert.assertEquals(primeTech.passwordText.getText(), TestDataReader.getProperty("passwordText"));
	  Assert.assertTrue(primeTech.enterPasswordField.isDisplayed());
	  

//	  A button titled ‘Login with Google’
	  Assert.assertTrue(primeTech.loginWithGoogle.isDisplayed());
	  

//	  A button titled ‘Login with Facebook’
	  Assert.assertTrue(primeTech.loginWithFaceBook.isDisplayed());
	  
	  
//	  A Checkbox titled ‘Subscribe To Our Newsletter’ Button
	  Assert.assertTrue(primeTech.newsLettersCheckBox.isDisplayed());
	  Assert.assertTrue(primeTech.newsLettersSubscribeText.isDisplayed());
	  Assert.assertEquals(primeTech.newsLettersSubscribeText.getText(), 
			  TestDataReader.getProperty("newslettersSubscribeText"));
	  
//	  A button titled ‘Sign Up’. Link 1 - A Link titled ‘Back To Login’
	  Assert.assertTrue(primeTech.signUpBtn.isDisplayed());
	  Assert.assertTrue(primeTech.backToLoginBtn.isDisplayed());
		 
		 
	  Driver.quitDriver();
		 
	  
	  
  }
}
