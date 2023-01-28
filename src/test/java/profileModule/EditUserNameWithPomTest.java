package profileModule;

import org.openqa.selenium.WebDriver;

import com.BioBook.Pom.HomePage;
import com.BioBook.Pom.PhotoPage;
import com.BioBook.Pom.ProfilePage;
import com.BioBook.Pom.SingInPage;
import com.BioBook.Pom.WlcomePage;

import GenericLiberary.FileUtility;
import GenericLiberary.JavaUtility;
import GenericLiberary.WebDriverUtility;



public class EditUserNameWithPomTest {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		WebDriverUtility wdLib=new WebDriverUtility();
		JavaUtility jLib=new JavaUtility();
		
		int random=jLib.getRandomNo();
		String Url = fLib.readDataFromPropertyFile("url");
		String Email = fLib.readDataFromPropertyFile("email");
		String Password = fLib.readDataFromPropertyFile("password");
		String ImagePath1=fLib.readDataFromPropertyFile("ImagePath1");
		String ImagePath2 = fLib.readDataFromPropertyFile("ImagePath2");
		
		WebDriver driver = wdLib.browser("Chrome");
		driver.get(Url);
		wdLib.maximizeWindow(driver);

		
		WlcomePage  wp=new WlcomePage(driver);
		wp.getSignbtn().click();
		SingInPage sp=new SingInPage(driver);
				sp.setlog(Email, Password);
		
		HomePage hp=new HomePage(driver);
		hp.getProfilepage().click();
		
		ProfilePage pp=new ProfilePage(driver);
		pp.getEditprofilebtn().click();

		pp.uploadPictuer(ImagePath1);
		wdLib.scrollBarAction(driver);
		
		PhotoPage php=new PhotoPage(driver);
		php.addPhoto(ImagePath2);
		
		hp.getLogoutbtn().click();
		
	}

}
