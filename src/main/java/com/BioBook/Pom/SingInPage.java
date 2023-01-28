package com.BioBook.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingInPage {
	@FindBy(name="email")
	private WebElement emailtxt;
	@FindBy(name="password")
	private WebElement passwordtxt;
	@FindBy(name="submit")
	private WebElement loginbtn;
	@FindBy(name="cancel")
	private WebElement canclebtn;  
	public SingInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	public WebElement getEmailtxt() {
		return emailtxt;
	}
	public WebElement getPasswordtxt() {
		return passwordtxt;
	}
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	public WebElement getCanclebtn() {
		return canclebtn;
	}
	//Business lib
	public void setlog(String email,String password)
	{
		emailtxt.sendKeys(email);
		passwordtxt.sendKeys(password);
		loginbtn.click();
		//canclebtn.click();
		
	}
	

}
