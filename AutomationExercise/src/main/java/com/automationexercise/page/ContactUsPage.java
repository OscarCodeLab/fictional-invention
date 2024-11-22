package com.automationexercise.page;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automationexercise.base.BasePage;

public class ContactUsPage extends BasePage{

	public ContactUsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath= "//h2[normalize-space()='Get In Touch']")
	private WebElement touchText;
	

	@FindBy(xpath= "//input[@placeholder='Name']")
	private WebElement nameField;
	
	@FindBy(xpath= "//input[@placeholder='Email']")
	private WebElement emailField;
	
	@FindBy(xpath= "//input[@placeholder='Subject']")
	private WebElement subjectField;
	
	@FindBy(xpath= "//textarea[@id='message']")
	private WebElement msgBodyeField;
	
	@FindBy(css= "div.form-group input[type='file']") 
	private WebElement uploadFileBtn;
	
	@FindBy(xpath= "//input[@name='submit']")
	private WebElement submitBtn;
	
	public String gettouchText(){
		if(action.isDisplayed(driver, touchText)) {
		String text = action.getText(driver, touchText);
		System.out.println("text is "+ text);
		return text;
		}else {
			System.out.println("GET IN TOUCH text is not available");
			return null;
		}
	}
	
	public void gotoContactsUsPage(String name, String email, String subject, String messageBody) {
		action.type(nameField, name);
		action.type(emailField, email);
		action.type(subjectField, subject);
		//action.scrollByVisibilityOfElement(driver, msgBodyeField);
		action.type(msgBodyeField, messageBody);
		
	}
	
	public ContactsUsPage gotoContactsUsPage(String path) {
		
		action.scrollByVisibilityOfElement(driver, uploadFileBtn);
		action.explicitWait(driver, uploadFileBtn, 5);
		action.type(uploadFileBtn, path);
		action.explicitWait(driver, submitBtn, 5);
		//.moveToElement(driver, submitBtn);
		action.click(driver, submitBtn);
		//action.isAlertPresent(driver);
		action.Alert(driver);
		return new ContactsUsPage(driver);
	};
}
