package StepDefinition;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import CommonMethods.CommonUtility;
import PageObjects.MovementHomePage;
import io.cucumber.core.plugin.Options;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.http.ConnectionFailedException;

public class MMBaseClass {

	public String getURL;
	static WebDriver driver;

	public static WebDriver MMBaseClass(String Broswername) {

		switch (Broswername) {
		case "Chrome":
			ChromeOptions Chrome = new ChromeOptions();
			Chrome.addArguments("--remote-allow-origins=*");
			// Chrome.setHeadless(true);

			driver = new ChromeDriver(Chrome);

			break;
		case "Edge":

			System.setProperty("webdriver.gicko.driver",
					System.getProperty("user.dir") + "\\target\\test-classes\\drivers\\msedgedriver.exe");

			EdgeOptions Edge = new EdgeOptions();
			Edge.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(Edge);
			break;
		case "Headless":

			ChromeOptions Chrome1 = new ChromeOptions();
			Chrome1.addArguments("--remote-allow-origins=*");
			Chrome1.addArguments("--disable-gpu");
			Chrome1.addArguments("--window-size=1280,800");
			Chrome1.addArguments("--allow-insecure-localhost");
			// specifically this line here :)
			// Chrome1.addAdditionalCapability("acceptInsecureCerts", true, true);

			Chrome1.setHeadless(true);

			driver = new ChromeDriver(Chrome1);
			break;
		case "Firefox":

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		}
		return driver;
	}

	public void MMBaseClass() {

	}
	// public void openBrowser() {

	// }
}