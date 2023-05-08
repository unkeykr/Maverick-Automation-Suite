package StepDefinition;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

import org.apache.commons.io.FilenameUtils;
import org.junit.Assume;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
////import com.aventstack.extentreports.gherkin.model.Scenario;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import CommonMethods.CommonUtility;
import CommonMethods.Excel;
import PageObjects.MovementHomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MovementMortgage extends MMBaseClass {
	public static ExtentReports extent;
	ExtentTest test;
	CommonUtility UtilObj = new CommonUtility();
	static WebDriver driver;
	Excel excelObj = new Excel(System.getProperty("user.dir") + "\\ExcelInput\\InputDataSheet.xlsx");
	MovementHomePage MMObj = new MovementHomePage(driver);
	String pageNotFound = "404";
	long startTime, endTime, loadTime;

	@BeforeAll
	public static void BeforeSuite() {
		extent = new ExtentReports();
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("MovementMortgageReport.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Movement Mortgage Report");
		htmlReporter.config().setReportName("MM Regression Test Suite");
		extent.attachReporter(htmlReporter);

	}

	@Before
	public void BeforeScenario(Scenario scenario) {
		String SceanrioName = scenario.getName();
		Boolean flag = UtilObj.checkRunFlag(SceanrioName, excelObj);
		Assume.assumeTrue(flag);
		test = extent.createTest(scenario.getName());

	}

	@After
	public void AfterScenario() {
		extent.flush();
	}

	@Given("Movement Home Page URL is Loaded Successfully")
	public void MovementHomePageLaunch() throws Exception {

		excelObj.setSheet("Browser&URL");
		int retRow = excelObj.getRowNum("MovementMortgage");
		String MMURL = excelObj.getCellData(retRow, "URL");
		String browser = excelObj.getCellData(retRow, "Browser name");
		driver = MMBaseClass(browser);
		startTime = System.currentTimeMillis();

		// Calling Method to launch the URL of the Movement Mortgage Application
		UtilObj.LaunchURL(driver, MMURL);
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;
		excelObj.close();
		int rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Movement Mortgage");
		MMObj.verifyHomeURLResponse(driver, test, UtilObj, rescode, loadTime, "Movement Mortgage");
	}

	@Then("Home Page is loaded successfully with Movement Mortgage Logo")
	public void Home_Page_is_loaded_successfully() throws IOException {

		// Calling MM Logo verification method
		MMObj.MMLogoverification(driver, test, UtilObj, excelObj);
	}

	@Then("Verify Movement Mortgage Menu Options")
	public void verify_landing_page() throws IOException {
		// Calling Method to verify Five Menu button verification present on Movement
		// Home page
		MMObj.ButtonVerification(driver, test, UtilObj, excelObj);

	}

	@Then("Close the browser")
	public void Close_Browser() {
		// Calling Method to close the launched browser
		UtilObj.closeBrowser(driver);

	}

	@Then("Close browser")
	public void close_Browser() {
		// Calling Method to close the launched browser
		// UtilObj.closeBrowser(driver);

	}

	@Then("Hover Careers Menu to verify Submenu")
	public void VerifySubmenus() throws IOException

	{
		// Calling Method to verify Careers Menu on Movement Home Page
		MMObj.CareersSubmenu(driver, test, UtilObj, excelObj);
	}

	@Then("Open Careers Submenu to verify their screen and URL")
	public void Verify_SubmenusScreen() throws IOException, InterruptedException {

		// Calling Method to verify Work at Movement Sub Menu of Careers Menu
		MMObj.CareersSubmenu_1(driver, test, UtilObj, excelObj);

		// Calling Method to verify Loan Officer Sub Menu of Careers Menu
		MMObj.CareersSubmenu_2(driver, test, UtilObj, excelObj);

	}

	@Then("Hover About Menu to verify Submenu")
	public void AboutHoverVerify() throws IOException {

		// Calling Method to verify About Sub menu of Movement home page
		MMObj.AboutSubmenu(driver, test, UtilObj, excelObj);

	}

	@Then("Open About Submenu to verify their screen and URL")
	public void Verify_AboutSubmenusScreen() throws IOException, InterruptedException {

		// Calling method to verify Our Story Sub Menu redirect page and URL
		MMObj.AboutSubmenu_1(driver, test, UtilObj, excelObj);

		// Calling method to verify Our Leadership Sub Menu redirect page and URL
		MMObj.AboutSubmenu_2(driver, test, UtilObj, excelObj);

		// Calling method to verify The Blog Sub Menu redirect page and URL
		MMObj.AboutSubmenu_3(driver, test, UtilObj, excelObj);
	}

	@Then("Hover Home Loans Menu to verify Submenu")
	public void HomeLoansHoverVerify() throws IOException {

		// Calling method to verify Home Loans Menu hovering
		MMObj.HomeLoansSubmenu(driver, test, UtilObj, excelObj);

	}

	@Then("Open Home Loans Submenu to verify their screen and URL")
	public void Verify_HomeLoansSubmenusScreen() throws IOException, InterruptedException {

		// Calling Method to verify Find a Loan Sub Menu redirect page and URL
		MMObj.HomeLoanSubmenu_1(driver, test, UtilObj, excelObj);

		// Calling Method to verify Our Process Sub Menu redirect page and URL
		MMObj.HomeLoanSubmenu_2(driver, test, UtilObj, excelObj);

	}

	@Then("Hover Customers Menu to verify Submenu")
	public void CustomersHover() throws IOException, InterruptedException {

		// Calling method to verify Customers sub Menus by hovering
		MMObj.CustomersSubmenu(driver, test, UtilObj, excelObj);

	}

	@Then("Open Customers Submenu to verify their screen and URL")
	public void CustomersSubmenuScreenURLVerify() throws IOException, InterruptedException {

		// Calling Method to verify Careers sub menu: Pay My Mortgage screen and URL
		MMObj.CustomersSubmenu_1(driver, test, UtilObj, excelObj);

		// Calling Method to verify Support and Servicing Sub Menu screen and URL
		MMObj.CustomersSubmenu_2(driver, test, UtilObj, excelObj);

	}

	@Then("Click on Apply Now to verify Lets Get Started Page")
	public void ApplyNowButtonVerify() throws IOException {

		// Calling Method to verify Apply Now button on MM home Page
		MMObj.ApplyNowVerify(driver, test, UtilObj, excelObj);

	}

	@Then("Verify two sub Menu options")
	public void ApplyNowSubMenusVerify() throws IOException {

		MMObj.ApplyNowSubmenu(driver, test, UtilObj, excelObj);

	}

	@Then("Verify the Screen and URLs of the Apply Now sub menus by clicking on them")
	public void Verify_ApplyNowSubmenusScreen() throws IOException, InterruptedException {

		// Calling Method to verify Find a I want to find aLoan Officer Sub Menu
		MMObj.ApplyNowSubmenu_1(driver, test, UtilObj, excelObj);

		// Calling Method to verify I want to start an Application Sub Menu
		MMObj.ApplyNowSubmenu_2(driver, test, UtilObj, excelObj);

	}

	@Then("Click on the Movement Mortgage Logo to redirect on Home Page")
	public void Verify_HomePageRedirect() throws IOException, InterruptedException {

		// calling Method to verify MM logo Redirect verification
		MMObj.MMLogoHomePageRedirect(driver, test, UtilObj, excelObj);

	}

	@Then("Click on Contact button to verify its screen and URL")
	public void ContactScreenURL() throws IOException {

		// Calling Method to verify Contact Menu page and URL on MM Home Page
		MMObj.ContactVerify(driver, test, UtilObj, excelObj);

	}

	@Then("Click on Learn More About Us button to verify its screen and URL")
	public void LearnMoreAboutUsScreenURL() throws IOException {

		// Calling method to verify Learn More About Us Button verification
		MMObj.LearnMoreAboutVerify(driver, test, UtilObj, excelObj);

	}

	@Then("Click on View Loans button to verify its screen and URL")
	public void ViewLoansScreenURL() throws IOException {

		// Calling Method to verify View Loans page and URL
		MMObj.ViewLoansVerify(driver, test, UtilObj, excelObj);

	}

	@Then("Click on Find A loan Officer button to verify its screen and URL")
	public void FindALoanOfficerScreeURL() throws IOException {

		// Calling Method to verify Find a Loan Officer Button and URL
		MMObj.FindALoanOffVerify(driver, test, UtilObj, excelObj);

	}

	@Then("Scroll to Carousel section to verify using left and right arrow")
	public void VerifyCarousel() throws IOException {

		// Calling Method for Carousel verification by clicking right arrow
		MMObj.CarouselVerifyRight(driver, test, UtilObj, excelObj);

		// Calling Method for Carousel verification by clicking left arrow
		MMObj.CarouselVerifyLeft(driver, test, UtilObj, excelObj);

	}

	@Then("Click on small image on right to verify enlargement")
	public void VerifyImageEnlargement() throws InterruptedException, IOException {
		// Calling Method to verify image enlargement by clicking small images on right
		// side
		MMObj.ImageEnlargement(driver, test, UtilObj, excelObj);

	}

//********************* lo.movement.com URL 2 scenario verification*************************

	@Given("Loan Officer Movement Home Page URL is Loaded Successfully")
	public void LOMovementHomePageLaunch() throws Exception {

		excelObj.setSheet("Browser&URL");
		int retRow = excelObj.getRowNum("LoanOfficerMovementMortgage");
		String MMURL = excelObj.getCellData(retRow, "URL");
		String browser = excelObj.getCellData(retRow, "Browser name");
		driver = MMBaseClass(browser);
		startTime = System.currentTimeMillis();

		// Calling Method to launch the URL of the Movement Mortgage Loan Officer
		// Application
		UtilObj.LaunchURL(driver, MMURL);
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;
		excelObj.close();
		int rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Movement Loan Officer");
		MMObj.verifyHomeURLResponse(driver, test, UtilObj, rescode, loadTime, "Movement Loan Officer ");
		UtilObj.verifyResponseCode(driver, test, UtilObj, "Movement Loan Officer");
	}

	@Then("Loan Officer page loaded successfully with Movement Mortgage Logo")
	public void loMMLogoverification() throws IOException {

		// Calling Loan officer MM Logo verification method
		MMObj.LoanOfficerMMLogoverification(driver, test, UtilObj, excelObj);

	}

	@Then("Verify Movement Mortgage Loan officer picture")
	public void loPictureVerification() throws IOException {
		// Calling Loan officer picture verification method
		MMObj.LoanOfficerPictureVerification(driver, test, UtilObj, excelObj);

	}

	@Then("Verify three menu options About Pete,Find My Mortgage,Free Tools")
	public void loMenuVerification() throws IOException {

		// Calling Loan officer three menu verification method
		MMObj.LoanOfficerMenuVerification(driver, test, UtilObj, excelObj);

	}

	@Then("Verify Start My Application button")
	public void startMyApplicationutton() throws IOException {

		// Calling Start My Application Button verification method
		MMObj.startMyApplicationVerification(driver, test, UtilObj, excelObj);

	}

	@Then("Verify About Pete Menu")
	public void verifyAboutLO() throws IOException {

		// Calling About Pete verification method
		MMObj.AboutMeVerification(driver, test, UtilObj, excelObj);
	}

	@Then("Verify Find My Mortgage")
	public void VerifyFindMyMortgage() throws IOException {

		// Calling Find My Mortgage verification method
		MMObj.FindMyMortgageVerification(driver, test, UtilObj, excelObj);
	}

	@Then("Verify Free Tools")
	public void verifyFreeTools() throws IOException {

		// Calling Free Tools verification method
		MMObj.FreeToolsVerification(driver, test, UtilObj, excelObj);
	}

	@Then("Verify Go To Calculator Redirect")
	public void verifyGoCalculator() throws IOException, InterruptedException {

		// Calling Free Tools verification method
		MMObj.GoCalculatorVerification(driver, test, UtilObj, excelObj);
	}

	@Then("Verify Find A Loan Redirect")
	public void verifyFindALoanRedirect() throws IOException {

		// Calling Free Tools verification method
		MMObj.LOFindALoanVerification(driver, test, UtilObj, excelObj);
	}

	@Then("Verify Pay My Mortgage Redirect")
	public void verifyPayMyMortgageRedirect() throws IOException {

		// Calling Pay My Mortgage verification method
		MMObj.PayMyMortgageVerification(driver, test, UtilObj, excelObj);
	}

	@Then("Verify Market Update Redirect")
	public void verifyMarketUpdateRedirect() throws IOException, InterruptedException {

		// Calling Market Update page redirect and URL verification method
		MMObj.MarketUpdateVerification(driver, test, UtilObj, excelObj);
	}

	@Then("Verify Movement NewsRoom")
	public void verifyMovementNewsRoom() throws IOException, InterruptedException {

		// Calling Market Update page redirect and URL verification method
		MMObj.MovementNewsRoomVerification(driver, test, UtilObj, excelObj);
	}

	@Then("Verify More FAQs Redirect")
	public void verifyMoreFAQRedirect() throws IOException, InterruptedException {

		// Calling Market Update page redirect and URL verification method
		MMObj.MoreFAQsVerification(driver, test, UtilObj, excelObj);
	}

	@Then("Verify MM Twitter page")
	public void verify_mm_twitter_page() throws IOException, InterruptedException {
		MovementHomePage MMObj = new MovementHomePage(driver);
		// Calling MM Twitter page verification method
		MMObj.MMTwitterVerification(driver, test, UtilObj, excelObj);
	}

	@Then("Verify MM Instagram page")
	public void verify_mm_instagram_page() throws IOException, InterruptedException {
		// Calling MM Instagram page verification method
		MMObj.MMInstagramVerification(driver, test, UtilObj, excelObj);
	}

	@Then("Verify MM Facebook page")
	public void verify_mm_facebook_page() throws IOException, InterruptedException {

		// Calling MM Facebook page verification method
		MMObj.MMFacebookVerification(driver, test, UtilObj, excelObj);
	}

	@Then("Verify MM LinkedIn page")
	public void verify_mm_linked_in_page() throws IOException, InterruptedException {

		// Calling MM LinkedIn page verification method
		MMObj.MMLinkedInVerification(driver, test, UtilObj, excelObj);
	}

	@Then("Verify MM YouTube page")
	public void verify_mm_you_tube_page() throws IOException, InterruptedException {

		// Calling MM Youtube page verification method
		MMObj.MMYoutubeVerification(driver, test, UtilObj, excelObj);
	}

	@Then("Verify Moved By Love Video")
	public void verify_moved_by_love_video() throws IOException, InterruptedException {

		// Calling MM Moved by Love video play verification method
		MMObj.MovedByLoveVerification(driver, test, UtilObj, excelObj);
	}

	@Then("Verify Ten Year anniversary Video")
	public void verify_year_anniversary_video() throws IOException, InterruptedException {

		// Calling MM 10 Year Anniversary video play verification method
		MMObj.TenYearAnniversaryVerification(driver, test, UtilObj, excelObj);
	}

	@Then("Verify contact form submit")
	public void verify_contact_form() throws IOException, InterruptedException {

		// Calling MM 10 Year Anniversary video play verification method
		MMObj.ContactLOVerification(driver, test, UtilObj, excelObj);
	}

//**************************URL 3 MM Military Glue Code********************************

	@Given("Movement military Page is Loaded Successfully")
	public void movement_military_page_is_loaded_successfully() throws MalformedURLException, IOException {

		excelObj.setSheet("Browser&URL");
		int retRow = excelObj.getRowNum("MovementMilitary");
		String MMURL = excelObj.getCellData(retRow, "URL");
		String browser = excelObj.getCellData(retRow, "Browser name");
		driver = MMBaseClass(browser);
		startTime = System.currentTimeMillis();

		// Calling Method to launch the URL of the Movement Military Application
		UtilObj.LaunchURL(driver, MMURL);
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;
		excelObj.close();
		int rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Movement Military");
		MMObj.verifyHomeURLResponse(driver, test, UtilObj, rescode, loadTime, "Movement Military");
		UtilObj.verifyResponseCode(driver, test, UtilObj, "Movement Military");

	}

	@Then("Verify Movement Military url and Page Loaded successfully")
	public void verify_movement_military_url_and_page_loaded_successfully() throws IOException {

		// Calling Military page verification method
		MMObj.movementmilitaryUrlVerification(driver, test, UtilObj, excelObj);

	}

	@Then("Verify Movement Mortgage Military logo")
	public void verify_movement_mortgage_logo() throws IOException {

		// Calling Logo verification method
		MMObj.MMLogoverificationonMilitaryPage(driver, test, UtilObj, excelObj);

	}

	@Then("Verify Resource Library,Why Movement Options beside MM Logo")
	public void verify_resource_library_why_movement_options_beside_mm_logo() throws IOException {

		// Calling Resource Library verification method
		MMObj.resourceLibraryVerification(driver, test, UtilObj, excelObj);

		// Calling Why Movement verification method
		MMObj.whyMovementVerification(driver, test, UtilObj, excelObj);

	}

	@Then("Click on Resource library menu and verify url")
	public void click_on_resource_library_menu_and_verify_url() throws IOException {

		// Calling verify resourceLibrary method
		MMObj.verifyResourcelibraryurl(driver, test, UtilObj, excelObj);
	}

	@Then("Click on Why movement menu and verify url")
	public void click_on_why_movement_menu_and_verify_url() throws IOException {
		// Calling verify why movement method
		MMObj.verifyWhymovementurl(driver, test, UtilObj, excelObj);

	}

	@Then("Verify form submitted or not")
	public void verify_form_submitted_or_not() throws IOException {

		MMObj.verifyFormSubmittedorNot(driver, test, UtilObj, excelObj);
	}

	@Then("Click on Discover my benefits button and verify url")
	public void click_on_discover_my_benefits_button_and_verify_url() throws IOException {

		// Calling discover my benefits page and url
		MMObj.verifyDiscovvermyBenefitsURL(driver, test, UtilObj, excelObj);
	}

	@Then("Click on Permanent Change of Station button and verify url")
	public void click_on_d_permanent_change_of_station_button_and_verify_url() throws IOException {

		// Calling Permanent Change of Station button method
		MMObj.verifyPermanentChangeofStationURL(driver, test, UtilObj, excelObj);
	}

	@Then("Click on Buy my first home button and verify url")
	public void click_on_buy_my_first_home_button_and_verify_url() throws IOException {

		// Calling Buy my first home button method
		MMObj.verifyBuymyFirstHomeURL(driver, test, UtilObj, excelObj);
	}

	@Then("Click on Lower my payments or buy again button and verify url")
	public void click_on_lower_my_payments_or_buy_again_button_and_verify_url() throws IOException {

		// Calling Lower my payments or buy again method
		MMObj.verifyLowermypaymentsorbuyagainURL(driver, test, UtilObj, excelObj);
	}

	@Then("Click on Lesson {int} video and verify the url")
	public void click_on_lesson_video_and_verify_the_url(Integer int1) throws IOException {

		MMObj.verifyLesson1(driver, test, UtilObj, excelObj);
	}

	@Then("Click on second lesson video and verify the url")
	public void click_on_second_lesson_video_and_verify_the_url() throws IOException {

		MMObj.verifyLesson2(driver, test, UtilObj, excelObj);
	}

	@Then("Click on third lesson video and verify the url")
	public void click_on_third_lesson_video_and_verify_the_url() throws IOException {
		MMObj.verifyLesson3(driver, test, UtilObj, excelObj);
	}

	@Then("Click on fourth lesson video and verify the url")
	public void click_on_fourth_lesson_video_and_verify_the_url() throws IOException {
		MMObj.verifyLesson4(driver, test, UtilObj, excelObj);
	}

	@Then("Click on fifth lesson video and verify the url")
	public void click_on_fifth_lesson_video_and_verify_the_url() throws IOException, InterruptedException {
		MMObj.verifyLesson5(driver, test, UtilObj, excelObj);
	}

	@Then("Click on Get Started button under first Lesson and verify the url")
	public void click_on_get_started_button_under_first_lesson_and_verify_the_url() throws IOException {

		MMObj.verifyLesson1underGetStarted(driver, test, UtilObj, excelObj);
	}

	@Then("Click on Get Started button under second Lesson and verify the url")
	public void click_on_get_started_button_under_second_lesson_and_verify_the_url() throws IOException {

		MMObj.verifyLesson2underGetStarted(driver, test, UtilObj, excelObj);
	}

	@Then("Click on Get Started button under third Lesson and verify the url")
	public void click_on_get_started_button_under_third_lesson_and_verify_the_url() throws IOException {

		MMObj.verifyLesson3underGetStarted(driver, test, UtilObj, excelObj);
	}

	@Then("Click on Get Started button under fourth Lesson and verify the url")
	public void click_on_get_started_button_under_fourth_lesson_and_verify_the_url() throws IOException {

		MMObj.verifyLesson4underGetStarted(driver, test, UtilObj, excelObj);
	}

	@Then("Click on Get Started button under fifth Lesson and verify the url")
	public void click_on_get_started_button_under_fifth_lesson_and_verify_the_url()
			throws IOException, InterruptedException {

		MMObj.verifyLesson5underGetStarted(driver, test, UtilObj, excelObj);
	}

	@Then("Click on View Full Library button and verify the url")
	public void click_on_view_full_library_button_and_verify_the_url() throws IOException {

		MMObj.verifyViewFullLibraryURL(driver, test, UtilObj, excelObj);
	}

	@Then("Click on Start Now button below Get mission ready section and verify a form")
	public void click_on_start_now_button_below_get_mission_ready_section_and_verify_a_form()
			throws IOException, InterruptedException {

		MMObj.clickOnGetstartedButtonandEnterSetofdata(driver, test, UtilObj, excelObj);
	}

	@Then("Click on Get Started beside READY TO GO? and verify a form")
	public void click_on_get_started_beside_ready_to_go_and_verify_a_form() throws IOException, InterruptedException {

		MMObj.clickOnGetstartedButtonandEnterSetofdata(driver, test, UtilObj, excelObj);

	}

	@Then("Click on cursor and verify slides to the direction it is clicked")
	public void click_on_cursor_and_verify_slides_to_the_direction_it_is_clicked() throws IOException {

		// MMObj.verifyCursorandVerifySlidestoTheDirection(driver, test, UtilObj,
		// excelObj);
		MMObj.verifyCursor(driver, test, UtilObj, excelObj);

	}

	@Then("Click on Arrows beside VA Loan bootcamp and verify the lesson slides to the direction it is clicked")
	public void click_on_arrows_beside_va_loan_bootcamp_and_verify_the_lesson_slides_to_the_direction_it_is_clicked()
			throws IOException, InterruptedException {

		// MMObj.verifyVABootcampCursorandVerifySlidestoTheDirection(driver, test,
		// UtilObj, excelObj);
		MMObj.verifyArrowsBesideVAloan(driver, test, UtilObj, excelObj);
	}

	@Then("Click on ? bot and verify new prompt")
	public void click_on_bot_and_verify_new_prompt() throws IOException {

		MMObj.verifyquestionmark(driver, test, UtilObj, excelObj);
	}

	@Then("Click on Start Now button below Get mission ready section")
	public void click_on_start_now_button_below_get_mission_ready_section() throws IOException, InterruptedException {
		// MMObj.verifyStartNowbuttonbelowGetmissionreadysection(driver, test, UtilObj,
		// excelObj);
		MMObj.clickOnGetstartedButtonandEnterSetofdata(driver, test, UtilObj, excelObj);
	}

	@Then("Click on Get Started beside READY TO GO?")
	public void click_on_get_started_beside_ready_to_go() throws IOException, InterruptedException {
		// MMObj.verifyGetStartedbesideREADYTOGO(driver, test, UtilObj, excelObj);
		MMObj.clickOnGetstartedButtonandEnterSetofdata(driver, test, UtilObj, excelObj);
	}

	@Then("Click on Get started button and enter data and click next")
	public void click_on_get_started_button_and_enter_data_and_click_next()
			throws AWTException, InterruptedException, MalformedURLException, IOException {

		// Calling click on get started button and enter data

		MMObj.clickOnGetstartedButtonandEnterSetofdata(driver, test, UtilObj, excelObj);
	}

// *******************URL 4 MM BLOG Glue Code**************************************************************

	@Given("Movement blog Page is Loaded Successfully")
	public void movement_blog_page_is_loaded_successfully() throws MalformedURLException, IOException {

		excelObj.setSheet("Browser&URL");
		int retRow = excelObj.getRowNum("MovementBlog");
		String MMURL = excelObj.getCellData(retRow, "URL");
		String browser = excelObj.getCellData(retRow, "Browser name");
		driver = MMBaseClass(browser);
		startTime = System.currentTimeMillis();

		// Calling Method to launch the URL of the Movement Blog Application
		UtilObj.LaunchURL(driver, MMURL);
		endTime = System.currentTimeMillis();
		loadTime = endTime - startTime;
		excelObj.close();
		int rescode = UtilObj.verifyResponseCode(driver, test, UtilObj, "Movement Blog");
		MMObj.verifyHomeURLResponse(driver, test, UtilObj, rescode, loadTime, "Movement Blog");
		UtilObj.verifyResponseCode(driver, test, UtilObj, "Movement Blog");
	}

	@Then("Click on {int} dots beside Categories Option")
	public void click_on_dots_beside_categories_option(Integer int1) throws InterruptedException {

		MMObj.clickOnThreedots(driver, test, UtilObj, excelObj);
	}

	@Then("Click on Movement News option inside Categories Option and verify url")
	public void click_on_movement_news_option_inside_categories_option_and_verify_url()
			throws IOException, InterruptedException {

		MMObj.clickOnMovementNewsandVerifyURL(driver, test, UtilObj, excelObj);
	}

	@Then("Click on Mortgage {int} option inside Categories Option and verify url")
	public void click_on_mortgage_option_inside_categories_option_and_verify_url(Integer int1)
			throws InterruptedException, IOException {

		MMObj.clickOnMortgage101andVerifyURL(driver, test, UtilObj, excelObj);
	}

	@Then("Click on Spotlight option inside Categories Option and verify url")
	public void click_on_spotlight_option_inside_categories_option_and_verify_url()
			throws InterruptedException, IOException {

		MMObj.clickOnSportlightandVerifyURL(driver, test, UtilObj, excelObj);
	}

	@Then("Click on {int} lines on blog home page")
	public void click_on_lines_on_blog_home_page(Integer int1) throws InterruptedException {

		MMObj.clickOnThreelines(driver, test, UtilObj, excelObj);
	}

	@Then("Click on About option and verify url")
	public void click_on_about_option_and_verify_url() throws InterruptedException, IOException {

		MMObj.clickOnAboutandVerifyURL(driver, test, UtilObj, excelObj);
	}

	@Then("Click on movement.com option and verify url")
	public void click_on_movement_com_option_and_verify_url() throws IOException {

		MMObj.clickOnmovementdotcomandVerifyURL(driver, test, UtilObj, excelObj);
	}

	@Then("Click on MARKET UPDATE and verify url")
	public void click_on_market_update_and_verify_url() throws IOException, InterruptedException {

		MMObj.verifyMarketUpdate(driver, test, UtilObj, excelObj);
	}

	@Then("verify url")
	public void verify_url() throws IOException {

		MMObj.verifyTheURL(driver, test, UtilObj, excelObj);
	}

	@Then("verify MovementBlog logo")
	public void verify_movement_blog_logo() throws IOException {

		MMObj.verifyMovementBloglogo(driver, test, UtilObj, excelObj);

	}

	@Then("verify BlogMovement logo")
	public void verify_blog_movement_logo() throws IOException {
		MMObj.verifyMovementBloglogo(driver, test, UtilObj, excelObj);
	}

	@Then("Click on search button and verify Search field")
	public void click_on_search_button_and_verify_search_field() throws IOException {

		MMObj.verifySearchButton(driver, test, UtilObj, excelObj);
	}

	@Then("Click on Hamburger icon and verify Home,Trending,Categories,About,Movement.com")
	public void click_on_hamburger_icon_and_verify_home_trending_categories_about_movement_com()
			throws IOException, InterruptedException {

		MMObj.verifyHamburgerIcon(driver, test, UtilObj, excelObj);
	}

	@Then("Click on Home option and verify url")
	public void click_on_home_option_and_verify_url() throws IOException {
		MMObj.verifyHomeOption(driver, test, UtilObj, excelObj);
	}

	@Then("Click on Trending option and verify url")
	public void click_on_trending_option_and_verify_url() throws IOException {
		MMObj.verifyTrendingOption(driver, test, UtilObj, excelObj);
	}

	@Then("Click on category Option and verify more options pops up with the option to navigate back to the original option")
	public void click_on_category_option_and_verify_more_options_pops_up_with_the_option_to_navigate_back_to_the_original_option()
			throws InterruptedException, IOException {
		MMObj.verifyCategoryOptionandMoreOptions(driver, test, UtilObj, excelObj);
	}

	@Then("Click on Market Update option inside Categories Option and verify url")
	public void click_on_market_update_option_inside_categories_option_and_verify_url()
			throws InterruptedException, IOException {

		MMObj.clickOnMarketUpdateandVerifyURL(driver, test, UtilObj, excelObj);
	}

	@Then("Click on Movement Foundation option inside Categories Option and verify url")
	public void click_on_movement_foundation_option_inside_categories_option_and_verify_url()
			throws InterruptedException, IOException {

		MMObj.clickOnMovementFoundationandVerifyURL(driver, test, UtilObj, excelObj);
	}

// ----------------------------------------------------------------------------------------------//

	@Given("Open the browser")
	public void open_browser() {
		// driver = MMBaseClass("Chrome");
	}

	@Then("Launch url and verify")
	public void launch_url_and_verify() throws MalformedURLException, IOException, InterruptedException {

		MMObj.verifyRedirectionVerification(driver, test, UtilObj, excelObj);

	}

}
