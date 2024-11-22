package com.automationexercise.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automationexercise.base.BasePage;

public class LoginAndSignUpPage extends BasePage{

	public LoginAndSignUpPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css = "div[class='signup-form'] h2")
	private WebElement signUpText;
	
	@FindBy(css = "div[class='login-form'] h2")
	private WebElement loginText;
	
	@FindBy(css = "input[placeholder='Name']")
	private WebElement nameField;
	
	@FindBy(css = "input[data-qa='signup-email']")
	private WebElement emailField;
	
	@FindBy(css = "button[data-qa='signup-button']")
	private WebElement signUpbtn;
	
	@FindBy(css = "input[data-qa='login-email']")
	private WebElement loginEmailField;
	
	@FindBy(css = "input[placeholder='Password']")
	private WebElement loginPasswordField;
	
	@FindBy(css = "button[data-qa='login-button']")
	private WebElement loginBtn;
	
	// i added s to the email to test if the screenshot will appear in the extent Report. i fail the test deliberately
	@FindBy(xpath = "//p[normalize-space()='Your emails or password is incorrect!']")
	private WebElement incorrectPasswordorEmailText;
	
	
	public String verifyText() {
	    if (action.isDisplayed(driver, signUpText)) {
	        String signupText = action.getText(driver, signUpText);
	        System.out.println("Sign Up: " + signupText);

	        // Check if the signup text contains "New User Signup!" and print a message
	        if (signupText.contains("New User Signup!")) {
	            System.out.println("Test passed: 'New User Signup!' text is present.");
	        } else {
	            System.out.println("Test failed: Expected 'New User Signup!' text is missing.");
	        }

	        return signupText;
	    } else {
	        System.out.println("Sign-up message is not available on the page.");
	        return null;
	    }
	}
	
	public String verifyLoginText() {
	    if (action.isDisplayed(driver, loginText)) {
	        String signupText = action.getText(driver, loginText);
	        System.out.println("Test passed: 'Login to your account' text is present.");
	        return signupText;}
	    else {
	    	System.out.println("Login text is not available on the page.");
	    	return null;
	    }
	       
	}
	
	public String verifyIncorrectPasswordOrEmail() {
		action.explicitWait(driver, incorrectPasswordorEmailText, 5);
	    if (action.isDisplayed(driver, incorrectPasswordorEmailText)) {
	        String wrongdataText = action.getText(driver, incorrectPasswordorEmailText);
	        System.out.println("Test passed: 'Your email or password is incorrect!' text is present.");
	        return wrongdataText;}
	    else {
	    	System.out.println("Your email or password is incorrect! text is not available on the page.");
	    	return null;
	    }
	       
	}


	
	
	public SignUpPage signUp(String name, String email) {
		action.type(nameField, name);
		action.type(emailField, email);
		
		action.click(driver, signUpbtn);
		
		return new SignUpPage(driver);
	}
	
	public HomePage login(String email, String password) {
		action.type(loginEmailField, email);
        action.type(loginPasswordField, password);
        
        action.click(driver, loginBtn);
        
        return new HomePage(driver);
	}

}
