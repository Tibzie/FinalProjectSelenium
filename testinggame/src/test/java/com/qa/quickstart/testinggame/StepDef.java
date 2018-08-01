package com.qa.quickstart.testinggame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.quickstart.testinggame.Pages.Game;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
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
	    report = new ExtentReports("/home/tibor/eclipse-workspace/game_report.html", true);
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

	@When("^I click on the Game webpage$") 
	public void i_click_on_the_Game_webpage() throws InterruptedException {
		
		ExtentTest test = report.startTest("Game Webpage");
	    test.log(LogStatus.INFO, "Navigating to Game webpage.");
	    
	    
	    Game gamepage = PageFactory.initElements(driver, Game.class);
	    gamepage.clickGame();
	    Thread.sleep(2000);
	    
	    test.log(LogStatus.PASS, "The game is selected.");
	    report.endTest(test);
	    report.flush();
	}

	@Then("^I click on the left arrow the character will move left$")
	public void i_click_on_the_left_arrow_the_character_will_move_left() {
		
		ExtentTest test = report.startTest("Game Movement - Left (West)");
	    test.log(LogStatus.INFO, "Testing left click.");
		
	    Game gamepage = PageFactory.initElements(driver, Game.class);
	    gamepage.clickLeft();
	    
	    test.log(LogStatus.PASS, "Character successfully moved to the left.");
	    report.endTest(test);
	    report.flush();
	}

	@Then("^I click on the right arrow the character will move right$")
	public void i_click_on_the_right_arrow_the_character_will_move_right() {
		
		ExtentTest test = report.startTest("Game Movement - Right (East)");
	    test.log(LogStatus.INFO, "Testing right click.");
		
	    Game gamepage = PageFactory.initElements(driver, Game.class);
	    gamepage.clickRight();
	    
	    test.log(LogStatus.PASS, "Character successfully moved to the right.");
	    report.endTest(test);
	    report.flush();
	}

	@Then("^I click on the up arrow the character will move up$")
	public void i_click_on_the_up_arrow_the_character_will_move_up() {
		
		ExtentTest test = report.startTest("Game Movement - Up (North)");
	    test.log(LogStatus.INFO, "Testing up click.");
	    
	    Game gamepage = PageFactory.initElements(driver, Game.class);
	    gamepage.clickUp();
	    
	    test.log(LogStatus.PASS, "Character successfully moved up.");
	    report.endTest(test);
	    report.flush();
	}

	@Then("^I click on the down arrow the character will down$")
	public void i_click_on_the_down_arrow_the_character_will_down() {
		
		ExtentTest test = report.startTest("Game Movement - Down (South)");
	    test.log(LogStatus.INFO, "Testing down click.");
	    
	    Game gamepage = PageFactory.initElements(driver, Game.class);
	    gamepage.clickDown();
	    
	    test.log(LogStatus.PASS, "Character successfully moved down.");
	    report.endTest(test);
	    report.flush();	    
	}
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
