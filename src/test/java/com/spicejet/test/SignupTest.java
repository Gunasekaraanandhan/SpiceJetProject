package com.spicejet.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.spicejet.utils.Reports;
import com.spicejet.utils.Wrapper;
import com.spicejet.pages.SignupPage;

@Listeners(Reports.class)
public class SignupTest extends Wrapper {

	Reports report = new Reports();

	@Test(priority = 0)
	public void signUp() {

		try {
			report.setTCDesc("Validate signup functionality");

	//		launchBrowser("https://www.spicejet.com");
	//		driver.get("https://www.spicejet.com");
			
			brokenLink("https://www.spicejet.com");
			SignupPage sp = PageFactory.initElements(driver, SignupPage.class);
			sp.clickSignupButton();
			windowHandling();
			
			sp.selectOption("Mr");
			sp.setFirstName("Gunasekar");
			sp.setLastName("Aanandhan");
			sp.selectCountry("India");
			sp.clickDOB();
			sp.selectYear("1998");
			sp.selectMonth("June");
			sp.clickDate("3");
			sp.enterPhoneNumber("9585148924");
			sp.enterEmail("gunasekaranandhan24@gmail.com");
			sp.setPassword("9585148924@Gu");
			sp.confirmPassword("9585148924@Gu");
			sp.clickCheckBox();
			Thread.sleep(3000);
			sp.clickSubmitButton();

			System.out.println("Signup functionality has been done successfully");
            
			closeBrowser();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
