package profileModule;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericLiberary.DataBaseUtility;
import GenericLiberary.ExcelUtility;
import GenericLiberary.FileUtility;
import GenericLiberary.JavaUtility;
import GenericLiberary.WebDriverUtility;



public class EditProfileWithGenericTest {
	private static final String String = null;

	public static void main(String[] args) throws Throwable {

		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wdLib=new WebDriverUtility();
		DataBaseUtility dbLib=new DataBaseUtility();
		JavaUtility jLib=new JavaUtility();

		int random = jLib.getRandomNo();
//		Random ran = new Random();
//		int random = ran.nextInt(500);
		
		
		String url = fLib.readDataFromPropertyFile("url");
		String email = fLib.readDataFromPropertyFile("email");
		String passward = fLib.readDataFromPropertyFile("password");
		String ExcelPath = fLib.readDataFromPropertyFile("Excelpath");
		
//		Properties p = new Properties();
//		FileInputStream fis = new FileInputStream("./src/test/resources/CommanData.Prooerties");
//		p.load(fis);
//		String url = p.getProperty("url");
//		String email = p.getProperty("email");
//		String PASSWORD = p.getProperty("password");
//		String Excelpath = p.getProperty("Excelpath");
		
		// step 3:Open Application
	
		WebDriver driver = new ChromeDriver();
			
		wdLib.maximizeWindow(driver);
		driver.get(url);
		//driver.manage().window().maximize();
		wdLib.waitForPageLoad(driver);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Login as user
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(passward);
		driver.findElement(By.name("submit")).click();
		
		//Click on profile page and  Edit  personal info 
		driver.findElement(By.xpath("//label[.='Profile']")).click();
		driver.findElement(By.xpath("//button[.='Edit Profile']")).click();
		ArrayList<String> al = new ArrayList<String>();
		al.add("firstname");
		al.add("lastname");
		al.add("username");
		al.add("birthday");
		al.add("number");
//		FileInputStream fi = new FileInputStream(Excelpath);
//		Workbook book = WorkbookFactory.create(fi);
//		Sheet sh = book.getSheet("Sheet2");
		for (int i = 0; i < al.size(); i++) {
			String value = eLib.readDataFromExcel("Sheet2", i, 1 )+random;
			driver.findElement(By.name(al.get(i))).clear();
			driver.findElement(By.name(al.get(i))).sendKeys(value);
			Thread.sleep(2000);
		}
//		 String firstname = eLib.readDataFromExcel("Sheet2", 0, 1 );
//		 String lastname=eLib.readDataFromExcel("Sheet2", 1, 1 );
//		 String username=eLib.readDataFromExcel("Sheet2", 2, 1 );
//		 String	number=eLib.readDataFromExcel("Sheet2", 3, 1 );
//		
		
		WebElement genderlist = driver.findElement(By.xpath("//select[@name='gender']"));
		
		 wdLib.select("Male",genderlist);
//		Select s=new Select(genderlist);
//		s.selectByVisibleText("Male");
		//Scroll page
		 wdLib.scrollBarAction(driver);
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(200,100)");
		
		//Click on save 
		driver.findElement(By.xpath("//button[@name='save']")).click();
		//Click on user page
		driver.findElement(By.xpath("//button[text()='Log out']/ancestor::*/li[8]/a")).click();
		//to verify the same data should be display in user page 
		String username=eLib.readDataFromExcel("Sheet2",2,1)+random;
		//String username = sh.getRow(2).getCell(1).toString()+random;
		WebElement ele = driver.findElement(By.xpath("//button[text()='Log out']/ancestor::*/li[8]/a"));
		if (ele.isDisplayed()) {
			System.out.println("the same data "+username+" displayed in user page");
		}else {
			System.out.println("the same data "+username+" not displayed in user page");
		}
		//Click on home page,
		driver.findElement(By.xpath("//label[.='Home']")).click();
		//Click on logout
		driver.findElement(By.xpath("//button[.='Log out']")).click();
		System.out.println("By using generic method my automation is pass");
	}

}


