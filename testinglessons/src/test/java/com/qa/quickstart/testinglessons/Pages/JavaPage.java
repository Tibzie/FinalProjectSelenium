package com.qa.quickstart.testinglessons.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaPage {

	@FindBy(xpath="//*[@id=\"accordion\"]/div[1]/div[1]/h4/a")
	private WebElement lessonLink;
	
	public void clickJavaTab() {
		lessonLink.click();
	}
	
}