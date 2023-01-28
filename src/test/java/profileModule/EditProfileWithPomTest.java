package profileModule;

import org.openqa.selenium.WebDriver;

import com.BioBook.Pom.HomeModulePage;
import com.BioBook.Pom.HomePage;
import com.BioBook.Pom.PhotoPage;
import com.BioBook.Pom.SingInPage;
import com.BioBook.Pom.WlcomePage;

import GenericLiberary.ExcelUtility;
import GenericLiberary.FileUtility;
import GenericLiberary.JavaUtility;
import GenericLiberary.WebDriverUtility;



public class EditProfileWithPomTest {
	public static  void main(String ar[]) throws Throwable
	{
		WebDriverUtility wbLib=new WebDriverUtility();
		FileUtility fuLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		int random = jLib.getRandomNo();

		String Url = fuLib.readDataFromPropertyFile("url");
		String Emial = fuLib.readDataFromPropertyFile("email");
		String Password = fuLib.readDataFromPropertyFile("password");
		String Image=fuLib.readDataFromPropertyFile("ImagePath1");
		String Status=fuLib.readDataFromPropertyFile("status");
		String Comment=fuLib.readDataFromPropertyFile("Comment3")+random;

		WebDriver driver = wbLib.browser("Chrome");
		driver.get(Url);

		wbLib.maximizeWindow(driver);
		wbLib.waitForPageLoad(driver);

		//Login as user
		WlcomePage wp=new WlcomePage(driver);
		wp.getSignbtn().click();

		SingInPage sp=new SingInPage(driver);
		sp.setlog(Emial, Password);
		//Click on profile photo, take photo from external Resources, Able to click on add button,
		HomePage hp=new HomePage(driver);
		hp.getPhotopage().click();
		PhotoPage php=new PhotoPage(driver);
		php.addPhoto(Image);

		hp.getProfilepage().click();

		hp.getHomepage().click();

		HomeModulePage hmp=new HomeModulePage(driver);
		hmp.shareStatus(Status, Image);

		hmp.comment(Comment);
		Thread.sleep(5000);
		//wbLib.scrollBarAction(driver);		
		//hmp.deleteAllComment(driver);
		hmp.deleteComment();
		System.out.println("Deleted comment sucessfully");
		hp.getLogoutbtn().click();
	}
}
