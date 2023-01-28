package profileModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.BioBook.Pom.HomePage;
import com.BioBook.Pom.ProfilePage;
import com.BioBook.Pom.SingInPage;
import com.BioBook.Pom.WlcomePage;

import GenericLiberary.FileUtility;
import GenericLiberary.JavaUtility;
import GenericLiberary.WebDriverUtility;

public class EditProfileAndUpdateProfilePhotoWithPomTeat {
	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		WebDriverUtility wdLib=new WebDriverUtility();
		JavaUtility jLib=new JavaUtility();

		WebDriver driver=new ChromeDriver();
		wdLib.waitForPageLoad(driver);
		wdLib.maximizeWindow(driver);
		int random = jLib.getRandomNo();

		String url= fLib.readDataFromPropertyFile("url");
		String Email=fLib.readDataFromPropertyFile("email");
		String Password=fLib.readDataFromPropertyFile("password");
		String User=fLib.readDataFromPropertyFile("user")+random;
		driver.get(url);
		WlcomePage wp= new WlcomePage(driver);
		wp.getSignbtn().click();
		SingInPage sp=new SingInPage(driver);
		sp.setlog(Email, Password);

		HomePage hp=new HomePage(driver);
		hp.getProfilepage().click();

		ProfilePage pp=new ProfilePage(driver);
		pp.getEditprofilebtn().click();

		pp.getUsernametxt().clear();
		pp.getUsernametxt().sendKeys(User);
		
		wdLib.scrollBarAction(driver);
		pp.getSavebtn().click();
		
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
		 hp.getLogoutbtn().click();
		
	}
}
