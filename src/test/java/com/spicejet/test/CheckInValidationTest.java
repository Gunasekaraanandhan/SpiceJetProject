package com.spicejet.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.spicejet.pages.CheckInValidationPage;
import com.spicejet.utils.Reports;
import com.spicejet.utils.Wrapper;

@Listeners(Reports.class)
public class CheckInValidationTest extends Wrapper{
	
	Reports report = new Reports();
	@Test(priority = 5)
	public void validateCheckIn() {
		
		try {
			report.setTCDesc("Validate Checkin field in SpiceJet website");

	//		launchBrowser("https://www.spicejet.com");
			
			
			CheckInValidationPage cvp = PageFactory.initElements(driver, CheckInValidationPage.class);
			cvp.clickCheckIn();
			cvp.enterTicketNumber("G3S3A8");
			cvp.enterLastNmae("Gunasekar");
			cvp.clickSearch();
			cvp.validateCheckingField("Unable to fetch your booking. Please check the inputs \n"
					+ " you have provided and try again.");
			System.out.println("ChechIn Fields Verified successfully");
			closeBrowser();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
