package com.qa.quickstart.codemon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.quickstart.codemon.Pages.Home;
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
	    report = new ExtentReports("/home/tibor/eclipse-workspace/first_usecase_report.html", true);
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

	@When("^I click on the Games webpage I go to that webpage$")
	public void i_click_on_the_Games_webpage_I_go_to_that_webpage() {
	    Home logotest = PageFactory.initElements(driver, Home.class);
	    logotest.clickGame();
	    
	    ExtentTest test = report.startTest("Game Webpage");
	    test.log(LogStatus.INFO, "Navigating to Game webpage.");
	    
	    test.log(LogStatus.PASS, "Successfully navigated to Game webpage.");
	    report.endTest(test);
	    report.flush();
	    
//	    try {
//	    	assertEquals(url, driver.getCurrentUrl());
//	    	test.log(LogStatus.PASS, "Loaded website succesfully.");
//	    } catch (AssertionError e) {
//	    	test.log(LogStatus.FAIL, "It failed");
//	    	fail();
//	    	
//	    } finally {
//	    	report.endTest(test);
//	    	report.flush();
//	    }
	}

	@Then("^I click the logo and it goes back to the homepage$")
	public void i_click_the_logo_and_it_goes_back_to_the_homepage() throws InterruptedException {
		Thread.sleep(1000);
		Home logotest = PageFactory.initElements(driver, Home.class);
		logotest.clickLogo();
		
	    ExtentTest test = report.startTest("Back to home page");
	    test.log(LogStatus.INFO, "Using logo button.");
	    
	    test.log(LogStatus.PASS, "Logo successfully navigated back to the home page.");
	    report.endTest(test);
	    report.flush();	
	}
	@After
	public void tearDown() throws InterruptedException  {
		Thread.sleep(1000);
		driver.quit();
	}
}
