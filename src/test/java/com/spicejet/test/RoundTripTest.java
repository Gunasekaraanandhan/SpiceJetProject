package com.spicejet.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.spicejet.pages.BookingPage;
import com.spicejet.pages.PassengerAndPaymentInfoPage;
import com.spicejet.pages.RoundTripPage;
import com.spicejet.utils.Reports;
import com.spicejet.utils.Wrapper;

@Listeners(Reports.class)
public class RoundTripTest extends Wrapper {

	Reports report = new Reports();

	@Test(priority = 4)
	public void searchFlightRound() {

		try {
			report.setTCDesc("Search flights for Round trip");
	//		launchBrowser("https://www.spicejet.com");
	//		driver.get("https://www.spicejet.com");
			System.out.println("Title : "+driver.getTitle());
			System.out.println();
			
			RoundTripPage rtp = PageFactory.initElements(driver, RoundTripPage.class);
			rtp.clickRoundTrip();
			rtp.typeFrom("Chen");
			Thread.sleep(2000);
			rtp.typeTo("del");
			rtp.clickDate();
			rtp.clickReturndate();
			rtp.clickSearchFlight();
			Thread.sleep(6000);
			screenShot("RoundTripSearchFlights");
			System.out.println("Round trip flights has been searched successfully.");
			System.out.println();

			BookingPage bp = PageFactory.initElements(driver, BookingPage.class);
			// bp.clickFirstFlight();
			// bp.click6amDepartFlight();
			// bp.click10pmReturnFlight();
			Thread.sleep(3000);
			bp.clickContinueButton();
			System.out.println("Booking page passed successfully in Round Trip.");
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
			// ppi.clickAdd1SpiceMax();
			// ppi.clickFirstSeat();
			// ppi.clickPrivateRow();
			// ppi.clickSkip();
			// ppi.clickContinueButton1();
			// ppi.selectMeals();
			// ppi.paneerSandwich();
			// ppi.clickDoneButton();
			// ppi.clickCancel();
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
			screenShot("RoundTripPaymentInvalid");
			
			ppi.validatePayment("Invalid Card Details");
			closeBrowser();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
