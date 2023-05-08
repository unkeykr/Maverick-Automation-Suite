package PageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import CommonMethods.CommonUtility;
import CommonMethods.Excel;
import StepDefinition.MMBaseClass;
import io.cucumber.java.Scenario;

public class MovementHomePage {

	public static WebDriver driver;

	int retRow, rescode;
	long startTime, endTime, loadTime;

	String RetVal, FieldValue, SubMenuURL, SubMenuURLsales, AboutSubMenuURL1, AboutSubMenuURL2, AboutSubMenuURL3,
			FindLoanURL, OurProURL, PayMortgageURL, SupportServiceURL, FindLoanOfficerURL, ApplyApplicationURL,
			CurrentHomeURL, LearnMoreCurrentURL, ViewLoansCurrentURL, FindLoanOffCurrentURL, ContactCurrentURL,
			LOStartMyApplicationActURL, LOGoCalculatorActURL, LOGoPayMyMortgageActURL, LOFindALoanButtonActURL,
			MMTwitterActURL, MMInstagramActURL, MMFacebookActURL, MMLinkedInActURL, MMYouTubeActURL,
			LOMovementNewsRoomActURL, LOMoreFAQActURL, LOMarketUpdateActURL, MMTwitterExpURL, MMInstagramExpURL,
			MMFacebookExpURL, MMLinkedInExpURL, MMYoutubeExpURL, statusCode, pageNotFound = "404";

	// Movement Home Page Constructor
	public MovementHomePage(WebDriver driver) {

	}

	// Method to verify Movement Mortgage Logo present on home page
	public void verifyHomeURLResponse(WebDriver driver, ExtentTest test, CommonUtility UtilObj, int rescode,
			long loadTime, String pageName) throws IOException {
		String SSpath = UtilObj.SaveScreenshot(driver, "Home Page");
		if (rescode == 200) {

			test.log(Status.INFO, "<b>Expected Result: </b> Base URL web page should be loaded");
			test.pass("<b>Actual Result: </b> Home page was loaded with" + " , Response code :- " + rescode
					+ ", Page Load time was: " + loadTime + " Milliseconds ").addScreenCaptureFromPath(SSpath);

		} else {
			test.log(Status.INFO, "<b>Expected Result: </b> Base URL web page should be loaded");
			test.fail("<b>Actual Result: </b> Home page was loaded with" + " , Response code :- " + rescode
					+ ", Page Load time was: " + loadTime + " Milliseconds ").addScreenCaptureFromPath(SSpath);
		}

	}

	public void MMLogoverification(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("Xpath");

		retRow = excelObj.getRowNum("MMLogo");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		startTime = System.currentTimeMillis();
		int Logosize = driver.findElements(By.xpath(RetVal)).size();
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "MM Logo");
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;
		if (Logosize > 0) {
			String SSpath = UtilObj.SaveScreenshot(driver, "MM Logo");

			test.log(Status.INFO, "<b>Expected Result: </b> Movement Mortgage Logo Should be present");
			test.pass("<b>Actual Result: </b> Movement Mortgage Logo was present" + " , Response code :- " + rescode
					+ ", Page Load time in Milliseconds: " + loadTime).addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "MM Logo");
			test.log(Status.INFO, "<b>Expected Result: </b> Movement Mortgage Logo Should be present");
			test.fail("<b>Actual Result: </b> Movement Mortgage Logo was not present" + " , Response code :- " + rescode
					+ ", Page Load time in Milliseconds: " + loadTime).addScreenCaptureFromPath(SSpath);
		}

	}

	// Method to verify five Option Buttons present on the Home page of Movement
	// Mortgage
	public void ButtonVerification(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("Xpath");

		retRow = excelObj.getRowNum("Careers");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayCareer = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("About");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayAbout = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("HomeLoans");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayLoans = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("Customers");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayCustomer = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("Contact");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayContact = driver.findElement(By.xpath(RetVal)).isDisplayed();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Option Buttons");
		if (DisplayCareer && DisplayAbout && DisplayLoans && DisplayCustomer && DisplayContact) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Option Buttons");
			test.log(Status.INFO,
					"<b>Expected Result: </b> 5 Option Button(Careers,About,Home Loans,Customers,Contact) should be available");
			test.pass(
					"<b>Actual Result: </b> 5 Option Button(Careers,About,Home Loans,Customers,Contact) were available"
							+ " , Response code :- " + rescode)
					.addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Option Buttons");
			test.log(Status.INFO,
					"<b>Expected Result: </b> 5 Option Button(Careers,About,Home Loans,Customers,Contact) should be available");
			test.fail(
					"<b>Actual Result: </b> 5 Option Button(Careers,About,Home Loans,Customers,Contact) were not available"
							+ " , Response code :- " + rescode)
					.addScreenCaptureFromPath(SSpath);

		}
	}

	// Method to verify Careers Sub menus present on movement home page by hovering
	// Careers option
	public void CareersSubmenu(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("Careers");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		startTime = System.currentTimeMillis();
		driver.findElement(By.xpath(RetVal)).click();
		WebElement CarrersEle = driver.findElement(By.xpath(RetVal));
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;

		Actions act = new Actions(driver);
		act.moveToElement(CarrersEle).perform();
		retRow = excelObj.getRowNum("CareersSubmenu1");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		Boolean DisplayCareerSub1 = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("CareersSubmenu2");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayCareerSub2 = driver.findElement(By.xpath(RetVal)).isDisplayed();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Careers Submenu");

		if (DisplayCareerSub1 && DisplayCareerSub2) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Careers Submenu");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Careers Sub Menu: WORK AT MOVEMENT and LOAN OFFICERS should be present");
			test.pass("<b>Actual Result: </b> Careers Sub Menu: WORK AT MOVEMENT and LOAN OFFICERS were present"
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Careers Submenu");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Careers Sub Menu: WORK AT MOVEMENT and LOAN OFFICERS should be present");
			test.fail("<b>Actual Result: </b> Careers Sub Menu: WORK AT MOVEMENT and LOAN OFFICERS were not present"
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		}
	}

	// Method to verify Careers sub menu: Work at Movement screen and URL
	public void CareersSubmenu_1(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {
		// String CareerURL="https://movement.com/careers";
		excelObj.setSheet("InputData");
		retRow = excelObj.getRowNum("Verify Careers Submenus");
		String CareerURL = excelObj.getCellData(retRow, "MMWorkAtMovementURL");

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("CareersSubmenu1");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		startTime = System.currentTimeMillis();
		driver.findElement(By.xpath(RetVal)).click();
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Work At Movement");
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;

		SubMenuURL = driver.getCurrentUrl();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Work at Movement");
		if (CareerURL.equals(SubMenuURL)) {

			String SSpath = UtilObj.SaveScreenshot(driver, "Work at Movement");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Careers Sub Menu 1: WORK AT MOVEMENT URL should be " + CareerURL);
			test.pass("<b>Actual Result: </b> Careers Sub Menu 1: WORK AT MOVEMENT URL was " + SubMenuURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Work at Movement");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Careers Sub Menu 1: WORK AT MOVEMENT URL should be " + CareerURL);
			test.fail("<b>Actual Result: </b> Sub Menu 1: WORK AT MOVEMENT URL was " + SubMenuURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		}

	}

	// Method to verify Careers sub menu: Loan Officers screen and URL
	public void CareersSubmenu_2(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws InterruptedException, IOException {
		// String CareerURLSales="https://movement.com/careers/sales";

		excelObj.setSheet("InputData");
		retRow = excelObj.getRowNum("Verify Careers Submenus");
		String CareerURLSales = excelObj.getCellData(retRow, "MMLoanOfficerURL");

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("Careers");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		WebElement CarrersEle = driver.findElement(By.xpath(RetVal));
		Actions act = new Actions(driver);
		act.moveToElement(CarrersEle).perform();
		String originalHandle = driver.getWindowHandle();
		retRow = excelObj.getRowNum("CareersSubmenu2");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		startTime = System.currentTimeMillis();
		driver.findElement(By.xpath(RetVal)).click();
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Movement Loan Officer");
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;

		Set<String> currentPageHandles = driver.getWindowHandles();
		boolean myNewTabFound = false;

		for (String handle : currentPageHandles) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				myNewTabFound = true;
			}

		}

		if (myNewTabFound) {
			SubMenuURLsales = driver.getCurrentUrl();
		}

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Loan Officer");
		if (CareerURLSales.equals(SubMenuURLsales)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Loan Officer");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Careers Sub Menu 2: LOAN OFFICERS URL should be " + CareerURLSales);
			test.pass("<b>Actual Result: </b> Careers Sub Menu 2: LOAN OFFICERS URL was " + SubMenuURLsales
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Loan Officer");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Careers Sub Menu 2: LOAN OFFICERS URL should be " + CareerURLSales);
			test.fail("<b>Actual Result: </b> Careers Sub Menu 2: LOAN OFFICERS URL was " + SubMenuURLsales
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		}
	}

	// Method to verify About Sub menus present by hovering About option

	public void AboutSubmenu(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("About");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		WebElement AboutEle = driver.findElement(By.xpath(RetVal));
		Actions act = new Actions(driver);
		act.moveToElement(AboutEle).perform();

		retRow = excelObj.getRowNum("AboutSubmenu1");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayAboutSub1 = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("AboutSubmenu2");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayAboutSub2 = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("AboutSubmenu3");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayAboutSub3 = driver.findElement(By.xpath(RetVal)).isDisplayed();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "About Submenu");
		if (DisplayAboutSub1 && DisplayAboutSub2 && DisplayAboutSub3) {
			String SSpath = UtilObj.SaveScreenshot(driver, "About Submenu");
			test.log(Status.INFO,
					"<b>Expected Result: </b> About Sub Menu: OUR STORY,OUR LEADERSHIP and THE BLOG should be present");
			test.pass("<b>Actual Result: </b> About Sub Menu: OUR STORY,OUR LEADERSHIP and THE BLOG were present"
					+ " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "About Submenu");
			test.log(Status.INFO,
					"<b>Expected Result: </b> About Sub Menu: OUR STORY,OUR LEADERSHIP and THE BLOG should be present");
			test.fail("<b>Actual Result: </b> About Sub Menu: OUR STORY,OUR LEADERSHIP and THE BLOG were not present"
					+ " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);

		}
	}

	// Method to verify About sub menu: Our Story screen and URL
	public void AboutSubmenu_1(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {
		excelObj.setSheet("InputData");
		retRow = excelObj.getRowNum("Verify About Submenus");
		String OurStoryURL = excelObj.getCellData(retRow, "MMOurStoryURL");

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("AboutSubmenu1");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		startTime = System.currentTimeMillis();
		driver.findElement(By.xpath(RetVal)).click();
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Our Story");
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;

		AboutSubMenuURL1 = driver.getCurrentUrl();

		if (OurStoryURL.equals(AboutSubMenuURL1)) {

			String SSpath = UtilObj.SaveScreenshot(driver, "Our Story");
			test.log(Status.INFO, "<b>Expected Result: </b> About Sub Menu 1: OUR STORY URL should be " + OurStoryURL);
			test.pass("<b>Actual Result: </b> About Sub Menu 1: OUR STORY URL was " + AboutSubMenuURL1
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Our Story");
			test.log(Status.INFO, "<b>Expected Result: </b> About Sub Menu 1: OUR STORY URL should be " + OurStoryURL);
			test.fail("<b>Actual Result: </b> About Sub Menu 1: OUR STORY URL was " + AboutSubMenuURL1
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		}
	}

	// Method to verify About sub menu: Our Leadership screen and URL
	public void AboutSubmenu_2(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {
		excelObj.setSheet("InputData");
		retRow = excelObj.getRowNum("Verify About Submenus");
		String OurLeadershipURL = excelObj.getCellData(retRow, "MMOurLeadershipURL");

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("About");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		WebElement AboutEle = driver.findElement(By.xpath(RetVal));

		Actions act = new Actions(driver);
		act.moveToElement(AboutEle).perform();

		retRow = excelObj.getRowNum("AboutSubmenu2");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		startTime = System.currentTimeMillis();
		driver.findElement(By.xpath(RetVal)).click();
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Our Leadership");
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;
		AboutSubMenuURL2 = driver.getCurrentUrl();

		if (OurLeadershipURL.equals(AboutSubMenuURL2)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Our Leadership");
			test.log(Status.INFO,
					"<b>Expected Result: </b> About Sub Menu 2: OUR LEADERSHIP URL should be " + OurLeadershipURL);
			test.pass("<b>Actual Result: </b> About Sub Menu 2: OUR LEADERSHIP URL was " + AboutSubMenuURL2
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Our Leadership");
			test.log(Status.INFO,
					"<b>Expected Result: </b> About Sub Menu 2: OUR LEADERSHIP URL should be " + OurLeadershipURL);
			test.fail("<b>Actual Result: </b> About Sub Menu 2: OUR LEADERSHIP URL was " + AboutSubMenuURL2
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		}

	}

	// Method to verify Careers sub menu: Loan Officers screen and URL
	public void AboutSubmenu_3(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws InterruptedException, IOException {

		excelObj.setSheet("InputData");
		retRow = excelObj.getRowNum("Verify About Submenus");
		String TheBlogURL = excelObj.getCellData(retRow, "MMTheBlogURL");

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("About");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		WebElement AboutEle = driver.findElement(By.xpath(RetVal));

		Actions act = new Actions(driver);
		act.moveToElement(AboutEle).perform();
		String originalHandle = driver.getWindowHandle();

		retRow = excelObj.getRowNum("AboutSubmenu3");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		startTime = System.currentTimeMillis();
		driver.findElement(By.xpath(RetVal)).click();
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "The Blog");
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;

		Set<String> currentPageHandles = driver.getWindowHandles();
		boolean myNewTabFound = false;

		for (String handle : currentPageHandles) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				myNewTabFound = true;
			}

		}

		if (myNewTabFound) {
			AboutSubMenuURL3 = driver.getCurrentUrl();
		}

		if (TheBlogURL.equals(AboutSubMenuURL3)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "The Blog");
			test.log(Status.INFO, "<b>Expected Result: </b> About Sub Menu 3: THE BLOG URL should be " + TheBlogURL);
			test.pass("<b>Actual Result: </b> About Sub Menu 3: THE BLOG URL was " + AboutSubMenuURL3
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "The Blog");
			test.log(Status.INFO, "<b>Expected Result: </b> About Sub Menu 3: THE BLOG URL should be " + TheBlogURL);
			test.fail("<b>Actual Result: </b> About Sub Menu 3: THE BLOG URL was " + AboutSubMenuURL3
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		}
	}

	// Method to verify Home Loan sub menu by hovering the button
	public void HomeLoansSubmenu(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {
		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("HomeLoans");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		WebElement LoantEle = driver.findElement(By.xpath(RetVal));
		Actions act = new Actions(driver);
		act.moveToElement(LoantEle).perform();

		retRow = excelObj.getRowNum("LoanSubmenu1");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayLoanSub1 = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LoanSubmenu2");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayLoanSub2 = driver.findElement(By.xpath(RetVal)).isDisplayed();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "HomeLoans Submenu");
		if (DisplayLoanSub1 && DisplayLoanSub2) {
			String SSpath = UtilObj.SaveScreenshot(driver, "HomeLoans Submenu");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Home Loans Sub Menu: FIND A LOAN and OUR PROCESS should be present");
			test.pass("<b>Actual Result: </b> Home Loans Sub Menu: FIND A LOAN and OUR PROCESS were present"
					+ " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "HomeLoans Submenu");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Home Loans Sub Menu: FIND A LOAN and OUR PROCESS should be present");
			test.fail("<b>Actual Result: </b> Home Loans Sub Menu: FIND A LOAN and OUR PROCESS were not present"
					+ " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);

		}
	}

	// Method to verify Home Loans sub menu: Find A Loan screen and URL
	public void HomeLoanSubmenu_1(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {
		excelObj.setSheet("InputData");
		retRow = excelObj.getRowNum("Verify Home Loans Submenus");
		String FindALoanURL = excelObj.getCellData(retRow, "MMFindALoanURL");

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("LoanSubmenu1");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		startTime = System.currentTimeMillis();
		driver.findElement(By.xpath(RetVal)).click();
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Find A Loan");
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;

		FindLoanURL = driver.getCurrentUrl();

		if (FindALoanURL.equals(FindLoanURL)) {

			String SSpath = UtilObj.SaveScreenshot(driver, "Find A Loan");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Home Loan Sub Menu 1: FIND A LOAN page should be loaded with URL "
							+ FindALoanURL);
			test.pass("<b>Actual Result: </b> Home Loan Sub Menu 1: FIND A LOAN page URL was " + FindLoanURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Find A Loan");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Home Loan Sub Menu 1: FIND A LOAN page should be loaded with URL "
							+ FindALoanURL);
			test.fail("<b>Actual Result: </b> Home Loan Sub Menu 1: FIND A LOAN page URL was " + FindLoanURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		}
	}

	// Method to verify Home Loans sub menu: Our Process screen and URL
	public void HomeLoanSubmenu_2(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {
		excelObj.setSheet("InputData");
		retRow = excelObj.getRowNum("Verify Home Loans Submenus");
		String OurProcessURL = excelObj.getCellData(retRow, "MMOurProcessURL");

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("HomeLoans");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		WebElement HomLoanEle = driver.findElement(By.xpath(RetVal));
		Actions act = new Actions(driver);
		act.moveToElement(HomLoanEle).perform();

		retRow = excelObj.getRowNum("LoanSubmenu2");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		startTime = System.currentTimeMillis();
		driver.findElement(By.xpath(RetVal)).click();
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Our Process");
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;

		OurProURL = driver.getCurrentUrl();
		if (OurProcessURL.equals(OurProURL)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Our Process");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Home Loan Sub Menu 2: OUR PROCESS URL should be " + OurProcessURL);
			test.pass("<b>Actual Result: </b> Home Loan Sub Menu 2: OUR PROCESS URL was " + OurProURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Our Process");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Home Loan Sub Menu 2: OUR PROCESS URL should be " + OurProcessURL);
			test.fail("<b>Actual Result: </b> Home Loan Sub Menu 2: OUR PROCESS URL was " + OurProURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		}
	}

	// Method to verify Customers Sub menus present by hovering Customers option
	public void CustomersSubmenu(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("Customers");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		WebElement CustomersEle = driver.findElement(By.xpath(RetVal));
		Actions act = new Actions(driver);
		act.moveToElement(CustomersEle).perform();

		retRow = excelObj.getRowNum("CustomersSubmenu1");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayCustomersSub1 = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("CustomersSubmenu2");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayCustomersSub2 = driver.findElement(By.xpath(RetVal)).isDisplayed();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Customers Submenu");
		if (DisplayCustomersSub1 && DisplayCustomersSub2) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Customers Submenu");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Customers Sub Menu: PAY MY MORTGAGE and SUPPORT & SERVICING should be present");
			test.pass("<b>Actual Result: </b> Customers Sub Menu: PAY MY MORTGAGE and SUPPORT & SERVICING were present"
					+ " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Customers Submenu");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Customers Sub Menu: PAY MY MORTGAGE and SUPPORT & SERVICING should be present");
			test.fail(
					"<b>Actual Result: </b> Customers Sub Menu: PAY MY MORTGAGE and SUPPORT & SERVICING were not present"
							+ " , Response code :- " + rescode)
					.addScreenCaptureFromPath(SSpath);

		}
	}

	// Method to verify Careers sub menu: Pay My Mortgage screen and URL
	public void CustomersSubmenu_1(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws InterruptedException, IOException {
		excelObj.setSheet("InputData");
		retRow = excelObj.getRowNum("Verify Customers Submenus");
		String PayMyMortgageURL = excelObj.getCellData(retRow, "MMPayMyMortgageURL");

		String originalHandle = driver.getWindowHandle();

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("CustomersSubmenu1");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		startTime = System.currentTimeMillis();
		driver.findElement(By.xpath(RetVal)).click();
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Pay My Mortgage");
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;
		Set<String> currentPageHandles = driver.getWindowHandles();
		boolean myNewTabFound = false;

		for (String handle : currentPageHandles) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				myNewTabFound = true;
			}

		}

		if (myNewTabFound) {
			PayMortgageURL = driver.getCurrentUrl();
		}

		if (PayMyMortgageURL.equals(PayMortgageURL)) {

			String SSpath = UtilObj.SaveScreenshot(driver, "Pay My Mortgage");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Customers Sub Menu 1: PAY MY MORTGAGE URL should be " + PayMyMortgageURL);
			test.pass("<b>Actual Result: </b> Customers Sub Menu 1: PAY MY MORTGAGE URL was " + PayMortgageURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Pay My Mortgage");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Customers Sub Menu 1: PAY MY MORTGAGE URL should be " + PayMyMortgageURL);
			test.fail("<b>Actual Result: </b> Customers Sub Menu 1: PAY MY MORTGAGE URL was " + PayMortgageURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		}
	}

	// Method to verify Customers sub menu: Support & Servicing screen and URL
	public void CustomersSubmenu_2(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws InterruptedException, IOException {

		excelObj.setSheet("InputData");
		retRow = excelObj.getRowNum("Verify Customers Submenus");
		String SupportandServiceURL = excelObj.getCellData(retRow, "MMSupportServiceURL");

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("Customers");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		WebElement CustomersEle = driver.findElement(By.xpath(RetVal));
		Actions act = new Actions(driver);
		act.moveToElement(CustomersEle).perform();

		retRow = excelObj.getRowNum("CustomersSubmenu2");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		startTime = System.currentTimeMillis();
		driver.findElement(By.xpath(RetVal)).click();
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Support And Service");
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;
		SupportServiceURL = driver.getCurrentUrl();
		if (SupportandServiceURL.equals(SupportServiceURL))

		{
			String SSpath = UtilObj.SaveScreenshot(driver, "Support and Service");
			test.log(Status.INFO, "<b>Expected Result: </b> Customers Sub Menu 2: SUPPORT AND SERVICING URL should be "
					+ SupportandServiceURL);
			test.pass("<b>Actual Result: </b>Customers Sub Menu 2: SUPPORT AND SERVICING URL was " + SupportServiceURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Support and Service");
			test.log(Status.INFO, "<b>Expected Result: </b> Customers Sub Menu 2: SUPPORT AND SERVICING URL should be "
					+ SupportandServiceURL);
			test.fail("<b>Actual Result: </b> Customers Sub Menu 2: SUPPORT AND SERVICING URL was " + SupportServiceURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		}
	}

	// Method to verify Apply Now button on MM home Page
	public void ApplyNowVerify(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {
		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("ApplyNowButton");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		driver.findElement(By.xpath(RetVal)).click();

		retRow = excelObj.getRowNum("LetsGetStarted");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayLetsGetPage = driver.findElement(By.xpath(RetVal)).isDisplayed();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Lets Get Start");
		if (DisplayLetsGetPage) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Lets Get Start");
			test.log(Status.INFO, "<b>Expected Result: </b> Let's Get Started screen should be present");
			test.pass("<b>Actual Result: </b> Let's Get Started screen was present" + " , Response code :- " + rescode)
					.addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Customers Submenu");
			test.log(Status.INFO, "<b>Expected Result: </b> Let's Get Started screen should be present");
			test.fail("<b>Actual Result: </b> Let's Get Started screen was not present" + " , Response code :- "
					+ rescode).addScreenCaptureFromPath(SSpath);

		}
	}

	public void ApplyNowSubmenu(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {
		excelObj.setSheet("Xpath");

		retRow = excelObj.getRowNum("FindLoanOfficer");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayFindLoanOffiver = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("StartAnApplication");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayStartApplication = driver.findElement(By.xpath(RetVal)).isDisplayed();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "ApplyNow Submenu");
		if (DisplayFindLoanOffiver && DisplayStartApplication) {
			String SSpath = UtilObj.SaveScreenshot(driver, "ApplyNow Submenu");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Apply Now Sub Menus: I WANT TO FIND A LOAN OFFICER and I WANT TO START AN APPLICATION should be present");
			test.pass(
					"<b>Actual Result: </b> Apply Now Sub Menus: I WANT TO FIND A LOAN OFFICER and I WANT TO START AN APPLICATION  were present"
							+ " , Response code :- " + rescode)
					.addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "ApplyNow Submenu");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Apply Now Sub Menus: I WANT TO FIND A LOAN OFFICER and I WANT TO START AN APPLICATION  should be present");
			test.fail(
					"<b>Actual Result: </b> Apply Now Sub Menus: I WANT TO FIND A LOAN OFFICER and I WANT TO START AN APPLICATION  were not present"
							+ " , Response code :- " + rescode)
					.addScreenCaptureFromPath(SSpath);

		}
	}

	// Method to verify Apply Now sub menu: Find A Loan Officer screen and URL
	public void ApplyNowSubmenu_1(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {

		try {
			excelObj.setSheet("InputData");
			retRow = excelObj.getRowNum("Verify Apply Now button Submenus");
			String FindALoanOfficerURL = excelObj.getCellData(retRow, "MMIWantTOFindURL");

			excelObj.setSheet("Xpath");
			retRow = excelObj.getRowNum("FindLoanOfficer");
			RetVal = excelObj.getCellData(retRow, "Xpath");
			startTime = System.currentTimeMillis();
			driver.findElement(By.xpath(RetVal)).click();
			rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Find A Loan Officer");
			endTime = System.currentTimeMillis();
			loadTime = endTime - startTime;
			FindLoanOfficerURL = driver.getCurrentUrl();
			if (FindALoanOfficerURL.equals(FindLoanOfficerURL)) {

				String SSpath = UtilObj.SaveScreenshot(driver, "Find A Loan Officer");
				test.log(Status.INFO,
						"<b>Expected Result: </b> Apply Now Sub Menu 1: I WANT TO FIND A LOAN OFFICER URL should be "
								+ FindALoanOfficerURL);
				test.pass("<b>Actual Result: </b> Apply Now Sub Menu 1: I WANT TO FIND A LOAN OFFICER URL was "
						+ FindLoanOfficerURL + " , Response code :- " + rescode + ", Page Load time in Milliseconds: "
						+ loadTime).addScreenCaptureFromPath(SSpath);

			} else {
				String SSpath = UtilObj.SaveScreenshot(driver, "Find A Loan Officer");
				test.log(Status.INFO,
						"<b>Expected Result: </b> Apply Now Sub Menu 1: I WANT TO FIND A LOAN OFFICER URL should be "
								+ FindALoanOfficerURL);
				test.fail("<b>Actual Result: </b> Apply Now Sub Menu 1: I WANT TO FIND A LOAN OFFICER URL was "
						+ FindLoanOfficerURL + " , Response code :- " + rescode + ", Page Load time in Milliseconds: "
						+ loadTime).addScreenCaptureFromPath(SSpath);

			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	// Method to verify Apply Now sub menu: I want to apply an Application screen
	// and URL
	public void ApplyNowSubmenu_2(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {
		try {
			excelObj.setSheet("InputData");
			retRow = excelObj.getRowNum("Verify Apply Now button Submenus");
			String StartAnApplicationURL = excelObj.getCellData(retRow, "MMIWantTOStartURL");

			driver.navigate().back();

			excelObj.setSheet("Xpath");
			retRow = excelObj.getRowNum("StartAnApplication");
			RetVal = excelObj.getCellData(retRow, "Xpath");

			startTime = System.currentTimeMillis();
			driver.findElement(By.xpath(RetVal)).click();
			rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Start An Application");
			endTime = System.currentTimeMillis();
			loadTime = endTime - startTime;
			ApplyApplicationURL = driver.getCurrentUrl();
			if (ApplyApplicationURL.equals(StartAnApplicationURL)) {

				String SSpath = UtilObj.SaveScreenshot(driver, "Start An Application");
				test.log(Status.INFO,
						"<b>Expected Result: </b> Apply Now Sub Menu 2: I WANT TO START AN APPLICATION URL should be :"
								+ StartAnApplicationURL);
				test.pass("<b>Actual Result: </b> Apply Now Sub Menu 2: I WANT TO START AN APPLICATION URL was "
						+ ApplyApplicationURL + " , Response code :- " + rescode + ", Page Load time in Milliseconds: "
						+ loadTime).addScreenCaptureFromPath(SSpath);

			} else {
				String SSpath = UtilObj.SaveScreenshot(driver, "Start An Application");
				test.log(Status.INFO,
						"<b>Expected Result: </b> Apply Now Sub Menu 2: I WANT TO START AN APPLICATION URL should be :"
								+ StartAnApplicationURL);
				test.fail("<b>Actual Result: </b> Apply Now Sub Menu 2: I WANT TO START AN APPLICATION URL was "
						+ ApplyApplicationURL + " , Response code :- " + rescode + ", Page Load time in Milliseconds: "
						+ loadTime).addScreenCaptureFromPath(SSpath);
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void MMLogoHomePageRedirect(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {

		try {

			excelObj.setSheet("InputData");

			retRow = excelObj.getRowNum("Verify Apply Now button Submenus");
			String HomePageURL = excelObj.getCellData(retRow, "MMHomeURL");

			driver.navigate().back();
			// String HomePageURL="https://movement.com/home";

			excelObj.setSheet("Xpath");
			retRow = excelObj.getRowNum("MMHeaderLogo");
			RetVal = excelObj.getCellData(retRow, "Xpath");

			driver.findElement(By.xpath(RetVal)).click();
			rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Movement Home Page");
			retRow = excelObj.getRowNum("MMLogo");
			RetVal = excelObj.getCellData(retRow, "Xpath");
			int Logosize = driver.findElements(By.xpath(RetVal)).size();
			if (Logosize > 0)

				CurrentHomeURL = driver.getCurrentUrl();

			if (CurrentHomeURL.equals(HomePageURL)) {

				String SSpath = UtilObj.SaveScreenshot(driver, "Home Page Redirect");
				test.log(Status.INFO,
						"<b>Expected Result: </b>After clicking MM Logo Movement Mortgage Home Page should be loaded  with URL should be "
								+ HomePageURL);
				test.pass(
						"<b>Actual Result: </b> After clicking MM Logo Movement Mortgage Home Page was loaded with URL  "
								+ CurrentHomeURL + " , Response code :- " + rescode
								+ ", Page Load time in Milliseconds: " + loadTime)
						.addScreenCaptureFromPath(SSpath);

			} else {
				String SSpath = UtilObj.SaveScreenshot(driver, "Home Page Redirect");
				test.log(Status.INFO,
						"<b>Expected Result: </b> After clicking MM Logo  Movement Mortgage Home Page should be loaded with "
								+ HomePageURL);
				test.fail(
						"<b>Actual Result: </b> After clicking MM Logo Movement Mortgage Home Page was not loaded with URL "
								+ CurrentHomeURL + " , Response code :- " + rescode
								+ ", Page Load time in Milliseconds: " + loadTime)
						.addScreenCaptureFromPath(SSpath);

			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			driver.close();
		}
	}

	// Method to verify Learn More About Us Button page and URL
	public void LearnMoreAboutVerify(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {
		excelObj.setSheet("InputData");
		retRow = excelObj
				.getRowNum("Verify Contact,Learn More,View Loans and Find A Loan Officer button and their URLs");
		String LearnMoreAboutURL = excelObj.getCellData(retRow, "MMLearnMoreURL");

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("MMHeaderLogo");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		driver.findElement(By.xpath(RetVal)).click();
		// rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Learn More About
		// Us");
		((JavascriptExecutor) driver).executeScript("scroll(0,2800)");
		retRow = excelObj.getRowNum("LearnMoreAboutUs");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		startTime = System.currentTimeMillis();
		driver.findElement(By.xpath(RetVal)).click();
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Learn More About Us");
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;
		LearnMoreCurrentURL = driver.getCurrentUrl();
		if (LearnMoreCurrentURL.equals(LearnMoreAboutURL)) {

			String SSpath = UtilObj.SaveScreenshot(driver, "Learn More About Us");
			test.log(Status.INFO,
					"<b>Expected Result: </b>Learn More About Us:The Movement Story Page should be loaded with URL "
							+ LearnMoreAboutURL);
			test.pass("<b>Actual Result: </b> Learn More About Us:The Movement Story Page was loaded with URL "
					+ LearnMoreCurrentURL + " , Response code :- " + rescode + ", Page Load time in Milliseconds: "
					+ loadTime).addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Home Page Redirect");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Learn More About Us:The Movement Story Page should be loaded with URL "
							+ LearnMoreAboutURL);
			test.fail("<b>Actual Result: </b> Learn More About Us:The Movement Story Page was not loaded with URL "
					+ LearnMoreCurrentURL + " , Response code :- " + rescode + ", Page Load time in Milliseconds: "
					+ loadTime).addScreenCaptureFromPath(SSpath);

		}

	}

	// Method to verify View Loans page and URL
	public void ViewLoansVerify(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {
		excelObj.setSheet("InputData");
		retRow = excelObj
				.getRowNum("Verify Contact,Learn More,View Loans and Find A Loan Officer button and their URLs");
		String ViewLoansURL = excelObj.getCellData(retRow, "MMViewLoansURL");

		// String ViewLoansURL="https://movement.com/loans#view-loans";

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("MMHeaderLogo");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		driver.findElement(By.xpath(RetVal)).click();

		retRow = excelObj.getRowNum("MMViewLoans");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		((JavascriptExecutor) driver).executeScript("scroll(0,4400)");

		WebElement ViewLoanEle = driver.findElement(By.xpath(RetVal));

		startTime = System.currentTimeMillis();
		ViewLoanEle.click();
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "View Loans");
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;
		ViewLoansCurrentURL = driver.getCurrentUrl();

		if (ViewLoansCurrentURL.equals(ViewLoansURL))

		{

			String SSpath = UtilObj.SaveScreenshot(driver, "View Loans");
			test.log(Status.INFO,
					"<b>Expected Result: </b> View Loans:Find the Best Loan for Me Page should be loaded with URL "
							+ ViewLoansURL);
			test.pass("<b>Actual Result: </b> View Loans:Find the Best Loan for Me page was loaded with URL "
					+ ViewLoansCurrentURL + " , Response code :- " + rescode + ", Page Load time in Milliseconds: "
					+ loadTime).addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "View Loans");
			test.log(Status.INFO,
					"<b>Expected Result: </b> View Loans:Find the Best Loan for Me Page should be loaded with URL "
							+ ViewLoansURL);
			test.fail("<b>Actual Result: </b> View Loans:Find the Best Loan for Me Page was loaded with URL "
					+ ViewLoansCurrentURL + " , Response code :- " + rescode + ", Page Load time in Milliseconds: "
					+ loadTime).addScreenCaptureFromPath(SSpath);

		}

	}

	// Method to verify Find A Loan Officer Page redirect and URL
	public void FindALoanOffVerify(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("InputData");
		retRow = excelObj
				.getRowNum("Verify Contact,Learn More,View Loans and Find A Loan Officer button and their URLs");
		String FindLoanOffURL = excelObj.getCellData(retRow, "MMFindALoanOffURL");
		driver.navigate().back();

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("MMFindALoanOffierEle");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		WebElement FindALoanOffEle = driver.findElement(By.xpath(RetVal));

		startTime = System.currentTimeMillis();
		FindALoanOffEle.click();
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Find A Loan Officer");
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;
		FindLoanOffCurrentURL = driver.getCurrentUrl();
		if (FindLoanOffCurrentURL.equals(FindLoanOffURL))

		{

			String SSpath = UtilObj.SaveScreenshot(driver, "Find a LoanOff");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Find a Loan Officer:Find a Loan Officer Near You Page should be loaded with URL "
							+ FindLoanOffURL);
			test.pass(
					"<b>Actual Result: </b> Find a Loan Officer:Find a Loan Officer Near You Page was loaded with URL "
							+ FindLoanOffCurrentURL + " , Response code :- " + rescode
							+ ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Find a LoanOff");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Find a Loan Officer:Find a Loan Officer Near You Page should be loaded with URL "
							+ FindLoanOffURL);
			test.fail(
					"<b>Actual Result: </b> Find a Loan Officer:Find a Loan Officer Near You Page was not loaded with URL "
							+ FindLoanOffCurrentURL + " , Response code :- " + rescode
							+ ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		}

	}

	// Method to verify Contact Menu page and URL on MM Home Page
	public void ContactVerify(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {
		excelObj.setSheet("InputData");
		retRow = excelObj
				.getRowNum("Verify Contact,Learn More,View Loans and Find A Loan Officer button and their URLs");
		String ContactURL = excelObj.getCellData(retRow, "MMContactURL");

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("Contact");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		startTime = System.currentTimeMillis();
		driver.findElement(By.xpath(RetVal)).click();
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Contact");
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;

		ContactCurrentURL = driver.getCurrentUrl();
		if (ContactURL.equals(ContactCurrentURL)) {

			String SSpath = UtilObj.SaveScreenshot(driver, "Contact");
			test.log(Status.INFO,
					"<b>Expected Result: </b>Contact:The Movement Mortgage Contact Page should be loaded with URL "
							+ ContactURL);
			test.pass("<b>Actual Result: </b> Contact:The Movement Mortgage Contact Page was loaded with URL "
					+ ContactCurrentURL + " , Response code :- " + rescode + ", Page Load time in Milliseconds: "
					+ loadTime).addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Contact");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Contact:The Movement Mortgage Contact Page should be loaded with URL "
							+ ContactURL);
			test.fail("<b>Actual Result: </b> Contact:The Movement Mortgage Contact Page was loaded with URL "
					+ ContactCurrentURL + " , Response code :- " + rescode + ", Page Load time in Milliseconds: "
					+ loadTime).addScreenCaptureFromPath(SSpath);

		}

	}

	// Method for Carousel verification by clicking left arrow

	public void CarouselVerifyRight(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {
		Boolean ArrowBool = true;
		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("MMCarouselNext");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		do {
			((JavascriptExecutor) driver).executeScript("scroll(0,400)");
			ArrowBool = driver.findElement(By.xpath(RetVal)).isDisplayed();
		} while (ArrowBool = false);
		driver.findElement(By.xpath(RetVal)).click();

		retRow = excelObj.getRowNum("MMCarouselTheresaText");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		WebElement ele4 = driver.findElement(By.xpath(RetVal));

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Carousel Right");
		if (ele4.isDisplayed()) {

			String SSpath = UtilObj.SaveScreenshot(driver, "Carousel Right");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Carousel Right: Pressing the Right arrow should move to the slide right side");
			test.pass("<b>Actual Result: </b> Carousel Right: Pressing the Right arrow was moved to the right side"
					+ " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Carousel Right");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Carousel Right: Pressing the Right arrow should move to the slide right side");
			test.fail("<b>Actual Result: </b> Carousel Right: Pressing the Right arrow was not moved to the right side"
					+ " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);
		}
	}

	// Method for Carousel verification by clicking left arrow
	public void CarouselVerifyLeft(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {
		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("MMCarouselPrevious");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		driver.findElement(By.xpath(RetVal)).click();

		retRow = excelObj.getRowNum("MMCarouselAngelaText");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		WebElement AngelaEleme = driver.findElement(By.xpath(RetVal));
		// String expectext1 = AngelaEleme.getText();
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Carousel Left");
		if (AngelaEleme.isDisplayed()) {

			String SSpath = UtilObj.SaveScreenshot(driver, "Carousel Left");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Carousel Left: Pressing the Left arrow should move to the slide left side");
			test.pass("<b>Actual Result: </b> Carousel Left: Pressing the Left arrow was moved to the left side"
					+ " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Carousel Left");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Carousel Left: Pressing the Left arrow should move to the slide left side");
			test.fail("<b>Actual Result: </b> Carousel Left: Pressing the Left arrow was not moved to the left side"
					+ " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);
		}

	}

	// Method to verify image enlargement by clicking small images on right side

	public void ImageEnlargement(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws InterruptedException, IOException {
		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("MMHeaderLogo");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		driver.findElement(By.xpath(RetVal)).click();

		retRow = excelObj.getRowNum("MMEnlargeImage2Actual");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		WebElement actualImg = driver.findElement(By.xpath(RetVal));
		actualImg.click();
		Thread.sleep(3000);

		retRow = excelObj.getRowNum("MMEnlargeImage2Expected");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		WebElement expectedImg = driver.findElement(By.xpath(RetVal));

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Image Enlarge");
		if (expectedImg.isDisplayed()) {

			String SSpath = UtilObj.SaveScreenshot(driver, "Image Enlarge");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Image Enlarge: The enlarge version of the selected picture(Highlighted red) should get displayed in the middle ");
			test.pass(
					"<b>Actual Result: </b> Image Enlarge: The enlarge version of the selected picture(Highlighted red) was displayed in the middle"
							+ " , Response code :- " + rescode)
					.addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Image Enlarge");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Image Enlarge: The enlarge version of the selected picture(Highlighted red) should get displayed in the middle");
			test.fail(
					"<b>Actual Result: </b> Image Enlarge: The enlarge version of the selected picture(Highlighted red) wsa not displayed in the middle"
							+ " , Response code :- " + rescode)
					.addScreenCaptureFromPath(SSpath);
		}

	}

	// ********************* lo.movement.com URL 2 scenario verification Method
	// definition *************************

	public void LoanOfficerMMLogoverification(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {
		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("LOMMLogo");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		By LOMMLogo = By.xpath(RetVal);

		Boolean DisplayLoMMLogo = driver.findElement(LOMMLogo).isDisplayed();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "LO MM Logo");
		if (DisplayLoMMLogo) {
			String SSpath = UtilObj.SaveScreenshot(driver, "LO MM Logo");

			test.log(Status.INFO,
					"<b>Expected Result: </b> Movement Mortgage Logo on Loan Officer page Should be present");
			test.pass("<b>Actual Result: </b> Movement Mortgage Logo on Loan Officer page was present"
					+ " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "LO MM Logo");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Movement Mortgage Logo on Loan Officer page Should be present");
			test.fail("<b>Actual Result: </b> Movement Mortgage Logo on Loan Officer page was not present"
					+ " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);
		}
	}

	// Method to verify Loan Officer picture on the home page
	public void LoanOfficerPictureVerification(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {
		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("LOPeteGriffinPicture");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		Boolean DisplayLoPicture = driver.findElement(By.xpath(RetVal)).isDisplayed();
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "LO Picture");

		if (DisplayLoPicture) {
			String SSpath = UtilObj.SaveScreenshot(driver, "LO Picture");

			test.log(Status.INFO,
					"<b>Expected Result: </b>Loan Officer Pete Griffin picture Should be present beside the MM Logo");
			test.pass("<b>Actual Result: </b> Loan Officer Pete Griffin picture was present beside the MM Logo"
					+ " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "LO Picture");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Loan Officer Pete Griffin picture Should be present beside the MM Logo");
			test.fail("<b>Actual Result: </b> Loan Officer Pete Griffin picture was not present beside the MM Logo"
					+ " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);
		}

	}

	// Method to verify Loan Officer three Menus on the home page
	public void LoanOfficerMenuVerification(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {
		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("AboutPete");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		Boolean DisplayAboutLO = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("FindMyMortgage");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayFindMyMortgage = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("FreeTools");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayFreeTools = driver.findElement(By.xpath(RetVal)).isDisplayed();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "LO Menus");
		if (DisplayAboutLO && DisplayFindMyMortgage && DisplayFreeTools) {
			String SSpath = UtilObj.SaveScreenshot(driver, "LO Menus");

			test.log(Status.INFO,
					"<b>Expected Result: </b>Loan Officer three Menus: About Pete,Find My Mortgage and Free Tools Should be present");
			test.pass(
					"<b>Actual Result: </b> Loan Officer three Menus: About Pete,Find My Mortgage and Free Tools was present"
							+ " , Response code :- " + rescode)
					.addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "LO Menus");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Loan Officer three Menus: About Pete,Find My Mortgage and Free Tools Should be present");
			test.fail(
					"<b>Actual Result: </b> Loan Officer three Menus: About Pete,Find My Mortgage and Free Tools were not present"
							+ " , Response code :- " + rescode)
					.addScreenCaptureFromPath(SSpath);
		}
	}

	// Method to verify Start My Application button and Navigated URL
	public void startMyApplicationVerification(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("InputData");
		retRow = excelObj.getRowNum("Verify Start My Application");
		String LOStartMyApplicationExpURL = excelObj.getCellData(retRow, "LOMMStartMyAppURL");

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("StartMyApplication");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayStartMyApp = driver.findElement(By.xpath(RetVal)).isDisplayed();

		if (DisplayStartMyApp) {

			String originalHandle = driver.getWindowHandle();

			startTime = System.currentTimeMillis();
			driver.findElement(By.xpath(RetVal)).click();
			rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Start My Application");
			endTime = System.currentTimeMillis();
			loadTime = endTime - startTime;

			Set<String> currentPageHandles = driver.getWindowHandles();
			boolean myNewTabFound = false;

			for (String handle : currentPageHandles) {
				if (!handle.equals(originalHandle)) {
					driver.switchTo().window(handle);
					myNewTabFound = true;
				}

			}

			if (myNewTabFound) {
				LOStartMyApplicationActURL = driver.getCurrentUrl();
			}

			// rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Start My
			// Application");

			if (LOStartMyApplicationActURL.contains(LOStartMyApplicationExpURL)) {
				String SSpath = UtilObj.SaveScreenshot(driver, "Start My Application");
				test.log(Status.INFO,
						"<b>Expected Result: </b>Click Start My Application:New page should be loaded with URL "
								+ LOStartMyApplicationExpURL);
				test.pass("<b>Actual Result: </b> Click Start My Application:New page was loaded with URL "
						+ LOStartMyApplicationActURL + " , Response code :- " + rescode
						+ ", Page Load time in Milliseconds: " + loadTime).addScreenCaptureFromPath(SSpath);

			} else {
				String SSpath = UtilObj.SaveScreenshot(driver, "Start My Application");
				test.log(Status.INFO,
						"<b>Expected Result: </b>Click Start My Application:New page should be loaded with URL "
								+ LOStartMyApplicationExpURL);
				test.fail("<b>Actual Result: </b> Click Start My Application:New page was loaded with URL "
						+ LOStartMyApplicationActURL + " , Response code :- " + rescode
						+ ", Page Load time in Milliseconds: " + loadTime).addScreenCaptureFromPath(SSpath);
			}

		}

	}

	public void AboutMeVerification(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {
		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("AboutPete");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		driver.findElement(By.xpath(RetVal)).click();

		retRow = excelObj.getRowNum("LOMM_AboutMe");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayAboutMe = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_OnTheMove");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayOnTheMove = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_ContactMe");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayContactMe = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_Blog");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayBlog = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_Reviews");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayReviews = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_Purchase");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayPurchase = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_Refinance");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayRefinance = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_FindALoan");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayFindALoan = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_AffordCalculator");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayAffordCalculator = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_MortgageCalculator");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayMortgageCalculator = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_RefinanceCalculator");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayRefinanceCalculator = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_FAQ");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayFAQ = driver.findElement(By.xpath(RetVal)).isDisplayed();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "About Pete Menu");

		if (DisplayAboutMe && DisplayOnTheMove && DisplayContactMe && DisplayBlog && DisplayReviews && DisplayPurchase
				&& DisplayRefinance && DisplayFindALoan && DisplayAffordCalculator && DisplayMortgageCalculator
				&& DisplayRefinanceCalculator && DisplayFAQ) {
			String SSpath = UtilObj.SaveScreenshot(driver, "About Pete Menu");
			test.log(Status.INFO,
					"<b>Expected Result: </b>About Pete Menu:Sub Menu Should be displayed(About Me,On The Move,Contact Me,Blog,Reviews,Purchase,Refinance,Find A Loan,Affordability Calculator,Mortgage Payment Calculator,Refinance Calculator,FAQs)");
			test.pass(
					"<b>Actual Result: </b>About Me Menu:Sub Menu was displayed(About Me,On The Move,Contact Me,Blog,Reviews,Purchase,Refinance,Find A Loan,Affordability Calculator,Mortgage Payment Calculator,Refinance Calculator,FAQs)"
							+ " , Response code :- " + rescode)
					.addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "About Pete Menu");
			test.log(Status.INFO,
					"<b>Expected Result: </b>About Me Menu:Sub Menu Should be displayed(About Me,On The Move,Contact Me,Blog,Reviews,Purchase,Refinance,Find A Loan,Affordability Calculator,Mortgage Payment Calculator,Refinance Calculator,FAQs)");
			test.fail(
					"<b>Actual Result: </b>About Pete Menu:Sub Menu was not displayed(About Me,On The Move,Contact Me,Blog,Reviews,Purchase,Refinance,Find A Loan,Affordability Calculator,Mortgage Payment Calculator,Refinance Calculator,FAQs)"
							+ " , Response code :- " + rescode)
					.addScreenCaptureFromPath(SSpath);

		}
	}

	public void FindMyMortgageVerification(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("FindMyMortgage");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		driver.findElement(By.xpath(RetVal)).click();

		retRow = excelObj.getRowNum("LOMM_AboutMe");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayAboutMe = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_OnTheMove");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayOnTheMove = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_ContactMe");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayContactMe = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_Blog");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayBlog = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_Reviews");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayReviews = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_Purchase");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayPurchase = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_Refinance");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayRefinance = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_FindALoan");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayFindALoan = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_AffordCalculator");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayAffordCalculator = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_MortgageCalculator");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayMortgageCalculator = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_RefinanceCalculator");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayRefinanceCalculator = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_FAQ");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayFAQ = driver.findElement(By.xpath(RetVal)).isDisplayed();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Find My Mortgage");

		if (DisplayAboutMe && DisplayOnTheMove && DisplayContactMe && DisplayBlog && DisplayReviews && DisplayPurchase
				&& DisplayRefinance && DisplayFindALoan && DisplayAffordCalculator && DisplayMortgageCalculator
				&& DisplayRefinanceCalculator && DisplayFAQ) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Find My Mortgage");
			test.log(Status.INFO,
					"<b>Expected Result: </b>Find My Mortgage Menu:Sub Menu Should be displayed(About Me,On The Move,Contact Me,Blog,Reviews,Purchase,Refinance,Find A Loan,Affordability Calculator,Mortgage Payment Calculator,Refinance Calculator,FAQs)");
			test.pass(
					"<b>Actual Result: </b>Find My Mortgage Menu:Sub Menu was displayed(About Me,On The Move,Contact Me,Blog,Reviews,Purchase,Refinance,Find A Loan,Affordability Calculator,Mortgage Payment Calculator,Refinance Calculator,FAQs)"
							+ " , Response code :- " + rescode)
					.addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Find My Mortgage Menu");
			test.log(Status.INFO,
					"<b>Expected Result: </b>Find My Mortgage Menu:Sub Menu Should be displayed(About Me,On The Move,Contact Me,Blog,Reviews,Purchase,Refinance,Find A Loan,Affordability Calculator,Mortgage Payment Calculator,Refinance Calculator,FAQs)");
			test.fail(
					"<b>Actual Result: </b>Find My Mortgage Menu:Sub Menu was not displayed(About Me,On The Move,Contact Me,Blog,Reviews,Purchase,Refinance,Find A Loan,Affordability Calculator,Mortgage Payment Calculator,Refinance Calculator,FAQs)"
							+ " , Response code :- " + rescode)
					.addScreenCaptureFromPath(SSpath);

		}
	}

	public void FreeToolsVerification(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {
		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("FreeTools");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		driver.findElement(By.xpath(RetVal)).click();

		retRow = excelObj.getRowNum("LOMM_AboutMe");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayAboutMe = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_OnTheMove");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayOnTheMove = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_ContactMe");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayContactMe = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_Blog");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayBlog = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_Reviews");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayReviews = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_Purchase");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayPurchase = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_Refinance");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayRefinance = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_FindALoan");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayFindALoan = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_AffordCalculator");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayAffordCalculator = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_MortgageCalculator");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayMortgageCalculator = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_RefinanceCalculator");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayRefinanceCalculator = driver.findElement(By.xpath(RetVal)).isDisplayed();

		retRow = excelObj.getRowNum("LOMM_FAQ");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		Boolean DisplayFAQ = driver.findElement(By.xpath(RetVal)).isDisplayed();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Free Tools Menu");
		if (DisplayAboutMe && DisplayOnTheMove && DisplayContactMe && DisplayBlog && DisplayReviews && DisplayPurchase
				&& DisplayRefinance && DisplayFindALoan && DisplayAffordCalculator && DisplayMortgageCalculator
				&& DisplayRefinanceCalculator && DisplayFAQ) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Free Tools Menu");
			test.log(Status.INFO,
					"<b>Expected Result: </b>Free Tools Menu:Sub Menu Should be displayed(About Me,On The Move,Contact Me,Blog,Reviews,Purchase,Refinance,Find A Loan,Affordability Calculator,Mortgage Payment Calculator,Refinance Calculator,FAQs)");
			test.pass(
					"<b>Actual Result: </b>Free Tools Menu:Sub Menu was displayed(About Me,On The Move,Contact Me,Blog,Reviews,Purchase,Refinance,Find A Loan,Affordability Calculator,Mortgage Payment Calculator,Refinance Calculator,FAQs)"
							+ " , Response code :- " + rescode)
					.addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Free Tools Menu");
			test.log(Status.INFO,
					"<b>Expected Result: </b>Free Tools Menu:Sub Menu Should be displayed(About Me,On The Move,Contact Me,Blog,Reviews,Purchase,Refinance,Find A Loan,Affordability Calculator,Mortgage Payment Calculator,Refinance Calculator,FAQs)");
			test.fail(
					"<b>Actual Result: </b>Free Tools Menu:Sub Menu was not displayed(About Me,On The Move,Contact Me,Blog,Reviews,Purchase,Refinance,Find A Loan,Affordability Calculator,Mortgage Payment Calculator,Refinance Calculator,FAQs)"
							+ " , Response code :- " + rescode)
					.addScreenCaptureFromPath(SSpath);

		}
	}

	public void GoCalculatorVerification(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException, InterruptedException {
		excelObj.setSheet("InputData");
		retRow = excelObj.getRowNum("Verify Redirecton of web page");
		String LOGoCalculatorExpURL = excelObj.getCellData(retRow, "LOMMGoCalculatorURL");
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("LOMM_GoCalculator");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		startTime = System.currentTimeMillis();
		driver.findElement(By.xpath(RetVal)).click();
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Go Calculator");
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;

		LOGoCalculatorActURL = driver.getCurrentUrl();

		if (LOGoCalculatorActURL.equals(LOGoCalculatorExpURL)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Go Calculator");
			test.log(Status.INFO,
					"<b>Expected Result: </b>Go Calculator:Affordability Calculator page should be loaded with URL "
							+ LOGoCalculatorExpURL);
			test.pass("<b>Actual Result: </b> Go Calculator:Affordability Calculator page was loaded with URL "
					+ LOGoCalculatorActURL + " , Response code :- " + rescode + ", Page Load time in Milliseconds: "
					+ loadTime).addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Go Calculator");
			test.log(Status.INFO,
					"<b>Expected Result: </b>Go Calculator:Affordability Calculator page should be loaded with URL "
							+ LOGoCalculatorExpURL);
			test.fail("<b>Actual Result: </b> Go Calculator:New page was loaded with URL " + LOGoCalculatorActURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		}

	}

	public void LOFindALoanVerification(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {
		excelObj.setSheet("InputData");
		retRow = excelObj.getRowNum("Verify Redirecton of web page");
		String LOFindALoanButtonExpURL = excelObj.getCellData(retRow, "LOMMFindALoanURL");
		driver.navigate().back();

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("LOMM_FindALoanButton");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		startTime = System.currentTimeMillis();
		driver.findElement(By.xpath(RetVal)).click();
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Find A Loan");
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;

		LOFindALoanButtonActURL = driver.getCurrentUrl();

		if (LOFindALoanButtonActURL.equals(LOFindALoanButtonExpURL)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Find A Loan");
			test.log(Status.INFO, "<b>Expected Result: </b>Find A Loan:Find A Loan page should be loaded with URL "
					+ LOFindALoanButtonExpURL);
			test.pass(
					"<b>Actual Result: </b> Find A Loan:Find A Loan page was loaded with URL " + LOFindALoanButtonActURL
							+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Find A Loan");
			test.log(Status.INFO, "<b>Expected Result: </b>Find A Loan:Find A Loan page should be loaded with URL "
					+ LOFindALoanButtonExpURL);
			test.fail("<b>Actual Result: </b> Find A Loan:New page was loaded with URL " + LOFindALoanButtonActURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		}

	}

	public void PayMyMortgageVerification(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {
		excelObj.setSheet("InputData");
		retRow = excelObj.getRowNum("Verify Redirecton of web page");
		String LOGoPayMyMortgageExpURL = excelObj.getCellData(retRow, "LOMMPayMyMortgageURL");
		driver.navigate().back();

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("LOMM_PayMyMortgage");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		startTime = System.currentTimeMillis();
		driver.findElement(By.xpath(RetVal)).click();
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Pay My Mortgage");
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;
		LOGoPayMyMortgageActURL = driver.getCurrentUrl();

		if (LOGoPayMyMortgageActURL.equals(LOGoPayMyMortgageExpURL)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Pay My Mortgage");
			test.log(Status.INFO,
					"<b>Expected Result: </b>Pay My Mortgage:Welcome to the Movement Family page should be loaded with URL "
							+ LOGoPayMyMortgageExpURL);
			test.pass(
					"<b>Actual Result: </b> Pay My Mortgage:Welcome to the Movement Family page should be loaded with URL "
							+ LOGoPayMyMortgageActURL + " , Response code :- " + rescode
							+ ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Pay My Mortgage");
			test.log(Status.INFO,
					"<b>Expected Result: </b>Pay My Mortgage:Welcome to the Movement Family page should be loaded with URL "
							+ LOGoPayMyMortgageExpURL);
			test.fail("<b>Actual Result: </b> Pay My Mortgage:New page was loaded with URL " + LOGoPayMyMortgageActURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		}

	}

	// Market Update page redirect and URL verification method
	public void MarketUpdateVerification(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException, InterruptedException {
		excelObj.setSheet("InputData");
		retRow = excelObj.getRowNum("Verify Redirecton of web page");
		String LOMarketUpdateExpURL = excelObj.getCellData(retRow, "LOMMMarketUpdateURL");
		Thread.sleep(2000);

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("LOMMLogo");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		driver.findElement(By.xpath(RetVal)).click();
		retRow = excelObj.getRowNum("LOMM_MoreFaq");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		By LOMM_MoreFaq = By.xpath(RetVal);

		UtilObj.scrollDowbUntillElementExists(driver, LOMM_MoreFaq);

		String originalHandle = driver.getWindowHandle();

		retRow = excelObj.getRowNum("LOMM_MarketUpdate");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		startTime = System.currentTimeMillis();
		driver.findElement(By.xpath(RetVal)).click();
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Market Update");
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;
		Set<String> currentPageHandles = driver.getWindowHandles();
		boolean myNewTabFound = false;

		for (String handle : currentPageHandles) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				myNewTabFound = true;
			}

		}

		if (myNewTabFound) {
			LOMarketUpdateActURL = driver.getCurrentUrl();
		}

		if (LOMarketUpdateActURL.equals(LOMarketUpdateExpURL)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Market Update");
			test.log(Status.INFO, "<b>Expected Result: </b>Market Update:Market Update Page should be loaded with URL "
					+ LOMarketUpdateExpURL);
			test.pass("<b>Actual Result: </b> Market Update:Market Update Page was loaded with URL "
					+ LOMarketUpdateActURL + " , Response code :- " + rescode + ", Page Load time in Milliseconds: "
					+ loadTime).addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Market Update");
			test.log(Status.INFO, "<b>Expected Result: </b> Market Update:Market Update Page should be loaded with URL "
					+ LOMarketUpdateExpURL);
			test.fail("<b>Actual Result: </b> Market Update::New Page was loaded with URL " + LOMarketUpdateActURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		}

		driver.switchTo().window(originalHandle);
		Thread.sleep(2000);
		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("LOMMLogo");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		driver.findElement(By.xpath(RetVal)).click();

	}

	// Movement Newsroom page redirect and URL verification method
	public void MovementNewsRoomVerification(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException, InterruptedException {
		excelObj.setSheet("InputData");
		retRow = excelObj.getRowNum("Verify Redirecton of web page");
		String LOMMNewsRoomExpURL = excelObj.getCellData(retRow, "LOMMNewsRoomURL");
		Thread.sleep(2000);

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("LOMMLogo");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		driver.findElement(By.xpath(RetVal)).click();

		retRow = excelObj.getRowNum("LOMM_MoreFaq");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		By LOMM_MoreFaq = By.xpath(RetVal);

		UtilObj.scrollDowbUntillElementExists(driver, LOMM_MoreFaq);

		String originalHandle = driver.getWindowHandle();

		retRow = excelObj.getRowNum("LOMM_MovementNewsRoom");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		startTime = System.currentTimeMillis();
		driver.findElement(By.xpath(RetVal)).click();
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Movement NewsRoom");
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;
		Set<String> currentPageHandles = driver.getWindowHandles();
		boolean myNewTabFound = false;

		for (String handle : currentPageHandles) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				myNewTabFound = true;
			}

		}

		if (myNewTabFound) {
			LOMovementNewsRoomActURL = driver.getCurrentUrl();
		}

		if (LOMovementNewsRoomActURL.equals(LOMMNewsRoomExpURL)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Movement NewsRoom");
			test.log(Status.INFO,
					"<b>Expected Result: </b>Movement NewsRoom :Movement NewsRoom Page should be loaded with URL "
							+ LOMMNewsRoomExpURL);
			test.pass("<b>Actual Result: </b> Movement NewsRoom :Movement NewsRoom Page was loaded with URL "
					+ LOMovementNewsRoomActURL + " , Response code :- " + rescode + ", Page Load time in Milliseconds: "
					+ loadTime).addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Movement NewsRoom");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Movement NewsRoom :Market Update Page should be loaded with URL "
							+ LOMMNewsRoomExpURL);
			test.fail("<b>Actual Result: </b> Movement NewsRoom ::New Page was loaded with URL "
					+ LOMovementNewsRoomActURL + " , Response code :- " + rescode + ", Page Load time in Milliseconds: "
					+ loadTime).addScreenCaptureFromPath(SSpath);
		}

		driver.switchTo().window(originalHandle);
//									
	}

	public void MoreFAQsVerification(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException, InterruptedException {
		excelObj.setSheet("InputData");
		retRow = excelObj.getRowNum("Verify Redirecton of web page");
		String LOMoreFAQExpURL = excelObj.getCellData(retRow, "LOMMMoreFaqURL");
		Thread.sleep(2000);

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("LOMMLogo");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		driver.findElement(By.xpath(RetVal)).click();

		retRow = excelObj.getRowNum("LOMM_TenYearsPlay");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		By LOMMtenplay = By.xpath(RetVal);

		UtilObj.scrollDowbUntillElementExists(driver, LOMMtenplay);

		retRow = excelObj.getRowNum("LOMM_ClosePeteBottomPopUp");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		driver.findElement(By.xpath(RetVal)).click();
		Thread.sleep(2000);

		retRow = excelObj.getRowNum("LOMM_MoreFaq");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		startTime = System.currentTimeMillis();
		driver.findElement(By.xpath(RetVal)).click();
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "More FAQs");
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;

		LOMoreFAQActURL = driver.getCurrentUrl();
		Thread.sleep(2000);
		if (LOMoreFAQExpURL.equals(LOMoreFAQActURL)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "More FAQs");
			test.log(Status.INFO,
					"<b>Expected Result: </b>More FAQs :More FAQs Page should be loaded with URL " + LOMoreFAQExpURL);
			test.pass("<b>Actual Result: </b> More FAQs: New Page was loaded with URL " + LOMoreFAQActURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "More FAQs");
			test.log(Status.INFO,
					"<b>Expected Result: </b> More FAQs :More FAQs Page should be loaded with URL " + LOMoreFAQExpURL);
			test.fail("<b>Actual Result: </b> More FAQs: New Page was loaded with URL " + LOMoreFAQActURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		}

	}

	// Method to verify MM Social Media Twitter web page launch

	public void MMTwitterVerification(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException, InterruptedException {

		excelObj.setSheet("InputData");
		retRow = excelObj.getRowNum("Verify Social Media webpages");
		MMTwitterExpURL = excelObj.getCellData(retRow, "MMTwitterExpURL");
		Thread.sleep(2000);

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("LOMM_TenYearsPlay");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		By LOMMtenplay = By.xpath(RetVal);

		UtilObj.scrollDowbUntillElementExists(driver, LOMMtenplay);

		String originalHandle = driver.getWindowHandle();

		retRow = excelObj.getRowNum("LOMM_Twitterlogo");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		// driver.findElement(By.xpath(RetVal)).click();

		startTime = System.currentTimeMillis();
		driver.findElement(By.xpath(RetVal)).click();
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "MM Twitter");
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;

		Thread.sleep(5000);
		// rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "MM Twitter");
		Set<String> currentPageHandles = driver.getWindowHandles();
		boolean myNewTabFound = false;

		for (String handle : currentPageHandles) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				myNewTabFound = true;
			}

		}

		if (myNewTabFound) {
			MMTwitterActURL = driver.getCurrentUrl();
		}

		if (MMTwitterActURL.equals(MMTwitterExpURL)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "MM Twitter");
			test.log(Status.INFO, "<b>Expected Result: </b>Twitter Page:MM twitter Page should be loaded with URL "
					+ MMTwitterExpURL);
			test.pass("<b>Actual Result: </b> Twitter Page:MM twitter Page was loaded with URL " + MMTwitterActURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "MM Twitter");
			test.log(Status.INFO, "<b>Expected Result: </b>Twitter Page:MM twitter Page should be loaded with URL "
					+ MMTwitterExpURL);
			test.fail("<b>Actual Result: </b> Twitter Page:New Page was loaded with URL " + MMTwitterActURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		}
		driver.switchTo().window(originalHandle);
		Thread.sleep(2000);

	}

	// Method to verify MM Social Media Instagram web page launch

	public void MMInstagramVerification(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException, InterruptedException {

		excelObj.setSheet("InputData");
		retRow = excelObj.getRowNum("Verify Social Media webpages");
		MMInstagramExpURL = excelObj.getCellData(retRow, "MMInstagramExpURL");
		Thread.sleep(2000);

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("LOMM_Instagramlogo");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		String originalHandle = driver.getWindowHandle();
		driver.switchTo().window(originalHandle);

		startTime = System.currentTimeMillis();
		driver.findElement(By.xpath(RetVal)).click();
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "MM Instagram");
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;

		Thread.sleep(5000);
		// rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "MM Instagram");
		Set<String> currentPageHandles = driver.getWindowHandles();
		boolean myNewTabFound = false;

		for (String handle : currentPageHandles) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				myNewTabFound = true;
			}

		}

		if (myNewTabFound) {
			MMInstagramActURL = driver.getCurrentUrl();
		}

		if (MMInstagramActURL.equals(MMInstagramExpURL)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "MM Instagram");
			test.log(Status.INFO, "<b>Expected Result: </b>Twitter Page:MM twitter Page should be loaded with URL "
					+ MMInstagramExpURL);
			test.pass("<b>Actual Result: </b> Twitter Page:MM twitter Page was loaded with URL " + MMInstagramActURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "MM Instagram");
			test.log(Status.INFO, "<b>Expected Result: </b>Twitter Page:MM twitter Page should be loaded with URL "
					+ MMInstagramExpURL);
			test.fail("<b>Actual Result: </b> Twitter Page:New Page was loaded with URL " + MMInstagramActURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		}
		driver.switchTo().window(originalHandle);
		Thread.sleep(2000);
	}

	// Method to verify MM Social Media FaceBook web page launch

	public void MMFacebookVerification(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException, InterruptedException {

		excelObj.setSheet("InputData");
		retRow = excelObj.getRowNum("Verify Social Media webpages");
		MMFacebookExpURL = excelObj.getCellData(retRow, "MMFacebookExpURL");
		Thread.sleep(2000);

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("LOMM_Facebooklogo");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		String originalHandle = driver.getWindowHandle();
		driver.switchTo().window(originalHandle);
		startTime = System.currentTimeMillis();
		driver.findElement(By.xpath(RetVal)).click();
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "MM Facebook");
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;
		Thread.sleep(5000);

		Set<String> currentPageHandles = driver.getWindowHandles();
		boolean myNewTabFound = false;

		for (String handle : currentPageHandles) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				myNewTabFound = true;
			}

		}

		if (myNewTabFound) {
			MMFacebookActURL = driver.getCurrentUrl();
		}

		if (MMFacebookActURL.equals(MMFacebookExpURL)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "MM Facebook");
			test.log(Status.INFO, "<b>Expected Result: </b>MM Facebook Page:MM Facebook Page should be loaded with URL "
					+ MMFacebookExpURL);
			test.pass(
					"<b>Actual Result: </b> MM Facebook Page:MM Facebook Page  was loaded with URL " + MMFacebookActURL
							+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "MM Facebook");
			test.log(Status.INFO, "<b>Expected Result: </b>MM Facebook Page:MM Facebook Page should be loaded with URL "
					+ MMFacebookExpURL);
			test.fail("<b>Actual Result: </b> MM Facebook Page:New Page  was loaded with URL " + MMFacebookActURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		}
		driver.switchTo().window(originalHandle);
		Thread.sleep(2000);
	}
	// Method to verify MM Social Media LinkedIn web page launch

	public void MMLinkedInVerification(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException, InterruptedException {

		excelObj.setSheet("InputData");
		retRow = excelObj.getRowNum("Verify Social Media webpages");
		MMLinkedInExpURL = excelObj.getCellData(retRow, "MMLinkedInExpURL");
		Thread.sleep(2000);

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("LOMM_LinkedInlogo");
		RetVal = excelObj.getCellData(retRow, "Xpath");

		String originalHandle = driver.getWindowHandle();
		driver.switchTo().window(originalHandle);
		startTime = System.currentTimeMillis();
		driver.findElement(By.xpath(RetVal)).click();
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "MM LinkedIn");
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;
		Thread.sleep(5000);
		// rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "MM LinkedIn");
		Set<String> currentPageHandles = driver.getWindowHandles();
		boolean myNewTabFound = false;

		for (String handle : currentPageHandles) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				myNewTabFound = true;
			}

		}

		if (myNewTabFound) {
			MMLinkedInActURL = driver.getCurrentUrl();
		}

		if (MMLinkedInActURL.contains(MMLinkedInExpURL))

		{
			String SSpath = UtilObj.SaveScreenshot(driver, "MM LinkedIn");
			test.log(Status.INFO,
					"<b>Expected Result: </b>LinkedIn Page:MM LinkedIn Page should be loaded with Base URL "
							+ MMLinkedInExpURL);
			test.pass("<b>Actual Result: </b> LinkedIn Page:MM LinkedIn Page was loaded with URL " + MMLinkedInActURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "MM LinkedIn");
			test.log(Status.INFO,
					"<b>Expected Result: </b>LinkedIn Page:MM LinkedIn Page should be loaded with Base URL "
							+ MMLinkedInExpURL);
			test.fail("<b>Actual Result: </b> LinkedIn Page:New Page was loaded with URL " + MMLinkedInActURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		}
		driver.switchTo().window(originalHandle);
		Thread.sleep(2000);
	}

	// Method to verify MM Social Media YouTube web page launch

	public void MMYoutubeVerification(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException, InterruptedException {
		String MMYoutubeExpURL = "https://www.youtube.com/channel/UCLJmPes0FZeXOJ3xUfag9sA";
		try {
			excelObj.setSheet("InputData");
			retRow = excelObj.getRowNum("Verify Social Media webpages");
			MMYoutubeExpURL = excelObj.getCellData(retRow, "MMYoutubeExpURL");
			Thread.sleep(2000);

			excelObj.setSheet("Xpath");
			retRow = excelObj.getRowNum("LOMM_Youtubelogo");
			RetVal = excelObj.getCellData(retRow, "Xpath");

			String originalHandle = driver.getWindowHandle();
			driver.switchTo().window(originalHandle);
			startTime = System.currentTimeMillis();
			driver.findElement(By.xpath(RetVal)).click();
			rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "MM Youtube");
			endTime = System.currentTimeMillis();
			loadTime = endTime - startTime;
			Thread.sleep(5000);
			// rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "MM Youtube");
			Set<String> currentPageHandles = driver.getWindowHandles();
			boolean myNewTabFound = false;

			for (String handle : currentPageHandles) {
				if (!handle.equals(originalHandle)) {
					driver.switchTo().window(handle);
					myNewTabFound = true;
				}

			}

			if (myNewTabFound) {
				MMYouTubeActURL = driver.getCurrentUrl();
			}

			if (MMYouTubeActURL.equals(MMYoutubeExpURL)) {
				String SSpath = UtilObj.SaveScreenshot(driver, "MM YouTube");
				test.log(Status.INFO, "<b>Expected Result: </b>YouTube Page:MM Youtube Page should be loaded with URL "
						+ MMYoutubeExpURL);
				test.pass("<b>Actual Result: </b> YouTube Page:MM YouTube Page was loaded with URL " + MMYouTubeActURL
						+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
						.addScreenCaptureFromPath(SSpath);

			} else {
				String SSpath = UtilObj.SaveScreenshot(driver, "MM YouTube");
				test.log(Status.INFO, "<b>Expected Result: </b>YouTube Page:MM YouTube Page should be loaded with URL "
						+ MMYoutubeExpURL);
				test.fail("<b>Actual Result: </b> YouTube Page:New Page was loaded with URL " + MMYouTubeActURL
						+ " , Response code :- " + rescode + ", Page Load time in Milliseconds: " + loadTime)
						.addScreenCaptureFromPath(SSpath);
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			driver.close();
		}

	}

	// Method to verify Moved By Love play video
	public void MovedByLoveVerification(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException, InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,1200)");
		try {
			excelObj.setSheet("Xpath");
			retRow = excelObj.getRowNum("LOMM_MovedByLovePlay");
			RetVal = excelObj.getCellData(retRow, "Xpath");

			driver.findElement(By.xpath(RetVal)).click();

			retRow = excelObj.getRowNum("LOMM_VideoPopUpClose");
			RetVal = excelObj.getCellData(retRow, "Xpath");
			Boolean DisplayLovedByPop = driver.findElement(By.xpath(RetVal)).isDisplayed();
			Thread.sleep(2000);

			rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Moved By Love");
			if (DisplayLovedByPop) {
				String SSpath = UtilObj.SaveScreenshot(driver, "Moved By Love");
				test.log(Status.INFO, "<b>Expected Result: </b> Moved By Love POP up video Should be present");
				test.pass("<b>Actual Result: </b> Moved By Love POP up video was present" + " , Response code :- "
						+ rescode).addScreenCaptureFromPath(SSpath);

			} else {
				String SSpath = UtilObj.SaveScreenshot(driver, "Moved By Love");
				test.log(Status.INFO, "<b>Expected Result: </b> Moved By Love POP up video Should be present");
				test.fail("<b>Actual Result: </b> Moved By Love POP up video was not present" + " , Response code :- "
						+ rescode).addScreenCaptureFromPath(SSpath);
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	// Method to verify Ten Year Anniversary video play
	public void TenYearAnniversaryVerification(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException, InterruptedException {

		try {
			excelObj.setSheet("Xpath");
			retRow = excelObj.getRowNum("LOMM_VideoPopUpClose");
			RetVal = excelObj.getCellData(retRow, "Xpath");

			driver.findElement(By.xpath(RetVal)).click();

			retRow = excelObj.getRowNum("LOMMLogo");
			RetVal = excelObj.getCellData(retRow, "Xpath");
			driver.findElement(By.xpath(RetVal)).click();

			retRow = excelObj.getRowNum("LOMM_TenYearsPlay");
			RetVal = excelObj.getCellData(retRow, "Xpath");
			By LOMMtenplay = By.xpath(RetVal);

			UtilObj.scrollDowbUntillElementExists(driver, LOMMtenplay);

			retRow = excelObj.getRowNum("LOMM_ClosePeteBottomPopUp");
			RetVal = excelObj.getCellData(retRow, "Xpath");
			driver.findElement(By.xpath(RetVal)).click();
			Thread.sleep(5000);

			retRow = excelObj.getRowNum("LOMM_TenYearWatchVideo");
			RetVal = excelObj.getCellData(retRow, "Xpath");
			driver.findElement(By.xpath(RetVal)).click();
			Thread.sleep(2000);

			retRow = excelObj.getRowNum("LOMM_VideoPopUpClose");
			RetVal = excelObj.getCellData(retRow, "Xpath");
			Boolean DisplayTenYearAnniPop = driver.findElement(By.xpath(RetVal)).isDisplayed();
			Thread.sleep(2000);

			rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Movement Ten Year Anniversary");
			if (DisplayTenYearAnniPop) {
				String SSpath = UtilObj.SaveScreenshot(driver, "Movement Ten Year Anniversary");
				test.log(Status.INFO,
						"<b>Expected Result: </b> Movement Ten Year Anniversary POP up video Should be present");
				test.pass("<b>Actual Result: </b> Movement Ten Year Anniversary POP up video was present"
						+ " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);

			} else {
				String SSpath = UtilObj.SaveScreenshot(driver, "Movement Ten Year Anniversary");
				test.log(Status.INFO,
						"<b>Expected Result: </b> Movement Ten Year Anniversary POP up video Should be present");
				test.fail("<b>Actual Result: </b> Movement Ten Year Anniversary POP up video was not present"
						+ " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);
			}
			driver.findElement(By.xpath(RetVal)).click();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			driver.close();
		}
	}

	// Method to verify Contact Form play
	public void ContactLOVerification(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException, InterruptedException {

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("LOMM_FirstName");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		By LOMMtFirstName = By.xpath(RetVal);

		UtilObj.scrollDowbUntillElementExists(driver, LOMMtFirstName);

		excelObj.setSheet("InputData");
		retRow = excelObj.getRowNum("Verify contact form");
		FieldValue = excelObj.getCellData(retRow, "LOMMFirstName");
		driver.findElement(By.xpath(RetVal)).sendKeys(FieldValue);
		Thread.sleep(3000);
	}

	// Method to get feature name during runtime
	public static String getFeatureNameFromScenario(Scenario scenario) {
		String[] test = scenario.getUri().toString().split("/");
		String[] longFeatureName = test[test.length - 1].split("\\.");
		return longFeatureName[0];
	}

	// ---------------Methods of MM url 3 Momnet Military---------------------
	public void resourceLibraryVerification(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("Military_ResourceLibrary");

		String RetVal = excelObj.getCellData(retRow, "Xpath");

		By Military_resourceLibrary = By.xpath(RetVal);

		Boolean elementIsDisplayedorNot = driver.findElement(Military_resourceLibrary).isDisplayed();
		String actualTestResource = driver.findElement(Military_resourceLibrary).getText();
		WebElement element = driver.findElement(Military_resourceLibrary);

		excelObj.setSheet("InputData");
		int retRow1 = excelObj.getRowNum("Verify 2 Options beside MM Logo");

		String expectedTestResource = excelObj.getCellData(retRow1, "MilitaryExpectedTextResourceLibrary");
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Resource Library menu");

		if (elementIsDisplayedorNot && actualTestResource.equals(expectedTestResource)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Resource Library menu");

			test.log(Status.INFO, "<b>Expected Result: </b> Resource Library menu should be present");
			test.pass("<b>Actual Result: </b> Resource Library menu was present" + " , Response code :- " + rescode)
					.addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Resource Library menu");
			test.log(Status.INFO, "<b>Expected Result: </b> Resource Library menu should be present");
			test.fail("<b>Actual Result: </b> Resource Library menu was not present" + " , Response code :- " + rescode)
					.addScreenCaptureFromPath(SSpath);
		}

	}

	public void verifyResourcelibraryurl(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("Military_resourceLibrary");

		String RetVal = excelObj.getCellData(retRow, "Xpath");

		By element = By.xpath(RetVal);

		startTime = System.currentTimeMillis();
		driver.findElement(element).click();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Movement Military Resource library");

		endTime = System.currentTimeMillis();

		loadTime = endTime - startTime;
		String actualResourcelibraryURL = driver.getCurrentUrl();

		retRow = excelObj.getRowNum("Military_resourcelibraryLogo");

		RetVal = excelObj.getCellData(retRow, "Xpath");

		element = By.xpath(RetVal);

		Boolean resourceLibraryButton = driver.findElement(element).isDisplayed();

		excelObj.setSheet("InputData");
		int retRow1 = excelObj.getRowNum("Verify Resource library menu");

		String expectedResourcelibraryURL = excelObj.getCellData(retRow1, "MilitaryExpectedResourceLibraryURL");

		if (expectedResourcelibraryURL.equals(actualResourcelibraryURL) && resourceLibraryButton) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Resource Library page");

			test.log(Status.INFO,
					"<b>Expected Result: </b> Resource Library page should be launch successfully with url :"
							+ expectedResourcelibraryURL);
			test.pass("<b>Actual Result: </b> Resource Library page was launched successfully with url :"
					+ actualResourcelibraryURL + " , Response code :- " + rescode + ", Page Load time in Milliseconds: "
					+ loadTime).addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Resource Library page");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Resource Library page should be launch successfully with url :"
							+ expectedResourcelibraryURL);
			test.fail("<b>Actual Result: </b> Resource Library page was not launched successfully url :"
					+ actualResourcelibraryURL + " , Response code :- " + rescode + ", Page Load time in Milliseconds: "
					+ loadTime).addScreenCaptureFromPath(SSpath);
		}

	}

	public void verifyWhymovementurl(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("Military_whyMovement");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);

		startTime = System.currentTimeMillis();

		driver.findElement(element).click();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Movement Military Why Movement");

		endTime = System.currentTimeMillis();

		loadTime = endTime - startTime;
		String actualWhymovementURL = driver.getCurrentUrl();

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("Military_whyMovementLogo");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		element = By.xpath(RetVal);

		Boolean whyMovementButton = driver.findElement(element).isDisplayed();

		excelObj.setSheet("InputData");
		int retRow1 = excelObj.getRowNum("Verify Why movement menu");

		String expectedWhyMovementURL = excelObj.getCellData(retRow1, "MilitaryExpectedWhyMovementURL");

		if (expectedWhyMovementURL.equals(actualWhymovementURL) && whyMovementButton) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Why Movement page");

			test.log(Status.INFO, "<b>Expected Result: </b> Why Movement page should be launch successfully with url :"
					+ expectedWhyMovementURL);
			test.pass("<b>Actual Result: </b> Why Movement page was launched successfully with url :"
					+ actualWhymovementURL + " , Response code :- " + rescode + ", Page Load time in Milliseconds: "
					+ loadTime).addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Why Movement page");
			test.log(Status.INFO, "<b>Expected Result: </b> Why Movement page should be launch successfully with url :"
					+ expectedWhyMovementURL);
			test.fail("<b>Actual Result: </b> Why Movement page was not launched successfully url :"
					+ actualWhymovementURL + " , Response code :- " + rescode + ", Page Load time in Milliseconds: "
					+ loadTime).addScreenCaptureFromPath(SSpath);
		}

	}

	public void verifyDiscovvermyBenefitsURL(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("Military_discoverMyBenefits");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);

		driver.findElement(element).click();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Military Discover my benefits");

		String actualDiscovermyBenefitsURL = driver.getCurrentUrl();

		excelObj.setSheet("InputData");
		int retRow1 = excelObj.getRowNum("Verify Discover my benefits button");
		String expectedDiscovermyBenefitsURL = excelObj.getCellData(retRow1, "MilitaryDiscoverMyBenefitsExpectedURL");

		if (actualDiscovermyBenefitsURL.equals(expectedDiscovermyBenefitsURL)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Discover my benefits page");

			test.log(Status.INFO,
					"<b>Expected Result: </b> Discover my benefits page should be load successfully with url :"
							+ expectedDiscovermyBenefitsURL);
			test.pass("<b>Actual Result: </b> Discover my benefits page was loaded successfully with url :"
					+ actualDiscovermyBenefitsURL + " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Discover my benefits page");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Discover my benefits page should be load successfully with url :"
							+ expectedDiscovermyBenefitsURL);
			test.fail("<b>Actual Result: </b> Discover my benefits page was not loaded successfully url :"
					+ actualDiscovermyBenefitsURL + " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);
		}

	}

	public void verifyPermanentChangeofStationURL(WebDriver driver, ExtentTest test, CommonUtility UtilObj,
			Excel excelObj) throws IOException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("Military_PermanentChangeofStation");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);

		startTime = System.currentTimeMillis();

		driver.findElement(element).click();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Movement Military Permanent Change of station");

		endTime = System.currentTimeMillis();

		loadTime = endTime - startTime;
		String actualpermanentchangeofSectionURL = driver.getCurrentUrl();

		excelObj.setSheet("InputData");
		int retRow1 = excelObj.getRowNum("Verify Permanent Change of Station button");
		String expectedpermanentchangeofSectionURL = excelObj.getCellData(retRow1,
				"MilitaryPermanentChangeExpectedURL");

		if (actualpermanentchangeofSectionURL.equals(expectedpermanentchangeofSectionURL)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Permanent Change of Station page");

			test.log(Status.INFO,
					"<b>Expected Result: </b> Permanent Change of Station page should be load successfully with url :"
							+ expectedpermanentchangeofSectionURL + " url");
			test.pass("<b>Actual Result: </b> Permanent Change of Station page was loaded successfully with url :"
					+ actualpermanentchangeofSectionURL + " , Response code :- " + rescode
					+ ", Page Load time in Milliseconds: " + loadTime).addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Permanent Change of Station page");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Permanent Change of Station page should be load successfully with url :"
							+ expectedpermanentchangeofSectionURL + " url");
			test.fail("<b>Actual Result: </b> Permanent Change of Station page was not loaded successfully url :"
					+ actualpermanentchangeofSectionURL + " , Response code :- " + rescode
					+ ", Page Load time in Milliseconds: " + loadTime).addScreenCaptureFromPath(SSpath);
		}

	}

	public void verifyBuymyFirstHomeURL(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("Military_BuyMyFirstHome");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);

		startTime = System.currentTimeMillis();

		driver.findElement(element).click();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Movement Military Buy my first Home");

		endTime = System.currentTimeMillis();

		loadTime = endTime - startTime;
		String actualBuymyFirstHomeURL = driver.getCurrentUrl();

		excelObj.setSheet("InputData");
		int retRow1 = excelObj.getRowNum("Verify Buy my first home button");
		String expectedBuymyFirstHomeURL = excelObj.getCellData(retRow1, "MilitaryBuymyFirstHomeExpectedURL");

		if (actualBuymyFirstHomeURL.equals(expectedBuymyFirstHomeURL)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Buy my first home page");

			test.log(Status.INFO,
					"<b>Expected Result: </b> Buy my first home page should be load successfully with url :"
							+ expectedBuymyFirstHomeURL);
			test.pass("<b>Actual Result: </b> Buy my first home page was loaded successfully with url :"
					+ actualBuymyFirstHomeURL + " url" + " , Response code :- " + rescode
					+ ", Page Load time in Milliseconds: " + loadTime).addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Buy my first home page");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Buy my first home page should be load successfully with url :"
							+ expectedBuymyFirstHomeURL);
			test.fail("<b>Actual Result: </b> Buy my first home page was not loaded successfully url :"
					+ actualBuymyFirstHomeURL + " , Response code :- " + rescode + ", Page Load time in Milliseconds: "
					+ loadTime).addScreenCaptureFromPath(SSpath);
		}

	}

	public void verifyLowermypaymentsorbuyagainURL(WebDriver driver, ExtentTest test, CommonUtility UtilObj,
			Excel excelObj) throws IOException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("Military_LowerMyPayment");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);

		startTime = System.currentTimeMillis();

		driver.findElement(element).click();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Movement Military Lower my payments or buy again");

		endTime = System.currentTimeMillis();

		loadTime = endTime - startTime;
		String actualLowermypaymentsorbuyagainURL = driver.getCurrentUrl();

		excelObj.setSheet("InputData");
		int retRow1 = excelObj.getRowNum("Verify Lower my payments or buy again button");
		String expectedLowermypaymentsorbuyagain = excelObj.getCellData(retRow1, "MilitaryLowerPaymentExpectedURL");

		if (actualLowermypaymentsorbuyagainURL.equals(expectedLowermypaymentsorbuyagain)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Lower my payments or buy again page");

			test.log(Status.INFO,
					"<b>Expected Result: </b> Lower my payments or buy again page should be load successfully with url :"
							+ expectedLowermypaymentsorbuyagain);
			test.pass("<b>Actual Result: </b> Lower my payments or buy again page was loaded successfully with url :"
					+ actualLowermypaymentsorbuyagainURL + " , Response code :- " + rescode
					+ ", Page Load time in Milliseconds:- " + loadTime).addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Lower my payments or buy again page");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Lower my payments or buy again page should be load successfully with url :"
							+ expectedLowermypaymentsorbuyagain);
			test.fail("<b>Actual Result: </b> Lower my payments or buy again page was not loaded successfully url :"
					+ actualLowermypaymentsorbuyagainURL + " , Response code :- " + rescode
					+ ", Page Load time in Milliseconds:- " + loadTime).addScreenCaptureFromPath(SSpath);
		}

	}

	public void verifyLesson1(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("Military_video1");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);

		startTime = System.currentTimeMillis();

		driver.findElement(element).click();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Movement Military Lesson 1");

		endTime = System.currentTimeMillis();

		loadTime = endTime - startTime;
		String actualVideo1URL = driver.getCurrentUrl();

		excelObj.setSheet("InputData");
		int retRow1 = excelObj.getRowNum("Verify Lesson 1 video url");
		String expectedVideo1URL = excelObj.getCellData(retRow1, "MilitaryLesson1ExpectedURL");

		if (actualVideo1URL.equals(expectedVideo1URL)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Lesson 1 page");

			test.log(Status.INFO, "<b>Expected Result: </b> Lesson 1 page should be load successfully with url :"
					+ expectedVideo1URL);
			test.pass("<b>Actual Result: </b> Lesson 1 page was loaded successfully with url :" + actualVideo1URL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Lession 1 page");
			test.log(Status.INFO, "<b>Expected Result: </b> Lesson 1 page should be load successfully with url :"
					+ expectedVideo1URL);
			test.fail("<b>Actual Result: </b> Lesson 1 page was not loaded successfully url :" + actualVideo1URL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		}

	}

	public void verifyLesson2(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("Military_video2");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);

		startTime = System.currentTimeMillis();

		driver.findElement(element).click();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Movement Military Lesson 2");

		endTime = System.currentTimeMillis();

		loadTime = endTime - startTime;
		String actualVideo2URL = driver.getCurrentUrl();

		excelObj.setSheet("InputData");
		int retRow1 = excelObj.getRowNum("Verify Second Lesson video url");
		String expectedVideo2URL = excelObj.getCellData(retRow1, "MilitaryLesson2ExpectedURL");

		if (actualVideo2URL.equals(expectedVideo2URL)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Lesson 2 page");

			test.log(Status.INFO, "<b>Expected Result: </b> Lesson 2 page should be load successfully with url :"
					+ expectedVideo2URL);
			test.pass("<b>Actual Result: </b> Lesson 2 page was loaded successfully with url :" + actualVideo2URL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Lession 2 page");
			test.log(Status.INFO, "<b>Expected Result: </b> Lesson 2 page should be load successfully with url :"
					+ expectedVideo2URL);
			test.fail("<b>Actual Result: </b> Lesson 2 page was not loaded successfully url :" + actualVideo2URL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		}

	}

	public void verifyLesson3(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("Military_video3");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);

		startTime = System.currentTimeMillis();

		driver.findElement(element).click();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Movement Military Lesson 3");

		endTime = System.currentTimeMillis();

		loadTime = endTime - startTime;
		String actualVideo3URL = driver.getCurrentUrl();

		excelObj.setSheet("InputData");
		int retRow1 = excelObj.getRowNum("Verify Third Lesson video url");
		String expectedVideo3URL = excelObj.getCellData(retRow1, "MilitaryLesson3ExpectedURL");

		if (actualVideo3URL.equals(expectedVideo3URL)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Lesson 3 page");

			test.log(Status.INFO, "<b>Expected Result: </b> Lesson 3 page should be load successfully with url :"
					+ expectedVideo3URL);
			test.pass("<b>Actual Result: </b> Lesson 3 page was loaded successfully with url :" + actualVideo3URL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Lession 3 page");
			test.log(Status.INFO, "<b>Expected Result: </b> Lesson 3 page should be load successfully with url :"
					+ expectedVideo3URL);
			test.fail("<b>Actual Result: </b> Lesson 3 page was not loaded successfully url :" + actualVideo3URL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		}

	}

	public void verifyLesson4(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("Military_video4");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);

		startTime = System.currentTimeMillis();

		driver.findElement(element).click();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Movement Military Lesson 4");

		endTime = System.currentTimeMillis();

		loadTime = endTime - startTime;
		String actualVideo4URL = driver.getCurrentUrl();

		excelObj.setSheet("InputData");
		int retRow1 = excelObj.getRowNum("Verify Fourth Lesson video url");
		String expectedVideo4URL = excelObj.getCellData(retRow1, "MilitaryLesson4ExpectedURL");

		if (actualVideo4URL.equals(expectedVideo4URL)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Lesson 4 page");

			test.log(Status.INFO, "<b>Expected Result: </b> Lesson 4 page should be load successfully with url ;"
					+ expectedVideo4URL);
			test.pass("<b>Actual Result: </b> Lesson 4 page was loaded successfully with url :" + actualVideo4URL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Lession 4 page");
			test.log(Status.INFO, "<b>Expected Result: </b> Lesson 4 page should be load successfully with url :"
					+ expectedVideo4URL);
			test.fail("<b>Actual Result: </b> Lesson 4 page was not loaded successfully url :" + actualVideo4URL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		}

	}

	public void verifyLesson5(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException, InterruptedException {

		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");

			excelObj.setSheet("Xpath");
			int retRow = excelObj.getRowNum("Military_leftArrow");
			String RetVal = excelObj.getCellData(retRow, "Xpath");
			By element = By.xpath(RetVal);

			startTime = System.currentTimeMillis();

			driver.findElement(element).click();

			rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Movement Military Lesson 5");

			endTime = System.currentTimeMillis();

			loadTime = endTime - startTime;
			Thread.sleep(2000);

			excelObj.setSheet("Xpath");
			int retRow1 = excelObj.getRowNum("Military_video5");
			String RetVal1 = excelObj.getCellData(retRow1, "Xpath");
			By element1 = By.xpath(RetVal1);

			driver.findElement(element1).click();
			String actualVideo5URL = driver.getCurrentUrl();

			excelObj.setSheet("InputData");
			int retRow2 = excelObj.getRowNum("Verify Fifth Lesson video url");
			String expectedVideo5URL = excelObj.getCellData(retRow2, "MilitaryLesson5ExpectedURL");

			if (actualVideo5URL.equals(expectedVideo5URL)) {
				String SSpath = UtilObj.SaveScreenshot(driver, "Lesson 5 page");

				test.log(Status.INFO, "<b>Expected Result: </b> Lesson 5 page should be load successfully with url :"
						+ expectedVideo5URL);
				test.pass("<b>Actual Result: </b> Lesson 5 page was loaded successfully with url ;" + actualVideo5URL
						+ " , Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
						.addScreenCaptureFromPath(SSpath);
			} else {
				String SSpath = UtilObj.SaveScreenshot(driver, "Lession 5 page");
				test.log(Status.INFO, "<b>Expected Result: </b> Lesson 5 page should be load successfully with url :"
						+ expectedVideo5URL);
				test.fail("<b>Actual Result: </b> Lesson 5 page was not loaded successfully url :" + actualVideo5URL
						+ " , Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
						.addScreenCaptureFromPath(SSpath);
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			driver.close();
		}

	}

	public void verifyLesson1underGetStarted(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("Military_getStartedLesson1");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);

		startTime = System.currentTimeMillis();

		driver.findElement(element).click();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj,
				"Movement Military get started button under Lesson 1");
		endTime = System.currentTimeMillis();

		loadTime = endTime - startTime;
		String actualgetStartedLesson1URL = driver.getCurrentUrl();

		excelObj.setSheet("InputData");
		int retRow1 = excelObj.getRowNum("Verify Get Started button under first Lesson");
		String expectedVideo1URL = excelObj.getCellData(retRow1, "MilitaryGetstartedLesson1ExpectedURL");

		if (actualgetStartedLesson1URL.equals(expectedVideo1URL)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Get Started button under first Lesson");

			test.log(Status.INFO, "<b>Expected Result: </b> Lesson 1 page should be load successfully with url :"
					+ expectedVideo1URL);
			test.pass("<b>Actual Result: </b> Lesson 1 page was loaded successfully with url :"
					+ actualgetStartedLesson1URL + " , Response code :- " + rescode
					+ ", Page Load time in Milliseconds:- " + loadTime).addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Get Started button under first Lesson");
			test.log(Status.INFO, "<b>Expected Result: </b> Lesson 1 page should be load successfully with url :"
					+ expectedVideo1URL);
			test.fail("<b>Actual Result: </b> Lesson 1 page was not loaded successfully url :"
					+ actualgetStartedLesson1URL + " , Response code :- " + rescode
					+ ", Page Load time in Milliseconds:- " + loadTime).addScreenCaptureFromPath(SSpath);
		}

	}

	public void verifyLesson2underGetStarted(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("Military_getStartedLesson2");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);

		startTime = System.currentTimeMillis();

		driver.findElement(element).click();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj,
				"Movement Military get started button under Lesson 2");

		endTime = System.currentTimeMillis();

		loadTime = endTime - startTime;
		String actualgetStartedLesson2URL = driver.getCurrentUrl();

		excelObj.setSheet("InputData");
		int retRow1 = excelObj.getRowNum("Verify Get Started button under second Lesson");
		String expectedVideo2URL = excelObj.getCellData(retRow1, "MilitaryGetstartedLesson2ExpectedURL");

		if (actualgetStartedLesson2URL.equals(expectedVideo2URL)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Get Started button under second Lesson");

			test.log(Status.INFO, "<b>Expected Result: </b> Lesson 2 page should be load successfully with url :"
					+ expectedVideo2URL);
			test.pass("<b>Actual Result: </b> Lesson 2 page was loaded successfully with url :"
					+ actualgetStartedLesson2URL + " , Response code :- " + rescode
					+ ", Page Load time in Milliseconds:- " + loadTime).addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Get Started button under second Lesson");
			test.log(Status.INFO, "<b>Expected Result: </b> Lesson 2 page should be load successfully with url :"
					+ expectedVideo2URL);
			test.fail("<b>Actual Result: </b> Lesson 2 page was not loaded successfully url :"
					+ actualgetStartedLesson2URL + " , Response code :- " + rescode
					+ ", Page Load time in Milliseconds:- " + loadTime).addScreenCaptureFromPath(SSpath);
		}

	}

	public void verifyLesson3underGetStarted(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("Military_getStartedLesson3");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);

		startTime = System.currentTimeMillis();

		driver.findElement(element).click();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj,
				"Movement Military get started button under Lesson 3");

		endTime = System.currentTimeMillis();

		loadTime = endTime - startTime;
		String actualgetStartedLesson3URL = driver.getCurrentUrl();

		excelObj.setSheet("InputData");
		int retRow1 = excelObj.getRowNum("Verify Get Started button under third Lesson");
		String expectedVideo3URL = excelObj.getCellData(retRow1, "MilitaryGetstartedLesson3ExpectedURL");

		if (actualgetStartedLesson3URL.equals(expectedVideo3URL)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Get Started button under third Lesson");

			test.log(Status.INFO, "<b>Expected Result: </b> Lesson 3 page should be load successfully with url :"
					+ expectedVideo3URL);
			test.pass("<b>Actual Result: </b> Lesson 3 page was loaded successfully with url :"
					+ actualgetStartedLesson3URL + " , Response code :- " + rescode
					+ ", Page Load time in Milliseconds:- " + loadTime).addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Get Started button under third Lesson");
			test.log(Status.INFO, "<b>Expected Result: </b> Lesson 3 page should be load successfully with url :"
					+ expectedVideo3URL);
			test.fail("<b>Actual Result: </b> Lesson 3 page was not loaded successfully url :"
					+ actualgetStartedLesson3URL + " , Response code :- " + rescode
					+ ", Page Load time in Milliseconds:- " + loadTime).addScreenCaptureFromPath(SSpath);
		}

	}

	public void verifyLesson4underGetStarted(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("Military_getStartedLesson4");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);

		startTime = System.currentTimeMillis();

		driver.findElement(element).click();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj,
				"Movement Military get started button under Lesson 4");

		endTime = System.currentTimeMillis();

		loadTime = endTime - startTime;
		String actualgetStartedLesson4URL = driver.getCurrentUrl();

		excelObj.setSheet("InputData");
		int retRow1 = excelObj.getRowNum("Verify Get Started button under fourth Lesson");
		String expectedVideo4URL = excelObj.getCellData(retRow1, "MilitaryGetstartedLesson4ExpectedURL");

		if (actualgetStartedLesson4URL.equals(expectedVideo4URL)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Get Started button under fourth Lesson");

			test.log(Status.INFO, "<b>Expected Result: </b> Lesson 4 page should be load successfully with url :"
					+ expectedVideo4URL);
			test.pass("<b>Actual Result: </b> Lesson 4 page was loaded successfully with url :"
					+ actualgetStartedLesson4URL + " , Response code :- " + rescode
					+ ", Page Load time in Milliseconds:- " + loadTime).addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Get Started button under fourth Lesson");
			test.log(Status.INFO, "<b>Expected Result: </b> Lesson 4 page should be load successfully with url :"
					+ expectedVideo4URL);
			test.fail("<b>Actual Result: </b> Lesson 4 page was not loaded successfully url :"
					+ actualgetStartedLesson4URL + " , Response code :- " + rescode
					+ ", Page Load time in Milliseconds:- " + loadTime).addScreenCaptureFromPath(SSpath);
		}

	}

	public void verifyLesson5underGetStarted(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException, InterruptedException {

		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");

			excelObj.setSheet("Xpath");
			int retRow = excelObj.getRowNum("Military_leftArrow");
			String RetVal = excelObj.getCellData(retRow, "Xpath");
			By element = By.xpath(RetVal);

			startTime = System.currentTimeMillis();

			driver.findElement(element).click();

			rescode = UtilObj.verifyResponseCode(driver, test, UtilObj,
					"Movement Military get started button under Lesson 5");

			endTime = System.currentTimeMillis();

			loadTime = endTime - startTime;
			Thread.sleep(2000);

			excelObj.setSheet("Xpath");
			int retRow1 = excelObj.getRowNum("Military_video5");
			String RetVal1 = excelObj.getCellData(retRow1, "Xpath");
			By element1 = By.xpath(RetVal1);

			driver.findElement(element1).click();
			String actualVideo5URL = driver.getCurrentUrl();

			excelObj.setSheet("InputData");
			int retRow2 = excelObj.getRowNum("Verify Fifth Lesson video url");
			String expectedVideo5URL = excelObj.getCellData(retRow2, "MilitaryLesson5ExpectedURL");

			if (actualVideo5URL.equals(expectedVideo5URL)) {
				String SSpath = UtilObj.SaveScreenshot(driver, "Lesson 5 page");

				test.log(Status.INFO, "<b>Expected Result: </b> Lesson 5 page should be load successfully with url :"
						+ expectedVideo5URL);
				test.pass("<b>Actual Result: </b> Lesson 5 page was loaded successfully with url ;" + actualVideo5URL
						+ " , Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
						.addScreenCaptureFromPath(SSpath);
			} else {
				String SSpath = UtilObj.SaveScreenshot(driver, "Lession 5 page");
				test.log(Status.INFO, "<b>Expected Result: </b> Lesson 5 page should be load successfully with url :"
						+ expectedVideo5URL);
				test.fail("<b>Actual Result: </b> Lesson 5 page was not loaded successfully url :" + actualVideo5URL
						+ " , Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
						.addScreenCaptureFromPath(SSpath);
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			driver.close();
		}

	}

	public void verifyViewFullLibraryURL(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("Military_viewFullLibrary");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);

		startTime = System.currentTimeMillis();

		driver.findElement(element).click();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Movement Military view full library");

		endTime = System.currentTimeMillis();

		loadTime = endTime - startTime;
		String actualViewFullLibraryURL = driver.getCurrentUrl();

		excelObj.setSheet("InputData");
		int retRow1 = excelObj.getRowNum("Verify View Full Library URL");
		String expectedViewFullLibraryURL = excelObj.getCellData(retRow1, "MilitaryViewFullLibraryURL");

		if (actualViewFullLibraryURL.equals(expectedViewFullLibraryURL)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "View Full Library page");

			test.log(Status.INFO,
					"<b>Expected Result: </b> View Full Library page should be load successfully with url :"
							+ expectedViewFullLibraryURL);
			test.pass("<b>Actual Result: </b> View Full Library page was loaded successfully with url :"
					+ actualViewFullLibraryURL + " , Response code :- " + rescode
					+ ", Page Load time in Milliseconds:- " + loadTime).addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "View Full Library page");
			test.log(Status.INFO,
					"<b>Expected Result: </b> View Full Library  page should be load successfully with url :"
							+ expectedViewFullLibraryURL);
			test.fail("<b>Actual Result: </b> View Full Library page was not loaded successfully url :"
					+ actualViewFullLibraryURL + " , Response code :- " + rescode
					+ ", Page Load time in Milliseconds:- " + loadTime).addScreenCaptureFromPath(SSpath);
		}

	}

	public void verifyquestionmark(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("Military_questionmark");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);

		driver.findElement(element).click();

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("Military_heretoHelp");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		element = By.xpath(RetVal);

		Boolean heretoHelp = driver.findElement(element).isDisplayed();
		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Here to Help prompt");
		if (heretoHelp) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Here to Help prompt");

			test.log(Status.INFO, "<b>Expected Result: </b> Here to Help prompt should be display");
			test.pass("<b>Actual Result: </b> Here to Help prompt was displayed successfully" + " , Response code :- "
					+ rescode).addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Here to Help prompt");
			test.log(Status.INFO, "<b>Expected Result: </b> Here to Help prompt should be display");
			test.fail("<b>Actual Result: </b> Here to Help prompt was not displayed successfully"
					+ " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);
		}

	}

	public void clickOnGetstartedButtonandEnterSetofdata(WebDriver driver, ExtentTest test, CommonUtility UtilObj,
			Excel excelObj) throws InterruptedException, MalformedURLException, IOException {

		excelObj.setSheet("InputData");
		int retRow39 = excelObj.getRowNum("Verify Get started button");
		String firstName = excelObj.getCellData(retRow39, "MilitaryFirstName");

		excelObj.setSheet("InputData");
		int retRow40 = excelObj.getRowNum("Verify Get started button");
		String lastName = excelObj.getCellData(retRow40, "MilitaryLastName");

		excelObj.setSheet("InputData");
		int retRow41 = excelObj.getRowNum("Verify Get started button");
		String mailId = excelObj.getCellData(retRow41, "MilitaryMailId");

		excelObj.setSheet("InputData");
		int retRow42 = excelObj.getRowNum("Verify Get started button");
		String zipcode = excelObj.getCellData(retRow42, "MilitaryZipcode");

		excelObj.setSheet("InputData");
		int retRow43 = excelObj.getRowNum("Verify Get started button");
		String phoneNumber = excelObj.getCellData(retRow43, "MilitaryPhoneNumber");

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("military_StartNowbuttonbelowGetmissionreadysection");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);
		driver.findElement(element).click();

		Thread.sleep(2000);

		// Home Purchase
		int retRow1 = excelObj.getRowNum("military_homePurchase");
		String RetVal1 = excelObj.getCellData(retRow1, "Xpath");
		By element1 = By.xpath(RetVal1);

		int retRow2 = excelObj.getRowNum("military_homePurchase_path");
		String RetVal2 = excelObj.getCellData(retRow2, "Xpath");
		By element2 = By.xpath(RetVal2);

		int retRow3 = excelObj.getRowNum("military_tabElement");
		String RetVal3 = excelObj.getCellData(retRow3, "Xpath");
		By element3 = By.xpath(RetVal3);

		try {

			driver.findElement(element1).click();

		} catch (Exception e) {

			try {
				driver.findElement(element2).click();

				Thread.sleep(2000);
				driver.findElement(element3).sendKeys(Keys.TAB);
				Thread.sleep(2000);
				driver.findElement(element3).sendKeys(Keys.ENTER);
			} catch (Exception k) {

			}
		} finally {
			Thread.sleep(2000);

		}

		// Next button
		int retRow4 = excelObj.getRowNum("military_nextButton");
		String RetVal4 = excelObj.getCellData(retRow4, "Xpath");
		By element5 = By.xpath(RetVal4);

		int retRow5 = excelObj.getRowNum("military_nextButton_path");
		String RetVal5 = excelObj.getCellData(retRow5, "Xpath");
		By element4 = By.xpath(RetVal5);

		try {

			driver.findElement(element5).click();

		} catch (Exception e) {

			try {
				driver.findElement(element4).click();

			} catch (Exception k) {

			}
		} finally {
			Thread.sleep(2000);

		}

		// Military

		int retRow6 = excelObj.getRowNum("military_yes");
		String RetVal6 = excelObj.getCellData(retRow6, "Xpath");
		By element22 = By.xpath(RetVal6);

		int retRow7 = excelObj.getRowNum("military_yes_path");
		String RetVal7 = excelObj.getCellData(retRow7, "Xpath");
		By element6 = By.xpath(RetVal7);

		try {

			driver.findElement(element22).click();

		} catch (Exception e) {

			try {
				driver.findElement(element6).click();

			} catch (Exception k) {

			}
		} finally {
			Thread.sleep(2000);

		}

		// Next button
		int retRow8 = excelObj.getRowNum("military_nextButton");
		String RetVal8 = excelObj.getCellData(retRow8, "Xpath");
		By element23 = By.xpath(RetVal8);

		int retRow9 = excelObj.getRowNum("military_militaryNext_path");
		String RetVal9 = excelObj.getCellData(retRow9, "Xpath");
		By element7 = By.xpath(RetVal9);

		try {

			driver.findElement(element23).click();

		} catch (Exception e) {

			try {
				driver.findElement(element7).click();

			} catch (Exception k) {

			}
		} finally {
			Thread.sleep(2000);

		}

		// zipcode
		int retRow10 = excelObj.getRowNum("military_zipcode");
		String RetVal10 = excelObj.getCellData(retRow10, "Xpath");
		By element24 = By.xpath(RetVal10);

		String zipcode1 = "35242";
		// military_zipcode_path

		int retRow11 = excelObj.getRowNum("military_zipcode_path");
		String RetVal11 = excelObj.getCellData(retRow11, "Xpath");
		By element8 = By.xpath(RetVal11);

		try {

			driver.findElement(element24).sendKeys(zipcode1);

		} catch (Exception e) {

			try {
				driver.findElement(element8).sendKeys(zipcode1);

			} catch (Exception k) {

			}
		} finally {
			Thread.sleep(2000);

		}

		// Next button
		int retRow14 = excelObj.getRowNum("military_nextButton");
		String RetVal14 = excelObj.getCellData(retRow14, "Xpath");
		By element25 = By.xpath(RetVal14);

		int retRow15 = excelObj.getRowNum("military_zipcodenext_path");
		String RetVal15 = excelObj.getCellData(retRow15, "Xpath");
		By element9 = By.xpath(RetVal15);

		try {

			driver.findElement(element25).click();

		} catch (Exception e) {

			try {
				driver.findElement(element9).click();

			} catch (Exception k) {

			}
		} finally {
			Thread.sleep(2000);

		}

		// first name
		int retRow17 = excelObj.getRowNum("military_firstname");
		String RetVal17 = excelObj.getCellData(retRow17, "Xpath");
		By element27 = By.xpath(RetVal17);

		int retRow18 = excelObj.getRowNum("military_firstname_path");
		String RetVal18 = excelObj.getCellData(retRow18, "Xpath");
		By element10 = By.xpath(RetVal18);
		try {

			driver.findElement(element27).sendKeys(firstName);

		} catch (Exception e) {

			try {
				driver.findElement(element10).sendKeys(firstName);

			} catch (Exception k) {

			}
		} finally {
			Thread.sleep(2000);

		}

		// last name
		int retRow19 = excelObj.getRowNum("military_lastname");
		String RetVal19 = excelObj.getCellData(retRow19, "Xpath");
		By element28 = By.xpath(RetVal19);

		int retRow20 = excelObj.getRowNum("military_lastname_path");
		String RetVal20 = excelObj.getCellData(retRow20, "Xpath");
		By element11 = By.xpath(RetVal20);
		try {

			driver.findElement(element28).sendKeys(lastName);

		} catch (Exception e) {

			try {
				driver.findElement(element11).sendKeys(lastName);

			} catch (Exception k) {

			}
		} finally {
			Thread.sleep(2000);

		}

		// Next button
		int retRow21 = excelObj.getRowNum("military_nextButton");
		String RetVal21 = excelObj.getCellData(retRow21, "Xpath");
		By element29 = By.xpath(RetVal21);

		int retRow22 = excelObj.getRowNum("military_fullnamenextButton");
		String RetVal22 = excelObj.getCellData(retRow22, "Xpath");
		By element12 = By.xpath(RetVal22);

		try {

			driver.findElement(element29).click();

		} catch (Exception e) {

			try {
				driver.findElement(element12).click();

			} catch (Exception k) {

			}
		} finally {
			Thread.sleep(2000);

		}

		// phoneNumber
		int retRow30 = excelObj.getRowNum("military_phoneNumber");
		String RetVal30 = excelObj.getCellData(retRow30, "Xpath");
		By element30 = By.xpath(RetVal30);

		String phoneNumber1 = "3106365555";

		int retRow31 = excelObj.getRowNum("militaryphoneNumber_path");
		String RetVal31 = excelObj.getCellData(retRow31, "Xpath");
		By element13 = By.xpath(RetVal31);

		try {

			driver.findElement(element30).sendKeys(phoneNumber1);

		} catch (Exception e) {

			try {
				driver.findElement(element13).sendKeys(phoneNumber1);

			} catch (Exception k) {

			}
		} finally {
			Thread.sleep(2000);

		}

		// Next button
		int retRow32 = excelObj.getRowNum("military_nextButton");
		String RetVal32 = excelObj.getCellData(retRow32, "Xpath");
		By element32 = By.xpath(RetVal32);

		int retRow33 = excelObj.getRowNum("military-buttonnext_path");
		String RetVal33 = excelObj.getCellData(retRow33, "Xpath");
		By element14 = By.xpath(RetVal33);

		try {

			driver.findElement(element32).click();

		} catch (Exception e) {

			try {
				driver.findElement(element14).click();

			} catch (Exception k) {

			}
		} finally {
			Thread.sleep(2000);

		}

		// email
		int retRow34 = excelObj.getRowNum("military_email");
		String RetVal34 = excelObj.getCellData(retRow34, "Xpath");
		By element34 = By.xpath(RetVal34);

		int retRow35 = excelObj.getRowNum("military_mailid_path");
		String RetVal35 = excelObj.getCellData(retRow35, "Xpath");
		By element15 = By.xpath(RetVal35);

		try {

			driver.findElement(element34).sendKeys(mailId);

		} catch (Exception e) {

			try {
				driver.findElement(element15).sendKeys(mailId);

			} catch (Exception k) {

			}
		} finally {
			Thread.sleep(2000);

		}

		// Submit button
		int retRow36 = excelObj.getRowNum("military_submitButton");
		String RetVal36 = excelObj.getCellData(retRow36, "Xpath");
		By element36 = By.xpath(RetVal36);

		int retRow37 = excelObj.getRowNum("military_submitButton_path");
		String RetVal37 = excelObj.getCellData(retRow37, "Xpath");
		By element16 = By.xpath(RetVal37);

		try {

			driver.findElement(element36).click();

		} catch (Exception e) {

			try {
				driver.findElement(element16).click();

			} catch (Exception k) {

			}
		} finally {
			Thread.sleep(2000);

		}

	}

	public void whyMovementVerification(WebDriver driver, ExtentTest test, CommonUtility UtilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("Military_whyMovement");

		String RetVal = excelObj.getCellData(retRow, "Xpath");

		By element = By.xpath(RetVal);

		Boolean elementIsDisplayedorNot = driver.findElement(element).isDisplayed();
		String actualWhyMovement = driver.findElement(element).getText();

		excelObj.setSheet("InputData");
		int retRow1 = excelObj.getRowNum("Verify 2 Options beside MM Logo");

		String expectedWhyMovement = excelObj.getCellData(retRow1, "MilitaryExpectedTextWhyMovement");

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Why Movement menu");
		//
		if (elementIsDisplayedorNot && actualWhyMovement.equals(expectedWhyMovement)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Why Movement menu");

			test.log(Status.INFO, "<b>Expected Result: </b> Why Movement menu should be present");
			test.pass("<b>Actual Result: </b> Why Movement menu was present" + " , Response code :- " + rescode)
					.addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Why Movement menu");
			test.log(Status.INFO, "<b>Expected Result: </b> Why Movement menu should be present");
			test.fail("<b>Actual Result: </b> Why Movement menu was not present" + " , Response code :- " + rescode)
					.addScreenCaptureFromPath(SSpath);
		}

	}

	public void MMLogoverificationonMilitaryPage(WebDriver driver, ExtentTest test, CommonUtility UtilObj,
			Excel excelObj) throws IOException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("Military_MMLogoMilitaryPage");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element1 = By.xpath(RetVal);
		String actualsrcValue = driver.findElement(element1).getAttribute("src");

		excelObj.setSheet("InputData");
		int retRow1 = excelObj.getRowNum("Verify Movement Mortgage Logo");
		String expectedsrcValue = excelObj.getCellData(retRow1, "expectedMilitarySRCvalue");

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Movement Military logo");
		if (actualsrcValue.equals(expectedsrcValue)) {

			String SSpath = UtilObj.SaveScreenshot(driver, "Movement Military logo");

			test.log(Status.INFO, "<b>Expected Result: </b> Movement Military logo should be valid");
			test.pass("<b>Actual Result: </b> Movement Military logo was valid" + " ,Response code :- " + rescode)
					.addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Movement Military logo");
			test.log(Status.INFO, "<b>Expected Result: </b> Movement Military logo should be valid");
			test.fail("<b>Actual Result: </b> Movement Blog Military was invalid" + " ,Response code :- " + rescode)
					.addScreenCaptureFromPath(SSpath);
		}

		/*
		 * excelObj.setSheet("Xpath"); int retRow =
		 * excelObj.getRowNum("Military_MMLogoMilitaryPage"); String RetVal =
		 * excelObj.getCellData(retRow, "Xpath"); By MilitaryMMLogo = By.xpath(RetVal);
		 * 
		 * WebElement element = driver.findElement(MilitaryMMLogo); Boolean b1 =
		 * UtilObj.compareImage(driver, element, "Expected Movement Military logo.png");
		 * 
		 * rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "MM logo"); if
		 * (b1) { String SSpath = UtilObj.SaveScreenshot(driver, "MM logo");
		 * 
		 * test.log(Status.INFO,
		 * "<b>Expected Result: </b> Movement logo should be present");
		 * test.pass("<b>Actual Result: </b> Movement logo was present" +
		 * " , Response code :- " + rescode) .addScreenCaptureFromPath(SSpath);
		 * 
		 * } else { String SSpath = UtilObj.SaveScreenshot(driver, "MM logo");
		 * test.log(Status.INFO,
		 * "<b>Expected Result: </b> Movement logo should be present");
		 * test.fail("<b>Actual Result: </b> Movement logo was different" +
		 * " , Response code :- " + rescode) .addScreenCaptureFromPath(SSpath);
		 * 
		 * }
		 */

	}

	public void movementmilitaryUrlVerification(WebDriver driver, ExtentTest test, CommonUtility UtilObj,
			Excel excelObj) throws IOException {

		excelObj.setSheet("InputData");
		int retRow = excelObj.getRowNum("Verify movement-military page");

		String expectedmilitaryUrl = excelObj.getCellData(retRow, "Military page url");

		String actualmilitaryUrl = driver.getCurrentUrl();

		rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Movement military page");
		if (actualmilitaryUrl.equals(expectedmilitaryUrl)) {
			String SSpath = UtilObj.SaveScreenshot(driver, "Movement military page");

			test.log(Status.INFO,
					"<b>Expected Result: </b> Movement military page should be loaded successfully with url :"
							+ expectedmilitaryUrl);
			test.pass("<b>Actual Result: </b> Movement military page was loaded successfully with url :"
					+ actualmilitaryUrl + " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = UtilObj.SaveScreenshot(driver, "Movement military page");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Movement military page should be loaded successfully with url :"
							+ expectedmilitaryUrl);
			test.fail("<b>Actual Result: </b> Movement military page was not loaded successfully url"
					+ actualmilitaryUrl + " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);
		}

	}

	// ----------URL 4---------------------//

	public void clickOnThreedots(WebDriver driver, ExtentTest test, CommonUtility utilObj, Excel excelObj)
			throws InterruptedException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("blog_threeLinesOnHomepage");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);

		driver.findElement(element).click();

		Thread.sleep(2000);

		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("blog_threeDotsCategories");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		element = By.xpath(RetVal);

		driver.findElement(element).click();
	}

	public void clickOnMovementNewsandVerifyURL(WebDriver driver, ExtentTest test, CommonUtility utilObj,
			Excel excelObj) throws IOException, InterruptedException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("blog_MovementNews");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);
		Thread.sleep(2000);

		startTime = System.currentTimeMillis();

		driver.findElement(element).click();

		rescode = utilObj.verifyResponseCode(driver, test, utilObj, "Movement Blog Movement News");

		endTime = System.currentTimeMillis();

		loadTime = endTime - startTime;
		String actualMovementNewsURL = driver.getCurrentUrl();

		excelObj.setSheet("InputData");
		retRow = excelObj.getRowNum("Verify Movement News Option redirects properly");
		String expectedMovementNewsURL = excelObj.getCellData(retRow, "BlogMovementNewsExpectedURL");

		if (actualMovementNewsURL.equals(expectedMovementNewsURL)) {
			String SSpath = utilObj.SaveScreenshot(driver, "Movement News page");

			test.log(Status.INFO, "<b>Expected Result: </b> Movement News page should be loaded successfully with url :"
					+ expectedMovementNewsURL);
			test.pass("<b>Actual Result: </b> Movement News page was loaded successfully with url :"
					+ actualMovementNewsURL + " , Response code :- " + rescode + ", Page Load time in Milliseconds:- "
					+ loadTime).addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = utilObj.SaveScreenshot(driver, "Movement News page");
			test.log(Status.INFO, "<b>Expected Result: </b> Movement News page should be loaded successfully with url :"
					+ expectedMovementNewsURL);
			test.fail(
					"<b>Actual Result: </b> Movement News page was not loaded successfully url" + actualMovementNewsURL
							+ " , Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		}
	}

	public void clickOnMortgage101andVerifyURL(WebDriver driver, ExtentTest test, CommonUtility utilObj, Excel excelObj)
			throws InterruptedException, IOException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("blog_Mortgage101");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);
		Thread.sleep(2000);

		startTime = System.currentTimeMillis();

		driver.findElement(element).click();

		rescode = utilObj.verifyResponseCode(driver, test, utilObj, "Movement Blog Mortgage 101 option");

		endTime = System.currentTimeMillis();

		loadTime = endTime - startTime;
		String actualMortgage101URL = driver.getCurrentUrl();

		excelObj.setSheet("InputData");
		retRow = excelObj.getRowNum("Verify Mortgage 101 Option redirects properly");
		String expectedMortgage101URL = excelObj.getCellData(retRow, "Blog101ExpectedURL");

		if (actualMortgage101URL.equals(expectedMortgage101URL)) {
			String SSpath = utilObj.SaveScreenshot(driver, "Mortgage 101 page");

			test.log(Status.INFO, "<b>Expected Result: </b> Mortgage 101 page should be loaded successfully with url :"
					+ expectedMortgage101URL);
			test.pass(
					"<b>Actual Result: </b> Mortgage 101 page was loaded successfully with url :" + actualMortgage101URL
							+ " , Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = utilObj.SaveScreenshot(driver, "Mortgage 101 page");
			test.log(Status.INFO, "<b>Expected Result: </b> Mortgage 101 page should be loaded successfully with url :"
					+ expectedMortgage101URL);
			test.fail("<b>Actual Result: </b> Mortgage 101 page was not loaded successfully url" + actualMortgage101URL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		}
	}

	public void clickOnSportlightandVerifyURL(WebDriver driver, ExtentTest test, CommonUtility utilObj, Excel excelObj)
			throws InterruptedException, IOException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("blog_Spotlight");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);
		Thread.sleep(2000);

		startTime = System.currentTimeMillis();
		driver.findElement(element).click();

		rescode = utilObj.verifyResponseCode(driver, test, utilObj, "Movement Blog Spoltlight");

		endTime = System.currentTimeMillis();

		loadTime = endTime - startTime;
		String actualMortgageSpotlightURL = driver.getCurrentUrl();

		excelObj.setSheet("InputData");
		retRow = excelObj.getRowNum("Verify Spotlight Option redirects properly");
		String expectedMortgageSpotlightURL = excelObj.getCellData(retRow, "BlogSpotlightExpectedURL");

		if (actualMortgageSpotlightURL.equals(expectedMortgageSpotlightURL)) {
			String SSpath = utilObj.SaveScreenshot(driver, "Mortgage Spotlight page");

			test.log(Status.INFO,
					"<b>Expected Result: </b> Mortgage Spotlight page should be loaded successfully with url :"
							+ expectedMortgageSpotlightURL);
			test.pass("<b>Actual Result: </b> Mortgage Spotlight page was loaded successfully with url :"
					+ actualMortgageSpotlightURL + " , Response code :- " + rescode
					+ ", Page Load time in Milliseconds:- " + loadTime).addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = utilObj.SaveScreenshot(driver, "Mortgage Spotlight page");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Mortgage Spotlight page should be loaded successfully with url :"
							+ expectedMortgageSpotlightURL);
			test.fail("<b>Actual Result: </b> Mortgage Spotlight page was not loaded successfully url"
					+ actualMortgageSpotlightURL + " , Response code :- " + rescode
					+ ", Page Load time in Milliseconds:- " + loadTime).addScreenCaptureFromPath(SSpath);
		}
	}

	public void clickOnThreelines(WebDriver driver, ExtentTest test, CommonUtility utilObj, Excel excelObj)
			throws InterruptedException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("blog_threeLinesOnHomepage");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);

		driver.findElement(element).click();

		Thread.sleep(2000);
	}

	public void clickOnAboutandVerifyURL(WebDriver driver, ExtentTest test, CommonUtility utilObj, Excel excelObj)
			throws InterruptedException, IOException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("blog_About");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);

		startTime = System.currentTimeMillis();
		driver.findElement(element).click();

		rescode = utilObj.verifyResponseCode(driver, test, utilObj, "Movement Blog About");

		endTime = System.currentTimeMillis();

		loadTime = endTime - startTime;
		String actualAboutPageURL = driver.getCurrentUrl();

		excelObj.setSheet("InputData");
		int retRow1 = excelObj.getRowNum("Verify About Option redirects properly");
		String expectedAboutPageURL = excelObj.getCellData(retRow1, "BlogAboutExpectedURL");

		if (actualAboutPageURL.equals(expectedAboutPageURL)) {
			String SSpath = utilObj.SaveScreenshot(driver, "About page");

			test.log(Status.INFO, "<b>Expected Result: </b> About page should be loaded successfully with url :"
					+ expectedAboutPageURL);
			test.pass("<b>Actual Result: </b> About page was loaded successfully with url :" + actualAboutPageURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = utilObj.SaveScreenshot(driver, "About page");
			test.log(Status.INFO, "<b>Expected Result: </b> About page should be loaded successfully with url :"
					+ expectedAboutPageURL);
			test.fail("<b>Actual Result: </b> About page was not loaded successfully url" + actualAboutPageURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		}
	}

	public void clickOnmovementdotcomandVerifyURL(WebDriver driver, ExtentTest test, CommonUtility utilObj,
			Excel excelObj) throws IOException {
		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("blog_movement.com");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);

		startTime = System.currentTimeMillis();

		driver.findElement(element).click();

		rescode = utilObj.verifyResponseCode(driver, test, utilObj, "Movement Blog Movement url");

		endTime = System.currentTimeMillis();

		loadTime = endTime - startTime;
		String actualMovementPageURL = driver.getCurrentUrl();

		excelObj.setSheet("InputData");
		retRow = excelObj.getRowNum("Verify movement.com Option redirects properly");
		String expectedMovementPageURL = excelObj.getCellData(retRow, "BlogMovementExpectedURL");

		if (actualMovementPageURL.equals(expectedMovementPageURL)) {
			String SSpath = utilObj.SaveScreenshot(driver, "movement.com page");

			test.log(Status.INFO, "<b>Expected Result: </b> movement.com page should be loaded successfully with url :"
					+ expectedMovementPageURL);
			test.pass("<b>Actual Result: </b> movement.com page was loaded successfully with url :"
					+ actualMovementPageURL + " , Response code :- " + rescode + ", Page Load time in Milliseconds:- "
					+ loadTime).addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = utilObj.SaveScreenshot(driver, "movement.com page");
			test.log(Status.INFO, "<b>Expected Result: </b> movement.com page should be loaded successfully with url :"
					+ expectedMovementPageURL);
			test.fail("<b>Actual Result: </b> movement.com page was not loaded successfully url" + actualMovementPageURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		}

	}

	public void verifyMarketUpdate(WebDriver driver, ExtentTest test, CommonUtility utilObj, Excel excelObj)
			throws IOException, InterruptedException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("blog_MarketUpdate");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);

		startTime = System.currentTimeMillis();

		driver.findElement(element).click();
		Thread.sleep(2000);

		rescode = utilObj.verifyResponseCode(driver, test, utilObj, "Movement blog Market update");

		endTime = System.currentTimeMillis();

		loadTime = endTime - startTime;
		String actualMarketupdatePageURL = driver.getCurrentUrl();

		excelObj.setSheet("InputData");
		int retRow1 = excelObj.getRowNum("Verify MARKET UPDATE redirects properly");

		String expectedMarketupdatePageURL = excelObj.getCellData(retRow1, "BlogMarketUpdateExpURL");

		if (actualMarketupdatePageURL.equals(expectedMarketupdatePageURL)) {
			String SSpath = utilObj.SaveScreenshot(driver, "Market update page");

			test.log(Status.INFO, "<b>Expected Result: </b> Market update page should be loaded successfully with url :"
					+ expectedMarketupdatePageURL);
			test.pass("<b>Actual Result: </b> Market update page was loaded successfully with url :"
					+ actualMarketupdatePageURL + " , Response code :- " + rescode
					+ ", Page Load time in Milliseconds:- " + loadTime).addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = utilObj.SaveScreenshot(driver, "Market update page");
			test.log(Status.INFO, "<b>Expected Result: </b> Market update page should be loaded successfully with url :"
					+ expectedMarketupdatePageURL);
			test.fail("<b>Actual Result: </b> Market update page was not loaded successfully url"
					+ actualMarketupdatePageURL + " , Response code :- " + rescode
					+ ", Page Load time in Milliseconds:- " + loadTime).addScreenCaptureFromPath(SSpath);
		}
	}

	public void verifyTheURL(WebDriver driver, ExtentTest test, CommonUtility utilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("InputData");
		int retRow = excelObj.getRowNum("Verify https://blog.movement.com/ url");

		String expectedURL = excelObj.getCellData(retRow, "BlogMovementHomepageExpectedURL");

		String actualURL = driver.getCurrentUrl();

		rescode = utilObj.verifyResponseCode(driver, test, utilObj, actualURL);
		// endTime = System.currentTimeMillis();

		// loadTime = endTime - startTime;
		if (expectedURL.equals(actualURL)) {

			String SSpath = utilObj.SaveScreenshot(driver, "Market update page");

			test.log(Status.INFO, "<b>Expected Result: </b> Market update page should be loaded successfully with url :"
					+ expectedURL);
			test.pass("<b>Actual Result: </b> Market update page was loaded successfully with url :" + actualURL
					+ " ,Response code :- " + rescode).addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = utilObj.SaveScreenshot(driver, "Market update page");
			test.log(Status.INFO, "<b>Expected Result: </b> Market update page should be loaded successfully with url :"
					+ expectedURL);
			test.fail("<b>Actual Result: </b> Market update page was not loaded successfully url" + actualURL
					+ " ,Response code :- " + rescode).addScreenCaptureFromPath(SSpath);
		}
	}

	public void verifyMovementBloglogo(WebDriver driver, ExtentTest test, CommonUtility utilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("blog_MovementLogo");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element1 = By.xpath(RetVal);
		String actualsrcValue = driver.findElement(element1).getAttribute("src");

		excelObj.setSheet("InputData");
		int retRow1 = excelObj.getRowNum("Verify MovementBlog logo");
		String expectedsrcValue = excelObj.getCellData(retRow1, "BlogMMlogoExpctedsrc");

		rescode = utilObj.verifyResponseCode(driver, test, utilObj, "Movement Blog logo");
		if (actualsrcValue.equals(expectedsrcValue)) {

			String SSpath = utilObj.SaveScreenshot(driver, "Movement Blog logo");

			test.log(Status.INFO, "<b>Expected Result: </b> Movement Blog logo should be valid");
			test.pass("<b>Actual Result: </b> Movement Blog logo was valid"/* + " ,Response code :- " + rescode */)
					.addScreenCaptureFromPath(SSpath);

		} else {
			String SSpath = utilObj.SaveScreenshot(driver, "Movement Blog logo");
			test.log(Status.INFO, "<b>Expected Result: </b> Movement Blog logo should be valid");
			test.fail("<b>Actual Result: </b> Movement Blog logo was invalid" /* + " ,Response code :- " + rescode */)
					.addScreenCaptureFromPath(SSpath);
		}

	}

	public void verifySearchButton(WebDriver driver, ExtentTest test, CommonUtility utilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("blog_searchButton");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);

		driver.findElement(element).click();

		retRow = excelObj.getRowNum("blog_searchField");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		element = By.xpath(RetVal);

		Boolean testResult = driver.findElement(element).isDisplayed();

		excelObj.setSheet("InputData");
		int retRow1 = excelObj.getRowNum("Verify https://blog.movement.com/ url");
		String expectedURL = excelObj.getCellData(retRow1, "BlogMovementHomepageExpectedURL");
		String actualURL = driver.getCurrentUrl();

		rescode = utilObj.verifyResponseCode(driver, test, utilObj, actualURL);

		if (testResult) {
			String SSpath = utilObj.SaveScreenshot(driver, "Search field");

			test.log(Status.INFO,
					"<b>Expected Result: </b> Search field should be work successfully with url :" + expectedURL);
			test.pass("<b>Actual Result: </b> Search field was worked successfully with url :" + actualURL
					+ " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = utilObj.SaveScreenshot(driver, "Search field");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Search field should be work successfully with url :" + expectedURL);
			test.fail("<b>Actual Result: </b> Search field was not worked successfully url" + actualURL
					+ " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);
		}
	}

	public void verifyHamburgerIcon(WebDriver driver, ExtentTest test, CommonUtility utilObj, Excel excelObj)
			throws IOException, InterruptedException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("blog_threeLinesOnHomepage");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);
		driver.findElement(element).click();

		Thread.sleep(2000);
		retRow = excelObj.getRowNum("blog_Home");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		element = By.xpath(RetVal);
		Boolean home = driver.findElement(element).isDisplayed();

		retRow = excelObj.getRowNum("blog_Trending");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		element = By.xpath(RetVal);
		Boolean trending = driver.findElement(element).isDisplayed();

		retRow = excelObj.getRowNum("blog_Categories");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		element = By.xpath(RetVal);
		Boolean categories = driver.findElement(element).isDisplayed();

		retRow = excelObj.getRowNum("blog_About");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		element = By.xpath(RetVal);
		Boolean about = driver.findElement(element).isDisplayed();

		retRow = excelObj.getRowNum("blog_movement.com");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		element = By.xpath(RetVal);
		Boolean movement = driver.findElement(element).isDisplayed();

		excelObj.setSheet("InputData");
		int retRow1 = excelObj.getRowNum("Verify https://blog.movement.com/ url");
		String expectedURL = excelObj.getCellData(retRow1, "BlogMovementHomepageExpectedURL");
		String actualURL = driver.getCurrentUrl();

		rescode = utilObj.verifyResponseCode(driver, test, utilObj, actualURL);

		if (home && trending && categories && about && movement) {
			String SSpath = utilObj.SaveScreenshot(driver, "Hamburger icon");

			test.log(Status.INFO,
					"<b>Expected Result: </b> Hamburger icon should be work successfully with url :" + expectedURL);
			test.pass("<b>Actual Result: </b> Hamburger icon was worked successfully with url :" + actualURL
					+ " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = utilObj.SaveScreenshot(driver, "Hamburger icon");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Hamburger icon should be work successfully with url :" + expectedURL);
			test.fail("<b>Actual Result: </b> Hamburger icon was not worked successfully url :" + actualURL
					+ " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);
		}
	}

	public void verifyHomeOption(WebDriver driver, ExtentTest test, CommonUtility utilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("Xpath");
		/*
		 * int retRow = excelObj.getRowNum("blog_threeLinesOnHomepage"); String RetVal =
		 * excelObj.getCellData(retRow, "Xpath"); By element = By.xpath(RetVal);
		 * driver.findElement(element).click();
		 */

		retRow = excelObj.getRowNum("blog_Home");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);

		startTime = System.currentTimeMillis();

		driver.findElement(element).click();

		rescode = utilObj.verifyResponseCode(driver, test, utilObj, "Movement Blog Home option");

		endTime = System.currentTimeMillis();

		loadTime = endTime - startTime;
		// int rescode = utilObj.testverifyResponseCode(driver, test, utilObj, "Movement
		// Blog Home option");

		excelObj.setSheet("InputData");
		int retRow1 = excelObj.getRowNum("Verify https://blog.movement.com/ url");
		String expectedURL = excelObj.getCellData(retRow1, "BlogMovementHomepageExpectedURL");
		String actualURL = driver.getCurrentUrl();

		if (expectedURL.equals(actualURL)) {
			String SSpath = utilObj.SaveScreenshot(driver, "Home option");

			test.log(Status.INFO,
					"<b>Expected Result: </b> Home option should be work successfully with url :" + expectedURL);
			test.pass("<b>Actual Result: </b> Home option was worked successfully with url :" + actualURL
					+ " Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = utilObj.SaveScreenshot(driver, "Home option");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Home option should be work successfully with url :" + expectedURL);
			test.fail("<b>Actual Result: </b> Home option was not worked successfully url" + actualURL
					+ " Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		}
	}

	public void verifyTrendingOption(WebDriver driver, ExtentTest test, CommonUtility utilObj, Excel excelObj)
			throws IOException {
		excelObj.setSheet("Xpath");
		/*
		 * int retRow = excelObj.getRowNum("blog_threeLinesOnHomepage"); String RetVal =
		 * excelObj.getCellData(retRow, "Xpath"); By element = By.xpath(RetVal);
		 * driver.findElement(element).click();
		 */

		retRow = excelObj.getRowNum("blog_Trending");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);
		startTime = System.currentTimeMillis();

		driver.findElement(element).click();

		rescode = utilObj.verifyResponseCode(driver, test, utilObj, "Movement Blog Trending option");

		endTime = System.currentTimeMillis();

		loadTime = endTime - startTime;
		excelObj.setSheet("InputData");
		int retRow1 = excelObj.getRowNum("Verify Trending Option redirects properly");
		String expectedURL = excelObj.getCellData(retRow1, "BlogTrandingExpectedURL");
		String actualURL = driver.getCurrentUrl();

		if (expectedURL.equals(actualURL)) {
			String SSpath = utilObj.SaveScreenshot(driver, "Trending option");

			test.log(Status.INFO,
					"<b>Expected Result: </b> Trending option should be work successfully with url :" + expectedURL);
			test.pass("<b>Actual Result: </b> Trending option was worked successfully with url :" + actualURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = utilObj.SaveScreenshot(driver, "Trending option");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Trending option should be work successfully with url :" + expectedURL);
			test.fail("<b>Actual Result: </b> Trending option was not worked successfully url" + actualURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		}

	}

	public void verifyCategoryOptionandMoreOptions(WebDriver driver, ExtentTest test, CommonUtility utilObj,
			Excel excelObj) throws InterruptedException, IOException {

		Thread.sleep(2000);

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("blog_marketUpdateHamburger");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);
		Boolean marketUpdate = driver.findElement(element).isDisplayed();

		retRow = excelObj.getRowNum("blog_foundation");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		element = By.xpath(RetVal);
		Boolean foundation = driver.findElement(element).isDisplayed();

		retRow = excelObj.getRowNum("blog_MovementNews");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		element = By.xpath(RetVal);
		Boolean movementNews = driver.findElement(element).isDisplayed();

		retRow = excelObj.getRowNum("blog_Mortgage101");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		element = By.xpath(RetVal);
		Boolean mortgage101 = driver.findElement(element).isDisplayed();

		retRow = excelObj.getRowNum("blog_Spotlight");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		element = By.xpath(RetVal);
		Boolean spotlight = driver.findElement(element).isDisplayed();

		excelObj.setSheet("InputData");
		int retRow1 = excelObj.getRowNum("Verify https://blog.movement.com/ url");
		String expectedURL = excelObj.getCellData(retRow1, "BlogMovementHomepageExpectedURL");
		String actualURL = driver.getCurrentUrl();
		rescode = utilObj.verifyResponseCode(driver, test, utilObj, actualURL);
		if (marketUpdate && foundation && movementNews && mortgage101 && spotlight) {
			String SSpath = utilObj.SaveScreenshot(driver, "Category option and more options");

			test.log(Status.INFO,
					"<b>Expected Result: </b> Category option and more options should be work successfully with url :"
							+ expectedURL);
			test.pass("<b>Actual Result: </b> Category option and more options was worked successfully with url :"
					+ actualURL + " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = utilObj.SaveScreenshot(driver, "Category option and more options");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Category option and more options should be work successfully with url :"
							+ expectedURL);
			test.fail("<b>Actual Result: </b> Category option and more options was not worked successfully url :"
					+ actualURL + " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);
		}

		excelObj.setSheet("Xpath");
		int retRow2 = excelObj.getRowNum("blog_back");
		String RetVal2 = excelObj.getCellData(retRow2, "Xpath");
		By element2 = By.xpath(RetVal2);
		driver.findElement(element2).click();

	}

	public void clickOnMarketUpdateandVerifyURL(WebDriver driver, ExtentTest test, CommonUtility utilObj,
			Excel excelObj) throws InterruptedException, IOException {
		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("blog_marketUpdateHamburger");
		String RetVal = excelObj.getCellData(retRow, "Xpath");

		By element = By.xpath(RetVal);
		Thread.sleep(2000);

		startTime = System.currentTimeMillis();

		driver.findElement(element).click();

		rescode = utilObj.verifyResponseCode(driver, test, utilObj, "Movement Blog Market update");

		endTime = System.currentTimeMillis();

		loadTime = endTime - startTime;
		String actualURL = driver.getCurrentUrl();

		excelObj.setSheet("InputData");
		retRow = excelObj.getRowNum("Verify Market Update Option redirects properly");
		String expectedURL = excelObj.getCellData(retRow, "BlogMarketUpdateExpectedURL");

		if (actualURL.equals(expectedURL)) {
			String SSpath = utilObj.SaveScreenshot(driver, "Market update page");

			test.log(Status.INFO, "<b>Expected Result: </b> Market update page should be loaded successfully with url :"
					+ expectedURL);
			test.pass("<b>Actual Result: </b> Market update page was loaded successfully with url :" + actualURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = utilObj.SaveScreenshot(driver, "Market update page");
			test.log(Status.INFO, "<b>Expected Result: </b> Market update page should be loaded successfully with url :"
					+ expectedURL);
			test.fail("<b>Actual Result: </b> Market update page was not loaded successfully url" + actualURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		}

	}

	public void clickOnMovementFoundationandVerifyURL(WebDriver driver, ExtentTest test, CommonUtility utilObj,
			Excel excelObj) throws InterruptedException, IOException {
		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("blog_foundation");
		String RetVal = excelObj.getCellData(retRow, "Xpath");

		By element = By.xpath(RetVal);
		Thread.sleep(2000);

		startTime = System.currentTimeMillis();

		driver.findElement(element).click();

		rescode = utilObj.verifyResponseCode(driver, test, utilObj, "Movement Blog Movement foundation");

		endTime = System.currentTimeMillis();

		loadTime = endTime - startTime;
		String actualURL = driver.getCurrentUrl();

		excelObj.setSheet("InputData");
		retRow = excelObj.getRowNum("Verify Movement Foundation Option redirects properly");
		String expectedURL = excelObj.getCellData(retRow, "BlogMovementFoundationExpectedURL");

		if (actualURL.equals(expectedURL)) {
			String SSpath = utilObj.SaveScreenshot(driver, "Movement Foundation page");

			test.log(Status.INFO,
					"<b>Expected Result: </b> Movement Foundation page should be loaded successfully with url :"
							+ expectedURL);
			test.pass("<b>Actual Result: </b> Movement Foundation page was loaded successfully with url :" + actualURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = utilObj.SaveScreenshot(driver, "Movement Foundation page");
			test.log(Status.INFO,
					"<b>Expected Result: </b> Movement Foundation page should be loaded successfully with url :"
							+ expectedURL);
			test.fail("<b>Actual Result: </b> Movement Foundation page was not loaded successfully url" + actualURL
					+ " , Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
					.addScreenCaptureFromPath(SSpath);
		}

	}

	public void verifyFormSubmittedorNot(WebDriver driver, ExtentTest test, CommonUtility utilObj, Excel excelObj)
			throws IOException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("military_submitform_path");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);

		Boolean b1 = driver.findElement(element).isDisplayed();
		rescode = utilObj.verifyResponseCode(driver, test, utilObj, "Get started form");
		if (b1) {
			String SSpath = utilObj.SaveScreenshot(driver, "Get started form");

			test.log(Status.INFO, "<b>Expected Result: </b> Get started form should be submit successfully");
			test.pass("<b>Actual Result: </b> Get started form was submitted successfully" + " , Response code :- "
					+ rescode).addScreenCaptureFromPath(SSpath);
		} else {
			String SSpath = utilObj.SaveScreenshot(driver, "Get started form");
			test.log(Status.INFO, "<b>Expected Result: </b> Get started form should be submit successfully");
			test.fail("<b>Actual Result: </b> Get started form was not submitted successfully" + " , Response code :- "
					+ rescode).addScreenCaptureFromPath(SSpath);
		}

	}

	public void verifyArrowsBesideVAloan(WebDriver driver, ExtentTest test, CommonUtility utilObj, Excel excelObj)
			throws IOException, InterruptedException {

		excelObj.setSheet("Xpath");
		int retRow = excelObj.getRowNum("Military_leftArrow");
		String RetVal = excelObj.getCellData(retRow, "Xpath");
		By element = By.xpath(RetVal);
		//
		driver.findElement(element).click();

		//
		excelObj.setSheet("Xpath");
		int retRow1 = excelObj.getRowNum("Military_video5");
		String RetVal1 = excelObj.getCellData(retRow1, "Xpath");
		By element1 = By.xpath(RetVal1);

		Boolean video5, video6 = null;

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");
		try {
			video5 = driver.findElement(element1).isDisplayed();

			excelObj.setSheet("Xpath");
			int retRow2 = excelObj.getRowNum("Military_rightArrow");
			String RetVal2 = excelObj.getCellData(retRow2, "Xpath");
			By element2 = By.xpath(RetVal2);
			//
			driver.findElement(element2).click();

			//
			excelObj.setSheet("Xpath");
			int retRow3 = excelObj.getRowNum("Military_video5");
			String RetVal3 = excelObj.getCellData(retRow3, "Xpath");
			By element3 = By.xpath(RetVal3);

			video6 = driver.findElement(element3).isDisplayed();
			rescode = utilObj.verifyResponseCode(driver, test, utilObj, "Arrow Beside VA loan");
			if (video5 && video6.equals(false)) {
				String SSpath = utilObj.SaveScreenshot(driver, "Arrow Beside VA loan");

				test.log(Status.INFO, "<b>Expected Result: </b> Arrow Beside VA loan should work successfully");
				test.pass("<b>Actual Result: </b> Arrow Beside VA loan was worked successfully" + " , Response code :- "
						+ rescode).addScreenCaptureFromPath(SSpath);
			} else {
				String SSpath = utilObj.SaveScreenshot(driver, "Arrow Beside VA loan");
				test.log(Status.INFO, "<b>Expected Result: </b> v successfully");
				test.fail("<b>Actual Result: </b> Arrow Beside VA loan was not worked successfully"
						+ " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);
			}

		} catch (Exception e) {

			e.getMessage();
		} finally {

		}

	}

	public void verifyVABootcampCursorandVerifySlidestoTheDirection(WebDriver driver, ExtentTest test,
			CommonUtility utilObj, Excel excelObj) throws IOException {

		try {

			excelObj.setSheet("Xpath");
			int retRow = excelObj.getRowNum("Military_getStartedLesson1");
			String RetVal = excelObj.getCellData(retRow, "Xpath");
			By element = By.xpath(RetVal);

			Boolean beforeLeftClickLesson1 = driver.findElement(element).isDisplayed();

			int retRow1 = excelObj.getRowNum("Military_getStartedLesson5");
			String RetVal1 = excelObj.getCellData(retRow1, "Xpath");
			By element1 = By.xpath(RetVal1);

			Boolean beforeLeftClickLesson5 = driver.findElement(element1).isDisplayed();

			int retRow2 = excelObj.getRowNum("Military_leftArrow");
			String RetVal2 = excelObj.getCellData(retRow2, "Xpath");
			By element2 = By.xpath(RetVal2);
			driver.findElement(element2).click();

			int retRow3 = excelObj.getRowNum("Military_getStartedLesson5");
			String RetVal3 = excelObj.getCellData(retRow3, "Xpath");
			By element3 = By.xpath(RetVal3);

			Boolean afterClickLesson5 = driver.findElement(element3).isDisplayed();

			int retRow4 = excelObj.getRowNum("Military_getStartedLesson4");
			String RetVal4 = excelObj.getCellData(retRow4, "Xpath");
			By element4 = By.xpath(RetVal4);

			Boolean afterClickLesson4 = driver.findElement(element4).isDisplayed();

			int count = 0;
			if (beforeLeftClickLesson1.equals(true) && beforeLeftClickLesson5.equals(false)
					&& afterClickLesson5.equals(true) && afterClickLesson4.equals(false)) {
				count = count + 1;
			}

			int retRow5 = excelObj.getRowNum("Military_rightArrow");
			String RetVal5 = excelObj.getCellData(retRow5, "Xpath");
			By element5 = By.xpath(RetVal5);
			driver.findElement(element5).click();

			int retRow6 = excelObj.getRowNum("Military_getStartedLesson4");
			String RetVal6 = excelObj.getCellData(retRow6, "Xpath");
			By element6 = By.xpath(RetVal6);

			Boolean afterRightClickLesson4 = driver.findElement(element6).isDisplayed();

			int retRow7 = excelObj.getRowNum("Military_getStartedLesson5");
			String RetVal7 = excelObj.getCellData(retRow7, "Xpath");
			By element7 = By.xpath(RetVal7);

			Boolean afterRightClickLesson5 = driver.findElement(element7).isDisplayed();

			if (afterRightClickLesson4.equals(true) && afterRightClickLesson5.equals(false)) {
				count = count + 1;
			}

			String sCount = Integer.toString(count);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");

			rescode = utilObj.verifyResponseCode(driver, test, utilObj, "Cursor and Verify Slides to The Direction");
			if (sCount.equals("2")) {
				String SSpath = utilObj.SaveScreenshot(driver, "Cursor and Verify Slides to The Direction");

				test.log(Status.INFO,
						"<b>Expected Result: </b> Cursor slides to The Direction should work successfully");
				test.pass("<b>Actual Result: </b> Cursor slides to The Direction was worked successfully"
						+ " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);
			} else {
				String SSpath = utilObj.SaveScreenshot(driver, "Cursor and Verify Slides to The Direction");
				test.log(Status.INFO,
						"<b>Expected Result: </b> Cursor slides to The Direction should work successfully");
				test.fail("<b>Actual Result: </b> Cursor slides to The Direction was not worked successfully"
						+ " , Response code :- " + rescode).addScreenCaptureFromPath(SSpath);
			}

		} catch (Exception e) {
			e.getMessage();
		} finally {
			driver.close();
		}

	}

	/*
	 * public void verifyRedirectionVerification(WebDriver driver, ExtentTest test,
	 * CommonUtility utilObj, Excel excelObj) throws MalformedURLException,
	 * IOException, InterruptedException {
	 * 
	 * String path = System.getProperty("user.dir"); System.out.println(path); File
	 * file = new File(path + "\\ExcelInput\\InputDataSheet.xlsx"); FileInputStream
	 * fis = new FileInputStream(file); XSSFWorkbook wb = new XSSFWorkbook(fis);
	 * XSSFSheet sheet = wb.getSheet("UrlList"); int rowCount =
	 * sheet.getLastRowNum() + 1; System.out.println("total rows :- " + rowCount);
	 * 
	 * for (int i = 1; i < rowCount; i++) {
	 * 
	 * MMBaseClass mm = new MMBaseClass(); driver = mm.MMBaseClass("Chrome");
	 * driver.manage().window().maximize(); String launchUrl =
	 * sheet.getRow(i).getCell(0).getStringCellValue(); String expectedURL =
	 * sheet.getRow(i).getCell(1).getStringCellValue(); // String reportText =
	 * sheet.getRow(i).getCell(1).getStringCellValue();
	 * 
	 * driver.navigate().to(launchUrl); startTime = System.currentTimeMillis();
	 * rescode = utilObj.verifyResponseCode(driver, test, utilObj, launchUrl);
	 * String actualURL = driver.getCurrentUrl(); endTime =
	 * System.currentTimeMillis(); loadTime = endTime - startTime;
	 * 
	 * if (actualURL.equals(expectedURL)) { String SSpath =
	 * utilObj.SaveScreenshot(driver, "URL:-" + i);
	 * 
	 * test.log(Status.INFO,
	 * "<b>Expected Result: </b> Expected url should launch successfully , URL :- "
	 * + expectedURL); test.
	 * pass("<b>Actual Result: </b> Expected url was launched successfully , URL :- "
	 * + actualURL + " , Response code :- " + rescode +
	 * ", Page Load time in Milliseconds:- " + loadTime)
	 * .addScreenCaptureFromPath(SSpath); } else { String SSpath =
	 * utilObj.SaveScreenshot(driver, "URL:-" + i); test.log(Status.INFO,
	 * "<b>Expected Result: </b> Expected url should launch successfully , URL :- "
	 * + expectedURL); test.
	 * fail("<b>Actual Result: </b> Expected url was not launched successfully , URL :- "
	 * + actualURL + " , Response code :- " + rescode +
	 * ", Page Load time in Milliseconds:- " + loadTime)
	 * .addScreenCaptureFromPath(SSpath); }
	 * 
	 * driver.close(); }
	 * 
	 * }
	 */ public void verifyCursor(WebDriver driver, ExtentTest test, CommonUtility utilObj, Excel excelObj) {
		try {

			excelObj.setSheet("Xpath");
			int retRow = excelObj.getRowNum("military_commnet01");
			String RetVal = excelObj.getCellData(retRow, "Xpath");
			By element = By.xpath(RetVal);

			Boolean comment01BeforeNext = driver.findElement(element).isDisplayed();

			int retRow1 = excelObj.getRowNum("military_commetNext");
			String RetVal1 = excelObj.getCellData(retRow1, "Xpath");
			By element1 = By.xpath(RetVal1);

			driver.findElement(element1).click();

			Boolean comment01AfterNext = driver.findElement(element).isDisplayed();

			int retRow2 = excelObj.getRowNum("military_commentPrevious");
			String RetVal2 = excelObj.getCellData(retRow2, "Xpath");
			By element2 = By.xpath(RetVal2);

			driver.findElement(element2).click();

			Boolean comment01AfterPrevious = driver.findElement(element).isDisplayed();

			rescode = utilObj.verifyResponseCode(driver, test, utilObj, "Cursor and Verify Slides to The Direction");
			if (comment01BeforeNext.equals(true) && comment01AfterNext.equals(false)
					&& comment01AfterPrevious.equals(true)) {
				String SSpath = utilObj.SaveScreenshot(driver, "Cursor and Verify Slides to The Direction");

				test.log(Status.INFO,
						"<b>Expected Result: </b> Below GET MISSION READY section Cursor slides to The Direction should work successfully");
				test.pass(
						"<b>Actual Result: </b> Below GET MISSION READY section Cursor slides to The Direction was worked successfully"
								+ " , Response code :- " + rescode)
						.addScreenCaptureFromPath(SSpath);
			} else {
				String SSpath = utilObj.SaveScreenshot(driver, "Cursor and Verify Slides to The Direction");
				test.log(Status.INFO,
						"<b>Expected Result: </b> Below GET MISSION READY section Cursor slides to The Direction should work successfully");
				test.fail(
						"<b>Actual Result: </b> Below GET MISSION READY section Cursor slides to The Direction was not worked successfully"
								+ " , Response code :- " + rescode)
						.addScreenCaptureFromPath(SSpath);
			}

		} catch (Exception e) {
			e.getMessage();
		} finally {
			driver.close();
		}

	}

	public void verifyRedirectionVerification(WebDriver driver, ExtentTest test, CommonUtility utilObj, Excel excelObj)
			throws IOException {

		String path = System.getProperty("user.dir");
		System.out.println(path);
		File file = new File(path + "\\ExcelInput\\InputDataSheet.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("UrlList");
		int rowCount = sheet.getLastRowNum() + 1;

		for (int i = 1; i < rowCount; i++) {

			MMBaseClass mm = new MMBaseClass();
			excelObj.setSheet("Browser&URL");
			int retRow = excelObj.getRowNum("RedirectionVerification");
			String browser = excelObj.getCellData(retRow, "Browser name");
			driver = mm.MMBaseClass(browser);
			driver.manage().window().maximize();
			String launchUrl = sheet.getRow(i).getCell(0).getStringCellValue();
			String expectedURL = sheet.getRow(i).getCell(1).getStringCellValue();
			// String reportText = sheet.getRow(i).getCell(1).getStringCellValue();

			driver.navigate().to(launchUrl);
			startTime = System.currentTimeMillis();
			rescode = utilObj.verifyResponseCode(driver, test, utilObj, launchUrl);
			String actualURL = driver.getCurrentUrl();
			endTime = System.currentTimeMillis();
			loadTime = endTime - startTime;

			if (actualURL.equals(expectedURL)) {
				String SSpath = utilObj.SaveScreenshot(driver, "URL:-" + i);

				test.log(Status.INFO,
						"<b>Expected Result: </b> Expected url should launch successfully , URL :- " + expectedURL);
				test.pass("<b>Actual Result: </b> Expected url was launched successfully , URL :- " + actualURL
						+ " , Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
						.addScreenCaptureFromPath(SSpath);
			} else {
				String SSpath = utilObj.SaveScreenshot(driver, "URL:-" + i);
				test.log(Status.INFO,
						"<b>Expected Result: </b> Expected url should launch successfully , URL :- " + expectedURL);
				test.fail("<b>Actual Result: </b> Expected url was not launched successfully , URL :- " + actualURL
						+ " , Response code :- " + rescode + ", Page Load time in Milliseconds:- " + loadTime)
						.addScreenCaptureFromPath(SSpath);
			}

			driver.close();
		}

	}

}
