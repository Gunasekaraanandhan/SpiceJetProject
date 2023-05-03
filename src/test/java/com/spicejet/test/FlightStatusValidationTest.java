package com.spicejet.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.spicejet.pages.FlightStatusValidationPage;
import com.spicejet.utils.Reports;
import com.spicejet.utils.Wrapper;

@Listeners(Reports.class)
public class FlightStatusValidationTest extends Wrapper {

	Reports report = new Reports();

	@Test(priority = 6)
	public void validateFlightStatus() {

		try {
			report.setTCDesc("Validate Flight Status in SpiceJet website");

	//		launchBrowser("https://www.spicejet.com");
	//		driver.get("https://www.spicejet.com");

			FlightStatusValidationPage fvp = PageFactory.initElements(driver, FlightStatusValidationPage.class);
			fvp.clickFlightStatus();
			fvp.clickDepartureDate();
			fvp.clickToday();
			fvp.typeFrom("chen");
			fvp.typeTo("del");
			fvp.clickSearch();
			validateTitle("SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets");
			System.out.println("Flight status Fields Verified successfully");
			closeBrowser();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
