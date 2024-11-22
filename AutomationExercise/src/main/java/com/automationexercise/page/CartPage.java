package com.automationexercise.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automationexercise.base.BasePage;

public class CartPage extends BasePage {
	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = ".btn.btn-default.check_out")
	private WebElement proceedToCheckOutBtn;
	
	@FindBy(xpath = "//li[@class='active']")
	private WebElement shoppinCartText;
	
	@FindBy(xpath = "//u[contains(text(),'Register / Login')]") //u[normalize-space()='Register / Login']
	private WebElement register_LoginBtn;
	
	public LoginAndSignUpPage clickOnProceedToCheckOut() {
		
		action.click(driver, proceedToCheckOutBtn);		
		
		action.explicitWait(driver, register_LoginBtn, 5);
		action.click(driver, register_LoginBtn);
		
		return new LoginAndSignUpPage(driver);
        
    }

	public String getShoppingCartText() {
        if(action.isDisplayed(driver, shoppinCartText)) {
        	String text = action.getText(driver, shoppinCartText);
        	System.out.println("Shopping Cart Text: " + text);
        	return text;
        }else {
        		System.out.println("Shopping Cart Text is not displayed");
            return null;
        }
    }
	
	public CheckOutPage clickproceedToCheckOutBtn() {
		action.click(driver, proceedToCheckOutBtn);
		return new CheckOutPage(driver);
	}
}
