package com.BioBook.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
	@FindBy(name="firstname")
	private WebElement firstnametxt;
	
	@FindBy(name="lastname")
	private WebElement lastnametxt;
	
	@FindBy(name="username")
	private WebElement usernametxt;
	
	@FindBy(name="username2")
	private WebElement username2txt;
	
	@FindBy(name="day")
	private WebElement daydd;
	
	@FindBy (name="month")
	private WebElement monthdd;
	
	@FindBy(name="year")
	private WebElement yeardd;
	
	@FindBy(xpath="//input[@value='male']")
	private WebElement malebtn;
	
	@FindBy (xpath="//input[@value='female']")
	private WebElement femalebtn;
	
	
	//initialization
	public  SignupPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}


	public WebElement getFirstnametxt() {
		return firstnametxt;
	}


	public WebElement getLastnametxt() {
		return lastnametxt;
	}


	public WebElement getUsernametxt() {
		return usernametxt;
	}


	public WebElement getUsername2txt() {
		return username2txt;
	}


	public WebElement getDaydd() {
		return daydd;
	}


	public WebElement getMonthdd() {
		return monthdd;
	}


	public WebElement getYeardd() {
		return yeardd;
	}


	public WebElement getMalebtn() {
		return malebtn;
	}
	

	public WebElement getFemalebtn() {
		return femalebtn;
	}
	
	
	
	


}
