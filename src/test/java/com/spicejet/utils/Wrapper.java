package com.spicejet.utils;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wrapper {
	/*
	 * for update chrome browser ChromeOptions options = new ChromeOptions();
	 * options.addArguments("--remote-allow-origins=*"); driver = new
	 * ChromeDriver(options);
	 */
	public static WebDriver driver = null;

/*	@Parameters({ "browser" })
	public void launchBrowser(String url) {

		try {	
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
			Reports.reportStep("PASS", "Browser launched successfully with " + url);
		} catch (Exception ex) {
			System.out.println("Problem while launching Browser");
			Reports.reportStep("FAIL", "Problem while launching the browser with " + url);
			ex.printStackTrace();
		}
	}
*/
	@BeforeMethod
	@Parameters({ "browser" })
	public void launchBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.spicejet.com");
		}
		
		else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.spicejet.com");
		}
		
		else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.spicejet.com");
		}
	}
	
	
	public void brokenLink(String url) {

		try {
			HttpURLConnection httpConnection = (HttpURLConnection) new URL(url).openConnection();
			httpConnection.connect();
			int respCode = httpConnection.getResponseCode();

			if (respCode >= 400) {
				System.out.println(url + " is broken and its responsecode is " + respCode);
				Reports.reportStep("PASS", "This " + url + " is broken");
			} else {
				System.out.println(url + " is Valid and its responsecode is " + respCode);
				Reports.reportStep("PASS", "This " + url + " is verified valid link");
			}
		} catch (Exception ex) {
			Reports.reportStep("FAIL", "Problem while Verifing the " + url + " as broken link");
			ex.printStackTrace();
		}
	}

	@AfterMethod
	public void quitBrowser() {
		try {
			driver.quit();
			Reports.reportStep("PASS", "Problem while closing All the Browsers");
		} catch (Exception ex) {
			Reports.reportStep("FAIL", "Problem while closing all the browsers");
			ex.printStackTrace();
		}
	}

	public void closeBrowser() {
		try {
			driver.close();
			Reports.reportStep("PASS", "Closing the active browser window");
		} catch (Exception ex) {
			Reports.reportStep("FAIL", "Pooblem while closing the current browser window");
			ex.printStackTrace();
		}
	}

	public void validateTitle(String expectedTitle) {

		try {
			Assert.assertEquals(driver.getTitle(), expectedTitle);
			Reports.reportStep("PASS", "This " + expectedTitle + " has been verified successfully");
		} catch (Exception e) {
			Reports.reportStep("FAIL", "Problem while Verifing the " + expectedTitle);
			e.printStackTrace();
		}
	}

	public void validateText(WebElement ele, String text) {

		try {
			Assert.assertEquals(ele.getText(), text);
			Reports.reportStep("PASS", "This " + text + " has been verified successfully");
		} catch (Exception e) {
			Reports.reportStep("FAIL", "Problem while Verifing the " + text);
			e.printStackTrace();
		}
	}

	public void typeText(WebElement ele, String text) {
		try {
			// ele.clear();
			ele.sendKeys(text);
			Reports.reportStep("PASS", "The " + text + " was entered succesfully to the " + ele);
		} catch (Exception ex) {
			Reports.reportStep("FAIL", "The " + text + " was not entered to the " + ele);
			ex.printStackTrace();
		}
	}

	public void clickAction(WebElement ele) {
		try {
			ele.click();
			Reports.reportStep("PASS", "The " + ele + " was clicked succesfully");
		} catch (Exception ex) {
			Reports.reportStep("FAIL", "The " + ele + " wasn't clicked");
			ex.printStackTrace();
		}
	}

	public void waitForElement(WebElement ele) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(ele));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			Reports.reportStep("PASS", "The " + ele + " waited successfully to meet the expected conditions");
		} catch (Exception ex) {
			Reports.reportStep("FAIL", "Problem while waiting for the " + ele);
			ex.printStackTrace();
		}

	}

	public void selectDDByValue(WebElement ele, String value) {
		try {
			Select sel = new Select(ele);
			sel.selectByValue(value);
			Reports.reportStep("PASS", "Selected the given " + value + " from the dropdown");
		} catch (Exception ex) {
			Reports.reportStep("FAIL", "Problem while selecting the given " + value + " from the dropdown");
			ex.printStackTrace();
		}

	}

	public void selectDDByVisibleText(WebElement ele, String VisibleText) {
		try {
			Select sel = new Select(ele);
			sel.selectByVisibleText(VisibleText);
			Reports.reportStep("PASS", "Selected the given " + VisibleText + " from the dropdown");
		} catch (Exception ex) {
			Reports.reportStep("FAIL", "Problem while selecting the given " + VisibleText + " from the dropdown");
			ex.printStackTrace();
		}
	}

	public void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			Reports.reportStep("PASS", "Successfully accepted the alert");
		} catch (Exception ex) {
			Reports.reportStep("FAIL", "Problem while accepting the alert");
			ex.printStackTrace();
		}
	}

	public void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			Reports.reportStep("PASS", "Successfully dismiss the alert");
		} catch (Exception ex) {
			Reports.reportStep("FAIL", "Problem while dismiss the alert");
			ex.printStackTrace();
		}
	}

	public void jsScrollUpAndDown(int value) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0," + value + ")");
			Reports.reportStep("PASS", "Scroll action(up/down) has been done successfully with " + value);
		} catch (Exception e) {
			Reports.reportStep("FAIL", "Problem while doing Scroll action(up/down) with " + value);
			e.printStackTrace();
		}
	}

	public void jsScrollUpToElement(WebElement ele) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", ele);
			Reports.reportStep("PASS", "Scroll action has been done successfully upto finding that " + ele);
		} catch (Exception e) {
			Reports.reportStep("FAIL", "Problem while doing Scroll action upto find that " + ele);
			e.printStackTrace();
		}
	}

	public void jsClick(WebElement ele) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ele);
			Reports.reportStep("PASS", "The " + ele + " was clicked succesfully");
		} catch (Exception e) {
			Reports.reportStep("FAIL", "The " + ele + " wasn't clicked succesfully");
			e.printStackTrace();
		}

	}

	// screenshot
	public void screenShot(String ssname) {
		try {
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			File dest = new File("./ssphotos/" + ssname + ".png");

			FileUtils.copyFile(source, dest);

			Reports.reportStep("PASS", "The ScreenShot has been done successfully");
		} catch (Exception e) {
			Reports.reportStep("FAIL", "Problem while taking the ScreenShot ");
			e.printStackTrace();
		}
	}

	public void windowHandling() {
		try {
			String pWindow = driver.getWindowHandle();
			Set<String> windowHandle = driver.getWindowHandles();
			System.out.println("Parent window address : " + pWindow);

			for (String adr : windowHandle) {

				if (!(pWindow.contentEquals(adr))) {
					System.out.println("Current window address : " + adr);
					driver.switchTo().window(adr);
				}

				Reports.reportStep("PASS", "The widow has been handled successfully");
			}

		} catch (Exception e) {
			Reports.reportStep("FAIL", "Problem while handling the widow");
			e.printStackTrace();
		}
	}

	public void actionClick(WebElement ele) {
		try {
			Actions act = new Actions(driver);
			act.click(ele).build().perform();
			Reports.reportStep("PASS", "The " + ele + " has been clicked succesfully");
		} catch (Exception ex) {
			Reports.reportStep("FAIL", "The " + ele + " wasn't clicked");
			ex.printStackTrace();
		}
	}

	public void moveTo(WebElement ele) {
		try {
			Actions act = new Actions(driver);
			act.moveToElement(ele).build().perform();
			Reports.reportStep("PASS", "The " + ele + " was movoTo element succesfully");
		} catch (Exception ex) {
			Reports.reportStep("PASS", "The " + ele + " wasn't moveTo  element");
			ex.printStackTrace();
		}
	}

	public void doubleclick(WebElement ele) {
		try {
			Actions act = new Actions(driver);
			act.doubleClick(ele).build().perform();
			Reports.reportStep("PASS", "The " + ele + " has been doubleclicked succesfully");
		} catch (Exception ex) {
			Reports.reportStep("FAIL", "The " + ele + " wasn't doubleclicked");
			ex.printStackTrace();
		}
	}

	public void framesByWebElement(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
			Reports.reportStep("PASS", "The frame is swicthed successfully using WebElement " + ele);
		} catch (Exception e) {
			Reports.reportStep("FAIL", "Problem while switching the frame using WebElement" + ele);
			e.printStackTrace();
		}
	}

	public void framesByDefault() {
		try {
			driver.switchTo().defaultContent();
			Reports.reportStep("PASS", "The frame is swicthed to parent frame successfully");
		} catch (Exception e) {
			Reports.reportStep("FAIL", "Problem while switching the parent frame ");
			e.printStackTrace();
		}
	}
}
