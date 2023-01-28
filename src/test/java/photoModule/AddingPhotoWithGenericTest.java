package photoModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericLiberary.DataBaseUtility;
import GenericLiberary.ExcelUtility;
import GenericLiberary.FileUtility;
import GenericLiberary.JavaUtility;
import GenericLiberary.WebDriverUtility;



public class AddingPhotoWithGenericTest {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wbLib=new WebDriverUtility();
		DataBaseUtility dbLib=new DataBaseUtility();
		JavaUtility jLib=new JavaUtility();
		//random
		int random=jLib.getRandomNo();
		//property file
		String Browser = fLib.readDataFromPropertyFile("browser");
		String Url = fLib.readDataFromPropertyFile("url");
		String Email = fLib.readDataFromPropertyFile("email");
		String Passward = fLib.readDataFromPropertyFile("passward"); 
		String ImagePath1=fLib.readDataFromPropertyFile("ImagePath1");
		//open Application
		WebDriver driver = null;
		if(Browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}else if(Browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("There is no browser");
		}
		wbLib.waitForPageLoad(driver);
		wbLib.maximizeWindow(driver);
		driver.get(Url);
		//Login as user
				driver.findElement(By.name("email")).sendKeys(Email);
				driver.findElement(By.name("password")).sendKeys(Passward);
				driver.findElement(By.name("submit")).click();
				//Click on profile photo, take photo from external Resources, Able to click on add button,
				driver.findElement(By.xpath("//label[.='Photos']")).click();
				driver.findElement(By.xpath("(//input[@name='image'])[1]")).sendKeys(ImagePath1);
				driver.findElement(By.xpath("//button[@name='Submit']")).click();
				//Click on profile page
				driver.findElement(By.xpath("//label[.='Profile']")).click();
				//Click on home page,
				driver.findElement(By.xpath("//label[.='Home']")).click();
				//Click on user page
				driver.findElement(By.xpath("//button[.='Log out']/ancestor::*/li[8]/a")).click();
				//Click on logout
				driver.findElement(By.xpath("//button[.='Log out']")).click();
	}

}
  