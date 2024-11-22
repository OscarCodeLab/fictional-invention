package com.automationexercise.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automationexercise.base.BasePage;

public class PaymentPage extends BasePage {

	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css = "input[name='name_on_card']")
	private WebElement cardNameField;
	
	@FindBy(css = "input[name='card_number']")
	private WebElement cardNumberField;
	
	@FindBy(css = "input[placeholder='ex. 311']")
	private WebElement cardcvcField;
	
	@FindBy(css = "input[placeholder='MM']")
	private WebElement cardExpirationMonthField;
	
	@FindBy(css = "input[placeholder='YYYY']")
	private WebElement cardExpirationYearField;
	

	@FindBy(css = "#submit")
	private WebElement payAndConfirmOrderBtn;
	
	public PaymentDonePage payAndConfirmOrder(String cardName, String cardNumber, String cardCVC, String cardMM, String cardYY ) {
		action.type(cardNameField, cardName);
		action.type(cardNumberField, cardNumber);
		action.type(cardcvcField, cardCVC);
		action.type(cardExpirationMonthField, cardMM);
		action.type(cardExpirationYearField, cardYY);
		
		action.click(driver, payAndConfirmOrderBtn);
		
		return new PaymentDonePage(driver);
		
	}

}
