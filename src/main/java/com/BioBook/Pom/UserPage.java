package com.BioBook.Pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {
	@FindBy(name="content")
	private WebElement statusTxtfiled;

	@FindBy(xpath = "(//input[@name='image'])[1]")
	private WebElement choosefile;

	@FindBy(xpath ="//button[.='Share']")
	private WebElement sharebtn;

	@FindBy(xpath="((//a[@title='Delete your post']/button)[1]")
	private WebElement deleteStatus;

	@FindBy(name = "content_comment")
	private WebElement writeComment;
	@FindBy(xpath = "(//input[@value='Enter'])[1]")
	private WebElement entercomment;

	@FindBy(xpath = "//a[@title='Delete your comment']/button")
	private List<WebElement> deleteComment;

	public UserPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getStatusTxtfiled() {
		return statusTxtfiled;
	}

	public WebElement getChoosefile() {
		return choosefile;
	}

	public WebElement getSharebtn() {
		return sharebtn;
	}

	public WebElement getDeleteStatus() {
		return deleteStatus;
	}

	public WebElement getWriteComment() {
		return writeComment;
	}
	public WebElement entercomment() {
		return entercomment;
	}


	public List<WebElement> getDeleteComment() {
		return deleteComment;
	}

	public void shareStatus(String text,String  image) {
		statusTxtfiled.sendKeys(text);
		choosefile.sendKeys(image);
		sharebtn.click();

	}
	public void comment(String comment){

		writeComment.sendKeys(comment);	
		entercomment.click();
	}
	public  void deleteComment()
	{
		List<WebElement> dc=deleteComment;
		dc.get(1).click();
	}
}
