package com.automationexercise.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automationexercise.base.BasePage;

public class HomePage extends BasePage {
	

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath= "//a[normalize-space()='Home']")
	private WebElement homepagebtn;
	
	@FindBy(xpath= "//a[normalize-space()='Signup / Login']")
	private WebElement signup_Loginbtn;
	
	@FindBy(css= "li:nth-child(10) a:nth-child(1)")
	private WebElement Loggedusername;
	
	@FindBy(css= "a[href='/delete_account']")
	private WebElement deleteBtn;
	
	@FindBy(css= "a[href='/products']")
	private WebElement productsBtn;
	

	@FindBy(xpath= "//a[normalize-space()='Cart']")
	private WebElement cartsBtn;
	
	@FindBy(css= "a[href='/contact_us']")
	private WebElement ContactUsBtn;
	
	
	
	public String verifyHomePageBtn() {
       if(action.isDisplayed(driver, homepagebtn)) {
    	 String homepagetext =   action.getText(driver, homepagebtn);
    	 System.out.println("Home Page Button Text: " + homepagetext);
    	 return homepagetext;
       }
       else {
    	   System.out.println("Home Page Button is not displayed");
           return null;
       }
    }
	
	
	public LoginAndSignUpPage clickSignUp_Loginbtn() {
		action.click(driver, signup_Loginbtn);
		return new LoginAndSignUpPage(driver);
	}
	
	public String verifyUsername() {
		if(action.isDisplayed(driver, Loggedusername)) {
			String username = action.getText(driver, Loggedusername);
            System.out.println("Logged in user's name is displayed");
            return username;
        } else {
        	
            System.out.println("Logged in user's name is not displayed");
            return null;
        }
	}
	
	public DeleteAccountPage clickDeleteBtn() {
			action.click(driver, deleteBtn);
			
			return new DeleteAccountPage(driver);
}
	
	public ProductPage clickProductBtn() {
		action.click(driver, productsBtn);
		return new ProductPage(driver);
	}
	
	public CartPage clickCartsBtn() {
        action.click(driver, cartsBtn);
        return new CartPage(driver);
    }
	
	public ContactUsPage clickContactUsBtn() {
        action.click(driver, ContactUsBtn);
        return new ContactUsPage(driver);
    }
}
