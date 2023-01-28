package userModule;

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


public class WriteAndDeleteCommentWithGenericTest {

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
		String comment2 = fLib.readDataFromPropertyFile("comment2");
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
		wbLib.maximizeWindow(driver);
		//Login as user
		driver.findElement(By.name("email")).sendKeys(Email);
		driver.findElement(By.name("password")).sendKeys(Password);
		 driver.findElement(By.name("submit")).click();
		// goto profile module
		driver.findElement(By.xpath("//label[text()='Profile']")).click();
		//click on update profile
		driver.findElement(By.xpath("//button[text()='Update Picture']")).click();
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(ImagePath1);
		driver.findElement(By.xpath("(//input[@name='image'])[2]")).click();
		driver.findElement(By.xpath("//button[.='Log out']/ancestor::*/li[8]/a")).click();
		String comment = comment2+random;
		driver.findElement(By.name("content_comment")).sendKeys(comment);
		driver.findElement(By.className("btn-comment")).click();
		WebElement ele = driver.findElement(By.xpath("//body[1]/div[2]/div[5]/div[3]/div[1]/a[1]/button[1]"));
		for(;;)
		{
			try {
				wbLib.waitForPageLoad(driver);
				break;
			}
			catch(Exception e)
			{
				wbLib.scrollBarAction(driver);
			}
		}
		System.out.println("Deleted the comment successfully");
		driver.findElement(By.xpath("//label[text()='Home']")).click();
		driver.findElement(By.xpath("//button[text()='Log out']")).click();
	}

}
