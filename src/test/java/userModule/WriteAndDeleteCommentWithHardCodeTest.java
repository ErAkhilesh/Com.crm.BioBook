package userModule;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WriteAndDeleteCommentWithHardCodeTest {
	public static void main(String[] args) throws Throwable {
		Random ran=new Random();
		int random= ran.nextInt(500);
		//setp1:Get common data;
		FileInputStream fis=new FileInputStream("./src/test/resources/CommanData.Prooerties");
		Properties p=new Properties();
		p.load(fis);
		String URL=p.getProperty("url");
		String Email=p.getProperty("email");
		String PASSWORD =p.getProperty("password");
		String ExcelPath=p.getProperty("ExcelPath");
		String ImagePath1=p.getProperty("ImagePath1");
		String ImagePath2=p.getProperty("ImagePath2");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.name("email")).sendKeys(Email);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//label[text()='Profile']")).click();

		//Getting data from excel file
		FileInputStream fi=new FileInputStream(ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Sheet2");
		//editing Profile
		driver.findElement(By.xpath("//Button[text()='Edit Profile']")).click();
		//driver.findElement(By.)
		ArrayList<String> al= new ArrayList<String>();
		al.add("firstname");
		al.add("lastname");
		al.add("username");
		al.add("birthday");
		//al.add("gender");
		al.add("number");
		for(int i=0;i<al.size();i++) {
			//  driver.findElement(By.name(al.get(i))).clear();
			String value =sh.getRow(i).getCell(1).getStringCellValue();
			driver.findElement(By.name(al.get(i))).clear();
			driver.findElement(By.name(al.get(i))).sendKeys(value);

		}
		WebElement genderlist = driver.findElement(By.xpath("//select[@name='gender']"));
		Select s=new Select(genderlist);
		s.selectByVisibleText("Male");

		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(200,200)");

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
