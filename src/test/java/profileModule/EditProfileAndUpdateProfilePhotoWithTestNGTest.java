package profileModule;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.BioBook.Pom.HomePage;
import com.BioBook.Pom.ProfilePage;

import GenericLiberary.BaseClass;


public class EditProfileAndUpdateProfilePhotoWithTestNGTest extends BaseClass {

	@Test(groups="regression")
	public void editProfile() throws Throwable
	{
	
	HomePage hp=new HomePage(driver);
	hp.getProfilepage().click();
	

	ProfilePage pp=new ProfilePage(driver);
	pp.getEditprofilebtn().click();
	String User=fLib.readDataFromPropertyFile("user")+random;

	pp.getUsernametxt().clear();
	pp.getUsernametxt().sendKeys(User);
	
	wbLib.scrollBarAction(driver);
	pp.getSavebtn();
	
	WebElement ele = hp.getUserpage();
	if(ele.isDisplayed())
	{
		System.out.println("The same data "+ele.getText()+" dispalyed in user page");
		
	}
	else
	{
		System.out.println("The same data "+ele.getText()+" not dispalyed in user page");
	}
	hp.getHomepage().click();
	}
}
