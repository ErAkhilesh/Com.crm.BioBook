package homeModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericLiberary.ExcelUtility;
import GenericLiberary.FileUtility;
import GenericLiberary.JavaUtility;
import GenericLiberary.WebDriverUtility;



public class ShareStatusWithGenericTest {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wbLib=new WebDriverUtility();
		//DataBaseUtility dbLib=new DataBaseUtility();
		JavaUtility jLib=new JavaUtility();
		int random = jLib.getRandomNo();
		//getting data from property file
		String Browser = fLib.readDataFromPropertyFile("browser");
		String Url = fLib.readDataFromPropertyFile("url");
		String Email = fLib.readDataFromPropertyFile("email");
		String Password = fLib.readDataFromPropertyFile("password");
		String ImagePath3 = fLib.readDataFromPropertyFile("ImagePath3");
		//String ExcelPath = fLib.readDataFromPropertyFile("Excelpath");
		//Open Application
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
		//Login as use
		driver.findElement(By.name("email")).sendKeys(Email);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.name("submit")).click();
		//Click on home page
		driver.findElement(By.xpath("//label[.='Home']")).click();
		//Write the comments
		driver.findElement(By.xpath("//textarea[@name='content']")).sendKeys("Happy Sunday");
		driver.findElement(By.xpath("//input[@name='image']")).sendKeys(ImagePath3);
		driver.findElement(By.xpath("//div[@id='right-nav']/div/form/button")).click();
		//Click on logout
		driver.findElement(By.xpath("//button[@value='Log out']")).click();	
	}

}
