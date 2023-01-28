package profileModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericLiberary.DataBaseUtility;
import GenericLiberary.ExcelUtility;
import GenericLiberary.FileUtility;
import GenericLiberary.JavaUtility;
import GenericLiberary.WebDriverUtility;



public class EditProfileAndUpdateProfilePhotoWithGenericTest {
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
		String Password = fLib.readDataFromPropertyFile("password");
		String ImagePath1=fLib.readDataFromPropertyFile("ImagePath1");
		String ImagePath2 = fLib.readDataFromPropertyFile("ImagePath2");
		//open Application
		WebDriver driver = new ChromeDriver();
//		if(Browser.equals("chrome"))
//		{
//			driver = new ChromeDriver();
//		}else if(Browser.equals("firefox"))
//		{
//			driver = new FirefoxDriver();
//		}
//		else {
//			System.out.println("There is no browser");
//		}
		wbLib.waitForPageLoad(driver);
		wbLib.maximizeWindow(driver);
		driver.get(Url);
		wbLib.waitForPageLoad(driver);
		driver.findElement(By.name("email")).sendKeys(Email);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//label[text()='Profile']")).click();
		//editing Profile
		driver.findElement(By.xpath("//Button[text()='Edit Profile']")).click();
		//Read data from excel file

		WebElement genderlist = driver.findElement(By.xpath("//select[@name='gender']"));
		wbLib.select("Male",genderlist);
		wbLib.scrollBarAction(driver);
		eLib.list(driver, "Sheet2");
		driver.findElement(By.xpath("//button[@name='save']")).click();
		//driver.findElement(By.xpath("//a[@title='Settings']"));
		driver.findElement(By.xpath("//button[.='Update Picture']")).click();
		driver.findElement(By.xpath("//input[@name='image']")).sendKeys(ImagePath1);
		driver.findElement(By.xpath("//input[@value='save']")).click();
		driver.findElement(By.xpath("//label[.='Photos']")).click();
		driver.findElement(By.xpath("//input[@name='image']")).sendKeys(ImagePath2);
		driver.findElement(By.xpath("//button[.='Add Photos']")).click();
		
		driver.findElement(By.xpath("//button[@class='btn-sign-in']")).click();
	}

}
