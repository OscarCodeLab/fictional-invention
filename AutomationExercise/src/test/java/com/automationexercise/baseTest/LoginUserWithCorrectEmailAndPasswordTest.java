package com.automationexercise.baseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.utilities.DataProviders;
import com.automationexercise.base.Base;
import com.automationexercise.page.DeleteAccountPage;
import com.automationexercise.page.HomePage;
import com.automationexercise.page.LoginAndSignUpPage;

public class LoginUserWithCorrectEmailAndPasswordTest extends Base {
	
	public HomePage home;
	public LoginAndSignUpPage loginAndSignUp;
	public DeleteAccountPage delete;
	
	@Test(priority = 1)
	public void homepageTest() {
		home = new HomePage(driver);
		loginAndSignUp = new LoginAndSignUpPage(driver);
       String actualText =  home.verifyHomePageBtn();
       String expectedText = "Home";
       Assert.assertEquals(actualText, expectedText);
       loginAndSignUp=home.clickSignUp_Loginbtn();     
	}
	
	@Test(priority = 2, dataProviderClass = DataProviders.class, dataProvider = "dp")
	public void loginDataTest(String email, String password) {
		loginAndSignUp = new LoginAndSignUpPage(driver);
		String actualText = loginAndSignUp.verifyLoginText();
		String expectedText = "Login to your account";
		Assert.assertEquals(actualText, expectedText);
		
		home=loginAndSignUp.login(email, password);
			
	}
	
	@Test(priority = 3)
	public void confirmUsernameTest() {
		home = new HomePage(driver);
        delete = new DeleteAccountPage(driver);
       String actualText =  home.verifyUsername();
       String expectedText = "Logged in as fuifk";
    Assert.assertEquals(actualText, expectedText);
    delete=home.clickDeleteBtn();
      
	}
	
	@Test(priority = 4)
	 public void deleteAccountTest() {
		 delete = new DeleteAccountPage(driver);
		 String actualText = delete.verifyDeleteText();
		 String expectedText = "ACCOUNT DELETED!";
		 Assert.assertEquals(actualText, expectedText);
		// delete.clickContinue();
		 
	    }


}
