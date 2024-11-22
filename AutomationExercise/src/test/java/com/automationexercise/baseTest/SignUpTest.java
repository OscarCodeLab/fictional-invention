package com.automationexercise.baseTest;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.utilities.DataProviders;
import com.automationexercise.base.Base;
import com.automationexercise.page.AccountCreatedPage;
import com.automationexercise.page.DeleteAccountPage;
import com.automationexercise.page.HomePage;
import com.automationexercise.page.LoginAndSignUpPage;
import com.automationexercise.page.SignUpPage;

public class SignUpTest extends Base {
	public HomePage home;
	public DeleteAccountPage delete;
	public SignUpPage signUp;
	public LoginAndSignUpPage loginAndSignUp;
	public AccountCreatedPage createdAccount;
	// Test case for sign-up functionality goes here
	@Test(priority = 1)
	public void homepageTest() {
		home = new HomePage(driver);
       String actualText =  home.verifyHomePageBtn();
       String expectedText = "Home";
       Assert.assertEquals(actualText, expectedText);
       loginAndSignUp=home.clickSignUp_Loginbtn();     
	}
	@Test(priority = 2)
	public void LoginAndSignUpPageTest() {
		loginAndSignUp = new LoginAndSignUpPage(driver);
		signUp = new SignUpPage(driver);
		String actualText = loginAndSignUp.verifyText();
		String expectedText = "New User Signup!";
		Assert.assertTrue(actualText.contains(expectedText), "Test failed: Expected text '" + expectedText + "' was not found in the actual text: " + actualText);
		
		signUp=loginAndSignUp.signUp(prop.getProperty("name"), prop.getProperty("email"));		
	}
	
	@Test(priority = 3, dataProviderClass =DataProviders.class, dataProvider = "newAcountDetailsData")
    public void signUpDataTest(HashMap<String, String> hashMapValue) throws Throwable {
		signUp = new SignUpPage(driver);
		createdAccount = new AccountCreatedPage(driver);
		String actualText = signUp.verifyText();
		String expectedText = "ENTER ACCOUNT INFORMATION";
		Assert.assertEquals(actualText, expectedText);
		
		signUp.signUpData(
				hashMapValue.get("Password"),
				hashMapValue.get("Day"),
				hashMapValue.get("Month"),
				hashMapValue.get("Year"),
                hashMapValue.get("FirstName"), 
                hashMapValue.get("LastName"), 
                hashMapValue.get("Company"),
                hashMapValue.get("Address1"), 
                hashMapValue.get("Address2"),
                hashMapValue.get("Country"),
                hashMapValue.get("State"), 
                hashMapValue.get("City"), 
                hashMapValue.get("ZipCode"),
                hashMapValue.get("Mobile"));
    
		createdAccount = signUp.clickCreateAccountBtn();
		
	}
	
	@Test(priority = 4)
	public void AccountCreatedPageTest() {
		home = new HomePage(driver);
		createdAccount = new AccountCreatedPage(driver);
		String actualText = createdAccount.verifyText();
		String expectedText = "ACCOUNT CREATED!";
		Assert.assertEquals(actualText, expectedText);
		home = createdAccount.clickContinue();
	}
	@Test(priority = 5)
	public void confirmUsernameTest() {
		home = new HomePage(driver);
        delete = new DeleteAccountPage(driver);
       String actualText =  home.verifyUsername();
       String expectedText = "Logged in as freeman";
    Assert.assertEquals(actualText, expectedText);
    delete=home.clickDeleteBtn();
      
	}
	
	@Test(priority = 6)
	 public void deleteAccountTest() {
		 delete = new DeleteAccountPage(driver);
		 String actualText = delete.verifyDeleteText();
		 String expectedText = "ACCOUNT DELETED!";
		 Assert.assertEquals(actualText, expectedText);
		 delete.clickContinue();
		 
	    }

}
