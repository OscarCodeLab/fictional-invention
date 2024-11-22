package com.automationexercise.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automationexercise.base.BasePage;

public class CheckOutPage extends BasePage {

	public CheckOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//h2[normalize-space()='Address Details']")
	private WebElement addressDetailsText;
	
	@FindBy(xpath = "//a[normalize-space()='Place Order']")
    private WebElement orderBtn;
	
	
	public boolean isAddressDetailsTextDisplayed() {
        return action.isDisplayed(driver, addressDetailsText);
        
    }
	
	public PaymentPage clickorderBtn() {
		action.moveToElement(driver, orderBtn);
		action.click(driver, orderBtn);
		return new PaymentPage(driver);
	}

}
