package StepDefinition;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import CommonMethods.CommonUtility;
import CommonMethods.Excel;

public class DebuggingClass {

	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException 
	{	int retRow;
		String RetVal;
		//driver = new ChromeDriver("Chrome");
		CommonUtility UtilObj=new CommonUtility();
		Excel excelObj = new Excel(System.getProperty("user.dir")+"\\ExcelInput\\InputDataSheet.xlsx");
		
		driver.manage().window().maximize();
		driver.get("https://lo.movement.com/pete-griffin");
		
		excelObj.setSheet("Xpath");
		retRow = excelObj.getRowNum("LOMM_MoreFaq");
		RetVal = excelObj.getCellData(retRow, "Xpath");
		By LOMM_MoreFaq=By.xpath(RetVal);
		
		UtilObj.scrollDowbUntillElementExists(driver,LOMM_MoreFaq);
		
		String originalHandle=driver.getWindowHandle(); //first tab
		
		
		 retRow = excelObj.getRowNum("LOMM_MarketUpdate");
		 RetVal = excelObj.getCellData(retRow, "Xpath");
		driver.findElement(By.xpath(RetVal)).click();
		
		
		Set<String> currentPageHandles = driver.getWindowHandles();  
		boolean myNewTabFound = false;

		for(String handle : currentPageHandles)
		{	if(!handle.equals(originalHandle))
		    {
			driver.switchTo().window(handle);
			myNewTabFound = true; 
		    }

		}

		driver.switchTo().window(originalHandle);
		retRow = excelObj.getRowNum("LOMM_MoreFaq");
		 RetVal = excelObj.getCellData(retRow, "Xpath");
		driver.findElement(By.xpath(RetVal)).click();
		Thread.sleep(5000);
		driver.quit();
						

		
	}

}
