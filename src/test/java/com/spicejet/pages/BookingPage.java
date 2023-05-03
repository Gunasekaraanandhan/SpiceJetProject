package com.spicejet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.spicejet.utils.Wrapper;

public class BookingPage extends Wrapper {

	/*
	 * //@FindBy(xpath="(//div[@class='css-1dbjc4n r-13ejrc r-109y4c4 r-bnwqim r-1ki14p2 r-13qz1uu r-184en5c'])[1]")
	 * 
	 * @FindBy(xpath="//div[text()='SG 8104']") WebElement flight1;
	 * 
	 * public void clickFirstFlight() {
	 *  waitForElement(flight1);
	 * clickAction(flight1); 
	 * }
	 * 
	 * //@FindBy(xpath="(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-15d164r'])[3]")
	 * 
	 * @FindBy(xpath="(//div[@data-testid='spicemax-flight-select-radio-button-3'])[1]")
	 * WebElement spiceMax1;
	 * 
	 * public void click6amDepartFlight() {
	 *  waitForElement(spiceMax1);
	 * //clickAction(spiceMax1);
	 *  //jsClick(spiceMax1);
	 *   actionClick(spiceMax1);
	 * }
	 * 
	 * //@FindBy(
	 * xpath="(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-15d164r'])[10]")
	 * 
	 * @FindBy(xpath=
	 * "(//div[@data-testid='spicemax-flight-select-radio-button-3'])[4]")
	 * WebElement spiceMax2;
	 * 
	 * public void click10pmReturnFlight() {
	 *  waitForElement(spiceMax2);
	 * //clickAction(spiceMax2);
	 *  //jsClick(spiceMax2);
	 * actionClick(spiceMax2); }
	 */

	@FindBy(xpath = "(//div[text()='Continue'])[1]")
	WebElement continue1;

	public void clickContinueButton() {
		waitForElement(continue1);
		// clickAction(continue1);
		// jsClick(continue1);
		actionClick(continue1);
	}

}
