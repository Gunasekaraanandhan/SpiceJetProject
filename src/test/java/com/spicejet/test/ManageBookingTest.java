package com.spicejet.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.spicejet.pages.ManageBookingValidationPage;
import com.spicejet.utils.Reports;
import com.spicejet.utils.Wrapper;

@Listeners(Reports.class)
public class ManageBookingTest extends Wrapper{

	Reports report = new Reports();
	@Test(priority = 7)
	public void validateCheckIn() {
		
		try {
			report.setTCDesc("Validate Manage Booking in SpiceJet website");

		//	launchBrowser("https://www.spicejet.com");
		//	driver.get("https://www.spicejet.com");
			
			ManageBookingValidationPage mvp = PageFactory.initElements(driver, ManageBookingValidationPage.class);
			mvp.clickManageBooking();
			mvp.enterTicketNumber("A3V3M8");
			mvp.enterLastNmae("Aanandhan");
			mvp.clickSearch();
			mvp.validateCheckingField("Unable to fetch your booking. Please check the inputs \n"
					+ " you have provided and try again.");
			System.out.println("Manage Bookings Fields Verified successfully");
			closeBrowser();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
