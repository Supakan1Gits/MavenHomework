package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CommonPage;
import pages.ECommerceSignUpPage;
import utils.Driver;
import utils.TestDataReader;

public class SignupTest {
	
	@BeforeMethod
	public void setup() {
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void test2() {
		System.out.println("Test 2");
	}
	
	@Test
	public void test3() {
		System.out.println("Test 3");
	}
	
	@Test
	public void test4() {
		System.out.println("Test 4");
	}
	
	@Test (groups = {"smoke-test"})
	public void test5() {
		System.out.println("Test 5");
	}
	
	@Test (groups = {"smoke-test", "signupPage"}, description = "verify signup page components")
	public void signUpPageTest() {
		CommonPage commonpage = new CommonPage();
		ECommerceSignUpPage signuppage = new ECommerceSignUpPage();
	// when
		Driver.getDriver().get(TestDataReader.getProperty("primeTechUrl"));
	// and click 
		Assert.assertTrue(commonpage.welcomeLink.isDisplayed());
		commonpage.welcomeLink.click();
    // and click 
		Assert.assertTrue(commonpage.signUpButton.isDisplayed());
		commonpage.signUpButton.click();
		
		// verify the sign up page web components
		Assert.assertTrue(signuppage.signUpText.isDisplayed());
		
		// email field verification
		Assert.assertTrue(signuppage.enterEmailField.isDisplayed());
		Assert.assertEquals(signuppage.enterEmailField.getAttribute("placeholder"), "Please Enter Your Email");
	
		// first name field verification
		Assert.assertTrue(signuppage.enterFirstNameField.isDisplayed());
		Assert.assertEquals(signuppage.enterFirstNameField.getAttribute("placeholder"), "Please Enter Your First Name");
		// last name field verification
		Assert.assertTrue(signuppage.enterLastNameField.isDisplayed());
		Assert.assertEquals(signuppage.enterLastNameField.getAttribute("placeholder"), "Please Enter Your Last Name");
		// password name field verification
		Assert.assertTrue(signuppage.enterPasswordField.isDisplayed());
		Assert.assertEquals(signuppage.enterPasswordField.getAttribute("placeholder"), "Please Enter Your Password");
		
		
		// google and facebook login verification
		Assert.assertTrue(signuppage.loginWithGoogle.isDisplayed());
		Assert.assertTrue(signuppage.loginWithFaceBook.isDisplayed());
		
		// check box verification
		Assert.assertTrue(signuppage.newsLettersCheckBox.isDisplayed());
		Assert.assertFalse(signuppage.newsLettersCheckBox.isSelected());
		Assert.assertTrue(signuppage.newsLettersSubscribeText.isDisplayed());
		
		// back and signup buttons 
		Assert.assertTrue(signuppage.signUpBtn.isDisplayed());
		Assert.assertTrue(signuppage.backToLoginBtn.isDisplayed());
			
	}
	
	
	@AfterMethod
	public void quitDriver() {
		Driver.quitDriver();
	}
}


