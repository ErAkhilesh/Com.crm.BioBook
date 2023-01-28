package homeModule;

import org.openqa.selenium.WebDriver;

import com.BioBook.Pom.HomePage;
import com.BioBook.Pom.ProfilePage;
import com.BioBook.Pom.SingInPage;
import com.BioBook.Pom.UserPage;
import com.BioBook.Pom.WlcomePage;

import GenericLiberary.FileUtility;
import GenericLiberary.JavaUtility;
import GenericLiberary.WebDriverUtility;

public class ShareStatusWithPomTest {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		WebDriverUtility wdLib=new WebDriverUtility();
		JavaUtility jLib=new JavaUtility();
		
		int random=jLib.getRandomNo();
		String Url = fLib.readDataFromPropertyFile("url");
		String Email = fLib.readDataFromPropertyFile("email");
		String Password = fLib.readDataFromPropertyFile("password");
		String Image= fLib.readDataFromPropertyFile("ImagePath1");
		String Comment=fLib.readDataFromPropertyFile("comment");
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
		pp.uploadPictuer(Image);
		
		hp.getUserpage().click();
		 
		UserPage up=new UserPage(driver);
		up.comment(Comment);
		
		up.deleteComment();
		hp.getLogoutbtn();
		

		
	}

}
