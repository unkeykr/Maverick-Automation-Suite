package CommonMethods;

import java.awt.print.Book;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.gson.JsonElement;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

public class TestProj {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException, ParseException {

		ChromeOptions option = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vinay.singh\\Documents\\chromedriver_win32\\chromedriver.exe");
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		driver.navigate().to("http://movement.com");
		long startTime=System.currentTimeMillis();
		driver.manage().window().maximize();
		//long startTime=System.currentTimeMillis();
		driver.navigate().to("http://movement.com");
		//long startTime=System.currentTimeMillis();
		//driver.get("https://www.minitool.com/news/web-pages-loading-slow-reasons-fixes.html");
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		long endTime=System.currentTimeMillis();
		long totalTime=endTime-startTime;
		System.out.println("Total loand time of the webpage :"+totalTime);
		//driver.close();
		
		//public void readJSONreport() throws IOException, ParseException
		//{
//			JSONParser jsonParser = new JSONParser();
//			FileReader reader = new FileReader(System.getProperty("user.dir") + "\\target\\Cucumber-Report\\CCreportjson.json");
//		
//			Object obj = jsonParser.parse(reader);
//			JsonElement  jsonEleObj=jsonParser.parse(obj);
//			JSONObject ScenarioElement=(JSONObject)obj;
//			JSONArray arr=(JSONArray)ScenarioElement.get("locatoin");
//			
//			
//			for(int i=0;i<arr.size();i++) 
//			{
//			JSONObject Sname = (JSONObject)arr.get(i);	
//			
//				//JSONObject Sname = (JSONObject)(((JSONArray)arr.get(i)).get(i));
//				
//				
//				//JSONObject Sname =arr.get(i).toString();
//			System.out.println("Scenario -> "+Sname);
//			String ScenarioNameValue = (String) Sname.get("name");
//			String SceanrioStatus = (String) Sname.get("status");
//			System.out.println("The Sceanrio name in JSON is: "+ScenarioNameValue);
//			System.out.println("The Status in JSON is: "+SceanrioStatus);
//			System.out.println("JSON Size : "+arr.size());
			
			
//		ObjectMapper objectMapper = new ObjectMapper();
//        File bookJsonfile = new File(System.getProperty("user.dir") + "\\target\\Cucumber-Report\\CCreportjson.json");
//        Book book =  objectMapper.readValue(bookJsonfile, Book.class);

       // File booksJsonfile = new File(System.getProperty("user.dir") + "\\target\\Cucumber-Report\\CCreportjson.json");

        //List<Book> books = objectMapper.readValue(bookJsonfile, new TypeReference<List<Book>>() {});
        //System.out.println(books);
        //for(Book book1: books){
            //System.out.println(book1.getTitle());
			
			
			//}
		
	}
}
