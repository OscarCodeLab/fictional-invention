package com.automationexercise.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automationexercise.base.BasePage;

public class SignUpPage extends BasePage {

	public SignUpPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//b[normalize-space()='Enter Account Information']")
	private WebElement login_form;
	
	@FindBy(id = "id_gender1")
	private WebElement mr;
	
	@FindBy(id = "password")
	private WebElement passwordField;
	
	@FindBy(css = "#days")
	private WebElement selectDay;
	
	@FindBy(css = "#months")
	private WebElement selectMonth;
	
	@FindBy(css = "#years")
	private WebElement selectYear;
	
	@FindBy(id = "newsletter")
	private WebElement checkBoxNewsletter;
	
	@FindBy(id = "optin")
	private WebElement checkBoxSpecialOffer;
	
	@FindBy(id = "first_name")
	private WebElement firstNameField;
	
	@FindBy(id = "last_name")
	private WebElement lastNameField;
	
	@FindBy(id = "company")
	private WebElement companyField;
	
	@FindBy(id = "address1")
	private WebElement address1Field;
	
	@FindBy(id = "address2")
	private WebElement address2Field;
	
	@FindBy(id = "country")
	private WebElement selectCountry;
	
	@FindBy(id = "state")
	private WebElement stateField;
	
	@FindBy(id = "city")
	private WebElement cityField;
	
	@FindBy(id = "zipcode")
	private WebElement zipCodeField;
	
	@FindBy(id = "mobile_number")
    private WebElement mobileNumberField;


	@FindBy(css = "button[data-qa='create-account']")
	private WebElement createAccountBtn;
	
	public String verifyText(){
		if(action.isDisplayed(driver, login_form)) {
			String text = action.getText(driver, login_form);
            System.out.println("Enter Account Information: " + text); 
            return text;
		}
		else{
			System.out.println("login_form text is not visible");
			return null;
		}
	}

	public void signUpData(String password, String day, String month, String year, String firstName, String lastName, String company, String adress1, String adress2, String country, String state, String city, String zipCode, String mobileNumber) {
		action.click(driver, mr);
		action.moveToElement(driver, passwordField);
		action.type(passwordField, password);
		action.explicitWait(driver, selectDay, 5);
		action.selectByVisibleText(day, selectDay);
		action.selectByVisibleText(month, selectMonth);
		action.selectByVisibleText(year, selectYear);
		
		action.click(driver, checkBoxNewsletter);
		action.click(driver, checkBoxSpecialOffer);
		
		action.moveToElement(driver, firstNameField);
		action.type(firstNameField, firstName);
		action.type(lastNameField, lastName);
		action.type(companyField, company);
		
		action.moveToElement(driver, address1Field);
		action.type(address1Field, adress1);
		action.type(address2Field, adress2);
		
		action.moveToElement(driver, selectCountry);
		action.selectByValue(selectCountry, country);
		action.type(stateField, state);
		action.type(cityField, city);
		action.type(zipCodeField, zipCode);
		action.type(mobileNumberField, mobileNumber);
	
	}
	
	public AccountCreatedPage clickCreateAccountBtn(){
        action.click(driver, createAccountBtn);
        System.out.println("Account created successfully");
        
        return new AccountCreatedPage(driver);
        
    }
}
