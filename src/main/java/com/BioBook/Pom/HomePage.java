package com.BioBook.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath="//button[.='Log out']/ancestor::*/li[8]")
	private WebElement userpage;
	
	@FindBy(xpath="//button[.='Log out']/ancestor::*/li[9]")
	private WebElement homepage;
	
	@FindBy(xpath = "//button[.='Log out']/ancestor::*/li[10]")
	private WebElement profilepage;
	
	@FindBy(xpath = "//button[.='Log out']/ancestor::*/li[11]")
	private WebElement photopage;
	
	@FindBy(xpath = "//button[.='Log out']")
	private WebElement logoutbtn;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserpage() {
		return userpage;
	}

	public WebElement getHomepage() {
		return homepage;
	}

	public WebElement getProfilepage() {
		return profilepage;
	}

	public WebElement getPhotopage() {
		return photopage;
	}

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
	
	

}
