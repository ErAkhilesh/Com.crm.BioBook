package GenericLiberary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.BioBook.Pom.HomePage;
import com.BioBook.Pom.SingInPage;
import com.BioBook.Pom.WlcomePage;
import com.aventstack.extentreports.Status;
public class BaseClass {
	public WebDriver driver=null;
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public DataBaseUtility dbLib =new DataBaseUtility();
	public WebDriverUtility wbLib=new WebDriverUtility();
	public JavaUtility jLib= new JavaUtility();
	public int random = jLib.getRandomNo();
	public static WebDriver sdriver;
	@BeforeSuite
	public void connectDB() throws Throwable {
		dbLib.connectToDB();
		System.out.println("connect Data base");
	}
	
	
	@BeforeTest(groups= {"smoke,regrssion"})
	public void beforeTest()
	{
		System.out.println("parellel Execution start");
	}
	
	//@Parameters("Browser")
	
	
	@BeforeClass(groups={"regression","smoke"})
	 public void OpenBrowser() throws Throwable {
		ChromeOptions option=  new ChromeOptions();
		
		driver=wbLib.browser("chrome");
		sdriver=driver;
		ListenerImplimentationClass.test.log(Status.INFO,"----Chrome Browser is open succesfully---");
		System.out.println("Browser is open");
		wbLib.maximizeWindow(driver);
		
		
	}
	@BeforeMethod(groups={"regression","smoke"})
	public void loginToApp() throws Throwable {
		
		String Url = fLib.readDataFromPropertyFile("url");
		
		String Email=fLib.readDataFromPropertyFile("email");
		String Password = fLib.readDataFromPropertyFile("password");
		driver.get(Url);
		wbLib.waitForPageLoad(driver);
		
		WlcomePage  wp=new WlcomePage(driver);
		wp.getSignbtn().click();
		
		SingInPage sp=new SingInPage(driver);
		sp.setlog(Email, Password);
		ListenerImplimentationClass.test.log(Status.INFO,"----Login to BioBook Sucessfully---");
		System.out.println("-----Login to biobook-----");
	}
	@AfterMethod(groups={"regression","smoke"})
	public void logOutTo_App() {
		HomePage hp=new HomePage(driver);
		hp.getLogoutbtn();
		System.out.println("Logout Successfully");
		ListenerImplimentationClass.test.log(Status.INFO,"Logout From BioBool successfully");
		
	}
	//@Parameters(Browser)
	@AfterClass(groups={"regression","smoke"})
	public void closeBrowser()
	{
		driver.quit();
		//System.out.println("----"+Browser+"Browser was closed successfully----");
		ListenerImplimentationClass.test.log(Status.INFO,"----Chrome Browser is close succesfully---");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("parellel Execution close");
	}
	
	@AfterSuite
	public void disconnectDB() throws Throwable
	
	{
	dbLib.closeDataBase();
	System.out.println("Close Database");
	}
	

}
