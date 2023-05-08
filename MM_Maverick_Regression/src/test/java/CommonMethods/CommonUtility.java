package CommonMethods;

import static org.junit.Assert.fail;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.http.HttpConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;

import StepDefinition.MMBaseClass;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class CommonUtility extends MMBaseClass {
	// WebDriver driver;
	ExtentReports extentObj = new ExtentReports();
	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentTestReports.html");

	File destination;
	ExtentTest testObj;

	// Constructor

	public CommonUtility() {

	}

	// Launching URL Method
	public void LaunchURL(WebDriver driver, String URL) {
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

	}

	// Response code
	public int verifyResponseCode(WebDriver driver, ExtentTest test, CommonUtility UtilObj, String pageDescription)
			throws MalformedURLException, IOException {
		int res = 0;
		try {
			// establish, open connection with URL
			HttpURLConnection cn = (HttpURLConnection) new URL(driver.getCurrentUrl()).openConnection();
			// set HEADER request
			cn.setRequestMethod("HEAD");
			// connection initiate
			cn.connect();
			// get response code
			res = cn.getResponseCode();

		} catch (Exception e) {
			e.printStackTrace();
		}
		String responseCode = Integer.toString(res);
		if (responseCode.equals("404") || responseCode.equals("502") || responseCode.equals("999")) {
			String SSpath = UtilObj.SaveScreenshot(driver, pageDescription);
			test.log(Status.INFO,
					"<b>Expected Result: </b> " + pageDescription + " page should be loaded successfully");
			test.fail("<b>Actual Result: </b> " + pageDescription
					+ " page was not loaded successfully , Response code :- " + responseCode)
					.addScreenCaptureFromPath(SSpath);
			driver.close();
			fail();
		}
		return res;

	}

	// Reporting Method
	public void extentFlushTest() {
		// extentObj.flush();
	}

	public void extentReportFun(String StepStatus, String TestName, String ExpectedResult, String ActualResult,
			String SSPath) throws IOException {
		extentObj.attachReporter(htmlReporter);

		testObj = extentObj.createTest(TestName);
		// htmlReporter.setAppendExisting(true);
		testObj.log(Status.INFO, "<b>Expected Result: </b>" + ExpectedResult);

		if (StepStatus.equals("pass"))
			testObj.pass("<b>Actual Result: </b>" + ActualResult).addScreenCaptureFromPath(SSPath);
		else
			testObj.fail("<b>Actual Result: </b>" + ActualResult).addScreenCaptureFromPath(SSPath);
		;

		extentObj.flush();
		// htmlReporter.setAppendExisting(true);
	}

	// Capture Screenshot Method
	public String SaveScreenshot(WebDriver driver, String SShotName) throws IOException {

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			destination = new File(System.getProperty("user.dir") + "//target/screenshots//" + SShotName + ".jpg");
			Files.copy(source, destination);
			return destination.getAbsolutePath();
		} catch (IOException exception) {
			exception.printStackTrace();
			return destination.getAbsolutePath();
		}
	}

	// Closing browser method
	public void closeBrowser(WebDriver driver) {
		driver.quit();
	}

	// Highlight element
	public void highLightanElement(WebDriver driver, By resourceLibrary) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(resourceLibrary);
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
	}

	// scrolldownuntil element exists
	public void scrollDowbUntillElementExists(WebDriver driver, By resourceLibrary) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(resourceLibrary);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public boolean compareImage(WebDriver driver, WebElement element, String expectedImageName) throws IOException {

		// WebElement element = driver.findElement(MilitaryMMLogo);
		Screenshot actualMMlogo = new AShot().takeScreenshot(driver, element);
		ImageIO.write(actualMMlogo.getImage(), "PNG",
				new File(System.getProperty("user.dir") + "/ImageVerify/" + "test1.png"));

		BufferedImage actualImage = actualMMlogo.getImage();

		BufferedImage expectedImage = ImageIO
				.read(new File(System.getProperty("user.dir") + "/ImageVerify/" + expectedImageName));

		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);

		if (diff.hasDiff() == false) {
			return true;
		} else {

			return false;
		}
	}

	public boolean checkRunFlag(String ScenarioName, Excel excelObj) {
		Boolean flag;
		excelObj.setSheet("InputData");
		int retRow = excelObj.getRowNum(ScenarioName);
		String RetVal = excelObj.getCellData(retRow, "RunFlag");

		if (RetVal.equals("No")) {
			flag = false;
		} else
			flag = true;

		return flag;
	}

}
