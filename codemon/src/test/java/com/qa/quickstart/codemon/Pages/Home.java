package com.qa.quickstart.codemon.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {
	@FindBy(xpath="//*[@id=\"navbarNav\"]/ul/li[1]/a")
	private WebElement gameLink;
	
	@FindBy(id="logo-navbar")
	private WebElement logoLink;
	
	public void clickGame() {
		gameLink.click();
	}
	public void clickLogo() {
		logoLink.click();
	}
	
}
