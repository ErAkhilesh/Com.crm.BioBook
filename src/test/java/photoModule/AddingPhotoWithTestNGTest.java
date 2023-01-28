package photoModule;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.BioBook.Pom.HomePage;
import com.BioBook.Pom.ProfilePage;

import GenericLiberary.BaseClass;



public class AddingPhotoWithTestNGTest extends BaseClass{
	@Test
	public void addingPhoto() throws Throwable
	{
		
		HomePage hp = new HomePage(driver);
		hp.getProfilepage().click();
		
		ProfilePage pp=new ProfilePage(driver);
		pp.getEditprofilebtn().click();
		
		ArrayList<String> all = eLib.arraylist(driver, "Sheet2");
		pp.editProfile(all);
		wbLib.scrollBarAction(driver);
		pp.getSavebtn().click();
		hp.getUserpage().click();
		String username=eLib.readDataFromExcel("Sheet2",2,1)+random;
		WebElement user = hp.getUserpage();
		if (user.isDisplayed()) {
			System.out.println("the same data "+username+" displayed in user page");
		}else {
			System.out.println("the same data "+username+" not displayed in user page");
		}
		hp.getHomepage().click();
		System.out.println("By using TetsNg my automation is pass");
		
	}
	
	

}
