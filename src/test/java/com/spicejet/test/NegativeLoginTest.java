package com.spicejet.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.spicejet.pages.LoginPage;
import com.spicejet.utils.Reports;
import com.spicejet.utils.Wrapper;
@Listeners(Reports.class)
public class NegativeLoginTest extends Wrapper{
	
	Reports report = new Reports();
	@Test(priority = 2)
	public void login() {
		
		try {
			report.setTCDesc("Validate Negative Login functionality");
		//	launchBrowser("https://www.spicejet.com");
		//	driver.get("https://www.spicejet.com");
			
			LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
			
			lp.clickLogin();
			lp.clickEmailField();
			lp.enterEmail("guna@gmail.com");
			lp.enterPassword("9585148924@Gu");
			lp.clickLogin1();
			lp.validateInvalidUsername("Invalid Username/Password");
			
			System.out.println("Negative Login functionality has been verified successfully");
			
			closeBrowser();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
