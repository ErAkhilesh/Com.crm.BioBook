package profileModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericLiberary.DataBaseUtility;
import GenericLiberary.ExcelUtility;
import GenericLiberary.FileUtility;
import GenericLiberary.JavaUtility;
import GenericLiberary.WebDriverUtility;



public class EditUserNameWithGenericTest {
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
		String ExcelPath = fLib.readDataFromPropertyFile("ExcelPath");
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
		driver.findElement(By.name("email")).sendKeys(Email);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.name("submit")).click();
		//Click on profile page and  Edit  personal info 
		driver.findElement(By.xpath("//label[.='Profile']")).click();
		driver.findElement(By.xpath("//button[.='Edit Profile']")).click();
		String user="Amrita";
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(user);
		wbLib.scrollBarAction(driver);
		driver.findElement(By.xpath("//button[@name='save']")).click();
		driver.findElement(By.xpath("//button[text()='Log out']/ancestor::*/li[8]/a")).click();
		WebElement ele = driver.findElement(By.xpath("//button[text()='Log out']/ancestor::*/li[8]/a"));
		if (ele.isDisplayed()) {
			System.out.println("the same data "+user+" displayed in user page");
		}else {
			System.out.println("the same data "+user+" not displayed in user page");
		}
		//Click on home page,
		driver.findElement(By.xpath("//label[.='Home']")).click();
		//Click on logout
		driver.findElement(By.xpath("//button[.='Log out']")).click();


	}
}