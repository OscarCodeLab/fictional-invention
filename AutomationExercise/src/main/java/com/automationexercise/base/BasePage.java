package com.automationexercise.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.automationexercise.actiondriver.Action;

public class BasePage {

	public WebDriver driver;
	public Action action;
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.action = new Action(driver);
		PageFactory.initElements(driver, this);
	}
	
}
