package com.BioBook.Pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhotoPage {
	@FindBy(xpath = "//input[@name='image']")
	private WebElement imagebtn;
	@FindBy(xpath = "//button[.='Add Photos']")
	private WebElement savebtn;
	@FindBy(xpath = "//div[@class='photo-select']//a[@class='btn-delete-photos']")
	private List<WebElement> deletebtn;
	//
	public PhotoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getImagebtn() {
		return imagebtn;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	public List<WebElement>getDeletebtn() {
		return  deletebtn;
	}
	//

	public void addPhoto(String image)
	{
		imagebtn.sendKeys(image);
		savebtn.click();

	}
	public void deletPhoto() {
		List<WebElement> del=deletebtn;
		del.get(1);
	}

}
