package homeModule;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class ShareStatusWithhardCodeTest {
	public static void main(String[]args) throws Throwable{
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream("./src/test/resources/CommanData.Prooerties");
		p.load(fis);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("email");
		String PASSWORD = p.getProperty("password");
		String  ImagePath3= p.getProperty("ImagePath3");
		//Open Application
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		//Login as user
		driver.findElement(By.name("email")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("submit")).click();
		//Click on home page,
		driver.findElement(By.xpath("//label[.='Home']")).click();
		//Write the comments,
		driver.findElement(By.xpath("//textarea[@name='content']")).sendKeys("Happy Sunday");
		driver.findElement(By.xpath("//input[@name='image']")).sendKeys(ImagePath3);
		driver.findElement(By.xpath("//div[@id='right-nav']/div/form/button")).click();
		//Click on logout
		driver.findElement(By.xpath("//button[@value='Log out']")).click();		
	}
}

