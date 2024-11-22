package com.automationexercise.page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automationexercise.base.BasePage;

public class ProductPage extends BasePage {public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css="#sale_image")
    private WebElement saleImage;
	
	@FindBy(css="a[href='/brand_products/Polo']")
    private WebElement poloBtn;

	public PoloPage clickPoloBtn() {
		action.scrollByVisibilityOfElement(driver, poloBtn);
        action.click(driver, poloBtn);
		       
        return new PoloPage(driver);
    }
	
	public boolean isSaleImageVisible() {
		
       try{
    	   return action.isDisplayed(driver, saleImage);
       } catch (NoSuchElementException e) {
    	   return false;
       }
    }
}
