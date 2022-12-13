package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class ECommerceSignUpPage {
	
	public ECommerceSignUpPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(linkText = "Welcome!")
	public WebElement welcomeDropDown;
	
	@FindBy(xpath = "//button[text()='Sign Up']")
	public WebElement singUpLink;
	
	@FindBy(xpath = "//h2[text()='Sign Up']")
	public WebElement signUpText;
	
	@FindBy(xpath = "//label[text()='Email Address']")
	public WebElement emailAddrressText;
	
	@FindBy(name = "email")
	public WebElement enterEmailField;
	
	@FindBy(xpath = "//label[text()='First Name']")
	public WebElement firstNameText;
		 
	@FindBy(name = "firstName")
	public WebElement enterFirstNameField;
	
	@FindBy(xpath = "//label[text()='Last Name']")
	public WebElement lastNameText;
		 
	@FindBy(name = "lastName")
	public WebElement enterLastNameField;
	
	@FindBy(xpath = "//label[text()='Password']")
	public WebElement passwordText;
		 
	@FindBy(name = "password")
	public WebElement enterPasswordField;
	
	@FindBy(linkText = "Login with Google")
	public WebElement loginWithGoogle;
		 
	@FindBy(linkText = "Login with Facebook")
	public WebElement loginWithFaceBook;
	
	@FindBy(id = "subscribe")
	public WebElement newsLettersCheckBox;
	
	@FindBy(xpath = "//label[contains(text(),'Subscribe To')]")
	public WebElement newsLettersSubscribeText;
		 
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	public WebElement signUpBtn;
	
	@FindBy(linkText = "Back To Login")
	public WebElement backToLoginBtn;
	
	@FindBy(xpath = "//span[text()='Email is required.']")
	public WebElement emailRequiredText;
	
	@FindBy(xpath = "//span[text()='First Name is required.']")
	public WebElement firstNameRequiredText;
	
	@FindBy(xpath = "//span[text()='Last Name is required.']")
	public WebElement lastNameRequiredText;
	
	@FindBy(xpath = "//span[text()='Password is required.']")
	public WebElement passwordRequiredText;

	
	
	
	

}
