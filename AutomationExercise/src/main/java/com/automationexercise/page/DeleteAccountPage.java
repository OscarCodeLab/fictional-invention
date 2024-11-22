package com.automationexercise.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automationexercise.base.BasePage;

public class DeleteAccountPage extends BasePage {

	public DeleteAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath= "//b[normalize-space()='Account Deleted!']")
	private WebElement deleteText;
	
	@FindBy(xpath= "//a[normalize-space()='Continue']")
	private WebElement continueBtn;
	
	public String verifyDeleteText() {
      if (action.isDisplayed(driver, deleteText)) {
    	  String deletetext = action.getText(driver, deleteText);
          System.out.println("Account deleted text is displayed");
          return deletetext;
      }else {
    	  	System.out.println("Account deleted text is not displayed");
          return null;
      }
    }
	
	public void clickContinue() {
        action.click(driver, continueBtn);
       
    }

}
