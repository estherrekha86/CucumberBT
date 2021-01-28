package stepdefinition;

import java.io.IOException;

import com.cucumber.listener.Reporter;

import CommonUtils.TriggerMail;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import managers.WebDriverManager;
import testrunner.TestRunner;

public class Hooks {
	@After
	public void afterScenario(Scenario scenario) throws IOException
	{
		if(scenario.isFailed()) {
			String a = WebDriverManager.captureScreenshot(TestRunner.tagNameOfSce);
			Reporter.addScreenCaptureFromPath(a);
			TriggerMail.listOfFailedTC.add(TestRunner.tagNameOfSce);
			
		} else  {
			TriggerMail.listOfPassedTC.add(TestRunner.tagNameOfSce);
		}
	}

}
