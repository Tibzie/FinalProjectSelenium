package com.qa.quickstart.testinggame.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Game {
	
	@FindBy(xpath="//*[@id=\"navbarNav\"]/ul/li[1]/a")
	private WebElement gameLink;
	
	@FindBy(className="gameContainer")
	private WebElement container;

	
	@FindBy(className="buttonWEST")
	private WebElement leftArrow;
	
	@FindBy(className="buttonEAST")
	private WebElement rightArrow;
	
	@FindBy(className="buttonNORTH")
	private WebElement upArrow;
	
	@FindBy(className="buttonSOUTH")
	private WebElement downArrow;
	
	
	/* METHODS */
	
	public void clickGame() {
		gameLink.click();
	}
	
	
	/* need to click this container */
	public void clickContainer() {
		container.click();
	}
	
	
	/* Movements */
	public void clickLeft() {
		leftArrow.click();
	}
	
	public void clickRight() {
		rightArrow.click();
	}
	
	public void clickUp() {
		upArrow.click();
	}
	
	public void clickDown() {
		downArrow.click();
	}
}
