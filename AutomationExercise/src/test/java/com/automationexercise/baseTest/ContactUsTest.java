package com.automationexercise.baseTest;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.utilities.DataProviders;
import com.automationexercise.base.Base;
import com.automationexercise.page.ContactUsPage;
import com.automationexercise.page.ContactsUsPage;
import com.automationexercise.page.HomePage;

public class ContactUsTest extends Base {
	public HomePage home;
	public ContactUsPage contact;
	public ContactsUsPage contacts;

	@Test(priority = 1)

	public void homepageTest() {
		home = new HomePage(driver);
		String actualText = home.verifyHomePageBtn();
		String expectedText = "Home";
		Assert.assertEquals(expectedText, actualText);
		contact = home.clickContactUsBtn();
	}

	@Test(priority = 2)
	public void verifyText() {
		contact = new ContactUsPage(driver);
		String actualText = contact.gettouchText();
		String expectedText = "GET IN TOUCH";
		Assert.assertEquals(expectedText, actualText);
	}

	@Test(priority = 3, dataProviderClass = DataProviders.class, dataProvider = "dp")
	public void contactUsTest(String name, String email, String subject, String messageBody) {
		contact = new ContactUsPage(driver);
		contact.gotoContactsUsPage(name, email, subject, messageBody);
	}

	@Test(priority = 4)
	public void goToContacts() throws InterruptedException {
		String path = "C:\\Users\\hp\\Downloads\\wizkid.png";
		contacts = new ContactsUsPage(driver);
		contacts = contact.gotoContactsUsPage(path);
		Thread.sleep(Duration.ofSeconds(5));

	}

	@Test(priority = 5)
	public void ContactPage() {
		contacts = new ContactsUsPage(driver);
		String actualText = contacts.getSuccessText();
		String expectedText = "Success! Your details have been submitted successfully.";
		Assert.assertEquals(expectedText, actualText);

		home = contacts.clickHomeBtn();

	}

}
