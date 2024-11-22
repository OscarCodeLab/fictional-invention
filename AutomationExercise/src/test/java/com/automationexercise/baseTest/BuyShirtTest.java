package com.automationexercise.baseTest;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.utilities.DataProviders;
import com.automationexercise.base.Base;
import com.automationexercise.page.AccountCreatedPage;
import com.automationexercise.page.CartPage;
import com.automationexercise.page.CheckOutPage;
import com.automationexercise.page.DeleteAccountPage;
import com.automationexercise.page.HomePage;
import com.automationexercise.page.LoginAndSignUpPage;
import com.automationexercise.page.PaymentDonePage;
import com.automationexercise.page.PaymentPage;
import com.automationexercise.page.PoloPage;
import com.automationexercise.page.ProductDetailsPage;
import com.automationexercise.page.ProductPage;
import com.automationexercise.page.SignUpPage;

public class BuyShirtTest extends Base {
	public HomePage home;
	public ProductPage product;
	public PoloPage polo;
	public ProductDetailsPage productDetails;
	public CartPage cart;
	public LoginAndSignUpPage loginAndSignUp;
	public SignUpPage signUp;
	public AccountCreatedPage createdAccount;
	public DeleteAccountPage delete;
	public CheckOutPage checkOut;
	public PaymentPage payment;
	public PaymentDonePage done;
	@Test(priority = 1)
	public void homepageTest() {
		home = new HomePage(driver);
		product = new ProductPage(driver);
		String actualText = home.verifyHomePageBtn();
		String expectedText = "Home";
		Assert.assertEquals(actualText, expectedText);
		product = home.clickProductBtn();
	}

	@Test(priority = 2)
	public void productPageTest() {
		polo = new PoloPage(driver);
		product = home.clickProductBtn();
		product.isSaleImageVisible();
		polo = product.clickPoloBtn();
	}

	@Test(priority = 3)
	public void PoloPageTest() {
		productDetails = new ProductDetailsPage(driver);	
		String actualText = polo.validatePoloText();
		String expectedText = "Polo";
		Assert.assertEquals(actualText, expectedText);
		productDetails =polo.clickOnViewProductDetails();
		
	}
	
	@Test(priority = 4,  dataProviderClass = DataProviders.class, dataProvider = "dp")
    public void reviewFieldTest(String name, String email, String reviewFields) {
        productDetails.WriteAReview(name, email, reviewFields);
        String actualText = productDetails.verifysucessText();
        String expectedText = "Thank you for your review.";
        Assert.assertEquals(actualText, expectedText);
    
    }
	@Test(priority = 5)
	public void addToCartTest() {
		String actualText = productDetails.verifyShirtName();
		String expectedText = "Premium Polo T-Shirts";
		Assert.assertTrue(actualText.contains(expectedText), "Test failed: Expected text '" + expectedText + "' was not found in the actual text: " + actualText);
		cart = productDetails.addToCart(prop.getProperty("quantity"));
		
		 // Log the actual and expected text for debugging
        System.out.println("Actual Text: [" + actualText + "]");
        System.out.println("Expected Text: [" + expectedText + "]");
        
		
	}
	
	@Test(priority = 6)
	public void cartPageTest() {
		String actualtext = cart.getShoppingCartText();
		String expectedText = "Shopping Cart";
		Assert.assertEquals(actualtext, expectedText);
		
		loginAndSignUp = cart.clickOnProceedToCheckOut();
	}
	
	@Test(priority = 7)
	public void LoginAndSignUpPageTest() {
		loginAndSignUp = new LoginAndSignUpPage(driver);
		signUp = new SignUpPage(driver);
		String actualText = loginAndSignUp.verifyText();
		String expectedText = "New User Signup!";
		Assert.assertTrue(actualText.contains(expectedText), "Test failed: Expected text '" + expectedText + "' was not found in the actual text: " + actualText);
		
		signUp=loginAndSignUp.signUp(prop.getProperty("name"), prop.getProperty("email"));		
	}
	
	@Test(priority = 8, dataProviderClass =DataProviders.class, dataProvider = "newAcountDetailsData")
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
	
	@Test(priority = 9)
	public void verifyAccountCreationAndLoginTest() {
	    home = new HomePage(driver);
	    createdAccount = new AccountCreatedPage(driver);

	    // Verify account creation
	    String actualText = createdAccount.verifyText();
	    String expectedText = "ACCOUNT CREATED!";
	    Assert.assertEquals(actualText, expectedText, "Account creation verification failed.");

	    // Click continue and verify the username is displayed
	    home = createdAccount.clickContinue();
	    String actualUsername = home.verifyUsername();
	    String expectedUsername = "Logged in as freeman";
	    Assert.assertEquals(actualUsername, expectedUsername, "User login verification failed.");
	}

	@Test(priority = 10)
	public void verifyCartAndProceedToCheckoutTest() {
	    cart = home.clickCartsBtn();

	    // Verify shopping cart page text
	    String actualCartText = cart.getShoppingCartText();
	    String expectedCartText = "Shopping Cart";
	    Assert.assertEquals(actualCartText, expectedCartText, "Shopping Cart verification failed.");

	    // Proceed to checkout and verify address details
	    checkOut = cart.clickproceedToCheckOutBtn();
	    Assert.assertTrue(checkOut.isAddressDetailsTextDisplayed(), "Address details verification failed.");

	    // Proceed to the payment page
	    payment = checkOut.clickorderBtn();
	}

	
	@Test(priority = 11, dataProviderClass = DataProviders.class, dataProvider = "dp")
	public void cardTest(String name, String cardNumber, String cardCvc, String cardD, String cardY) {
		done = 	payment.payAndConfirmOrder(name, cardNumber, cardCvc, cardD, cardY);
		String actual = done.getOrderPlaceText();
		String expected = "ORDER PLACED!";
		Assert.assertEquals(actual, expected);
		home = done.clickContinueBtn();
	
	}
	
	@Test(priority = 12)
	 public void deleteAccountTest() {
		 delete = new DeleteAccountPage(driver);
		 delete=home.clickDeleteBtn();
		 String actualText = delete.verifyDeleteText();
		 String expectedText = "ACCOUNT DELETED!";
		 Assert.assertEquals(actualText, expectedText);
		 delete.clickContinue();
		 
	    
	}	
	
}