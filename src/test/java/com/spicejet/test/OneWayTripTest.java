package com.spicejet.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.spicejet.pages.BookingPage;
import com.spicejet.pages.OneWayTripPage;
import com.spicejet.pages.PassengerAndPaymentInfoPage;
import com.spicejet.utils.Reports;
import com.spicejet.utils.Wrapper;

@Listeners(Reports.class)
public class OneWayTripTest extends Wrapper{
	Reports report = new Reports();
	@Test(priority = 3)
	public void searchFlightOneway() {
		
		try {
			report.setTCDesc("Searching flights for Oneway trip");

		//	launchBrowser("https://www.spicejet.com");
		//	driver.get("https://www.spicejet.com");
			System.out.println("Title : "+driver.getTitle());
			System.out.println();
			
			OneWayTripPage otp = PageFactory.initElements(driver, OneWayTripPage.class);
			otp.typeFrom("Chen");
			Thread.sleep(2000);
			otp.typeTo("del");
			otp.clickDate();
			otp.clickSearchFlight();
			
			Thread.sleep(6000);
			screenShot("OneWayTripSearchFlights");
			System.out.println("One way trip flights has been searched successfully");
			System.out.println();
			
			BookingPage bp = PageFactory.initElements(driver, BookingPage.class);
			Thread.sleep(3000);
			bp.clickContinueButton();
			System.out.println("Booking page passed successfully in One Way Trip.");
			System.out.println();

			PassengerAndPaymentInfoPage ppi = PageFactory.initElements(driver, PassengerAndPaymentInfoPage.class);
			ppi.enterFirstName("Gunasekar");
			ppi.enterLastName("Aanandhan");
			ppi.enterPhoneNumber("9585148924");
			ppi.enterEmail("gunasekarstar4@gmail.com");
			ppi.enterCityName("Chennai");
			ppi.clickCheckBox();
			ppi.enterFirstNameTraveller("Gunasekar");
			ppi.enterLastNameTraveller("Aanandhan");
			ppi.enterPhoneNumberTraveller("9585148924");
			ppi.clickContinueButton();
			ppi.clickContinueButton2();
			ppi.clickSkipSeat();
			ppi.enterCardNumber("1234123456785678");
			ppi.enterAccHolderName("Gunasekar");
			ppi.enterExpiryMonth("12");
			ppi.enterExpiryYear("25");
			ppi.enterExpiryCVV("123");
			ppi.framesByDefault();
			ppi.clickProceedToPay();
			Thread.sleep(4000);
			screenShot("OneWayTripPaymentInvalid");
			
			ppi.validatePayment("Invalid Card Details");
			closeBrowser();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
