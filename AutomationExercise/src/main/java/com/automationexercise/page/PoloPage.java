package com.automationexercise.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automationexercise.base.BasePage;

public class PoloPage extends BasePage {

	public PoloPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "a[href='/product_details/30']")
	private WebElement viewProductDetails;
	
	@FindBy(css = ".active")
	private WebElement polotext;
	
	public ProductDetailsPage clickOnViewProductDetails() {
        action.scrollByVisibilityOfElement(driver, viewProductDetails);
        action.click(driver, viewProductDetails);
        
        return new ProductDetailsPage(driver);
    }
	
	public String validatePoloText() {
        if (action.isDisplayed(driver, polotext)) {
        	String text = action.getText(driver, polotext);
        	System.out.println("the polo text is available");
        	return text;
        }else {
        	System.out.println("the polo text is not available");
        	return null;
        }
		
    }
	
}
