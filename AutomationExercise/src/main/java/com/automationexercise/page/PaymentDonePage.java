package com.automationexercise.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automationexercise.base.BasePage;

public class PaymentDonePage extends BasePage{

	public PaymentDonePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css = "h2[class='title text-center'] b")
	private WebElement orderPlaceText;
	
	@FindBy(xpath = "//a[normalize-space()='Continue']")
	private WebElement continueBtn;

	
	public String getOrderPlaceText() {
        if(action.isDisplayed(driver, orderPlaceText)) {
        	String text = action.getText(driver, orderPlaceText);
        	System.out.println("OrderPlaceText" + text);
        	return text;
        }else {
        		System.out.println("OrderPlaceText is not displayed");
            return null;
        }
    }
	
	public HomePage clickContinueBtn() {
        action.click(driver, continueBtn);
        System.out.println("Clicked on Continue button");
        return new HomePage(driver);
    }
    }
