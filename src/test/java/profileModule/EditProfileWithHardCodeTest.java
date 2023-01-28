package profileModule;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
public class EditProfileWithHardCodeTest{
	public static void main(String[] args) throws Throwable {
		Random ran = new Random();
		int random = ran.nextInt(500);
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream("./src/test/resources/CommanData.Prooerties");
		p.load(fis);
		String url = p.getProperty("url");
		String email = p.getProperty("email");
		String PASSWORD = p.getProperty("password");
		String Excelpath = p.getProperty("Excelpath");
		//Open Application
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		//Login as user
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("submit")).click();
		//Click on profile page and  Edit  personal info 
		driver.findElement(By.xpath("//label[.='Profile']")).click();
		driver.findElement(By.xpath("//button[.='Edit Profile']")).click();
		ArrayList<String> al = new ArrayList<String>();
		al.add("firstname");
		al.add("lastname");
		al.add("username");
		al.add("number");
		FileInputStream fi = new FileInputStream(Excelpath);
		Workbook book = WorkbookFactory.create(fi);
		Sheet sh = book.getSheet("Sheet2");
		for (int i = 0; i < al.size(); i++) {
			String value = sh.getRow(i).getCell(1).toString()+random;
			driver.findElement(By.name(al.get(i))).clear();
			driver.findElement(By.name(al.get(i))).sendKeys(value);
			Thread.sleep(2000);
		}
		WebElement genderlist = driver.findElement(By.xpath("//select[@name='gender']"));
		Select s=new Select(genderlist);
		s.selectByVisibleText("Male");
		//Scroll page
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(200,100)");
		//Click on save 
		driver.findElement(By.xpath("//button[@name='save']")).click();
		//Click on user page
		driver.findElement(By.xpath("//button[text()='Log out']/ancestor::*/li[8]/a")).click();
		//to verify the same data should be display in user page 
		String username = sh.getRow(2).getCell(1).toString()+random;
		WebElement ele = driver.findElement(By.xpath("//b[.='("+username+")']"));
		if (ele.isDisplayed()) {
			System.out.println("the same data "+username+" displayed in user page");
		}else {
			System.out.println("the same data "+username+" not displayed in user page");
		}
		//Click on home page,
		driver.findElement(By.xpath("//label[.='Home']")).click();
		//Click on logout
		driver.findElement(By.xpath("//button[.='Log out']")).click();
	}
}
