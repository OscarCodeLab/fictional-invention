package com.automationexercise.baseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.utilities.DataProviders;
import com.automationexercise.base.Base;
import com.automationexercise.page.HomePage;
import com.automationexercise.page.LoginAndSignUpPage;

public class LoginUserWithInCorrectEmailAndPasswordTest extends Base {
	public HomePage home;
	public LoginAndSignUpPage loginAndSignup;
	
	// Test case for login with incorrect email and password

	@Test(priority = 1)
	public void homepageTest() {
		home = new HomePage(driver);
		loginAndSignup = new LoginAndSignUpPage(driver);
       String actualText =  home.verifyHomePageBtn();
       String expectedText = "Home";
       Assert.assertEquals(actualText, expectedText);
       loginAndSignup=home.clickSignUp_Loginbtn();     
	}
	
	@Test(priority = 2, dataProviderClass = DataProviders.class, dataProvider = "dp")
	public void wrongDataTest(String email, String password) {
		loginAndSignup = new LoginAndSignUpPage(driver);
		String actualText = loginAndSignup.verifyLoginText();
		String expectedText = "Login to your account";
		Assert.assertEquals(actualText, expectedText);
		
		loginAndSignup.login(email, password);
			
	}
	
	@Test(priority = 3)
	public void verifyText()  {
		loginAndSignup = new LoginAndSignUpPage(driver);
		String actualText = loginAndSignup.verifyIncorrectPasswordOrEmail();
		String expectedText = "Your email or password is incorrect!";
		Assert.assertEquals(actualText, expectedText);
	}
}
