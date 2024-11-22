package com.automationexercise.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automationexercise.base.BasePage;

public class ContactsUsPage extends BasePage{

	public ContactsUsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	

	@FindBy(xpath= "//div[@class='status alert alert-success']")
	private WebElement successText;
	
	@FindBy(xpath= "//span[normalize-space()='Home']")
	private WebElement homeBtn;
	
	public String getSuccessText(){
		action.explicitWait(driver, successText, 5);
		if(action.isDisplayed(driver, successText)) {
		String text = action.getText(driver, successText);
		System.out.println("text is "+ text);
		return text;
		}else {
			System.out.println("Success! Your details have been submitted successfully text is not available");
			return null;
		}
	}
	
	public HomePage clickHomeBtn() {
			action.click(driver, homeBtn);
        return new HomePage(driver);        // TODO Auto-generated method stub
	}

}
