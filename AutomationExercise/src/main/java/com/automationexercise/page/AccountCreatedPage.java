package com.automationexercise.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automationexercise.base.BasePage;

public class AccountCreatedPage extends BasePage {

	public AccountCreatedPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//b[normalize-space()='Account Created!']" )
	private WebElement accountCreatedText;
	
	@FindBy(xpath = "//a[normalize-space()='Continue']" )
	private WebElement continueBtn;
	
	
	public String verifyText() {
		if(action.isDisplayed(driver, accountCreatedText)) {
			String text = action.getText(driver, accountCreatedText);
			System.out.println("Account created text is displayed");
			return text;
		}else {
			System.out.println("Account created text is not displayed");
			return null;
		}
	}
	
	
	public HomePage clickContinue() {
        action.click(driver, continueBtn);
        return new HomePage(driver);
    }
	
}
