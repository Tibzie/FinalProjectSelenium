package com.qa.quickstart.testinglessons;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.quickstart.testinglessons.Pages.JavaPage;
import com.qa.quickstart.testinglessons.Pages.Lessons;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	
	ChromeDriver driver;
	String url="http://localhost:3000/";
	ExtentReports report;
	
	
	@Given("^the website$")
	public void the_website() {
		 System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		 report = new ExtentReports("/home/tibor/eclipse-workspace/accordion_report.html", true);
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(url);
		 
		    
		 ExtentTest test = report.startTest("Loading Website");
		 test.log(LogStatus.INFO, "Opened the website");
		    
		 try {
			assertEquals(url, driver.getCurrentUrl());
		    test.log(LogStatus.PASS, "Loaded website succesfully. Current URL is: "+ driver.getCurrentUrl());
		 } catch (AssertionError e) {
		    test.log(LogStatus.FAIL, "It failed");
		    fail();
		    	
		 } finally {
			report.endTest(test);
		    report.flush();
		 }		 
	}

	@When("^I am on the Lessons page$")
	public void i_am_on_the_Lessons_page() {
		
		ExtentTest test = report.startTest("Opening Lesson Webpage");
	    test.log(LogStatus.INFO, "Navigating to Lesson webpage.");
	    
		Lessons lessonclick = PageFactory.initElements(driver, Lessons.class);
	    lessonclick.clickLesson();
	    
	    test.log(LogStatus.PASS, "Page is selected.");
	    report.endTest(test);
	    report.flush();
	}

	@Then("^I click on the Java tab$")
	public void i_click_on_the_Java_tab() {
		
		ExtentTest test = report.startTest("Accordion test");
	    test.log(LogStatus.INFO, "Testing Java tab.");
	    
	    JavaPage javaclick = PageFactory.initElements(driver, JavaPage.class);
	    javaclick.clickJavaTab();
	    
	    test.log(LogStatus.PASS, "Java tab has been successfully selected.");
	    report.endTest(test);
	    report.flush();
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
