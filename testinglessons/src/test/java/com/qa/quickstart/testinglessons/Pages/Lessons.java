package com.qa.quickstart.testinglessons.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Lessons {
	@FindBy(css="#navbarNav > ul > li.nav-item:nth-child(3)")
	private WebElement learnLink;
	

	@FindBy(xpath="//*[@id=\"navbarNav\"]/ul/li[3]/div/a[1]")
	private WebElement lessonLink;
	
	public void clickLesson() {
		learnLink.click();
		lessonLink.click();
	}
	
}
