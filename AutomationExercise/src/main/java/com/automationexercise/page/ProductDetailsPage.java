package com.automationexercise.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automationexercise.base.BasePage;

public class ProductDetailsPage extends BasePage{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	@FindBy(css = "button[type='button']")
	private WebElement addToCartBtn;

	@FindBy(css = "#quantity")
	private WebElement quantityField;
	
	@FindBy(css = "#name")
	private WebElement nameField;
	
	@FindBy(css = "#email")
	private WebElement emailField;
	
	@FindBy(css = "#review")
	private WebElement reviewField;
	
	@FindBy(css = "#button-review")
	private WebElement submitBtn;
	
	@FindBy(css = ".fa.fa-angle-up")
	private WebElement scrollUpBtn;
	
	@FindBy(css = "div[class='product-information'] h2")
	private WebElement shirtName;
	
	@FindBy(css = "div[class='alert-success alert'] span")
	private WebElement alertSuccessmsg;
	
	@FindBy(css = "a[href='#reviews']")
	private WebElement reviewText;
	
	@FindBy(xpath = "//u[normalize-space()='View Cart']") 
	private WebElement cartBtn;
	
	public String verifyShirtName() {
	    if (action.isDisplayed(driver, shirtName)) {
	        // Get the text of the shirt name and normalize spaces
	        String text = action.getText(driver, shirtName).trim().replaceAll("\\s+", " ");
	        System.out.println("Shirt Name: " + text);

	        // Check if the normalized text contains "Premium Polo T-Shirts"
	        if (text.contains("Premium Polo T-Shirts")) {
	            System.out.println("Test passed: 'Premium Polo T-Shirts' text is present.");
	        } else {
	            System.out.println("Test failed: Expected 'Premium Polo T-Shirts' text is missing.");
	        }

	        return text;
	    } else {
	        System.out.println("Premium Polo T-Shirts message is not available on the page.");
	        return null;
	    }
	}

	
	public void WriteAReview(String name, String email, String reviewFields) {
		action.moveToElement(driver, nameField);
		action.type(nameField, name);
		action.type(emailField, email);
		action.type(reviewField, reviewFields);
		action.click(driver, submitBtn);
	}
	
	public String verifysucessText() {
		if(action.isDisplayed(driver, alertSuccessmsg)) {
            String text = action.getText(driver, alertSuccessmsg);
            System.out.println("Success Message: " + text);
            return text;
        } else {
                System.out.println("Success Message is not displayed");
            return null;
        }
	
	}
	
	
	public CartPage addToCart(String quantity) {
		action.click(driver, scrollUpBtn);
		action.explicitWait(driver, quantityField, 5);
		action.type(quantityField, quantity);
        action.click(driver, addToCartBtn);
        action.explicitWait(driver, cartBtn, 5);
        action.click(driver, cartBtn);
        
        return new CartPage(driver);
    }	
	
	
}
