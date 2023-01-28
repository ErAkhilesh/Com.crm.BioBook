package com.BioBook.Pom;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
	@FindBy(xpath = "//button[.='Edit Profile']")
	private WebElement editprofilebtn;

	@FindBy(name="firstname")
	private WebElement firstnametxt;

	@FindBy(name="lastname")
	private WebElement lastnametxt;

	@FindBy(name="username")
	private WebElement usernametxt;

	@FindBy(xpath = "//input[@name='birthday']")
	private WebElement birthdaytxt;

	@FindBy(xpath="//select[@name='gender']/child::option[2]")
	private WebElement gendertxt;

	@FindBy(name="number")
	private WebElement numbertxt;

	@FindBy(name="save")
	private WebElement savebtn;

	@FindBy(xpath = "//button[.='Update Picture']")
	private WebElement picturebtm;

	@FindBy(xpath = "(//input[@name='image'])[1]")
	private WebElement choosephotobtn;

	@FindBy(xpath ="//input[@value='save']")
	private WebElement photosavebtn;

	//
	public ProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//

	public WebElement getEditprofilebtn() {
		return editprofilebtn;
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

	public WebElement getBirthdaytxt() {
		return birthdaytxt;
	}

	public WebElement getGendertxt() {
		return gendertxt;
	}

	public WebElement getNumbertxt() {
		return numbertxt;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getPicturebtm() {
		return picturebtm;
	}

	public WebElement getChoosephotobtn() {
		return choosephotobtn;
	}

	public WebElement getPhotosavebtn() {
		return photosavebtn;
	}
	//
	public void editProfile(ArrayList<String> al)
	{

		firstnametxt.clear();
		firstnametxt.sendKeys(al.get(0));
		lastnametxt.clear();
		lastnametxt.sendKeys(al.get(1));
		usernametxt.clear();
		usernametxt.sendKeys(al.get(2));
		birthdaytxt.sendKeys(al.get(3));
		gendertxt.click();
		numbertxt.clear();
		numbertxt.sendKeys(al.get(4));	
	}
	public void uploadPictuer(String image)
	{
		
		picturebtm.click();
		choosephotobtn.sendKeys(image);
		photosavebtn.click();

	}


}
