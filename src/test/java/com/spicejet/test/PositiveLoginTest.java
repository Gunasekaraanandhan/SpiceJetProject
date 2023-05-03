package com.spicejet.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.spicejet.pages.LoginPage;
import com.spicejet.utils.Reports;
import com.spicejet.utils.Wrapper;

@Listeners(Reports.class)
public class PositiveLoginTest extends Wrapper{

	Reports report = new Reports();
	@Test(priority = 1)
	public void login() {
		
		try {
			report.setTCDesc("Validate Positive Login functionality");
	//		launchBrowser("https://www.spicejet.com");
	//		driver.get("https://www.spicejet.com");
			
			LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
			
			lp.clickLogin();
			lp.clickEmailField();
			lp.enterEmail("gunasekarstar4@gmail.com");
			lp.enterPassword("9585148924@Gu");
			lp.clickLogin1();
			validateTitle("SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets");
			System.out.println("Positive Login functionality has been verified successfully");
			closeBrowser();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
