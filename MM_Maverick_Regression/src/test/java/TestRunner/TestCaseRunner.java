package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
//@CucumberOptions(features={"src\\test\\resources\\Feature\\movement.feature","src\\test\\resources\\Feature\\lo_movement.feature"},glue= {"StepDefinition"},
@CucumberOptions(features = { "src\\test\\resources\\Feature\\movement.feature",
		"src\\\\test\\\\resources\\\\Feature\\lo_movement.feature",
		"src\\test\\resources\\Feature\\movement military.feature",
		"src\\test\\resources\\Feature\\blog movement.feature","src\\test\\resources\\Feature\\Redirection Verification.feature"}, glue = {
				"StepDefinition" }, monochrome = true, tags = "@MMRegression", dryRun = false, plugin = { "pretty",
						"html:target/Cucumber-Report/CCreport.html", "json:target/Cucumber-Report/CCreportjson.json",
						"junit:target/Cucumber-Report/CCreportxml.xml" })
public class TestCaseRunner {

}
