package com.BioBook.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WlcomePage {
	//declaration
	@FindBy(xpath = "//button[.='Sign in']")
	private WebElement signbtn;

	@FindBy(xpath = "//button[.=Sign up")
	private WebElement Signupbtn;



	//initialization
	public WlcomePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization



	public WebElement getSignbtn() {
		return signbtn;
	}



	public WebElement getSignupbtn() {
		return Signupbtn;
	}


}
